package aplicacao;

public class ItemEmprestimo { 
    private Livro livro; 
    private boolean devolvido;

    public ItemEmprestimo(Livro livro) {
        this.livro = livro;
        this.devolvido = false;
    }

    public void registrarDevolucao() {
        this.devolvido = true;
    }

    public Livro getLivro() {
        return this.livro;
    }
}