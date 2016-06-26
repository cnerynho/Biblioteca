package al.ifal.proo.biblioteca.control.util;

import al.ifal.proo.biblioteca.control.controllers.UserController;

public class Gerente extends Usuario implements IUser {

	private String senha;

	public Gerente(int iD, String nome, String cpf, String endereco, String senha) {
		super(iD, nome, cpf, endereco, UserController.GERENTE, UserController.NVGERENTE);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
