package toomuchdrinking.bean;

import java.util.List;

import toomuchdrinking.model.Drink;

public class DrinkResponse {

    private boolean ok;
    private List<Drink> drinks;

    public DrinkResponse() {}

    public DrinkResponse(boolean ok, final List<Drink> drinks) {
        this.ok = ok;
        this.drinks = drinks;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(final boolean ok) {
        this.ok = ok;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(final List<Drink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "DrinkResponse{" +
                "ok=" + ok +
                ", drinks=" + drinks +
                '}';
    }
}
