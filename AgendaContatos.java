public class AgendaContatos {

    // Método para busca linear
    public static int buscaLinear(int[] lista, int numeroBuscado) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == numeroBuscado) {
                return i;  // Retorna índice da primeira ocorrência encontrada
            }
        }
        return -1;  // Número não encontrado
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] contatos = {55, 21, 99, 42, 33, 21};
        int numeroParaBuscar = 42;

        int posicao = buscaLinear(contatos, numeroParaBuscar);

        if (posicao != -1) {
            System.out.println("Número " + numeroParaBuscar + " encontrado na posição: " + posicao);
        } else {
            System.out.println("Número " + numeroParaBuscar + " não encontrado na lista.");
        }
    }
}
