package toomuchdrinking.bean;

import java.util.Date;

public class MillilitersPerDay {

    private Date drinkDate;
    private long mls;
    private double abv;

    public MillilitersPerDay(final Date drinkDate, final long mls) {
        this.drinkDate = drinkDate;
        this.mls = mls;
    }

    public Date getDrinkDate() {
        return drinkDate;
    }

    public void setDrinkDate(final Date drinkDate) {
        this.drinkDate = drinkDate;
    }

    public long getMls() {
        return mls;
    }

    public void setMls(final long mls) {
        this.mls = mls;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(final double abv) {
        this.abv = abv;
    }

    @Override
    public String toString() {
        return "MillilitersPerDay{" +
                "drinkDate=" + drinkDate +
                ", mls=" + mls +
                ", abv=" + abv +
                '}';
    }
}
