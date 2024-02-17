public class Voiture{
     // autre champ à déclarer ici
    private String nom;
    private int nbCylindres; //No de cylindres du moteur
    //Consommation d'essence en litres/100km en ville ainsi que sur la route
    private double consVille, consRoute;

    // Déclarez un champs, de la classe Voiture, qui sera commun pour tous les objects Voiture,
    // représentant la consommation minimum de l'ensemble des voitures.
    // la valeur devra être modifiée dès la première comparasioné
    private static double consMin = 100;

    //constructeur, la valeur devra changer si une des 2 consommations(ville ou route) est >=0 et plus petite que la valeur courante de consMin
    public Voiture(String nom, int nbCylindres, double consVille, double consRoute){
        this.nom = nom;
        this.nbCylindres = nbCylindres;
        this.consVille = consVille;
        this.consRoute = consRoute;
        if(consVille >= 0 && consVille < consMin){
            consMin = consVille;
        }
        if(consRoute >= 0 && consRoute < consMin){
            consMin = consRoute;
        }
    }

    public int getNbCulindres(){
        return nbCylindres;
    }

    //un constructeur qui prend en paramètre le nom et le nombre de cylindres
    public Voiture(String nom, int nbCylindres){
        // consVille et consRoute sont initialisés à -1 pour indiquer que ces valeurs ne sont pas encore connues
        this(nom, nbCylindres, -1, -1);
    }

    //Redéfinition de la méthode equals héritée de Object
    // 2 voitures sont égales si le nom est identique ainsi que le nombre de cylindres
    public boolean equals(Object o){
        if(o instanceof Voiture){
            Voiture autre = (Voiture) o;
            return nom.equals(autre.nom) && nbCylindres == autre.nbCylindres;
        }
        return this == o;
    }

    // Présumez que la méthode toString a bien été redéfinie et retourne une chaîne avec les informations de la voiture

    //Méthode va calculer le nombre estimé de litres d'essence nécessaires pour compléter un trajet
    public double consTrajet(double ville, double route){
        // consVille divis
        return consVille / 100 * ville + consRoute / 100 * route;
    }
}
