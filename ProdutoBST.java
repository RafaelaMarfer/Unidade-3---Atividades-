public class ProdutoBST {

    // Classe que representa um produto na árvore
    static class Produto {
        double preco;
        String nome;
        Produto esquerdo;
        Produto direito;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }
    }

    // Método para encontrar o menor valor (produto mais barato)
    public static Produto encontrarMaisBarato(Produto raiz) {
        if (raiz == null) return null;

        Produto atual = raiz;
        while (atual.esquerdo != null) {
            atual = atual.esquerdo;
        }
        return atual; // Produto mais barato
    }

    // Exemplo de construção de uma árvore BST de produtos
    public static void main(String[] args) {
        Produto raiz = new Produto("Notebook", 2500.00);
        raiz.esquerdo = new Produto("Mouse", 80.00);
        raiz.direito = new Produto("Smartphone", 1800.00);
        raiz.esquerdo.esquerdo = new Produto("Cabo USB", 25.00);
        raiz.direito.direito = new Produto("TV", 3000.00);

        Produto maisBarato = encontrarMaisBarato(raiz);

        if (maisBarato != null) {
            System.out.println("Produto mais barato:");
            System.out.println("Nome: " + maisBarato.nome);
            System.out.println("Preço: R$ " + maisBarato.preco);
        } else {
            System.out.println("A árvore está vazia.");
        }
    }
}
