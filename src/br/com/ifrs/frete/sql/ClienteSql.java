package br.com.ifrs.frete.sql;

public enum ClienteSql {
    INSERT("INSERT INTO clientes(nome, endereco, telefone, cpf) VALUES (?, ?, ?, ?)"),
    LISTALL("SELECT * FROM clientes"),
    DELETE("DELETE FROM clientes WHERE cpf= ?"),
    UPDATE("UPDATE clientes SET nome= ? WHERE cpf= ?"),
    FINDBYID("SELECT * FROM clientes WHERE idCliente= ?"),
    FINDBYNOME("SELECT * FROM clientes WHERE nome= ?"),
    CREATE_TABLE_CLIENTE("CREATE TABLE `clientes` (\n" +
            "  `idCliente` int NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
            "  `nome` varchar(50) NOT NULL,\n" +
            "  `endereco` varchar(50) NOT NULL,\n" +
            "  `telefone` varchar(11) NOT NULL,\n" +
            "  `cpf` varchar(11) NOT NULL\n" +
            ") ENGINE='InnoDB';");


    private final String query;

    ClienteSql(String query) {
        this.query = query;
    }

    public String getQuery(){
        return query;
    }
    
}
