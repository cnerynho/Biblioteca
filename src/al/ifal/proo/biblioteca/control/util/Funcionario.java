package al.ifal.proo.biblioteca.control.util;

public class Funcionario extends Usuario implements IUser {

	private String senha;

	public Funcionario(int iD, String nome, int cpf, Endereco endereco, String senha) {
		super(iD, nome, cpf, endereco, senha, "FUNCIONARIO", "AVANCADO");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
