package modelo;

public class Veiculo {
	
	private static int contador = 0;
	
	private String marca;
	private String modelo;
	private int ano;
	private String placa;
	private double preco;
	private TipoDeVeiculo tipoDeVeiculo;
	private int idVeiculo;
	
	
	public Veiculo(String marca, String modelo, int ano, String placa, double preco, TipoDeVeiculo tipoDeVeiculo) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.preco = preco;
		this.tipoDeVeiculo = tipoDeVeiculo;
		this.idVeiculo = ++contador;
	}
	
	public Veiculo() {
		
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public TipoDeVeiculo getTipoDeVeiculo() {
		return tipoDeVeiculo;
	}

	public void setTipoDeVeiculo(TipoDeVeiculo tipoDeVeiculo) {
		this.tipoDeVeiculo = tipoDeVeiculo;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Veiculo.contador = contador;
	}
	
	
}
