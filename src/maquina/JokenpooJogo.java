package maquina;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JokenpooJogo extends JFrame {
	
	private String nome;
	private Double cash;
	private Double odd = 0.95;
	private String escolha;
	private Double apostado;
	private String sorteado;
	private String resultado;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JokenpooJogo frame = new JokenpooJogo(null, null, null, null);
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
	public JokenpooJogo(String nome, Double cash, String escolha, Double apostado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setNome(nome);
		this.setCash(cash);
		this.setEscolha(escolha);
		this.setApostado(apostado);
		this.sorteador();
		this.verificaIgualdade();
		this.resultado();
		
		JLabel label = new JLabel("Resultado:");
		label.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label_1 = new JLabel("Você jogou: ");
		label_1.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label_2 = new JLabel(this.getEscolha());
		label_2.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label_3 = new JLabel("CPU jogou: ");
		label_3.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label_4 = new JLabel(this.getSorteado());
		label_4.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label_5 = new JLabel(this.getResultado());
		label_5.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JButton button = new JButton("Novo jogo");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jokenpoo painel = new Jokenpoo(getNome(), getCash());
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
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
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
		int gerador = random.nextInt(3);
		if(gerador == 0) {
			setSorteado("Pedra");
		}else if(gerador == 1) {
			setSorteado("Papel");
		}else if(gerador == 2) {
			setSorteado("Tesoura");
		}
	}
	
	public void verificaIgualdade() {
		while(this.getSorteado().equals(this.getEscolha())){
			this.sorteador();
		}
	}

	public String getSorteado() {
		return sorteado;
	}

	public void setSorteado(String sorteado) {
		this.sorteado = sorteado;
	}
	
	public void resultado() {
		if(!this.getEscolha().equals(this.getSorteado())) {
			if(this.getEscolha().equals("Pedra") && this.getSorteado().equals("Tesoura")) {
				this.setCash(this.getCash() + (this.getApostado() * this.getOdd()));
				this.setResultado("Você venceu, saldo atualizado");
			}else if(this.getEscolha().equals("Tesoura") && this.getSorteado().equals("Papel")) {
				this.setCash(this.getCash() + (this.getApostado() * this.getOdd()));
				this.setResultado("Você venceu, saldo atualizado");
			}else if(this.getEscolha().equals("Papel") && this.getSorteado().equals("Pedra")) {
				this.setCash(this.getCash() + (this.getApostado() * this.getOdd()));
				this.setResultado("Você venceu, saldo atualizado");
			}else if(this.getEscolha().equals("Pedra") && this.getSorteado().equals("Papel")) {
				this.setCash(this.getCash() - this.getApostado());
				this.setResultado("Você perdeu, saldo atualizado");
			}
			else if(this.getEscolha().equals("Papel") && this.getSorteado().equals("Tesoura")) {
				this.setCash(this.getCash() - this.getApostado());
				this.setResultado("Você perdeu, saldo atualizado");
			}else if(this.getEscolha().equals("Tesoura") && this.getSorteado().equals("Pedra")) {
				this.setCash(this.getCash() - this.getApostado());
				this.setResultado("Você perdeu, saldo atualizado");
			}
		}
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	
}
