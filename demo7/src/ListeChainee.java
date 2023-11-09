public class ListeChainee<T> {

	private Noeud premier;

	private class Noeud {
		public T valeur;
		public Noeud prochain;

		public Noeud(T valeur, Noeud prochain) {
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
			if(n == null)
			{
				throw new IndexOutOfBoundsException("Index invalide :'( " + idx);
				// lancer une exception si l'index est invalide, avantage : on peut
				// afficher un message d'erreur personnalisé, et on peut aussi faire en sorte que
				// le programme s'arrête (plutôt que de continuer à tourner avec des valeurs
				// par défaut)
			}
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
	public T get(int idx) {
		return getNoeud(idx).valeur;
	}

	/**
	 * Modifie le idx-ème élément
	 *
	 * @param idx indice du nœud
	 * @param valeur valeur du nœud
	 */
	public void set(int idx, T valeur) {
		getNoeud(idx).valeur = valeur;
	}

	/**
	 * Calcule la taille de la liste chaînée
	 *
	 * @return taille de la liste
	 */
	public int size() {
		int size = 0;

		Noeud n = this.premier;
		while(n != null) {
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
	public void addFirst(T valeur) {
		this.premier = new Noeud(valeur, this.premier);
	}

	/**
	 * Ajoute un élément à la fin de la liste
	 *
	 * @param valeur valeur du nœud
	 */
	public void addLast(T valeur) {
		if(this.premier == null) { // Cas 1 : rien dans la liste
			this.premier = new Noeud(valeur, null);
		} else { // Cas 2 : trouver le nœud final
			Noeud fin = this.premier;
			Noeud n = this.premier.prochain;

			while(n != null) {
				fin = n;
				n = n.prochain;
			}

			// Ajoute un nœud après la fin de la liste
			fin.prochain = new Noeud(valeur, null);
		}
	}
}