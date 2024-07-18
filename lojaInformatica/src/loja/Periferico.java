package loja;

public class Periferico extends Produto{
	
	private String tipo; // ex: teclado, mouse...
	private String compatibilidade; // ex: usb, vga...
	
	//construtor
	public Periferico(String nome, String marca, float valor, int quantidade,Fornecedor fornecedor, String tipo, String compatibilidade) {
		super(nome, marca, valor, quantidade, fornecedor);
		this.tipo = tipo;
		this.compatibilidade = compatibilidade;
	}

	//getters e setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCompatibilidade() {
		return compatibilidade;
	}

	public void setCompatibilidade(String compatibilidade) {
		this.compatibilidade = compatibilidade;
	}
	
	public void cadastrar() {
		
	}
	
	@Override
    public String toString() {
    	return "nome: " + nome + ", "+ "marca: " + marca + ", " + "valor: " + valor + ", " + "quantidade: " + quantidade + ", " + "Tipo: " + tipo + ", " + "entrada: " + compatibilidade;
    }
}