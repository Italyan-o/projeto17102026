package aplicacao;

import java.util.Scanner;

public class Leitor {

    private Scanner scanner = new Scanner(System.in);
    private int codigo;
    private String nome;
    private String email;

    public Leitor(int codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public void atualizarDados(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public int getCodigo() {
        return this.codigo;
    }
    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.nome + " ("+this.email+")";
    }
}
