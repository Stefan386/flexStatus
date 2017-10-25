package com.flex.status;

import java.sql.Timestamp;

public class RequestLogger {
    private String packageNr, username, status;
    private Timestamp timestamp;

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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public RequestLogger(String packageNr, String username, String status){
        this.packageNr = packageNr;
        this.username = username;
        this.status = status;

        logRequest(packageNr, username, status);

    }

    private void logRequest(String packageNr, String username, String status) {
        this.packageNr = packageNr;
        this.username = username;
        this.status = status;

    }
}
