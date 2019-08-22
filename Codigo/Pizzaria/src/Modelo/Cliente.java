package modelo;
import java.util.*;

import javax.swing.JOptionPane;

import persistencia.DMCliente;

/**
 * 
 */
public class Cliente extends Pessoa 
{
	private String idCliente;
	private DMCliente dmCliente;
	
	public Cliente(String idCliente, String nome, String cpf, String data_nascimento) {
		super(nome, cpf, data_nascimento);
		this.idCliente = idCliente;
		this.dmCliente = new DMCliente();
	}
	
	public Cliente(String nome, String cpf, String data_nascimento) {
		super(nome, cpf, data_nascimento);
		this.idCliente = idCliente;
		this.dmCliente = new DMCliente();
	}
	
	public Cliente(String idCliente) {
		this.idCliente = idCliente;
		this.dmCliente = new DMCliente();
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	public boolean salvar()
    {
    	if(dmCliente.salvar(this))
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
    	if(dmCliente.atualizar(this))
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
    	if(dmCliente.apagar(this))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
		
}