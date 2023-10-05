public abstract class Personnage {

    private String nom;

    private int HP;

    private int dmg;

    public Personnage(String nom, int HP, int dmg){
        this.nom = nom;
        this.HP = HP;
        this.dmg = dmg;
    }

    public int getHP()
    {
        return HP;
    }

    public void setHP(int HP) {
        if(HP < 0)
        {
            this.HP = 0;
        }else {
            this.HP = HP;
        }

    }

    public int getDmg() {
        return dmg;
    }

    public String getNom() {
        return nom;
    }

    public abstract void afficher();

    public void attaquer(Personnage autre)
    {
        System.out.println("attaque!!!");
        //Lorsqu'un personnage attaque un autre personnage, on décrémente les HP de la victime.
        autre.setHP(autre.getHP() - this.getDmg());
    }

    public String toString(){
        return this.nom + " : " + this.HP;
    }

}
