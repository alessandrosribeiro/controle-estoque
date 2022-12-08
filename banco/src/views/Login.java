package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.DAO;
import views.Login;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;
	private JLabel lblNewLabel;
	private JTextField txtLogin;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setBounds(132, 159, 89, 23);
		contentPane.add(btnAcessar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(10, 185, 48, 48);
		contentPane.add(lblStatus);

		lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(62, 73, 46, 14);
		contentPane.add(lblNewLabel);

		txtLogin = new JTextField();
		txtLogin.setBounds(113, 70, 128, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(62, 116, 46, 14);
		contentPane.add(lblNewLabel_1);

		// uso da tecla enteder
		getRootPane().setDefaultButton(btnAcessar);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(113, 113, 127, 20);
		contentPane.add(txtSenha);
	}// fim do construtor

	DAO dao = new DAO();
	private JPasswordField txtSenha;

	private void status() {
		// System.out.println("teste - Janela Ativada");
		// uso da classe Connection (JDBC) para estabelecer a conexão
		try {
			Connection con = dao.conectar();
			if (con == null) {
				// System.out.println("Erro de conexão");
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
			} else {
				// System.out.println("Banco conectado!");
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
			}
			// Nunca esquecer de encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void logar() {
		// validação da senha (captura segura)
		String capturaSenha = new String(txtSenha.getPassword());

		// validação de campos obrigatórios
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu Login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Digite a sua Senha");
			txtSenha.requestFocus();

		} else {
			// Logica Principal (Pesquisar Login e Senha Correspondente
			String read = "select * from usuario where login= ? and senha= md5(?)";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				// Executar a query e executar o login se existir o login e senha correspondente
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					Main main = new Main();
					
					String perfil = rs.getString(5);
					if (perfil.equals("admin")) {
						main.setVisible(true);
						main.lblUsuario_1.setText(rs.getString(2));
						main.btnRelatórios.setEnabled(true);
						main.bntUsuarios.setEnabled(true);
						main.panelUsuarios.setBackground(Color.black);
						this.dispose();
					
			} else {
				main.setVisible(true);
				main.lblUsuario_1.setText(rs.getString(2));
				this.dispose();
			}
			} else {
				JOptionPane.showMessageDialog(null, "Login e/ou senha Incorreta");
			
			}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

			

		}
	}
}// fim do código
