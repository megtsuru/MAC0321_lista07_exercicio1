package lista07.Isabella.Megumi.Q;

public class Mestre extends Cavaleiros {
	private int campoVidencia;
	private boolean imortalidade;
	private double quantidadeVida = 100.0;
	private int dominioSabre; //vai de 0 a 10
	private int dominioForca; //vai de 0 a 10
	
	public Mestre(String nome, int dominioForca, int dominioSabre) {
		this.nome = nome;
		this.dominioForca = dominioForca;
		this.dominioSabre = dominioSabre;
	}
	
	public void setVidaPosDano(double dano) {
		quantidadeVida -= dano;
	}
	
	public int getDominioForca() {
		return dominioForca;
	}
	public void setDominioForca(int dominioForca) {
		this.dominioForca = dominioForca;
	}
	public int getDominioSabre() {
		return dominioSabre;
	}
	public void setDominioSabre(int dominioSabre) {
		this.dominioSabre = dominioSabre;
	}
	public double getQuantidadeVida() {
		return quantidadeVida;
	}
	public void setQuantidadeVida(int quantidadeVida) {
		this.quantidadeVida = quantidadeVida;
	}
	public int getCampoVidencia() {
		return campoVidencia;
	}
	public void setCampoVidencia(int campoVidencia) {
		this.campoVidencia = campoVidencia;
	}
	public boolean isImortalidade() {
		return imortalidade;
	}
	public void setImortalidade(boolean imortalidade) {
		this.imortalidade = imortalidade;
	}
}
