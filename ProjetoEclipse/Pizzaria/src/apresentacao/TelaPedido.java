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


import modelo.Funcionario;
import modelo.Produto;
import persistencia.DMCliente;
import persistencia.DMFuncionario;
import persistencia.DMProduto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaPedido extends JInternalFrame 
{
	private JTextField tStatus, tValor, tPedido;
	private JTable tableResultado;
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
				/*
				tIdFuncionario.setText((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),0));
				tNome.setText((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),1));
				tCpf.setText((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),2));
				tNascimento.setText((String)tableResultado.getValueAt(tableResultado.getSelectedRow(),3));
				tSalario.setText(tableResultado.getValueAt(tableResultado.getSelectedRow(),4).toString());
				tFuncao.setText((String)tableResultado.getValueAt(tableResultado.getSelectedRow(),5));
				*/
			}
		});
		tableResultado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableResultado.setAutoscrolls(true);
		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "CPF", "Data de Nascimento", "Sal�rio", "Fun��o"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					true, true, true, false, true, true
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
		tPedido.setColumns(10);
		
		JLabel lblSalario = new JLabel("Valor");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox cbFunc = new JComboBox();
		cbFunc.setModel(new DefaultComboBoxModel(new String[] {"Selecione um Funcion\u00E1rio", "Caralho"}));
		
		JComboBox cbCli = new JComboBox();
		cbCli.setModel(new DefaultComboBoxModel(new String[] {"Selecione um Cliente", "Caralho"}));
		
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
				/*
				if(tIdFuncionario.getText().equalsIgnoreCase(""))
				{
					if(!(tNome.getText().equals("") || tCpf.getText().equals("") || tNascimento.getText().equals("") || tSalario.getText().equals("")|| tFuncao.getText().equals("")))
					{
						Funcionario fun = new Funcionario(tNome.getText(), tCpf.getText(), tNascimento.getText(), Float.parseFloat(tSalario.getText()), tFuncao.getText());
						if(fun.salvar())
						{
							JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
							limpar();
							carregarTabela(modelo);
							tNome.grabFocus();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Erro ao Salvar");
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
						tNome.grabFocus();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Funcionario Existente!\nUse o bot�o 'Editar'");
				}
				*/
			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				Funcionario fun = new Funcionario(tIdFuncionario.getText(),tNome.getText(), tCpf.getText(), tNascimento.getText(), Float.parseFloat(tSalario.getText()), tFuncao.getText());
				if(fun.atualizar())
				{
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
					limpar();
					carregarTabela(modelo);
					tNome.grabFocus();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
				}
				*/
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				if(tIdFuncionario.getText().equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela!");
				}
				else
				{
					int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse funcionario?\nA Exclus�o ser� permanente!", "Aten��o", JOptionPane.WARNING_MESSAGE);
					if(resposta == JOptionPane.YES_OPTION)
					{
						Funcionario fun = new Funcionario(tIdFuncionario.getText());
						if(fun.apagar())
						{
							JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
							limpar();
							carregarTabela(modelo);
							tNome.grabFocus();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Erro ao Deletar");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Opera��o de apagar cancelada!");
					}
				}
				*/
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
		carregarCombo(cbFunc);
		carregarComboCliente(cbCli);
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
	
	public void limpar()
	{
		/*
		tIdFuncionario.setText("");
		tNome.setText("");
		tNascimento.setText("");
		tCpf.setText("");
		tFuncao.setText("");
		tSalario.setText("");
		tNome.grabFocus();
		*/
	}
	
	
	public void carregarTabela(DefaultTableModel modelo)
	{
		modelo.setRowCount(0);
		DMFuncionario dmFun = new DMFuncionario();
		for(Funcionario fun: dmFun.consultar())
		{
			modelo.addRow(new Object[] {
					fun.getIdFuncionario(),
					fun.getNome(),
					fun.getCpf(),
					fun.getDataNascimento(),
					fun.getSalario(),
					fun.getFuncao()
			});
		}
	}
	
	public void carregarCombo(JComboBox combo)
	{
		DMFuncionario dmFun = new DMFuncionario();
		combo.setModel(new DefaultComboBoxModel(new DMFuncionario().consultarNomes().toArray()));
	}
	
	public void carregarComboCliente(JComboBox combo)
	{
		DMFuncionario dmFun = new DMFuncionario();
		combo.setModel(new DefaultComboBoxModel(new DMCliente().consultarNomes().toArray()));
	}
}