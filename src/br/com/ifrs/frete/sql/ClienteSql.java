package br.com.ifrs.frete.sql;

public enum ClienteSql {
    INSERT("INSERT INTO clientes(nome, endereco, telefone, cpf) VALUES (?, ?, ?, ?)"),
    LISTALL("SELECT * FROM clientes"),
    DELETE("DELETE FROM clientes WHERE cpf= ?"),
    UPDATE("UPDATE clientes SET nome= ? WHERE cpf= ?"),
    FINDBYID("SELECT * FROM clientes WHERE idCliente= ?"),
    FINDBYNOME("SELECT * FROM clientes WHERE nome= ?");

    private final String query;

    ClienteSql(String query) {
        this.query = query;
    }

    public String getQuery(){
        return query;
    }
    
}
