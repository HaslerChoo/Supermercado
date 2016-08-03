package MetodosGerente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

import Classes.Cliente;

public class testarMetodoAdcionar
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Scanner teclado= new Scanner(System.in);
		
		FileInputStream criar=new FileInputStream("cliente.dat");		
		ObjectInputStream saida= new ObjectInputStream(criar);
		Cliente [] ok = (Cliente[]) saida.readObject();
		
		System.out.println("nome");
		String nome=teclado.nextLine().trim();
		char maior=nome.toUpperCase().charAt(0);
		nome=maior+nome.substring(1).toLowerCase();
		
		System.out.println("nome");
		String apelido=teclado.nextLine().trim();
		maior=apelido.toUpperCase().charAt(0);
		apelido=maior+apelido.substring(1).toLowerCase();
		
		System.out.println("sexo");
		String sexo=teclado.nextLine();

		System.out.println("endereco");
		String endereco=teclado.nextLine();
		System.out.println("contacto");
		String contacto=teclado.nextLine();
		System.out.println("nrBI");
		String nrBI=teclado.nextLine();
		
		System.out.println("datanascimento (usar o formato Dia/mes/ano): ");
		String data=teclado.next();
		String [] separtar=data.split("/");
		int year=Integer.parseInt(separtar[2]);
		int month=Integer.parseInt(separtar[1]);
		int date=Integer.parseInt(separtar[0]);

		Date datanascimento=new Date(year, month, date);
	//	Cliente novoCliente=new Cliente(nome,apelido, sexo, datanascimento, endereco, contacto, nrBI);

		Cliente []novaLista=new Cliente[ok.length+1];
		for (int i = 0; i < ok.length; i++) 
		{
			novaLista[i]=ok[i];			
		}
	//	novaLista[ok.length]=novoCliente;
		try 
		{
			FileOutputStream abrir= new FileOutputStream("cliente.dat");
			ObjectOutputStream escrever= new ObjectOutputStream(abrir);
			escrever.writeObject(novaLista);
			escrever.close();
			System.out.println("Addicionei");
			
		} 
			catch (IOException e)
			{

				e.printStackTrace();
			}					
		
		
	}

}
