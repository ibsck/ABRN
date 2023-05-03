import java.util.*;                                                             
										
class TestABR{                                                               
										
	public static void main(String[] args) {                                
	       //Teste de la classe ABR avec des strings
		ABR<String> arbre = new ABR<String>();
		arbre.add("a");
		arbre.add("b");
		arbre.add("c");
		arbre.add("d");
		arbre.add("e");
		arbre.add("f");
		
		//affichage de l'arbre
		System.out.println(arbre.toString());
		//teste de iterator()
		Iterator<String> it = arbre.iterator();
		
		//teste de remove() de ittérator
		while(it.hasNext()){
			String s = it.next();
			if(s.equals("c")){
				it.remove();
			}
		} 

		System.out.println(arbre.size());
		
		//test du constructeur qui prend une collection en paramètre avec une liste d'entiers
		ABR arbre2 = new ABR(Arrays.asList(5,3,7,2,4));
		System.out.println(arbre2.toString());
		
		//teste de la méthode size()
		System.out.println(arbre2.size());

		//teste de la méthode contains()
		System.out.println(arbre2.contains(3));

		//teste de la méthode remove()
		arbre2.remove(3);
		System.out.println(arbre2.toString());

		//teste de la méthode clear()
		arbre2.clear();
		System.out.println(arbre2.toString());

		//teste de la méthode isEmpty()
		System.out.println(arbre2.isEmpty());

		//teste de la méthode toArray()
		ABR arbre3 = new ABR(Arrays.asList(1,2,3,4,5));
		Object[] tab = arbre3.toArray();
		for(int i=0;i<tab.length;i++){
			System.out.println(tab[i]);
		}

		//teste de la méthode retainAll()
		ABR arbre4 = new ABR(Arrays.asList(5,3,7,2,4));
		List arbre5 = Arrays.asList(3,4,5);
		System.out.println(arbre4.toString());
		arbre4.retainAll(arbre5);
		System.out.println(arbre4.toString());

	}                                                                       
}                                                                               
   
