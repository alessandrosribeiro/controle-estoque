package views;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
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
	public Sobre() {
		setModal(true);
		getContentPane().setForeground(SystemColor.textHighlight);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("@Autor Alessandro da Silva");
		lblNewLabel_1.setBounds(10, 242, 219, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnYoutube = new JButton("");
		btnYoutube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://youtube.com");
			}
		});
		btnYoutube.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnYoutube.setToolTipText("Youtube");
		btnYoutube.setIcon(new ImageIcon(Sobre.class.getResource("/img/youtube.png")));
		btnYoutube.setBounds(13, 167, 64, 64);
		getContentPane().add(btnYoutube);
		
		JButton btnGitHub = new JButton("");
		btnGitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/alessandrosribeiro");
			}
		});
		btnGitHub.setIcon(new ImageIcon(Sobre.class.getResource("/img/git.png")));
		btnGitHub.setToolTipText("GitHub");
		btnGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGitHub.setBounds(87, 167, 64, 64);
		getContentPane().add(btnGitHub);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Sobre.class.getResource("/img/MIT.png")));
		lblNewLabel_3.setBounds(337, 180, 70, 70);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Copyright (c) <2022>");
		lblNewLabel_4.setBounds(308, 242, 143, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Ol\u00E1, Meu nome \u00E9 Alessandro!");
		lblNewLabel.setBounds(10, 11, 234, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Tenho 22 anos, Estou cursando o t\u00E9cnico em inform\u00E1tica no");
		lblNewLabel_5.setBounds(10, 58, 403, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Senac Tatuap\u00E9, a procura de estagios para me aprimorar.");
		lblNewLabel_6.setBounds(10, 83, 403, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Logo abaixo est\u00E3o minhas redes socias para contato.");
		lblNewLabel_7.setBounds(10, 108, 403, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Qualquer duvida, interesse estou a disposi\u00E7\u00E3o :)");
		lblNewLabel_8.setBounds(10, 133, 403, 14);
		getContentPane().add(lblNewLabel_8);

	}//fim do construtor
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
