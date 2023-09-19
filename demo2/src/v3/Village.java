package v3;

import java.util.Arrays;

@SuppressWarnings({"FieldMayBeFinal", "unused", "ForLoopReplaceableByForEach"})
public class Village {
    private Villageois[] population;
    private String nom;

    private double fondsPublics = 0;

    public Village(String nom, Villageois[] population) {
        this.nom = nom;
        this.population = population;
    }

    public void avancerUnAn() {
        for (int i = 0; i < population.length; i++) {
            Villageois villageois = population[i];
            villageois.vieillir(1);
            villageois.recevoirArgent(10 * villageois.getAge());
        }
    }

    public void recolterImpot(double tauxImpot) {
        double impotsRecoltees = 0;
        for (int i = 0; i < population.length; i++) {
            Villageois villageois = population[i];
            if (villageois.getAge() >= 20) {
                impotsRecoltees += villageois.payerImpot(tauxImpot);
            }
        }
        fondsPublics += impotsRecoltees;
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
