package menu;

import java.util.Scanner;

import menu.frente_loja.MenuFrenteLoja;
import menu.manutencao_cadastro.MenuManutencaoCadastro;

public class MenuInterface {

	public static Scanner entrada = new Scanner(System.in);
	
	public static void exibirInterface() {
		System.out.println("-------------- CONCESSIONÁRIA ----------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Frente de Loja                             |");
		System.out.println("|   2 - Manutenção Cadastro                        |");
		System.out.println("|   3 - Sair                                       |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				MenuFrenteLoja.exibirMenuFrenteLoja();
				break;
			case 2:
				MenuManutencaoCadastro.exibirMenuManutencao();
				break;
			case 3:
				System.out.println("Obrigado Pela Visita!");
				System.exit(0);
				break;
			default:
				System.out.println("Opção Inválida.");
				exibirInterface();
				break;
		}
	}
}
