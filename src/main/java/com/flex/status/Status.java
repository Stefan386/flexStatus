package com.flex.status;

import org.springframework.web.client.RestTemplate;

public class Status {


    public String getStatusFromApi(String packageNr, String username){ //get status from Service-Provider-API
        String status;


        String serviceURL = "http://demo0657008.mockable.io/getStatus?nr="+packageNr; //mock return only status 'delivered'
        RestTemplate restTemplate = new RestTemplate();
        status = restTemplate.getForObject(serviceURL,String.class); //returns JSONObject

        /**
        //converting JSON result to String;
        try {
            JSONObject jsonObject = new JSONObject(status);
            status = jsonObject.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */
        return status;
    }
}
