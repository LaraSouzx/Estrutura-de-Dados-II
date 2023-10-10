package ed_2;

public class Principal {

	public static void main(String[] args) {
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
