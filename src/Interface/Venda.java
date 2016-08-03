package Interface;

import Classes.Produto;



public interface Venda 
{
	public abstract int venda(int valor, int preco);
	public abstract void recebo(Produto[]produtos);
	
}
