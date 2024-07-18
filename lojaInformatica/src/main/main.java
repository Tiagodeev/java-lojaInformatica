package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import loja.Periferico;
import loja.Produto;
import loja.Cliente;
import loja.Componente;
import loja.Fornecedor;
import loja.Funcionario;
import services.Venda;
import services.Manutencao;
import java.io.IOException;
import java.util.InputMismatchException;

public class main {
	public static void main(String[] args) throws IOException {
		
		int i = 1;
		Scanner scr = new Scanner(System.in);
		CadastroControle loja = new CadastroControle();
		
		do {
			
			System.out.println("==========Menu Principal==========");
			System.out.println("----------------------------------" );
			System.out.println("1: Adicionar Cliente");
			System.out.println("2: adicionar Funcionario");
			System.out.println("3: adicionar Fornecedor");
			System.out.println("4: adicionar Produto");
			System.out.println("5: registrar Venda");
			System.out.println("6: registrar Manutenção");
			System.out.println("7: mostrar registros de serviços(vendas, manutenções)");
			System.out.println("8: mostrar dados(clientes, funcionarios, fornecedores, produtos)");
			System.out.println("9: Salvar");
			System.out.println("\nDigite um numero: ");
			
			try {
			
			i = scr.nextInt();
			scr.nextLine();
			
			switch (i) {
				case 1:
					System.out.println("nome: ");
					String clienteNome = scr.nextLine();
					System.out.println("email: ");
					String clienteEmail = scr.nextLine();
					System.out.println("telefone: ");
					String clienteTelefone = scr.nextLine();
					
					loja.addCliente(new Cliente(clienteNome, clienteEmail, clienteTelefone));
					
					break;
				case 2:
					System.out.println("nome: ");
					String funcionarioNome = scr.nextLine();
					System.out.println("cargo: ");
					String funcionarioCargo = scr.nextLine();
					System.out.println("telefone: ");
					String funcionarioContato = scr.nextLine();
					
					loja.addFuncionario(new Funcionario(funcionarioNome, funcionarioCargo, funcionarioContato));
					break;
				case 3:
					System.out.println("nome: ");
					String fornecedorNome = scr.nextLine();
					System.out.println("endereço: ");
					String fornecedorEndereco = scr.nextLine();
					System.out.println("email: ");
					String fornecedorEmail = scr.nextLine();
					System.out.println("telefone: ");
					String fornecedorTelefone = scr.nextLine();
					
					loja.addFornecedor(new Fornecedor(fornecedorNome, fornecedorEndereco, fornecedorEmail, fornecedorTelefone));
					break;
					
				case 4:
					System.out.println("nome: ");
					String produtoNome = scr.nextLine();
					System.out.println("marca: ");
					String produtoMarca = scr.nextLine();
					System.out.println("valor: ");
					float produtoValor = scr.nextFloat();
					System.out.println("quantidade: ");
					int produtoQuant = scr.nextInt();
					scr.nextLine();
					
					System.out.println("fornecedor [Numero]: ");
					for (int n = 0; n <loja.getFornecedores().size(); n++) {
						System.out.println("\n" + (n + 1) + " = " + loja.getFornecedores().get(n).getNome());
					}
					int indexFornecedor = scr.nextInt() - 1;
					scr.nextLine();
					
					System.out.println("componente[1];  periferico[2]:");
					int tipo = scr.nextInt();
					scr.nextLine();
					
					Fornecedor fornecedor = loja.getFornecedores().get(indexFornecedor);
					
					if (tipo == 1){//componente
						System.out.println("especificação: ");
						String produtoEspec = scr.nextLine();
						
						System.out.println("fabricante: ");
						String produtoFabric = scr.nextLine();
						
						loja.addProduto(new Componente(produtoNome, produtoMarca, produtoValor, produtoQuant, fornecedor, produtoEspec, produtoFabric));
						
					}else if (tipo== 2) {//periferico
						System.out.println("tipo: ");
						String produtoTipo = scr.nextLine();
						System.out.println("compatibilidade: ");
						String produtoCompat = scr.nextLine();
						
						loja.addProduto(new Periferico(produtoNome, produtoMarca, produtoValor, produtoQuant, fornecedor, produtoTipo, produtoCompat));
					}
					break;
					
				case 5://realizar venda
					
					System.out.println("cliente [Numero]: ");
					System.out.println("\n");
					for (int n = 0; n <loja.getClientes().size(); n++) {
						System.out.println((n + 1) + " = " + loja.getClientes().get(n).getNome());
					}
					int indexCliente = scr.nextInt() - 1;
					scr.nextLine();
						
			        System.out.print("Escolha o funcionário [número]: ");
			        System.out.println("\n");
			        for (int n = 0; n <loja.getFuncionarios().size(); n++) {
			        	System.out.println("\n" + (n + 1) + " = " + loja.getFuncionarios().get(n).getNome());
			        }
			        int indexFuncionario = scr.nextInt() - 1;
			        scr.nextLine();
					
			        System.out.print("Escolha o produto [número]: ");
			        System.out.println("\n");
			        for (int n = 0; n < loja.getProdutos().size(); n++) {
			        	System.out.println("\n" + (n + 1) + " = " + loja.getProdutos().get(n).getNome());
			        }
			        int indexProduto = scr.nextInt() - 1;
			        scr.nextLine();
			        
			        System.out.println("digite a quantidade: ");
			        int quant = scr.nextInt();
			        scr.nextLine();

			        Cliente cliente = loja.getClientes().get(indexCliente);
			        Funcionario funcionario = loja.getFuncionarios().get(indexFuncionario);
			        Produto produto = loja.getProdutos().get(indexProduto);

			        loja.registrarVenda(new Venda(cliente, funcionario, produto));
			        
			        produto.setQuantidade(produto.getQuantidade() - quant);
			        
					break;
					
				case 6://manutenção
					System.out.println("cliente [Numero]: ");
					System.out.println("\n");
					for (int n = 0; n <loja.getClientes().size(); n++) {
						System.out.println((n + 1) + " = " + loja.getClientes().get(n).getNome());
					}
					int manutencCliente = scr.nextInt() - 1;
					scr.nextLine();
					//int manutencCliente = Integer.parseInt(scr.nextLine()) - 1;
					
					System.out.print("Escolha o funcionário [número]: ");
			        System.out.println("\n");
			        for (int n = 0; n <loja.getFuncionarios().size(); n++) {
			        	System.out.println("\n" + (n + 1) + " = " + loja.getFuncionarios().get(n).getNome());
			        }
			        int manutencFuncionario = scr.nextInt() - 1;
			        scr.nextLine();
			        //int manutencFuncionario = Integer.parseInt(scr.nextLine()) - 1;
					
			        System.out.println("descrição: ");
			        String manutencDesc= scr.nextLine();
			        
			        System.out.println("valor");
					float manutencValor = scr.nextFloat();
			        
			        Cliente mcliente = loja.getClientes().get(manutencCliente);
			        Funcionario mfuncionario = loja.getFuncionarios().get(manutencFuncionario);

			        loja.registrarManutenc(new Manutencao(mcliente, mfuncionario, manutencDesc, manutencValor));
					break;
					
				case 7://registros de serviços
					System.out.println("/n---Vendas---");
					
					loja.printVendas();
					System.out.println("/n---manutencoes---");
					loja.printManutencao();
					break;
					
				case 8:
					System.out.println("\nClientes");
					loja.printClientes();
					System.out.println("\nFuncionarios");
					loja.printFuncionarios();
					System.out.println("\nFornecedores");
					loja.printFornecedores();
					System.out.println("\nProdutos");
					loja.printProdutos();
					break;
					
				case 9:
					loja.saveCadastros();
					break;
					
				default:
					System.out.println("Opção inválida!");
			}
			
		}catch (InputMismatchException e) {
            System.out.println("Opção inválida!");
            scr.next();
		}
			
		}while(i != 0);
		
		scr.close();
	}
}