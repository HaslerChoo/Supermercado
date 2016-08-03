package login;

import java.util.Date;
import java.util.Scanner;

import Classes.Gerente;
import Classes.Stock;
import Classes.Vendedor;

public class Menu
{



	
	public static void menuV(Vendedor actual)
	{
		Scanner dados= new Scanner(System.in);
		Scanner numeros=new Scanner(System.in);
		
		System.out.println("\n\nMenu");
		System.out.println("1->Vender");
		System.out.println("2->Listar Produtos");
		System.out.println("0->sair");
		int escolha=numeros.nextInt();
		
		switch (escolha)
		{
		case 1:
			
			Stock []lista=new Stock[0];
			boolean a=true;
			String nome="";
			while(a)
			{
				System.out.print("Nome do produto: ");
				nome=dados.nextLine();
				int posicao=actual.procurar(nome);	
				
				if(posicao!=-1)
				{
					System.out.print("Quantidade: ");
					int quantidade=numeros.nextInt();
					boolean verifica=actual.Reduzir(nome, quantidade);
					
					if(verifica)
					{
						
						boolean aumentar=true;
						for (int i = 0; i < lista.length; i++) 
						{
							if(nome.equalsIgnoreCase(lista[i].getNome()))
							{
								lista[i].setstockExistente(quantidade+lista[i].getstockExistente());
								aumentar=false;
							}
						}
						if(aumentar)
						{				
							lista=actual.PPVendar(lista, posicao);
							lista[lista.length-1].setstockExistente(quantidade);
						}	
							
							
						System.out.println("addiciona mais produtos");
						System.out.println("1-sim");
						System.out.println("2-nao");
						
						switch (dados.nextInt()) 
						{
						case 1:
								a=true;
								
							break;

						case 2:
							double total=actual.CalcularPreco(lista);
							System.out.println("Deve pagar: "+total);
							boolean possoContinuar=true;
							double pago=0;
							while(possoContinuar)
							{

								System.out.print("Valor pago: ");			
								pago= dados.nextDouble();
								
								if(pago>=total)
								{
									possoContinuar=false;
									actual.Vender(lista, total, pago);
								}
							}						
							a=false;
							break;
						}
					}		
					else
					{
						System.out.println("Problemas na quantidade");
					}

				}
				else
				{
					a=true;
					System.out.println("Produto nao existe");
				}				
			}
			

			break;
		case 2:
			
			actual.listar();
			break;
		case 0:
			
			System.out.println("Tchao");
			break;
		default:
			System.out.println("Opcao invalida");
			menuV(actual);
		
		}
		if(escolha!=0)
		{
			menuV(actual);
		}
	
	}
	

	public static void menuG(Gerente actual)
	{
		Scanner dados= new Scanner(System.in);
		Scanner numeros=new Scanner(System.in);
	

		System.out.println("\n\n\tMenu\n\n");
		System.out.println("1->adcionar Funcionario");		

		System.out.println("2->Eliminar Funcionario");	
	
		System.out.println("3->Modificar Funcionario");
		
		System.out.println("4->Ver todos Funcionario");
		
		System.out.println("5->Registar Produto");		

		System.out.println("6->Eliminar Produto");	

		System.out.println("7->Modificar Produto");
		
		System.out.println("8->Listar todos Produtos");
		
		System.out.println("0->Sair");

		System.out.println("Escolher uma opcao");
		int escolhar=numeros.nextInt();
		switch (escolhar)
		{
		case 1:
		Vendedor novoVendedor=criarDadosV(dados);
			actual.RegistarFuncionario(novoVendedor);
			break;
		
		case 2:
			System.out.print("nome do vendedor: ");
			String nome=dados.nextLine();
			if(nome.equals(actual.getNome()))
			{
				System.out.println("Nao pode se eliminar");
			}
			else
			{
				actual.EliminarFuncionario(nome);
			}
			
		break;
		
		case 3:
			System.out.print("nome do vendedor: ");
			actual.ModificarFuncinonario(dados, dados.nextLine());
			break;
		case 4:
			actual.listarFuncionario();
		break;
		case 5:
			actual.RegistarProduto(criarProduto(dados));					
			break;
			
		case 6:
			System.out.print("Nome do produto: ");
			actual.EliminarProduto(dados.nextLine());
		break;
		case 7:
			
			System.out.print("Nome do produto: ");
			actual.ModificarProduto(numeros, dados.nextLine());
			break;
		case 8:
		break;
		case 0:
			
			System.out.println("Tchao");
			break;
		default:
			System.out.println("Opcao invalida");
			menuG(actual);
		
		}
		if(escolhar!=0)
		{
			menuG(actual);
		}

	}
	
	
	@SuppressWarnings("deprecation")
	public static Stock criarProduto(Scanner dados)
	{
		System.out.print("introduzir nome: ");	
		String nome=dados.nextLine();

		System.out.print("tipo: ");	
		String tipo=dados.nextLine();
		
		System.out.print("preco: ");
		double preco=dados.nextDouble();
		
		System.out.print("Quantidade: ");		
		long stockExistente=dados.nextLong();
		
		System.out.print("Quantidade minima: ");		
		long StockMin=dados.nextLong();
		
		boolean c=true;
		Date dataValidade=null;
		while(c)
		{

			try
			{
				System.out.println("data de Validade (usar o formato DD/MMM/YYYY): ");
				String data=dados.next();
				String [] separtar=data.split("/");
				int year=Integer.parseInt(separtar[2]);
				int month=Integer.parseInt(separtar[1]);
				int date=Integer.parseInt(separtar[0]);
				dataValidade=new Date(year, month, date);
				c=false;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Introduzir no formato: DD/MMM/YYYY");
			}

		}
		Stock novo=new Stock(nome, tipo, preco, dataValidade, StockMin, stockExistente);
		return novo;
		
	}	

	@SuppressWarnings("deprecation")
	public static Vendedor criarDadosV(Scanner dados)
	{
		System.out.print("introduzir nome: ");	
		String nome=dados.nextLine();

		System.out.print("sexo: ");	
		String sexo=dados.nextLine();
		
		System.out.print("Endereco: ");	
		String endereco=dados.nextLine();
		
		System.out.print("Contacto: ");
		String contacto=dados.nextLine();
		
		System.out.print("Senha: ");		
		String senha=dados.nextLine();
		
		System.out.print("Numero de BI: ");		
		String nrBI=dados.nextLine();
		boolean c=true;
		Date datanascimento=null;
		while(c)
		{

			try
			{
				System.out.println("datanascimento (usar o formato DD/MMM/YYYY): ");
				String data=dados.next();
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
		Vendedor a= new Vendedor(nome, sexo, endereco, contacto, nrBI, datanascimento);
		a.setSenha(senha);
		return a;
	}
}
