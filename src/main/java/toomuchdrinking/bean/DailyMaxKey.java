package toomuchdrinking.bean;

import java.sql.Date;
import java.util.Objects;

public class DailyMaxKey {

    private Date date;
    private double grams;

    public DailyMaxKey(final Date date, final double grams) {
        this.date = date;
        this.grams = grams;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(final double grams) {
        this.grams = grams;
    }

    @Override
    public String toString() {
        return String.format("%s -  %.1fg", date, grams);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DailyMaxKey that = (DailyMaxKey) o;
        return Double.compare(that.grams, grams) == 0 && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, grams);
    }
}
