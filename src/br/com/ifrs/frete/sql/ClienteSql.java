package br.com.ifrs.frete.sql;

public enum ClienteSql {
    INSERT("INSERT INTO cliente(nome, endereco, telefone, cpf, numero) VALUES (?, ?, ?, ?, ?)"),
    LISTALL("SELECT * FROM cliente"),
    DELETE("DELETE FROM cliente WHERE cpf= ?"),
    UPDATE("UPDATE cliente SET nome= ? WHERE cpf= ?"),
    FINDBYID("SELECT * FROM cliente WHERE idCliente= ?"),
    FINDBYNOME("SELECT * FROM cliente WHERE nome= ?");

    private final String query;

    ClienteSql(String query) {
        this.query = query;
    }

    public String getQuery(){
        return query;
    }
    
}
