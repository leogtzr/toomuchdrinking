package toomuchdrinking.util;

import toomuchdrinking.model.Drink;

public class SuggestedAlcohol {

    private SuggestedAlcohol() {}

    private static final double PURE_ALCOHOL = 789.24D;

    public static double calculateConsumedGrams(final Drink drink) {
        return ((drink.getMilliliters() * drink.getQuantity()) / 1000.0D) * ((drink.getAbv() / 100.0D) * PURE_ALCOHOL);
    }
}
