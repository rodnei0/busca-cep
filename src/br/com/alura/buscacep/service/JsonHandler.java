package br.com.alura.buscacep.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHandler {
    ObjectMapper objectMapper = new ObjectMapper();

    public <T> T readJson(String json, Class<T> classe) throws JsonProcessingException {
        return objectMapper.readValue(json, classe);
    }

    public String writeJson(Object object) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}
