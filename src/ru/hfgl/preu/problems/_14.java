package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.Testable;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class _14 implements Testable {

    private int count = 0;
    private long num = 1000000;
    private HashMap<Long, Integer> hm;

    @Override
    public String getResult() {
        return "";
    }

    @Override
    public void doOperation() {
        hm = new HashMap<>();
        long n;
        while ((n = num--) > 1) {
            count = 0;
            while (n != 1) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = 3 * n + 1;
                }
                count++;

            }
            hm.put(num, count);

        }

        Set<Integer> st = new TreeSet<>(hm.values());
    }

    @Override
    public void setup() {
        count = 0;
    }
}
