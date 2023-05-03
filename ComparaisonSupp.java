public class ComparaisonSupp {
    // Comparaison de la suppression dans un ABR et un ABRN

    public static void main(String[] args){
        // Teste de performance de ABR et ABRN pour la suppression sur 100 elements
        System.out.println("cas défavorable");
        int n = 0;
        ABRN<Integer> arbre = new ABRN<Integer>();
        ABR<Integer> arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            arbre.add(i);
            arbre2.add(i);
        }
        long t1 = System.currentTimeMillis();
        arbre.remove(50);
        long t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(50);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 50 elements
        n = 50;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            arbre.add(i);
            arbre2.add(i);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(25);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(25);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 200 elements
        n = 200;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            arbre.add(i);
            arbre2.add(i);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(100);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(100);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 800 elements
        n = 800;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            arbre.add(i);
            arbre2.add(i);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(400);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(400);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 3200 elements
        n = 3200;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            arbre.add(i);
            arbre2.add(i);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(1600);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(1600);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 12800 elements
        n = 12800;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            arbre.add(i);
            arbre2.add(i);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(6400);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(6400);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 51200 elements
        n = 51200;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            arbre.add(i);
            arbre2.add(i);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(25600);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(25600);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 204800 elements
        n = 204800;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            arbre.add(i);
            arbre2.add(i);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(102400);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(102400);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        System.out.println("Cas favorables");
        // Teste de performance de ABR et ABRN pour la suppression sur 0 elements
        n = 0;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
            arbre2.add(x);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(0);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(0);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 50 elements
        n = 50;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
            arbre2.add(x);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(25);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(25);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 200 elements
        n = 200;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
            arbre2.add(x);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(100);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(100);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 800 elements
        n = 800;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
            arbre2.add(x);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(400);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(400);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 3200 elements
        n = 3200;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
            arbre2.add(x);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(1600);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(1600);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 12800 elements
        n = 12800;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
            arbre2.add(x);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(6400);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(6400);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));
        
        // Teste de performance de ABR et ABRN pour la suppression sur 51200 elements
        n = 51200;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
            arbre2.add(x);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(25600);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(25600);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));

        // Teste de performance de ABR et ABRN pour la suppression sur 204800 elements
        n = 204800;
        arbre = new ABRN<Integer>();
        arbre2 = new ABR<Integer>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 100);
            arbre.add(x);
            arbre2.add(x);
        }
        t1 = System.currentTimeMillis();
        arbre.remove(102400);
        t2 = System.currentTimeMillis();
        System.out.println("ABRN: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        arbre2.remove(102400);
        t2 = System.currentTimeMillis();
        System.out.println("ABR: " + (t2 - t1));


    }
}
