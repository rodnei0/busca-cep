package br.com.alura.buscacep.service;

public class ValidaCep {
    public boolean validaCep(String cep) {
        return  cep.matches("[0-9]{8}");
    }
}
