package br.com.ifrs.frete.view;

import br.com.ifrs.frete.dao.MinhaGen;
import br.com.ifrs.frete.model.Cliente;

import java.util.Scanner;

public class MenuMinhaGen {
    private static final MinhaGen<Cliente> minhaGenCliente = new MinhaGen<>();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            switch (exibeMenu()) {
                case 1:
                    cadastro();
                    break;
                case 2:
                    pesquisar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    listarTodos();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;

            }
        }
    }

    public static int exibeMenu() {
        StringBuilder stringMenu = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        for (OpcoesMenu opcaoMenu : OpcoesMenu.values())
            stringMenu.append(opcaoMenu.toString());
        System.out.println(stringMenu.append("Digite uma opção:"));
        return Integer.parseInt(sc.next());
    }

    public static void cadastro() {
        try {
            System.out.println("=== Cadastro ===");
            System.out.println("Digite o nome:");
            String nome = teclado.nextLine();
            System.out.println("Digite o endereço:");
            String endereco = teclado.nextLine();
            System.out.println("Digite o telefone:");
            String telefone = teclado.nextLine();
            System.out.println("Digite o CPF:");
            String cpf = teclado.nextLine();
            System.out.println(minhaGenCliente.adicionarLista(new Cliente(nome, endereco, telefone, cpf)) ? "Sucesso ao cadastrar" : "Falha ao cadastrar");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente na lista!" + e.getMessage());
        }
    }

    public static void pesquisar() {
        try {
            if (!minhaGenCliente.obterTodos().isEmpty()) {
                System.out.println("=== Pesquisa ===");
                System.out.println("Digite o nome para pesquisa:");
                String nomePesquisa = teclado.nextLine();
                Cliente clientePesquisado = minhaGenCliente.pesquisarListaPorNome(nomePesquisa);
                if (clientePesquisado != null) {
                    System.out.println(clientePesquisado);
                } else {
                    System.out.println("Não existe cliente com o nome pesquisado!");
                }
            } else System.out.println("Não há clientes na lista!");
        } catch (Exception e) {
            System.out.println("Erro generico ao pesquisar cleinte" + e.getMessage());
        }
    }

    public static void excluir() {
        try {
            if (!minhaGenCliente.obterTodos().isEmpty()) {
                System.out.println("Digite o CPF:");
                String cpf = teclado.nextLine();
                int resultado = minhaGenCliente.excluirPorCpf(cpf);
                if (resultado >= 1) System.out.println("Sucesso ao excluir o cliente!");
                else if (resultado == 0) System.out.println("Não há cliente com o CPF informado!");
            } else System.out.println("Não há clientes na lista!");
        } catch (Exception e) {
            System.out.println("Erro genérico ao excluir cliente: " + e.getMessage());
        }
    }


    public static void listarTodos() {
        try {
            if (!minhaGenCliente.obterTodos().isEmpty()) {
                for (Cliente cliente : minhaGenCliente.obterTodos()) {
                    System.out.println(cliente.toString());
                }
            } else {
                System.out.println("Não há clientes na lista!");
            }
        } catch (Exception e) {
            System.out.println("Erro genérico na listagem de clientes: " + e.getMessage());
        }
    }
}






