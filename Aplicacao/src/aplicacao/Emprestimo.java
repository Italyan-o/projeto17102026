package aplicacao;

import java.time.LocalDate;
import java.util.ArrayList;

public class Emprestimo {

    private int codigo;
    private LocalDate dataEmprestimo;
    private boolean aberto;
    private Leitor leitor;
    private ArrayList<ItemEmprestimo> itens;

    public Emprestimo(int codigo, Leitor leitor) {
        this.codigo = codigo;
        this.leitor = leitor;
        this.dataEmprestimo = LocalDate.now();
        this.aberto = true;
        this.itens = new ArrayList<>();
    }

    public boolean adicionarLivro(Livro livro) {
        if (livro != null && !contemLivro(livro)) {
            ItemEmprestimo item = new ItemEmprestimo(livro);
            this.itens.add(item);
            livro.emprestar();
            return true;
        }
        return false;
    }

    public boolean contemLivro(Livro livro) {
        if (livro == null) {
            return false;
        }
        for (ItemEmprestimo item : itens) {
            if (item.getLivro().getCodigo() == livro.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    public void finalizar() {
        for (ItemEmprestimo item : itens) {
            item.registrarDevolucao();
            item.getLivro().devolver();
        }
        this.aberto = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isAberto() {
        return aberto;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codigo).append(" - ").append(leitor.getNome())
                .append(" - ").append(dataEmprestimo)
                .append(" - ").append(aberto ? "aberto" : "finalizado")
                .append(" - livros: ");
        for (int i = 0; i < itens.size(); i++) {
            sb.append(itens.get(i).getLivro().getTitulo());
            if (i < itens.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
