package MetodosGerente;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import login.Menu;

import Classes.Cliente;
import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;




public class Escrever 
{
	public static void main(String[] args)
	{

		Gerente D= new Gerente ("Hasler","Masculino","Alto Mae","822730104","1021",new Date(1994,11,30));
		D.setCodigo("G001");
		D.setSenha("hasker");
		Vendedor B= new Vendedor ("Guilherme","Masculino","Alto Mae","001","1021",new Date(1994,11,3));
		B.setCodigo("V001");
		B.setSenha("Fumo");
		Funcionario [] M ={D,B};

		try 
		
		{
			FileOutputStream abrir= new FileOutputStream("Funcionario.dat");
			ObjectOutputStream escrever= new ObjectOutputStream(abrir);
			escrever.writeObject(M);
			escrever.close();
			System.out.println("Escrevi");
			
		} 
			catch (IOException e)
			{
				e.printStackTrace();
			}					
		
		
	}
}