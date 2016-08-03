package MetodosGerente;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Scanner;

import Classes.Cliente;

public class testarMetodosEliminar
{

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		{
			System.out.println("Clientes:");
			Scanner teclado= new Scanner(System.in);
			{
				
					FileInputStream criar=new FileInputStream("cliente.dat");		
					ObjectInputStream saida= new ObjectInputStream(criar);
					Cliente [] ok = (Cliente[]) saida.readObject();
	
					for (int i = 0; i < ok.length; i++) 
					{
						System.out.println((1+i)+"->"+ok[i].getNome());
						
					}
					saida.close();	


					int posicao=teclado.nextInt()-1;
					if(posicao < ok.length)
					{
						System.out.println("Deseja eliminar o "+ok[posicao].getNome()+"?");
						System.out.println("1->Sim");
						System.out.println("2->Nao");
						int desicao=teclado.nextInt();
						switch (desicao)
						{
						case 1:

						int j=0;
						
						Cliente []novoCliente=new Cliente[ok.length-1];
						
						for (int i = 0; i < ok.length; i++)
						{
							
							if(posicao!=i)
							{
								novoCliente[j]=ok[i];
								j++;
							}
						}
						try 
						{
							FileOutputStream abrir= new FileOutputStream("cliente.dat");
							ObjectOutputStream escrever= new ObjectOutputStream(abrir);
							escrever.writeObject(novoCliente);
							escrever.close();
							System.out.println("Removi");
							
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
						System.out.println("Nao existe");
					}
					
					
				}

		}
	}
}
