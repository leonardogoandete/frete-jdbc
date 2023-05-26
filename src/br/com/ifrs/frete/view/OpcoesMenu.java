package br.com.ifrs.frete.view;

public enum OpcoesMenu {

    CADASTRAR(1,"Cadastrar Cliente em Banco de dados"),
    LISTAR_TODOS(2,"Pesquisar Cliente usando nome"),
    TOT_CADASTRO(3,"Excluir Cliente usando cpf"),
    PESQ_PESSOA(4,"Listar todos os clientes"),
    SAIR(5,"Sair"),
    CRIAR_TABELA_CLIENTE(6,"Criar tabela CLIENTE");


    private final int numero;
    private final String descricao;

    private OpcoesMenu(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    public int getnumero() {
        return numero;
    }

    public String getdescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return numero + " - " + descricao+"\n";
    }
}