import java.util.List;

public class App {
    public static void main(String[] args) {
        
        // Variant 5
        // Визначити ієрархію дорогоцінного та напівкоштовного каміння. Відібрати
        // камені для намиста. Порахувати загальну вагу (у каратах) і вартість намиста.
        // Провести сортування каміння намиста за цінністю. Знайти каміння в намисто,
        // що відповідає заданому діапазону параметрів прозорості.

        Necklace necklace = new Necklace();
        necklace.seedValues();

        necklace.addGemstone(new PreciousGemstone("Sapphire", 0.2, 7000, 0.2, 1));

        System.out.println("Total Weight: " + necklace.calculateTotalWeight() + " carats");
        System.out.println("Total Value: $" + necklace.calculateTotalValue());

        necklace.sortStonesByValue();
        for (Gemstone stone : necklace.getStones()) {
            System.out.println("---------------------------");
            System.out.println(stone.toString());
            System.out.println("\nTotal value: " + stone.calculateValue());
        }

        double minTransparency = 0.9;
        double maxTransparency = 1;
        List<Gemstone> transparentStones = necklace.findStonesByTransparency(minTransparency, maxTransparency);

        System.out.println("Stones with transparency between " + minTransparency + " and " + maxTransparency + ":");
        for (Gemstone stone : transparentStones) {
            System.out.println("---------------------------");
            System.out.println(stone.getName());
            System.out.println(stone.getTransparency());
        }
    }
}

