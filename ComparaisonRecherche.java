import  java.util.*;
public class ComparaisonRecherche {
	public static void main(String[] args) {
		System.out.println("Test de performance pour la recherche cas defavorable");
		// Teste de performance pour la recherche sur 0 element
		ABRN<Integer> arbre = new ABRN<Integer>();
		ABR<Integer> arbre2 = new ABR<Integer>();
		int n = 0;
		for (int i = 0; i < n; i++) {
			arbre.add(i);
		}
		long t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(50));
		long t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		t1 = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			arbre2.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(50));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));
		
		// Teste de la performance pour la recherche sur 50 elements
		n = 50;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(50));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(50));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));
		
		
		// Teste de performance de ABR et ABRN pour la recherche sur 200 elements
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		n = 200;
		for (int i = 0; i < n; i++) {
			arbre.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			arbre2.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));
		
		// Teste de performance de ABR et ABRN pour la recherche sur 800 elements
		n = 800;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));
		
		
		// Teste de performance pour la recherche sur 3200 elements
		n = 3200;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			arbre.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			arbre2.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 12800 elements
		n = 12800;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			arbre2.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			arbre2.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 51200 elements
		n = 51200;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			arbre.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			arbre2.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 204800 elements
		n = 204800;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			arbre.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			arbre2.add(i);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		System.out.println("Cas favorable ");
		// Teste de performance pour la recherche sur 0 element
		n = 0;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 50 elements
		n = 50;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 200 elements
		n = 200;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 800 elements
		n = 800;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 3200 elements
		n = 3200;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 12800 elements
		n = 12800;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 51200 elements
		n = 51200;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));

		// Teste de performance pour la recherche sur 204800 elements
		n = 204800;
		arbre = new ABRN<Integer>();
		arbre2 = new ABR<Integer>();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABRN: " + (t2 - t1));
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100);
			arbre2.add(x);
		}
		t1 = System.currentTimeMillis();
		System.out.println(arbre2.contains(500));
		t2 = System.currentTimeMillis();
		System.out.println("ABR: " + (t2 - t1));
		

	}
}
