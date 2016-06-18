package al.ifal.proo.biblioteca.control.util;

public class Funcionario extends Usuario {

	public Funcionario(int iD, String nome, int cpf, Endereco endereco, String senha) {
		super(iD, nome, cpf, endereco, senha, "FUNCIONARIO", "AVANCADO");
	}

}
