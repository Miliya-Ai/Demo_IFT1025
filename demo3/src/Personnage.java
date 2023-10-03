public abstract class Personnage {

    private String nom;

    private int HP;
    private int dmg;
    private int maxHP;  //Cet attribut ne sert a rien, mais on pourrait éventuellement l'utiliser si on veut rajouter la
                        //possibilité de soigner un personnage.

    public Personnage(String nom, int HP, int dmg){
        this.nom = nom;
        this.HP = HP;
        this.dmg = dmg;
        this.maxHP = HP;
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
        autre.setHP(autre.getHP() - this.getDmg());
    }

    public String toString(){
        return this.nom + " : " + this.HP;
    }

}
