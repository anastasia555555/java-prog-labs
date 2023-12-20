public class GemstoneNode {

    public GemstoneNode(Gemstone gemstone) {
        this.gem = gemstone;
    }

    public GemstoneNode() {
        gem = null;
    }

    private Gemstone gem;
    private GemstoneNode nextNode;

    public Gemstone getGemstone() {
        return gem;
    }

}