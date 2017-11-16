package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

class collisionCreation {
    static private final String MATR_NUM_1 = "1431411";
    static private final String MATR_NUM_2 = "1431983";
    static private final String COOLIS_MESS_BASSIS = MATR_NUM_1 + MATR_NUM_2;           // 14314111431983
    static final BigInteger MAX_VALUE = new BigInteger("18446744073709551616").
            subtract(new BigInteger(COOLIS_MESS_BASSIS + "000000"));                               // HEX : FFFFFFFFFFFFFFFF+1

    static final BigInteger MAX_VALUE_8 = new BigInteger("4294967295");             // HEX : FFFFFFFF+1

    static ArrayList<String> calculate() {
        TreeSet<String> database = new TreeSet<>();
        ArrayList<String> output = new ArrayList<>();
        BigInteger r;
        while(true) {
            do {
                r = new BigInteger(MAX_VALUE_8.bitLength(), new Random());
            } while (r.compareTo(MAX_VALUE_8) >= 0);
            String hashCode = shaConverter.sha64(r.toString());
            if(!database.add(hashCode)) {
                output.add(hashCode);
                break;
            }
        }

        return output;
    }


}
