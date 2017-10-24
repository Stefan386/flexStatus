package com.flex.status;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/getStatus") //returns the status of one package; example-URL: http://localhost:8080/getStatus?packageNr=2
    public String getStatus(@RequestParam(value="packageNr", defaultValue = "") int packageNr){

        Status statusObj = new Status();
        String status;
        status = statusObj.getStatusFromApi(packageNr);

        return status;
    }
}
