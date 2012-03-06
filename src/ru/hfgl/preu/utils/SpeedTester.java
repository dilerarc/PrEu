package ru.hfgl.preu.utils;

import org.apache.log4j.Logger;

public class SpeedTester {

    private static double ITERATIONS_NUMBER = 1e5;
    private static final Logger log = Logger.getLogger(SpeedTester.class);

    public static void run(Testable... tests) {
        log.info("Testing for " + ITERATIONS_NUMBER + " iterations");
        log.info("---------------------------");
        log.info("---------------------------");
        for (int i = 0; i < tests.length; i++) {
            Testable test = tests[i];
            long millis = System.currentTimeMillis();
            for (double j = 0; j < ITERATIONS_NUMBER; j++) {
                test.setup();
                test.doOperation();
            }
            log.info("Problem" + test.getClass().getSimpleName());
            log.info(System.currentTimeMillis() - millis + " ms");
            log.info("Result is " + test.getResult());
            log.info("---------------------------");
        }
    }

    public static double getIterationsNumber() {
        return ITERATIONS_NUMBER;
    }

    public static void setIterationsNumber(int ITERATIONS_NUMBER) {
        SpeedTester.ITERATIONS_NUMBER = ITERATIONS_NUMBER;
    }
}
