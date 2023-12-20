import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Enums.HardnessLevel;

class Necklace {
    private List<Gemstone> stones = new ArrayList<Gemstone>();

    public void addGemstone(Gemstone gemstone) {
        stones.add(gemstone);
    }

    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (Gemstone stone : stones) {
            totalWeight += stone.getWeight();
        }
        return totalWeight;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        for (Gemstone stone : stones) {
            totalValue += stone.calculateValue();
        }
        return totalValue;
    }

    public void sortStonesByValue() {
        Collections.sort(stones, Comparator.comparingDouble(Gemstone::calculateValue).reversed());
    }

    public List<Gemstone> getStones() {
        return stones;
    }

    public List<Gemstone> findStonesByTransparency(double minTransparency, double maxTransparency) {
        List<Gemstone> result = new ArrayList<>();
        for (Gemstone stone : stones) {
            if(stone.getTransparency() > minTransparency 
            && stone.getTransparency() < maxTransparency) {
                result.add(stone);
            }
        }
        return result;
    }

    public void seedValues() {
    
    PreciousGemstone diamond = new PreciousGemstone("Diamond", 2.5, 15000, 0.96, 0.97);
    PreciousGemstone diamond1 = new PreciousGemstone("Diamond", 2.0, 15000, 0.99, 0.96);
    PreciousGemstone diamond2 = new PreciousGemstone("Diamond", 1.8, 18000, 0.99, 0.99);
    PreciousGemstone sapphire = new PreciousGemstone("Sapphire", 3.5, 8000, 0.78, 0.89);
    PreciousGemstone ruby = new PreciousGemstone("Ruby", 2.2, 12000, 0.5, 0.8);
    PreciousGemstone emerald = new PreciousGemstone("Emerald", 2.8, 16000, 0.4, 0.95);


    SemiPreciousGemstone amethyst = new SemiPreciousGemstone("Amethyst", 1.8, 500, 0.2, HardnessLevel.SEMI_HARD);
    SemiPreciousGemstone amethyst1 = new SemiPreciousGemstone("Amethyst", 1.5, 200, 0.1, HardnessLevel.SEMI_HARD);
    SemiPreciousGemstone citrine = new SemiPreciousGemstone("Citrine", 2.2, 180, 0.56, HardnessLevel.HARD);
    SemiPreciousGemstone aquamarine = new SemiPreciousGemstone("Aquamarine", 3.0, 150, 0.16, HardnessLevel.HARD);
    SemiPreciousGemstone garnet = new SemiPreciousGemstone("Garnet", 1.8, 120, 0.17, HardnessLevel.SOFT);
    SemiPreciousGemstone peridot = new SemiPreciousGemstone("Peridot", 2.5, 160, 0.98, HardnessLevel.SOFT);

    stones.add(diamond);
    stones.add(diamond1);
    stones.add(diamond2);
    stones.add(sapphire);    
    stones.add(ruby);
    stones.add(emerald);    
    stones.add(amethyst);
    stones.add(amethyst1);    
    stones.add(citrine);
    stones.add(aquamarine);    
    stones.add(garnet);
    stones.add(peridot);
    
}
}
