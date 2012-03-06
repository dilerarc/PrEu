package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.Testable;

public class _9 implements Testable {

    long product = 0;

    @Override
    public String getResult() {
        return Long.toString(product);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doOperation() {
        for (int a = 1; a <= 1000; a++) {
            for (int b = 1; b <= 1000; b++) {
                for (int c = 1; c < 1000; c++) {
                    if (a < b && b < c && (a + b + c == 1000) && (a * a + b * b == c * c)) {
                        product = a * b * c;
                        return;
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
