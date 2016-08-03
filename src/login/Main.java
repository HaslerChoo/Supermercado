package login;

import java.util.Scanner;

import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner input= new Scanner (System.in);
		Login log=null;
		boolean login=true;
		
		while(login)
		{
			System.out.print("Username: ");
			String nome=input.nextLine();
			System.out.print("Password: ");
			String senha=input.nextLine();
			log=new Login(nome, senha);
			try
			{
				Funcionario a=log.verifica();
				login=false;
				char c=a.getCodigo().charAt(0);
				if(c=='G')
				{
					Gerente actual=(Gerente)a;
					System.out.println("Bem Vindo Gerente : "+actual.getNome());
					Menu.menuG(actual);
				}
				else
				{
					Vendedor actual=(Vendedor)a;
					System.out.println("Bem Vindo Vendedor : "+actual.getNome());
					Menu.menuV(actual);			
				}
			}
			catch(NullPointerException e)
			{
				login=true;
				System.out.println("Senha/ username errado");
			}
		}
	}
}
