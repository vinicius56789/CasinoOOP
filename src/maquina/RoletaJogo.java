package maquina;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoletaJogo extends JFrame {

	private JPanel contentPane;
	private String nome;
	private Double cash;
	private Double odd = 3.5;
	private String escolha;
	private Double apostado;
	private int sorteado;
	private String resultado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoletaJogo frame = new RoletaJogo(null, null, null, null);
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
	public RoletaJogo(String nome, Double cash, String escolha, Double apostado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		icone();
		this.setNome(nome);
		this.setCash(cash);
		this.setEscolha(escolha);
		this.setApostado(apostado);
		this.sorteador();
		this.resultado();
		
		JLabel label = new JLabel("Resultado:");
		label.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label_1 = new JLabel("O número roletado foi: ");
		label_1.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label_2 = new JLabel(String.valueOf(this.getSorteado()));
		label_2.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label_3 = new JLabel(this.getResultado());
		label_3.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JButton button = new JButton("Novo jogo");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roleta painel = new Roleta(getNome(), getCash());
				painel.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton button_1 = new JButton("Tela de Escolha");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(169)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(44))
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

	public Double getApostado() {
		return apostado;
	}

	public void setApostado(Double apostado) {
		this.apostado = apostado;
	}
	
	public void sorteador() {
		Random random = new Random();
		int gerador = random.nextInt(5);
		this.setSorteado(gerador);
	}

	public int getSorteado() {
		return sorteado;
	}

	public void setSorteado(int sorteado) {
		this.sorteado = sorteado;
	}
	
	public void resultado() {
		if(this.getEscolha().equals(String.valueOf(this.getSorteado()))) {
			this.setResultado("Você venceu, saldo atualizado");
			this.setCash(this.getCash() + (this.getOdd() * this.getApostado()));
		}else {
			this.setResultado("Você perdeu, saldo atualizado");
			this.setCash(this.getCash() - this.getApostado());
		}
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public void icone(){
		this.setIconImage(new ImageIcon(getClass().getResource("../imagens/download.png")).getImage());
	}

}
