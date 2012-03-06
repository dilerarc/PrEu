package ru.hfgl.preu.problems;

import org.apache.log4j.Logger;
import ru.hfgl.preu.utils.PrimeGen;
import ru.hfgl.preu.utils.Testable;
import sun.util.resources.LocaleNames_ga;

import java.util.HashSet;
import java.util.Set;

public class _41 implements Testable {

    private static Logger log = Logger.getLogger(_41.class);
    private Long intersect;
    private Set<Long> permutations;

    @Override
    public String getResult() {
        return intersect.toString();
    }

    @Override
    public void doOperation() {
        long temp = 0;
        Set<Long> permutations = findAllPermutations(new int[]{1, 2, 3, 4, 5, 6, 7}, 0);  // 1-8 and 1-9 don't have primes
        for (long l : permutations) {
            if (PrimeGen.isPrime(l)) {
                intersect = Math.max(intersect, l);
            }
        }
    }

    @Override
    public void setup() {
        intersect = 0l;
        permutations = new HashSet<>();
    }

    private Set<Long> findAllPermutations(int[] pa, int i) {
        if (i == pa.length - 1) {
            permutations.add(arrayToLong(pa));
        } else {
            for (int j = i; j < pa.length; j++) {
                swap(pa, i, j);
                findAllPermutations(pa, i + 1);
                swap(pa, i, j);
            }
        }
        return permutations;
    }

    private void swap(int[] pa, int i, int j) {
        int k = pa[i];
        pa[i] = pa[j];
        pa[j] = k;
    }

    private Long arrayToLong(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return Long.parseLong(sb.toString());
    }
}
