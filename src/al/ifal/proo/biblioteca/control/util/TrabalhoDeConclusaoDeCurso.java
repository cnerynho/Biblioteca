package al.ifal.proo.biblioteca.control.util;

public class TrabalhoDeConclusaoDeCurso extends Item {

	private int ano;
	private String autor;
	private String institutoSuperior;
	private String curso;
	private String orientador;
	private String campoDeEstudos;

	public TrabalhoDeConclusaoDeCurso(int iD, String nome, Setor setor, boolean isDisponivel, int ano, String autor,
			String institutoSuperior, String curso, String orientador, String areaDeInteresse) {
		super(iD, nome, setor, isDisponivel);
		this.ano = ano;
		this.autor = autor;
		this.institutoSuperior = institutoSuperior;
		this.curso = curso;
		this.orientador = orientador;
		this.campoDeEstudos = areaDeInteresse;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getInstitutoSuperior() {
		return institutoSuperior;
	}

	public void setInstitutoSuperior(String institutoSuperior) {
		this.institutoSuperior = institutoSuperior;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public String getAreaDeInteresse() {
		return campoDeEstudos;
	}

	public void setAreaDeInteresse(String areaDeInteresse) {
		this.campoDeEstudos = areaDeInteresse;
	}

}
