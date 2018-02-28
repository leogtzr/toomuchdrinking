package toomuchdrinking.bean;

public class DrinkType {

    private int id;
    private String drink;

    public DrinkType() {}

    public DrinkType(final int id, final String drink) {
        this.id = id;
        this.drink = drink;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(final String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "DrinkType{" +
                "id=" + id +
                ", drink='" + drink + '\'' +
                '}';
    }
}
