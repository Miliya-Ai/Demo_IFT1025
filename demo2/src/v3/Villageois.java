package v3;

@SuppressWarnings({"FieldMayBeFinal", "unused"})
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

    public void recevoirArgent(double montant) {
        this.argent += montant;
    }

    public double payerImpot(double tauxImpot) {
        double montant = this.argent * tauxImpot;
        this.argent -= montant;
        return montant;
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

    @Override
    public String toString() {
        return prenom + " " + nom + " (age: " + age + " ans, argent: " + argent + "$)";
    }
}
