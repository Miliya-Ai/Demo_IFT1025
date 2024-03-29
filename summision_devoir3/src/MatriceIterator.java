
import java.util.Iterator;

/**
 * Un iterateur qui permet de parcourir un matrice ligne par ligne.
 * </br>
 * Par exemple, la matrice suivante sera parcourue 
 * comme suit: 0,1,3,4,5,6,7,8.
 * <pre>
 * ---
 * [0, 1, 2]
 * [3, 4, 5]
 * [6, 7, 8]
 * ---
 * </pre>
 * 
 * @author Michalis Famelis
 *
 * @param <E>
 */
public class MatriceIterator<E> implements Iterator<E> {

	private MatriceCarree<E> m;
	private int iCourant, jCourant;
	private int iPrecedent, jPrecedent;
	private int max;

	/**
	 * Crée un MatriceIterator pour une MatriceCarree donnée.
	 * 
	 * @param m - la MatriceCaree à itérer
	 */
	public MatriceIterator(MatriceCarree<E> m) {
		this.m = m;
		this.iCourant = 0;
		this.jCourant = 0;
		this.max = m.dim();
		this.iPrecedent = 0;
		this.jPrecedent = 0;
	}

	@Override
public boolean hasNext() {
    return iCourant < max && jCourant < max;
}


	@Override
public E next() {
    if (!hasNext()) {
        throw new NoSuchElementException();
    }

    E ret = this.m.get(iCourant, jCourant);
    jCourant++;

    if (jCourant == max) {
        jCourant = 0;
        iCourant++;
    }

    return ret;
}


	/**
	 * Remplace le dernier élément visité par un autre élément. Ce méthode ne fait
	 * pas avancer l'itérateur. </br>
	 * Le dernier élément visité est le dernier élément rétourné par un appel à
	 * {@code next()}. Si {@code next()} n'a jamais été appelé, cette méthode
	 * remplace le premier élément de la matrice.
	 * 
	 * Il est acceptable si une {@link MatriceIndexOutOfBoundsException} est générée
	 * si on essaie de remplacer un élément dans une matrice vide (dont la dimension
	 * est 0).
	 * 
	 * @param e - le nouveau élément
	 */
	public void remplace(E e) {
    this.m.set(iPrecedent, jPrecedent, e);
}


}
