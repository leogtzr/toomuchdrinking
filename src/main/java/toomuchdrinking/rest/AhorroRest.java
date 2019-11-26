package toomuchdrinking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import toomuchdrinking.bean.Ahorro;
import toomuchdrinking.repository.AhorroRepository;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/ahorro")
public class AhorroRest {

    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final DateFormat DRINK_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private AhorroRepository ahorroRepository;

    @GetMapping(value = {"/", "/view", "/info"})
    public String ahorro() {
        return ahorroRepository.count() + "";
    }

    @PostMapping("amount")
    public String addAmount(
            final @RequestParam("amount") String amount
    ) {

        final Date date = new Date(CALENDAR.getTime().getTime());
        final List<Ahorro> amountsByDate = ahorroRepository.findAllByDate(date);

        final boolean sameAmount = amountsByDate
                .stream()
                .anyMatch(a -> a.getAmount() == Double.valueOf(amount));

        final Ahorro ahorro = new Ahorro();
        ahorro.setDate(date);
        ahorro.setAmount(Double.valueOf(amount));

        // already in the DB, do not do anything ...
        if (sameAmount) {
            return String.format("%s-(NOT-UPDATED)", ahorro);
        }

        ahorroRepository.save(ahorro);
        return String.format("%s-(UPDATED)", ahorro);
    }

}
