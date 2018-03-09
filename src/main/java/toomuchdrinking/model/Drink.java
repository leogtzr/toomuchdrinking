package toomuchdrinking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DRINKS")
public class Drink {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "DRINK_ID")
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="DRINK_TYPE_ID", referencedColumnName="DRINK_TYPE_ID")
	@JsonIgnore
    private DrinkType drinkType;
    
    private double abv;
    private java.sql.Date drinkDate;
    private String description;
    private int quantity;
    private int milliliters;
    
    protected Drink() {}

    public Drink(final double abv, final java.sql.Date drinkDate, 
    		final String description, final int quantity, 
    		final int milliliters, final DrinkType drinkType) {
		this.abv = abv;
		this.drinkDate = drinkDate;
		this.description = description;
		this.quantity = quantity;
		this.milliliters = milliliters;
		this.drinkType = drinkType;
	}
        
	public DrinkType getDrinkType() {
		return drinkType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	public java.sql.Date getDrinkDate() {
		return drinkDate;
	}

	public void setDrinkDate(java.sql.Date drinkDate) {
		this.drinkDate = drinkDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMilliliters() {
		return milliliters;
	}

	public void setMilliliters(int milliliters) {
		this.milliliters = milliliters;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", abv=" + abv + ", drinkDate=" + drinkDate + ", description=" + description
				+ ", quantity=" + quantity + ", milliliters=" + milliliters + ", drinkType=" + drinkType + "]";
	}

}
