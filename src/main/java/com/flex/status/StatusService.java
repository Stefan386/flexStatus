package com.flex.status;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatusService {

    public String getStatusFromApi(String packageNr, String username){ //get status from Service-Provider-API
        String status;
        String serviceURL = "http://demo0657008.mockable.io/getStatus?nr="+packageNr; //mock return only status 'delivered'
        RestTemplate restTemplate = new RestTemplate();
        status = restTemplate.getForObject(serviceURL,String.class); //returns JSONObject

        //converting JSON result to String;
        try {
            JSONObject jsonObject = new JSONObject(status);
            status = jsonObject.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return status;
    }
}
