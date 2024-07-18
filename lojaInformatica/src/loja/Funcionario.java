package loja;
import java.io.Serializable;

public class Funcionario implements Serializable {

	private String nome;
	private String cargo;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Funcionario(String nome, String cargo, String telefone) {
		this.nome = nome;
		this.cargo = cargo;
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "nome: " + nome +", "+ "cargo: " + cargo +", "+ "contato: " + telefone;
	}
	
}