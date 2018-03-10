package toomuchdrinking.bean;

public class MapperToCalculateGrams {
    private final double abv;
    private final int mls;

    public MapperToCalculateGrams(final double abv, final int mls) {
        this.abv = abv;
        this.mls = mls;
    }

    public double getAbv() {
        return abv;
    }

    public int getMls() {
        return mls;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "abv=" + abv +
                ", mls=" + mls +
                '}';
    }
}