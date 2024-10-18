package model;
import java.util.Date;

public class Animal {
	private String nome;
	private Date nascimento;
	private Cliente cliente;
	private String especie;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Animal(String nome, Date nascimento, Cliente cliente, String especie) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.cliente = cliente;
		this.especie = especie;
	}
	
}
