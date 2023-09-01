import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PessoaFisicaRepo repoFisicas = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridicas = new PessoaJuridicaRepo();

        Scanner entrada = new Scanner(System.in);

        String textoMenu = """
                ====================================
                1 - Incluir Pessoa
                2 - Alterar Pessoa
                3 - Excluir Pessoa
                4 - Buscar pelo Id
                5 - Exibir Todos
                6 - Persistir Dados
                7 - Recuperar Dados
                0 - Finalizar Programa
                ====================================
                """;
        int opcao;

        do {
            System.out.println(textoMenu);
            opcao = entrada.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("F - Pessoa Física | J - Pessoa Juridica");

                    String tipoDePessoa = entrada.next();

                    if(tipoDePessoa.equals("F")){
                        System.out.println("Digite o id da Pessoa:");
                        int id = entrada.nextInt();

                        System.out.println("Insira os dados...");
                        System.out.println("Nome:");
                        String nome = entrada.next();
                        System.out.println("CPF:");
                        String cpf = entrada.next();
                        System.out.println("Idade:");
                        int idade = entrada.nextInt();
                        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        repoFisicas.inserir(pessoaFisica);
                    } else if (tipoDePessoa.equals("J")) {
                        System.out.println("Digite o id da Empresa:");
                        int id = entrada.nextInt();

                        System.out.println("Insira os dados...");
                        System.out.println("Nome:");
                        String nome = entrada.next();
                        System.out.println("CNPJ:");
                        String cnpj = entrada.next();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                        repoJuridicas.inserir(pessoaJuridica);
                    } else {
                        System.out.println("Tipo inválido");
                    }

                    break;

                case 2:
                    System.out.println("F - Pessoa Física | J - Pessoa Juridica");
                    tipoDePessoa = entrada.next();

                    if (tipoDePessoa.equals("F")) {
                        System.out.println("Id:");
                        int id = entrada.nextInt();
                        PessoaFisica p = repoFisicas.obter(id);

                        System.out.println("Id: " + p.getId());
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("CPF: " + p.getCpf());
                        System.out.println("Idade: " + p.getIdade());
                        System.out.println("-----------------------");

                        System.out.println("Insira os dados...");
                        System.out.println("Nome:");
                        String nome = entrada.next();
                        System.out.println("CPF:");
                        String cpf = entrada.next();
                        System.out.println("Idade:");
                        int idade = entrada.nextInt();

                        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);

                        repoFisicas.alterar(id, pessoaFisica);
                    } else if (tipoDePessoa.equals("J")) {
                        System.out.println("Id:");
                        int id = entrada.nextInt();
                        PessoaJuridica p = repoJuridicas.obter(id);

                        System.out.println("Id: " + p.getId());
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("CNPJ: " + p.getCnpj());
                        System.out.println("-----------------------");

                        System.out.println("Insira os dados...");
                        System.out.println("Nome:");
                        String nome = entrada.next();
                        System.out.println("CNPJ:");
                        String cnpj = entrada.next();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                        repoJuridicas.alterar(id, pessoaJuridica);
                    }
                    break;

                case 3:
                    System.out.println("F - Pessoa Física | J - Pessoa Juridica");
                    tipoDePessoa = entrada.next();

                    if (tipoDePessoa.equals("F")) {
                        System.out.println("Id:");
                        int id = entrada.nextInt();

                        repoFisicas.excluir(id);
                    } else if (tipoDePessoa.equals("J")) {
                        System.out.println("Id:");
                        int id = entrada.nextInt();

                        repoJuridicas.excluir(id);
                    }
                    break;

                case 4:
                    System.out.println("F - Pessoa Física | J - Pessoa Juridica");
                    tipoDePessoa = entrada.next();

                    if (tipoDePessoa.equals("F")) {
                        System.out.println("Id:");
                        int id = entrada.nextInt();
                        PessoaFisica p = repoFisicas.obter(id);

                        System.out.println("Id: " + p.getId());
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("CPF: " + p.getCpf());
                        System.out.println("Idade: " + p.getIdade());
                        System.out.println("-----------------------");
                    } else if (tipoDePessoa.equals("J")) {
                        System.out.println("Id:");
                        int id = entrada.nextInt();
                        PessoaJuridica p = repoJuridicas.obter(id);

                        System.out.println("Id: " + p.getId());
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("CNPJ: " + p.getCnpj());
                        System.out.println("-----------------------");
                    }
                    break;

                case 5:
                    System.out.println("F - Pessoa Física | J - Pessoa Juridica");
                    tipoDePessoa = entrada.next();
                    if(tipoDePessoa.equals("F")){
                        repoFisicas.obterTodos().forEach(p -> {
                            System.out.println("Id: " + p.getId());
                            System.out.println("Nome: " + p.getNome());
                            System.out.println("CPF: " + p.getCpf());
                            System.out.println("Idade: " + p.getIdade());
                            System.out.println("-----------------------");
                        });
                    } else if (tipoDePessoa.equals("J")) {
                        repoJuridicas.obterTodos().forEach(p -> {
                            System.out.println("Id: " + p.getId());
                            System.out.println("Nome: " + p.getNome());
                            System.out.println("CNPJ: " + p.getCnpj());
                            System.out.println("-----------------------");
                        });
                    }
                    break;
                case 6:
                    System.out.println("Nome do arquivo: ");
                    String nomeArquivo = entrada.next();
                    try {
                        repoFisicas.persistir( nomeArquivo + ".fisicas.bin");
                        repoJuridicas.persistir(nomeArquivo + ".juridicas.bin");
                    } catch (FileNotFoundException e) {
                        System.out.println(e);
                    }

                    break;

                case 7:
                    System.out.println("Nome do arquivo: ");
                    nomeArquivo = entrada.next();
                    try {
                        repoFisicas.recuperar(nomeArquivo + ".fisicas.bin");
                        repoJuridicas.recuperar(nomeArquivo + ".juridicas.bin");
                    } catch (FileNotFoundException e) {
                        System.out.println(e);
                    }
                    break;

            }

        }while (opcao != 0);

    }




}
