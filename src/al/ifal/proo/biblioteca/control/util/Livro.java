package al.ifal.proo.biblioteca.control.util;

public class Livro extends Item {

	private String editora;
	private int edicao;
	private String autor;
	private String genero;

	public Livro(int iD, String nome, Setor setor, boolean isDisponivel, String editora, int edicao, String autor,
			String genero) {
		super(iD, nome, setor, isDisponivel);
		this.editora = editora;
		this.edicao = edicao;
		this.autor = autor;
		this.genero = genero;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
