package toomuchdrinking.bean;

public class MillilitersPerDay {

    private String drinkDate;
    private int mls;

    public String getDrinkDate() {
        return drinkDate;
    }

    public void setDrinkDate(final String drinkDate) {
        this.drinkDate = drinkDate;
    }

    public int getMls() {
        return mls;
    }

    public void setMls(final int mls) {
        this.mls = mls;
    }

    @Override
    public String toString() {
        return "MillilitersPerDay{" +
                "drinkDate='" + drinkDate + '\'' +
                ", mls=" + mls +
                '}';
    }
}
