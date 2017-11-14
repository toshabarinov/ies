package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public class factor {
    public static ArrayList<BigInteger> factorMe(BigInteger input) {
        ArrayList<BigInteger> output = new ArrayList<>();
        BigInteger sqrt = sqrt(input);
        if(sqrt.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
            sqrt = sqrt.add(BigInteger.valueOf(1));
        }
        BigInteger it = new BigInteger("2");
        while(true) {
            BigInteger result = input.divide(sqrt);
            if(result.multiply(sqrt).compareTo(input) == 0) {
                output.add(sqrt);
                output.add(input.divide(sqrt));
                break;
            }
            else {
                sqrt = sqrt.add(it);
            }
        }
        return output;
    }

    // Source : http://faruk.akgul.org/blog/javas-missing-algorithm-biginteger-sqrt/
    private static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while(b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
            else a = mid.add(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }
}
