package aplicacao;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Leitor> leitores = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public boolean cadastrarLeitor(Leitor leitor) {
        if (leitor == null || leitor.getCodigo() <= 0) {
            return false;
        }
        if (consultarLeitor(leitor.getCodigo()) != null) {
            return false;
        }
        return this.leitores.add(leitor);
    }

    public Leitor consultarLeitor(int codigo) {
        for (Leitor leitor : leitores) {
            if (leitor.getCodigo() == codigo) {
                return leitor;
            }
        }
        return null;
    }

    public void listarLeitores() {
        if (leitores.isEmpty()) {
            System.out.println("Nenhum leitor cadastrado.");
            return;
        }
        for (Leitor leitor : leitores) {
            System.out.println(leitor);
        }
    }

    public boolean removerLeitor(Leitor leitor) {
        if (leitor == null) {
            return false;
        }
        for (Emprestimo e : emprestimos) {
            if (e.getLeitor().getCodigo() == leitor.getCodigo() && e.isAberto()) {
                return false;
            }
        }
        return this.leitores.remove(leitor);
    }

    public boolean cadastrarLivro(Livro livro) {
        if (livro == null || livro.getCodigo() <= 0) {
            return false;
        }
        if (consultarLivro(livro.getCodigo()) != null) {
            return false;
        }
        return this.livros.add(livro);
    }

    public Livro consultarLivro(int codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public boolean removerLivro(Livro livro) {
        if (livro == null) {
            return false;
        }
        for (Emprestimo e : emprestimos) {
            if (e.isAberto() && e.contemLivro(livro)) {
                return false;
            }
        }
        return this.livros.remove(livro);
    }

    public boolean registrarEmprestimo(int codigo, Leitor leitor, ArrayList<Livro> livros) {
        if (codigo <= 0) {
            return false;
        }

        for (Emprestimo e : emprestimos) {
            if (e.getCodigo() == codigo) {
                return false;
            }
        }

        if (leitor == null || livros == null || livros.isEmpty()) {
            return false;
        }

        ArrayList<Livro> livrosValidos = new ArrayList<>();
        for (Livro l : livros) {
            if (l == null || !l.isDisponivel() || livrosValidos.contains(l)) {
                return false;
            }
            livrosValidos.add(l);
        }

        Emprestimo emprestimo = new Emprestimo(codigo, leitor);
        for (Livro l : livrosValidos) {
            emprestimo.adicionarLivro(l);
        }

        this.emprestimos.add(emprestimo);
        return true;
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        for (Emprestimo e : emprestimos) {
            System.out.println(e);
        }
    }

    public boolean registrarDevolucao(int codigo) {
        for (Emprestimo e : this.emprestimos) {
            if (e.getCodigo() == codigo && e.isAberto()) {
                e.finalizar();
                return true;
            }
        }
        return false;
    }
}
