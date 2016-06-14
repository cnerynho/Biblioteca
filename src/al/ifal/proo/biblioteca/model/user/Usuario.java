package al.ifal.proo.biblioteca.model.user;

public class Usuario {

	private int ID;
	private String usuario;
	private String senha;
	private int nivelAcesso;

	public Usuario(int iD, String login, String senha, int nivelAcesso) {
		ID = iD;
		this.usuario = login;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String login) {
		this.usuario = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

}
