package com.flex.status;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.*;

@RestController
public class Controller {

    private List<RequestLogger> requestLoggerList = new ArrayList<>();

    @RequestMapping("/getStatus") //returns the status of one package; example-URL: http://localhost:8080/getStatus?packageNr=2
    public String getStatus(@RequestParam Map<String,String> requestParams){
        String packageNr = requestParams.get("packageNr");
        String username = requestParams.get("username");
        Status statusObj = new Status();
        String status;
        status = statusObj.getStatusFromApi(packageNr, username);

        //logRequest
        RequestLogger requestLog = new RequestLogger(packageNr, username, status);
        requestLoggerList.add(requestLog);
        System.out.println(requestLoggerList.size());

        return status;
    }

    @RequestMapping("/getLoggedRequests")
    public int getLoggedRequests(){

       int sizeOfRequestList =  requestLoggerList.size();
        LocalTime timeStamp = requestLoggerList.get(0).getTimestamp();
        System.out.println(timeStamp);

        return sizeOfRequestList;
    }
}
