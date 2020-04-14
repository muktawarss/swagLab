package com.ecom.utility;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class TestData {
   public  InputStream datais;
    public  JSONObject loginuser;
   public  TestData(String file){
       try {
           String dataFileName = file;
           datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
           JSONTokener tokener = new JSONTokener(datais);
           loginuser = new JSONObject(tokener);
       } catch (Exception e) {
           e.printStackTrace();

       } finally {
           if (datais != null) {
               try {
                   datais.close();
               } catch (IOException e) {
                   e.printStackTrace();

           }
       }
   }

    }
}
