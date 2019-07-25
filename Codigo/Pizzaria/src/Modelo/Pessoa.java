package Modelo;
import java.util.*;

/**
 * 
 */
public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected Date data_nascimento;
	
	public Pessoa(String nome, String cpf, Date data_nascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
	}
	
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getCpf()
	{
		return cpf;
	}
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}
	
	public Date getData_nascimento() 
	{
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) 
	{
		this.data_nascimento = data_nascimento;
	}
   
	
   

}