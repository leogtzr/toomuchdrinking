package toomuchdrinking.bean;

import java.util.List;

import toomuchdrinking.model.DrinkType;

public class DrinkTypesResponse {

    private boolean ok;
    private List<DrinkType> drinks;

    public boolean isOk() {
        return ok;
    }

    public void setOk(final boolean ok) {
        this.ok = ok;
    }

    public List<DrinkType> getDrinks() {
        return drinks;
    }

    public void setDrinks(final List<DrinkType> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "DrinkTypesResponse{" +
                "ok=" + ok +
                ", drinks=" + drinks +
                '}';
    }
}
