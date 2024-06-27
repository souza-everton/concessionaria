package modelo;

public class TipoDeVeiculo {

	private String categoria;
	private String descricao;
	
	
	public TipoDeVeiculo(String categoria, String descricao) {
		this.categoria = categoria;
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
