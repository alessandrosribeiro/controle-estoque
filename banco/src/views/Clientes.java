package views;

import java.awt.BorderLayout;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Clientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtClientes;
	private JTextField txtIDfor;
	private JTextField txtContato;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtWhatsapp;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtObs;
	@SuppressWarnings("rawtypes")
	JComboBox cboUf;
	@SuppressWarnings("unused")
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Clientes dialog = new Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Clientes() {
		setTitle("CLIENTES");
		setBounds(100, 100, 450, 657);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNewLabel);

		txtClientes = new JTextField();
		txtClientes.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				pesquisarClientes();
			}
		});
		txtClientes.setBounds(68, 8, 150, 20);
		contentPanel.add(txtClientes);
		txtClientes.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 414, 60);
		contentPanel.add(scrollPane);

		table2 = new JTable();
		scrollPane.setViewportView(table2);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 107, 46, 14);
		contentPanel.add(lblNewLabel_1);

		txtIDfor = new JTextField();
		txtIDfor.setBounds(33, 108, 86, 20);
		contentPanel.add(txtIDfor);
		txtIDfor.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton.setBounds(129, 107, 89, 23);
		contentPanel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Contato");
		lblNewLabel_2.setBounds(10, 151, 46, 14);
		contentPanel.add(lblNewLabel_2);

		txtContato = new JTextField();
		txtContato.setBounds(58, 148, 160, 20);
		contentPanel.add(txtContato);
		txtContato.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(228, 151, 59, 14);
		contentPanel.add(lblNewLabel_3);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(290, 148, 134, 20);
		contentPanel.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(10, 186, 46, 14);
		contentPanel.add(lblNewLabel_4);

		txtEmail = new JTextField();
		txtEmail.setBounds(58, 183, 160, 20);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Whatsapp");
		lblNewLabel_5.setBounds(228, 186, 59, 14);
		contentPanel.add(lblNewLabel_5);

		txtWhatsapp = new JTextField();
		txtWhatsapp.setBounds(290, 183, 134, 20);
		contentPanel.add(txtWhatsapp);
		txtWhatsapp.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("CEP");
		lblNewLabel_11.setBounds(10, 247, 46, 14);
		contentPanel.add(lblNewLabel_11);

		txtCep = new JTextField();
		txtCep.setToolTipText("CEP");
		txtCep.setColumns(10);
		txtCep.setBounds(44, 244, 86, 20);
		contentPanel.add(txtCep);

		JButton btnCep = new JButton("Buscar");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnCep.setBounds(140, 243, 89, 23);
		contentPanel.add(btnCep);

		JLabel lblNewLabel_12 = new JLabel("Endere\u00E7o");
		lblNewLabel_12.setBounds(10, 290, 71, 14);
		contentPanel.add(lblNewLabel_12);

		txtEndereco = new JTextField();
		txtEndereco.setToolTipText("Endere\u00E7o");
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(70, 287, 210, 20);
		contentPanel.add(txtEndereco);

		JLabel lblNewLabel_13 = new JLabel("N\u00BA");
		lblNewLabel_13.setBounds(290, 290, 33, 14);
		contentPanel.add(lblNewLabel_13);

		txtNumero = new JTextField();
		txtNumero.setToolTipText("N\u00FAmero");
		txtNumero.setColumns(10);
		txtNumero.setBounds(312, 287, 79, 20);
		contentPanel.add(txtNumero);

		JLabel lblNewLabel_14 = new JLabel("Complemento");
		lblNewLabel_14.setBounds(10, 331, 79, 14);
		contentPanel.add(lblNewLabel_14);

		txtComplemento = new JTextField();
		txtComplemento.setToolTipText("Complemento");
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(94, 328, 199, 20);
		contentPanel.add(txtComplemento);

		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(10, 368, 46, 14);
		contentPanel.add(lblNewLabel_15);

		txtBairro = new JTextField();
		txtBairro.setToolTipText("Bairro");
		txtBairro.setColumns(10);
		txtBairro.setBounds(58, 365, 211, 20);
		contentPanel.add(txtBairro);

		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(10, 407, 46, 14);
		contentPanel.add(lblNewLabel_16);

		txtCidade = new JTextField();
		txtCidade.setToolTipText("Cidade");
		txtCidade.setColumns(10);
		txtCidade.setBounds(68, 404, 175, 20);
		contentPanel.add(txtCidade);

		JLabel lblNewLabel_5_1 = new JLabel("UF");
		lblNewLabel_5_1.setBounds(290, 368, 46, 14);
		contentPanel.add(lblNewLabel_5_1);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUf.setToolTipText("Estados");
		cboUf.setBounds(312, 364, 46, 22);
		contentPanel.add(cboUf);

		JLabel lblNewLabel_18 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_18.setBounds(10, 457, 86, 14);
		contentPanel.add(lblNewLabel_18);

		txtObs = new JTextField();
		txtObs.setToolTipText("Observa\u00E7\u00E3o");
		txtObs.setColumns(10);
		txtObs.setBounds(90, 435, 334, 64);
		contentPanel.add(txtObs);

		JButton btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarClientes();
			}
		});
		btnCreate.setIcon(new ImageIcon(Clientes.class.getResource("/img/create.png")));
		btnCreate.setToolTipText("Adicionar Fornecedor");
		btnCreate.setBounds(10, 534, 89, 62);
		contentPanel.add(btnCreate);

		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarClientes();
			}
		});
		btnUpdate.setIcon(new ImageIcon(Clientes.class.getResource("/img/update.png")));
		btnUpdate.setToolTipText("Editar Fornecedor");
		btnUpdate.setBounds(119, 534, 89, 62);
		contentPanel.add(btnUpdate);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirClientes();
			}
		});
		btnDelete.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete.png")));
		btnDelete.setToolTipText("Excluir Fornecedor");
		btnDelete.setBounds(223, 534, 89, 62);
		contentPanel.add(btnDelete);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparClientes();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Clientes.class.getResource("/img/limpar48x48.png")));
		btnLimpar.setToolTipText("Limpar Campos");
		btnLimpar.setBounds(335, 534, 89, 62);
		contentPanel.add(btnLimpar);
		limparClientes();

		RestrictedTextField IDfor = new RestrictedTextField(txtIDfor);
		IDfor.setOnlyNums(true);
		IDfor.setLimit(10);
		
		RestrictedTextField CEP = new RestrictedTextField(txtCep);
		CEP.setOnlyNums(true);
		CEP.setLimit(10);

		RestrictedTextField Endereço = new RestrictedTextField(txtEndereco);
		Endereço.setOnlyNums(false);
		Endereço.setLimit(50);

		RestrictedTextField Numero = new RestrictedTextField(txtNumero);
		Numero.setOnlyNums(false);
		Numero.setLimit(6);

		RestrictedTextField Complemento = new RestrictedTextField(txtComplemento);
		Complemento.setOnlyNums(false);
		Complemento.setLimit(20);

		RestrictedTextField Bairro = new RestrictedTextField(txtBairro);
		Bairro.setOnlyNums(false);
		Bairro.setLimit(50);

		RestrictedTextField Cidade = new RestrictedTextField(txtCidade);
		Cidade.setOnlyNums(false);
		Cidade.setLimit(50);

		RestrictedTextField nomeContato = new RestrictedTextField(txtContato);
		nomeContato.setOnlyNums(false);
		nomeContato.setLimit(30);

		RestrictedTextField Telefone = new RestrictedTextField(txtTelefone);
		Telefone.setOnlyNums(true);
		Telefone.setLimit(15);
		
		RestrictedTextField Whatsapp = new RestrictedTextField(txtWhatsapp);
		Whatsapp.setOnlyNums(true);
		Whatsapp.setLimit(15);
		
		RestrictedTextField Email = new RestrictedTextField(txtEmail);
		Email.setOnlyNums(false);
		Email.setLimit(50);
		
		RestrictedTextField Obs = new RestrictedTextField(txtObs);
		Obs.setOnlyNums(false);
		Obs.setLimit(250);
	}

	void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {

					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}

			txtEndereco.setText(tipoLogradouro + "" + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	void pesquisar() {

		if (txtIDfor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o ID");
			txtIDfor.requestFocus();

		} else {
			String read = "select * from clientes where idFor = ?";

			try {
				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtIDfor.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					txtCep.setText(rs.getString(2));
					txtEndereco.setText(rs.getString(3));
					txtNumero.setText(rs.getString(4));
					txtComplemento.setText(rs.getString(5));
					txtBairro.setText(rs.getString(6));
					txtCidade.setText(rs.getString(7));
					cboUf.setSelectedItem(rs.getString(8));
					txtContato.setText(rs.getString(9));
					txtTelefone.setText(rs.getString(10));
					txtWhatsapp.setText(rs.getString(11));
					txtEmail.setText(rs.getString(12));
					txtObs.setText(rs.getString(13));

				} else {
					JOptionPane.showMessageDialog(null, "Cliente inexistente");
					limparClientes();
				}
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}// Fim Pesquisar Fornecedor

	void pesquisarClientes() {

		String read = "select idfor as ID, nomeContato as Contato, fone as Telefone, whatsapp as Whatsapp from clientes where nomeContato like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtClientes.getText() + "%");
			ResultSet rs = pst.executeQuery();
			table2.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	DAO dao = new DAO();
	JButton btnCreate;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnLimpar;
	private JScrollPane scrollPane;
	private JTable table2;

	void limparClientes() {
		txtIDfor.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		txtContato.setText(null);
		txtTelefone.setText(null);
		txtWhatsapp.setText(null);
		txtEmail.setText(null);
		txtObs.setText(null);
		txtClientes.setText(null);
		txtClientes.requestFocus();
		cboUf.setSelectedItem(null);
		((DefaultTableModel) table2.getModel()).setRowCount(0);
		
	}

	void atualizarClientes() {
		if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do Contato");
			txtContato.requestFocus();

		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Telefone");
			txtTelefone.requestFocus();

		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o E-mail");
			txtEmail.requestFocus();

		} else {
			String update = "update clientes set cep = ?, endereço = ?, numero = ? , complemento = ?, bairro = ?, cidade = ?, uf = ?, nomeContato = ?, fone = ?, whatsapp = ?, email = ?, obs = ? where idFor = ?";

			try {
				// Abrir a conexão
				Connection con = dao.conectar();
				// Preparar a query (instrução SQL)
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtCep.getText());
				pst.setString(2, txtEndereco.getText());
				pst.setString(3, txtNumero.getText());
				pst.setString(4, txtComplemento.getText());
				pst.setString(5, txtBairro.getText());
				pst.setString(6, txtCidade.getText());
				pst.setString(7, cboUf.getSelectedItem().toString());
				pst.setString(8, txtContato.getText());
				pst.setString(9, txtTelefone.getText());
				pst.setString(10, txtWhatsapp.getText());
				pst.setString(11, txtEmail.getText());
				pst.setString(12, txtObs.getText());
				pst.setString(13, txtIDfor.getText());

				// Executar a query e confirmar as alterações no banco
				int executa = pst.executeUpdate();
				// System.out.println(executa);
				if (executa == 1) {
					JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso!");
					limparClientes();
					txtClientes.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Erro: Cliente não atualizado!");
				}
				// Encerrar a conexão
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Cliente não adicionado - Cliente ja cadastrado");
				txtContato.setText(null);
				txtContato.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	void excluirClientes() {
		// System.out.println("teste do botão excluir");
		// validação (confirmação)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste Cliente ?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from clientes where idFor = ?";
			try {
				// abrir a conexão
				Connection con = dao.conectar();
				// preparar a query
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtIDfor.getText());
				// executar o comando sql e confirmar a exclusão
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limparClientes();
					JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");

				}
				// encerrar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	void cadastrarClientes() {
		if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");
			txtContato.requestFocus();

		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Telefone");
			txtTelefone.requestFocus();

		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Email");
			txtEmail.requestFocus();

		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP");
			txtCep.requestFocus();

		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço");
			txtEndereco.requestFocus();

		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Número");
			txtNumero.requestFocus();

		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bairro");
			txtBairro.requestFocus();

		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Cidade");
			txtCidade.requestFocus();

		} else {
			String create = "insert into clientes (cep,endereço,numero,complemento,bairro,cidade,uf,nomeContato,fone,whatsapp,email,obs) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtCep.getText());
				pst.setString(2, txtEndereco.getText());
				pst.setString(3, txtNumero.getText());
				pst.setString(4, txtComplemento.getText());
				pst.setString(5, txtBairro.getText());
				pst.setString(6, txtCidade.getText());
				pst.setString(7, cboUf.getSelectedItem().toString());
				pst.setString(8, txtContato.getText());
				pst.setString(9, txtTelefone.getText());
				pst.setString(10, txtWhatsapp.getText());
				pst.setString(11, txtEmail.getText());
				pst.setString(12, txtObs.getText());

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Cliente Adicionado");
					limparClientes();

				}
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Cliente Não Adicionado - Cliente ja cadastrado");
				limparClientes();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
