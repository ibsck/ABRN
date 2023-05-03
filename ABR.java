import java.util.*;

/**
 * <p>
 * Implantation de l'interface Collection basée sur les arbres binaires de
 * recherche. Les éléments sont ordonnés soit en utilisant l'ordre naturel (cf
 * Comparable) soit avec un Comparator fourni à la création.
 * </p>
 * 
 * <p>
 * Certaines méthodes de AbstractCollection doivent être surchargées pour plus
 * d'efficacité.
 * </p>
 * 
 * @param <E>
 *            le type des clés stockées dans l'arbre
 */
public class ABR<E> extends AbstractCollection<E> {
	private Noeud racine;
	private int taille;
	private Comparator<? super E> cmp;

	private class Noeud {
		E cle;
		Noeud gauche;
		Noeud droit;
		Noeud pere;

		Noeud(E cle) {
			// TODO
            this.cle = cle;
			this.gauche = null;
			this.droit = null;
			this.pere = null;
		}

		/**
		 * Renvoie le noeud contenant la clé minimale du sous-arbre enraciné
		 * dans ce noeud
		 * 
		 * @return le noeud contenant la clé minimale du sous-arbre enraciné
		 *         dans ce noeud
		 */
		Noeud minimum() {
			// TODO
            Noeud n = this;
            while(n.gauche != null) {
                n = n.gauche;
            }
            return n;
		}

		/**
		 * Renvoie le successeur de ce noeud
		 * 
		 * @return le noeud contenant la clé qui suit la clé de ce noeud dans
		 *         l'ordre des clés, null si c'es le noeud contenant la plus
		 *         grande clé
		 */
		Noeud suivant() {
			// TODO
            if(this.droit != null) {
                return this.droit.minimum();
            }
            Noeud n = this;
            while(n.pere != null && n.pere.droit == n) {
                n = n.pere;
            }
            return n.pere;			
		}
	}

	// Consructeurs

	/**
	 * Crée un arbre vide. Les éléments sont ordonnés selon l'ordre naturel
	 */
	public ABR() {
		// TODO
        this.taille = 0;
        this.racine = null;
        this.cmp = (e1,e2)->((Comparable)e1).compareTo(e2);
	}

	/**
	 * Crée un arbre vide. Les éléments sont comparés selon l'ordre imposé par
	 * le comparateur
	 * 
	 * @param cmp
	 *            le comparateur utilisé pour définir l'ordre des éléments
	 */
	public ABR(Comparator<? super E> cmp) {
		// TODO
        this.racine = null;
        this.taille = 0;
        this.cmp = cmp;

	}

	/**
	 * Constructeur par recopie. Crée un arbre qui contient les mêmes éléments
	 * que c. L'ordre des éléments est l'ordre naturel.
	 * 
	 * @param c
	 *            la collection à copier
	 */
	public ABR(Collection<? extends E> c) {
		// TODO
        this();
        this.addAll(c);
	}

	@Override
	public Iterator<E> iterator() {
		return new ABRIterator();
	}

	@Override
	public int size() {
		return taille;
	}

	// Quelques méthodes utiles

	/**
	 * Recherche une clé. Cette méthode peut être utilisée par
	 * {@link #contains(Object)} et {@link #remove(Object)}
	 * 
	 * @param o
	 *            la clé à chercher
	 * @return le noeud qui contient la clé ou null si la clé n'est pas trouvée.
	 */
	private Noeud rechercher(Object o) {
		// TODO
        Noeud n = this.racine;
        while(n != null) {
            if(cmp.compare((E)o,n.cle) == 0) {
                return n;
            }
            if(cmp.compare((E)o,n.cle) < 0) {
                n = n.gauche;
            } else {
                n = n.droit;
            }
        }
        return null;
	}

	/**
	 * Supprime le noeud z. Cette méthode peut être utilisée dans
	 * {@link #remove(Object)} et {@link Iterator#remove()}
	 * 
	 * @param z
	 *            le noeud à supprimer
	 * @return le noeud contenant la clé qui suit celle de z dans l'ordre des
	 *         clés. Cette valeur de retour peut être utile dans
	 *         {@link Iterator#remove()}
	 */
	private Noeud supprimer(Noeud z) {
		// TODO
		Noeud y;
		Noeud x;
		if(z.gauche == null || z.droit == null) {
		    y = z;
		} else {
		    y = z.suivant();
		}
		if(y.gauche != null) {
		    x = y.gauche;
		} else {
		    x = y.droit;
		}
		if(x != null) {
		    x.pere = y.pere;
		}
		if(y.pere == null) {
		    this.racine = x;
		} else {
		    if(y == y.pere.gauche) {
		        y.pere.gauche = x;
		    } else {
		        y.pere.droit = x;
		    }
		}
		if(y != z) {
		    z.cle = y.cle;
		}
		this.taille--;
		return y.suivant();
	}

	/**
	 * Les itérateurs doivent parcourir les éléments dans l'ordre ! Ceci peut se
	 * faire facilement en utilisant {@link Noeud#minimum()} et
	 * {@link Noeud#suivant()}
	 */
	private class ABRIterator implements Iterator<E> {
		private Noeud courant;
		private Noeud suivant;
		public ABRIterator() {
			// TODO
			courant = racine.minimum();
			suivant = courant.suivant();
		}
		
		@Override
		public boolean hasNext() {
			// TODO
			if(suivant != null) {
				return true;
			}else {
				return false;
			}
		}
		
		@Override
		public E next() {
			// TODO
			if(hasNext()) {
				courant = suivant;
				suivant = suivant.suivant();
				return courant.cle;
			}else {
				throw new NoSuchElementException("Pas d'élément suivant");
			}

		}
		
		@Override
		public void remove() {
			// TODO
			if (courant == null) throw new IllegalStateException("Pas d'élément courant");
			Noeud x = supprimer(courant);
			if (x == null) {
				courant = null;
			} else {
				courant = x;
				suivant = x.suivant();
			}
		}

	}

	// Pour un "joli" affichage

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		toString(racine, buf, "", maxStrLen(racine));
		return buf.toString();
	}

	private void toString(Noeud x, StringBuffer buf, String path, int len) {
		if (x == null)
			return;
		toString(x.droit, buf, path + "D", len);
		for (int i = 0; i < path.length(); i++) {
			for (int j = 0; j < len + 6; j++)
				buf.append(' ');
			char c = ' ';
			if (i == path.length() - 1)
				c = '+';
			else if (path.charAt(i) != path.charAt(i + 1))
				c = '|';
			buf.append(c);
		}
		buf.append("-- " + x.cle.toString());
		if (x.gauche != null || x.droit != null) {
			buf.append(" --");
			for (int j = x.cle.toString().length(); j < len; j++)
				buf.append('-');
			buf.append('|');
		}
		buf.append("\n");
		toString(x.gauche, buf, path + "G", len);
	}

	private int maxStrLen(Noeud x) {
		return x == null ? 0 : Math.max(x.cle.toString().length(),
				Math.max(maxStrLen(x.gauche), maxStrLen(x.droit)));
	}
	// un jouli affichage de l'arbre pour les arbres rouge-noir
	

	// TODO : voir quelles autres méthodes il faut surcharger

    public boolean add(E e){
        Noeud n = new Noeud(e);
        if(this.racine == null) {
            this.racine = n;
            this.taille++;
            return true;
        }
        Noeud x = this.racine;
        Noeud y = null;
        while(x != null) {
            y = x;
            if(this.cmp.compare(e,x.cle) < 0) {
                x = x.gauche;
            } else {
                x = x.droit;
            }
        }
        n.pere = y;
        if(this.cmp.compare(e,y.cle) < 0) {
            y.gauche = n;
        } else {
            y.droit = n;
        }
        this.taille++;
        return true;
    }

    public boolean addAll(Collection<? extends E> c){
        for(E e : c) {
            this.add(e);
        }
        return true;
    }
    // supprime tous les éléments de l'arbre
    public void clear(){
        this.racine = null;
        this.taille = 0;
    }
    // retourne true si l'arbre contient l'élément e
    public boolean contains(Object e){
        return this.rechercher(e) != null;
    }
    // retourne true si l'arbre contient tous les éléments de c
    public boolean containsAll(Collection<?> c){
        for(Object e : c) {
            if(!this.contains(e)) {
                return false;
            }
        }
        return true;
    }
    // retourne true si l'arbre est vide
    public boolean isEmpty(){
        return this.taille == 0;
    }

	//supprime un élement de l'arbre
	public boolean remove(Object e){
		Noeud n = this.rechercher(e);
		if(n == null) {
			return false;
		}
		this.supprimer(n);
		return true;
	}

	//supprime tous les éléments de l'arbre qui sont dans c
	public boolean removeAll(Collection<?> c){
		for(Object e : c) {
			this.remove(e);
		}
		return true;
	}

	//supprime tous les éléments de l'arbre qui ne sont pas dans c

	public boolean retainAll(Collection<?> c){
		ABR<E> a = new ABR<E>(this.cmp);
		for(Object e : c) {
			if(this.contains(e)) {
				a.add((E)e);
			}
		}
		this.racine = a.racine;
		this.taille = a.taille;
		return true;
	}

	// retourne un tableau contenant tous les éléments de l'arbre
	public Object[] toArray(){
		Object[] tab = new Object[this.taille];
		int i = 0;
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			tab[i] = it.next();
			i++;
		}
		return tab;
	}
}
