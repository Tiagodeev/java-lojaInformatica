package loja;

public class Componente extends Produto {

	private String especificacao; // ex: 3.6ghz, 2gbvram...
	private String fabricante; // ex: amd, nvidia...
	
	//construtor
	public Componente(String nome, String marca, float valor, int quantidade, Fornecedor fornecedor, String especificacao, String fabricante) {
		super(nome, marca, valor, quantidade, fornecedor);
		this.especificacao = especificacao;
		this.fabricante = fabricante;

	}

	//getters e setters
	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
    @Override
    public String toString() {
    	return "nome: " + nome + ", "+ "marca: " + marca + ", " + "valor: " + valor + ", " + "quantidade: " + quantidade + ", " + "especificação: " + especificacao + ", " + "fabricante: " + fabricante;
    }
}