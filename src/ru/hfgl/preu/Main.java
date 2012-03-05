package ru.hfgl.preu;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        DOMConfigurator.configure("./config/log4j.xml");
        log.info("Hello");
        log.info("Hello");
    }
}
