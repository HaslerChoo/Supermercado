 package Classes;


import java.util.Date;

import Interface.Venda;

public class Cliente extends Pessoa implements Venda
{	



	public Cliente(String nome,  String sexo, String endereco,
			String contacto, String nrBI, String codigo, Date datanascimento)
	{
		super(nome, sexo, endereco, contacto, nrBI, datanascimento);
	}


	@Override
	public int venda(int valor, int preco) 
	{
		int troco=preco-valor;
		if (troco<0)
		{
			System.out.println("Valor incompleto, falta"+(valor-preco) );
		}
		
		return troco;
	}

	
	public void recebo(Produto[]produtos)
	{
		System.out.print("| ID |");
		System.out.println("Nome do protudo|");
		System.out.println("preco|");
		int tamanho = produtos.length;
		for (int i= 0; i<tamanho;i++)
		{
			System.out.println(produtos[i]);
			
		}
		
		
	}




	
	
	
	
	

}
