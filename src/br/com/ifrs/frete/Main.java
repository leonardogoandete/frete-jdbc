package br.com.ifrs.frete;

import br.com.ifrs.frete.dao.ClienteDAO;
import br.com.ifrs.frete.factory.ConnectionFactory;
import br.com.ifrs.frete.model.Cliente;
import br.com.ifrs.frete.model.Pessoa;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //Pessoa p = new Pessoa("leonardo");
        //System.out.println(p);
        ClienteDAO clienteDAO = new ClienteDAO();
        //Cliente cliente = new Cliente("Laika","Travessa Teste 01","51999999999","78945612314");

        //System.out.println(cliente);
        //Cliente cliente1 = new Cliente("Katyuscha Maria", "Av Secundaria 888", "51988888888","74185296378");

        //System.out.println(cliente1);

        //System.out.println(cliente1.getTotal());
        //System.out.println(clienteDAO.insert(cliente1));
        Cliente cli = new Cliente();
        cli.setCpf("12345678912");
        cli.setNome("Jerustrildes");

        //System.out.println(clienteDAO.update(cli));
        //System.out.println("Deletando ->" + clienteDAO.delete(cli)+"\n");
        System.out.println("==== Listando ==== \n" + clienteDAO.listAll());
        System.out.println("Cliente por ID: " + clienteDAO.findByID(3));









    }
}