package toomuchdrinking.bean;

public enum DailyMaximumDrinks {
    AUSTRALIA("Australia", 24.0D),
    AUSTRIA("Austria", 24.0D),
    CZECH_REPUBLIC("Czech Republic", 24.0D),
    GERMANY("Germany", 24.0D),
    HONGKONG("Hong Kong", 20.0D),
    ITALY("Italy", 40.0D),
    JAPAN("Japan", 39.5D),
    NETHERLANDS("Netherlands", 10.0D),
    PORTUGAL("Portugal", 37.0D),
    SPAIN("Spain", 30.0D),
    SWEDEN("Sweden", 20.0D),
    SWITZERLAND("Switzerland", 30.0D)
    ;

    private String country;
    private double grams;

    DailyMaximumDrinks(final String country, final double grams) {
        this.country = country;
        this.grams = grams;
    }

    public String getCountry() {
        return country;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public String toString() {
        return String.format("%s (%.1fg)", country, grams);
    }
}
