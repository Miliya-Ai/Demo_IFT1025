public class Pokemon extends Personnage {

    private boolean estCapture;

    public Pokemon(String nom, int HP, int dmg){
        super(nom, HP, dmg);
        estCapture = false;
        if(this.getHP() == 0)
        {
            estCapture = true;
        }
    }

    public void setHP(int HP)
    {
        super.setHP(HP);
        if(this.getHP() == 0)
        {
            estCapture = true;
        }
    }

    	/*
	 *
5. Surchargez la fonction attaquer() de Pokemon :

attaquer(Pokemon autre)

Lorsqu'on demande à un Pokemon d'attaquer à un autre Pokemon, il ne
l'attaque pas et dit plutôt (à coups de System.out.println) :

    Pika pika pika pika !!
	 */

    // 就只是皮卡丘的话
    /*public void attaquer(Pokemon autre){
        System.out.println("Pika pika pika pika !!");
    }*/
    public void attaquer(Personnage autre)
    {
        if(autre instanceof Pokemon) //verifie si autre est un Pokemon ou non
        {
            System.out.println(this.getNom() + " " + this.getNom() + " " + this.getNom() + " " + this.getNom() + " !!" );
        }else{
            super.attaquer(autre);
        }

    }

    public void afficher() {
        if (estCapture) {
            System.out.println("    -------\n" +
                    "  -/       \\-\n" +
                    " /           \\\n" +
                    " +-----O-----+\n" +
                    " \\.........../\n" +
                    "  -\\......./-\n" +
                    "    -------");
        } else {
            System.out.println("   ___\n" +
                    "  (ô.ô)\n" +
                    "   -v-\n" +
                    " <(   )>\n" +
                    "  (___)\n" +
                    "   m m");
        }
    }

    /*Redéfinir également la méthode toString() de Pokemon pour qu'elle ajoute :

    Nom : HP (capturé)

    Dans le cas où le pokémon est capturé*/
    public String toString()
    {
        return super.toString() + (estCapture ? " (capturé)" : "");
    }

}