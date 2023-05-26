package br.com.ifrs.frete.dao;

import java.util.ArrayList;
import java.util.List;

public class MinhaGen<T> {
    private final List<T> lista;
    public MinhaGen() {
        lista = new ArrayList<>();
    }

    public boolean adicionarLista(T objeto) {
        try {
            return lista.add(objeto);
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao inserir o objeto na lista: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro desconhecido durante o cadastro " + e.getMessage());
        }
        return false;
    }

    public List<T> obterTodos() {
        try {
            return lista;
        } catch (Exception e) {
            System.out.println("Erro desconhecido durante a listagem " + e.getMessage());
        }
        return null;
    }
}
