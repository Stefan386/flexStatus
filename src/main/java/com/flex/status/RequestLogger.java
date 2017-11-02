package com.flex.status;

import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.time.Instant;
import java.util.Date;

@Service
public class RequestLogger {
    private String packageNr, username, status;
    private long timestamp;


    public RequestLogger(){

    }


    public RequestLogger(String packageNr, String username, String status){
        this.packageNr = packageNr;
        this.username = username;
        this.status = status;
        System.out.print(toString());

        setPackageNr(packageNr);
        setUsername(username);
        setTimestamp();
        //logRequest(packageNr, username, status);
    }

    public String getPackageNr() {
        return packageNr;
    }

    public void setPackageNr(String packageNr) {
        this.packageNr = packageNr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Date getTimestampAsDate(){
        Date date = new Date(timestamp);
        return date;
    }

    public void setTimestamp() {
        //this.timestamp = timestamp;
        Instant instant = Instant.now();
        timestamp = instant.toEpochMilli();
    }

    private void logRequest(String packageNr, String username, String status) {
        this.packageNr = packageNr;
        this.username = username;
        this.status = status;

    }

    public JsonObject getAllDetails(){
        //String details;
        //details = packageNr + username + status + timestamp;

        /**
        details = "{\"Request\":\n" +
                "{\n" +
                "\"packageNr\": "+packageNr+",\n" +
                "\"username\": "+username+",\n" +
                "\"timestamp\": "+timestamp+",\n" +
                "\"status\": "+status+",\n" +
                "}\n" +
                "}";
         */

        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("packageNr",packageNr);
        builder.add("username",username);
        builder.add("timestamp",timestamp);
        builder.add("status",status);
        JsonObject details = builder.build();

        return details;
    }
    @Override
    public String toString(){
        return "RequestLoggerService";
    }

    public void addRequest(String packageNr, String username, String status) {
        this.packageNr = packageNr;
        this.username = username;
        this.status = status;
        System.out.print(toString());

        setPackageNr(packageNr);
        setUsername(username);
        setTimestamp();
    }
}
