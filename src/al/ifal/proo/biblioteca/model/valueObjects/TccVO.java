package al.ifal.proo.biblioteca.model.valueObjects;

public class TccVO {

	private int iD;
	private String autor;
	private String instituto;
	private String curso;
	private String orientador;
	private String campoDeEstudo;

	public TccVO(int iD, String autor, String instituto, String curso, String orientador, String campoDeEstudo) {
		super();
		this.iD = iD;
		this.autor = autor;
		this.instituto = instituto;
		this.curso = curso;
		this.orientador = orientador;
		this.campoDeEstudo = campoDeEstudo;
	}

	public int getiD() {
		return iD;
	}

	public String getAutor() {
		return autor;
	}

	public String getInstituto() {
		return instituto;
	}

	public String getCurso() {
		return curso;
	}

	public String getOrientador() {
		return orientador;
	}

	public String getCampoDeEstudo() {
		return campoDeEstudo;
	}

}
