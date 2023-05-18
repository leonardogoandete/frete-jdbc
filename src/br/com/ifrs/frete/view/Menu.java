package br.com.ifrs.frete.view;

import br.com.ifrs.frete.model.Cliente;
import br.com.ifrs.frete.dao.MinhaGen;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Cliente cliente = new Cliente();
    private static final MinhaGen<Cliente> minhaGenCliente = new MinhaGen<>();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            switch (exibeMenu()) {
                case 1:
                    //cadastro();
                    Cliente cliente1 = new Cliente("leonardo","Trav. Guedes da Luz 51","51991561597","18035208764");
                    System.out.println(minhaGenCliente.insert(cliente1));
                    break;
                case 2:
                    //pesquisar();
                    Cliente cli = new Cliente();
                    cli.setNome("leonardo");
                    System.out.println(minhaGenCliente.findByName(cli));
                    break;
                case 3:
                    Cliente cliCpf = new Cliente();
                    cliCpf.setCpf("18035208764");
                    minhaGenCliente.deleteWithCpf(cliCpf);
                    //excluir();
                    break;
                case 4:
                    //listarTodos();
                    System.out.println(minhaGenCliente.listAll());
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
        try{
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
        }catch (Exception e){
            System.out.println("Erro ao cadastrar cliente no banco!" + e.getMessage());
        }
    }

    public static void pesquisar() {
        try {
            System.out.println("=== Pesquisa ===");
            System.out.println("Digite o nome para pesquisa:");
            String nomePesquisa = teclado.nextLine();
            Cliente clientePesquisado = cliente.pesquisarClientePorNome(nomePesquisa);
            if (clientePesquisado != null) {
                System.out.println(clientePesquisado);
            } else {
                System.out.println("Não existe cliente com o nome pesquisado!");
            }
        }catch (Exception e){
            System.out.println("Erro ao pesquisar cleinte" + e.getMessage());
        }
    }

    public static void excluir() {
        try {
            Cliente cli = new Cliente();
            System.out.println("Digite o CPF:");
            cli.setCpf(teclado.nextLine());
            int resultado = cliente.deletarClientePorCpf(cli);
            if (resultado >= 1) System.out.println("Sucesso ao excluir o cliente!");
            else if(resultado == 0) System.out.println("Não há cliente com o CPF informado!");
        } catch (Exception e) {
            System.out.println("Erro genérico ao excluir cliente: " + e.getMessage());
        }
    }


    public static void listarTodos() {
        try {
            List<Cliente> clientes = cliente.listTodos();
            if (!clientes.isEmpty()) {
                for (Cliente cl : clientes) {
                    System.out.println(cl.toString());
                }
            } else {
                System.out.println("Não há clientes na lista!");
            }
        } catch (Exception e) {
            System.out.println("Erro genérico na listagem de clientes: " + e.getMessage());
        }
    }
}






