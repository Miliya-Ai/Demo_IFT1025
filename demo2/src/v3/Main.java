package v3;

@SuppressWarnings("DuplicatedCode")
public class Main {
    public static void main(String[] args) {
        double tauxImpot = 0.1; // 10%

        Villageois[] population = {
                new Villageois("Jean", "Til", 38),
                new Villageois("Roxanne", "PotDeVin", 16),
                new Villageois("Jeanne", "Manse", 27),
                new Villageois("Paul", "Picard", 44),
                new Villageois("Stéphane", "ChampsGauche", 10),
                new Villageois("Annie", "Tyr", 78),
        };

        Village progLand = new Village("ProgLand", population);
        System.out.println("Fonds publics initiaux: " + progLand.getFondsPublics() + "$");
        System.out.println(progLand);
        System.out.println();

        for (int i = 0; i < 5; i++) {  // récolter le taux d'impôts sur 5 ans
            progLand.avancerUnAn();
            progLand.recolterImpot(tauxImpot);
        }

        System.out.println();
        System.out.println("Fonds publics finaux: " + progLand.getFondsPublics() + "$"); // 2929.1631000000007$
        System.out.println(progLand);
    }
}
