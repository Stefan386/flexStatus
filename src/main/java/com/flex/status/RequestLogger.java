package com.flex.status;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.ZoneId;

public class RequestLogger {
    private String packageNr, username, status;
    private LocalTime timestamp;


    public RequestLogger(String packageNr, String username, String status){
        this.packageNr = packageNr;
        this.username = username;
        this.status = status;

        setPackageNr(packageNr);
        setUsername(username);
        LocalTime localTime = LocalTime.now(ZoneId.of("GMT+02:00"));
        setTimestamp(localTime);


        logRequest(packageNr, username, status);

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

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }

    private void logRequest(String packageNr, String username, String status) {
        this.packageNr = packageNr;
        this.username = username;
        this.status = status;

    }
}
