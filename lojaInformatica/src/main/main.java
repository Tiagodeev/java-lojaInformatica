package main;
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
			
			System.out.println("\n----------------------------------" );
			System.out.println("==========Menu Principal==========");
			System.out.println("----------------------------------" );
			System.out.println("1: Adicionar Cliente");
			System.out.println("2: adicionar Funcionario");
			System.out.println("3: adicionar Fornecedor");
			System.out.println("4: adicionar Produto");
			System.out.println("5: registrar Venda");
			System.out.println("6: registrar Manutenção");
			System.out.println("7: registrar serviços em um arquivo");
			System.out.println("8: mostrar dados salvos ");
			System.out.println("9: Deletar");
			System.out.println("0: Salvar");
			
			System.out.println("\nDigite um numero: ");
			
			try {
			
			i = scr.nextInt();
			scr.nextLine();
			
			switch (i) {
			
				case 1://adicionar cliente
					System.out.println("nome: ");
					String clienteNome = scr.nextLine();
					System.out.println("email: ");
					String clienteEmail = scr.nextLine();
					System.out.println("telefone: ");
					String clienteTelefone = scr.nextLine();
					
					loja.addCliente(new Cliente(clienteNome, clienteEmail, clienteTelefone));
					System.out.println("cadastro realizado!");
					
					break;
					
				case 2://adicionar funcionario
					System.out.println("nome: ");
					String funcionarioNome = scr.nextLine();
					System.out.println("cargo: ");
					String funcionarioCargo = scr.nextLine();
					System.out.println("telefone: ");
					String funcionarioContato = scr.nextLine();
					
					loja.addFuncionario(new Funcionario(funcionarioNome, funcionarioCargo, funcionarioContato));
					System.out.println("cadastro realizado!");
					
					break;
					
				case 3://adivionar fornecedor
					System.out.println("nome: ");
					String fornecedorNome = scr.nextLine();
					System.out.println("endereço: ");
					String fornecedorEndereco = scr.nextLine();
					System.out.println("email: ");
					String fornecedorEmail = scr.nextLine();
					System.out.println("telefone: ");
					String fornecedorTelefone = scr.nextLine();
					
					loja.addFornecedor(new Fornecedor(fornecedorNome, fornecedorEndereco, fornecedorEmail, fornecedorTelefone));
					System.out.println("cadastro realizado!");
					
					break;
					
				case 4://adicionar produto
					System.out.println("nome: ");
					String produtoNome = scr.nextLine();
					System.out.println("marca: ");
					String produtoMarca = scr.nextLine();
					System.out.println("valor: ");
					float produtoValor = scr.nextFloat();
					System.out.println("quantidade: ");
					int produtoQuant = scr.nextInt();
					scr.nextLine();
					
					System.out.println("fornecedor [Numero]: \n");
					for (int n = 0; n <loja.getFornecedores().size(); n++) {
						System.out.println((n + 1) + " = " + loja.getFornecedores().get(n).getNome());
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
					
					System.out.println("produto registrado!");
					
					break;
					
				case 5://realizar venda
					
					System.out.println("Escolha o cliente [Numero]: \n");
					for (int n = 0; n <loja.getClientes().size(); n++) {
						System.out.println((n + 1) + " = " + loja.getClientes().get(n).getNome());
					}
				
					int indexCliente = scr.nextInt() - 1;
					scr.nextLine();
					
						
			        System.out.print("Escolha o funcionário [número]: \n");
			        for (int n = 0; n <loja.getFuncionarios().size(); n++) {
			        	System.out.println((n + 1) + " = " + loja.getFuncionarios().get(n).getNome());
			        }
			        int indexFuncionario = scr.nextInt() - 1;
			        scr.nextLine();
					
			        System.out.print("Escolha o produto [número]: \n");
			        for (int n = 0; n < loja.getProdutos().size(); n++) {
			        	System.out.println((n + 1) + " = " + loja.getProdutos().get(n).getNome());
			        }
			        int indexProduto = scr.nextInt() - 1;
			        scr.nextLine();
			        
			        System.out.println("digite a quantidade: ");
			        int quant = scr.nextInt();
			        scr.nextLine();
			        
			        //checa se a quantidade solicitada esta disponivel
			        
			        if (loja.getProdutos().get(indexProduto).getQuantidade() < quant) {
			        
				        do {
				        	
				        	System.out.println("quantidade incorreta, digite a quantidade: ");
				        	quant = scr.nextInt();
					        scr.nextLine();
					        
				        } while(loja.getProdutos().get(indexProduto).getQuantidade() < quant);
				    }
			        
			        try {
			        
			        Cliente cliente = loja.getClientes().get(indexCliente);
			        Funcionario funcionario = loja.getFuncionarios().get(indexFuncionario);
			        Produto produto = loja.getProdutos().get(indexProduto);
			        float valor = loja.getProdutos().get(indexProduto).getValor()*quant;

			        loja.registrarVenda(new Venda(cliente, funcionario, produto, valor));
			        
			        produto.setQuantidade(produto.getQuantidade() - quant);
			        
			        
			        //apaga o produto da lista caso nao tenha quantidade
			        if (produto.getQuantidade() == 0) {
			        	loja.getProdutos().remove(indexProduto);
			        	System.out.println("produto esgotado apos a compra\n");
			        	}
			        
			        System.out.println("venda registrada com sucesso!");
			        
			        }catch(IndexOutOfBoundsException e) {
			        	System.out.println("erro, verifique os numeros digitados e tente novamente");
			        }
			        
					break;
					
				case 6://realizar manutenção
					
					System.out.println("escolha o cliente [Numero]: \n");
					
					for (int n = 0; n <loja.getClientes().size(); n++) {//exibe uma lista com os nomes disponiveis
						System.out.println((n + 1) + " = " + loja.getClientes().get(n).getNome());
					}
					
					
					
					int manutencCliente = scr.nextInt() - 1;
					scr.nextLine();
					
					System.out.print("Escolha o funcionário [número]: \n");
			        for (int n = 0; n <loja.getFuncionarios().size(); n++) {
			        	System.out.println((n + 1) + " = " + loja.getFuncionarios().get(n).getNome());
			        }
			        int manutencFuncionario = scr.nextInt() - 1;
			        scr.nextLine();
					
			        System.out.println("descrição: ");
			        String manutencDesc= scr.nextLine();
			        
			        System.out.println("valor");
					float manutencValor = scr.nextFloat();
			        
					try {
					
				        Cliente mcliente = loja.getClientes().get(manutencCliente);
				        Funcionario mfuncionario = loja.getFuncionarios().get(manutencFuncionario);
	
				        loja.registrarManutenc(new Manutencao(mcliente, mfuncionario, manutencDesc, manutencValor));
						
				        System.out.println("manutenção registrada com sucesso!");
				        
			        }catch (IndexOutOfBoundsException e) {
			        	System.out.println("erro, verifique os numeros digitados e tente novamente");
			        }
			        
			        break;
					
				case 7://escreve um relatorio de serviços
					
					loja.escreverRegistros();
					
				    System.out.println("Texto salvo com sucesso!");
					
					break;
					
				case 8://mostra os dados salvos
					
					System.out.println("\nClientes");
					loja.printClientes();
					
					System.out.println("\nFuncionarios");
					loja.printFuncionarios();
					
					System.out.println("\nFornecedores");
					loja.printFornecedores();
					
					System.out.println("\nProdutos");
					loja.printProdutos();
					
					System.out.println("\n ---Vendas---");
					loja.printVendas();
					
					System.out.println("\n ---manutencoes---");
					loja.printManutencao();
					
					break;
					
				case 9://deletar arquivos
					
					System.out.println("1: deletar cliente");
					System.out.println("2: deletar funcionario");
					System.out.println("3: deletar fornecedor");
					System.out.println("4: deletar produto");
					System.out.println("5: deletar registro de venda");
					System.out.println("6: deletar registro de manutenção");
			
					int a = scr.nextInt();
					scr.nextLine();
					
					switch (a) {
					
						case 1:
							System.out.println("cliente [Numero]: ");
							System.out.println("\n");
							for (int n = 0; n <loja.getClientes().size(); n++) {
								System.out.println((n + 1) + " = " + loja.getClientes().get(n).getNome());
							}
							
							
							int indCliente = scr.nextInt() - 1;
							scr.nextLine();
							
							try {
							
								loja.getClientes().remove(indCliente);
								System.out.println("deletado com sucesso!");
								
							}catch (IndexOutOfBoundsException e) {
								
					        	System.out.println("erro, opção invalida");
					        }
							
							break;
							
						case 2:
							System.out.println("funcionario [Numero]: ");
							System.out.println("\n");
							for (int n = 0; n <loja.getFuncionarios().size(); n++) {
								System.out.println((n + 1) + " = " + loja.getFuncionarios().get(n).getNome());
							}
							int indFuncionario = scr.nextInt() - 1;
							scr.nextLine();
							
							try {
							
								loja.getFuncionarios().remove(indFuncionario);
								System.out.println("deletado com sucesso!");
							
							}catch (IndexOutOfBoundsException e) {
					        	System.out.println("erro, opção invalida");
					        }
							
							break;
							
						case 3:
							
							System.out.println("fornecedor [Numero]: ");
							System.out.println("\n");
							for (int n = 0; n <loja.getFornecedores().size(); n++) {
								System.out.println((n + 1) + " = " + loja.getFornecedores().get(n).getNome());
							}
							int indFornecedor = scr.nextInt() - 1;
							scr.nextLine();
							
							try {
								
								loja.getFornecedores().remove(indFornecedor);
								System.out.println("deletado com sucesso!");
								
							}catch (IndexOutOfBoundsException e) {
					        	System.out.println("erro, opção invalida");
					        }
							
							break;
							
						case 4:
							System.out.println("produto [Numero]: ");
							System.out.println("\n");
							for (int n = 0; n <loja.getProdutos().size(); n++) {
								System.out.println((n + 1) + " = " + loja.getProdutos().get(n).getNome());
							}
							int indProduto = scr.nextInt() - 1;
							scr.nextLine();
							
							try {
								
								loja.getProdutos().remove(indProduto);
								System.out.println("deletado com sucesso!");
								
							}catch (IndexOutOfBoundsException e) {
					        	System.out.println("erro, opção invalida");
					        }
							
							break;
							
						case 5:
							System.out.println("vendas [Numero]: ");
							System.out.println("\n");
							for (int n = 0; n <loja.getVendas().size(); n++) {
								System.out.println((n + 1) + " = " + loja.getProdutos().get(n));
							}
							int indVenda = scr.nextInt() - 1;
							scr.nextLine();
							
							try {
								loja.getVendas().remove(indVenda);
								System.out.println("deletado com sucesso!");
								
							}catch (IndexOutOfBoundsException e) {
					        	System.out.println("erro, opção invalida");
					        }
								
							break;
							
						case 6:
							
							System.out.println("manutençãoes [Numero]: ");
							System.out.println("\n");
							for (int n = 0; n <loja.getManutencoes().size(); n++) {
								System.out.println((n + 1) + " = " + loja.getManutencoes().get(n));
							}
							int indManutencao = scr.nextInt() - 1;
							scr.nextLine();
							
							try {
								loja.getManutencoes().remove(indManutencao);
								System.out.println("deletado com sucesso!");
								
							}catch (IndexOutOfBoundsException e) {
					        	System.out.println("erro, opção invalida");
					        }
							
							break;
						
						}
						
					case 0://salvar arquivos
						loja.saveCadastros();
						break;
						
					default:
						System.out.println("Opção inválida!");
			}
			
		}catch (InputMismatchException e){
            System.out.println("Opção inválida!");
            scr.next();
            
		}
			
		}while(i < 10);
		
		scr.close();
	}
}