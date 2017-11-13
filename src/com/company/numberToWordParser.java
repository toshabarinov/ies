package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class numberToWordParser {
    public static String parser(int input) {
        System.out.println("BUCHSTABEN ANTOHER :");
        for(BigInteger i : getAlphabet(5)) {
            System.out.println(i);
        }
        return "";
    }

    private static int findNumberOfLetters(int input) {
        int output = 1;

        while(true) {
            if (input > getMinimum(output) && input < getMaximum(output)) {
                break;
            }
            output++;
        }
        return output;
    }

    private static int getMinimum(int input) {
        return (int)Math.pow(26,input-1);
    }

    private static int getMaximum(int input) {
        int output = 0;
        if(input == 1) {
            return 25;
        }
        for(int i = 0; i < input; i++) {
            output += 25 * Math.pow(26, i);
        }
        return output;
    }
    private static ArrayList<BigInteger> getAlphabet(int numberOfWords) {
        BigInteger factor = new BigDecimal(Math.pow(26,numberOfWords-1)).unscaledValue();
        ArrayList<BigInteger> output = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            output.add(factor.multiply(BigInteger.valueOf(i)));
        }
        return output;
    }

}
