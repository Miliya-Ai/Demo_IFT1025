public class Pokemon extends Personnage {


	public Pokemon(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}


	public void afficher(){
		if (super.getHP()!=0) {

			System.out.println(
					"   ___\r\n"
							+ "  (ô.ô)\r\n"
							+ "   -v-\r\n"
							+ " <(   )>\r\n"
							+ "  (___)\r\n"
							+ "   m m");
		} else {
			System.out.println(
					"    -------\r\n"
							+ "  -/       \\-\r\n"
							+ " /           \\\r\n"
							+ " +-----O-----+\r\n"
							+ " \\.........../\r\n"
							+ "  -\\......./-\r\n"
							+ "    -------");
		}
	}

	/*
	 * Redéfinir également la méthode toString() de Pokemon pour qu'elle ajoute :

    Nom : HP (capturé)

	Dans le cas où le pokémon est capturé
	 * */

	public String toString() {
		String toReturn = super.toString();
		if(super.getHP()==0) {
			toReturn+=" (capturé)";
		}
		return toReturn;
	}

	/*
	 * 
5. Surchargez la fonction attaquer() de Pokemon :

attaquer(Pokemon autre)

Lorsqu'on demande à un Pokemon d'attaquer à un autre Pokemon, il ne
l'attaque pas et dit plutôt (à coups de System.out.println) :

    Pika pika pika pika !!
	 */

	
	public void attaquer(Pokemon autre){
		System.out.println("Pika pika pika pika !!");
	}


	public static void main(String[] args) {
		//		6. Que se passe-t-il si on exécute ce code ?

		Personnage[] ennemis = new Personnage[2];

		ennemis[0] = new Humain("Jimmy Whooper");
		ennemis[1] = new Pokemon("Squirtle"); // ATTN ici meme si c'est un pokemon, le type de REFERENCE est Personnage 
		
		Pokemon newSquirtle = new Pokemon("newSquirtle");
		
		Pokemon pokemon = new Pokemon("Pikachu");

		/*System.out.println(ennemis[0].toString()); // Jimmy Whooper
		System.out.println(ennemis[1].toString()); // Squirtle
		System.out.println(newSquirtle.toString()); // Squirtle
		ennemis[0].afficher();  // dessin
		ennemis[1].afficher();  //dessin 
		newSquirtle.afficher();
		System.out.println(pokemon);  //Pikachu


		pokemon.attaquer(ennemis[0]); //Pikachu attaque Jimmy Whooper*/
		pokemon.attaquer(ennemis[1]);  //Pikachu attaque Squirtle (censé refuser mais attaque qd meme) 
		//pokemon.attaquer(newSquirtle); // refuse

		//System.out.println(ennemis[0].toString()); // Jimmy Whooper (après attaque)
		System.out.println(ennemis[1].toString()); // Squirtle (après attaque)
		//System.out.println(newSquirtle.toString()); //new Squirtle (après attaque) - pas réellement attaqué
		//ennemis[0].afficher(); // dessin Jimmy Whooper (après attaque)
		ennemis[1].afficher(); // dessin Squirtle (après attaque)
		/*newSquirtle.afficher(); // dessin newSquirtle (après attaque) - pas réellement attaqué


		System.out.println("========================================");
		//		Expliquer ce qui se passe


		//		Trouver une façon de faire fonctionner "correctement" :

// c'est pcq dans les arguments, *normalement* ça prend la version la plus spécifique.
// mais ça regarde la REFERENCE et non pas le type instance
// comme Squirtle a été instancé comme Personnage comme REFERENCE, alors le prgm va le voir comme Personnage
// Donc il va prendre la méthode de Personnage
// diapo 87 de 04-Héritage
		pokemon.attaquer(ennemis[0]); // Attaque l'Humain
		pokemon.attaquer(newSquirtle); // Refuse d'attaquer le Pokemon*/
	}
}
