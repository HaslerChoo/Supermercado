package Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Vendedor extends Funcionario 
{
	private FileInputStream ficheiro;
	private ObjectInputStream saida;
	private FileOutputStream abrir;
	private ObjectOutputStream escrever;

	public Vendedor(String nome, String sexo, String endereco,
			String contacto, String nrBI, Date datanascimento) 
	{
		super(nome, sexo, endereco, contacto, nrBI, datanascimento);
	}
	
	
	public Stock[] PPVendar(Stock [] lista,int posicao)
	{
		Stock[] listaActual=lerProduto();
		Stock[] novaLista=new Stock[lista.length+1];
		
		for (int i = 0; i < lista.length; i++) 
		{
			novaLista[i]=lista[i];
		}
		novaLista[lista.length]=listaActual[posicao];
		
		return novaLista;
	}
	
	public double CalcularPreco(Stock[] lista)
	{
		double total=0;
		for (int i = 0; i < lista.length; i++)
		{
			total=total+(lista[i].getpreco()*lista[i].getstockExistente());
		}
		
		return total;
		
	}
	
	
	public double Vender(Stock[] lista,double total,double pago)
	{
			criarRecebo(lista, total,(pago-total));
			return (pago-total);
				
	}

	public void criarRecebo(Stock[] lista,double total,double troco) 
	{
		int a=0;
		int t=0;
		System.out.println("\n\t\t\tRecibo");
		System.out.println("_________________________________________________________________________________________________________");
		System.out.println("|Quantidade   |Nome do produto                                 |Preco unitario      |Preco              |");
		System.out.println("_________________________________________________________________________________________________________");
		for (int i = 0; i < lista.length; i++) 
		{
			System.out.print("|"+lista[i].getstockExistente());
			a=(lista[i].getstockExistente()+"").length();
			t=12-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
		
			System.out.print(lista[i].getNome());
			a=lista[i].getNome().length();
			t=47-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			
			System.out.print(lista[i].getpreco());
			a=(lista[i].getpreco()+"").length();
			t=19-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			
			System.out.print((lista[i].getpreco()*lista[i].getstockExistente()));
			a=(((lista[i].getpreco()*lista[i].getstockExistente()))+"").length();
			t=18-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.println("|");
					System.out.println("_________________________________________________________________________________________________________");
				}				
			}							
		}
		
		a=((troco+"").length());
		t=18-a;
		System.out.print("                                                               |Troco               |"+troco);
		for (int j = 0; j <= t; j++) 
		{
			System.out.print(" ");
			if (j==t)
			{
				System.out.println("|");
				System.out.println("                                                               __________________________________________");
				
			}
		}
		
		a=((total+"").length());
		t=18-a;
		System.out.print("                                                               |Total               |"+total);
		for (int j = 0; j <= t; j++) 
		{
			System.out.print(" ");
			if (j==t)
			{
				System.out.println("|");
				System.out.println("                                                               __________________________________________");
				
			}
		}
		System.out.println("obrigado pela perferencia");
		}	
	
	
	
	
	public Stock[] lerProduto()
	{
		Stock []lista = null;
		try 
		{
			ficheiro=new FileInputStream("Produto.dat");
			saida= new ObjectInputStream(ficheiro);
			try 
			{
				lista = (Stock[]) saida.readObject();
				saida.close();
			} 
			catch (ClassNotFoundException e) 
			{
				saida.close();
				lista = new Stock[0];
			}
		}
		catch (IOException e) 
		{
			lista = new Stock[0];
		}
		return lista;
	}
	
	public void listar()
	{
		System.out.println(" ______________________________________________________________________________________________________");
		System.out.println("|Nome do produto                                                |Preco                      |Quantidade|");
		System.out.println(" ______________________________________________________________________________________________________");
		Stock[]lista =lerProduto();
		int t=0;
		int a=0;
		for (int i = 0; i < lista.length; i++) 
		{
			System.out.print("|"+lista[i].getNome());
			
			a=(lista[i].getNome()+"").length();
			t=62-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			System.out.print(lista[i].getpreco());
			
			a=(lista[i].getpreco()+"").length();
			
			t=26-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			
			
			System.out.print(lista[i].getstockExistente());	
			
			a=(lista[i].getstockExistente()+"").length();
			t=9-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.println("|");
				}
			}
			System.out.println(" ______________________________________________________________________________________________________");
		}
		
		
		
	}
	public int procurar(String nome)
	{
		int tamanho=0;
		Stock[] lista =lerProduto();
		for (int i = 0; i < lista.length; i++) 
		{
			if(nome.equalsIgnoreCase(lista[i].getNome()))
			{		
				tamanho=i;
				i=lista.length;
			}
			else
			{
				tamanho=-1;
			}
			
		}
		return tamanho;
	}
	
	
	
	public boolean Reduzir(String nome,int quantidade)
	{
		boolean a=false;
		Stock[] lista =lerProduto();		
		int posicao=procurar(nome);
		int q=(int) lista[posicao].getstockExistente();
		if(q>quantidade)
		{
			long novaQuantidade=q-quantidade;
			ReduzirQuantidade(posicao, novaQuantidade);
			a=true;			
		}
		return a;
	}
	
	public void ReduzirQuantidade(int posicao,long quantidade)
	{
		Stock[] lista =lerProduto();
		lista[posicao].setstockExistente(quantidade);
		gravarStock(lista);
		
	}
	
	
	
	public void gravarStock(Produto [] novaLista)
	{
		try 
		{

			abrir= new FileOutputStream("Produto.dat");
			escrever= new ObjectOutputStream(abrir);
			escrever.writeObject(novaLista);
			escrever.close();		
		} 
		catch (IOException e)
		{
		}
	}
}
