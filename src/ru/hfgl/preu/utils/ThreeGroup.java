package ru.hfgl.preu.utils;

public class ThreeGroup {

    private final static String[] UNITS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private final static String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private final static String[] HUNDREDS = {"", "one hundred", "two hundred", "three hundred", "four hundred",
            "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};
    private int units = 0;
    private int tens = 0;
    private int hundreds = 0;
    private int number = 0;
    private String unitsStr = "";
    private String tensStr = "";
    private String hundredsStr = "";
    private String numberStr = "zero";

    public ThreeGroup(int n) throws RuntimeException {
        if (n < 0 && n > 999) throw new RuntimeException("only 0-999");
        number = n;

        units = number % 10;
        tens = number % 100 / 10;
        hundreds = number / 100;

        if (units != 0 || (tens == 0 && hundreds == 0)) {
            unitsStr = UNITS[units];
        }
        if (tens == 1) {
            unitsStr = UNITS[units + 10];
        }
        tensStr = TENS[tens];
        hundredsStr = HUNDREDS[hundreds];

        numberStr = hundredsStr + " " + tensStr + "-" + unitsStr;
        numberStr = numberStr.replaceAll("\\b-\\B|\\B-\\b|\\B-\\B", "").trim();
    }

    public ThreeGroup(String str) throws RuntimeException {
        this(Integer.parseInt(str));
    }

    public void setUnits(int n) throws RuntimeException {
        if (n < 0 && n > 9) throw new RuntimeException("only 0-9");
        units = n;
    }

    public int getUnits() {
        return units;
    }

    public void setTens(int n) throws RuntimeException {
        if (n < 0 && n > 9) throw new RuntimeException("only 0-9");
        tens = n;
    }

    public int getTens() {
        return tens;
    }

    public void setHundreds(int n) throws RuntimeException {
        if (n < 0 && n > 9) throw new RuntimeException("only 0-9");
        hundreds = n;
    }

    public int getHundreds() {
        return hundreds;
    }

    public int getNumber() {
        return number;
    }

    public String getNumberStr() {
        return numberStr;
    }
}
