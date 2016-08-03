package MetodosGerente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Classes.Cliente;

public class testarMetodosModificar 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		{
	
			Scanner teclado= new Scanner(System.in);
			Scanner teclado1= new Scanner(System.in);
			{
				
					FileInputStream criar=new FileInputStream("cliente.dat");		
					ObjectInputStream saida= new ObjectInputStream(criar);
					Cliente [] ok = (Cliente[]) saida.readObject();
					saida.close();
					for (int i = 0; i < ok.length; i++) 
					{
						System.out.println((1+i)+"->"+ok[i].getNome());						
					}
					System.out.println("Modificar dados do Cliente numero: ");
					int posicao=teclado.nextInt()-1;
					if(posicao < ok.length)
					{
						System.out.println("Deseja modificar  "+ok[posicao].getNome()+"?");
						System.out.println("1->Sim");
						System.out.println("2->Nao");
						int desicao=teclado.nextInt();
						switch (desicao)
						{
						case 1:
							System.out.println("O deseja modificar:");
							System.out.println("1->Apelido ");
							System.out.println("2->Conctacto");
							System.out.println("3->Endereco");
							int resposta=teclado.nextInt();
							switch (resposta)
							{
							case 1:
								System.out.println("Introduzir apelido ");
		
								break;

							case 2:

								System.out.println("Introduzir Contacto ");
								ok[posicao].setCodigo(teclado1.nextLine());
								break;

							case 3:
								System.out.println("Introduzir Endereco ");
								ok[posicao].setEndereco(teclado1.nextLine());
								
								break;

							default:
								break;
							}

						try 
						{
							FileOutputStream abrir= new FileOutputStream("cliente.dat");
							ObjectOutputStream escrever= new ObjectOutputStream(abrir);
							escrever.writeObject(ok);
							escrever.close();
							System.out.println("Modificado");
							
						} 
							catch (IOException e)
							{
								
							}
					
							break;
						case 2:
							break;
						default:
							break;
						}
					}
					else
					{
						System.out.println("Opcao invalida");
					}
					
					
				}

		}
	}

}


