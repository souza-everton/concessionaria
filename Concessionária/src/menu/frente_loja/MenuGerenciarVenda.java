package menu.frente_loja;

import java.util.Scanner;

import manutencao_cadastro.GerenciarCliente;
import manutencao_cadastro.GerenciarVeiculo;
import manutencao_cadastro.GerenciarVenda;
import manutencao_cadastro.GerenciarVendedor;
import modelo.Cliente;
import modelo.Veiculo;
import modelo.Venda;
import modelo.Vendedor;

public class MenuGerenciarVenda {

	public static Scanner entrada = new Scanner(System.in);
	
	public static void exibirMenuVenda() {
		System.out.println("-------------------- MENU Venda --------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Cadastrar Venda                            |");
		System.out.println("|   2 - Listar Vendas                              |");
		System.out.println("|   3 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				cadastrarVenda();
				break;
			case 2:
				listarVendas();
			case 3:
				MenuFrenteLoja.exibirMenuFrenteLoja();
				break;
			default:
				System.out.println("Opção Inválida.");
				exibirMenuVenda();
				break;
		}
	}
	
	public static void cadastrarVenda() {
		entrada.nextLine();
		System.out.println("Informe a Data da Venda: Ex. DD/MM/AAAA");
		String dataVenda = entrada.nextLine();
		System.out.println("Informe o ID do Veículo Vendido:");
		int idVeiculoVendido = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Informe o ID do Vendedor Responsável:");
		int idVendedorResponsavel = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Informe o ID do Cliente:");
		int idCliente = entrada.nextInt();
		entrada.nextLine();
		
		
	    Veiculo veiculo = GerenciarVeiculo.getInstance().getVeiculos().get(idVeiculoVendido - 1);
	    Vendedor vendedor = GerenciarVendedor.getInstance().getVendedores().get(idVendedorResponsavel - 1);
	    Cliente cliente = GerenciarCliente.getInstance().getClientes().get(idCliente - 1);
		
		Venda venda = new Venda(veiculo, vendedor, cliente, dataVenda);
        GerenciarVenda.getInstance().cadastrar(venda);
        System.out.println("ID Venda: " + venda.getIdVenda());
        System.out.println("Data: " + venda.getData());
        System.out.println(GerenciarVenda.getInstance().getVendas().size());
		exibirMenuVenda();
	}
	
	public static void listarVendas() {
		GerenciarVenda.getInstance().listarVendas();
		exibirMenuVenda();
	}
}
