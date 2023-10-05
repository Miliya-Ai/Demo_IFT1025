public abstract class Personnage {
    /*Démonstration #03
     Insister sur le fait que l'indentation est automatisée dans les IDEs
     et qu'il n'y a pas d'excuse pour remettre un code non-indenté...

     Mentionner qu'il faudrait commencer à utiliser la JavaDoc.

     1. Écrire une classe abstraite Personnage

     Un personnage a une représentation ASCII et un nom

     Le constructeur devrait être : public Personnage(String nom)

     La méthode personnage.afficher() devrait afficher la tête, le corps et
     les jambes*/

    private String nom;

    private int HP;

    // 下面这两个属性可以要可以不要
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

    /*3. Ajouter une méthode attaquer(Personnage autre) et un attribut HP
	(health points) dans la classe abstraite Personnage

    Lorsqu'un personnage attaque un autre personnage, on décrémente les HP
    de la victime.

    Lorsque les HP d'un Pokemon tombent à 0, il devient capturé

    Lorsque les HP d'un Humain tombent à 0, sa représentation ASCII
    devient :

            -----
            ( x.x )
            -----
            |
	      <--|-->
            / \
            /   \*/
    public void attaquer(Personnage autre)
    {
        System.out.println("attaque!!!");
        //Lorsqu'un personnage attaque un autre personnage, on décrémente les HP
        //		de la victime.
        autre.setHP(autre.getHP() - this.getDmg());
    }

    /*4. Redéfinir la méthode toString() de Personnage pour qu'elle
    affiche :
    Nom : HP

    Avec le nom et le nombre de HP du personnage

    Tester tout ça dans le main()*/
    public String toString(){
        return this.nom + " : " + this.HP;
    }

}
