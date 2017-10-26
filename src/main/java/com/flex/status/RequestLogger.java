package com.flex.status;

import java.time.Instant;
import java.util.Date;

public class RequestLogger {
    private String packageNr, username, status;
    private long timestamp;


    public RequestLogger(String packageNr, String username, String status){
        this.packageNr = packageNr;
        this.username = username;
        this.status = status;

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

    public String getAllDetails(){
        String details;
        details = packageNr + username + status;

        return details;
    }
}
