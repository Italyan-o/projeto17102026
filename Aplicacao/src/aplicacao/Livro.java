package aplicacao;

public class Livro {

    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private String disponibilidade;

    public Livro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void atualizarDados(String titulo, String autor) {
        if (titulo != null && !titulo.isBlank()) {
            this.titulo = titulo;
        }
        if (autor != null && !autor.isBlank()) {
            this.autor = autor;
        }
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }
    
    @Override
    public String toString() {
        if (this.disponivel == true) {
            this.disponibilidade = "Disponível";
        } else{
            this.disponibilidade = "Indisponível";
        }
        return this.codigo + " - " + this.titulo + "(" + this.autor + ")" + " - " + this.disponibilidade;
    }
}
