public class ListeCirculaire {

	private Noeud premier;

	private class Noeud { // classe interne 
		public int valeur;
		public Noeud prochain;

		public Noeud(int valeur, Noeud prochain) {
			this.valeur = valeur;
			this.prochain = prochain;
		}
	}

	/**
	 * Retrouve le idx-ème nœud de la chaîne
	 *
	 * @param idx indice du nœud
	 * @return nœud sélectionné
	 */
	private Noeud getNoeud(int idx) {
		Noeud n = this.premier;

		for(int i=0; i<idx; i++) {
			n = n.prochain;
		}

		return n;
	}

	/**
	 * Accède au idx-ème élément
	 *
	 * @param idx indice du nœud
	 * @return valeur du nœud
	 */
	public int get(int idx) {
		return getNoeud(idx % size()).valeur; // e) mobiliser l'operande modulo %
		// pour éviter de tourner en rond plusieurs fois inutilement
	}

	/**
	 * Modifie le idx-ème élément
	 *
	 * @param idx indice du nœud
	 * @param valeur valeur du nœud
	 */
	public void set(int idx, int valeur) {
		getNoeud(idx).valeur = valeur;
	}

	/**
	 * Calcule la taille de la liste chaînée
	 *
	 * @return taille de la liste
	 */
	public int size() {
		
        if (this.premier == null) // <- ajouté ! : checker si size = 0.
            return 0;

		int size = 1;  // <- modifié : compter à partir de 1

		Noeud n = this.premier.prochain;  // <- modifié ! commencer à compter depuis le 2e noeud
		while(n != this.premier) { // au lieu de viser le null, checker si on est de retour à "premier"
			size++;
			n = n.prochain;
		}

		return size;
	}

	/**
	 * Ajoute un élément au début de la liste
	 *
	 * @param valeur valeur du nœud
	 */
	public void addFirst(int valeur) {
		this.premier = new Noeud(valeur, this.premier);
	}

	/**
	 * Ajoute un élément à la fin de la liste
	 *
	 * @param valeur valeur du nœud
	 */
	public void addLast(int valeur) {
		if(this.premier == null) { // Cas 1 : rien dans la liste
			this.premier = new Noeud(valeur, null); 
			this.premier.prochain = this.premier; // <-modifié. s'assurer que prochain n'est pas null.
			// (il pointe vers lui meme, c'est le seul élément)
		} else { // Cas 2 : trouver le nœud final
			Noeud fin = this.premier; // c'est comme un itérateur
			Noeud n = this.premier.prochain;

			while(n != this.premier) { // <-modifié. on ne va pas jusq'a null.
				// on va jusqu'à ce qu'on revienne au "début" du cycle
				fin = n;
				n = n.prochain;
			}

			// Ajoute un nœud après la fin de la liste
			fin.prochain = new Noeud(valeur, this.premier); //<-modifié. prochain pointer will be this.premier instead of null
		}
	}

	/**
	 * Affiche les n premiers éléments de la liste
	 *
	 * @param n nombre d'éléments à afficher
	 */
	public void print(int n) {
		Noeud n2 = this.premier;
		for (int i = 0; i < n; i++) {
			System.out.println(n2.valeur);
			n2 = n2.prochain;
		}
	}

	public ListeCirculaire() {
		// Créez les trois nœuds 1, 2 et 3 dans le constructeur
		this.premier = new Noeud(1, null);
		this.premier.prochain = new Noeud(2, null);
		this.premier.prochain.prochain = new Noeud(3, this.premier);
	}

	public static void main(String[] args) {
		ListeCirculaire liste = new ListeCirculaire();

//		liste.print(5);
//
//		System.out.println("size: " + liste.size());

		System.out.println(liste.get(0)); // => 1
		System.out.println(liste.get(3)); // => 1
		System.out.println(liste.get(33)); // => 1
		System.out.println(liste.get(34)); // => 2
		System.out.println(liste.get(35)); // => 3
	}
}
