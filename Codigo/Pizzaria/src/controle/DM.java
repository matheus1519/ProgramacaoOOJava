package controle;

import java.sql.*;

import javax.swing.JOptionPane;

public class DM 
{
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/db_pizzaria?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	public static Connection conectar()
	{
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro - Conectar");
			System.out.println(e);
			throw new RuntimeException();
		}
	}
	
	public static void fecharConexao(Connection cone)
	{
		if(cone != null)
		{
			try {
				cone.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro - FecharConexão");
				throw new RuntimeException();
			}
		}
	}
	
	public static void fecharConexao(Connection cone, PreparedStatement stm)
	{
		if(stm != null)
		{
			try {
				stm.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro - FecharConexão/Statement");
				throw new RuntimeException();
			}
		}
		fecharConexao(cone);
	}
	
	public static void fecharConexao(Connection cone, PreparedStatement stm, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro - FecharConexão/Statement/ResultSet");
				throw new RuntimeException();
			}
		}
		fecharConexao(cone,stm);
	}
}
