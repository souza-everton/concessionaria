package modelo;

public class Venda {

	private static int contador = 0;
	
	private Veiculo veiculoVendido;
	private Vendedor vendedor;
	private Cliente cliente;
	private String data;
	private int idVenda;
	
	public Venda(Veiculo veiculoVendido, Vendedor vendedor, Cliente cliente, String data) {
		this.veiculoVendido = veiculoVendido;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.data = data;
		this.idVenda = ++contador;
	}
	
	public Veiculo getVeiculoVendido() {
		return veiculoVendido;
	}
	public void setVeiculoVendido(Veiculo veiculoVendido) {
		this.veiculoVendido = veiculoVendido;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	
}
