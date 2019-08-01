package modelo;
import java.util.*;

/**
 * 
 */
public class Pedido {

    public Pedido(float valor, String status) {
		this.valor = valor;
		this.status = status;
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
	
	private float valor;
    private String status;

}