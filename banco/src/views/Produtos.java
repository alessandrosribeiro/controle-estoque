package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Produtos extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBarcode;
	private JTextField txtCodigo;
	private JTextField txtFornecedor;
	private JTable table;
	private JTextField txtId;
	private JTextField txtProduto;
	private JTextField txtCusto;
	private JTextField txtLucro;
	private JTextField txtFabricante;
	private JTextField txtEstoque;
	private JTextField txtEstoquemin;
	private JTextField txtLocal;
	private JTextArea txtaDescricao;
	@SuppressWarnings("rawtypes")
	private JComboBox cboUnidade;
	private JDateChooser dateEntrada;
	private JDateChooser dateValidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos dialog = new Produtos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Produtos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}

		});
		setTitle("Produtos");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 800, 502);
		getContentPane().setLayout(null);

		dateEntrada = new JDateChooser();
		dateEntrada.setEnabled(false);
		dateEntrada.setBounds(379, 226, 147, 20);
		getContentPane().add(dateEntrada);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Produtos.class.getResource("/img/barcode.png")));
		lblNewLabel.setBounds(22, 31, 64, 45);
		getContentPane().add(lblNewLabel);

		txtBarcode = new JTextField();
		txtBarcode.addKeyListener(new KeyAdapter() {
			// leitor de código de barras
			// evento ao pressionar uma tecla específica (ENTER)
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pesquisarProdutoBarcode();
				}
			}
		});
		txtBarcode.setBounds(96, 43, 216, 20);
		getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(39, 97, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(96, 94, 103, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(Produtos.class.getResource("/img/search.png")));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProduto();
			}
		});
		btnPesquisar.setBounds(209, 85, 38, 37);
		getContentPane().add(btnPesquisar);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(348, 31, 395, 151);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtFornecedor = new JTextField();
		txtFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarFornecedor();
			}
		});
		txtFornecedor.setBounds(25, 23, 152, 20);
		panel.add(txtFornecedor);
		txtFornecedor.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Produtos.class.getResource("/img/search.png")));
		lblNewLabel_2.setBounds(187, 20, 24, 24);
		panel.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 54, 349, 74);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] { { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, },
				new String[] { "id", "Fornecedor" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(270, 26, 24, 14);
		panel.add(lblNewLabel_3);

		txtId = new JTextField();
		txtId.setBounds(288, 23, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Produto");
		lblNewLabel_4.setBounds(39, 146, 46, 14);
		getContentPane().add(lblNewLabel_4);

		txtProduto = new JTextField();
		txtProduto.setBounds(96, 143, 216, 20);
		getContentPane().add(txtProduto);
		txtProduto.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_5.setBounds(22, 200, 58, 14);
		getContentPane().add(lblNewLabel_5);

		txtaDescricao = new JTextArea();
		txtaDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtaDescricao.setBounds(96, 195, 229, 74);
		getContentPane().add(txtaDescricao);

		JLabel lblNewLabel_6 = new JLabel("Entrada");
		lblNewLabel_6.setBounds(379, 201, 58, 14);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Validade");
		lblNewLabel_7.setBounds(576, 200, 64, 14);
		getContentPane().add(lblNewLabel_7);

		dateValidade = new JDateChooser();
		dateValidade.setBounds(577, 226, 147, 20);
		getContentPane().add(dateValidade);

		JLabel lblNewLabel_8 = new JLabel("Custo");
		lblNewLabel_8.setBounds(379, 291, 38, 14);
		getContentPane().add(lblNewLabel_8);

		txtCusto = new JTextField();
		txtCusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCusto.setBounds(418, 288, 121, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Lucro");
		lblNewLabel_9.setBounds(583, 291, 38, 14);
		getContentPane().add(lblNewLabel_9);

		txtLucro = new JTextField();
		txtLucro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtLucro.setBounds(619, 288, 77, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("%");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(697, 290, 46, 14);
		getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Fabricante");
		lblNewLabel_11.setBounds(22, 310, 64, 14);
		getContentPane().add(lblNewLabel_11);

		txtFabricante = new JTextField();
		txtFabricante.setBounds(96, 307, 229, 20);
		getContentPane().add(txtFabricante);
		txtFabricante.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Estoque");
		lblNewLabel_12.setBounds(40, 362, 46, 14);
		getContentPane().add(lblNewLabel_12);

		txtEstoque = new JTextField();
		txtEstoque.setBounds(96, 359, 51, 20);
		getContentPane().add(txtEstoque);
		txtEstoque.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Estoque m\u00EDnimo");
		lblNewLabel_13.setBounds(180, 362, 96, 14);
		getContentPane().add(lblNewLabel_13);

		txtEstoquemin = new JTextField();
		txtEstoquemin.setColumns(10);
		txtEstoquemin.setBounds(274, 359, 51, 20);
		getContentPane().add(txtEstoquemin);

		JLabel lblNewLabel_14 = new JLabel("Unidade");
		lblNewLabel_14.setBounds(39, 416, 58, 14);
		getContentPane().add(lblNewLabel_14);

		cboUnidade = new JComboBox();
		cboUnidade.setModel(new DefaultComboBoxModel(new String[] {"UN", "PC", "CX", "KG", "g", "M", "CM"}));
		cboUnidade.setBounds(96, 412, 51, 22);
		getContentPane().add(cboUnidade);

		JLabel lblNewLabel_15 = new JLabel("Local");
		lblNewLabel_15.setBounds(171, 416, 38, 14);
		getContentPane().add(lblNewLabel_15);

		txtLocal = new JTextField();
		txtLocal.setBounds(209, 413, 116, 20);
		getContentPane().add(txtLocal);
		txtLocal.setColumns(10);

		btnAdicionar = new JButton("");
		btnAdicionar.setIcon(new ImageIcon(Produtos.class.getResource("/img/create.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirProduto();
			}
		});
		btnAdicionar.setBounds(361, 362, 89, 68);
		getContentPane().add(btnAdicionar);

		btnAlterar = new JButton("");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarProduto();
			}
		});
		btnAlterar.setIcon(new ImageIcon(Produtos.class.getResource("/img/update.png")));
		btnAlterar.setBounds(460, 362, 89, 68);
		getContentPane().add(btnAlterar);

		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirProduto();
			}
		});
		btnExcluir.setIcon(new ImageIcon(Produtos.class.getResource("/img/delete.png")));
		btnExcluir.setBounds(559, 362, 89, 68);
		getContentPane().add(btnExcluir);

		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Produtos.class.getResource("/img/limpar48x48.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparProduto();
			}
		});
		btnLimpar.setBounds(658, 362, 89, 68);
		getContentPane().add(btnLimpar);

		RestrictedTextField barcode = new RestrictedTextField(txtBarcode);
		barcode.setOnlyNums(true);
		barcode.setLimit(255);

		RestrictedTextField produto = new RestrictedTextField(txtProduto);
		produto.setOnlyNums(false);
		produto.setLimit(50);

		RestrictedTextField fabricante = new RestrictedTextField(txtFabricante);
		fabricante.setOnlyNums(false);
		fabricante.setLimit(50);

		RestrictedTextField localizacao = new RestrictedTextField(txtLocal);
		localizacao.setOnlyNums(false);
		localizacao.setLimit(50);

		RestrictedTextField custo = new RestrictedTextField(txtCusto);
		custo.setLimit(10);

		RestrictedTextField lucro = new RestrictedTextField(txtLucro);
		lucro.setLimit(10);

		RestrictedTextField id = new RestrictedTextField(txtId);
		id.setOnlyNums(true);
		id.setLimit(10);
		
		RestrictedTextField estoque = new RestrictedTextField(txtEstoque);
		estoque.setOnlyNums(true);
		estoque.setLimit(5);
		
		RestrictedTextField estoquemin = new RestrictedTextField(txtEstoquemin);
		estoquemin.setOnlyNums(true);
		estoquemin.setLimit(5);

	}// fim do construtor

	DAO dao = new DAO();
	private JButton btnAlterar;
	private JButton btnAdicionar;
	private JButton btnExcluir;
	private JPanel panel;
	private JButton btnPesquisar;

	private void pesquisarFornecedor() {
		String read3 = "select idFor as ID, fantasia as Fornecedor from fornecedores where fantasia like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read3);
			pst.setString(1, txtFornecedor.getText() + "%"); // Atenção "%"
			ResultSet rs = pst.executeQuery();
			// Uso da biblioteca rs2xml para "popular" a tabela
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void pesquisarProduto() {
		// System.out.println("teste botão pesquisar produto");
		String read = "select * from produtos where codigo = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtCodigo.getText());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtBarcode.setText(rs.getString(2));
				txtProduto.setText(rs.getString(3));
				txtaDescricao.setText(rs.getString(4));
				txtFabricante.setText(rs.getString(5));
				txtEstoque.setText(rs.getString(8));
				txtEstoquemin.setText(rs.getString(9));
				cboUnidade.setSelectedItem(rs.getString(10));
				txtLocal.setText(rs.getString(11));
				txtId.setText(rs.getString(14));
				// formatação da data recebida pelo MySQL
				// JCalendar - formatação para exibição
				String setarData = rs.getString(6);
				// apoio a lógica
				// System.out.println(setarData);
				Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
				dateEntrada.setDate(dataFormatada);
				String setarData2 = rs.getString(7);
				Date dataFormatada2 = new SimpleDateFormat("yyyy-MM-dd").parse(setarData2);
				dateValidade.setDate(dataFormatada2);
				txtCusto.setText(rs.getString(12));
				txtLucro.setText(rs.getString(13));

				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnAdicionar.setEnabled(false);
				dateEntrada.setEnabled(false);
				txtId.setEnabled(false);

			} else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
				limparProduto();
				txtBarcode.requestFocus();
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void pesquisarProdutoBarcode() {
		// System.out.println("teste botão pesquisar produto");
		String read = "select * from produtos where barcode = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtBarcode.getText());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtCodigo.setText(rs.getString(1));
				txtProduto.setText(rs.getString(3));
				txtaDescricao.setText(rs.getString(4));
				txtFabricante.setText(rs.getString(5));
				txtEstoque.setText(rs.getString(8));
				txtEstoquemin.setText(rs.getString(9));
				cboUnidade.setSelectedItem(rs.getString(10));
				txtLocal.setText(rs.getString(11));
				txtId.setText(rs.getString(14));
				// formatação da data recebida pelo MySQL
				// JCalendar - formatação para exibição
				String setarData = rs.getString(6);
				// apoio a lógica
				// System.out.println(setarData);
				Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
				dateEntrada.setDate(dataFormatada);
				String setarData2 = rs.getString(7);
				Date dataFormatada2 = new SimpleDateFormat("yyyy-MM-dd").parse(setarData2);
				dateValidade.setDate(dataFormatada2);
				txtCusto.setText(rs.getString(12));
				txtLucro.setText(rs.getString(13));

				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnAdicionar.setEnabled(false);
				dateEntrada.setEnabled(false);
				dateValidade.setEnabled(false);
				txtId.setEnabled(false);
				txtCodigo.setEnabled(false);
				txtBarcode.setEnabled(false);
				btnPesquisar.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
				txtCodigo.setEnabled(false);
				txtCodigo.requestFocus();
				txtProduto.requestFocus();
				txtBarcode.setEnabled(false);
				btnPesquisar.setEnabled(false);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void inserirProduto() {
		// validação
		String insert = "insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,IdFor) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, txtBarcode.getText());
			pst.setString(2, txtProduto.getText());
			pst.setString(3, txtaDescricao.getText());
			pst.setString(4, txtFabricante.getText());
			// Formatar o valor do JCalendar para inserção correta no banco
			SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
			String dataFormatada = formatador.format(dateValidade.getDate());
			pst.setString(5, dataFormatada);
			pst.setString(6, txtEstoque.getText());
			pst.setString(7, txtEstoquemin.getText());
			pst.setString(8, cboUnidade.getSelectedItem().toString());
			pst.setString(9, txtLocal.getText());
			pst.setString(10, txtCusto.getText());
			pst.setString(11, txtLucro.getText());
			pst.setString(12, txtId.getText());
			int confirma = pst.executeUpdate();
			if (confirma == 1) {
				JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso");
				limparProduto();
			} else if (txtProduto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Produto");
				txtProduto.requestFocus();
			} else if (txtFabricante.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Fabricante");
				txtFabricante.requestFocus();
			} else if (txtEstoque.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a Quantidade em Estoque");
				txtEstoque.requestFocus();
			} else if (txtLucro.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Lucro" + "");
				txtLucro.requestFocus();
			} else if (txtEstoquemin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a Quantidade minima em Estoque");
				txtEstoquemin.requestFocus();
			} else if (dateValidade.getDate() == null) {
				JOptionPane.showMessageDialog(null, "Preencha a Quantidade minima em Estoque");
				txtEstoquemin.requestFocus();
			} else {
				JOptionPane.showMessageDialog(null, "Produto Já Cadastrado");
			}
			con.close();
		} catch (java.sql.SQLException e) {
			JOptionPane.showMessageDialog(null, "Preencha o Fornecedor");
			txtId.requestFocus(true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void excluirProduto() {
		// System.out.println("teste do botão excluir");
		// validação (confirmação)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste Produto ?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from produtos where idFor = ?";
			try {
				// abrir a conexão
				Connection con = dao.conectar();
				// preparar a query
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				// executar o comando sql e confirmar a exclusão
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limparProduto();
					JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
				}
				// encerrar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	void atualizarProduto() {

		if (txtBarcode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Barcode do Produto");
			txtBarcode.requestFocus();

		} else if (txtProduto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do Produto");
			txtProduto.requestFocus();

		} else if (txtFabricante.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Fabricante do Produto");
			txtFabricante.requestFocus();

		} else if (txtEstoque.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Quantidade em Estoque");
			txtEstoque.requestFocus();

		} else if (txtEstoquemin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Quantidade Minima em Estoque");
			txtEstoquemin.requestFocus();

		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o preço de Custo");
			txtCusto.requestFocus();

		} else if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecione o Fornecedor do Produto");
			txtId.requestFocus();

		} else if (dateEntrada.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Selecione a data de Entrada");

		} else if (dateValidade.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Selecione a data de Validade");

		} else {

			String update = "update produtos set produto = ?, descricao = ? , fabricante = ?, dataval = ?, estoque = ?, estoquemin = ?, unidade = ?, localizacao = ?, custo = ?, lucro = ? where idFor = ?";

			try {
				// Abrir a conexão
				Connection con = dao.conectar();
				// Preparar a query (instrução SQL)
				PreparedStatement pst = con.prepareStatement(update);
				// pst.setString(1, txtBarcode.getText());
				pst.setString(1, txtProduto.getText());
				pst.setString(2, txtaDescricao.getText());
				pst.setString(3, txtFabricante.getText());
				// Formatar o valor do JCalendar para inserção correta no banco
				SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
				String dataFormatada = formatador.format(dateValidade.getDate());
				pst.setString(4, dataFormatada);
				pst.setString(5, txtEstoque.getText());
				pst.setString(6, txtEstoquemin.getText());
				pst.setString(7, cboUnidade.getSelectedItem().toString());
				pst.setString(8, txtLocal.getText());
				pst.setString(9, txtCusto.getText());
				pst.setString(10, txtLucro.getText());
				pst.setString(11, txtId.getText());

				// Executar a query e confirmar as alterações no banco
				int executa = pst.executeUpdate();
				// System.out.println(executa);
				if (executa == 1) {
					JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
					limparProduto();
					txtCodigo.setText(null);
					txtId.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Erro: Preencha a unidade");
					txtId.requestFocus();
				}
				// Encerrar a conexão
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(null, "Produto não alterado - Produto ja cadastrado");
				txtBarcode.setText(null);
			} catch (java.lang.NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Selecione o tipo de Unidade");

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	void limparProduto() {
		txtCodigo.setText(null);
		txtBarcode.setText(null);
		txtProduto.setText(null);
		txtaDescricao.setText(null);
		txtFabricante.setText(null);
		txtEstoque.setText(null);
		txtEstoquemin.setText(null);
		txtLocal.setText(null);
		txtCusto.setText(null);
		txtLucro.setText(null);
		txtId.setText(null);
		cboUnidade.setSelectedItem(null);
		dateEntrada.setDate(null);
		dateValidade.setDate(null);
		txtFornecedor.setText(null);
		((DefaultTableModel) table.getModel()).setRowCount(0);
		txtBarcode.requestFocus();
		btnAdicionar.setEnabled(true);
		btnExcluir.setEnabled(false);
		btnPesquisar.setEnabled(true);
		btnAlterar.setEnabled(false);
		dateEntrada.setEnabled(false);
		dateValidade.setEnabled(true);
		txtBarcode.setEnabled(true);
		txtCodigo.setEnabled(true);
		txtId.setEnabled(true);
	}

	/**
	 * Metodo usado para setar os Campos de texto do Formularios das tabelas
	 */
	private void setarCampos() {
		int setar = table.getSelectedRow();
		txtId.setText(table.getModel().getValueAt(setar, 0).toString());
	}
}// fim do código
