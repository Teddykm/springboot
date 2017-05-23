package com.boot;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileReader;

public class jsonFormater {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        String json = "";

        try {
            Resource resource = new ClassPathResource("/webapp.json");
            Object object = parser.parse(new FileReader(resource.getFile()));
            JSONObject jsonObject = (JSONObject) object;
            System.out.println(jsonObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
