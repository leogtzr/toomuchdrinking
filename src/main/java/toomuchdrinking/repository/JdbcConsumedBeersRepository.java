package toomuchdrinking.repository;

import toomuchdrinking.bean.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import toomuchdrinking.bean.DrinkType;

import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcConsumedBeersRepository implements ConsumedBeersRepository {

    private static final String INSERT_DRINK =
            "INSERT INTO COMMENTS (when, comment) values(?, ?)";

    @Autowired
    private JdbcTemplate template;

    /*
    @Override
    public void save(final String when, final String comment) throws SQLException {
        // template.update(INSERT_COMMENT, new Object[] {when, comment});
    }*/

    @Override
    public List<Drink> findAll() throws SQLException {
        final List<Drink> drinks = template.query("select * from drinks", (rs, i) -> {
            final Drink drink = new Drink();
            drink.setAbv(rs.getDouble("abv"));

            drink.setDescription(rs.getString("description"));
            drink.setQuantity(rs.getInt("qty"));
            return drink;
        });
        return drinks;
    }

}
