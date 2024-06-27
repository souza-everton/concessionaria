package modelo;

public class Loja {

	private static int contador = 0;
	
	private String nome;
	private String endereço;
	private String telefone;
	private int idLoja;
	
	
	public Loja(String nome, String endereço, String telefone) {
		this.nome = nome;
		this.endereço = endereço;
		this.telefone = telefone;
		this.idLoja = ++contador;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdLoja() {
		return idLoja;
	}
	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}
	
	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Loja.contador = contador;
	}
}
