package lista07.Isabella.Megumi.Q;

public class Mestre extends Cavaleiros {
	private int campoVidencia;
	private boolean imortalidade;
	private int quantidadeVida = 100;
	private String dominioSabre;

	public String getDominioSabre() {
		return dominioSabre;
	}
	public void setDominioSabre(String dominioSabre) {
		this.dominioSabre = dominioSabre;
	}
	public int getQuantidadeVida() {
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
