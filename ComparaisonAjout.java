import  java.util.*;
public class ComparaisonAjout {
    //test de performance entre ABR et ABRN

    public static void main(String[] args) {
        // Teste de performance de ABR et ABRN pour l'ajout cas défavorable
        ABRN<Integer> arbre = new ABRN<Integer>();
        ABR<Integer> arbre2 = new ABR<Integer>();
        //test de performance pour 0 element
        int n = 0;
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            arbre.add(i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
         // Teste de la performance de ABR et ABRN pour l'ajout sur 50 elements
         n = 50;
         arbre = new ABRN<Integer>();
         arbre2 = new ABR<Integer>();
         t1 = System.currentTimeMillis();
         for(int i = 0; i < n; i++) {
             /* int x = (int)(Math.random() * 100);
             arbre.add(x); */
             arbre2.add(i);
         }
         t2 = System.currentTimeMillis();
         System.out.println("ABRN: " + (t2-t1));
         t1 = System.currentTimeMillis();
         for(int i = 0; i < n; i++) {
             /* int x = (int)(Math.random() * 100);
             arbre2.add(x); */
             arbre2.add(i);
         }
         t2 = System.currentTimeMillis();
         System.out.println("ABR: " + (t2-t1));
        // Teste de la performance pour l'ajout de 200 elements
        n = 200;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            /* int x = (int)(Math.random() * 100);
            arbre.add(x); */
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            /* int x = (int)(Math.random() * 100);
            arbre2.add(x); */
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
        // Teste de la performance pour l'ajout de 800 elements
        n = 800;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            /* int x = (int)(Math.random() * 100);
            arbre.add(x); */
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            /* int x = (int)(Math.random() * 100);
            arbre2.add(x); */
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
        // Teste de la performance pour l'ajout de 3200 elements
        n = 3200;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
           /*  int x = (int)(Math.random() * 100);
            arbre.add(x); */
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
           /*  int x = (int)(Math.random() * 100);
            arbre2.add(x); */
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
        // Teste de la performance pour l'ajout de 12800 elements
        n = 12800;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            /* int x = (int)(Math.random() * 100);
            arbre.add(x); */
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            /* int x = (int)(Math.random() * 100);
            arbre2.add(x); */
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
        // Teste de performance de ABR et ABRN pour l'ajout
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        // Teste de la performance de ABR et ABRN pour l'ajout sur 51200 elements
        n = 51200;
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            arbre.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
    
        // Teste de la performance de ABR et ABRN pour l'ajout sur 204800 elements

        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        n = 204800;
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            arbre.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            arbre2.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
    
        System.out.println("Cas favorable");
        // Teste de la performance pour l'ajout cas favorable
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        // Teste de la performance pour l'ajout de 0 elements
        n = 0;
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();    
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre2.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));

        // Teste de la performance pour l'ajout de 800 elements
        n = 800;
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre2.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
        // Teste de la performance pour l'ajout de 3200 elements
        n = 3200;
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre2.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
        // Teste de la performance pour l'ajout de 12800 elements
        n = 12800;
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre2.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
        // Teste de performance de ABR et ABRN pour l'ajout de 51200 elements
        n = 51200;
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre2.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));
        // Teste de performance de ABR et ABRN pour l'ajout de 204800 elements
        n = 204800;
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2-t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre2.add(x);
        }
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2-t1));    
        
    }
}
