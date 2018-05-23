package lista07.Isabella.Megumi.Q;

public abstract class Ser {
	private String nome;
	private int anoNascimento;
	private Planeta planetaNatal;
	private String sexo;
	private String espécie;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoNascimento() {
		return anoNascimento;
	}
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	public Planeta getPlanetaNatal() {
		return planetaNatal;
	}
	public void setPlanetaNatal(Planeta planetaNatal) {
		this.planetaNatal = planetaNatal;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEspécie() {
		return espécie;
	}
	public void setEspécie(String espécie) {
		this.espécie = espécie;
	}
}
