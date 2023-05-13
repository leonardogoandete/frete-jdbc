package br.com.ifrs.frete.sql;

public enum PessoaSql {
    INSERT("INSERT INTO pessoa(nome) VALUES (?)"),
    LISTALL("SELECT * FROM pessoa"),
    DELETE("DELETE FROM pessoa WHERE nome= ?"),
    UPDATE("UPDATE pessoa SET nome= ? WHERE nome= ?"),
    FINDBYID("SELECT * FROM pessoa WHERE id= ?");

    private final String query;

    PessoaSql(String query) {
        this.query = query;
    }

    public String getQuery(){
        return query;
    }
}
