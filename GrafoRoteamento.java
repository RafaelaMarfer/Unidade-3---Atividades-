import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GrafoRoteamento {

    // Mapa que armazena os locais e suas conexões
    private Map<String, List<String>> adjacencias;

    // Construtor
    public GrafoRoteamento() {
        this.adjacencias = new HashMap<>();
    }

    // Adiciona um local ao grafo (vértice)
    public void adicionarLocal(String local) {
        adjacencias.putIfAbsent(local, new ArrayList<>());
    }

    // Adiciona uma conexão entre dois locais (aresta)
    public void adicionarConexao(String origem, String destino) {
        adicionarLocal(origem);
        adicionarLocal(destino);

        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem); // Remova se quiser grafo direcionado
    }

    // Exibe o mapa de conexões
    public void exibirMapa() {
        System.out.println("Mapa de conexões:");
        for (String local : adjacencias.keySet()) {
            System.out.println(local + " -> " + adjacencias.get(local));
        }
    }

    // Método principal (main)
    public static void main(String[] args) {
        GrafoRoteamento grafo = new GrafoRoteamento();

        grafo.adicionarConexao("Aeroporto", "Centro");
        grafo.adicionarConexao("Centro", "Estação");
        grafo.adicionarConexao("Estação", "Universidade");
        grafo.adicionarConexao("Universidade", "Shopping");
        grafo.adicionarConexao("Shopping", "Centro");

        grafo.exibirMapa();
    }
}
