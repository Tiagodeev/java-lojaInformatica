package loja;
import java.io.Serializable;

public abstract class Produto implements Serializable {

	protected String nome;
	protected String marca;
	protected float valor;
	protected int quantidade;
	protected Fornecedor fornecedor;
	
	////getters e setters////
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//constructor
	public Produto(String nome, String marca, float valor, int quantidade, Fornecedor fornecedor) {
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
	}

    @Override
    public String toString() {
    	return "nome: " + nome + ", "+ "marca: " + marca + ", " + "valor: " + valor + ", " + "quantidade: " + quantidade;
    }
	
}
