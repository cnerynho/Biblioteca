package al.ifal.proo.biblioteca.model.util;

public class Editora {

	private int ID;
	private String nome;

	public Editora(int iD, String nome) {
		super();
		ID = iD;
		this.nome = nome;
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

}
