package menu.frente_loja;

import java.util.Scanner;

import manutencao_cadastro.GerenciarLoja;

public class MenuGerenciarLoja {

	public static Scanner entrada = new Scanner(System.in);
	
	public static void exibirMenuLoja() {
		System.out.println("--------------------- MENU LOJA --------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Listar Lojas Cadastradas                   |");
		System.out.println("|   2 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				listarLojas();
				break;
			case 2:
				MenuFrenteLoja.exibirMenuFrenteLoja();
				break;
			default:
				System.out.println("Opção Inválida.");
				exibirMenuLoja();
				break;
		}
	}
	
	public static void listarLojas() {
		GerenciarLoja.getInstance().listarLojas();
		exibirMenuLoja();
	}
}
