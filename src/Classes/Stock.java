package Classes;

import java.io.Serializable;
import java.util.Date;

public class Stock extends Produto implements Serializable
{
	public Stock(String nome, String tipo, long codigo, double preco,
			Date dataValidade,long StockMin,long stockExistente) 
	{
		super(nome, tipo, codigo, preco, dataValidade);
		this.StockMin=StockMin;
		this.stockExistente=stockExistente;

	}
	
	public Stock(String nome, String tipo, double preco,
			Date dataValidade,long StockMin,long stockExistente) 
	{
		super(nome, tipo, preco, dataValidade);
		this.StockMin=StockMin;
		this.stockExistente=stockExistente;

	}
	
	private String codigo;
	protected long StockMin;
	private long stockExistente;
	private Date dataEntrada, dataSaida;
	


	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public long getStockMin()
	{
		return StockMin;
	}

	public void setStockMin(long stockMin) 
	{
		StockMin = stockMin;
	}

	public long getstockExistente()
	{
		return stockExistente;
	}

	public void setstockExistente(long stockExistente)
	{
		this.stockExistente = stockExistente;
	}

	public Date getDataEntrada() 
	{
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) 
	{
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() 
	{
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida)
	{
		this.dataSaida = dataSaida;
	}
}
