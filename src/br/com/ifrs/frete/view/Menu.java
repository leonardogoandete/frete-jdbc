package br.com.ifrs.frete.view;

import br.com.ifrs.frete.dao.ClienteDAO;
import br.com.ifrs.frete.model.Cliente;

import javax.swing.*;

public class Menu {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente;
        while (true) {
            switch (exibeMenu()) {
                case 1:
                    JOptionPane.showMessageDialog(null,
                            clienteDAO.insert(
                                    new Cliente(JOptionPane.showInputDialog("Digite o nome:"),
                                            JOptionPane.showInputDialog("Digite o endereco:"),
                                            JOptionPane.showInputDialog("Digite o telefone:"),
                                            JOptionPane.showInputDialog("Digite o CPF:"))
                            ));
                    //retorna true
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, clienteDAO.findByName(JOptionPane.showInputDialog("Digite o nome")));
                    //retorna o cliente
                    break;
                case 3:
                    Cliente cli = new Cliente();
                    cli.setCpf(JOptionPane.showInputDialog("Digite o CPF:"));
                    JOptionPane.showMessageDialog(null,clienteDAO.delete(cli));
                    break;
                case 4:
                    for (Cliente cl: clienteDAO.listAll()) {
                        JOptionPane.showMessageDialog(null,cl.toString());
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;

            }
        }
    }

    public static int exibeMenu() {
        StringBuilder stringMenu = new StringBuilder();
        for (OpcoesMenu opcaoMenu : OpcoesMenu.values())
            stringMenu.append(opcaoMenu.toString());
        return Integer.parseInt(JOptionPane.showInputDialog(null, stringMenu.toString()));
    }
}






