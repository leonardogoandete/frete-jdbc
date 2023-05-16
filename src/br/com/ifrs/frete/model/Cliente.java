package br.com.ifrs.frete.model;

import br.com.ifrs.frete.dao.ClienteDAO;

import java.util.List;

public class Cliente extends Pessoa{
    private static int numeroClientes = 1;
    private String endereco, telefone, cpf;

    public Cliente(){}

    public Cliente(String nome,String endereco, String telefone, String cpf) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.numeroClientes++;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTotal(){
        return numeroClientes - 1;
    }

    @Override
    public String toString() {
        return "\nNome: " + super.toString() +
                "\nEndereço: " + getEndereco() +
                "\nTelefone: " + getTelefone() +
                "\nCPF: " + getCpf()+"\n";
    }

    public boolean cadastrarCliente(Cliente cli){
        try {
            return new ClienteDAO().insert(cli);
        }catch (Exception e){
            System.out.println("Erro ao cadastrar um cliente!\n" +  e.getMessage());
            return false;
        }
    }

    public Cliente pesquisarClientePorNome(String nome){
        try {
            return new ClienteDAO().findByName(nome);
        }catch (Exception e){
            System.out.println("Erro ao pesquisar cliente por nome\n" + e.getMessage());
            return null;
        }
    }

    public int deletarClientePorCpf(Cliente cli){
        try {
            return new ClienteDAO().delete(cli);
        }catch (Exception e){
            System.out.println("Erro ao deletar o cliente utilizando CPF\n" + e.getMessage());
            return 0;
        }
    }

    public List<Cliente> listTodos(){
        try{
            return new ClienteDAO().listAll();
        }catch (Exception e){
            System.out.println("Erro ao listar os clientes\n" + e.getMessage());
            return null;
        }
    }
}
