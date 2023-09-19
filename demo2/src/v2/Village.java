package v2;

import java.util.Arrays;

@SuppressWarnings({"FieldMayBeFinal", "unused", "FieldCanBeLocal"})
public class Village {
    private final Villageois[] population;
    private String nom;

    private double fondsPublics = 0;

    public Village(String nom, Villageois[] population) {
        this.nom = nom;
        this.population = population;
    }

    public double getFondsPublics() {
        return fondsPublics;
    }

    public Villageois[] getPopulation() {
        return population;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom + "(" +
                "fondsPublics=" + fondsPublics +
                ", population=" + Arrays.toString(population) +
                ')';
    }
}
