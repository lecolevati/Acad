package model;

public class Historico {

	private String numeroDeMatricula;
	private String nome;
	private String nomeDaDisciplina;
	private int semestreEAno;
	private String conceito;
	private double media;
	private int periodo;
	private String nomeDoCurso;
	private int classificacaoNoVestibular;
	private String dataDoVestibular;
	private double totalDePontosNoVestibular;
	
	public String getNumeroDeMatricula() {
		return numeroDeMatricula;
	}
	public String getNome() {
		return nome;
	}
	public String getNomeDaDisciplina() {
		return nomeDaDisciplina;
	}
	public int getSemestreEAno() {
		return semestreEAno;
	}
	public String getConceito() {
		return conceito;
	}
	public double getMedia() {
		return media;
	}
	public int getPeriodo() {
		return periodo;
	}
	public String getNomeDoCurso() {
		return nomeDoCurso;
	}
	public int getClassificacaoNoVestibular() {
		return classificacaoNoVestibular;
	}
	public String getDataDoVestibular() {
		return dataDoVestibular;
	}
	public double getTotalDePontosNoVestibular() {
		return totalDePontosNoVestibular;
	}
	public void setNumeroDeMatricula(String numeroDeMatricula) {
		this.numeroDeMatricula = numeroDeMatricula;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNomeDaDisciplina(String nomeDaDisciplina) {
		this.nomeDaDisciplina = nomeDaDisciplina;
	}
	public void setSemestreEAno(int semestreEAno) {
		this.semestreEAno = semestreEAno;
	}
	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}
	public void setClassificacaoNoVestibular(int classificacaoNoVestibular) {
		this.classificacaoNoVestibular = classificacaoNoVestibular;
	}
	public void setDataDoVestibular(String dataDoVestibular) {
		this.dataDoVestibular = dataDoVestibular;
	}
	public void setTotalDePontosNoVestibular(double totalDePontosNoVestibular) {
		this.totalDePontosNoVestibular = totalDePontosNoVestibular;
	}
}
