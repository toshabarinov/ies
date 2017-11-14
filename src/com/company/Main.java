package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String input5 = "25775122570195912724"; // encrypted 'HALLO'
        String input = "7624886934"; // COUNTRY
        String input2 = "6598547"; // HELLO
        String input3 = "6598443"; // HALLO
        String input4 = "144727094174"; // APADANAS

        String input6 = "71467136137178"; // decr. 640003122567578301446  --> SATTLXRMINKPYXJ
        //System.out.println(numberToWordParser.parser(new BigInteger(input6)));



        String inputcipher = "SATTLXRMINKPYXJ";

        //System.out.println(cipherToNumberParser.parser(inputcipher));


        BigInteger d = new BigInteger("676920602992424195905");  //todo: d berechnen
        BigInteger n = new BigInteger("849075495442228387159");
        BigInteger m = cipherToNumberParser.parser(inputcipher).modPow( d, n);  // m = c^d mod n

        System.out.println(numberToWordParser.parser(m));
        factor.factorMe(new BigInteger("849075495442228387159"));


    }
}
