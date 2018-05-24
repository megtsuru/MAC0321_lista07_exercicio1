package lista07.Isabella.Megumi.Q;

public class RegimePolitico {
	private String nome;
	private int anoInstituicao;
	private int anoDissolucao;
	private Ser chefeEstado;
	private String capital;
	private Planeta[] planetasPertencentes = new Planeta[5];
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoInstituicao() {
		return anoInstituicao;
	}
	public void setAnoInstituicao(int anoInstituicao) {
		this.anoInstituicao = anoInstituicao;
	}
	public int getAnoDissolucao() {
		return anoDissolucao;
	}
	public void setAnoDissolucao(int anoDissolucao) {
		this.anoDissolucao = anoDissolucao;
	}
	public Ser getChefeEstado() {
		return chefeEstado;
	}
	public void setChefeEstado(Ser chefeEstado) {
		this.chefeEstado = chefeEstado;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Planeta[] getPlanetasPertencentes() {
		return planetasPertencentes;
	}
	public void setPlanetasPertencentes(Planeta[] planetasPertencentes) {
		this.planetasPertencentes = planetasPertencentes;
	}
}
