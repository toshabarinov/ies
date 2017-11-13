package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class numberToWordParser {
    static HashMap<Integer, Character> alphabet = new HashMap<>();
    static private final int ALPHABET_LENGTH = 26;

    static {
        int character = 65;
        for(int i = 0; i < ALPHABET_LENGTH; i++) {
            char ch = (char)character;
            alphabet.put(i, (Character)ch);
            character++;
        }
    }

    public static String parser(BigInteger input) {
        String output = "";
        int numberOfLetters = findNumberOfLetters(input);
        int arraySize = numberOfLetters;
        for(int i = 0; i < arraySize; i++) {
            ArrayList<BigInteger> alphabet = getAlphabet(numberOfLetters);
            BigInteger minArea = input.subtract(getMaximum(numberOfLetters-1));
            BigInteger maxArea = input.subtract(getMinimum(numberOfLetters-1));
            for(BigInteger in : alphabet) {
                if(in.compareTo(minArea) >= 0 && in.compareTo(maxArea) <= 0) {
                    output += getCharacter(in, alphabet);
                    input = input.subtract(in);
                    break;
                }
            }
            numberOfLetters--;

        }
        StringBuffer outputBuf = new StringBuffer(output);
        outputBuf.reverse();
        output = outputBuf.toString();
        return output;
    }

    private static char getCharacter(BigInteger number, ArrayList<BigInteger> bigAlphabet) {
        for(int i = 0; i < bigAlphabet.size(); i++) {
            if(bigAlphabet.get(i).compareTo(number) == 0) {
                return alphabet.get(i);
            }
        }
        return 'x';
    }

    private static int findNumberOfLetters(BigInteger in) {
        int output = 1;

        while(true) {
            if (in.compareTo(getMinimum(output)) > 0  && in.compareTo(getMaximum(output)) < 0) {
                break;
            }
            output++;
        }
        return output;
    }

    private static BigInteger getMinimum(int input) {
        //if(input == 0) {
            return new BigInteger("0");
        //}
        //return  new BigInteger("26").pow(input-1); // return 0 if AAAA?
    }

    private static BigInteger getMaximum(int input) {
        BigInteger output = new BigInteger("0");
        if(input == 1) {
            return new BigInteger("25");
        }
        for(int i = 0; i < input; i++) {
            BigInteger pow = new BigInteger("26").pow(i);
            output = output.add(new BigInteger("25").multiply(pow));
        }
        return output;
    }
    private static ArrayList<BigInteger> getAlphabet(int numberOfWords) {
        BigInteger factor = new BigDecimal(Math.pow(ALPHABET_LENGTH,numberOfWords-1)).unscaledValue();
        ArrayList<BigInteger> output = new ArrayList<>();
        for(int i = 0; i < ALPHABET_LENGTH; i++) {
            output.add(factor.multiply(BigInteger.valueOf(i)));
        }
        return output;
    }

}
