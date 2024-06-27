package menu.manutencao_cadastro;

import java.util.Scanner;


import manutencao_cadastro.GerenciarVendedor;
import modelo.Vendedor;

public class MenuGerenciarVendedor {

	public static Scanner entrada = new Scanner(System.in);
	private static GerenciarVendedor gerenciarVendedor = GerenciarVendedor.getInstance();
	
	public static void exibirMenuVendedor() {
		System.out.println("------------------- MENU VENDEDOR ------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Cadastrar Vendedor                         |");
		System.out.println("|   2 - Excluir Vendedor                           |");
		System.out.println("|   3 - Alterar Dados Vendedor                     |");
		System.out.println("|   4 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				cadastrarVendedor();
				break;
			case 2:
				excluirVendedor();
				break;
			case 3:
				alterarDados();
				break;
			case 4:
				MenuManutencaoCadastro.exibirMenuManutencao();
				break;
			default:
				System.out.println("Opção Inválida.");
				exibirMenuVendedor();
				break;
		}
	}
	
	public static void cadastrarVendedor() {
		
		entrada.nextLine();
		System.out.println("Digite o Nome do Vendedor");
		String nome = entrada.nextLine();
		System.out.println("Digite o Salário do Vendedor");
		double salario = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("Digite o CPF do Vendedor");
		String cpf = entrada.nextLine();
		System.out.println("Digite o Telefone do Vendedor");
		String telefone = entrada.nextLine();
		
		
		Vendedor vendedor = new Vendedor(nome,cpf,telefone,salario);
		
		GerenciarVendedor.getInstance().cadastrar(vendedor);
		System.out.println("ID Vendedor: " + vendedor.getIdVendedor());
		System.out.println("Nome: " + vendedor.getNome());
		System.out.println("CPF:" + vendedor.getCpf());
		System.out.println("Telefone: " + vendedor.getTelefone());
		System.out.println("Salário: R$" + vendedor.getSalario());
		System.out.println(GerenciarVendedor.getInstance().getVendedores().size());
		exibirMenuVendedor();
	}
	
	public static void excluirVendedor() {
		if(gerenciarVendedor.getVendedores().size() > 0) {
			System.out.println("Informe o ID do Vendedor");
			int idVendedor = entrada.nextInt();
			if(idVendedor >= 1 && idVendedor <= gerenciarVendedor.getVendedores().size()) {
				gerenciarVendedor.excluir(idVendedor - 1);
				for(int i = idVendedor - 1; i < gerenciarVendedor.getVendedores().size(); i++) {
					gerenciarVendedor.getVendedores().get(i).setIdVendedor(gerenciarVendedor.getVendedores()
							.get(i).getIdVendedor() - 1);
					Vendedor.setContador(Vendedor.getContador() - 1);
				}
			}else {
				System.out.println("O Vendedor não existe");
			}
		}else {
			System.out.println("Não há Vendedores Cadastrados");
		}
		exibirMenuVendedor();
	}
	
	public static void alterarDados() {
		if(gerenciarVendedor.getVendedores().size() > 0) {
			System.out.println("Informe o ID do Vendedor");
			int idVendedor = entrada.nextInt();
			if(idVendedor -1 < gerenciarVendedor.getVendedores().size()) {
				Vendedor vendedor = gerenciarVendedor.getVendedores().get(idVendedor - 1);
				if(gerenciarVendedor.getVendedores().contains(vendedor)) {
					System.out.println("Informe o Campo que Deseja Alterar:");
					System.out.println("""
							1 - Nome
							2 - CPF
							3 - Telefone
							4 - Salário
							""");
					int opcao = entrada.nextInt();
					
					switch(opcao) {
						case 1:
							entrada.nextLine();
							System.out.println("Informe o Novo Nome:");
							String novoNome = entrada.nextLine();
							vendedor.setNome(novoNome);
							break;
						case 2:
							entrada.nextLine();
							System.out.println("Informe o Novo CPF:");
							String novoCPF = entrada.nextLine();
							vendedor.setCpf(novoCPF);
							break;
						case 3:
							entrada.nextLine();
							System.out.println("Informe o Novo Telefone:");
							String novoTelefone = entrada.nextLine();
							vendedor.setTelefone(novoTelefone);
							break;
						case 4:
							System.out.println("Informe o Novo Salário:");
							double novoSalario = entrada.nextDouble();
							vendedor.setSalario(novoSalario);
							break;
						default:
							System.out.println("Opção Inválida.");
							exibirMenuVendedor();
							break;
					}
				}
			}else {
				System.out.println("Vendedor Não Encontrado.");
				exibirMenuVendedor();
			}
			
		}else {
			System.out.println("Não há Vendedores Cadastrados.");
		}
		exibirMenuVendedor();
	}
	
}
