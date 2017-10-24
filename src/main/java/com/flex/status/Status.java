package com.flex.status;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class Status {


    public String getStatusFromApi(int packageNr){ //get status from Service-Provider-API

        String serviceURL = "http://demo0657008.mockable.io/getStatus?nr="+packageNr; //mock return only status 'delivered'

        RestTemplate restTemplate = new RestTemplate();
        String status = "null";


        String result = restTemplate.getForObject(serviceURL,String.class);

        try {
            JSONObject jsonObject = new JSONObject(result);
            status = jsonObject.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return status;
    }
}
