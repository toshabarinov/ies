package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public class semiFactorisation {

        public static ArrayList<Integer> primeNumbers(BigInteger end) {
            // generate array of number from 2 to end
            // generate flag array of same size
            // this numbers are inclusive
            int eff = 0;
            ArrayList<Integer> factors = new ArrayList<Integer>();
            if (end.compareTo(2)) {
                return factors;
            }
            if (end == 2) {
                factors.add(2);
                return factors;
            }
            int numbers[] = new int[end - 1];
            boolean flags[] = new boolean[end - 1];
            int count = 2;
            // lets reset all numbers
            for (int i = 0; i < end - 1; i++) {
                numbers[i] = count;
                flags[i] = true;
                count++;
            }
            for (int i = 0; i < end - 1; i++) {
                if (flags[i]) {
                    factors.add(numbers[i]);
                    int loop = 2;
                    for (long j = numbers[i] * loop; j <= end; j = numbers[i]
                            * loop, loop++) {
                        flags[(int) (j - 2)] = false;
                        eff++;
                    }
                }
            }
            // System.out.println(eff);
            return factors;
        }
}
