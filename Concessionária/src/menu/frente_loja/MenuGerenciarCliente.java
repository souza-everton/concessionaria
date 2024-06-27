package menu.frente_loja;

import java.util.Scanner;

import manutencao_cadastro.GerenciarCliente;
import modelo.Cliente;

public class MenuGerenciarCliente {

	public static Scanner entrada = new Scanner(System.in);
	
	public static void exibirMenuCliente() {
		System.out.println("------------------- MENU CLIENTE -------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Cadastrar Cliente                          |");
		System.out.println("|   2 - Consultar Cliente por CPF                  |");
		System.out.println("|   3 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				consultarClienteCPF();
				break;
			case 3:
				MenuFrenteLoja.exibirMenuFrenteLoja();
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
	
	public static void consultarClienteCPF() {
		entrada.nextLine();
		System.out.println("Digite o CPF (Somente Números):");
		String cpf = entrada.nextLine();
		cpf = cpf.replaceAll("\\D", "");
		if(cpf.length() != 11) {
			System.out.println("CPF Inválido.\nCPF Deve Conter 11 Dígitos");
			System.out.println();
			exibirMenuCliente();;
		}
		System.out.println(GerenciarCliente.getInstance().consultarClienteCPF(cpf));
		exibirMenuCliente();
	}
}
