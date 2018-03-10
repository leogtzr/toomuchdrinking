package toomuchdrinking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import toomuchdrinking.bean.DailyMaxKey;
import toomuchdrinking.bean.DailyMaximumDrinks;
import toomuchdrinking.bean.MapperToCalculateGrams;
import toomuchdrinking.model.Drink;
import toomuchdrinking.repository.DrinkRepository;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DrinkStatsService {

    private static final double PURE_ALCOHOL = 789.24D;

    @Autowired
    private DrinkRepository drinkRepository;

    public @ResponseBody Map<DailyMaxKey, List<DailyMaximumDrinks>> maximums() {

        final Map<DailyMaxKey, List<DailyMaximumDrinks>> max = new HashMap<>();

        final Iterable<Drink> it = drinkRepository.findAll();
        final Map<Date, List<Drink>> map = StreamSupport.
                stream(it.spliterator(), false).collect(Collectors.groupingBy(Drink::getDrinkDate));

        map.forEach((date, drinks) -> {
            final double grams = drinks.
                    stream().
                    map(drink -> new MapperToCalculateGrams(drink.getAbv(), drink.getMilliliters(), drink.getQuantity())).
                    mapToDouble(m -> (((m.getMls() * m.getQuantity()) / 1000.0D) * ((m.getAbv() / 100.0D) * PURE_ALCOHOL))).sum();
            max.put(new DailyMaxKey(date, grams), passesMaxSuggestedAlcohol(grams));
        });

        return max;
    }

    private static List<DailyMaximumDrinks> passesMaxSuggestedAlcohol(final double grams) {
        return Arrays.stream(DailyMaximumDrinks.values()).
                filter(country -> grams > country.getGrams()).
                collect(Collectors.toList());
    }

}
