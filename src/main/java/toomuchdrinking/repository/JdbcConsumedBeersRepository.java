package toomuchdrinking.repository;

import toomuchdrinking.bean.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import toomuchdrinking.bean.DrinkType;

import java.sql.SQLException;
import java.time.*;
import java.time.format.*;
import java.util.List;

@Repository
public class JdbcConsumedBeersRepository implements ConsumedBeersRepository {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    private static final String INSERT_DRINK =
            "INSERT INTO Drinks(drink_date, type, qty, milliliters, abv, description) values (?, ?, ?, ?, ?, ?);"
            ;

    @Autowired
    private JdbcTemplate template;

    @Override
    public void save(
            final String type,
            final int qty,
            final int milliliters,
            final double abv,
            final String description
    ) throws SQLException {
        template.update(INSERT_DRINK,
                new Object[]{formatter.format(ZonedDateTime.now()), type, qty, milliliters, abv, description});
    }

    @Override
    public List<Drink> findAll() throws SQLException {
        final List<Drink> drinks = template.query("select * from Drinks", (rs, i) -> {
            final Drink drink = new Drink();
            drink.setAbv(rs.getDouble("abv"));
            drink.setMilliliters(rs.getInt("milliliters"));
            drink.setDescription(rs.getString("description"));
            drink.setQuantity(rs.getInt("qty"));
            return drink;
        });
        return drinks;
    }

    @Override
    public List<DrinkType> drinkTypes() throws SQLException {
        final List<DrinkType> types = template.query("select * from DrinkType", (rs, i) -> {
            final DrinkType type = new DrinkType();
            type.setId(rs.getInt("id"));
            type.setDrink(rs.getString("type"));
            return type;
        });
        return types;
    }

}
