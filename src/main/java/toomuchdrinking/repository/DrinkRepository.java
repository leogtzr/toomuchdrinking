package toomuchdrinking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import toomuchdrinking.bean.MillilitersPerDay;
import toomuchdrinking.model.Drink;

public interface DrinkRepository extends CrudRepository<Drink, Long>, JpaSpecificationExecutor<Drink> {
	@Query(value = "SELECT new toomuchdrinking.bean.MillilitersPerDay(d.drinkDate, SUM(d.quantity * d.milliliters)) FROM Drink d GROUP BY d.drinkDate")
	List<MillilitersPerDay> getMillilitersPerDay();
}
