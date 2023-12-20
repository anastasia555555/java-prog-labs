import Enums.HardnessLevel;

class SemiPreciousGemstone extends Gemstone {
    private HardnessLevel hardness;

    public SemiPreciousGemstone(String name, double weight, double pricePerCarat, double transparency, HardnessLevel hardness) {
        super(name, weight, pricePerCarat, transparency);
        this.hardness = hardness;
    }

    public HardnessLevel getHardness() {
        return hardness;
    }

    public void setHardness(HardnessLevel hardness) {
        this.hardness = hardness;
    }

    public String toString() {
        return super.toString() + "\nHardness: " + hardness.name();
    }
}
