package toomuchdrinking.repository;

import toomuchdrinking.bean.Drink;

import java.sql.SQLException;
import java.util.List;

public interface ConsumedBeersRepository {
    // void save(String when, String comment) throws SQLException;
    List<Drink> findAll() throws SQLException;
}
