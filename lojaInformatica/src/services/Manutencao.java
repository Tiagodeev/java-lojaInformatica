package services;
import java.io.Serializable;

import loja.Cliente;
import loja.Funcionario;

public class Manutencao implements Serializable{	
	
	private Cliente cliente;
    private Funcionario funcionario;
    private String descricao;
    private Float valor;
    
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Manutencao(Cliente cliente, Funcionario funcionario, String descricao, Float valor) {
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.descricao = descricao;
		this.valor = valor;
	}
	
    @Override
    public String toString() {
    	return "cliente: " + cliente.getNome() + ", "+ "funcionario: " + funcionario.getNome() + ", " + "valor: " + valor;
    }
}