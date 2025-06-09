public class CategoriaBST {

    // Classe para representar uma categoria na árvore
    static class Categoria {
        String nome;
        Categoria esquerda;
        Categoria direita;

        public Categoria(String nome) {
            this.nome = nome;
        }
    }

    // Método principal para verificar se é uma árvore binária de busca
    public static boolean ehBST(Categoria raiz) {
        return ehBSTRec(raiz, null, null);
    }

    // Método auxiliar recursivo com limites mínimo e máximo
    private static boolean ehBSTRec(Categoria no, String min, String max) {
        if (no == null) {
            return true;
        }

        // Verifica se o nome está fora dos limites definidos
        if ((min != null && no.nome.compareTo(min) <= 0) ||
            (max != null && no.nome.compareTo(max) >= 0)) {
            return false;
        }

        // Verifica recursivamente as subárvores esquerda e direita
        return ehBSTRec(no.esquerda, min, no.nome) &&
               ehBSTRec(no.direita, no.nome, max);
    }

    // Método para exibir o resultado com mensagem clara
    public static void verificarBST(Categoria raiz) {
        if (ehBST(raiz)) {
            System.out.println(" A árvore é uma Árvore Binária de Busca (BST).");
        } else {
            System.out.println(" A árvore NÃO é uma Árvore Binária de Busca (BST).");
        }
    }

    // Teste do sistema
    public static void main(String[] args) {

        System.out.println("Teste 1 (válido):");
        Categoria raiz1 = new Categoria("Eletrônicos");
        raiz1.esquerda = new Categoria("Celulares");
        raiz1.direita = new Categoria("Informática");

        verificarBST(raiz1); // 

        System.out.println("\nTeste 2 (inválido):");
        Categoria raiz2 = new Categoria("Eletrônicos");
        raiz2.esquerda = new Categoria("TVs"); // Incorreto: "TVs" > "Eletrônicos"
        raiz2.direita = new Categoria("Informática");

        verificarBST(raiz2); // 
    }
}

