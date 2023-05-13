package br.com.ifrs.frete.dao;

import br.com.ifrs.frete.factory.ConnectionFactory;
import br.com.ifrs.frete.model.Cliente;
import br.com.ifrs.frete.sql.ClienteSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente> {

    @Override
    public boolean insert(Cliente obj) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(ClienteSql.INSERT.getQuery())) {
            stmt.setString(1, obj.getNome().toLowerCase());
            stmt.setString(2, obj.getEndereco().toLowerCase());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getCpf());
            stmt.setInt(5, obj.getNumero());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Cliente!\n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return false;
    }

    @Override
    public int update(Cliente obj) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(ClienteSql.UPDATE.getQuery())) {
            stmt.setString(1, obj.getNome().toLowerCase()); //Nome para alterar
            stmt.setString(2,obj.getCpf().toLowerCase()); //busca pelo CPF para alterar
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar cliente!\n" + ex.getMessage());
        }
        return -1;
    }

    @Override
    public int delete(Cliente obj) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(ClienteSql.DELETE.getQuery())) {
            stmt.setString(1, obj.getCpf());
            return stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Erro ao deletar cliente!\n"+ex.getMessage());
        }
        return -1;
    }

    @Override
    public List<Cliente> listAll() {
        List<Cliente> listaClientes = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(ClienteSql.LISTALL.getQuery())) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listaClientes.add(new Cliente(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getInt("numero")
                ));
            }
            return listaClientes;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar todos os Clientes!\n" + ex.getMessage());
        }
        return null;
    }

    @Override
    public Cliente findByID(int id) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(ClienteSql.FINDBYID.getQuery())) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getInt("numero")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Cliente por ID!\n" + ex.getMessage());
        }
        return null;
    }

    @Override
    public Cliente findByName(String nome) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(ClienteSql.FINDBYNOME.getQuery())) {
            stmt.setString(1,nome.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getInt("numero")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Cliente por nome!\n" + ex.getMessage());
        }
        return null;
    }
}
