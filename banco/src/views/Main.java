package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.Font;
import java.awt.Color;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel lblStatus;
	JPanel panelUsuarios;
	JLabel lblUsuario;
	JLabel lblUsuario_1;
	JButton btnRelatórios;
	JButton bntUsuarios;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblStatus.setText(formatador.format(data));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/imgpainel.png")));
		setTitle("Painel de Controle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bntUsuarios = new JButton("");
		bntUsuarios.setEnabled(false);
		bntUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntUsuarios.setToolTipText("Usu\u00E1rios");
		bntUsuarios.setIcon(new ImageIcon(Main.class.getResource("/img/imgusuario.png")));
		bntUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		bntUsuarios.setBounds(95, 23, 64, 64);
		contentPane.add(bntUsuarios);
		
		JButton btnFornecedor = new JButton("");
		btnFornecedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedor.setToolTipText("Fornecedor");
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setVisible(true);			}
		});
		btnFornecedor.setIcon(new ImageIcon(Main.class.getResource("/img/imgfornecedor.png")));
		btnFornecedor.setBounds(21, 23, 64, 64);
		contentPane.add(btnFornecedor);
		
		JButton btnProdutos = new JButton("");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/imgproduto.png")));
		btnProdutos.setBounds(169, 23, 64, 64);
		contentPane.add(btnProdutos);
		
		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Main.class.getResource("/img/imgclient.png")));
		btnClientes.setBounds(243, 23, 64, 64);
		contentPane.add(btnClientes);
		
		btnRelatórios = new JButton("");
		btnRelatórios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnRelatórios.setEnabled(false);
		btnRelatórios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatórios.setToolTipText("Relat\u00F3rios");
		btnRelatórios.setIcon(new ImageIcon(Main.class.getResource("/img/imgrelatorio.png")));
		btnRelatórios.setBounds(317, 23, 64, 64);
		contentPane.add(btnRelatórios);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/imgsobre.png")));
		btnSobre.setBounds(317, 199, 64, 64);
		contentPane.add(btnSobre);
		
		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(SystemColor.textHighlight);
		panelUsuarios.setBounds(0, 274, 403, 56);
		contentPane.add(panelUsuarios);
		panelUsuarios.setLayout(null);
		
		lblStatus = new JLabel("New label");
		lblStatus.setForeground(SystemColor.window);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblStatus.setBounds(203, 0, 200, 56);
		panelUsuarios.add(lblStatus);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 20, 78, 14);
		panelUsuarios.add(lblNewLabel);
		
		lblUsuario_1 = new JLabel("");
		lblUsuario_1.setForeground(Color.WHITE);
		lblUsuario_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario_1.setBounds(66, 21, 127, 14);
		panelUsuarios.add(lblUsuario_1);
	}//fim do construtor
}//fim do código
