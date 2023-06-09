package br.com.ifrs.frete.view;

import br.com.ifrs.frete.dao.MinhaGen;
import br.com.ifrs.frete.model.Cliente;

import java.util.Scanner;

public class Menu {
    private static final Cliente cliente = new Cliente();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
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
                    case 6:
                        createTableIfNotExists();
                        break;
                    default:
                        System.out.println("Opção invalida!");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Opção digitada não é um numero!");
            }catch (Exception e){
                System.out.println("Erro inesperado no bloco switch-case");
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
            System.out.println("=== Cadastro ===");
            System.out.println("Digite o nome:");
            String nome = teclado.nextLine();
            System.out.println("Digite o endereço:");
            String endereco = teclado.nextLine();
            System.out.println("Digite o telefone:");
            String telefone = teclado.nextLine();
            System.out.println("Digite o CPF:");
            String cpf = teclado.nextLine();
            System.out.println(cliente.cadastrarCliente(new Cliente(nome, endereco, telefone, cpf)) ? "Sucesso ao cadastrar" : "Falha ao cadastrar");
    }

    public static void pesquisar() {
            System.out.println("=== Pesquisa ===");
            System.out.println("Digite o nome para pesquisa:");
            String nomePesquisa = teclado.nextLine();
            Cliente clientePesquisado = cliente.pesquisarClientePorNome(nomePesquisa);

            if (clientePesquisado != null) {
                System.out.println(clientePesquisado);
            } else {
                System.out.println("Não existe cliente com o nome pesquisado!");
            }
    }

    public static void excluir() {
            Cliente cli = new Cliente();
            System.out.println("Digite o CPF:");
            cli.setCpf(teclado.nextLine());
            int resultado = cliente.deletarClientePorCpf(cli);

            if (resultado >= 1) {
                System.out.println("Sucesso ao excluir o cliente!");
            } else {
                System.out.println("Não existe cliente com o nome pesquisado!");
            }
    }

    public static void listarTodos() {
            MinhaGen<Cliente> clientes = cliente.listTodos();
            try {
                if (clientes.obterTodos().size() >= 1) {
                    for (Cliente cl : clientes.obterTodos()) {
                        System.out.println(cl.toString());
                    }
                } else {
                    System.out.println("Não há clientes na lista!");
                }
            }catch (Exception e){
                System.out.println("Erro genérico ao listar todos os clientes");
            }
    }

    private static void createTableIfNotExists() {
        cliente.criarTabela();
    }
}






