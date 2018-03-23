package toomuchdrinking.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DRINK_TYPE")
public class DrinkType {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DRINK_TYPE_ID")
    private Long id;
	
	@Column(name = "TYPE")
    private String type;
	
	@OneToMany(mappedBy = "drinkType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Drink> drinks;

    protected DrinkType() {}

	public DrinkType(final String type) {
		this.type = type;
	}

	public DrinkType(final Long id, final String type) {
        this.id = id;
        this.type = type;
    }

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}
	
	public Set<Drink> getDrinks() {
		return drinks;
	}

	@Override
	public String toString() {
		return "DrinkType [id=" + id + ", type=" + type + "]";
	}	
	
}
