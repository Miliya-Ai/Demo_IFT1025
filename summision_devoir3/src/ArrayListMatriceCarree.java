
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Une implémentation de l'interface {@link } en utilisant la classe
 * {@link ArrayList}.
 *
 * @author Michalis Famelis
 *
 * @param <E> le type de chose stocké dans la matrice.
 */
public class ArrayListMatriceCarree<E> implements MatriceCarree<E>, Iterable<E> {

    private ArrayList<ArrayList<E>> lignes;
    private int dimension;

    /**
     * Crée une matrice de dimension 0.
     */
    public ArrayListMatriceCarree() {
        this(0);
    }

    /**
     * Crée une matrice carée, avec une dimension donnée. Les cases de la matrice
     * sont initialisées à {@code null}.
     *
     * @param dim - la dimension de la matrice à créer.
     */
    public ArrayListMatriceCarree(int dim) {
        this.dimension = dim;
        this.lignes = new ArrayList<ArrayList<E>>(this.dimension);
        for (int i = 0; i < this.dimension; i++) {
            ArrayList<E> nouvelleLigne = new ArrayList<E>(this.dimension);
            for (int j = 0; j < this.dimension; j++)
                nouvelleLigne.add(null);
            this.lignes.add(nouvelleLigne);
        }
    }

    @Override
    public int dim() {
        return this.dimension;
    }

    @Override
    public E get(int i, int j) throws MatriceIndexOutOfBoundsException {
        if (i < 0 || i >= dimension || j < 0 || j >= dimension) {
            throw new MatriceIndexOutOfBoundsException();
        }

        return this.lignes.get(i).get(j);
    }

    @Override
    public void set(int i, int j, E val) throws MatriceIndexOutOfBoundsException {
        if (i < 0 || i >= dimension || j < 0 || j >= dimension) {
            throw new MatriceIndexOutOfBoundsException();
        }

        if (this.lignes.get(i).get(j) == null) {
            this.lignes.get(i).set(j, val);
        } else {
            for (int x = 0; x < dimension; x++) {
                for (int y = 0; y < dimension; y++) {
                    if (this.lignes.get(x).get(y) == null) {
                        this.lignes.get(x).set(y, val);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void ajoute(E val) throws MatricePleineException {
        if (estPleine()) {
            throw new MatricePleineException();
        }

        MatriceIterator<E> it = new MatriceIterator<>(this);
        while (it.hasNext()) {
            E n = it.next();
            if (n == null) {
                it.remplace(val);
                break;
            }
        }
    }
    private boolean estPleine() {
        MatriceIterator<E> it = new MatriceIterator<>(this);
        while (it.hasNext()) {
            if (it.next() == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new MatriceIterator<E>(this);
    }

    @Override
    public String toString() {
        String ret = "---\n";
        for (var ligne : this.lignes) {
            ret += ligne.toString() + "\n";
        }
        ret += "---\n";
        return ret;
    }

}
