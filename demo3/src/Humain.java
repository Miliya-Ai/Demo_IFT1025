public class Humain extends Personnage {
    /*
     *
    2. Écrire une sous-classe Humain et une sous-classe Pokemon

    Leurs représentations ASCII sont les suivantes :

    Humain :

           -----
          ( o.o )
           -----
             |
          <--|-->
            / \
           /   \


    Pokemon :
       ___
      (ô.ô)
       -v-
     <(   )>
      (___)
       m m



    Un pokémon peut être dans un des deux états : capturé ou non.

    Dans le cas où le pokémon est capturé, on va plutôt afficher une
    pokéball comme représentation :


    Pokeball :

        -------
      -/       \-
     /           \
     +-----O-----+
     \.........../
      -\......./-
        -------

     *
     * */
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
