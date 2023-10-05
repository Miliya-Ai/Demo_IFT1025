public class Main {
    //		6. Que se passe-t-il si on exécute ce code ?
    public static void main(String[] args) {
        Personnage[] ennemis = new Personnage[2];

        ennemis[0] = new Humain("Jimmy Whooper", 100, 100);
        ennemis[1] = new Pokemon("Squirtle", 100, 100);
        // ATTN ici meme si c'est un pokemon, le type de REFERENCE est Personnage

        Pokemon pokemon = new Pokemon("Pikachu", 100, 100);
        Pokemon newSquirtle = new Pokemon("newSquirtle", 100, 100);

        //pokemon.attaquer(ennemis[0]);
        pokemon.attaquer(ennemis[1]);
        //pokemon.attaquer(newSquirtle);

        System.out.println(ennemis[1].toString());


        /*
        * Personnage[] ennemis = new Personnage[2];

		ennemis[0] = new Humain("Jimmy Whooper");
		ennemis[1] = new Pokemon("Squirtle"); // ATTN ici meme si c'est un pokemon, le type de REFERENCE est Personnage

		Pokemon newSquirtle = new Pokemon("newSquirtle");

		Pokemon pokemon = new Pokemon("Pikachu");

		System.out.println(ennemis[0].toString()); // Jimmy Whooper
		System.out.println(ennemis[1].toString()); // Squirtle
		System.out.println(newSquirtle.toString()); // Squirtle
		ennemis[0].afficher();  // dessin
		ennemis[1].afficher();  //dessin
		newSquirtle.afficher();
		System.out.println(pokemon);  //Pikachu


		pokemon.attaquer(ennemis[0]); //Pikachu attaque Jimmy Whooper
		pokemon.attaquer(ennemis[1]);  //Pikachu attaque Squirtle (censé refuser mais attaque qd meme)
		pokemon.attaquer(newSquirtle); // refuse

		System.out.println(ennemis[0].toString()); // Jimmy Whooper (après attaque)
		System.out.println(ennemis[1].toString()); // Squirtle (après attaque)
		System.out.println(newSquirtle.toString()); //new Squirtle (après attaque) - pas réellement attaqué
		ennemis[0].afficher(); // dessin Jimmy Whooper (après attaque)
		ennemis[1].afficher(); // dessin Squirtle (après attaque)
		newSquirtle.afficher(); // dessin newSquirtle (après attaque) - pas réellement attaqué


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
