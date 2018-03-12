package toomuchdrinking.bean;

public class MapperToCalculateGrams {

    private final double abv;
    private final int mls;
    private final int quantity;

    public MapperToCalculateGrams(final double abv, final int mls, final int quantity) {
        this.abv = abv;
        this.mls = mls;
        this.quantity = quantity;
    }

    public double getAbv() {
        return abv;
    }

    public int getMls() {
        return mls;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "MapperToCalculateGrams{" +
                "abv=" + abv +
                ", mls=" + mls +
                ", quantity=" + quantity +
                '}';
    }
}