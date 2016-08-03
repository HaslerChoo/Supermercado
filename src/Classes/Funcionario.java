package Classes;

import java.util.Date;

public abstract class Funcionario extends Pessoa
{
	protected String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario(String nome, String sexo,
			String endereco, String contacto, String nrBI, Date datanascimento)
	{
		super(nome, sexo, endereco, contacto, nrBI, datanascimento);

	}


}
