package modelo;
import java.util.*;

import javax.swing.JOptionPane;

import persistencia.DMPedido;

/**
 * 
 */
public class Pedido {

	private String idPedido;
	private float valor;
	private String status;
	private Funcionario fun;
	private Cliente cli;
	private DMPedido dmPedido;
	
    public Pedido(float valor, String status, Funcionario fun, Cliente cli) {
		this.valor = valor;
		this.status = status;
		this.fun = fun;
		this.cli = cli;
		this.dmPedido = new DMPedido();
	}

	public Pedido(String idPedido, float valor, String status, Funcionario fun, Cliente cli) {
		this.idPedido = idPedido;
		this.valor = valor;
		this.status = status;
		this.fun = fun;
		this.cli = cli;
		this.dmPedido = new DMPedido();
	}

	public Pedido(String idPedido) {
		this.idPedido = idPedido;
		this.dmPedido = new DMPedido();
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public Funcionario getFun() {
		return fun;
	}

	public void setFun(Funcionario fun) {
		this.fun = fun;
	}

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public float getValor() 
	{
		return valor;
	}
	public void setValor(float valor)
	{
		this.valor = valor;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	 public boolean salvar()
	    {
	    	if(dmPedido.salvar(this))
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }

	   
	    public List<Pedido> consultar()
	    {
	    	List<Pedido> produtos = null;
	    	produtos = dmPedido.consultar();
	    	if(produtos == null)
	    	{
	    		JOptionPane.showMessageDialog(null, "Erro ao Consultar");
	    	}
	    	return produtos;
	    }
	    
	    public List<Pedido> consultar(String nome)
	    {
	    	List<Pedido> produtos = null;
	    	produtos = dmPedido.consultar(nome);
	    	if(produtos == null)
	    	{
	    		JOptionPane.showMessageDialog(null, "Erro ao Consultar");
	    	}
	    	return produtos;
	    }
	    
	    public boolean atualizar()
	    {
	    	if(dmPedido.atualizar(this))
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
	    	if(dmPedido.apagar(this))
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }

}