package manutencao_cadastro;

public interface Gerenciadora<T> {

	public void cadastrar(T objeto);
	
	public void excluir(int indice);
	
	//public void alterarDados(int indice, T objeto);

}
