package utilities;

import java.util.Random;

public class Utils {

    //https://stackoverflow.com/questions/13725478/java-random-long-value-in-an-interval
    //generate random long number between mim and max
    public static long randLong(long min, long max) {
        Random rand = new Random();
        return min + (long)(rand.nextDouble()*(max - min));
    }

    //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
    //generate random number between mim and max
    public static int randInt(int min, int max) {
        Random rand = new Random();
        return  rand.nextInt((max - min) + 1) + min;
    }
}
