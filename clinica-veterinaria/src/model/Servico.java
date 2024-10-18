package model;
import java.util.Date;

import model.Funcionario.Veterinario;

public class Servico {
	
	class ServicoPadrao{
		private String tipo; // Tipo do serviço (Exame, Vacinação, Consulta, cirurgia, etc.)
		private String descricao;
		private float preco;
		private Animal animal;
    	private Veterinario veterinario;//veterinario que ira realizar o procedimento
    	private Date data;
    	
		public ServicoPadrao(String tipo, String descricao, float preco, Animal animal, Veterinario veterinario, Date data) {
			this.tipo = tipo;
			this.descricao = descricao;
			this.preco = preco;
			this.animal = animal;
			this.veterinario = veterinario;
			this.data = data;
		}
	}
	
	class consulta extends ServicoPadrao{
		
		//construtor
		public consulta(String descricao, float preco, Animal animal, Veterinario veterinario, Date data) {
			super("consulta", descricao, preco, animal, veterinario, data);
			
			}
	}
	
	class cirurgia extends ServicoPadrao{
		
		//construtor
		public cirurgia(String tipo, String descricao, float preco, Animal animal, Veterinario veterinario, Date data) {
			super("cirurgia", descricao, preco, animal, veterinario, data);
					
			}
	}
	
	class vacinacao extends ServicoPadrao{
		
		//construtor
			public vacinacao(String tipo, String descricao, float preco, Animal animal, Veterinario veterinario, Date data) {
				super("vacinacao", descricao, preco, animal, veterinario, data);
					
			}
	}
	
	class exame extends ServicoPadrao{
		//construtor
			public exame(String tipo, String descricao, float preco, Animal animal, Veterinario veterinario, Date data) {
				super("exame", descricao, preco, animal, veterinario, data);
					
			}
		
	}
	
}