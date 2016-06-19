package al.ifal.proo.biblioteca.control.util;

public class Gerente extends Usuario implements IUser {

	private String senha;

	public Gerente(int iD, String nome, int cpf, Endereco endereco, String senha) {
		super(iD, nome, cpf, endereco, senha, "GERENTE", "ADMINISTRADOR");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
