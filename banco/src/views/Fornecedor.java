package views;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;

public class Fornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFornecedor;
	private JTextField txtIDfor;
	private JTextField txtFantasia;
	private JTextField txtRazao;
	private JTextField txtCNPJ;
	private JTextField txtIe;
	private JTextField txtContato;
	private JTextField txtTelefone;
	private JTextField txtWhatsapp;
	private JTextField txtEmail;
	private JTextField txtSite;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtObs;
	private JLabel lblNewLabel_5;
	@SuppressWarnings("rawtypes")
	JComboBox cboUf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedor frame = new Fornecedor();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Fornecedor() {
		setTitle("FORNECEDOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(10, 11, 71, 14);
		contentPane.add(lblNewLabel);

		txtFornecedor = new JTextField();
		txtFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarFornecedor();
			}
		});
		txtFornecedor.setToolTipText("Fornecedor");
		txtFornecedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtFornecedor.setBounds(79, 8, 157, 20);
		contentPane.add(txtFornecedor);
		txtFornecedor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 181, 33, 14);
		contentPane.add(lblNewLabel_1);

		txtIDfor = new JTextField();
		txtIDfor.setToolTipText("ID");
		txtIDfor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtIDfor.setBounds(42, 178, 86, 20);
		contentPane.add(txtIDfor);
		txtIDfor.setColumns(10);

		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(147, 177, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_2.setBounds(10, 228, 86, 14);
		contentPane.add(lblNewLabel_2);

		txtFantasia = new JTextField();
		txtFantasia.setToolTipText("Nome Fantasia");
		txtFantasia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtFantasia.setBounds(455, 225, 263, 20);
		contentPane.add(txtFantasia);
		txtFantasia.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nome Fantasia");
		lblNewLabel_3.setBounds(363, 228, 86, 14);
		contentPane.add(lblNewLabel_3);

		txtRazao = new JTextField();
		txtRazao.setToolTipText("Raz\u00E3o Social");
		txtRazao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtRazao.setBounds(90, 225, 250, 20);
		contentPane.add(txtRazao);
		txtRazao.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CNPJ");
		lblNewLabel_4.setBounds(254, 181, 46, 14);
		contentPane.add(lblNewLabel_4);

		txtCNPJ = new JTextField();
		txtCNPJ.setToolTipText("CNPJ");
		txtCNPJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtCNPJ.setBounds(288, 178, 186, 20);
		contentPane.add(txtCNPJ);
		txtCNPJ.setColumns(10);

		JLabel txtInscricao = new JLabel("I.E");
		txtInscricao.setBounds(512, 181, 46, 14);
		contentPane.add(txtInscricao);

		txtIe = new JTextField();
		txtIe.setToolTipText("Inscri\u00E7\u00E3o Estadual");
		txtIe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtIe.setColumns(10);
		txtIe.setBounds(532, 178, 186, 20);
		contentPane.add(txtIe);

		JLabel lblNewLabel_6 = new JLabel("Contato");
		lblNewLabel_6.setBounds(10, 262, 46, 14);
		contentPane.add(lblNewLabel_6);

		txtContato = new JTextField();
		txtContato.setToolTipText("Contato");
		txtContato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtContato.setBounds(90, 259, 147, 20);
		contentPane.add(txtContato);
		txtContato.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Telefone");
		lblNewLabel_7.setBounds(277, 262, 53, 14);
		contentPane.add(lblNewLabel_7);

		txtTelefone = new JTextField();
		txtTelefone.setToolTipText("Telefone");
		txtTelefone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtTelefone.setBounds(339, 259, 147, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Whastapp");
		lblNewLabel_8.setBounds(499, 262, 59, 14);
		contentPane.add(lblNewLabel_8);

		txtWhatsapp = new JTextField();
		txtWhatsapp.setToolTipText("Whatsapp");
		txtWhatsapp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtWhatsapp.setColumns(10);
		txtWhatsapp.setBounds(571, 259, 147, 20);
		contentPane.add(txtWhatsapp);

		JLabel lblNewLabel_9 = new JLabel("E-mail");
		lblNewLabel_9.setBounds(10, 300, 46, 14);
		contentPane.add(lblNewLabel_9);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("E-mail");
		txtEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtEmail.setBounds(90, 297, 250, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Site");
		lblNewLabel_10.setBounds(363, 300, 46, 14);
		contentPane.add(lblNewLabel_10);

		txtSite = new JTextField();
		txtSite.setToolTipText("Site");
		txtSite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtSite.setBounds(399, 297, 319, 20);
		contentPane.add(txtSite);
		txtSite.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("CEP");
		lblNewLabel_11.setBounds(10, 354, 46, 14);
		contentPane.add(lblNewLabel_11);

		txtCep = new JTextField();
		txtCep.setToolTipText("CEP");
		txtCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtCep.setColumns(10);
		txtCep.setBounds(42, 351, 86, 20);
		contentPane.add(txtCep);

		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				} else {
					buscarCep();
				}
			}

		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(147, 350, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_12 = new JLabel("Endere\u00E7o");
		lblNewLabel_12.setBounds(10, 399, 71, 14);
		contentPane.add(lblNewLabel_12);

		txtEndereco = new JTextField();
		txtEndereco.setToolTipText("Endere\u00E7o");
		txtEndereco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtEndereco.setBounds(90, 396, 210, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("N\u00BA");
		lblNewLabel_13.setBounds(318, 399, 33, 14);
		contentPane.add(lblNewLabel_13);

		txtNumero = new JTextField();
		txtNumero.setToolTipText("N\u00FAmero");
		txtNumero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtNumero.setBounds(338, 396, 79, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Complemento");
		lblNewLabel_14.setBounds(434, 399, 79, 14);
		contentPane.add(lblNewLabel_14);

		txtComplemento = new JTextField();
		txtComplemento.setToolTipText("Complemento");
		txtComplemento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtComplemento.setBounds(519, 396, 199, 20);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(10, 440, 46, 14);
		contentPane.add(lblNewLabel_15);

		txtBairro = new JTextField();
		txtBairro.setToolTipText("Bairro");
		txtBairro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtBairro.setBounds(89, 437, 211, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(318, 440, 46, 14);
		contentPane.add(lblNewLabel_16);

		txtCidade = new JTextField();
		txtCidade.setToolTipText("Cidade");
		txtCidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtCidade.setBounds(363, 437, 175, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		lblNewLabel_5 = new JLabel("UF");
		lblNewLabel_5.setBounds(571, 440, 46, 14);
		contentPane.add(lblNewLabel_5);

		cboUf = new JComboBox();
		cboUf.setToolTipText("Estados");
		cboUf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(598, 436, 46, 22);
		contentPane.add(cboUf);

		JLabel lblNewLabel_18 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_18.setBounds(10, 531, 86, 14);
		contentPane.add(lblNewLabel_18);

		txtObs = new JTextField();
		txtObs.setToolTipText("Observa\u00E7\u00E3o");
		txtObs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtObs.setBounds(90, 483, 384, 108);
		contentPane.add(txtObs);
		txtObs.setColumns(10);

		btnCreate = new JButton("");
		btnCreate.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/create.png")));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFornecedor();
			}
		});
		btnCreate.setToolTipText("Adicionar Fornecedor");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setBounds(484, 483, 89, 62);
		contentPane.add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/update.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarFornecedor();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setToolTipText("Editar Fornecedor");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBounds(598, 483, 89, 62);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/delete.png")));
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnDelete.setToolTipText("Excluir Fornecedor");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBounds(484, 554, 89, 62);
		contentPane.add(btnDelete);

		btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFornecedores();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/limpar48x48.png")));
		btnLimpar.setEnabled(false);
		btnLimpar.setToolTipText("Limpar Campos");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setBounds(598, 554, 89, 62);
		contentPane.add(btnLimpar);

		RestrictedTextField validar = new RestrictedTextField(txtCep);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 708, 102);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		validar.setOnlyNums(true);
		validar.setLimit(8);

		RestrictedTextField razaoSocial = new RestrictedTextField(txtRazao);
		razaoSocial.setOnlyNums(false);
		razaoSocial.setLimit(50);

		RestrictedTextField fantasia = new RestrictedTextField(txtFantasia);
		fantasia.setOnlyNums(false);
		fantasia.setLimit(50);

		RestrictedTextField CNPJ = new RestrictedTextField(txtCNPJ);
		CNPJ.setOnlyNums(true);
		CNPJ.setLimit(20);

		RestrictedTextField Ie = new RestrictedTextField(txtIe);
		Ie.setOnlyNums(false);
		Ie.setLimit(20);

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

		RestrictedTextField Contato = new RestrictedTextField(txtContato);
		Contato.setOnlyNums(false);
		Contato.setLimit(30);

		RestrictedTextField Telefone = new RestrictedTextField(txtTelefone);
		Telefone.setOnlyNums(true);
		Telefone.setLimit(15);

		RestrictedTextField Whatsapp = new RestrictedTextField(txtWhatsapp);
		Whatsapp.setOnlyNums(true);
		Whatsapp.setLimit(15);

		RestrictedTextField Email = new RestrictedTextField(txtEmail);
		Email.setOnlyNums(false);
		Email.setLimit(50);

		RestrictedTextField Site = new RestrictedTextField(txtSite);
		Site.setOnlyNums(false);
		Site.setLimit(50);

		RestrictedTextField Obs = new RestrictedTextField(txtObs);
		Obs.setOnlyNums(false);
		Obs.setLimit(250);
	}// fim do construtor

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

	DAO dao = new DAO();
	JButton btnCreate;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnLimpar;

	void pesquisarFornecedor() {

		String read = "select idfor as ID, fantasia as Fornecedor, fone, nomecontato from fornecedores where Fantasia like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtFornecedor.getText() + "%");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void pesquisar() {

		if (txtIDfor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o ID");
			txtIDfor.requestFocus();

		} else {
			String read = "select * from fornecedores where idFor = ?";

			try {
				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtIDfor.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					// txtId.setText(rs.getString(1));

					txtRazao.setText(rs.getString(2));
					txtFantasia.setText(rs.getString(3));
					txtCNPJ.setText(rs.getString(4));
					txtIe.setText(rs.getString(5));
					txtCep.setText(rs.getString(6));
					txtEndereco.setText(rs.getString(7));
					txtNumero.setText(rs.getString(8));
					txtComplemento.setText(rs.getString(9));
					txtBairro.setText(rs.getString(10));
					txtCidade.setText(rs.getString(11));
					cboUf.setSelectedItem(rs.getString(12));
					txtContato.setText(rs.getString(13));
					txtTelefone.setText(rs.getString(14));
					txtWhatsapp.setText(rs.getString(15));
					txtEmail.setText(rs.getString(16));
					txtSite.setText(rs.getString(17));
					txtObs.setText(rs.getString(18));

					//// habilitar botões atualizar e deletar
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnCreate.setEnabled(false);
					btnLimpar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor inexistente");
					// Setar campos e botões (UX)
					btnCreate.setEnabled(true);
					btnLimpar.setEnabled(true);
					limparFornecedores();
				}
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}// Fim Pesquisar Fornecedor

	void cadastrarFornecedor() {
		if (txtCNPJ.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
			txtCNPJ.requestFocus();

		} else if (txtRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Razão Social");
			txtRazao.requestFocus();

		} else if (txtFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome Fantasia");
			txtFantasia.requestFocus();

		} else if (txtIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Inscrição Estadual");
			txtIe.requestFocus();

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

		} else if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do Contato");
			txtContato.requestFocus();

		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Telefone");
			txtTelefone.requestFocus();

		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Email");
			txtEmail.requestFocus();

		} else {
			String create = "insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep,endereco,numero,complemento,bairro,cidade,uf,nomeContato,fone,whatsapp,email,site,obs) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtRazao.getText());
				pst.setString(2, txtFantasia.getText());
				pst.setString(3, txtCNPJ.getText());
				pst.setString(4, txtIe.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtComplemento.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtCidade.getText());
				pst.setString(11, cboUf.getSelectedItem().toString());
				pst.setString(12, txtContato.getText());
				pst.setString(13, txtTelefone.getText());
				pst.setString(14, txtWhatsapp.getText());
				pst.setString(15, txtEmail.getText());
				pst.setString(16, txtSite.getText());
				pst.setString(17, txtObs.getText());

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor Adicionado");
					limparFornecedores();

				}
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Fornecedor Não Adicionado - Fornecedor ja cadastrado");
				limparFornecedores();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	void excluirContato() {
		// System.out.println("teste do botão excluir");
		// validação (confirmação)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste Fornecedor ?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from fornecedores where idFor = ?";
			try {
				// abrir a conexão
				Connection con = dao.conectar();
				// preparar a query
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtIDfor.getText());
				// executar o comando sql e confirmar a exclusão
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limparFornecedores();
					JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso");
					
				}
				// encerrar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}// Fim cadastrar fornecedores

	void atualizarFornecedor() {
		if (txtRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Razão Social");
			txtRazao.requestFocus();
		} else if (txtFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome Fantasia");
			txtFantasia.requestFocus();

		} else {
			String update = "update fornecedores set razaoSocial = ?, fantasia = ?, cnpj = ? , ie = ?, cep = ?,endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, nomeContato = ?, fone = ?, whatsapp = ?, email = ?, site = ?, obs = ? where idFor = ?";

			try {
				// Abrir a conexão
				Connection con = dao.conectar();
				// Preparar a query (instrução SQL)
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtRazao.getText());
				pst.setString(2, txtFantasia.getText());
				pst.setString(3, txtCNPJ.getText());
				pst.setString(4, txtCep.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtComplemento.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtCidade.getText());
				pst.setString(11, cboUf.getSelectedItem().toString());
				pst.setString(12, txtContato.getText());
				pst.setString(13, txtTelefone.getText());
				pst.setString(14, txtWhatsapp.getText());
				pst.setString(15, txtEmail.getText());
				pst.setString(16, txtSite.getText());
				pst.setString(17, txtObs.getText());
				pst.setString(18, txtIDfor.getText());

				// Executar a query e confirmar as alterações no banco
				int executa = pst.executeUpdate();
				// System.out.println(executa);
				if (executa == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor Atualizado com Sucesso!");
					limparFornecedores();
					txtFornecedor.setText(null);
					btnCreate.setEnabled(true);
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "Erro: Fornecedor não atualizado!");
					btnCreate.setEnabled(true);
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);
				}
				// Encerrar a conexão
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Fornecedor não adicionado - Fornecedor ja cadastrado");
				txtCNPJ.setText(null);
				txtCNPJ.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	void limparFornecedores() {
		txtIDfor.setText(null);
		txtRazao.setText(null);
		txtFantasia.setText(null);
		txtCNPJ.setText(null);
		txtIe.setText(null);
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
		txtSite.setText(null);
		txtObs.setText(null);
		txtIDfor.requestFocus();
		cboUf.setSelectedItem(null);
	}

}


