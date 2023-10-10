package ed_2;

public class Tree {
Node root;
	
	Tree(int valor){
		root = new Node(valor);
	}
	
	void insert(int value) {
		insert(root, value);
	}
	void insert(Node root, int valor) {
		if(root == null) {
			root = new Node();
			root.info = valor;
		}else {
			if(valor < root.info) {
				if(root.left == null) {
					root.left = new Node(valor);
					root.left.parent = root;
				}else {
					insert(root.left, valor);
				}
				
		
			}else if(valor > root.info){	
				if(root.right == null) {
					root.right = new Node(valor);
					root.right.parent = root;
				}else {
					insert(root.right, valor);
				}
			}
		}
		
	}
	
	void inOrder() {
		inOrder(root);
	}
	
	void inOrder(Node root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.info + " - ");
		inOrder(root.right);
	}
	
	void preOrder() {
		preOrder(root);
	}
	
	void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.info + " - ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	void posOrder() {
		posOrder(root);
	}
	
	void posOrder(Node root) {
		if(root == null) {
			return;
		}
		posOrder(root.left);
		posOrder(root.right);
		System.out.print(root.info + " - ");
	}
	
	Node buscar(int valor) {
		return buscar(root,  valor);
		
	}
	Node buscar(Node root, int valor) {
		// se o nó estiver vazio
		if(root == null) {
			//retorna nulo
			return null;
		}
		//se  o valor buscado for igual a raiz, retorna a raiz
		if(valor == root.info) {
			return root;
		}else {
			//se não, se o valor for maior que a raiz, busca para o lado direito
			
			if(valor > root.info){
				//retorna chamando o metodo
				return buscar(root.right, valor);
				
			
				
			}else {// se nao, busca a esquerda
				return buscar(root.left, valor);
				

			}
		}
		//return resultado;
		
	}
	Node minimum(Node root) {
		// se o nó a esquerda da raiz não estiver nulo
		if(root.left != null) {
			//retorna chamando o metodo de novo, e procura o menor numero do lado esquerdo
			return minimum(root.left);
		}
		return root;
	}
	
	void remover(int valor) {
		Node node1 = buscar(root,valor);
		
		int x = node1.info;
		
		//1º condição - Node folha
		//verifica se o nó nao tem filhos
		if(node1.left == null && node1.right == null) {
			//verifica se o nó está a esquerd ou direita
			if(node1.info < node1.parent.info) {
				//está dizendo que o pai do ó a esquerda é nulo, ou seja
				// dizendo ao pai que o filho é nulo
				node1.parent.left = null;
				//agora está dizendo ao nó que ele é nulo
				node1 = null;
				//parent.node1= null;
				System.out.println("O nó "+x+" foi removido");
			}else {
				node1.parent.right = null;
				node1 = null;
				System.out.println("O nó"+x+" foi removido");
			}
			//return;
			
			//se node tem 1 filho
		}else if(node1.left == null || node1.right == null) {
				// se o node é menor que o pai
				if(node1.info < node1.parent.info) {
					//se o filho a esquerda é menor que o node
					if(node1.left.info < node1.info) {
					//  o node1 que esta a 
						node1.left.parent = node1.parent;
						node1.parent.left = node1.left;
						return;
					}
					//se o node a direita for maior que o node pai
					if(node1.right.info > node1.info) {
						node1.left.parent = node1.parent;
						node1.parent.left = node1.right;
						return;
					}
			
				}
				if(node1.info > node1.parent.info) {
					//se o node
					if(node1.left.info < node1.info) {
						node1.right.parent = node1.parent;
						node1.parent.right = node1.left;
						return;
					}
					if(node1.right.info > node1.info) {
						node1.right.parent = node1.parent;
						node1.parent.right = node1.right;
						return;
					}
				}
				//se o node tem 2 filhos
			}else if(node1.left != null && node1.right != null){
				Node sucessor = minimum(node1.right);
				remover(sucessor.info);
				node1.info = sucessor.info;
		}
	}


	Node rotacaoSimples(Node root) {
		//caso 1: FB do root é +2 e do filho direito do root +1
		Node right = root.right;
		root.right = right.left;
		right.left.parent = root;
		right.left = root;
		root.parent = right;
		return right;
	}
	
	int height() {
		return height(root);
	}
	int height(Node root) {
	
		int h_left = 0;
		int h_right = 0;
		int maior = 0;
		
		if(root == null){
			return -1;
		}
		
		h_left = height(root.left);
		h_right = height(root.right);

		if(h_left > h_right){
			
			maior = h_left;
			
		}else{
			
			maior = h_right;
			
		}
		return maior +1;
	}


}
