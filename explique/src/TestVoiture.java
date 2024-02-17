import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestVoiture {
    // la déclaration d'un tableau de voitures
    public static Voiture analyseLigne(String ligne) {
        String[] val = ligne.split(";");
        // trim() enlève les espaces en début et fin de chaîne
        return new Voiture(val[0].trim(), Integer.parseInt(val[1].trim()), Double.parseDouble(val[2].trim()), Double.parseDouble(val[3].trim()));
    }

    public static int lireFichier (Voiture[] t, String nomFichier) throws IOException {
        Voiture auto;
        int n = 0;

        Scanner in = new Scanner(new BufferedReader(new FileReader(nomFichier)));

        while (in.hasNext()) {
            String ligne = in.nextLine();
            t[n] = analyseLigne(ligne);
            System.out.println(t[n]);
            n++;
        }
        return n;
    }

    // une méthode pour parcourir tous les objets Voiture du tableau tabAuto et
    // retourner la Voiture qui consommera la plus petite quantité d'essence pour un trajet dont
    // la portion de ville et la portion de route seront passés en paramètres.
    public static Voiture moinsDeGas(Voiture []t, int n, double ville, double route){
        int i, ind = 0;
        double min = t[0].consTrajet(ville, route);
        for (i = 0; i < n; i++) {
            if (t[i].consTrajet(ville, route) < min) {
                min = t[i].consTrajet(ville, route);
                ind = i;
            }
        }
        return t[ind];
    }

    public static void main(String[] args) throws IOException {

        Voiture[] tabAuto = new Voiture[25];
        int nbVoitures = lireFichier(tabAuto, "explique/auto");

        System.out.println(nbVoitures);

        int nb6cyl = 0;
        Voiture[] tab6cyl = new Voiture[25];
        int i;
        for (i = 0; i < nbVoitures; i++) {
            if (tabAuto[i].getNbCulindres() == 6) {
                tab6cyl[nb6cyl] = tabAuto[i];
                nb6cyl++;
            }
        }
        Voiture champion = moinsDeGas(tabAuto, nbVoitures, 100, 2245);

        int j = 0;
        Voiture bidon = new Voiture("toroto Camix", 6);
        while (j < nb6cyl && !tab6cyl[j].equals(bidon)) {
            j++;
        }
        if (j != nb6cyl) {
            JOptionPane.showMessageDialog(null, "oui, il y a une voiture avec 6 cylindres");
        } else {
            JOptionPane.showMessageDialog(null, "Pas de voiture avec 6 cylindres");
        }
    }
}