package toomuchdrinking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import toomuchdrinking.model.DrinkType;

import java.util.List;

public interface DrinkTypeRepository extends CrudRepository<DrinkType, Long> {
	@Query(value = "SELECT DISTINCT(type) from drink_type")
    List<String> types();
}