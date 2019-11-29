package com.power.smarttrack.controller;

import com.power.smarttrack.model.*;
import com.power.smarttrack.service.Service;
import com.power.smarttrack.util.SmartTrackUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/message")
public class SmartTrackController {

    @Autowired
    public Service service;

    @RequestMapping(value = "/send", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpStatus insertData(@RequestBody List<TTDPowerSupply> ttdPowerSupplyList) {
        boolean isDataInserted = service.insertData(ttdPowerSupplyList);
        return isDataInserted ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getVoltage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeviceVariables getVoltageData(@RequestBody SmartTrackRequest smartTrackRequest,
                                          HttpServletResponse response) {
        System.out.println("Entered getData method for retrieving the requested data...");
        try {
            SmartTrackUtils.setResponseHeader(response);
            DeviceVariables deviceVariables = service.getVoltageData(smartTrackRequest);
            System.out.println("Successfully fetched the requested data...");
            return deviceVariables;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getDevices", method = RequestMethod.GET, headers = "Accept=application/json")
    public DeviceName getDevices(@RequestParam String subStation, HttpServletResponse response) {
        System.out.println("Entered getData method for retrieving the requested data...");
        try {
            SmartTrackUtils.setResponseHeader(response);
            DeviceName deviceNames = service.getDeviceNames(subStation);
            return deviceNames;
        } catch (Exception ex) {
            return null;
        }
    }
}
