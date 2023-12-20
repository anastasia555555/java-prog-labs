class Gemstone {
    private String name;
    private double weight;
    private double pricePerCarat;
    private double transparency;

    public Gemstone(String name, double weight, double pricePerCarat, double transparency) {
        this.name = name;
        this.weight = weight;
        this.pricePerCarat = pricePerCarat;
        this.transparency = transparency;
    }

    public double calculateValue() {
        return weight * pricePerCarat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerCarat() {
        return pricePerCarat;
    }

    public void setPricePerCarat(double pricePerCarat) {
        this.pricePerCarat = pricePerCarat;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    @Override public String toString() {
        return "Gemstone Name: " + name +
            "\nWeight: " + weight + " carats" +
            "\nPrice per Carat: $" + pricePerCarat +
            "\nTransparency: " + transparency;
    }
}
