package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.Testable;

import java.math.BigInteger;

public class _15 implements Testable {

    @Override
    public String getResult() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doOperation() {
        BigInteger[][] a = new BigInteger[20][20];

        for (int i = 0; i < a.length; i++) {
            a[0][i] = new BigInteger(Integer.toString(i + 2));
        }
        for (int i = 0; i < a.length; i++) {
            a[i][0] = new BigInteger(Integer.toString(i + 2));
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                String b1 = a[i][j - 1].toString();
                String b2 = a[i - 1][j].toString();
                a[i][j] = new BigInteger(b1).add(new BigInteger(b2));
            }
        }
    }

    @Override
    public void setup() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
