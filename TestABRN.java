import java.util.*;

public class TestABRN {
    public static void main(String[] args) {
        // Teste de la classe ABRN avec des strings
        ABRN<Integer> arbre = new ABRN<>();
        for (int i=0;i<50;i++){
            int n = (int)(Math.random() * 100);
            arbre.add(n);
        }
        
        // affichage de l'arbre
        System.out.println(arbre.toString());
        //teste de l'itérateur
        Iterator<Integer> it = arbre.iterator();
        while (it.hasNext()){
            it.remove();
        }
        
        // teste du constructeur qui prend une collection en paramètre avec une liste d'entiers
        ABRN arbre2 = new ABRN(Arrays.asList(5,3,7,2,4,6,8,1,9,10));
        System.out.println(arbre2.toString());
        
        // teste de la méthode size()
        System.out.println(arbre2.size());
        
        System.out.println(arbre2.toString());
        
        //test suppression d'un élément qui n'existe pas
        System.out.println("test suppression d'un élément qui n'existe pas : 11");
        arbre2.remove(11);
        System.out.println(arbre2.toString());
        
        //test suppression d'une feuille
        System.out.println("test suppression d'une feuille : 1");
        arbre2.remove(1);
        System.out.println(arbre2.toString());
        
        //test suppression d'un noeud qui a un fils droit
        System.out.println("test suppression d'un noeud qui a un fils droit: 3");
        arbre2.remove(3);
        System.out.println(arbre2.toString());
        
        //test suppression d'un noeud qui a un fils gauche
        System.out.println("test suppression d'un noeud qui a un fils gauche : 7");
        arbre2.remove(7);
        System.out.println(arbre2.toString());
        
        //test suppression d'un noeud qui a deux fils
        System.out.println("test suppression d'un noeud qui a deux fils : 9");
        arbre2.remove(9);
        System.out.println(arbre2.toString());
        
        //test suppression de la racine
        System.out.println("test suppression de la racine : 5");
        arbre2.remove(5);
        System.out.println(arbre2.toString());

        //teste de la méthode contains()
        System.out.println("teste de la méthode contains()");
        System.out.println(arbre2.contains(2));
        
        //teste de la méthode contains() avec un élément qui n'existe pas
        System.out.println("teste de la méthode contains() avec un élément qui n'existe pas");
        System.out.println(arbre2.contains(11));
        
        //teste de la méthode contains() avec un arbre vide
        System.out.println("teste de la méthode contains() avec un arbre vide");
        ABRN arbre3 = new ABRN();
        System.out.println(arbre3.contains(11));
        
        //teste de la méthode add()
        System.out.println("teste de la méthode add()");
        arbre2.add(11);
        System.out.println(arbre2.toString());
        //teste de la méthode add() avec un élément qui existe déjà
        System.out.println("teste de la méthode add() avec un élément qui existe déjà");
        arbre2.add(11);
        System.out.println(arbre2.toString());
        //teste de la méthode add() avec un arbre vide
        System.out.println("teste de la méthode add() avec un arbre vide");
        arbre3.add(11);
        System.out.println(arbre3.toString());
        //teste de la méthode add() ajout d'une feuille

        
    }
}
