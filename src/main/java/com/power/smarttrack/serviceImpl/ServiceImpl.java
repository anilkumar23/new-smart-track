package com.power.smarttrack.serviceImpl;

import com.power.smarttrack.model.*;
import com.power.smarttrack.repository.DeviceRepository;
import com.power.smarttrack.repository.SmartTrackRepository;
import com.power.smarttrack.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    private SmartTrackRepository smartTrackRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public boolean insertData(List<TTDPowerSupply> ttdPowerSupplies) {
        ttdPowerSupplies.parallelStream().forEach(ttdPowerSupply ->
                ttdPowerSupply.setSubStation(ttdPowerSupply.getDeviceName().substring(0,ttdPowerSupply.getDeviceName().indexOf("0"))));
        smartTrackRepository.saveAll(ttdPowerSupplies);
        return true;
    }

    @SuppressWarnings("unused")
    @Override
    public DeviceVariables getVoltageData(SmartTrackRequest smartTrackRequest) {
        List<TTDPowerSupply> getTtdPowerSupplyList = new ArrayList<>();
        DeviceVariables deviceVariables = new DeviceVariables();
        Map<String, String[]> map = new HashMap<>();
        int count = 1;
        int c = 0;
        List<TTDPowerSupply> ttdPowerSupplies = smartTrackRepository.findByTStampContainsAndDeviceNameContaining(smartTrackRequest.getTimestamp(),
                smartTrackRequest.getDeviceName());
        for (TTDPowerSupply ttdPowerSupply : ttdPowerSupplies) {
            if (ttdPowerSupply.getDeviceName().contains(smartTrackRequest.getDeviceName())) {
                Gson gson = new Gson();
                ttdPowerSupply.setPower(ttdPowerSupply.getPower().replaceAll("'", ""));
                ttdPowerSupply.setEnergy(ttdPowerSupply.getEnergy().replaceAll("'", ""));
                JsonParser jsonParser = new JsonParser();
                JsonObject objectFromString = jsonParser.parse(ttdPowerSupply.toString()).getAsJsonObject();
                ttdPowerSupply = gson.fromJson(objectFromString, TTDPowerSupply.class);
                getTtdPowerSupplyList.add(ttdPowerSupply);
                if (ttdPowerSupply.getPower() != null && ttdPowerSupply.getPower().contains("rphvol")) {
                    String[] s = ttdPowerSupply.getPower().split(",");
                    String rPhVol = s[1].replaceAll("rphvol:", "").replace("V", "").trim();
                    String rphcu = s[4].replaceAll("rphcu:", "").replace("V", "").trim();
                    String rphpf = s[13].replaceAll("rphpf:", "").replace("V", "").trim();
                    if (count == 1) {
                        map.put(ttdPowerSupply.getDeviceId(), new String[]{rPhVol, rphcu, rphpf});
                        count = 0;
                    } else {
                        if (map.containsKey(ttdPowerSupply.getDeviceId())) {
                            String s3[] = map.get(ttdPowerSupply.getDeviceId());
                            map.put(ttdPowerSupply.getDeviceId(), new String[]{s3[0].concat(", " + rPhVol), s3[1].concat(", " + rphcu),
                                    s3[2].concat(", " + rphpf)});
                        } else if (c == 0) {
                            map.put(ttdPowerSupply.getDeviceId(), new String[]{rPhVol, rphcu, rphpf});
                            c++;
                        } else {
                            String newVol = rPhVol;
                            map.put(ttdPowerSupply.getDeviceId(), new String[]{rPhVol, rphcu, rphpf});
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, String[]> s1 : map.entrySet()) {
            String s4[] = s1.getValue();
            Set<Double> set = new HashSet<>();
            List<Double> currSet = new ArrayList<>();
            List<Double> pfSet = new ArrayList<>();
            for (int i = 0; i < s4.length; i++) {
                String s5[] = s4[i].split(",");
                for (String s6 : s5) {
                    int setFinalCount = set.size();
                    int currFinalCount = currSet.size();
                    int pfFinalSet = pfSet.size();
                    if (setFinalCount <= 23 && i == 0) {
                        set.add(Double.parseDouble(s6.trim()));
                        if (setFinalCount == 23) break;
                    } else if (currFinalCount <= 23 && i == 1) {
                        currSet.add(Double.parseDouble(s6.trim()));
                        if (currFinalCount == 23) break;
                    } else if (pfFinalSet <= 23 && i == 2) {
                        pfSet.add(Double.parseDouble(s6.trim()));
                        if (pfFinalSet == 23) break;
                    }
                }
            }

            Voltage voltage = new Voltage(set, s1.getKey());
            Current current = new Current(currSet, s1.getKey());
            PowerFactor powerFactor = new PowerFactor(pfSet, s1.getKey());
            Set<Voltage> voltages = new HashSet<>();
            voltages.add(voltage);
            Set<Current> currents = new HashSet<>();
            currents.add(current);
            Set<PowerFactor> powerFactors = new HashSet<>();
            powerFactors.add(powerFactor);
            deviceVariables = new DeviceVariables(voltages, currents, powerFactors);
        }
        return deviceVariables;
    }

    @Override
    public List<TTDPowerSupply> getDeviceDataWithName(String deviceName) {

        return null;
    }

    @Override
    public DeviceName getDeviceNames(String subStation) {
        DeviceMapping deviceMapping = deviceRepository.getOne(subStation);
        String s[] = deviceMapping.getDeviceName().split(",");
        DeviceName deviceName = new DeviceName();
        deviceName.setDeviceList(s);
        return deviceName;
    }
}
