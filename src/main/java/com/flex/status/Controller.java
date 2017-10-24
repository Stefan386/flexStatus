package com.flex.status;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/getStatus") //returns the status of one package
    public String getStatus(@RequestParam(value="packageNr", defaultValue = "") String packageNr){

        return packageNr;
    }
    //String home(){
    //    return "Hello, World!";
    //}
}
