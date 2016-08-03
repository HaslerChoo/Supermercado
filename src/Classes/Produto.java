package Classes;

import java.io.Serializable;
import java.util.Date;

public class Produto implements Serializable
{
	
	private String nome, tipo;
	private long codigo;
	protected double preco;
	private Date dataValidade;
	
	public Produto(String nome, String tipo,double preco, Date dataValidade)
	{
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.dataValidade = dataValidade;
	}
	
	
	public Produto(String nome, String tipo, long codigo,
			double preco, Date dataValidade)
	{
		this.nome = nome;
		this.tipo = tipo;
		this.codigo = codigo;
		this.preco = preco;
		this.dataValidade = dataValidade;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String gettipo() 
	{
		return tipo;
	}

	public void settipo(String tipo) 
	{
		this.tipo = tipo;
	}

	public long getcodigo()
	{
		return codigo;
	}

	public void setcodigo(long codigo)
	{
		this.codigo = codigo;
	}

	public double getpreco()
	{
		return preco;
	}

	public void setpreco(double preco)
	{
		this.preco = preco;
	}

	public Date getdataValidade()
	{
		return dataValidade;
	}

	public void setdataValidade(Date dataValidade)
	{
		this.dataValidade = dataValidade;
	}

	public String toString() 
	{
		return "Codigo do Produto -- " + this.codigo
				+ " Nome do Produto -- " + this.nome
				+ " Tipo do Produto -- " + this.tipo
				+ " Preco do Produto -- " + this.preco
				+ " Data de Validade do Produto -- " + this.dataValidade;
	}

}