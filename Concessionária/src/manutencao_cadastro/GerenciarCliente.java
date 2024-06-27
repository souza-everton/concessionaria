package manutencao_cadastro;

import java.util.ArrayList;
import java.util.List;

//import banco_dados.Listas;
import modelo.Cliente;

public class GerenciarCliente implements Gerenciadora<Cliente>{
	
	private static GerenciarCliente instance;
	private List<Cliente> clientes;
	
	private GerenciarCliente() {
		clientes = new ArrayList<>();
	}
	
	public static synchronized GerenciarCliente getInstance() {
		if (instance == null) {
            instance = new GerenciarCliente();
        }
        return instance;
	}
	
	@Override
	public void cadastrar(Cliente cliente) {
		this.clientes.add(cliente);
		System.out.println("Cliente Cadastrado.");
		
	} 

	@Override
	public void excluir(int indice) {
		this.clientes.remove(indice);
		System.out.println("Cliente Excluído.");
		
	}
	
	public String consultarClienteCPF(String CPF) {
		for(Cliente cliente : clientes) {
			if(cliente.getCpf().equalsIgnoreCase(CPF)) {
				return "\n-------------------------" +
						"\nID Cliente: " + cliente.getIdCliente() +
						"\nNome: " + cliente.getNome() + 
						"\nTelefone: " + cliente.getTelefone() +
						"\nRenda: R$" + cliente.getRenda();
			}
		}return "Cliente Não Cadastrado";
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
