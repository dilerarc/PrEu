package ru.hfgl.preu.utils;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class PrimeGen {

    private static boolean[] booleans;
    private static int[] primes;
    private final static int DEFAULT_PRIMES_COUNT = 1000;

    private static Logger log = Logger.getLogger(PrimeGen.class);

    public static int[] getPrimesBetween(int n, int m) {
        process(m);
        fillPrimesArray(n);
        return primes;
    }

    public static int[] getPrimesBelow(int m) {
        process(m);
        fillPrimesArray(0);
        return primes;
    }

    public static int[] getPrimes(int m) {
        process(DEFAULT_PRIMES_COUNT);
        int i = 2;
        while (getCount() < m) {
            process(DEFAULT_PRIMES_COUNT * i);
            i++;
        }

        fillPrimesArray(0);
        return Arrays.copyOf(primes, m);
    }

    public static boolean isPrime(long m) {
        if (m % 2 == 0) return false;
        for (long i = 3; i <= m / 2; i += 2) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void process(int n) {
        booleans = new boolean[n + 1];
        Arrays.fill(booleans, 2, n + 1, true);
        for (int i = 2; i * i <= n; i++) {
            if (booleans[i]) {
                for (int k = i + i; k <= n; k += i) {
                    booleans[k] = false;
                }
            }
        }
    }

    private static void fillPrimesArray(int n) {
        primes = new int[getCount()];
        int z = 0;
        for (int i = n; i < booleans.length; i++) {
            if (booleans[i] == true) {
                primes[z] = i;
                z++;
            }
        }
    }

    private static int getCount() {
        int count = 0;
        for (int i = booleans.length - 1; i >= 0; i--) {
            if (booleans[i]) {
                count++;
            }
        }
        return count;
    }
}