package ru.hfgl.preu;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.hfgl.preu.problems._22;
import ru.hfgl.preu.utils.SpeedTester;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        DOMConfigurator.configure("./config/log4j.xml");
        SpeedTester.setIterationsNumber(1);
        SpeedTester.run(new _22());

    }
}
