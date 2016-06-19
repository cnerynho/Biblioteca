package al.ifal.proo.biblioteca.control.controllers;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Cliente;

public class UserController {

	public static final String CLIENTE = "CLIENTE";
	public static final String NVCLIENTE = "SIMPLES";
	public static final String FUNCIONARIO = "CLIENTE";
	public static final String NVFUNCIONARIO = "AVANCADO";
	public static final String GERENTE = "CLIENTE";
	public static final String NVGERENTE = "ADMINISTRADOR";

	public Cliente consultarCpfUsuario(int cpf) throws ControllerException {

		return new Cliente(00, FUNCIONARIO, 0, "", GERENTE);

	}

	private void validarCPF(int cpf) throws ControllerException {
		try {
			consultarCpfUsuario(cpf);
			throw new ControllerException("Este CPF está Cadastrado Para outro usuario");
		} catch (ControllerException e) {

		}

		if (new Integer(cpf).toString().length() > 11) {
			throw new ControllerException("CPF com quantidade errada de caracteres!");
		}

		if (cpf == 0) {
			throw new ControllerException("Faltou digitar um CPF!");
		}

	}

	private void validarSenha(String senha) throws ControllerException {
		if (senha.length() < 6) {
			throw new ControllerException("Senha com quantidade insuficiente de caracteres");
		}

		if (senha.length() > 16) {
			throw new ControllerException("Senha com quantidade superior ao limite de caracteres");
		}

	}

	public void cadastrarCliente(String nome, int cpf, String senha, String rua, String bairro, String cidade,
			String estado, String complemento, int numeroCasa, int cep) throws ControllerException {

		try {
			validarCPF(cpf);
			validarSenha(senha);
		} catch (ControllerException e) {
			throw e;
		}
		if (nome.equals("")) {
			throw new ControllerException("Faltou Digitar um nome!");
		}

		// acessar banco de dados e salvar os dados nos locais corretos, criando
		// um novo cliente.

	}

	public void cadastrarFuncionario(String nome, int cpf, String senha, String rua, String bairro, String cidade,
			String estado, String complemento, int numeroCasa, int cep) throws ControllerException {

		try {
			validarCPF(cpf);
			validarSenha(senha);
		} catch (ControllerException e) {
			throw e;
		}
		if (nome.equals("")) {
			throw new ControllerException("Faltou Digitar um nome!");
		}

		// acessar banco de dados e salvar os dados nos locais corretos, criando
		// um novo cliente.

	}

	public void cadastrarGerente(String nome, int cpf, String senha, String rua, String bairro, String cidade,
			String estado, String complemento, int numeroCasa, int cep) throws ControllerException {

		try {
			validarCPF(cpf);
			validarSenha(senha);
		} catch (ControllerException e) {
			throw e;
		}
		if (nome.equals("")) {
			throw new ControllerException("Faltou Digitar um nome!");
		}

		// acessar banco de dados e salvar os dados nos locais corretos, criando
		// um novo cliente.

	}

}
