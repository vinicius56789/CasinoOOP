package maquina;

public class Usuario {
	
	private String nome;
	private Double cash = 100.0;
	
	public Usuario() {
		super();
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
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", pontuacao=" + cash + "]";
	}
	
}
