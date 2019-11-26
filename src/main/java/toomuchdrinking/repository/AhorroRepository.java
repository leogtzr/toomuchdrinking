package toomuchdrinking.repository;

import org.springframework.data.repository.CrudRepository;
import toomuchdrinking.bean.Ahorro;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface AhorroRepository extends CrudRepository<Ahorro, Long> {
    Optional<Ahorro> findByDate(Date date);
    List<Ahorro> findAllByDate(Date date);
}
