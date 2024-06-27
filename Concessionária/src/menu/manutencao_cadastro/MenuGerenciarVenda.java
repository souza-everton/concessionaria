package menu.manutencao_cadastro;

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
	private static GerenciarVenda gerenciarVenda = GerenciarVenda.getInstance();
	private static GerenciarVeiculo gerenciarVeiculo =  GerenciarVeiculo.getInstance();
	private static GerenciarVendedor gerenciarVendedor = GerenciarVendedor.getInstance();
	private static GerenciarCliente gerenciarCliente = GerenciarCliente.getInstance();
	
	public static void exibirMenuVenda() {
		System.out.println("------------------- MENU VENDAS -------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ***************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Cadastrar Venda                            |");
		System.out.println("|   2 - Excluir Venda                              |");
		System.out.println("|   3 - Alterar Dados Venda                        |");
		System.out.println("|   4 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				cadastrarVenda();
				break;
			case 2:
				excluirVenda();
				break;
			case 3:
				alterarDados();
				break;
			case 4:
				MenuManutencaoCadastro.exibirMenuManutencao();
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
        gerenciarVenda.cadastrar(venda);
        System.out.println("ID Venda: " + venda.getIdVenda());
        System.out.println(GerenciarVenda.getInstance().getVendas().size());
		exibirMenuVenda();
	}
	
	public static void excluirVenda() {
		if(gerenciarVenda.getVendas().size() > 0) {
			System.out.println("Informe o ID da Venda:");
			int idVenda = entrada.nextInt();
			if(idVenda >= 1 && idVenda <= gerenciarVenda.getVendas().size()) {
				gerenciarVenda.excluir(idVenda - 1);
				for(Venda venda : gerenciarVenda.getVendas()) {
					venda.setIdVenda(venda.getIdVenda() - 1);
				}
			}else {
				System.out.println("A venda não existe.");
			}
		}else {
			System.out.println("Não há Vendas Cadastradas.");
		}
		exibirMenuVenda();
	}
	
	public static void alterarDados() {
		if(gerenciarVenda.getVendas().size() > 0) {
			System.out.println("Informe o ID da Venda:");
			int idVenda = entrada.nextInt();
			if(idVenda - 1 < gerenciarVenda.getVendas().size()) {
				Venda venda = gerenciarVenda.getVendas().get(idVenda - 1);
				if(gerenciarVenda.getVendas().contains(venda)) {
					System.out.println("Informe o Campo que Deseja Alterar:");
					System.out.println("""
							1 - Veículo Vendido
							2 - Vendedor Responsável
							3 - Cliente
							4 - Data da Venda
							""");
					int opcao = entrada.nextInt();
					
					switch(opcao) {
						case 1:
							System.out.println("Informe o ID do Novo Veículo:");
							int idVeiculo = entrada.nextInt();
							Veiculo novoVeiculo = gerenciarVeiculo.getVeiculos().get(idVeiculo - 1);
							venda.setVeiculoVendido(novoVeiculo);
							break;
						case 2:
							System.out.println("Informe o ID do Novo Vendedor:");
							int idVendedor = entrada.nextInt();
							Vendedor novoVendedor = gerenciarVendedor.getVendedores().get(idVendedor - 1);
							venda.setVendedor(novoVendedor);
							break;
						case 3:
							System.out.println("Informe o ID do Novo Cliente:");
							int idCliente = entrada.nextInt();
							Cliente novoCliente = gerenciarCliente.getClientes().get(idCliente - 1);
							venda.setCliente(novoCliente);
							break;
						case 4:
							System.out.println("Informe a Nova Data da Venda:");
							String novaData = entrada.nextLine();
							venda.setData(novaData);
							break;
						default:
							System.out.println("Opção Inválida:");
							exibirMenuVenda();
							break;
					}
				}
			}else {
				System.out.println("Venda Não Encontrada.");
				exibirMenuVenda();
			}
		}else {
			System.out.println("Não há Vendas Cadastradas.");
		}
		exibirMenuVenda();
	}
}
