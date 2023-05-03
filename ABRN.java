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
public class ABRN<E> extends AbstractCollection<E> {
	
	private enum Couleur {
		ROUGE, NOIR;
	}
	private Noeud racine;
	private Noeud sentinelle;
	private int taille;
	private Comparator<? super E> cmp;
	
	private class Noeud {
		E cle;
		Noeud gauche;
		Noeud droit;
		Noeud pere;
		
		Couleur couleur;
		
		Noeud(E cle) {
			// TODO
			this.cle = cle;
			this.gauche = null;
			this.droit = null;
			this.pere = null;
			this.couleur = Couleur.NOIR;
		}
		
		
		
		/**
		 * Renvoie le noeud contenant la clé minimale du sous-arbre enraciné
		 * dans ce noeud
		 *
		 * @return le noeud contenant la clé minimale du sous-arbre enraciné
		 * dans ce noeud
		 */
		Noeud minimum() {
			// TODO
			Noeud n = this;
			while (n.gauche != sentinelle) {
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
			// TODO
			if (this.droit != sentinelle) {
				return this.droit.minimum();
			}
			Noeud n = this;
			while (n.pere != sentinelle && n.pere.droit == n) {
				n = n.pere;
			}
			return n.pere;	

		}
	}
	
	// Consructeurs
	
	/**
	 * Crée un arbre vide. Les éléments sont ordonnés selon l'ordre naturel
	 */
	public ABRN() {
		// TODO
		this.sentinelle = new Noeud(null);
		this.taille = 0;
		this.racine = this.sentinelle;
		this.cmp = (e1, e2) -> ((Comparable) e1).compareTo(e2);
	}
	
	/**
	 * Crée un arbre vide. Les éléments sont comparés selon l'ordre imposé par
	 * le comparateur
	 *
	 * @param cmp le comparateur utilisé pour définir l'ordre des éléments
	 */
	public ABRN(Comparator<? super E> cmp) {
		// TODO
		this.sentinelle = new Noeud(null);
		this.racine = sentinelle;
		this.taille = 0;
		this.cmp = cmp;
		
	}
	
	/**
	 * Constructeur par recopie. Crée un arbre qui contient les mêmes éléments
	 * que c. L'ordre des éléments est l'ordre naturel.
	 *
	 * @param c la collection à copier
	 */
	public ABRN(Collection<? extends E> c) {
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
	 * @param o la clé à chercher
	 * @return le nœud qui contient la clé ou null si la clé n'est pas trouvée.
	 */
	private Noeud rechercher(Object o) {
		// TODO
		Noeud x = this.racine;
		while (x != this.sentinelle && cmp.compare((E) o, x.cle) != 0) {
			if (cmp.compare((E) o, x.cle) < 0) x = x.gauche;
			else x = x.droit;
		}
		return x;
	}
	
	/**
	 * Supprime le noeud z. Cette méthode peut être utilisée dans
	 * {@link #remove(Object)} et {@link Iterator#remove()}
	 *
	 * @param z le noeud à supprimer
	 * @return le noeud contenant la clé qui suit celle de z dans l'ordre des
	 * clés. Cette valeur de retour peut être utile dans
	 * {@link Iterator#remove()}
	 */
	private Noeud supprimer(Noeud z) {
		// TODO
		Noeud y = z;
		Noeud x;
		Couleur yCouleur = y.couleur;
		if (z.gauche == sentinelle) {
			x = z.droit;
			transplant(z, z.droit);
		} else if (z.droit == sentinelle) {
			x = z.gauche;
			transplant(z, z.gauche);
		} else {
			y = z.droit;
			yCouleur = y.couleur;
			x = y.droit;
			if (y.pere == z) {
				x.pere = y;
			} else {
				transplant(y, y.droit);
				y.droit = z.droit;
				y.droit.pere = y;
			}
			transplant(z, y);
			y.gauche = z.gauche;
			y.gauche.pere = y;
			y.couleur = z.couleur;
		}
		if (yCouleur == Couleur.NOIR) {
			supprimerCorriger(x);
		}
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
			if(suivant != sentinelle) {
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
			if (courant == null) throw new IllegalStateException();
			Noeud x = supprimer(courant);
			if (x == null) {
				courant = null;
			} else {
				courant = x;
				suivant = x.suivant();
			}
		}
		
	}
	

	public String toString() {
		StringBuffer buf = new StringBuffer();
		toString(racine, buf, "", maxStrLen(racine));
		return buf.toString();
	}

	private void toString(Noeud x, StringBuffer buf, String path, int len) {
		if (x == sentinelle)
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
		if (x.gauche != sentinelle || x.droit != sentinelle) {
			buf.append(" --");
			for (int j = x.cle.toString().length(); j < len; j++)
				buf.append('-');
			buf.append('|');
		}
		buf.append(" " + (x.couleur == Couleur.ROUGE ? "R" : "N"));
		buf.append("\n");
		toString(x.gauche, buf, path + "G", len);
	}


	
	private int maxStrLen(Noeud x) {
		return x == sentinelle ? 0 : Math.max(x.cle.toString().length(),
				Math.max(maxStrLen(x.gauche), maxStrLen(x.droit)));
	}
	
	// TODO : voir quelles autres méthodes il faut surcharger
	
	public boolean add(E e) {
		Noeud z = new Noeud(e); 
		Noeud y = sentinelle; 
		Noeud x = racine; 
		while (x != sentinelle) { 
			y = x; 
			if (cmp.compare(z.cle, x.cle) < 0) { 
				x = x.gauche; 
			} else {
				x = x.droit; 
			}
		}
		z.pere = y; 
		if (y == sentinelle) { 
			racine = z; 
		} else if (cmp.compare(z.cle, y.cle) < 0) { 
			y.gauche = z; 
		} else {
			y.droit = z; 
		}
		z.gauche = sentinelle; 
		z.droit = sentinelle; 
		z.couleur = Couleur.ROUGE; 
		insererCorriger(z);
		return true;
	}
	
	public boolean addAll(Collection<? extends E> c) {
		for (E e : c) { 
			this.add(e); 
		} 
		return true;
	}
	
	//correction de l'arbre rouge noir après insertion
	private void insererCorriger(Noeud z) { 
		while (z.pere.couleur == Couleur.ROUGE) { 
			if (z.pere == z.pere.pere.gauche) { 
				Noeud y = z.pere.pere.droit; 
				if (y.couleur == Couleur.ROUGE) {
					z.pere.couleur = Couleur.NOIR;
					y.couleur = Couleur.NOIR; 
					z.pere.pere.couleur = Couleur.ROUGE; 
					z = z.pere.pere; 
				} else {
					if (z == z.pere.droit) { 
						z = z.pere; 			
						rotationGauche(z); 
					}
					z.pere.couleur = Couleur.NOIR; 		
					z.pere.pere.couleur = Couleur.ROUGE; 
					rotationDroite(z.pere.pere); 		
				}
			} else { 
				Noeud y = z.pere.pere.gauche; 
				if (y.couleur == Couleur.ROUGE) { 		
					z.pere.couleur = Couleur.NOIR; 		
					y.couleur = Couleur.NOIR;	
					z.pere.pere.couleur = Couleur.ROUGE; 	
					z = z.pere.pere;	 
				} else { 		
					if (z == z.pere.gauche) { 		
						z = z.pere; 	
						rotationDroite(z); 		
					}
					z.pere.couleur = Couleur.NOIR; 		
					z.pere.pere.couleur = Couleur.ROUGE; 		
					rotationGauche(z.pere.pere); 		
				}
			}
		}
		racine.couleur = Couleur.NOIR; 		
	}
	
	//rotation à gauche
	private void rotationGauche(Noeud x) {
		Noeud y = x.droit;
		x.droit = y.gauche;
		if (y.gauche != sentinelle) {
			y.gauche.pere = x;
		}
		y.pere = x.pere;
		if (x.pere == sentinelle) {
			racine = y;
		} else if (x == x.pere.gauche) {
			x.pere.gauche = y;
		} else {
			x.pere.droit = y;
		}
		y.gauche = x;
		x.pere = y;
	}
	
	//rotation à droite
	
	private void rotationDroite(Noeud x) {
		Noeud y = x.gauche;
		x.gauche = y.droit;
		if (y.droit != sentinelle) {
			y.droit.pere = x;
		}
		y.pere = x.pere;
		if (x.pere == sentinelle) {
			racine = y;
		} else if (x == x.pere.droit) {
			x.pere.droit = y;
		} else {
			x.pere.gauche = y;
		}
		y.droit = x;
		x.pere = y;
	}
	
	// supprime tous les éléments de l'arbre
	public void clear() {
		this.racine = this.sentinelle;
		this.taille = 0;
	}
	
	// retourne true si l'arbre contient l'élément e
	public boolean contains(Object e) {
		return this.rechercher(e) != this.sentinelle;
	}
	
	// retourne true si l'arbre contient tous les éléments de c
	public boolean containsAll(Collection<?> c) {
		for (Object e : c) {
			if (!this.contains(e)) {
				return false;
			}
		}
		return true;
	}
	
	// retourne true si l'arbre est vide
	public boolean isEmpty() {
		return this.taille == 0;
	}
	
	// supprime l'élément e de l'arbre
	public boolean remove(Object e) {
		Noeud z = this.rechercher(e);
		if (z == this.sentinelle) {
			return false;
		}
		this.supprimer(z);
		return true;
	}
	
	//correction de l'arbre rouge noir après suppression
	private void supprimerCorriger(Noeud x) {
		while (x != racine && x.couleur == Couleur.NOIR) {
			if (x == x.pere.gauche) {
				Noeud w = x.pere.droit;
				if (w.couleur == Couleur.ROUGE) {
					w.couleur = Couleur.NOIR;
					x.pere.couleur = Couleur.ROUGE;
					rotationGauche(x.pere);
					w = x.pere.droit;
				}
				if (w.gauche.couleur == Couleur.NOIR && w.droit.couleur == Couleur.NOIR) {
					w.couleur = Couleur.ROUGE;
					x = x.pere;
				} else {
					if (w.droit.couleur == Couleur.NOIR) {
						w.gauche.couleur = Couleur.NOIR;
						w.couleur = Couleur.ROUGE;
						rotationDroite(w);
						w = x.pere.droit;
					}
					w.couleur = x.pere.couleur;
					x.pere.couleur = Couleur.NOIR;
					w.droit.couleur = Couleur.NOIR;
					rotationGauche(x.pere);
					x = racine;
				}
			} else {
				Noeud w = x.pere.gauche;
				if (w.couleur == Couleur.ROUGE) {
					w.couleur = Couleur.NOIR;
					x.pere.couleur = Couleur.ROUGE;
					rotationDroite(x.pere);
					w = x.pere.gauche;
				}
				if (w.droit.couleur == Couleur.NOIR && w.gauche.couleur == Couleur.NOIR) {
					w.couleur = Couleur.ROUGE;
					x = x.pere;
				} else {
					if (w.gauche.couleur == Couleur.NOIR) {
						w.droit.couleur = Couleur.NOIR;
						w.couleur = Couleur.ROUGE;
						rotationGauche(w);
						w = x.pere.gauche;
					}
					w.couleur = x.pere.couleur;
					x.pere.couleur = Couleur.NOIR;
					w.gauche.couleur = Couleur.NOIR;
					rotationDroite(x.pere);
					x = racine;
				}
			}
		}
		x.couleur = Couleur.NOIR;
	}
	
	private void transplant(Noeud u, Noeud v) {
		if (u.pere == sentinelle) {
			racine = v;
		} else if (u == u.pere.gauche) {
			u.pere.gauche = v;
		} else {
			u.pere.droit = v;
		}
		v.pere = u.pere;
	}
}