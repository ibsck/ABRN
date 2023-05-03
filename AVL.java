import java.util.*;

/**
 * <p>
 * Implantation de l'interface Collection basée sur les arbres AVL. Les éléments sont ordonnés soit en utilisant l'ordre naturel (cf Comparable) soit avec un Comparator fourni à la création.
 * </p>
 *
 * <p>
 * Certaines méthodes de AbstractCollection doivent être surchargées pour plus d'efficacité.
 * </p>
 *
 * @param <E>
 *            le type des clés stockées dans l'arbre
 */

public class  AVL<E> extends AbstractCollection<E> {
    private Noeud racine;
	private int taille;
	private Comparator<? super E> cmp;

    private class Noeud {
		E cle;
		Noeud gauche;
		Noeud droit;
		Noeud pere;
		
		int hauteur;
		
		Noeud(E cle) {
			this.cle = cle;
			this.gauche = null;
			this.droit = null;
			this.pere = null;
			this.hauteur = 1;
		}
	
		/**
		 * Renvoie le noeud contenant la clé minimale du sous-arbre enraciné
		 * dans ce noeud
		 *
		 * @return le noeud contenant la clé minimale du sous-arbre enraciné
		 * dans ce noeud
		 */
		Noeud minimum() {
			Noeud n = this;
			while (n.gauche != null) {
				n = n.gauche;
			}
			return n;
		}
		
		/**
		 * Renvoie le successeur de ce noeud
		 *
		 * @return le noeud contenant la clé qui suit la clé de ce noeud dans
		 * l'ordre des clés, null si c'es le noeud contenant la plus
		 * grande clé
		 */
		Noeud suivant() {
			if (this.droit != null) {
				return this.droit.minimum();
			}
			Noeud n = this;
			while (n.pere != null && n.pere.droit == n) {
				n = n.pere;
			}
			return n.pere;	
		}
	}
	
	// Consructeurs

    /**
     * Construit un AVL vide
     */
    public AVL() {
        this.racine = null;
        this.taille = 0;
        this.cmp = (e1, e2) -> ((Comparable) e1).compareTo(e2);
    }

    /**
     * Construit un AVL vide utilisant le comparateur fourni
     *
     * @param cmp
     *            le comparateur à utiliser
     */
    public AVL(Comparator<? super E> cmp) {
        this.racine = null;
        this.taille = 0;
        this.cmp = cmp;
    }

    /**
     * Construit un AVL contenant les éléments de la collection fournie
     *
     * @param c
     *            la collection dont les éléments doivent être ajoutés
     */
    public AVL(Collection<? extends E> c) {
        this();
        this.addAll(c);
    }

    @Override
	public Iterator<E> iterator() {
		return new AVLterator();
	}

	@Override
	public int size() {
		return taille;
	}

    private class AVLterator implements Iterator<E> {
        Noeud courant;
        Noeud suivant;
        boolean removeOK;

        AVLterator() {
            this.courant = null;
            this.suivant = racine.minimum();
            this.removeOK = false;
        }

        @Override
        public boolean hasNext() {
            return suivant != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            courant = suivant;
            suivant = suivant.suivant();
            removeOK = true;
            return courant.cle;
        }

        @Override
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            AVL.this.remove(courant.cle);
            removeOK = false;
        }
    }

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
        Noeud n = y.pere;
        while(n != null) {
            n.hauteur = Math.max(hauteur(n.gauche),hauteur(n.droit)) + 1;
            n = n.pere;
        }
        return x;
    }

    private int hauteur(Noeud n) {
        if(n == null) {
            return 0;
        } else {
            return n.hauteur;
        }
    }

    private int balance(Noeud n) {
        if(n == null) {
            return 0;
        } else {
            return hauteur(n.gauche) - hauteur(n.droit);
        }
    }

    private Noeud rotationGauche(Noeud n) {
        Noeud y = n.droit;
        n.droit = y.gauche;
        if(y.gauche != null) {
            y.gauche.pere = n;
        }
        y.pere = n.pere;
        if(n.pere == null) {
            this.racine = y;
        } else {
            if(n == n.pere.gauche) {
                n.pere.gauche = y;
            } else {
                n.pere.droit = y;
            }
        }
        y.gauche = n;
        n.pere = y;
        n.hauteur = Math.max(hauteur(n.gauche),hauteur(n.droit)) + 1;
        y.hauteur = Math.max(hauteur(y.droit),n.hauteur) + 1;
        return y;
    }

    private Noeud rotationDroite(Noeud n) {
        Noeud y = n.gauche;
        n.gauche = y.droit;
        if(y.droit != null) {
            y.droit.pere = n;
        }
        y.pere = n.pere;
        if(n.pere == null) {
            this.racine = y;
        } else {
            if(n == n.pere.droit) {
                n.pere.droit = y;
            } else {
                n.pere.gauche = y;
            }
        }
        y.droit = n;
        n.pere = y;
        n.hauteur = Math.max(hauteur(n.gauche),hauteur(n.droit)) + 1;
        y.hauteur = Math.max(hauteur(y.gauche),n.hauteur) + 1;
        return y;
    }

    private Noeud rotationGaucheDroite(Noeud n) {
        n.gauche = rotationGauche(n.gauche);
        return rotationDroite(n);
    }

    private Noeud rotationDroiteGauche(Noeud n) {
        n.droit = rotationDroite(n.droit);
        return rotationGauche(n);
    }

    private Noeud equilibrer(Noeud n) {
        if(balance(n) == 2) {
            if(balance(n.gauche) == -1) {
                return rotationGaucheDroite(n);
            } else {
                return rotationDroite(n);
            }
        } else if(balance(n) == -2) {
            if(balance(n.droit) == 1) {
                return rotationDroiteGauche(n);
            } else {
                return rotationGauche(n);
            }
        }
        return n;
    }

    private Noeud inserer(Noeud n, E e) {
        if(n == null) {
            return new Noeud(e);
        }
        if(cmp.compare(e,n.cle) < 0) {
            n.gauche = inserer(n.gauche,e);
            n.gauche.pere = n;
        } else {
            n.droit = inserer(n.droit,e);
            n.droit.pere = n;
        }
        n.hauteur = Math.max(hauteur(n.gauche),hauteur(n.droit)) + 1;
        return equilibrer(n);
    }

    public boolean add(E e) {
        if(contains(e)) {
            return false;
        }
        this.racine = inserer(this.racine,e);
        this.taille++;
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean modifie = false;
        for(E e : c) {
            modifie |= add(e);
        }
        return modifie;
    }

    public void clear() {
        this.racine = null;
        this.taille = 0;
    }

    public boolean contains(Object o) {
        Noeud n = this.racine;
        while(n != null) {
            if(cmp.compare((E)o,n.cle) == 0) {
                return true;
            } else if(cmp.compare((E)o,n.cle) < 0) {
                n = n.gauche;
            } else {
                n = n.droit;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        for(Object o : c) {
            if(!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.racine == null;
    }
 
}
