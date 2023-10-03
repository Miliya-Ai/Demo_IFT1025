public class Humain extends Personnage {

    public Humain(String nom, int HP, int dmg){
        super(nom, HP, dmg);
    }

    public void afficher(){
        if(this.getHP() == 0){
            System.out.println("       -----\n" +
                    "      ( x.x )\n" +
                    "       -----\n" +
                    "         |\n" +
                    "      <--|-->\n" +
                    "        / \\\n" +
                    "       /   \\\n");
        }else
        {
            System.out.println("       -----\n" +
                    "      ( o.o )\n" +
                    "       -----\n" +
                    "         |\n" +
                    "      <--|-->\n" +
                    "        / \\\n" +
                    "       /   \\");
            }
        }

}
