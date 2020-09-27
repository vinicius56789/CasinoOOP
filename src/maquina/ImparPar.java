package maquina;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JRadioButton;

public class ImparPar extends JFrame {

	private JPanel contentPane;
	private String nome;
	private Double cash;
	private Double odd = 1.95;
	private String escolha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImparPar frame = new ImparPar(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param cash 
	 * @param nome 
	 */
	public ImparPar(String nome, Double cash) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		icone();
		this.setNome(nome);
		this.setCash(cash);
		JFormattedTextField apostado = new JFormattedTextField();
		
		JLabel lblNome = new JLabel(this.getNome());
		lblNome.setFont(new Font("Impact", Font.PLAIN, 18));
		
		DecimalFormat decimal = new DecimalFormat("0.00");
		String saldinho = decimal.format(this.getCash());
		JLabel lblSaldo = new JLabel("Saldo: " + saldinho);
		lblSaldo.setFont(new Font("Impact", Font.PLAIN, 18));
		
		JLabel apr_odd = new JLabel("Valor da ODD: " + String.valueOf(this.getOdd()));
		apr_odd.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel escolha_1 = new JLabel("Ímpar ou Par:");
		escolha_1.setFont(new Font("Impact", Font.PLAIN, 20));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ímpar");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Par");
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnNewRadioButton);
		grupo.add(rdbtnNewRadioButton_1);
		
		JLabel betar = new JLabel("Valor da aposta:");
		betar.setFont(new Font("Impact", Font.PLAIN, 20));
		
		JButton jogar = new JButton("Jogar");
		jogar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					setEscolha("ímpar");
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					setEscolha("par");
				}
				if((getEscolha().toLowerCase().equals("par") || getEscolha().toLowerCase().equals("ímpar")) && Double.valueOf(apostado.getText()) <= getCash()) {
					ImparParJogo ParouImpar = new ImparParJogo(getNome(), getCash(), Double.valueOf(apostado.getText()), getEscolha());
					if(ParouImpar.getValidarAposta().equals(true)) {
						ParouImpar.setVisible(true);
						setVisible(false);
					}
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("* Digite valores válidos.");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		
		JLabel label = new JLabel("* Utilize ponto, não vírgula.");
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFJogos painel = new JFJogos(getNome(), getCash());
				painel.setVisible(true);
				setVisible(false);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblSaldo))
						.addComponent(apr_odd, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addComponent(escolha_1)
						.addComponent(betar)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(apostado, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(jogar, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(rdbtnNewRadioButton_1)))
							.addGap(107)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)))))
					.addGap(295))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblSaldo)))
					.addGap(49)
					.addComponent(apr_odd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(escolha_1)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_1))
					.addGap(18)
					.addComponent(betar)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(apostado, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(jogar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton))))
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

	public Double getOdd() {
		return odd;
	}

	public void setOdd(Double odd) {
		this.odd = odd;
	}

	public String getEscolha() {
		return escolha;
	}

	public void setEscolha(String escolha) {
		this.escolha = escolha;
	}
	
	public void icone(){
		this.setIconImage(new ImageIcon(getClass().getResource("../imagens/download.png")).getImage());
	}
}

