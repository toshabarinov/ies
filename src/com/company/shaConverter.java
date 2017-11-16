package com.company;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.security.MessageDigest;
import java.util.ArrayList;

public class  shaConverter {
    static String prefix = "0x";


    //Source : https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
    private static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public static String sha64(String base) {

        String input = sha256(base);
        int divisor = 8;
        ArrayList<Long> inputParts = new ArrayList<>();

        while (input.length()>0) {

            String chunk = input.substring(0,divisor);
            input = input.substring(divisor,input.length());
            //chunk.toUpperCase();
            //chunk = prefix + chunk;
            inputParts.add(Long.parseUnsignedLong(chunk,16));
        }


        long result = inputParts.get(0);
        for(int it = 1 ; it < 4; it++) {
            result ^= inputParts.get(it);
        }

        long result2 = inputParts.get(4);
        for(int it = 5 ; it < 8; it++) {
            result2 ^= inputParts.get(it);
        }
        String output = Long.toHexString( result2) + Long.toHexString(result);
        return  output;
    }
}
