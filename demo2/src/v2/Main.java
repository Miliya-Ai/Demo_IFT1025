package v2;


public class Main {
    public static void main(String[] args) {
        Villageois[] population = new Villageois[] {
                new Villageois("Jean", "Til", 38),
                new Villageois("Roxanne", "PotDeVin", 16),
                new Villageois("Jeanne", "Manse", 27),
                new Villageois("Paul", "Picard", 44),
                new Villageois("Stéphane", "ChampsGauche", 10),
                new Villageois("Annie", "Tyr", 78),
        };

        Village progLand = new Village("ProgLand", population);

        System.out.println(progLand);
    }
}
