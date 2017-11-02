package com.flex.status;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestLoggerService {
    private List<RequestLogger> requestLoggerList = new ArrayList<>();

    public List<RequestLogger> getRequestLoggerList() {
        return requestLoggerList;
    }


    public void addRequest(String packageNr, String username, String status) {
        //logRequest
        RequestLogger requestLog = new RequestLogger(packageNr, username, status);
        requestLoggerList.add(requestLog);
        System.out.println(requestLoggerList.size());
    }
}
