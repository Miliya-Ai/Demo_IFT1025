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

public class Humain extends Personnage {

	public Humain(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public void afficher() {

		if (super.getHP()==0) {
			System.out.println("	       -----\r\n"
					+ "	      ( x.x )\r\n"
					+ "	       -----\r\n"
					+ "	         |\r\n"
					+ "	      <--|-->\r\n"
					+ "	        / \\\r\n"
					+ "	       /   \\");
		} else {
			System.out.println("       -----\r\n"
					+ "      ( o.o )\r\n"
					+ "       -----\r\n"
					+ "         |\r\n"
					+ "      <--|-->\r\n"
					+ "        / \\\r\n"
					+ "       /   \\");
		}
	}

}
