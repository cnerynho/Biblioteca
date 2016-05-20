package al.ifal.proo.biblioteca.model.util;

public class Livro {
	private int 	ID;
	private String 	nome;
	private String 	classificacao;
	private Autor 	autor;
	private String	descricao;
	private int 	edicao;
	
	//Usar este quando consultar um livro ja existente
	public Livro(int iD, String nome, String classificacao, Autor autor, String descricao, int edicao) {
		ID = iD;
		this.nome = nome;
		this.classificacao = classificacao;
		this.autor = autor;
		this.descricao = descricao;
		this.edicao = edicao;
	}
	
	//Usar este para criar um novo livro
	public Livro(String nome, String classificacao, Autor autor, String descricao, int edicao) {
		ID = getNewID();
		this.nome = nome;
		this.classificacao = classificacao;
		this.autor = autor;
		this.descricao = descricao;
		this.edicao = edicao;
	}

	private int getNewID() {
		// Criar um gerador de ID para livros Novos, de acordo com o BD
		return 0;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	
	
}
