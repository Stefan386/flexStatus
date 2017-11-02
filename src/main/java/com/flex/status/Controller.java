package com.flex.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    @Autowired
    private RequestLoggerService requestLoggerService;
    @Autowired
    private StatusService statusService;


    @RequestMapping("/getStatus") //returns the status of one package; example-URL: http://localhost:8080/getStatus?packageNr=2
    public String getStatus(@RequestParam Map<String,String> requestParams){
        String status;
        String packageNr = requestParams.get("packageNr");
        String username = requestParams.get("username");

        status = statusService.getStatusFromApi(packageNr, username);
        requestLoggerService.setRequest(packageNr, username, status);

        return status;
    }

    @RequestMapping("/getLoggedRequests")
    public String getLoggedRequests(){
        String details = "";
       int i = 0;
       while(i < requestLoggerService.getRequestLoggerList().size()){
           details = details+ requestLoggerService.getRequestLoggerList().get(i).getAllDetails();
        i++;
        }
        System.out.println(details);

        return details;
    }
    @RequestMapping("/getLoggedRequestsByUser") //return requests of one user
    public String getLoggedRequestsByUser(@RequestParam(value="username", defaultValue = "") String username){
        String details = "";
        String JsonSeperator = ","; //json element-seperator

    int i = 0;
    while(i < requestLoggerService.getRequestLoggerList().size()){

        if(i+1 == requestLoggerService.getRequestLoggerList().size())
        {
            JsonSeperator = "";
        }
        if(requestLoggerService.getRequestLoggerList().get(i).getUsername().equals(username)){
            details = details+ requestLoggerService.getRequestLoggerList().get(i).getAllDetails().toString()+JsonSeperator;
        }
        i++;
    }
    details = "["+details+"]"; //adding jsonArray prefix/sufix

    return details;
    }
}
