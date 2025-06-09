public class BuscaBinaria {

    // Método que realiza busca binária
    public static int buscaBinaria(int[] array, int valorBuscado) {
        int esquerda = 0;
        int direita = array.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (array[meio] == valorBuscado) {
                return meio;  // Encontrou, retorna índice
            }

            if (array[meio] < valorBuscado) {
                esquerda = meio + 1;  // Busca na metade direita
            } else {
                direita = meio - 1;   // Busca na metade esquerda
            }
        }

        return -1;  // Não encontrado
    }

    // Teste simples
    public static void main(String[] args) {
        int[] listaOrdenada = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int numeroParaBuscar = 38;

        int posicao = buscaBinaria(listaOrdenada, numeroParaBuscar);

        if (posicao != -1) {
            System.out.println("Número " + numeroParaBuscar + " encontrado na posição: " + posicao);
        } else {
            System.out.println("Número " + numeroParaBuscar + " não encontrado na lista.");
        }
    }
}
