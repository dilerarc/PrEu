package ru.hfgl.preu.problems;

import org.apache.log4j.Logger;
import ru.hfgl.preu.utils.FileReader;
import ru.hfgl.preu.utils.Testable;

import java.nio.file.NoSuchFileException;
import java.util.Arrays;

public class _22 implements Testable {

    Logger log = Logger.getLogger(_22.class);
    private Long scores;

    @Override
    public String getResult() {
        return scores.toString();
    }

    @Override
    public void doOperation() {
        try {
            FileReader fileReader = new FileReader("./other/names.txt");
            String s = fileReader.getList().get(0);
            String[] sarr = s.split(",");
            Arrays.sort(sarr);
            for (int i = 0; i < 5163; i++) {
                sarr[i] = sarr[i].replace("\"", "");
                scores += getScores(sarr[i], i);

            }


        } catch (NoSuchFileException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setup() {
        scores = 0l;
    }

    private long getScores(String word, int pos) {
        long sc = 0l;
        char[] ch = word.toCharArray();
        for (char c : ch) {
            sc += (long) c - 64;
        }
        return sc * (pos + 1);
    }
}
