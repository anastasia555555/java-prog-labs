class PreciousGemstone extends Gemstone {
    private double clarity;

    public PreciousGemstone(String name, double weight, double pricePerCarat, double transparency, double clarity) {
        super(name, weight, pricePerCarat, transparency);
        this.clarity = clarity;
    }

    public double getClarity() {
        return clarity;
    }

    public void setClarity(double clarity) {
        this.clarity = clarity;
    }

    public String toString() {
        return super.toString() + "\nClarity: " + clarity;
    }
}
