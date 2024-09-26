package clinica;

public class Funcionario {
	
	public class FuncionarioPadrao{
		
		private String nome;
		private String telefone;
		private String email;
		private String cargo; // veterinario, adm, atendente
		
		//constructor
		public FuncionarioPadrao(String nome, String telefone, String email, String cargo) {
			this.nome = nome;
			this.telefone = telefone;
			this.email = email;
			this.cargo = cargo;
		}

		//getters e setters
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}
	
	}
	
	////////===VETERINARIO===/////////
	public class Veterinario extends FuncionarioPadrao{
		
		private String crm;//registro profissional
		
		//construtor
		public Veterinario(String nome, String telefone, String email, String crm) {
			super(nome, telefone, email, "Veterinario");
			this.crm = crm;
			
		}
		
	}
	
	////////===ATENDENTE===/////////
	public class Atendente extends FuncionarioPadrao{
		
		//construtor
		public Atendente(String nome, String telefone, String email) {
	        super(nome, telefone, email, "Atendente");
	    }
	
	}
	
	////////===ADMINISTRADOR===/////////
	public class Administrador extends FuncionarioPadrao{
		
		//construtor
		public Administrador(String nome, String telefone, String email) {
			super(nome, telefone, email, "Administrador");
		}
		
	}

}