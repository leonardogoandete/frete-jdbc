package br.com.ifrs.frete.dao;

import java.util.List;

public interface GenericDAO <T> {
    public boolean insert(T obj);
    public int update(T obj);
    public int delete(T obj);
    public List<T> listAll();
    public T findByID(int id);
    public T findByName(String nome);
}

