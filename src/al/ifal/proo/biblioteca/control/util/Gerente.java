package al.ifal.proo.biblioteca.control.util;

public class Gerente extends Usuario implements IUser {

	private String senha;

	public Gerente(int iD, String nome, int cpf, String endereco, String senha) {
		super(iD, nome, cpf, endereco, "GERENTE", "ADMINISTRADOR");
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
