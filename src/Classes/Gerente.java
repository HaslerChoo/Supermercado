package Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;
import Interface.Processos;

public class Gerente extends Funcionario
{	



	private FileInputStream ficheiro;
	private ObjectInputStream saida;
	private FileOutputStream abrir;
	private ObjectOutputStream escrever;

	public Gerente(String nome, String sexo, String endereco,
			String contacto, String nrBI, Date datanascimento) 
	{
		super(nome, sexo, endereco, contacto, nrBI, datanascimento);
	}

	public Funcionario[] ler()
	{
		Funcionario []lista = null;
		try 
		{
			ficheiro=new FileInputStream("Funcionario.dat");
			saida= new ObjectInputStream(ficheiro);
			try 
			{
			
				lista = (Funcionario[]) saida.readObject();
				saida.close();
			} 
			catch (ClassNotFoundException e) 
			{

				saida.close();
				lista = new Funcionario[0];
			}
		}
		catch (IOException e) 
		{

			lista = new Funcionario[0];
		}

		return lista;
	}


	
	
	
	public void RegistarFuncionario(Funcionario novoFuncionario) //done
	{
		int novoCodigo=0;
		Funcionario [] lista =ler();
		boolean possoAdd=true;
		int tamanho=lista.length;
		Funcionario [] novaLista =null;
		if(tamanho==0)
		{
			novoCodigo=1;
			novaLista =new Funcionario[1];
			novaLista[0]=novoFuncionario;
		}
		else
		{
			novaLista=new Funcionario[lista.length+1];
			for (int i = 0; i < lista.length; i++) 
			{
					novaLista[i]=lista[i];

				if(	(   novoFuncionario.getNome().equalsIgnoreCase(novaLista[i].getNome()) 
						 
						||  novoFuncionario.getNrBI().equalsIgnoreCase(novaLista[i].getNrBI())))					  
				{
					possoAdd=false;
					i=lista.length;
				}
			}
			
		}
		if (possoAdd)
			{	
				if(novoCodigo!=1)
				{
					novoCodigo=Integer.parseInt(lista[lista.length-1].getCodigo().substring(1));
					System.out.println(novoCodigo);
					novoCodigo=novoCodigo+1;
				}
				String novo="V00"+novoCodigo;
				novoFuncionario.setCodigo(novo);
				novaLista[lista.length]=novoFuncionario;	
				gravar(novaLista,"Addicionei");
			}
			else
			{
				System.out.println("Repiticao de dados, vendedor ja existe");
			}
	}


	
	
	public void EliminarFuncionario(String nome) 
	{
		Funcionario [] lista=ler();
		int j=0;

		Funcionario [] novaLista=new Funcionario[lista.length-1];
		
		for (int i = 0; i < novaLista.length; i++)
		{
			
			if(!lista[i].getNome().equals(nome))
			{
				novaLista[i]=lista[j];
				j++;
				
			}

		}

		if (j==lista.length-1) 
		{		
			if(nome.equals(lista[lista.length-1].getNome()))
			{
				gravar(novaLista,"Eliminado");
			}
			else
			{
				System.out.println("Nao existe");
				gravar(lista,"");
			}
		
		}
		else
		{
			gravar(novaLista,"Eliminado");
		}
	}


	public void ModificarFuncinonario(Scanner teclado, String nome)
	{
		Scanner teclado1=new Scanner(System.in);
		Funcionario []list=ler();
		int posicao=0;
		boolean repiticao=true;
		boolean encontrar=false;
		for (int i = 0; i < list.length; i++) 
		{
			if(nome.equals(list[i].getNome()))
			{
				posicao=i;
				encontrar=true;
				i=list.length;		
			}
		}
		if(encontrar)
		{
			while(repiticao)
			{
				repiticao=false;
				System.out.println("O deseja modificar:");
				System.out.println("1->Conctacto");
				System.out.println("2->Endereco");
				System.out.println("3->Senha");				
				int resposta=teclado1.nextInt();
				switch (resposta)
				{

				case 1:

					System.out.println("Introduzir novo Contacto ");
					list[posicao].setCodigo(teclado.nextLine());
					break;

				case 2:
					System.out.println("Introduzir novo Endereco ");
					list[posicao].setEndereco(teclado.nextLine());
						
					break;
				case 3:
					System.out.println("Introduzir nova Senha ");
					list[posicao].setSenha(teclado.nextLine());						
					break;
					
				default:
					repiticao=true;
					break;
					
					}
				}	
				gravar(list,"Modificado");						
		}
		else
		{
			System.out.println("Funcionario nao existe");
		}
	}
	
	public void gravar(Funcionario [] novaLista,String texto)
	{
		try 
		{

			abrir= new FileOutputStream("Funcionario.dat");
			escrever= new ObjectOutputStream(abrir);
			escrever.writeObject(novaLista);
			escrever.close();
			System.out.println(texto);
			
		} 
		catch (IOException e)
		{
			System.out.println("Erro na "+texto);
		}					
		
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


	
	
	
	public void RegistarProduto(Stock novoStock) 
	{
		int novoCodigo=0;
		Stock [] lista =lerProduto();
		boolean possoAdd=true;
		int tamanho=lista.length;
		Stock [] novaLista =null;
		if(tamanho==0)
		{
			novoCodigo=1;
			novaLista =new Stock[1];
			novaLista[0]=novoStock;
		}
		else
		{
			novaLista=new Stock[lista.length+1];
			for (int i = 0; i < lista.length; i++) 
			{
				novaLista[i]=lista[i];

				if(novoStock.getNome().equalsIgnoreCase(novaLista[i].getNome()))			  
				{
					possoAdd=false;
					i=lista.length;
				}
			}
			
		
		}
		if (possoAdd)
			{	
				if(novoCodigo!=1)
				{
					novoCodigo=Integer.parseInt(lista[lista.length-1].getCodigo().substring(1));
					novoCodigo=novoCodigo+1;
				}
				String novo="P0"+novoCodigo;
				novoStock.setCodigo(novo);
				novaLista[lista.length]=novoStock;	
				gravarStock(novaLista,"Addicionei");
			}
			else
			{
				System.out.println("Repiticao de dados, ja existe");
			}
	}


	public void EliminarProduto(String nome) 
	{
		Stock [] lista=lerProduto();
		int j=0;
		
		try
		{
			Stock [] novaLista=new Stock[lista.length-1];
			
			
			for (int i = 0; i < novaLista.length; i++)
			{
				
				if(!lista[i].getNome().equals(nome))
				{
					novaLista[i]=lista[j];
					j++;
					
				}

			}

			
			if (j==lista.length-1) 
			{		
				if(nome.equals(lista[lista.length-1].getNome()))
				{
					gravarStock(novaLista,"Eliminado");
				}
				else
				{
					System.out.println("Nao existe");
					gravarStock(lista,"");
				}
			
			}
			else
			{
				gravarStock(novaLista,"Eliminado");
			}
		}
		catch(NegativeArraySizeException e)
		{
			System.out.println("Nao existe");
		}
	}


	public void ModificarProduto(Scanner teclado, String nome)
	{
		Scanner teclado1=new Scanner(System.in);
		Stock []list=lerProduto();
		int posicao=0;
		boolean repiticao=true;
		boolean encontrar=false;
		for (int i = 0; i < list.length; i++) 
		{
			if(nome.equals(list[i].getNome()))
			{
				posicao=i;
				encontrar=true;
				i=list.length;		
			}
		}
		if(encontrar)
		{
			while(repiticao)
			{
				repiticao=false;
				System.out.println("O deseja modificar:");
				System.out.println("1->preco");
				System.out.println("2->data de Validade");
				System.out.println("3->Quantidade Minima");	
				System.out.println("4->Quantidade");	
				
				int resposta=teclado1.nextInt();
				switch (resposta)
				{

				case 1:

					System.out.print("Introduzir novo preco: ");
					list[posicao].setpreco(teclado.nextDouble());
					break;

				case 2:
					System.out.println("Introduzir novo data de Validade:  ");
					Date dataValidade=null;
					boolean c=true;
					while(c)
					{

						try
						{
							System.out.println("data de Validade (usar o formato DD/MMM/YYYY): ");
							String data=teclado.next();
							String [] separtar=data.split("/");
							int year=Integer.parseInt(separtar[2]);
							int month=Integer.parseInt(separtar[1]);
							int date=Integer.parseInt(separtar[0]);
							datanascimento=new Date(year, month, date);
							c=false;
						}
						catch(ArrayIndexOutOfBoundsException e)
						{
							System.out.println("Introduzir no formato: DD/MMM/YYYY");
						}
					}
										
					list[posicao].setdataValidade(dataValidade);
						
					break;
				case 3:
					
					System.out.print("Quantidade Minima: ");
					list[posicao].setStockMin(teclado.nextLong());						
					break;
					
				case 4:
					System.out.println("Quantidade");
					list[posicao].setstockExistente(teclado.nextLong());						
					break;
					
				default:
					repiticao=true;
					break;
					
					}
				}	
				gravarStock(list,"Modificado");						
		}
		else
		{
			System.out.println("Produto nao existe nao existe");
		}
	}
	
	
	public void gravarStock(Produto [] novaLista,String texto)
	{
		try 
		{

			abrir= new FileOutputStream("Produto.dat");
			escrever= new ObjectOutputStream(abrir);
			escrever.writeObject(novaLista);
			escrever.close();
			System.out.println(texto);
			
		} 
		catch (IOException e)
		{
			System.out.println("Erro na "+texto);
		}
	}
 
	
	public void listarFuncionario() 
	{
		Funcionario[] lista=ler();
		int a=0;
		int t=0;
		System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________");
		System.out.println("|codigo   |Nome do Cliente                                 |Tipo de funcionario|Sexo            |Enderenco                      |Conctacto           |numero de BI        |Data de nascimento| ");
		System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________");
		for (int i = 0; i < lista.length; i++) 
		{
			System.out.print("|"+lista[i].getCodigo());
			a=(lista[i].getCodigo()+"").length();
			t=8-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			
		
			System.out.print(lista[i].getNome());
			a=(lista[i].getNome().length());
			t=47-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			String texto="";
			if(lista[i].getCodigo().charAt(0)=='V')
			{
				texto="Vendedor";				
			}
			else
			{
				texto="Gerente";
			}
			System.out.print(texto);
			a=texto.length();
			t=18-a;
						
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			
			
			
			
			System.out.print(lista[i].getSexo());
			a=(lista[i].getSexo()+"").length();
			t=15-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			
			
			
			System.out.print(lista[i].getEndereco());
			a=(lista[i].getEndereco()+"").length();
			t=30-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			
			
			System.out.print(lista[i].getContacto());
			a=(lista[i].getContacto()+"").length();
			t=19-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
			
			System.out.print(lista[i].getNrBI());
			a=(lista[i].getNrBI()+"").length();
			t=19-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.print("|");
				}
			}
						
			System.out.print((lista[i].datanascimento.getDay() + "/"+lista[i].datanascimento.getMonth() +"/"+lista[i].datanascimento.getYear()));
			a=((lista[i].datanascimento.getDay() + "/"+lista[i].datanascimento.getMonth() +"/"+lista[i].datanascimento.getYear())+"").length();
			t=17-a;
			for (int j = 0; j <= t; j++) 
			{
				System.out.print(" ");
				if (j==t)
				{
					System.out.println("|");
					System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________");
				}				
			}							
		}
	}
}

