package al.ifal.proo.biblioteca.model.valueObjects;

public class LivroVO {
	
	private int iD;
	private String editora;
	private int edicao;
	private String autor;
	private String genero;
	public LivroVO(int iD, String editora, int edicao, String autor, String genero) {
		super();
		this.iD = iD;
		this.editora = editora;
		this.edicao = edicao;
		this.autor = autor;
		this.genero = genero;
	}
	public int getiD() {
		return iD;
	}
	public String getEditora() {
		return editora;
	}
	public int getEdicao() {
		return edicao;
	}
	public String getAutor() {
		return autor;
	}
	public String getGenero() {
		return genero;
	}
}
