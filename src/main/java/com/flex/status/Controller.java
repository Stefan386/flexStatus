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
    public String getLoggedRequests(){
        String details = "";
       //int sizeOfLoggerList =  requestLoggerList.size();
       int i = 0;
       while(i < requestLoggerList.size()){
           details = details+requestLoggerList.get(i).getAllDetails();
        i++;
        }
        System.out.println(details);

        return details;
    }
    @RequestMapping("/getLoggedRequestsByUser") //return requests of one user
    public String getLoggedRequestsByUser(@RequestParam(value="username", defaultValue = "") String username){
        String details = "";
    int i = 0;
    while(i < requestLoggerList.size()){

        if(requestLoggerList.get(i).getUsername().equals(username)){
            details = details+requestLoggerList.get(i).getAllDetails();
        }
        i++;
    }
    return details;
    }
}
