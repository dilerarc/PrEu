package ru.hfgl.preu.problems;

import ru.hfgl.preu.utils.FileReader;
import ru.hfgl.preu.utils.Testable;

import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _18 implements Testable {

    private Integer sum;

    @Override
    public String getResult() {
        return sum.toString();
    }

    @Override
    public void doOperation() {
        try {
            FileReader fileReader = new FileReader("18.txt");
            List<String> list = fileReader.getList();
            for (String s : list) {
                String[] tokens = s.split("\\s");
                sum += Integer.parseInt(Collections.max(Arrays.asList(tokens)));
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void setup() {
        sum = 0;
    }
}
