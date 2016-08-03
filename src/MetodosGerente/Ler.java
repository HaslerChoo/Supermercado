package MetodosGerente;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Classes.Cliente;



public class Ler 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		
		FileInputStream criar=new FileInputStream("cliente.dat");		
		ObjectInputStream saida= new ObjectInputStream(criar);
		Cliente [] ok = (Cliente[]) saida.readObject();

		for (int i = 0; i < ok.length; i++) 
		{
			System.out.println(ok[i]+"\n");
			
		}
		saida.close();		
	}

}