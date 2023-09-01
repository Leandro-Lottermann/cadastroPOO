package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> listaPessoasFisicas = new ArrayList<>();

    public void inserir (PessoaFisica pessoaFisica) {
        this.listaPessoasFisicas.add(pessoaFisica);
    }

    public void alterar (Integer id, PessoaFisica pessoaFisica) {
        int index = this.listaPessoasFisicas.indexOf(this.listaPessoasFisicas.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null));

        if(!(index < 0)) {
            this.listaPessoasFisicas.set(index, pessoaFisica);
        }
    }

    public void excluir (Integer id) {
        this.listaPessoasFisicas.removeIf(pessoaFisica -> pessoaFisica.getId().equals(id));
    }

    public PessoaFisica obter (Integer id) {
        return this.listaPessoasFisicas.stream().filter(pessoaFisica -> pessoaFisica.getId().equals(id)).findFirst().orElse(null);
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return this.listaPessoasFisicas;
    }

    public void persistir (String nomeArquivo) throws FileNotFoundException {
        PrintWriter fileOut = new PrintWriter(nomeArquivo);
        for (PessoaFisica p : this.listaPessoasFisicas) {
            fileOut.println(p.getId());
            fileOut.println(p.getNome());
            fileOut.println(p.getCpf());
            fileOut.println(p.getIdade());
        }

        fileOut.close();
        System.out.println("Dados de Pessoa Física Armazenados.");
    }

    public void recuperar (String nomeArquivo) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(nomeArquivo));
        while (fileIn.hasNext()){
            int id = Integer.parseInt(fileIn.nextLine());
            String nome = fileIn.nextLine();
            String cpf = fileIn.nextLine();
            int idade = Integer.parseInt(fileIn.nextLine());

            PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
            this.inserir(pessoaFisica);
        }
        fileIn.close();
        System.out.println("Dados de Pessoa Física Recuperados.");
    }


}
