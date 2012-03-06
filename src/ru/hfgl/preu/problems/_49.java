package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.PrimeGen;
import ru.hfgl.preu.utils.Testable;

import java.util.*;

public class _49 implements Testable {

    private int[] primes = PrimeGen.getPrimesBelow(10000);

    @Override
    public String getResult() {
        return "";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doOperation() {
        int[] arr = PrimeGen.getPrimesBetween(1000, 9999);
        HashMap<String, Collection<Integer>> hashMap = new HashMap<String, Collection<Integer>>();
        Collection<Integer> sortedNumbers;

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i : arr) {
            String s = Integer.toString(i);
            char[] c = s.toCharArray();
            Arrays.sort(c);
            s = String.copyValueOf(c);

            sortedNumbers = hashMap.get(s);
            if (sortedNumbers == null) {
                sortedNumbers = new TreeSet<Integer>();
            }
            sortedNumbers.add(i);
            hashMap.put(s, sortedNumbers);

        }
        outer:
        for (Collection<Integer> collection : hashMap.values()) {
            if (collection.size() < 3) {
                continue;
            }
            ArrayList<Integer> ar = new ArrayList<Integer>(collection);

            for (int i = 0; i < ar.size() - 2; i++) {
                for (int j = i + 1; j < ar.size() - 1; j++) {
                    for (int k = j + 1; k < ar.size(); k++) {

                        if (ar.get(j) - ar.get(i) == ar.get(k) - ar.get(j)) {

                            first = ar.get(i);
                            second = ar.get(j);
                            third = ar.get(k);
                            if (first == 1487 && second == 4817) {
                                first = 0;
                                second = 0;
                                third = 0;
                            }

                            if (ar.get(i) == 1973) {
                            }

                        }
                    }
                }
            }
        }
    }

    @Override
    public void setup() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
