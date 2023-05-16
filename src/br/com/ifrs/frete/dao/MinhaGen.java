package br.com.ifrs.frete.dao;

import br.com.ifrs.frete.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class MinhaGen<T> {

    private final List<T> lista;

    public MinhaGen() {
        lista = new ArrayList<>();
    }

    public boolean adicionarLista(T objeto) {
        return lista.add(objeto);
    }

    public T pesquisarListaPorNome(String nome) {
        for (T obj : lista) {
            try {
                Cliente cli = (Cliente) obj;
                if (cli.getNome().equalsIgnoreCase(nome)) return obj;
            }catch (ClassCastException e){
                System.out.println("Erro ao fazer cast do obj para classe Cliente durante a busca por Nome");
            }
        }
        return null;
    }

    public int excluirPorCpf(String cpf) {
        for (T obj : lista) {
            try {
                Cliente cli = (Cliente) obj;
                if (cli.getCpf().equalsIgnoreCase(cpf)){
                    lista.remove(obj);
                    return 1;
                }
            }catch (ClassCastException e){
                System.out.println("Erro ao fazer cast do obj para classe Cliente durante a exclusao por CPF");
            }
            catch (UnsupportedOperationException e) {
                System.out.println("Erro ao remover o objeto da lista: " + e.getMessage());
            }catch (Exception e) {
                System.out.println("Erro desconhecido durante a exclusão por CPF: " + e.getMessage());
            }
        }
        return 0;
    }

    public List<T> obterTodos() {
        return lista;
    }
}
