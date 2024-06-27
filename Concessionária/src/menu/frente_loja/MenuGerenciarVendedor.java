package menu.frente_loja;

import java.util.Scanner;


import manutencao_cadastro.GerenciarVendedor;

public class MenuGerenciarVendedor {

	public static Scanner entrada = new Scanner(System.in);
	
	public static void exibirMenuVendedor() {
		System.out.println("------------------- MENU VENDEDOR ------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Consultar Vendedor Por Nome                |");
		System.out.println("|   2 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				consultarVendedorNome();
				break;
			case 2:
				MenuFrenteLoja.exibirMenuFrenteLoja();
				break;
			default:
				System.out.println("Opção Inválida.");
				exibirMenuVendedor();
				break;
		}
	}
	
	public static void consultarVendedorNome() {
		System.out.println("Informe o Nome do Vendedor:");
		String nome = entrada.next();
		System.out.println(GerenciarVendedor.getInstance().consultarVendedorNome(nome));
		exibirMenuVendedor();
	}
}
