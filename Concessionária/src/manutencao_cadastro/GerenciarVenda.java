package manutencao_cadastro;

import java.util.ArrayList;
import java.util.List;

//import banco_dados.Listas;
import modelo.Venda;
//import manutencao_cadastro.*;

public class GerenciarVenda implements Gerenciadora<Venda>{

	private static GerenciarVenda instance;
	private List<Venda> vendas;
	
	private GerenciarVenda() {
		vendas = new ArrayList<>();
	}
	
	public static synchronized GerenciarVenda getInstance() {
		if (instance == null) {
            instance = new GerenciarVenda();
        }
        return instance;
	}

	@Override
	public void cadastrar(Venda venda) {
		this.vendas.add(venda);
		System.out.println("Venda Cadastrada.");		
	}

	@Override
	public void excluir(int indice) {
		this.vendas.remove(indice);
		System.out.println("Venda Excluída.");		
	}

	public List<Venda> getVendas() {
		return vendas;
	}
	
	public void listarVendas() {
		if(vendas.size() > 0) {
			for(Venda venda : vendas) {
				System.out.println("-------------------------");
				String placa = venda.getVeiculoVendido().getPlaca();
				String nomeVendedor = venda.getVendedor().getNome();
				String cpfCliente = venda.getCliente().getCpf();
				System.out.println("ID Venda: " + venda.getIdVenda() +
						"\nData Venda: " + venda.getData() +
						"\nVeículo Vendido: " + GerenciarVeiculo.getInstance().consultarVeiculoPlaca(placa) +
						"\n" +
						"\nVendedor Responsável: " + GerenciarVendedor.getInstance().consultarVendedorNome(nomeVendedor) +
						"\n" +
						"\nCliente: " + GerenciarCliente.getInstance().consultarClienteCPF(cpfCliente));
				System.out.println("-------------------------");
			}
		}else {
			System.out.println("Não Existem Vendas Cadastradas.");
		}
	}

}
