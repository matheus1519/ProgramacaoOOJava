package modelo;
import java.util.*;

/**
 * 
 */
public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected String dataNascimento;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf, String dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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
	
	public String getDataNascimento() 
	{
		return dataNascimento;
	}
	public void setData_nascimento(String dataNascimento) 
	{
		this.dataNascimento = dataNascimento;
	}
   
	
   

}