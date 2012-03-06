package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.Testable;

public class _6 implements Testable {

    long sumOfSquares = 0;
    long squareOfSum = 0;

    @Override
    public String getResult() {
        return Long.toString(squareOfSum-sumOfSquares);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doOperation() {

        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
        }

        for (int i = 1; i <= 100; i++) {
            squareOfSum += i;
        }

        squareOfSum *= squareOfSum;
    }

    @Override
    public void setup() {
        sumOfSquares = 0;
        squareOfSum = 0;
    }
}
