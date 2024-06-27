package manutencao_cadastro;

import java.util.ArrayList;
import java.util.List;

//import banco_dados.Listas;
import modelo.Veiculo;

public class GerenciarVeiculo implements Gerenciadora<Veiculo>{
	
	private static GerenciarVeiculo instance;
	private List<Veiculo> veiculos;
	
	private GerenciarVeiculo() {
		veiculos = new ArrayList<>();
	}
	
	public static synchronized GerenciarVeiculo getInstance() {
        if (instance == null) {
            instance = new GerenciarVeiculo();
        }
        return instance;
    }


	@Override
	public void cadastrar(Veiculo veiculo) {
		this.veiculos.add(veiculo);
		System.out.println("Veículo Cadastrado");	
	}

	@Override
	public void excluir(int indice) {
		this.veiculos.remove(indice);
		System.out.println("Veículo Excluído.");
	}

//	@Override
//	public void alterarDados(int indice, Veiculo veiculo) {
//		this.veiculos.set(indice, veiculo);
//		System.out.println("Dados Alterados.");
//		
//	}
	
	public String consultarVeiculoPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return "\n-------------------------\n" +
                       "ID Veículo: " + veiculo.getIdVeiculo() +
                       "\nMarca: " + veiculo.getMarca() +
                       "\nModelo: " + veiculo.getModelo() +
                       "\nAno: " + veiculo.getAno() +
                       "\nCategoria: " + veiculo.getTipoDeVeiculo().getCategoria() +
                       "\n-------------------------";
            }
        }
        return "Veículo não Cadastrado.";
    }
	
	public void listarVeiculos() {
		if(veiculos.size() > 0) {
			for(Veiculo veiculo : veiculos) {
				System.out.println("-------------------------");
				System.out.println("ID Veículo: " + veiculo.getIdVeiculo() +
						"\nMarca: " + veiculo.getMarca() +
						"\nModelo: " + veiculo.getModelo() + 
						"\nAno: " + veiculo.getAno() + 
						"\nPlaca: " + veiculo.getPlaca());
				System.out.println("-------------------------");
			}
		}else {
			System.out.println("Não Existem Veículos Cadastrados");
		}
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
}
