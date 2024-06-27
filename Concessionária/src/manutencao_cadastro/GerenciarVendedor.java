package manutencao_cadastro;

import java.util.ArrayList;

import java.util.List;

//import banco_dados.Listas;
import modelo.Vendedor;

public class GerenciarVendedor implements Gerenciadora<Vendedor>{

	private static GerenciarVendedor instance;
	private List<Vendedor> vendedores;
	
	private GerenciarVendedor() {
		vendedores = new ArrayList<>();
	}
	
	public static synchronized GerenciarVendedor getInstance() {
		if (instance == null) {
            instance = new GerenciarVendedor();
        }
        return instance;
	}
	
	@Override
	public void cadastrar(Vendedor vendedor) {
		this.vendedores.add(vendedor);
		System.out.println("Vendedor Cadastrado.");
	}

	@Override
	public void excluir(int indice) {
		this.vendedores.remove(indice);
		System.out.println("Vendedor Excluído");
	}
	
	public String consultarVendedorNome(String nome) {
		for(Vendedor vendedor : vendedores) {
			if(vendedor.getNome().equalsIgnoreCase(nome)) {
				return "\n-------------------------"+
						"\nID Vendedor: " + vendedor.getIdVendedor() +
						"\nNome: " + vendedor.getNome() +
						"\nTelefone: " + vendedor.getTelefone() +
						"\nSalário: R$"+ vendedor.getSalario() +
						"\n-------------------------";
			}
		}
		return "Vendedor Não Encontrado";
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	
}
