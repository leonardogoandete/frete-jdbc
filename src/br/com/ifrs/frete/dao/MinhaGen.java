package br.com.ifrs.frete.dao;


import br.com.ifrs.frete.model.Cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MinhaGen<E extends Cliente> {
    private List<E> listaObjetos;
    public MinhaGen() {
        listaObjetos = new ArrayList<>();
    }
    public boolean insert(E obj) {
        try {
            return listaObjetos.add(obj);
        } catch (UnsupportedOperationException e) {
            System.out.println("Operação de adição não suportada para a coleção\n" + e.getMessage());
        } catch (ClassCastException e) {
            System.out.println("Erro ao realizar a inserção do elemento\n" + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Erro elemento não pode ser nulo\n" + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Alguma propriedade do elemento não pode ser adicionado na coleção\n" + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("O elemento não pode ser adicionado no momento devido a uma restrição\n" + e.getMessage());
        }
        return false;
    }
    public E findByName(E obj) {
        for (E elemento : listaObjetos) {
            if (Objects.equals(elemento.getNome(), obj.getNome())) {
                return elemento;
            }
        }
        return null;
    }

    public int deleteWithCpf(E obj) {
        Iterator<E> iterator = listaObjetos.iterator();
        while (iterator.hasNext()) {
            E elemento = iterator.next();
            if (Objects.equals(elemento.getCpf(), obj.getCpf())) {
                iterator.remove();
                return 1;
            }
        }
        return -1;
    }
    public List<E> listAll() {
        return listaObjetos;
    }


}
