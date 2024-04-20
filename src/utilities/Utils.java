package utilities;

import java.util.Random;

public class Utils {
    private static Utils instance;
    private Random rand;

    private Utils() {
        rand = new Random();
    }

    public static synchronized Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public int randInt(int min, int max) {
        return rand.nextInt((max - min + 1)) + min;
    }

    public long randLong(long min, long max) {
        return min + (long) (rand.nextDouble() * (max - min));
    }
}
