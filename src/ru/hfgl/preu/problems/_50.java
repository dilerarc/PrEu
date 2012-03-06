package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.PrimeGen;
import ru.hfgl.preu.utils.Testable;

import java.util.HashSet;

public class _50 implements Testable {

    private int num;

    @Override
    public String getResult() {
        return Integer.toString(num);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doOperation() {
        int sum = 1000000;
        int temp = 0;
        int[] arr = PrimeGen.getPrimesBelow(sum);
        HashSet<Integer> dict = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            dict.add(arr[i]);
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; temp+arr[j] < sum; j++) {
                temp += arr[j];
            }

            if (dict.contains(temp)) {
                num = temp;
                break;
            }
            temp = 0;
        }
    }

    @Override
    public void setup() {
        num = 0;
    }
}
