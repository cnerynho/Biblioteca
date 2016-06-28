package al.ifal.proo.biblioteca.control.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Cliente;
import al.ifal.proo.biblioteca.control.util.Funcionario;
import al.ifal.proo.biblioteca.control.util.Gerente;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Usuario;
import al.ifal.proo.biblioteca.model.conexao.CadastrarUsuarios;
import al.ifal.proo.biblioteca.model.conexao.ConsultarUsuarios;
import al.ifal.proo.biblioteca.model.conexao.EditarUsuarios;

public class UserController {

	public static final int CLIENTE = 1;
	public static final int NVCLIENTE = 1;
	public static final int FUNCIONARIO = 2;
	public static final int NVFUNCIONARIO = 2;
	public static final int GERENTE = 3;
	public static final int NVGERENTE = 3;

	public Usuario consultarUsuarioPeloCPF(String cpf) throws ControllerException {

		ConsultarUsuarios consulta = new ConsultarUsuarios();
		ResultSet rs = consulta.consultaCPF(cpf);

		try {
			if (!rs.next()) {
				throw new ControllerException("Consulta vazia");
			}
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta");
		} catch (ControllerException e) {
			throw e;
		}
		try {

			switch (rs.getInt(6)) {
			case CLIENTE:
				return new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
			case FUNCIONARIO:
				return new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(4));
			case GERENTE:
				return new Gerente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));

			}
			throw new Exception();
		} catch (Exception e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}

	private void validarCPF(String cpf) throws ControllerException {
		Usuario user = null;
		try {
			user = consultarUsuarioPeloCPF(cpf);
		} catch (ControllerException e) {

		}
		if (user != null) {
			throw new ControllerException("Este CPF esta Cadastrado Para outro usuario");
		}

		if (cpf.length() != 11) {
			throw new ControllerException("CPF com quantidade errada de caracteres!");
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

	public void cadastrarCliente(String nome, String cpf, String senha, String endereco) throws ControllerException {

		try {
			validarCPF(cpf);
			validarSenha(senha);
		} catch (ControllerException e) {
			throw e;
		}
		if (nome.equals("")) {
			throw new ControllerException("Faltou Digitar um nome!");
		}

		CadastrarUsuarios cadastro = new CadastrarUsuarios();
		cadastro.CadastrarUsuario(nome, cpf, senha, endereco, CLIENTE, NVCLIENTE);

	}

	public void cadastrarFuncionario(String nome, String cpf, String senha, String endereco)
			throws ControllerException {

		try {
			validarCPF(cpf);
			validarSenha(senha);
		} catch (ControllerException e) {
			throw e;
		}
		if (nome.equals("")) {
			throw new ControllerException("Faltou Digitar um nome!");
		}

		CadastrarUsuarios cadastro = new CadastrarUsuarios();
		cadastro.CadastrarUsuario(nome, cpf, senha, endereco, FUNCIONARIO, NVFUNCIONARIO);

	}

	public void cadastrarGerente(String nome, String cpf, String senha, String endereco) throws ControllerException {

		try {
			validarCPF(cpf);
			validarSenha(senha);
		} catch (ControllerException e) {
			throw e;
		}
		if (nome.equals("")) {
			throw new ControllerException("Faltou Digitar um nome!");
		}

		CadastrarUsuarios cadastro = new CadastrarUsuarios();
		cadastro.CadastrarUsuario(nome, cpf, senha, endereco, GERENTE, NVGERENTE);

	}

	public Usuario consultarUsuarioPeloID(int iD) throws ControllerException {
		ConsultarUsuarios consulta = new ConsultarUsuarios();
		ResultSet rs = consulta.consultaID(iD);

		try {
			if (!rs.next()) {
				throw new ControllerException("Consulta vazia");
			}
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta");
		} catch (ControllerException e) {
			throw e;
		}
		try {

			switch (rs.getInt(6)) {
			case CLIENTE:
				return new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
			case FUNCIONARIO:
				return new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(4));
			case GERENTE:
				return new Gerente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));

			}
			throw new Exception();
		} catch (Exception e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}
	}

	public ArrayList<Usuario> consultarUsuarioPeloNome(String nome) throws ControllerException {
		ConsultarUsuarios consulta = new ConsultarUsuarios();
		ResultSet rs = consulta.consultaNome(nome);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			while (rs.next()) {
				switch (rs.getInt(6)) {
				case CLIENTE:
					usuarios.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(4)));
					break;
				case FUNCIONARIO:
					usuarios.add(new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(4)));
					break;
				case GERENTE:
					usuarios.add(new Gerente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(4)));
					break;
				}
			}
			return usuarios;
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta");
		}
	}

	public ArrayList<Usuario> consultarUsuarioPeloTipo(int tipoUsuario) throws ControllerException {
		ConsultarUsuarios consulta = new ConsultarUsuarios();
		ResultSet rs = consulta.consultaTipoUsuario(tipoUsuario);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			while (rs.next()) {
				switch (rs.getInt(6)) {
				case CLIENTE:
					usuarios.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(4)));
					break;
				case FUNCIONARIO:
					usuarios.add(new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(4)));
					break;
				case GERENTE:
					usuarios.add(new Gerente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(4)));
					break;
				}
			}
			return usuarios;
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta");
		}
	}

	public ArrayList<Usuario> consultarTodosClientes() throws ControllerException {
		return consultarUsuarioPeloTipo(CLIENTE);
	}

	public ArrayList<Usuario> consultarTodosFuncionarios() throws ControllerException {
		return consultarUsuarioPeloTipo(FUNCIONARIO);

	}

	public ArrayList<Usuario> consultarTodosGerentes() throws ControllerException {
		return consultarUsuarioPeloTipo(GERENTE);

	}

	public void edicaoUsuario(String nome, String cpf, String senha, String endereco, int tipoUsuario, int nvlUsuario)
			throws ControllerException {

		try {
			validarCPF(cpf);
			validarSenha(senha);
		} catch (ControllerException e) {
			throw e;
		}
		if (nome.equals("")) {
			throw new ControllerException("Faltou Digitar um nome!");
		}

		EditarUsuarios editar = new EditarUsuarios();
		editar.editarUsuario(nome, cpf, senha, endereco, tipoUsuario, nvlUsuario);

	}

	public void emprestarItem(Usuario usuario, Item livro) throws ControllerException {
		EmprestimoDeItem emprestarLivro = new EmprestimoDeItem();
		emprestarLivro.novoEmprestimo(usuario,livro);
		
		
	}

}
