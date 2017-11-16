package com.company;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Main {
    static private final BigInteger PUBLIC_KEY = new BigInteger("849075495442228387159");
    static private final BigInteger EXPONENT = new BigInteger("65537");
    static private final String CIPHER_TEXT = "SATTLXRMINKPYXJ";


    public static void main(String[] args) {
        //ArrayList<BigInteger> primeNumbers = factor.factorMe(PUBLIC_KEY); // FULL VERSION
        ArrayList<BigInteger> primeNumbers = new ArrayList<>();          // SHORT VERSION
        primeNumbers.add(new BigInteger("30077289527"));           //
        primeNumbers.add(new BigInteger("28229787617"));          //

        BigInteger phiFromN = calculatePhiFromN(primeNumbers);
        BigInteger privateKey = calculatePrivateKey(phiFromN);
        BigInteger m = cipherToNumberParser.parser(CIPHER_TEXT).modPow( privateKey, PUBLIC_KEY);  // m = c^d mod n
        System.out.println(numberToWordParser.parser(m));
        System.out.println("Hash : " + sha256("10301231030456"));
    }

    private static BigInteger calculatePhiFromN(ArrayList<BigInteger> primeNumbers) { // phi(n) = (q-1) * (p-1)
        return (primeNumbers.get(0).subtract(BigInteger.valueOf(1))).
                multiply(primeNumbers.get(1).subtract(BigInteger.valueOf(1)));
    }

    private static BigInteger calculatePrivateKey(BigInteger phi) {
        return EXPONENT.modInverse(phi);
    }


    //Source : https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
    public static String sha256(String base) {
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

}


