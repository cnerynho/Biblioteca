package al.ifal.proo.biblioteca.model.util;

import java.util.ArrayList;

public class Autor {

	private int ID;
	private String nome;
	private ArrayList<Livro> livros;

	// Usar este quando consultar um autor ja existente
	public Autor(int iD, String nome, ArrayList<Livro> livros) {
		ID = iD;
		this.nome = nome;
		this.livros = livros;
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

	// consultar livro do autor pelo ID
	public Livro getLivro(int IDdoLivro) throws Exception {

		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getID() == IDdoLivro) {
				return livros.get(i);
			}
		}

		throw new Exception("Livro não encontrado!");
	}

	// consultar todos os livros do autor de acordo com a classificação
	public ArrayList<Livro> getLivrosClassificacao(String classificacao) throws Exception {

		ArrayList<Livro> livros = new ArrayList<Livro>();

		for (int i = 0; i < this.livros.size(); i++) {
			if (this.livros.get(i).getClassificacao().equals(classificacao)) {
				livros.add(this.livros.get(i));
			}
		}
		if (livros.size() == 0) {
			throw new Exception("Nenhum livro não encontrado!");
		}

		return livros;

	}

	// consultar livro do autor de acordo com o nome. PENSAR NO CASO DE EXISTIR
	// VARIOS LIVROS COM MESMO NOME
	public Livro getLivroNome(String nome) throws Exception {

		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getNome().equals(nome)) {
				return livros.get(i);
			}
		}

		throw new Exception("Livro não encontrado!");

	}

	// adicionar livro ao AUtor. CASO DA CRIACAO DE UM LIVRO NOVO!LEBRAR DE
	// PENSAR COMO ISTO FICARÁ NO BD
	public void addLivro(Livro novoLivro) {
		this.livros.add(novoLivro);
	}

}
