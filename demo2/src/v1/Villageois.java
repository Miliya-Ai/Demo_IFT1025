package v1;

@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal", "unused"})
public class Villageois {
    private final String prenom, nom;
    private int age;
    private double argent = 100;

    public Villageois(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public void vieillir(int annees) {
        this.age += annees;
    }

    //----------------- Getters && Setters -----------------//
    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public double getArgent() {
        return argent;
    }

    public String getPrenom() {
        return prenom;
    }

}
