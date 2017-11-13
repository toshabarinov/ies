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
        System.out.println(numberToWordParser.parser(new BigInteger(input5)));
    }
}
