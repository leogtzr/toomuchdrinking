package toomuchdrinking.repository;

import toomuchdrinking.bean.Need;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcConsumedBeersRepository implements ConsumedBeersRepository {

    private static final String INSERT_COMMENT =
            "INSERT INTO COMMENTS (when, comment) values(?, ?)";

    @Autowired
    private JdbcTemplate template;

    @Override
    public void save(final String when, final String comment) throws SQLException {
        template.update(INSERT_COMMENT, new Object[] {when, comment});
    }

    @Override
    public List<Need> findAll() throws SQLException {
        final List<Need> nds = template.query("select * from comments", (rs, i) -> {
            final Need need = new Need();
            need.setComment(rs.getString("comment"));
            need.setDate(rs.getString("when"));
            return need;
        });
        return nds;
    }

}
