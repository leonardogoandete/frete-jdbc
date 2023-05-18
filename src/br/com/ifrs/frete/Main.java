package br.com.ifrs.frete;

import br.com.ifrs.frete.dao.MinhaGen_old;
import br.com.ifrs.frete.model.Cliente;

public class Main {
    public static void main(String[] args) {
        MinhaGen_old<Cliente> listaDeClientes = new MinhaGen_old<>();
        Cliente cliente = new Cliente("Laika","Travessa Teste 01","51999999999","78945612314");
        Cliente cliente1 = new Cliente("Katyuscha Maria", "Av Secundaria 888", "51988888888","74185296378");
        Cliente cli = new Cliente();
        cli.setCpf("5481658125");
        cli.setNome("Bebel");


        listaDeClientes.adicionarLista(cliente1);
        listaDeClientes.adicionarLista(cliente);

        System.out.println(listaDeClientes.obterTodos());

        System.out.println("Pesquisa por nome:");
        System.out.println(listaDeClientes.pesquisarListaPorNome("Katyuscha Maria"));

        System.out.println("Excluindo:");
        System.out.println(listaDeClientes.excluirPorCpf("78945612314"));

        System.out.println(listaDeClientes.obterTodos());

        //System.out.println(listaDeClientes.obterTodos());
        //Pessoa p = new Pessoa("leonardo");
        //System.out.println(p);
        //ClienteDAO clienteDAO = new ClienteDAO();
        //Cliente cliente = new Cliente("Laika","Travessa Teste 01","51999999999","78945612314");

        //System.out.println(cliente);
        //Cliente cliente1 = new Cliente("Katyuscha Maria", "Av Secundaria 888", "51988888888","74185296378");

        //System.out.println(cliente1);

        //System.out.println(cliente1.getTotal());
        //System.out.println(clienteDAO.insert(cliente1));


        //System.out.println(clienteDAO.update(cli));
        //System.out.println("Deletando ->" + clienteDAO.delete(cli)+"\n");
        //System.out.println("==== Listando ==== \n" + clienteDAO.listAll());
        //System.out.println("Cliente por ID: " + clienteDAO.findByID(3));


        //System.out.println(cli.listTodos());


    }
}