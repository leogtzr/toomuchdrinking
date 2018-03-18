package toomuchdrinking.util;

import org.junit.Test;
import toomuchdrinking.model.Drink;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SuggestedAlcoholTest {

    @Test
    public void shouldReturnRightGrams() {
        final Drink drink = new Drink(4.7D, 1, 946);
        final String consumedGrams = String.format("%.1f", SuggestedAlcohol.calculateConsumedGrams(drink));
        assertThat(consumedGrams, is("35.1"));
    }

}