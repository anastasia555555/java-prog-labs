import java.util.Arrays;
import java.util.Comparator;

class Airport{
    public static void main(String[] args){

        // Клас - Plane
        //
        // Відсортувати масив, за одним з полів, 
        // за зростанням, а за іншим, за спаданням використавши 
        // при цьому стандартні засоби сортування.
        try {

            Plane[] planes = new Plane[10];

            planes[0] = new Plane("Boeing 747", "ABC123", 900.0, 50000.0);
            planes[1] = new Plane("Airbus A380", "DEF456", 850.0, 55000.0);
            planes[2] = new Plane("Cessna 172", "GHI789", 150.0, 2000.0);
            planes[3] = new Plane("Bombardier Global 7500", "JKL012", 950.0, 70000.0);
            planes[4] = new Plane("Embraer Phenom 300", "MNO345", 600.0, 5000.0);
            planes[5] = new Plane("Boeing 787", "PQR678", 900.0, 60000.0);
            planes[6] = new Plane("Airbus A320", "STU901", 800.0, 45000.0);
            planes[7] = new Plane("Gulfstream G650", "VWX234", 1000.0, 80000.0);
            planes[8] = new Plane("Cirrus SR22", "YZA567", 200.0, 1500.0);
            planes[9] = new Plane("Dassault Falcon 7X", "BCD890", 950.0, 65000.0);     

            Arrays.sort(planes, Comparator.comparing(Plane::getModel));

            System.err.println("SORTED BY MODEL");
            for (Plane plane : planes) {
                plane.print();
            }

            Arrays.sort(planes, Comparator.comparing(Plane::getMaxSpeed).reversed());

            System.out.println("\n\nSORTED BY MAXIMUM SPEED");
            for (Plane plane : planes) {
                plane.print();
            }

        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
