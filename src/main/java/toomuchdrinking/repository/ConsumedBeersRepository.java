package toomuchdrinking.repository;

import toomuchdrinking.bean.*;

import java.sql.SQLException;
import java.util.List;

public interface ConsumedBeersRepository {
    void save(String type, int qty, int milliliters, double abv, String description) throws SQLException;
    List<Drink> findAll() throws SQLException;
    List<DrinkType> drinkTypes() throws SQLException;
    List<MillilitersPerDay> mlsPerDay() throws SQLException;
}
