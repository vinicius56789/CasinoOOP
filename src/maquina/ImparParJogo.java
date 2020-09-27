package maquina;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImparParJogo extends JFrame {

	private JPanel contentPane;
	private String nome;
	private Double cash;
	private Double odd = 0.95;
	private String resultado;
	private int sorteado;
	private Boolean validar = false;
	private String texto;
	private Double apostado;
	private String escolha;
	

	public Double getOdd() {
		return odd;
	}

	public void setOdd(Double odd) {
		this.odd = odd;
	}

	public void setResultado(int numero) {
		if(numero % 2 == 0) {
			this.setParImpar("par");
		}else {
			this.setParImpar("ímpar");
		}
	}
	
	public void setValidarAposta(String escolha, Double apostado) {
		if(this.getEscolha().toLowerCase().equals("par") || this.getEscolha().toLowerCase().equals("impar") || this.getEscolha().toLowerCase().equals("ímpar") && this.getApostado() <= this.getCash()) {
			this.setValidar(true);
		}
	}
	
	public void setValidar(Boolean validar) {
		this.validar = validar;
	}
	
	public void setParImpar(String resultado) {
		this.resultado = resultado;
	}
	
	public String getResultado() {
		return resultado;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void sorteado(Boolean validar) {
		if(getValidarAposta() == true) {
			Random random = new Random();
			int gerador = random.nextInt(100);
			this.setSorteado(gerador);
		}
	}

	public int getSorteado() {
		return sorteado;
	}

	public void setSorteado(int sorteado) {
		this.sorteado = sorteado;
	}
	
	public Boolean getValidarAposta() {
		return validar;
	}
	
	public void resultado() {
		if(this.getEscolha().toLowerCase().equals(this.getResultado())) {
			Double dinheiro = Double.valueOf(this.getApostado()) * getOdd();
			this.setCash(this.getCash() + dinheiro);
			this.setTexto("Você venceu, saldo atualizado.");
		}else{
			Double dinheiro = Double.valueOf(this.getApostado());
			this.setCash(this.getCash() - dinheiro);
			this.setTexto("Você perdeu, saldo atualizado.");
		}
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
	
	public Double getApostado() {
		return apostado;
	}

	public void setApostado(Double apostado) {
		this.apostado = apostado;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImparParJogo frame = new ImparParJogo(null, null, null, null);
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
	public ImparParJogo(String nome, Double cash, Double apostado, String escolha) {
		
		icone();
		this.setNome(nome);
		this.setCash(cash);
		this.setApostado(apostado);
		this.setEscolha(escolha);
		
		this.setValidarAposta(this.getEscolha(), this.getApostado());
		this.sorteado(this.getValidarAposta());
		this.setResultado(this.getSorteado());
		this.resultado();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel resultado_2 = new JLabel("Resultado:");
		resultado_2.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel lblNumero = new JLabel("O Número sorteado foi:");
		lblNumero.setFont(new Font("Impact", Font.PLAIN, 25));
		
		String palavra = String.valueOf(getSorteado());
		JLabel numero = new JLabel(palavra);
		numero.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel lblParouImpar = new JLabel("O número é:");
		lblParouImpar.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel imparPar = new JLabel(this.getResultado());
		imparPar.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JLabel label = new JLabel(this.getTexto());
		label.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JButton btnNewButton = new JButton("Novo jogo");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImparPar painel = new ImparPar(getNome(), getCash());
				painel.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton button = new JButton("Tela de Escolha");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFJogos painel = new JFJogos(getNome(), getCash());
				painel.setVisible(true);
				setVisible(false);
			}
		});
		
//		String.valueOf(getValidarAposta())
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(169)
							.addComponent(resultado_2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(numero, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblParouImpar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(imparPar, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(resultado_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(numero, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblParouImpar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(imparPar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
