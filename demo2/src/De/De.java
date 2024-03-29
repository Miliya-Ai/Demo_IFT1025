package De;

import java.util.Random;

public class De {
    private int nombreFaces;
    private Random rand;

    /**
     * Constructeur de la classe De
     * @param nombreFaces nombre de faces du dé
     */
    public De(int nombreFaces) {
        this.nombreFaces = nombreFaces;
        this.rand = new Random();
    }

    /**
     * Lance le dé et retourne le résultat
     * @return le résultat du lancé de dé
     */
    public int lancerDe() {
        // Génère un nombre aléatoire entre 1 et le nombre de faces du dé inclus
        return rand.nextInt(nombreFaces) + 1;
    }

    public static void main(String[] args) {
        De d = new De(6);
        System.out.println(d.lancerDe());
    }
}

