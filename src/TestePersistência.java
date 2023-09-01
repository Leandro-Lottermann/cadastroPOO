import model.*;

import java.io.FileNotFoundException;

public class TestePersistência {
    public static void main(String[] args) {
        int contadorIds = 1;

        PessoaFisica leandro = new PessoaFisica(contadorIds, "Leandro",  "123.123.123", 12);
        contadorIds++;
        PessoaFisica claudio = new PessoaFisica(contadorIds, "Claudio",  "123.121233.123", 12);
        contadorIds++;


        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(leandro);
        repo1.inserir(claudio);


        try {
            repo1.persistir("pessoas.fisica.bin");
        } catch (FileNotFoundException e ) {
            System.out.println(e);
        }



        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        try {
            repo2.recuperar("pessoas.fisica.bin");
            repo2.obterTodos().forEach(pessoaFisica -> {
                System.out.println("Id: " + pessoaFisica.getId());
                System.out.println("Nome: " + pessoaFisica.getNome());
                System.out.println("CPF: " + pessoaFisica.getCpf());
                System.out.println("Idade: " + pessoaFisica.getIdade());
                System.out.println("-----------------------");
            });
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        PessoaJuridica casasBahia = new PessoaJuridica(contadorIds, "Casas Bahia", "11111111111");
        contadorIds++;
        PessoaJuridica magalu = new PessoaJuridica(contadorIds, "magalu", "11111111111");

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(casasBahia);
        repo3.inserir(magalu);

        try {
            repo3.persistir("empresas.juridica.bin");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        try {
            repo4.recuperar("empresas.juridica.bin");
            repo4.obterTodos().forEach(pessoaFisica -> {
                System.out.println("Id: " + pessoaFisica.getId());
                System.out.println("Nome: " + pessoaFisica.getNome());
                System.out.println("CNPJ: " + pessoaFisica.getCnpj());
                System.out.println("-----------------------");
            });
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}