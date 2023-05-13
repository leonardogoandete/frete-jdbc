package br.com.ifrs.frete.model;

public class Cliente extends Pessoa{
    private static int numeroClientes = 1;
    private String endereco, telefone, cpf;
    private int numero;

    public Cliente(){}

    public Cliente(String nome,String endereco, String telefone, String cpf) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.numero = numeroClientes;
        numeroClientes++;
    }

    public Cliente(String nome, String endereco, String telefone, String cpf, int numero) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.numero = numero;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotal(){
        return numeroClientes - 1;
    }

    @Override
    public String toString() {
        return "\nNome: " + super.toString() +
                "\nEndereço: " + getEndereco() +
                "\nTelefone: " + getTelefone() +
                "\nCPF: " + getCpf() +
                "\nNumero: " + getNumero() + "\n";
    }
}
