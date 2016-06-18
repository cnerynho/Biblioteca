package al.ifal.proo.biblioteca.control.util;

public class Cliente extends Usuario {

	public Cliente(int iD, String nome, int cpf, Endereco endereco, String senha) {
		super(iD, nome, cpf, endereco, senha, "CLIENTE", "SIMPLES");
	}

}
