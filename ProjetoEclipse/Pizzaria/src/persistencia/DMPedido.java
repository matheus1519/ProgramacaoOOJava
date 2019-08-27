package persistencia;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pedido;
import java.util.*;

public class DMPedido {
	private Connection conexao = null;
	private String sql;
	
	public DMPedido() {
		conexao = DM.conectar();
	}
	
	public boolean salvar(Pedido p)
	{
		
		PreparedStatement stm = null;
		sql = "INSERT INTO pedido(status, valor, id_cliente,id_funcionario) VALUES (?,?,?,?)";
		
		try 
		{
			stm = conexao.prepareStatement(sql);
			stm.setString(1, p.getStatus());
			stm.setFloat(2, p.getValor());
			stm.setString(3, p.getCli().getIdCliente());
			stm.setString(4, p.getFun().getIdFuncionario());
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

	public List<Pedido> consultar(String nome)
	{
		sql = "SELECT * FROM pedido WHERE nome LIKE ?;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		try {
			stm = conexao.prepareStatement(sql);
			stm.setString(1, "%"+nome+"%");
			rs = stm.executeQuery();
			if(rs.next())
			{
				do
				{
					Funcionario fun = new DMFuncionario().consultarUm(rs.getInt("id_funcionario"));
					Cliente cli = new DMCliente().consultarUm(rs.getInt("id_cliente"));
					Pedido ped = new Pedido(rs.getString("id_pedido"),rs.getFloat("valor"),rs.getString("status"),fun,cli);
					pedidos.add(ped);
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
		return pedidos;
		
	}
	
	public List<Pedido> consultar()
	{
		sql = "SELECT * FROM pedido;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		try {
			stm = conexao.prepareStatement(sql);
			rs = stm.executeQuery();
			if(rs.next())
			{
				do
				{
					Funcionario fun = new DMFuncionario().consultarUm(rs.getInt("id_funcionario"));
					Cliente cli = new DMCliente().consultarUm(rs.getInt("id_cliente"));
					Pedido ped = new Pedido(rs.getString("id_pedido"),rs.getFloat("valor"),rs.getString("status"),fun,cli);
					pedidos.add(ped);
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
		return pedidos;
		
	}

	public boolean atualizar(Pedido p)
	{
		
		PreparedStatement stm = null;
		String campo = "";
		Pedido prodComp = null;
		
		sql = "UPDATE pedido SET status = ?, valor = ?, id_funcionario = ?, id_cliente = ? WHERE id_pedido = '"+ p.getIdPedido() +"';";
		
		try 
		{
			
			stm = conexao.prepareStatement(sql);
			stm.setString(1, p.getStatus());
			stm.setFloat(2, p.getValor());
			stm.setString(3, p.getCli().getIdCliente());
			stm.setString(4, p.getFun().getIdFuncionario());
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
	
	public boolean apagar(Pedido ped)
	{
		
		PreparedStatement stm = null;
		sql = "delete from pedido where id_pedido = ?;";
		
		try 
		{
			stm = conexao.prepareStatement(sql);
			stm.setString(1, ped.getIdPedido());
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
