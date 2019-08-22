package persistencia;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import modelo.Produto;
import modelo.Cliente;
import java.util.*;

public class DMCliente {
	private Connection conexao = null;
	private String sql;
	
	public DMCliente() {
		conexao = DM.conectar();
	}
	
	public boolean salvar(Cliente cli)
	{
		
		PreparedStatement stm = null;
		sql = "INSERT INTO cliente(nome, cpf, data_nascimento) VALUES (?,?,?)";
		
		try 
		{
			stm = conexao.prepareStatement(sql);
			stm.setString(1, cli.getNome());
			stm.setString(2, cli.getCpf());
			stm.setString(3, cli.getDataNascimento());
			stm.executeUpdate();
			return true;
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Erro - Salvar");
			System.out.println(e);
			return false;
		}
		finally
		{
			DM.fecharConexao(conexao, stm);
		}
	}

	public List<Cliente> consultar(String nome)
	{
		sql = "SELECT * FROM cliente WHERE nome LIKE ?;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			stm = conexao.prepareStatement(sql);
			stm.setString(1, "%"+nome+"%");
			rs = stm.executeQuery();
			if(rs.next())
			{
				do
				{
					Cliente cli = new Cliente(rs.getString("id_cliente"),rs.getString("nome"),rs.getString("cpf"),rs.getString("data_nascimento"));
					clientes.add(cli);
				} while((rs.next()));				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		finally
		{
			DM.fecharConexao(conexao, stm, rs);
		}
		return clientes;
		
	}
	
	public List<Cliente> consultar()
	{
		sql = "SELECT * FROM cliente;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			stm = conexao.prepareStatement(sql);
			rs = stm.executeQuery();
			
			if(rs.next())
			{			
				do
				{
					Cliente cli = new Cliente(rs.getString("id_cliente"),rs.getString("nome"),rs.getString("cpf"),rs.getDate("data_nascimento").toString());
					clientes.add(cli);
				} while((rs.next()));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		finally
		{
			DM.fecharConexao(conexao, stm, rs);
		}
		return clientes;
		
	}

	public boolean atualizar(Cliente cli)
	{
		
		PreparedStatement stm = null;
		Produto prodComp = null;
		
		sql = "UPDATE cliente SET nome = ?, cpf = ?, data_nascimento = ? WHERE id_cliente = ?;";
		
		try 
		{
			
			stm = conexao.prepareStatement(sql);
			stm.setString(1, cli.getNome());
			stm.setString(2, cli.getCpf());
			stm.setString(3, cli.getDataNascimento());
			stm.setString(4, cli.getIdCliente());
			stm.executeUpdate();
			
			return true;
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Erro - Salvar");
			System.out.println(e);
			return false;
		}
		finally
		{
			DM.fecharConexao(conexao, stm);
		}
	}
	
	public boolean apagar(Cliente cli)
	{
		
		PreparedStatement stm = null;
		sql = "delete from cliente where id_cliente = ?;";
		
		try 
		{
			stm = conexao.prepareStatement(sql);
			stm.setString(1, cli.getIdCliente());
			stm.execute();
			return true;
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Erro - Deletar");
			System.out.println(e);
			return false;
		}
		finally
		{
			DM.fecharConexao(conexao, stm);
		}
	}

}
