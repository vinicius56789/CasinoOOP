package maquina;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFJogos extends JFrame {

	private JPanel contentPane;
	private String nome;
	private Double cash;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFJogos frame = new JFJogos(null, null);
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
	public JFJogos(String nome, Double cash) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		icone();
		this.setNome(nome);
		this.setCash(cash);
		
		DecimalFormat decimal = new DecimalFormat("0.00");
		
		JLabel bem_vindo = new JLabel("Bem vindo,");
		bem_vindo.setFont(new Font("Impact", Font.PLAIN, 18));
		
		JLabel usuario = new JLabel(this.getNome());
		usuario.setFont(new Font("Impact", Font.PLAIN, 18));
		
		JLabel saldo = new JLabel("Saldo:");
		saldo.setFont(new Font("Impact", Font.PLAIN, 18));
		
		JLabel cash_1 = new JLabel(String.valueOf(decimal.format(this.getCash())));
		cash_1.setFont(new Font("Impact", Font.PLAIN, 18));
		
		JLabel txtJogar = new JLabel("O que quer jogar?");
		txtJogar.setFont(new Font("Impact", Font.PLAIN, 30));
		
		JButton jokenpoo = new JButton("Pedra, Papel ou Tesoura");
		jokenpoo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jokenpoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jokenpoo painel = new Jokenpoo(getNome(), getCash());
				painel.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton imparPar = new JButton("Impar ou Par");
		imparPar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imparPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImparPar painel = new ImparPar(getNome(), getCash());
				painel.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton roleta = new JButton("Roleta");
		roleta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		roleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roleta painel = new Roleta(getNome(), getCash());
				painel.setVisible(true);
				setVisible(false);
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap(44, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(bem_vindo)
									.addGap(6)
									.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
									.addGap(166)
									.addComponent(saldo)
									.addGap(87)
									.addComponent(cash_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtJogar, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
									.addGap(176))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addComponent(imparPar, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
							.addComponent(roleta, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(jokenpoo, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(10)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bem_vindo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(saldo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(cash_1)))
					.addGap(52)
					.addComponent(txtJogar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(jokenpoo, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(imparPar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(roleta, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(132))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}
	
	public void icone(){
		this.setIconImage(new ImageIcon(getClass().getResource("../imagens/download.png")).getImage());
	}
}
