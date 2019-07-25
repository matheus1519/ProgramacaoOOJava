package Modelo;
import java.util.*;

/**
 * 
 */
public class Produto {

    private String nome;
    private String descricao;
    private float preco;
    
    public Produto(String nome, String descricao, float preco) {
    	this.nome = nome;
    	this.descricao = descricao;
    	this.preco = preco;
    }
    
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public float getPreco() 
	{
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
    
    
}