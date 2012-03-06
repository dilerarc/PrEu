package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.NumSpel;
import ru.hfgl.preu.utils.Testable;

public class _17 implements Testable {

    private Integer count;

    @Override
    public String getResult() {
        return count.toString();
    }

    @Override
    public void doOperation() {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            s.append(new NumSpel(i).getNumberString());
        }
        String t = s.toString().replaceAll("\\-|\\s", "");
        s = new StringBuilder(t);
        count = s.length();
    }

    @Override
    public void setup() {
        count = 0;
    }
}
