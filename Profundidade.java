import java.util.*;

public class Profundidade {

    private Map<String, List<String>> adjacencias;

    public Profundidade() {
        adjacencias = new HashMap<>();
    }

    public void adicionarLocal(String local) {
        adjacencias.putIfAbsent(local, new ArrayList<>());
    }

    public void adicionarConexao(String origem, String destino) {
        adicionarLocal(origem);
        adicionarLocal(destino);
        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem);
    }

    public void exibirMapa() {
        for (String local : adjacencias.keySet()) {
            System.out.println(local + " -> " + adjacencias.get(local));
        }
    }

    // DFS retorna lista de vértices visitados na ordem
    public List<String> dfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        Stack<String> pilha = new Stack<>();
        List<String> ordemVisita = new ArrayList<>();

        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            String atual = pilha.pop();

            if (!visitados.contains(atual)) {
                visitados.add(atual);
                ordemVisita.add(atual);

                List<String> vizinhos = adjacencias.get(atual);
                Collections.sort(vizinhos, Collections.reverseOrder());
                for (String vizinho : vizinhos) {
                    if (!visitados.contains(vizinho)) {
                        pilha.push(vizinho);
                    }
                }
            }
        }
        return ordemVisita;
    }

    public static void main(String[] args) {
        Profundidade grafo = new Profundidade();

        grafo.adicionarConexao("Aeroporto", "Centro");
        grafo.adicionarConexao("Centro", "Estação");
        grafo.adicionarConexao("Estação", "Universidade");
        grafo.adicionarConexao("Universidade", "Shopping");
        grafo.adicionarConexao("Shopping", "Centro");

        grafo.exibirMapa();

        System.out.println();

        List<String> verticesVisitados = grafo.dfs("Aeroporto");
        System.out.println("Vértices visitados na ordem DFS: " + verticesVisitados);
    }
}
