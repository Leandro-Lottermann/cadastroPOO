package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaJuridicaRepo implements Serializable {
    private ArrayList<PessoaJuridica> listaPessoasJuridicas = new ArrayList<>();

    public void inserir (PessoaJuridica pessoaJuridica) {

        this.listaPessoasJuridicas.add(pessoaJuridica);

    }

    public void alterar (Integer id, PessoaJuridica pessoaJuridica) {
        int index = this.listaPessoasJuridicas.indexOf(this.listaPessoasJuridicas.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null));

        if(!(index < 0)) {
            this.listaPessoasJuridicas.set(index, pessoaJuridica);
        }
    }

    public void excluir (Integer id) {
        this.listaPessoasJuridicas.removeIf(pessoaJuridica -> pessoaJuridica.getId().equals(id));
    }

    public PessoaJuridica obter (Integer id) {
        return this.listaPessoasJuridicas.stream().filter(pessoaJuridica -> pessoaJuridica.getId().equals(id)).findFirst().orElse(null);
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return this.listaPessoasJuridicas;
    }

    public void persistir (String nomeArquivo) throws FileNotFoundException {
        PrintWriter fileOut = new PrintWriter(nomeArquivo);
        for (PessoaJuridica p : this.listaPessoasJuridicas) {
            fileOut.println(p.getId());
            fileOut.println(p.getNome());
            fileOut.println(p.getCnpj());

        }

        fileOut.close();
        System.out.println("Dados de Pessoa Jurídica Armazenados.");
    }

    public void recuperar (String nomeArquivo) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(nomeArquivo));
        while (fileIn.hasNext()){
            int id = Integer.parseInt(fileIn.nextLine());
            String nome = fileIn.nextLine();
            String cnpj = fileIn.nextLine();


            PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
            this.inserir(pessoaJuridica);
        }
        fileIn.close();
        System.out.println("Dados de Pessoa Jurídica Recuperados.");
    }


}
