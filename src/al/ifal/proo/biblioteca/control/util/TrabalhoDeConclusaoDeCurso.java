package al.ifal.proo.biblioteca.control.util;

public class TrabalhoDeConclusaoDeCurso extends Item {

	private String autor;
	private String institutoSuperior;
	private String curso;
	private String orientador;
	private String campoDeEstudo;

	public TrabalhoDeConclusaoDeCurso(int iD, String nome, Setor setor, boolean isDisponivel, String autor,
			String institutoSuperior, String curso, String orientador, String campoDeEstudo) {
		super(iD, nome, setor, isDisponivel);
		this.autor = autor;
		this.institutoSuperior = institutoSuperior;
		this.curso = curso;
		this.orientador = orientador;
		this.campoDeEstudo = campoDeEstudo;
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
		return campoDeEstudo;
	}

	public void setAreaDeInteresse(String areaDeInteresse) {
		this.campoDeEstudo = areaDeInteresse;
	}

	@Override
	public String toString() {
		return "TCC " + this.getiD() + this.toStringItem() + ", Autor = " + autor + ", Instituto Superior = "
				+ institutoSuperior + ", Curso = " + curso + ", Orientador = " + orientador + ", Campo De Estudo = "
				+ campoDeEstudo;
	}

}
