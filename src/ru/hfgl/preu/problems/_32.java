package ru.hfgl.preu.problems;

import org.apache.log4j.Logger;
import ru.hfgl.preu.utils.Testable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _32 implements Testable {

    private static final Logger log = Logger.getLogger(_32.class);

    private Long sum;
    private Set<Long> products;
    private List<String> permutations;

    @Override
    public String getResult() {
        return sum.toString();
    }

    @Override
    public void doOperation() {
        findAllPermutations(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0);

        Long num;
        for (String s : permutations)
            for (int i = 0; i <= 6; i++) {
                for (int j = i + 1; j <= 7; j++) {
                    num = getNum(s, j + 1, 8);
                    if (num == getNum(s, 0, i) * getNum(s, i + 1, j)) {
                        products.add(num);
                    }
                }
            }

        getSum();
    }

    @Override
    public void setup() {
        sum = 0L;
        products = new HashSet<>();
        permutations = new ArrayList<>();
    }

    private void getSum() {
        for (Long l : products) {
            sum += l;
        }
    }

    private void findAllPermutations(int[] pa, int i) {
        if (i == pa.length - 1) {
            permutations.add(arrayToString(pa));
        } else {
            for (int j = i; j < pa.length; j++) {
                swap(pa, i, j);
                findAllPermutations(pa, i + 1);
                swap(pa, i, j);
            }
        }
    }

    private void swap(int[] pa, int i, int j) {
        int k = pa[i];
        pa[i] = pa[j];
        pa[j] = k;
    }

    private Long getNum(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }

    private String arrayToString(int[]arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }

}
