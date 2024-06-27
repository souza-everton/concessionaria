package menu.frente_loja;

import java.util.Scanner;

import manutencao_cadastro.GerenciarVeiculo;

public class MenuGerenciarVeiculo {

	public static Scanner entrada = new Scanner(System.in);
	//private static GerenciarVeiculo gerenciarVeiculo = GerenciarVeiculo.getInstance();
	
	public static void exibirMenuVeiculo() {
		System.out.println("------------------- MENU VEÍCULO -------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Consultar Veículo por Placa                |");
		System.out.println("|   2 - Listar Veículos Cadastrados                |");
		System.out.println("|   3 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				consultarVeiculoPlaca();
				break;
			case 2:
				listarVeiculosCadastrados();
				break;
			case 3:
				MenuFrenteLoja.exibirMenuFrenteLoja();
				break;
			default:
				System.out.println("Opção Inválida.");
				exibirMenuVeiculo();
				break;
		}
		
	}
	
	public static void consultarVeiculoPlaca() {
		System.out.println("Informe a Placa do Veículo. EX: XXX-0000");
		String placaVeiculo = entrada.next();
		String veiculoEncontrado = GerenciarVeiculo.getInstance().consultarVeiculoPlaca(placaVeiculo);
		System.out.println(veiculoEncontrado);
		exibirMenuVeiculo();
	}
	
	public static void listarVeiculosCadastrados() {
		GerenciarVeiculo.getInstance().listarVeiculos();
		exibirMenuVeiculo();
	}
}
