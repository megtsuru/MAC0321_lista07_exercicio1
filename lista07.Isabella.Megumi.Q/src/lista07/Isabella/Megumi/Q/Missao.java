package lista07.Isabella.Megumi.Q;

public class Missao {
	private String nome;
	private int anoExecucao;
	private boolean sucesso;
	private String objetivo;
	private Ser elaborador;
	private Ser executador;
	private Planeta[] planetasEnvolvidos = new Planeta[5];
	private Ser[] envolvidos = new Ser[5];
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoExecucao() {
		return anoExecucao;
	}
	public void setAnoExecucao(int anoExecucao) {
		this.anoExecucao = anoExecucao;
	}
	public boolean isSucesso() {
		return sucesso;
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public Ser getElaborador() {
		return elaborador;
	}
	public void setElaborador(Ser elaborador) {
		this.elaborador = elaborador;
	}
	public Ser getExecutador() {
		return executador;
	}
	public void setExecutador(Ser executador) {
		this.executador = executador;
	}
	public Planeta[] getPlanetasEnvolvidos() {
		return planetasEnvolvidos;
	}
	public void setPlanetasEnvolvidos(Planeta[] planetasEnvolvidos) {
		this.planetasEnvolvidos = planetasEnvolvidos;
	}
	public Ser[] getEnvolvidos() {
		return envolvidos;
	}
	public void setEnvolvidos(Ser[] envolvidos) {
		this.envolvidos = envolvidos;
	}
}
