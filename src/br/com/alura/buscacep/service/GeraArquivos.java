package br.com.alura.buscacep.service;

import java.io.FileWriter;
import java.io.IOException;

public class GeraArquivos {
    public void geraJson(Object object) throws IOException {
        FileWriter writer = new FileWriter("endereco.json");

        JsonHandler jsonHandler = new JsonHandler();
        writer.write(jsonHandler.writeJson(object));
        writer.close();
    }
}
