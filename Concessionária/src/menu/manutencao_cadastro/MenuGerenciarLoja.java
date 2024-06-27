package menu.manutencao_cadastro;

import java.util.Scanner;

import manutencao_cadastro.GerenciarLoja;
import modelo.Loja;

public class MenuGerenciarLoja {

	public static Scanner entrada = new Scanner(System.in);
	private static GerenciarLoja gerenciarLoja = GerenciarLoja.getInstance();
	
	public static void exibirMenuLoja() {
		System.out.println("--------------------- MENU LOJA --------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Cadastrar Loja	                           |");
		System.out.println("|   2 - Excluir Loja                               |");
		System.out.println("|   3 - Alterar Dados Loja                         |");
		System.out.println("|   4 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				cadastrarLoja();
				break;
			case 2:
				excluirLoja();
				break;
			case 3:
				alterarDados();
				break;
			case 4:
				MenuManutencaoCadastro.exibirMenuManutencao();
		}
	}
	
	public static void cadastrarLoja() {
		System.out.println("Digite o Nome da Loja:");
		String nome = entrada.next();
		entrada.nextLine();
		System.out.println("Digite o Endereço da Loja:");
		String endereco = entrada.nextLine();
		entrada.nextLine();
		System.out.println("Digite o Telefone da Loja:");
		String telefone = entrada.nextLine();
		
		Loja loja = new Loja(nome,endereco,telefone);
		gerenciarLoja.cadastrar(loja);
		System.out.println("ID Loja: " + loja.getIdLoja());
		System.out.println(GerenciarLoja.getInstance().getLojas().size());
		
		exibirMenuLoja();
	}
	
	public static void excluirLoja() {
		if(gerenciarLoja.getLojas().size() > 0) {
			System.out.println("Informe o ID da Loja");
			int idLoja = entrada.nextInt();
			if(idLoja >= 1 && idLoja <= gerenciarLoja.getLojas().size()) {
				gerenciarLoja.excluir(idLoja - 1);
				for(int i = idLoja - 1; i < gerenciarLoja.getLojas().size(); i++) {
					gerenciarLoja.getLojas().get(i).setIdLoja(gerenciarLoja.getLojas()
							.get(i).getIdLoja() - 1);
					Loja.setContador(Loja.getContador() - 1);
				}
			}else {
				System.out.println("O Veículo não existe.");
				exibirMenuLoja();
			}
		}else {
			System.out.println("Não há Veículos Cadastrados.");
		}
		exibirMenuLoja();
	}
	
	public static void alterarDados() {
		if(gerenciarLoja.getLojas().size() > 0) {
			System.out.println("Informe o ID da Loja.");
			int idLoja = entrada.nextInt();
			if(idLoja - 1 < gerenciarLoja.getLojas().size()) {
				Loja loja = gerenciarLoja.getLojas().get(idLoja - 1);
				if(gerenciarLoja.getLojas().contains(loja)) {
					System.out.println("Informe o Campo que Deseja Alterar:");
					System.out.println("""
							1 - Nome
							2 - Endereço
							3 - Telefone
							""");
					int opcao = entrada.nextInt();
					switch(opcao) {
						case 1:
							entrada.nextLine();
							System.out.println("Informe o Novo Nome da Loja");
							String novoNome = entrada.nextLine();
							loja.setNome(novoNome);
							break;
						case 2:
							entrada.nextLine();
							System.out.println("Informe o Novo Endereço da Loja");
							String novoEndereço = entrada.nextLine();
							loja.setEndereço(novoEndereço);
							break;
						case 3:
							entrada.nextLine();
							System.out.println("Informe o Novo Telefone da Loja");
							String novoTelefone = entrada.nextLine();
							loja.setTelefone(novoTelefone);
							break;
						default:
							System.out.println("Opção Inválida");
							alterarDados();
							break;
					}
				}
			}else {
				System.out.println("Loja Não Encontrada.");
				excluirLoja();
			}
		}else {
			System.out.println("Não há Lojas Cadastradas.");
		}
		exibirMenuLoja();
	}
}
