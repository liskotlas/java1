package ru.progwards.java2.lessons.Training;

import ru.progwards.java2.lessons.app.Store;

import java.util.HashMap;

public class Trainig {
    public static void main(String[] args) {


        String request = "GET /balance?id=cbf61d6f-ea3f-4f9a-9c5c-bd11dd02c392 HTTP/1.1";
//        System.out.println(request.indexOf("GET /"));
//        System.out.println(request.indexOf("?"));
        String method = request.substring(request.lastIndexOf("GET /")+5, request.indexOf("?")).trim();
//        System.out.println(method);
        HashMap<String, String> parameters = new HashMap<>();


        String[] strResp = request.substring(request.indexOf("?")+1, request.indexOf("HTTP")).trim().split("&");
        for (String strPair : strResp) {
            String[] pair = strPair.split("=");
            if (pair.length > 1) {
                parameters.put(pair[0], pair[1]);
            }
        }
        for (var entry : parameters.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        Store.getStore();

    }


}
