package br.com.ifrs.frete.view;

import br.com.ifrs.frete.dao.MinhaGen;
import br.com.ifrs.frete.model.Cliente;
import static br.com.ifrs.frete.view.Menu.exibeMenu;
public class TesteMinhaGen {
    public static void main(String[] args) {
        MinhaGen<Cliente> minhaGenCliente = new MinhaGen<>();

        while (true) {
            switch (exibeMenu()) {
                case 1:
                    Cliente cliente1 = new Cliente(
                            "leonardo",
                            "Trav. Guedes da Luz 51",
                            "51991561597",
                            "18035208764");
                    System.out.println(minhaGenCliente.insert(cliente1));
                    break;
                case 2:
                    Cliente cli = new Cliente();
                    cli.setNome("leonardo");
                    System.out.println(minhaGenCliente.findByName(cli));
                    break;
                case 3:
                    Cliente cliCpf = new Cliente();
                    cliCpf.setCpf("18035208764");
                    minhaGenCliente.deleteWithCpf(cliCpf);
                    break;
                case 4:
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
}

