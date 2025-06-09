public class BibliotecaApp {

    // Classe Livro
    static class Livro {
        String titulo;
        String autor;
        String codigo; // código simples de 2 números

        public Livro(String titulo, String autor, String codigo) {
            this.titulo = titulo;
            this.autor = autor;
            this.codigo = codigo;
        }

        @Override
        public String toString() {
            return "Livro{" +
                    "Título='" + titulo + '\'' +
                    ", Autor='" + autor + '\'' +
                    ", Código='" + codigo + '\'' +
                    '}';
        }
    }

    // Classe Nó
    static class No {
        Livro livro;
        No esquerdo;
        No direito;

        public No(Livro livro) {
            this.livro = livro;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    // Classe Árvore Binária
    static class ArvoreBiblioteca {
        private No raiz;

        public ArvoreBiblioteca() {
            this.raiz = null;
        }

        // Método para inserir novo livro com código simples
        public void inserirLivro(String titulo, String autor, String codigo) {
            Livro novoLivro = new Livro(titulo, autor, codigo);
            raiz = inserirRec(raiz, novoLivro);
        }

        private No inserirRec(No atual, Livro livro) {
            if (atual == null) {
                return new No(livro);
            }

            if (livro.titulo.compareToIgnoreCase(atual.livro.titulo) < 0) {
                atual.esquerdo = inserirRec(atual.esquerdo, livro);
            } else {
                atual.direito = inserirRec(atual.direito, livro);
            }

            return atual;
        }

        public void emOrdem() {
            System.out.println("Livros em ordem (título):");
            emOrdemRec(raiz);
        }

        private void emOrdemRec(No atual) {
            if (atual != null) {
                emOrdemRec(atual.esquerdo);
                System.out.println(atual.livro);
                emOrdemRec(atual.direito);
            }
        }

        public void preOrdem() {
            System.out.println("Livros em pré-ordem:");
            preOrdemRec(raiz);
        }

        private void preOrdemRec(No atual) {
            if (atual != null) {
                System.out.println(atual.livro);
                preOrdemRec(atual.esquerdo);
                preOrdemRec(atual.direito);
            }
        }

        public void posOrdem() {
            System.out.println("Livros em pós-ordem:");
            posOrdemRec(raiz);
        }

        private void posOrdemRec(No atual) {
            if (atual != null) {
                posOrdemRec(atual.esquerdo);
                posOrdemRec(atual.direito);
                System.out.println(atual.livro);
            }
        }
    }

    // Classe principal
    public static void main(String[] args) {
        ArvoreBiblioteca biblioteca = new ArvoreBiblioteca();

        // Inserindo livros com código de 2 números
        biblioteca.inserirLivro("O Senhor dos Anéis", "J.R.R. Tolkien", "01");
        biblioteca.inserirLivro("Dom Casmurro", "Machado de Assis", "02");
        biblioteca.inserirLivro("A Revolução dos Bichos", "George Orwell", "03");
        biblioteca.inserirLivro("1984", "George Orwell", "04");

        // Listagens
        biblioteca.emOrdem();
        System.out.println();
        biblioteca.preOrdem();
        System.out.println();
        biblioteca.posOrdem();
    }
}

