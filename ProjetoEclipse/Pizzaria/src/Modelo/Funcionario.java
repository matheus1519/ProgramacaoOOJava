package modelo;
import java.util.*;

import persistencia.DMFuncionario;

/**
 * 
 */
public class Funcionario extends Pessoa 
{
	private String idFuncionario;
    private float salario;
    private String funcao;
    private DMFuncionario dmFuncionario;
    
	public Funcionario(String idFuncionario, String nome, String cpf, String dataNascimento, float salario, String funcao) {
		super(nome, cpf, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
		this.idFuncionario = idFuncionario;
		this.dmFuncionario = new DMFuncionario();
	}
	
	public Funcionario(String nome, String cpf, String dataNascimento, float salario, String funcao) {
		super(nome, cpf, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
		this.dmFuncionario = new DMFuncionario();
	}
	
	public Funcionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
		this.dmFuncionario = new DMFuncionario();
	}
	
	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public float getSalario() 
	{
		return salario;
	}
	public void setSalario(float salario) 
	{
		this.salario = salario;
	}
	
	public String getFuncao()
	{
		return funcao;
	}
	public void setFuncao(String funcao)
	{
		this.funcao = funcao;
	}
    
	public boolean salvar()
    {
    	if(dmFuncionario.salvar(this))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public boolean atualizar()
    {
    	if(dmFuncionario.atualizar(this))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    public boolean apagar()
    {
    	if(dmFuncionario.apagar(this))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

}