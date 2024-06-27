package menu.manutencao_cadastro;

import java.util.Scanner;



import manutencao_cadastro.GerenciarVeiculo;
import modelo.Veiculo;
import modelo.TipoDeVeiculo;


public class MenuGerenciarVeiculo {

	public static Scanner entrada = new Scanner(System.in);
	private static GerenciarVeiculo gerenciarVeiculo = GerenciarVeiculo.getInstance();
	
	public static void exibirMenuVeiculo() {
		System.out.println("------------------- MENU VEÍCULO -------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*************** Selecione Uma Opção ****************");
		System.out.println("----------------------------------------------------");
		System.out.println("|   1 - Cadastrar Veículo                          |");
		System.out.println("|   2 - Excluir Veículo                            |");
		System.out.println("|   3 - Alterar Dados Veículo                      |");
		System.out.println("|   4 - Menu Superior                              |");
		System.out.println("----------------------------------------------------");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				cadastrarVeiculo();
				break;
			case 2:
				excluirVeiculo();
				break;
			case 3:
				alterarDados();
				break;
			case 4:
				MenuManutencaoCadastro.exibirMenuManutencao();
				break;
			default:
				System.out.println("Opção Inválida.");
				exibirMenuVeiculo();
				break;
		}
	}
	
	public static void cadastrarVeiculo() {
		System.out.println("Digite a Marca do Veículo:");
		String marca = entrada.next();
		entrada.nextLine();
		System.out.println("Digite o Modelo do Veículo:");
		String modelo = entrada.nextLine();
		entrada.nextLine();
		System.out.println("Digite o Ano do Veículo:");
		int ano = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Digite a Placa do Veículo: EX: XXX-0000");
		String placa = entrada.nextLine();
		System.out.println("Digite o Preço do Veículo:");
		double preco = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("Digite a Categoria de Veículo:");
		String categoria = entrada.next();
		entrada.nextLine();
		System.out.println("Digite a Descrição do Veículo:");
		String descricao = entrada.nextLine();
		
		TipoDeVeiculo tipoDeVeiculo = new TipoDeVeiculo(categoria, descricao);
		Veiculo veiculo = new Veiculo(marca,modelo,ano,placa,preco,tipoDeVeiculo);
		
		GerenciarVeiculo.getInstance().cadastrar(veiculo);
//		System.out.println("ID Veículo: " + veiculo.getIdVeiculo());
//		System.out.println(GerenciarVeiculo.getInstance().getVeiculos().size());
		exibirMenuVeiculo();
		
	}
	
	public static void excluirVeiculo() {
		if(gerenciarVeiculo.getVeiculos().size() > 0) {
			System.out.println("Informe o ID do Veículo:");
			int idVeiculo = entrada.nextInt();
			if(idVeiculo >= 1 && idVeiculo <= gerenciarVeiculo.getVeiculos().size()) {				
				gerenciarVeiculo.excluir(idVeiculo - 1);
				for(int i = idVeiculo -1; i < gerenciarVeiculo.getVeiculos().size(); i++) {
					gerenciarVeiculo.getVeiculos().get(i).setIdVeiculo(gerenciarVeiculo.getVeiculos()
							.get(i).getIdVeiculo() -1);
					Veiculo.setContador(Veiculo.getContador() -1);
				}
			}else {
				System.out.println("O Veículo não Existe");
			}
		}else {
			System.out.println("Não Há Veículos Cadastrados.");
		}
		exibirMenuVeiculo();
	}
	
	public static void alterarDados() {
		if(gerenciarVeiculo.getVeiculos().size() > 0) {
			System.out.println("Informe o ID do Veículo");
			int idVeiculo = entrada.nextInt();
			if(idVeiculo -1 < gerenciarVeiculo.getVeiculos().size()) {
				Veiculo veiculo = gerenciarVeiculo.getVeiculos().get(idVeiculo - 1);
				if(gerenciarVeiculo.getVeiculos().contains(veiculo)) {
					System.out.println("Informe o Campo que Deseja Alterar:");
					System.out.println("""
							1 - Marca
							2 - Modelo
							3 - Ano
							4 - Placa
							5 - Preço
							6 - Categoria
							7 - Descrição
							""");
					int opcao = entrada.nextInt();
//					String novaMarca = veiculo.getMarca();
//					String novoModelo = veiculo.getModelo();
//	                int novoAno = veiculo.getAno();
//	                String novaPlaca = veiculo.getPlaca();
//	                double novoPreco = veiculo.getPreco();
//	                String novaCategoria = veiculo.getTipoDeVeiculo().getCategoria();
//	                String novaDescricao = veiculo.getTipoDeVeiculo().getDescricao();
					switch(opcao) {
						case 1:
							System.out.println("Informe a Nova Marca:");
							String novaMarca = entrada.next();
							veiculo.setMarca(novaMarca);
							break;
						case 2:
	                        System.out.println("Informe o Novo Modelo:");
	                        String novoModelo = entrada.next();
	                        veiculo.setModelo(novoModelo);
	                        break;
	                    case 3:
	                        System.out.println("Informe o Novo Ano:");
	                        int novoAno = entrada.nextInt();
	                        veiculo.setAno(novoAno);
	                        break;
	                    case 4:
	                        System.out.println("Informe a Nova Placa:");
	                        String novaPlaca = entrada.next();
	                        veiculo.setPlaca(novaPlaca);
	                        break;
	                    case 5:
	                        System.out.println("Informe o Novo Preço:");
	                        double novoPreco = entrada.nextDouble();
	                        veiculo.setPreco(novoPreco);
	                        break;
	                    case 6:
	                    	entrada.nextLine();
	                        System.out.println("Informe a Nova Descrição:");
	                        String novaDescricao = entrada.nextLine();
	                        veiculo.getTipoDeVeiculo().setDescricao(novaDescricao);
	                        break;
	                    case 7:
	                        System.out.println("Informe a Nova Categoria:");
	                        String novaCategoria = entrada.next();
	                        veiculo.getTipoDeVeiculo().setCategoria(novaCategoria);
	                        break;
	                    default:
	                    	System.out.println("Opção Inválida");
	                    	exibirMenuVeiculo();
	                    	break;
					}
//					TipoDeVeiculo novoTipoDeVeiculo = new TipoDeVeiculo(novaCategoria, novaDescricao);
//					Veiculo novoVeiculo = new Veiculo(novaMarca,novoModelo,novoAno,novaPlaca,novoPreco,novoTipoDeVeiculo);
//					gerenciarVeiculo.alterarDados(idVeiculo - 1, novoVeiculo);
//					//Veiculo.setContador(Veiculo.getContador() -1);
//					for(int i = idVeiculo -1; i < gerenciarVeiculo.getVeiculos().size(); i++) {
//						gerenciarVeiculo.getVeiculos().get(i).setIdVeiculo(gerenciarVeiculo.getVeiculos()
//								.get(i).getIdVeiculo() -1);
//						Veiculo.setContador(Veiculo.getContador() -1);
//					}
//					for(Veiculo veiculos : gerenciarVeiculo.getVeiculos()) {
//						veiculos.setIdVeiculo(veiculos.getIdVeiculo() - 1);
//					}
					
				}
			}else {
				System.out.println("Veículo não Encontrado.");
				exibirMenuVeiculo();
			}
		}else {
			System.out.println("Não há Veículos Cadastrados.");
		}
		exibirMenuVeiculo();
	}
	
}
