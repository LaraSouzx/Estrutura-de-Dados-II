package ed_2;

import java.util.ArrayList;
import java.util.Stack;

public class Grafo {

    // Declaração das variáveis de instância
    ArrayList<Vertice> vertices; // Vetor de vértices
    ArrayList<Aresta> arestas; // Vetor de arestas

    // Método para adicionar um vértice
    public void adicionarVertice(Vertice vertice) {
        // Adiciona o vértice ao vetor de vértices
        vertices.add(vertice);
    }

    // Método para adicionar uma aresta
    public void adicionarAresta(double peso, Vertice org, Vertice dst) {
        // Cria uma nova aresta
        Aresta novaAresta = new Aresta(peso, org, dst);

        // Adiciona a aresta ao vetor de arestas
        arestas.add(novaAresta);

        // Adiciona o vértice adjacente à lista de adjacentes do vértice de origem
        org.adjacentes.add(dst);

        // Adiciona o vértice adjacente à lista de adjacentes do vértice de destino
        dst.adjacentes.add(org);
    }

    // Método para realizar uma busca em largura a partir de um vértice
    public ArrayList<Vertice> buscaEmLargura(Vertice origem) {
        // Declaração das variáveis locais
        ArrayList<Vertice> marcados = new ArrayList<>(); // Vetor de vértices marcados
        ArrayList<Vertice> fila = new ArrayList<>(); // Fila de vértices a serem visitados

        // Marca o vértice de origem como marcado
        marcados.add(origem);

        // Adiciona o vértice de origem à fila de vértices a serem visitados
        fila.add(origem);

        // Enquanto a fila não estiver vazia
        while (!fila.isEmpty()) {
            // Remove o primeiro vértice da fila
            Vertice v = fila.remove(0);

            // Para cada vértice adjacente ao vértice atual
            for (int i = 0; i < v.adjacentes.size(); i++) {
                // Se o vértice adjacente não estiver marcado
                if (!marcados.contains(v.adjacentes.get(i))) {
                    // Marca o vértice adjacente como marcado
                    marcados.add(v.adjacentes.get(i));

                    // Adiciona o vértice adjacente à fila de vértices a serem visitados
                    fila.add(v.adjacentes.get(i));
                }
            }
        }

        // Retorna o vetor de vértices marcados
        return marcados;
    }

    // Método para realizar uma busca em profundidade a partir de um vértice
    public ArrayList<Vertice> buscaProfundidade(Vertice origem) {
        // Declaração das variáveis locais
        ArrayList<Vertice> marcados = new ArrayList<>(); // Vetor de vértices marcados
        Stack<Vertice> pilha = new Stack<>(); // Pilha de vértices a serem visitados

        // Marca o vértice de origem como marcado
        marcados.add(origem);

        // Adiciona o vértice de origem à pilha de vértices a serem visitados
        pilha.push(origem);

        // Enquanto a pilha não estiver vazia
        while (!pilha.isEmpty()) {
            // Remove o topo da pilha
            Vertice v = pilha.pop();

            // Para cada vértice adjacente ao vértice atual
            for (int i = 0; i < v.adjacentes.size(); i++) {
                // Se o vértice adjacente não estiver marcado
                if (!marcados.contains(v.adjacentes.get(i))) {
                    // Marca o vértice adjacente como marcado
                    marcados.add(v.adjacentes.get(i));

                    // Adiciona o vértice adjacente à pilha de vértices a serem visitados
                    pilha.push(v.adjacentes.get(i));
                }
            }
        }

        // Retorna o vetor de vértices marcados
        return marcados;
    }
}
