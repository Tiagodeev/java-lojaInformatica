package loja;
import java.io.Serializable;

public class Fornecedor  implements Serializable {
	
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	
	public Fornecedor(String nome, String endereço, String email, String telefone) {
		this.nome = nome;
		this.endereco = endereço;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereço() {
		return endereco;
	}
	public void setEndereço(String endereço) {
		this.endereco = endereço;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "nome: " + nome + ", " + "endereço: " + endereco + ", " + "email: " + email  + ", " + "contato: " + telefone + " ";
	}
}