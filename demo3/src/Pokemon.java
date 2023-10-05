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

    public String toString()
    {
        return super.toString() + (estCapture ? " (capturé)" : "");
    }

}