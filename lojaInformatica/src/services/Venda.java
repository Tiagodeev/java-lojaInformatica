package services;
import java.io.Serializable;
import java.util.List;

import loja.Cliente;
import loja.Funcionario;
import loja.Produto;

public class Venda implements Serializable{
    private Cliente cliente;
    private Funcionario funcionario;
    private Produto produto;
    private float valor;
    
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

	public Produto getProdutos() {
		return produto;
	}

	public void setProdutos(Produto produtos) {
		this.produto = produtos;
	}

	public Venda(Cliente cliente, Funcionario funcionario, Produto produto, float valor) {
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.produto = produto;
		this.valor = valor;
	}
	
    @Override
    public String toString() {
    	return "cliente: " + cliente.getNome()+ ", "+ "funcionario: " + funcionario.getNome() + ", " + "produto: " + produto.getNome() + ", " + "valor: " + valor;
    }
	
}