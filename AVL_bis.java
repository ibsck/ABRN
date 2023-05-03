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
public class AVLB<E> extends AbstractCollection<E> {

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
	 * Crée un arbre vide. Les éléments sont ordonnés selon l'ordre naturel
	 */
	public AVL() {
		this.racine = null;
		this.taille = 0;
		this.cmp = (e1, e2) -> ((Comparable) e1).compareTo(e2);
	}
	
	/**
	 * Crée un arbre vide. Les éléments sont comparés selon l'ordre imposé par
	 * le comparateur
	 *
	/**
	 * Crée un arbre vide. Les éléments sont comparés selon l'ordre imposé par
	 * le comparateur
	 *
	 * @param cmp le comparateur utilisé pour définir l'ordre des éléments
	 */
	public AVL(Comparator<? super E> cmp) {
		this.racine = null;
		this.taille = 0;
		this.cmp = cmp;
	}
	
	// Méthodes d'accès
	
	/**
	 * Renvoie la racine de l'arbre
	 *
	 * @return la racine de l'arbre
	 */
	public Noeud getRacine() {
		return racine;
	}
	
	/**
	 * Renvoie le comparateur utilisé pour définir l'ordre des éléments
	 *
	 * @return le comparateur utilisé pour définir l'ordre des éléments
	 */
	public Comparator<? super E> getComparator() {
		return cmp;
	}
	
	/**
	 * Renvoie la hauteur de l'arbre
	 *
	 * @return la hauteur de l'arbre
	 */
	public int
	/**
	 * Renvoie la hauteur de l'arbre
	 *
	 * @return la hauteur de l'arbre
	 */
	public int hauteur() {
		return hauteur(racine);
	}
	
	/**
	 * Renvoie la hauteur du sous-arbre enraciné dans le noeud donné
	 *
	 * @param noeud le noeud racine du sous-arbre
	 * @return la hauteur du sous-arbre enraciné dans le noeud donné
	 */
	private int hauteur(Noeud noeud) {
		if (noeud == null) {
			return -1;
		}
		return noeud.hauteur;
	}
	
	/**
	 * Renvoie le facteur d'équilibre du noeud donné
	 *
	 * @param noeud le noeud dont on veut connaître le facteur d'équilibre
	 * @return le facteur d'équilibre du noeud donné
	 */
	private int facteurEquilibre(Noeud noeud) {
		return hauteur(noeud.droit) - hauteur(noeud.gauche);
	}
	
	/**
	 * Met à jour la hauteur du noeud donné
	 *
	 * @param noeud le noeud dont on veut mettre à jour la hauteur
	 */
	private void mettreAJourHauteur(Noeud noeud) {
		noeud.hauteur = 1 + Math.max(hauteur(noeud.gauche), hauteur(noeud.droit));
	}
	
	// Méthodes de modification de l'arbre
	
	/**
	 * Effectue une rotation à droite sur le sous-arbre enraciné dans le noeud
	 * donné
	 *
	 * @param no*/
private int hauteur(Noeud n) {
	if (n == sentinelle) {
		return 0;
	}
	return 1 + Math.max(hauteur(n.gauche), hauteur(n.droit));
}

private int balance(Noeud n) {
	if (n == sentinelle) {
		return 0;
	}
	return hauteur(n.gauche) - hauteur(n.droit);
}

private void rotationGauche(Noeud x) {
	Noeud y = x.droit;
	x.droit = y.gauche;
	if (y.gauche != sentinelle) {
		y.gauche.pere = x;
	}
	y.pere = x.pere;
	if (x.pere == sentinelle) {
		racine = y;
	} else if (x.pere.gauche == x) {
		x.pere.gauche = y;
	} else {
		x.pere.droit = y;
	}
	y.gauche = x;
	x.pere = y;
}

private void rotationDroite(Noeud y) {
	Noeud x = y.gauche;
	y.gauche = x.droit;
	if (x.droit != sentinelle) {
		x.droit.pere = y;
	}
	x.pere = y.pere;
	if (y.pere == sentinelle) {
		racine = x;
	} else if (y.pere.gauche == y) {
		y.pere.gauche = x;
	} else {
		y.pere.droit = x;
	}
	x.droit = y;
	y.pere = x;
}

private void equilibre(Noeud n) {
	while (n != sentinelle) {
		int balance = balance(n);
		if (balance > 1) {
			if (balance(n.gauche) < 0) {
				rotationGauche(n.gauche);
			}
			rotationDroite(n);
		} else if (balance < -1) {
			if (balance(n.droit) > 0) {
				rotationDroite(n.droit);
			}
			rotationGauche(n);
		}
		n = n.pere;
	}
}

/**
 * Ajoute un élément à l'arbre
 *
 * @param e
 *            l'élément à ajouter
 * @return true (selon la convention de Collection)
 */
private int hauteur(Noeud n) {
    if (n == sentinelle) {
        return -1;
    }
    return n.hauteur;
}

private int getBalance(Noeud n) {
    if (n == sentinelle) {
        return 0;
    }
    return hauteur(n.gauche) - hauteur(n.droit);
}

private Noeud rotationGauche(Noeud n) {
    Noeud r = n.droit;
    Noeud rl = r.gauche;
    
    r.gauche = n;
    n.droit = rl;
    
    n.hauteur = Math.max(hauteur(n.gauche), hauteur(n.droit)) + 1;
    r.hauteur = Math.max(hauteur(r.gauche), hauteur(r.droit)) + 1;
    
    return r;
}

private Noeud rotationDroite(Noeud n) {
    Noeud l = n.gauche;
    Noeud lr = l.droit;
    
    l.droit = n;
    n.gauche = lr;
    
    n.hauteur = Math.max(hauteur(n.gauche), hauteur(n.droit)) + 1;
    l.hauteur = Math.max(hauteur(l.gauche), hauteur(l.droit)) + 1;
    
    return l;
}

private Noeud inserer(Noeud n, E cle) {
    if (n == sentinelle) {
        n = new Noeud(cle);
        n.couleur = Couleur.ROUGE;
        n.gauche = sentinelle;
        n.droit = sentinelle;
    } else if (cmp.compare(cle, n.cle) < 0) {
        n.gauche = inserer(n.gauche, cle);
        if (getBalance(n) == 2) {
            if (cmp.compare(cle, n.gauche.cle) < 0) {
                n = rotationDroite(n);
            } else {
                n.gauche = rotationGauche(n.gauche);
                n = rotationDroite(n);
            }
        }
    } else if (cmp.compare(cle, n.cle) > 0) {
        n.droit = inserer(n.droit, cle);
        if (getBalance(n) == -2) {
            if (cmp.compare(cle, n.droit.cle) > 0) {
                n = rotationGauche(n);
            } else {
                n.droit = rotationDroite(n.droit);
                n = rotationGauche(n);
            }
        }
    }
    
    n.hauteur = Math.max(
    
    /**
    
    Voici quelques exemples d'arbres équilibrés :

	    Arbres AVL : ces arbres utilisent des rotations pour maintenir l'équilibre, de sorte que la différence de hauteur entre les deux sous-arbres d'un noeud ne dépasse pas 1.
	    Arbres rouge-noir : ces arbres utilisent une couleur rouge ou noire pour chaque noeud, avec des règles strictes pour maintenir l'équilibre.
	    Arbres binaires de recherche équilibrés : ces arbres utilisent également des rotations pour maintenir l'équilibre, mais ils ne sont pas aussi stricts que les arbres AVL.
	    Arbres splay : ces arbres modifient l'ordre des noeuds en utilisant des rotations chaque fois qu'un noeud est accédé, ce qui permet de maintenir l'équilibre de l'arbre.


    
    **/

