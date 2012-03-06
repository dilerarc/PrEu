package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.Testable;

public class _12 implements Testable {
    private int count = 0;
    private long maxTri = 1;
    private int temp = 0;
    long z = 2;

    @Override
    public String getResult() {
        return Long.toString(maxTri);
    }

    @Override
    public void doOperation() {
        for (; count < 500; maxTri += z++) {
            temp = 0;
            for (int j = 1; j<=Math.sqrt(maxTri); j++) {
                if (maxTri % j == 0) {
                    temp+=2;
                }


            }
            count = Math.max(temp, count);
        }
        z--;
        maxTri-=z;
    }

    @Override
    public void setup() {
        maxTri = 1;
        count = 0;
    }
}
