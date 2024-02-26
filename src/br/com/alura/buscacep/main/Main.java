package br.com.alura.buscacep.main;

import br.com.alura.buscacep.entity.Endereco;
import br.com.alura.buscacep.service.BuscaEndereco;
import br.com.alura.buscacep.service.GeraArquivos;
import br.com.alura.buscacep.service.JsonHandler;
import br.com.alura.buscacep.service.ValidaCep;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, JsonMappingException {
        Scanner read = new Scanner(System.in);
        String cep;

        System.out.print("Digite o CEP do endereço a ser buscado (somente números): ");
        cep = read.nextLine();

        ValidaCep validaCep = new ValidaCep();

        if(validaCep.validaCep(cep)) {
            BuscaEndereco busca = new BuscaEndereco();
            String json = busca.buscaEndereco(cep);

            JsonHandler jsonHandler = new JsonHandler();

            Endereco novoEndereco = jsonHandler.readJson(json, Endereco.class);
            System.out.println(novoEndereco);

            GeraArquivos geraArquivo = new GeraArquivos();
            geraArquivo.geraJson(novoEndereco);
        } else {
            System.out.println("O CEP digitado é inválido");
        }
    }
}
