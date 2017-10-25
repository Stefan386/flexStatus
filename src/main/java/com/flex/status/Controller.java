package com.flex.status;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    private List<RequestLogger> requestLoggerList = new List<RequestLogger>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<RequestLogger> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(RequestLogger requestLogger) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends RequestLogger> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends RequestLogger> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public RequestLogger get(int index) {
            return null;
        }

        @Override
        public RequestLogger set(int index, RequestLogger element) {
            return null;
        }

        @Override
        public void add(int index, RequestLogger element) {

        }

        @Override
        public RequestLogger remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<RequestLogger> listIterator() {
            return null;
        }

        @Override
        public ListIterator<RequestLogger> listIterator(int index) {
            return null;
        }

        @Override
        public List<RequestLogger> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    @RequestMapping("/getStatus") //returns the status of one package; example-URL: http://localhost:8080/getStatus?packageNr=2
    public String getStatus(@RequestParam Map<String,String> requestParams){
        String packageNr = requestParams.get("packageNr");
        String username = requestParams.get("username");
        Status statusObj = new Status();
        String status;
        status = statusObj.getStatusFromApi(packageNr, username);

        //logRequest
        RequestLogger requestLog = new RequestLogger(packageNr, username, status);
        requestLoggerList.add(requestLog);
        System.out.print(requestLoggerList.size());

        return status;
    }

    @RequestMapping("/getLoggedRequests")
    public int getLoggedRequests(){

       int sizeOfRequestList =  requestLoggerList.size();

        return sizeOfRequestList;
    }
}
