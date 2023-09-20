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
		if(root == null) {
			return null;
		}
		if(valor == root.info) {
			return root;
		}else {
			if(valor > root.info){
				return buscar(root.right, valor);
				
			//	if(valor == root.right.info) {
					//resultado = root.left;
				//}
				
			}else {
				return buscar(root.left, valor);
				//if(valor == root.left.info) {
					//resultado = root.left;
				//}

			}
		}
		//return resultado;
		
	}
	Node minimum(Node root) {
		if(root.left != null) {
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
}
