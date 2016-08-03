package Classes;

import java.util.Date;

public class ListaDeProdutos extends Stock
{

	public ListaDeProdutos(String nome, String tipo, double preco,
			Date dataValidade, long StockMin, long stockExistente)
	{
		super(nome, tipo, preco, dataValidade, StockMin, stockExistente);
		
	}

}
