package apresentacao;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pedido;
import modelo.Pedido;
import modelo.Produto;
import persistencia.DMCliente;
import persistencia.DMFuncionario;
import persistencia.DMPedido;
import persistencia.DMProduto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;

public class TelaPedido extends JInternalFrame 
{
	private JTextField tStatus, tValor, tPedido;
	private JTable tableResultado;
	private Funcionario funAtual;
	private Cliente cliAtual;
	private JComboBox cbFunc;
	private JComboBox cbCli;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedido frame = new TelaPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPedido() {
		setClosable(true);
		setTitle("Gerenciar Pedido");
		setSize(750,400);
		
		JPanel pPrincipal = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pPrincipal, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pPrincipal, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
		);
		
		JLabel lId = new JLabel("Funcion\u00E1rio:");
		lId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lCpf = new JLabel("Status:");
		lCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tStatus = new JTextField();
		tStatus.setColumns(10);
		
		JPanel panel = new JPanel();
		
		tableResultado = new JTable();
		tableResultado.setFillsViewportHeight(true);
		tableResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableResultado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tPedido.setText((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),0));
				cbFunc.setSelectedItem((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),1));
				cbCli.setSelectedItem((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),2));
				tStatus.setText((String)tableResultado.getValueAt(tableResultado.getSelectedRow(),3));
				tValor.setText(tableResultado.getValueAt(tableResultado.getSelectedRow(),4).toString());
			}
		});
		tableResultado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableResultado.setAutoscrolls(true);
		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Funcionario", "Cliente", "Status", "Valor"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
			
		tableResultado.setModel(modelo);
		tableResultado.getColumnModel().getColumn(0).setPreferredWidth(53);
		tableResultado.getColumnModel().getColumn(1).setPreferredWidth(115);
		tableResultado.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableResultado.getColumnModel().getColumn(3).setPreferredWidth(98);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNome_1 = new JLabel("Funcion\u00E1rio");
		lblNome_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDescrio_1 = new JLabel("Cliente");
		lblDescrio_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPreo_1 = new JLabel("Status");
		lblPreo_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("Valor:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tValor = new JTextField();
		tValor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tPedido = new JTextField();
		tPedido.setEditable(false);
		tPedido.setColumns(10);
		
		JLabel lblSalario = new JLabel("Valor");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cbFunc = new JComboBox();
		cbCli = new JComboBox();
		
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_pPrincipal = new GroupLayout(pPrincipal);
		gl_pPrincipal.setHorizontalGroup(
			gl_pPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pPrincipal.createSequentialGroup()
					.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pPrincipal.createSequentialGroup()
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pPrincipal.createSequentialGroup()
									.addGap(24)
									.addGroup(gl_pPrincipal.createParallelGroup(Alignment.TRAILING)
										.addComponent(lCpf)
										.addComponent(lblCliente)
										.addComponent(lId)
										.addComponent(lblNewLabel)))
								.addGroup(gl_pPrincipal.createSequentialGroup()
									.addGap(75)
									.addComponent(lblNewLabel_1)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING, false)
									.addComponent(tStatus, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
									.addComponent(tValor, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addComponent(cbCli, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cbFunc, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(tPedido, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_pPrincipal.createSequentialGroup()
									.addGap(36)
									.addComponent(lblId)
									.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
									.addComponent(lblNome_1)
									.addGap(28)
									.addComponent(lblDescrio_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(lblPreo_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(65))
								.addGroup(gl_pPrincipal.createSequentialGroup()
									.addGap(18)
									.addComponent(tableResultado, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pPrincipal.setVerticalGroup(
			gl_pPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pPrincipal.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_pPrincipal.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pPrincipal.createSequentialGroup()
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPreo_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescrio_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tableResultado, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(gl_pPrincipal.createSequentialGroup()
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(tPedido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbFunc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lId))
							.addGap(18)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbCli, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lCpf)
								.addComponent(tStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(tValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(25)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnInserir = new JButton("Salvar");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tPedido.getText().equalsIgnoreCase(""))
				{
					if(!(cbCli.getSelectedIndex() == 0 || cbFunc.getSelectedIndex() == 0  || tStatus.getText().equals("") || tValor.getText().equals("")))
					{
						funAtual = new DMFuncionario().consultarUm((String)cbFunc.getSelectedItem());
						cliAtual = new DMCliente().consultarUm((String)cbCli.getSelectedItem());
						Pedido ped = new Pedido(Float.parseFloat(tValor.getText()), tStatus.getText(), funAtual,cliAtual);
						if(ped.salvar())
						{
							JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
							limpar();
							carregarTabela(modelo);
							tStatus.grabFocus();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Erro ao Salvar");
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
						tStatus.grabFocus();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Pedido Existente!\nUse o botão 'Editar'");
				}
			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funAtual = new DMFuncionario().consultarUm((String)cbFunc.getSelectedItem());
				cliAtual = new DMCliente().consultarUm((String)cbCli.getSelectedItem());
				Pedido ped = new Pedido(tPedido.getText(),Float.parseFloat(tValor.getText()), tStatus.getText(), funAtual,cliAtual);
				if(ped.atualizar())
				{
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
					limpar();
					carregarTabela(modelo);
					tStatus.grabFocus();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tPedido.getText().equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(null, "Selecione um pedido da tabela!");
				}
				else
				{
					int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse pedido?\nA Exclusão será permanente!", "Atenção", JOptionPane.WARNING_MESSAGE);
					if(resposta == JOptionPane.YES_OPTION)
					{
						Pedido ped = new Pedido(tPedido.getText());
						if(ped.apagar())
						{
							JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
							limpar();
							carregarTabela(modelo);
							tStatus.grabFocus();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Erro ao Deletar");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Operação de apagar cancelada!");
					}
				}
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarTabela(modelo);
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(59)
					.addComponent(btnLimpar)
					.addGap(56)
					.addComponent(btnInserir)
					.addGap(60)
					.addComponent(btnEditar)
					.addGap(52)
					.addComponent(btnConsultar)
					.addGap(59)
					.addComponent(btnApagar)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnApagar)
						.addComponent(btnConsultar)
						.addComponent(btnLimpar)
						.addComponent(btnInserir)
						.addComponent(btnEditar))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		pPrincipal.setLayout(gl_pPrincipal);
		getContentPane().setLayout(groupLayout);
		carregarTabela(modelo);
		carregarFunc(cbFunc);
		carregarCli(cbCli);
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
	
	public void limpar()
	{
		tPedido.setText("");
		tStatus.setText("");
		tValor.setText("");
		cbCli.setSelectedIndex(0);
		cbFunc.setSelectedIndex(0);
		tStatus.grabFocus();
	}
	
	
	public void carregarTabela(DefaultTableModel modelo)
	{
		modelo.setRowCount(0);
		DMPedido dmPed = new DMPedido();
		for(Pedido ped: dmPed.consultar())
		{
			modelo.addRow(new Object[] {
					ped.getIdPedido(),
					ped.getFun().getNome(),
					ped.getCli().getNome(),
					ped.getStatus(),
					ped.getValor()
			});
		}
	}
	
	public void carregarFunc(JComboBox combo)
	{
		combo.setModel(new DefaultComboBoxModel(new DMFuncionario().consultarNomes().toArray()));
	}
	
	public void carregarCli(JComboBox combo)
	{
		combo.setModel(new DefaultComboBoxModel(new DMCliente().consultarNomes().toArray()));
	}
}
