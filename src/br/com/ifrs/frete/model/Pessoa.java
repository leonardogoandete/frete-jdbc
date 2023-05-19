package br.com.ifrs.frete.model;

import java.util.Objects;

public class Pessoa {
    private String nome;

    public Pessoa(){}
    public Pessoa(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
