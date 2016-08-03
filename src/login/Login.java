package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;



public class Login
{
	private FileInputStream ficheiro;
	private ObjectInputStream saida;

	private String nome;
	private String senha;
	
	public Login(String nome,String senha) 
	{
		this.nome=nome;
		this.senha=senha;

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
				lista = new Vendedor[0];
			}
		}
		catch (IOException e) 
		{

			lista = new Vendedor[0];
		}


		return lista;
	}


	
	
	public Funcionario verifica()
	{
		Funcionario [] actual=ler();
		Funcionario entrar=null;
		for (int i = 0; i < actual.length; i++) 
		{
			if(actual[i].getNome().equals(nome) && actual[i].getSenha().equals(senha))
			{
				entrar =actual[i];
				i=actual.length;				
			}
			
		}
		
		return entrar;
	}
	
}
