package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.Testable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _16 implements Testable {

    private Integer sum = 0;
    private List<Integer> subSums;

    @Override
    public String getResult() {
        return sum.toString();
    }

    @Override
    public void doOperation() {
        BigInteger bi = new BigInteger("1");
        BigInteger bi2 = new BigInteger("2");
        for (int i = 1; i <= 1000; i++) {
            bi = bi.multiply(bi2);
        }

        char[] chs = bi.toString().toCharArray();
        for (int i = 0; i < chs.length; i++) {
            sum += Character.getNumericValue(chs[i]);
        }
    }

    @Override
    public void setup() {
        subSums = new ArrayList<>();
        sum = 0;
    }
}
