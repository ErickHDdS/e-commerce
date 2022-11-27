package com.qualidade.application.entities;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.BufferedReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int cep;
    private String street;
    private int number;
    private String complement;
    private String neighborhood;
    private String district;
    private String state;

    public Address(int cep, int number, String complement) throws IOException {
        this.cep = cep;
        this.number = number;
        this.complement = complement;

        this.executeCEPAPI(cep);
    }

    public Address() {
    }

    public void executeCEPAPI(int cep) throws IOException {
        String webService = "http://viacep.com.br/ws/";
        String urlToCall = webService + cep + "/json";
        URL url = new URL(urlToCall);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader answer = new BufferedReader(new InputStreamReader((connection.getInputStream())));
        setFields(answer);

    }

    private static String getType(int initialCounter, String strSearch) {
        char c;
        String content = "";
        for (int j = initialCounter + 3; j < strSearch.length() - 2; j++, initialCounter++) {
            c = strSearch.charAt(j);
            if (c != '"')
                content += c;
        }
        return content;
    }

    private void setFields(BufferedReader buffereReader) throws IOException {
        String answer;
        char c;
        String cep = "", logradouro = "", complemento = "", bairro = "", localidade = "", uf = "";
        while ((answer = buffereReader.readLine()) != null) {

            String tipo = "";
            for (int i = 0; i < answer.length(); i++) {
                c = answer.charAt(i);
                if (c != '"' && c != '{' && c != '}' && c != ' ' && c != ':') {
                    tipo += c;
                    switch (tipo) {
                        case "cep" -> cep = getType(i, answer);
                        case "logradouro" -> logradouro = getType(i, answer);
                        case "complemento" -> complemento = getType(i, answer);
                        case "bairro" -> bairro = getType(i, answer);
                        case "localidade" -> localidade = getType(i, answer);
                        case "uf" -> uf = getType(i, answer);

                    }
                }
            }
        }

        this.setStreet(logradouro);
        this.setNeighborhood(bairro);
        this.setDistrict(localidade);
        this.setState(uf);

    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

}