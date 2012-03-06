package ru.hfgl.preu.utils;

public class NumSpel {

    private static final String[] LARGE_NUMBERS = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion"};
    private int number = 0;
    private int groups = 0;
    private String digStr = "";
    private String numberString = "";

    public NumSpel(int n) {
        number = n;
        digStr = Integer.toString(number);
        String[] arr = divide3(digStr);

        for (int i = 0; i < arr.length; i++) {
            String units =  new ThreeGroup(arr[i]).getNumberStr();
            String bigUnit =  LARGE_NUMBERS[i];

            if(i!=arr.length-1 && units.equals("zero")){
                units = "";
                bigUnit = "";
            }

            numberString = units + " " + bigUnit + " " + numberString;
            numberString = numberString.trim();
        }

    }

    public NumSpel(String s) {
        this(Integer.parseInt(s));
    }

    public String getNumberString() {
        return numberString;
    }

    private static String[] divide3(String s) {
        int groups = (int) Math.ceil(s.length() / 3);
        int rest = s.length() - groups * 3;
        if (rest != 0) groups++;
        String[] arr = new String[groups];

        s = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < groups; i++) {
            if (i == groups - 1 && rest != 0) {
                arr[i] = new StringBuilder(s.substring(i * 3, i * 3 + rest)).reverse().toString();
            } else {
                arr[i] = new StringBuilder(s.substring(i * 3, i * 3 + 3)).reverse().toString();
            }
        }
        return arr;
    }
}
