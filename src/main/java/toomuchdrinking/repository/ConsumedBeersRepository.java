package toomuchdrinking.repository;

import toomuchdrinking.bean.Need;

import java.sql.SQLException;
import java.util.List;

public interface ConsumedBeersRepository {
    void save(String when, String comment) throws SQLException;
    List<Need> findAll() throws SQLException;
}
