package menu.manutencao_cadastro;

import java.util.Scanner;

import manutencao_cadastro.GerenciarCliente;
import modelo.Cliente;

public class MenuGerenciarCliente {

	public static Scanner entrada = new Scanner(System.in);
	private static GerenciarCliente gerenciarCliente = GerenciarCliente.getInstance();
	
	public static void exibirMenuCliente() {
		System.out.println("------------------- MENU CLIENTE -------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Cadastrar Cliente                          |");
		System.out.println("|   2 - Excluir Cliente                            |");
		System.out.println("|   3 - Alterar Dados Cliente                      |");
		System.out.println("|   4 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				excluirCliente();
				break;
			case 3:
				alterarDados();
				break;
			case 4:
				MenuManutencaoCadastro.exibirMenuManutencao();
				break;
			default:
				System.out.println("Opção Inválida.");
				exibirMenuCliente();
				break;
		}
	}
	
	public static void cadastrarCliente() {
		entrada.nextLine();
		System.out.println("Digite o Nome do Cliente");
		String nome = entrada.nextLine();
		entrada.nextLine();
		System.out.println("Digite o CPF do Cliente");
		String cpf = entrada.nextLine();
		cpf = cpf.replaceAll("\\D", "");
		if(cpf.length() != 11) {
			System.out.println("CPF Inválido.\nCPF Deve Conter 11 Dígitos");
			System.out.println();
			exibirMenuCliente();
		}
		entrada.nextLine();
		System.out.println("Digite o Telefone do Cliente");
		String telefone = entrada.nextLine();
		entrada.nextLine();
		System.out.println("Digite a Renda do Cliente");
		double renda = entrada.nextDouble();
		
		Cliente cliente = new Cliente(nome,cpf,telefone,renda);
		GerenciarCliente.getInstance().cadastrar(cliente);
		
		System.out.println("ID Cliente: " + cliente.getIdCliente());
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Renda: R$" + cliente.getRenda());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println(GerenciarCliente.getInstance().getClientes().size());
		exibirMenuCliente();
	}
	
	public static void excluirCliente() {
		if(gerenciarCliente.getClientes().size() > 0) {
			System.out.println("Informe o ID do Cliente");
			int idCliente = entrada.nextInt();
			if(idCliente >= 1 && idCliente <= gerenciarCliente.getClientes().size()) {
				gerenciarCliente.excluir(idCliente - 1);
				for(int i = idCliente -1; i < gerenciarCliente.getClientes().size();i++) {
					gerenciarCliente.getClientes().get(i).setIdCliente(gerenciarCliente.getClientes()
							.get(i).getIdCliente() - 1);
					Cliente.setContador(Cliente.getContador() - 1);
				}
			}else {
				System.out.println("O cliente não existe");
			}
		}else {
			System.out.println("Não há vendedores cadastrados");
		}
		exibirMenuCliente();
	}
	
	public static void alterarDados() {
		if(gerenciarCliente.getClientes().size() > 0) {
			System.out.println("Informe o ID do Cliente");
			int idCliente = entrada.nextInt();
			if(idCliente -1 < gerenciarCliente.getClientes().size()) {
				Cliente cliente = gerenciarCliente.getClientes().get(idCliente - 1);
				if(gerenciarCliente.getClientes().contains(cliente)) {
					System.out.println("Informe o Campo que Deseja Alterar:");
					System.out.println("""
							1 - Nome
							2 - CPF
							3 - Telefone
							4 - Renda
							""");
					int opcao = entrada.nextInt();
					
					switch(opcao) {
						case 1:
							entrada.nextLine();
							System.out.println("Informe o Novo Nome:");
							String novoNome = entrada.nextLine();
							cliente.setNome(novoNome);
							break;
						case 2:
							entrada.nextLine();
							System.out.println("Informe o Novo CPF:");
							String novoCPF = entrada.nextLine();
							cliente.setCpf(novoCPF);
							break;
						case 3:
							entrada.nextLine();
							System.out.println("Informe o Novo Telefone:");
							String novoTelefone = entrada.nextLine();
							cliente.setTelefone(novoTelefone);
							break;
						case 4:
							System.out.println("Informe a Nova Renda:");
							double novaRenda = entrada.nextDouble();
							cliente.setRenda(novaRenda);
							entrada.nextLine();
							break;
						default:
							System.out.println("Opção Inválida");
							exibirMenuCliente();
							break;
					}
				}
			}else {
				System.out.println("Veículo Não Encontrado.");
				exibirMenuCliente();
			}
		}else {
			System.out.println("Não há Clientes Cadastrados.");
		}
		exibirMenuCliente();
	}
}
