package Classes;

import java.io.Serializable;
import java.util.Date;

public abstract class  Pessoa implements Serializable
{
	protected String nome, sexo, endereco, contacto, nrBI,codigo;;
	protected Date datanascimento;

	

	public Pessoa(String nome, String sexo, String endereco,
			String contacto, String nrBI, Date datanascimento) 
	{
		super();
		this.nome = nome;

		this.sexo = sexo;
		this.endereco = endereco;
		this.contacto = contacto;
		this.nrBI = nrBI;
		this.datanascimento = datanascimento;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}







	public String getSexo() {
		return sexo;
	}




	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public String getEndereco() {
		return endereco;
	}




	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}




	public String getContacto() {
		return contacto;
	}




	public void setContacto(String contacto) {
		this.contacto = contacto;
	}




	public String getNrBI() {
		return nrBI;
	}




	public void setNrBI(String nrBI) {
		this.nrBI = nrBI;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public Date getDatanascimento() {
		return datanascimento;
	}




	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}




	public String toString()
	{
		return "\nCodigo: " + codigo + 
				"\nNome: " + nome +
				"\nSexo: " + sexo +
				"\nEndereco:" + endereco + 
				"\nContacto= " + contacto+
				"\nnrbi: " + nrBI +
				"\ndatanascimento: " + datanascimento.getDay() + "/"+datanascimento.getMonth() +"/"+datanascimento.getYear();
	}

	
	
	
	

}
