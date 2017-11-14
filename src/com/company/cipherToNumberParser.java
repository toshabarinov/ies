package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public class cipherToNumberParser {

    public static BigInteger parser(String input) {
        BigInteger output = new BigInteger("0");
        int numberOfLetters = input.length();
        for(int i = 0; i < numberOfLetters; i++) {

            String Letter = String.valueOf(input.charAt(i));
            int wert = String.valueOf(Letter).codePointAt(0) - 65;

            BigInteger pow = new BigInteger("26").pow(i);
            output = output.add(BigInteger.valueOf(wert).multiply(pow));

        }

        return output;
    }
}
