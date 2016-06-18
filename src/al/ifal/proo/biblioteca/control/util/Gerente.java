package al.ifal.proo.biblioteca.control.util;

public class Gerente extends Usuario {

	public Gerente(int iD, String nome, int cpf, Endereco endereco, String senha) {
		super(iD, nome, cpf, endereco, senha, "GERENTE", "ADMINISTRADOR");
	}

}
