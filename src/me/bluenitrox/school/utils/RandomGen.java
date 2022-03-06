package me.bluenitrox.school.utils;

import java.util.PrimitiveIterator;
import java.util.Random;

public class RandomGen {

    private PrimitiveIterator.OfInt randomIterator;

    /**
     * Initialize a new random number generator that generates
     * random numbers in the range [min, max]
     * @param min - the min value (inclusive)
     * @param max - the max value (inclusive)
     */
    public RandomGen(int min, int max) {
        randomIterator = new Random().ints(min, max + 1).iterator();
    }

    /**
     * Returns a random number in the range (min, max)
     * @return a random number in the range (min, max)
     */
    public int nextInt() {
        return randomIterator.nextInt();
    }

}
