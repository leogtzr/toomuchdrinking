package toomuchdrinking.repository;

import org.springframework.data.repository.CrudRepository;
import toomuchdrinking.model.DrinkType;

public interface DrinkTypeRepository extends CrudRepository<DrinkType, Long> {
	
}