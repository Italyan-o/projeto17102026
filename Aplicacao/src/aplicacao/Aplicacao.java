package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();
        app.executar();
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = -1;

        do {
            System.out.println("\n--- MENU BIBLIOTECA ---");
            System.out.println("1 - Cadastrar leitor");
            System.out.println("2 - Consultar leitor");
            System.out.println("3 - Listar leitores");
            System.out.println("4 - Atualizar leitor");
            System.out.println("5 - Remover leitor");
            System.out.println("6 - Cadastrar livro");
            System.out.println("7 - Consultar livro");
            System.out.println("8 - Listar livros");
            System.out.println("9 - Atualizar livro");
            System.out.println("10 - Remover livro");
            System.out.println("11 - Registrar empréstimo");
            System.out.println("12 - Listar empréstimos");
            System.out.println("13 - Registrar devolução");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o código do leitor: ");
                        int codLeitor = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o e-mail: ");
                        String email = scanner.nextLine();

                        Leitor novoLeitor = new Leitor(codLeitor, nome, email);
                        if (biblioteca.cadastrarLeitor(novoLeitor)) {
                            System.out.println("Leitor cadastrado.");
                        } else {
                            System.out.println("Não foi possível cadastrar o leitor.");
                        }
                        break;

                    case 2:
                        System.out.print("Digite o código do leitor: ");
                        int codConsLeitor = Integer.parseInt(scanner.nextLine());
                        Leitor leitorConsultado = biblioteca.consultarLeitor(codConsLeitor);
                        if (leitorConsultado != null) {
                            System.out.println(leitorConsultado);
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;

                    case 3:
                        biblioteca.listarLeitores();
                        break;

                    case 4:
                        System.out.print("Digite o código do leitor que deseja atualizar: ");
                        int codAtuLeitor = Integer.parseInt(scanner.nextLine());
                        Leitor leitorParaAtualizar = biblioteca.consultarLeitor(codAtuLeitor);
                        if (leitorParaAtualizar != null) {
                            System.out.print("Digite o novo nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("Digite o novo e-mail: ");
                            String novoEmail = scanner.nextLine();

                            leitorParaAtualizar.atualizarDados(novoNome, novoEmail);
                            System.out.println("Dados do leitor atualizados.");
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;

                    case 5:
                        System.out.print("Digite o código do leitor para remover: ");
                        int codRemLeitor = Integer.parseInt(scanner.nextLine());
                        Leitor leitorParaRemover = biblioteca.consultarLeitor(codRemLeitor);
                        if (leitorParaRemover != null) {
                            if (biblioteca.removerLeitor(leitorParaRemover)) {
                                System.out.println("Leitor removido.");
                            } else {
                                System.out.println("Leitor não removido. Há empréstimo aberto.");
                            }
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;

                    case 6:
                        System.out.print("Digite o código do livro: ");
                        int codLivro = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Digite o autor: ");
                        String autor = scanner.nextLine();

                        Livro novoLivro = new Livro(codLivro, titulo, autor);
                        if (biblioteca.cadastrarLivro(novoLivro)) {
                            System.out.println("Livro cadastrado.");
                        } else {
                            System.out.println("Não foi possível cadastrar o livro.");
                        }
                        break;

                    case 7:
                        System.out.print("Digite o código do livro: ");
                        int codConsLivro = Integer.parseInt(scanner.nextLine());
                        Livro livroConsultado = biblioteca.consultarLivro(codConsLivro);
                        if (livroConsultado != null) {
                            System.out.println(livroConsultado);
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;

                    case 8:
                        biblioteca.listarLivros();
                        break;

                    case 9:
                        System.out.print("Digite o código do livro que deseja atualizar: ");
                        int codAtuLivro = Integer.parseInt(scanner.nextLine());
                        Livro livroParaAtualizar = biblioteca.consultarLivro(codAtuLivro);
                        if (livroParaAtualizar != null) {
                            System.out.print("Digite o novo título: ");
                            String novoTitulo = scanner.nextLine();
                            System.out.print("Digite o novo autor: ");
                            String novoAutor = scanner.nextLine();

                            livroParaAtualizar.atualizarDados(novoTitulo, novoAutor);
                            System.out.println("Dados do livro atualizados.");
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;

                    case 10:
                        System.out.print("Digite o código do livro para remover: ");
                        int codRemLivro = Integer.parseInt(scanner.nextLine());
                        Livro livroParaRemover = biblioteca.consultarLivro(codRemLivro);
                        if (livroParaRemover != null) {
                            if (biblioteca.removerLivro(livroParaRemover)) {
                                System.out.println("Livro removido.");
                            } else {
                                System.out.println("Livro não removido. Há empréstimo aberto.");
                            }
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;

                    case 11:
                        System.out.print("Digite o código do empréstimo: ");
                        int codEmp = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o código do leitor: ");
                        int codEmpLeitor = Integer.parseInt(scanner.nextLine());

                        Leitor leitorEmp = biblioteca.consultarLeitor(codEmpLeitor);
                        if (leitorEmp == null) {
                            System.out.println("Registro não encontrado.");
                            break;
                        }

                        ArrayList<Livro> livrosEmp = new ArrayList<>();
                        int codEmpLivro = -1;

                        while (codEmpLivro != 0) {
                            System.out.print("Digite o código do livro (ou 0 para encerrar a escolha): ");
                            codEmpLivro = Integer.parseInt(scanner.nextLine());

                            if (codEmpLivro != 0) {
                                Livro livroEmp = biblioteca.consultarLivro(codEmpLivro);
                                if (livroEmp == null) {
                                    System.out.println("Registro não encontrado.");
                                } else if (!livroEmp.isDisponivel()) {
                                    System.out.println("Livro indisponível para empréstimo.");
                                } else if (livrosEmp.contains(livroEmp)) {
                                    System.out.println("Livro já selecionado neste empréstimo.");
                                } else {
                                    livrosEmp.add(livroEmp);
                                }
                            }
                        }

                        if (biblioteca.registrarEmprestimo(codEmp, leitorEmp, livrosEmp)) {
                            System.out.println("Empréstimo registrado.");
                        } else {
                            System.out.println("Não foi possível registrar o empréstimo.");
                        }
                        break;

                    case 12:
                        biblioteca.listarEmprestimos();
                        break;

                    case 13:
                        System.out.print("Digite o código do empréstimo para devolução: ");
                        int codDev = Integer.parseInt(scanner.nextLine());
                        if (biblioteca.registrarDevolucao(codDev)) {
                            System.out.println("Devolução registrada.");
                        } else {
                            System.out.println("Não foi possível registrar a devolução.");
                        }
                        break;

                    case 0:
                        System.out.println("Aplicação encerrada.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
