import java.util.*;

public class MapaDeRotas {

    private Map<String, List<String>> adjacencias;

    public MapaDeRotas() {
        this.adjacencias = new HashMap<>();
    }

    public void adicionarLocal(String local) {
        adjacencias.putIfAbsent(local, new ArrayList<>());
    }

    public void adicionarConexao(String origem, String destino) {
        adicionarLocal(origem);
        adicionarLocal(destino);
        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem); // grafo não direcionado
    }

    public void exibirMapa() {
        System.out.println("Mapa de conexões:");
        for (String local : adjacencias.keySet()) {
            System.out.println(local + " -> " + adjacencias.get(local));
        }
    }

    public List<String> bfs(String origem, String destino) {
        if (!adjacencias.containsKey(origem) || !adjacencias.containsKey(destino)) {
            return new ArrayList<>();
        }

        Queue<String> fila = new LinkedList<>();
        Map<String, String> caminhoAnterior = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            String atual = fila.poll();

            if (atual.equals(destino)) break;

            for (String vizinho : adjacencias.get(atual)) {
                if (!visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    visitados.add(vizinho);
                    caminhoAnterior.put(vizinho, atual);
                }
            }
        }

        List<String> caminho = new LinkedList<>();
        String atual = destino;

        while (atual != null && caminhoAnterior.containsKey(atual)) {
            caminho.add(0, atual);
            atual = caminhoAnterior.get(atual);
        }

        if (origem.equals(destino)) {
            caminho.add(origem);
        } else if (!caminho.isEmpty()) {
            caminho.add(0, origem);
        }

        return caminho;
    }

    public static void main(String[] args) {
        MapaDeRotas grafo = new MapaDeRotas();

        grafo.adicionarConexao("Aeroporto", "Centro");
        grafo.adicionarConexao("Centro", "Estação");
        grafo.adicionarConexao("Estação", "Universidade");
        grafo.adicionarConexao("Universidade", "Shopping");
        grafo.adicionarConexao("Shopping", "Centro");

        grafo.exibirMapa();

        String origem = "Aeroporto";
        String destino = "Shopping";
        List<String> caminhoMaisCurto = grafo.bfs(origem, destino);

        if (caminhoMaisCurto.isEmpty()) {
            System.out.println("Não há caminho entre os vértices " + origem + " e " + destino);
        } else {
            System.out.println("Caminho mais curto entre " + origem + " e " + destino + ": " + caminhoMaisCurto);
        }
    }
}
