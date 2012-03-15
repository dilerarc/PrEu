package ru.hfgl.preu.problems;

import org.apache.log4j.Logger;
import ru.hfgl.preu.utils.PrimeGen;
import ru.hfgl.preu.utils.Testable;

import java.util.HashSet;
import java.util.Set;

public class _27 implements Testable {

    private static Logger log = Logger.getLogger(_27.class);
    private Integer product;

    @Override
    public String getResult() {
        return product.toString();
    }

    @Override
    public void doOperation() {
        Set<Integer> primes = new HashSet<>();
        int[] arr = PrimeGen.getPrimesBelow(111000);
        for (int i : arr) {
            primes.add(i);
        }
        int n = 0;
        int maxConsecutive = 0;
        int temp = 0;
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                while (true) {
                    if (primes.contains(n * n + i * n + j)) {
                        temp++;
                        n++;
                    } else {
                        if (maxConsecutive < temp) {
                            maxConsecutive = temp;
                            product = i * j;
                        }
                        n = 0;
                        temp = 0;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void setup() {
        product = 0;
    }
}
