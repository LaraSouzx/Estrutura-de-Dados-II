package ed_2;
import java.util.ArrayList;
public class Principal {

	public static void main(String[] args) {
		
		Vertice v12 = new Vertice(12);
		Vertice v15 = new Vertice(15);
		Vertice v10= new Vertice(10);
		Vertice v17 = new Vertice(17);
		Vertice v14 = new Vertice(14);
		Vertice v16 = new Vertice(16);
		
		Grafo g = new Grafo();
		g.adicionarVertice(v12);
		g.adicionarVertice(v14);
		g.adicionarVertice(v17);
		g.adicionarVertice(v15);
		g.adicionarVertice(v10);
		g.adicionarVertice(v16);
		g.adicionarAresta(0, v12, v15);
		g.adicionarAresta(9, v12, v10);
		g.adicionarAresta(8, v12, v17);
		g.adicionarAresta(10, v15, v17);
		g.adicionarAresta(0, v17, v14);
		g.adicionarAresta(0, v14, v16);
		
		
		ArrayList<Vertice> busca =  g.buscaEmLargura(v12);
		System.out.print("Busca em Largura: ");
		for(int i = 0; i< busca.size(); i++) {
			int j = busca.get(i).info;
			System.out.print(j+ " ");
			
		}
		System.out.print(" \n");
		System.out.print("Busca em Profundidade: ");
		ArrayList<Vertice> busca1 =  g.buscaProfundidade(v12);
		for(int i = 0; i< busca1.size(); i++) {
			int j = busca1.get(i).info;
			System.out.print(j+ " ");
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*		   15

		 *       /   \            EM ORDEM: 9 - 12 - 14 - 15 - 17 - 19 - 23

		 *      12   19           PÓS POS ORDEM : 9 - 14 - 12 - 17 - 23 - 19 - 15

		 *     /  \ /  \

		 *    9  14 17 23

		 *   /          \

		 *  5           27 

		 *              

		 *    

		 *  - Métodos:

		 *  	- Insert;

		 *  	- Buscar;

		 *  	- Remover;

		 *  	- RotaçãoSimples;

		 *  	- Height(altura);

		 * */

		//nova arvore

		Tree tree = new Tree(15);

		tree.insert(12);

		tree.insert(19);

		tree.insert(14);

		tree.insert(23);

		tree.insert(9);

		tree.insert(17);

		//testando métodos: 

		int altura = tree.height();

		System.out.print("a altura da arvore e: "+altura);

		System.out.println("PRINT ARVORE PRE ORDEM!");

		tree.preOrder();

		System.out.println("\nPRINT ARVORE EM ORDEM!");

		tree.inOrder();

		System.out.println("\nPRINT ARVORE POS ORDEM!");

		tree.posOrder();

		Node resultado = tree.buscar(56);

		if(resultado != null)

		  System.out.println("O valor procurado esta no nó de endereco: "+resultado.info);

		tree.remover(17);



		
		

	}

}
