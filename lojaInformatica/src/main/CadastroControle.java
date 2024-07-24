package main;
import loja.Cliente;
import loja.Funcionario;
import loja.Fornecedor;
import loja.Produto;
import services.Venda;
import services.Manutencao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;

public class CadastroControle {
	
	
	//Arquivos
	private static final String clientes_file = "Clientes.dat";
	private static final String funcionarios_file = "Funcionarios.dat";
	private static final String fornecedores_file = "Fornecedores.dat";
	private static final String produtos_file = "Produtos.dat";
	private static final String vendas_file = "vendas.dat";
	private static final String manutenc_file = "manutenc.dat";
	
	File arquivo = new File("registroFinanceiro.txt");

	//Arraylists
	private ArrayList<Cliente> clientes;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Fornecedor> fornecedores;
	private ArrayList<Produto> produtos;
	private ArrayList<Venda> vendas;
	private ArrayList<Manutencao> manutencoes;
	
	public CadastroControle() {
		
		clientes = new ArrayList<>();
		funcionarios = new ArrayList<>();
		fornecedores = new ArrayList<>();
		produtos = new ArrayList<>();
		vendas = new ArrayList<>();
		manutencoes = new ArrayList<>();
		
		loadCadastros();
	}
	
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }
    
    public void addFornecedor(Fornecedor fornecedor) {
    	fornecedores.add(fornecedor);
    }

    public void addProduto(Produto produto) {
    	produtos.add(produto);
    }
    
    public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	
	
	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public ArrayList<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void registrarVenda(Venda venda) {
    	vendas.add(venda);
    }
	
	public void registrarManutenc(Manutencao manutencao) {
		manutencoes.add(manutencao);
    }
    
    public void saveCadastros() {
    	try (
    			
    		ObjectOutputStream oosClientes = new ObjectOutputStream(new FileOutputStream(clientes_file));
    		ObjectOutputStream oosFuncionarios = new ObjectOutputStream(new FileOutputStream(funcionarios_file));
    		ObjectOutputStream oosFornecedores = new ObjectOutputStream(new FileOutputStream(fornecedores_file));
    		ObjectOutputStream oosProdutos = new ObjectOutputStream(new FileOutputStream(produtos_file));
        	ObjectOutputStream oosVendas = new ObjectOutputStream(new FileOutputStream(vendas_file));
    		ObjectOutputStream oosManutenc = new ObjectOutputStream(new FileOutputStream(manutenc_file));)
    	
    		{
    		
               oosClientes.writeObject(clientes);
               oosFuncionarios.writeObject(funcionarios);
               oosFornecedores.writeObject(fornecedores);
               oosProdutos.writeObject(produtos);
               oosVendas.writeObject(vendas);
               oosManutenc.writeObject(manutencoes);
               
           } catch (IOException e) {
               e.printStackTrace();
           }
    }
    
    public void loadCadastros() {
        try (
        		
        	ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream(clientes_file));
        	ObjectInputStream oisFuncionarios = new ObjectInputStream(new FileInputStream(funcionarios_file));
        	ObjectInputStream oisFornecedores = new ObjectInputStream(new FileInputStream(fornecedores_file));
        	ObjectInputStream oisProdutos = new ObjectInputStream(new FileInputStream(produtos_file));
            ObjectInputStream oisVendas = new ObjectInputStream(new FileInputStream(vendas_file));
        	ObjectInputStream oisManutenc = new ObjectInputStream(new FileInputStream(manutenc_file));)
        
        {
        	
            clientes = (ArrayList<Cliente>) oisClientes.readObject();
            funcionarios = (ArrayList<Funcionario>) oisFuncionarios.readObject();
            fornecedores = (ArrayList<Fornecedor>) oisFornecedores.readObject();
            produtos = (ArrayList<Produto>) oisProdutos.readObject();
            vendas = (ArrayList<Venda>) oisVendas.readObject();
            manutencoes = (ArrayList<Manutencao>) oisManutenc.readObject();
            
        } catch (FileNotFoundException e) {
        	
            // caso Arquivo não exista, iniciar com listas vazias
            clientes = new ArrayList<>();
            funcionarios = new ArrayList<>();
            fornecedores = new ArrayList<>();
            produtos = new ArrayList<>();
            vendas = new ArrayList<>();
            manutencoes = new ArrayList<>();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void printClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
        
    public void printFuncionarios() {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
    }
    
    public void printFornecedores() {
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(fornecedor);
        }
    }
    
    public void printProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
    
    public void printVendas() {
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
    }
    
    
    
    public void escreverRegistros() { //escreve em um arquivo
    	
    	try (FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw)) {

            // Escreve cada linha do ArrayList no arquivo
    		bw.write("[Vendas]");
    		bw.newLine();
    		
    		for (Venda venda : vendas) {
                
    				bw.write(venda.toString());
    				bw.newLine();
               }

    		bw.newLine();
    		bw.write("[manutenções]");
    		bw.newLine();
    		
    		for (Manutencao manutencao : manutencoes) {
    			
				bw.write(manutencao.toString());
				bw.newLine();
                
    		}
    		
    		
            System.out.println("dados salvo com sucesso no arquivo!");

           } catch (IOException e) {
               System.err.println("Erro ao salvar o ArrayList no arquivo: " + e.getMessage());
        }
    }
    
    
    public void printManutencao() {
        for (Manutencao manutencao : manutencoes) {
            System.out.println(manutencao);
        }
    }
}