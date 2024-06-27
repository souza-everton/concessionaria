package manutencao_cadastro;

import java.util.ArrayList;
import java.util.List;

import modelo.Loja;

public class GerenciarLoja implements Gerenciadora<Loja>{

	private static GerenciarLoja instance;
	private List<Loja> lojas;
	
	private GerenciarLoja() {
		lojas = new ArrayList<>();
	}
	
	public static synchronized GerenciarLoja getInstance() {
		if (instance == null) {
            instance = new GerenciarLoja();
        }
        return instance;
	}
	
	
	@Override
	public void cadastrar(Loja loja) {
		this.lojas.add(loja);
		System.out.println("Loja Cadastrada.");	
	}

	@Override
	public void excluir(int indice) {
		this.lojas.remove(indice);
		System.out.println("Loja Excluída.");		
	}
	
	public void listarLojas() {
		if(lojas.size() > 0) {
			for(Loja loja : lojas) {
				System.out.println("-------------------------");
				System.out.println("ID Loja: " + loja.getIdLoja() + 
						"\nNome: " + loja.getNome() + 
						"\nEndereço: " + loja.getEndereço() + 
						"\nTelefone: " + loja.getTelefone());
				System.out.println("-------------------------");
			}
		}
	}

	public List<Loja> getLojas() {
		return lojas;
	}
	
	
}
