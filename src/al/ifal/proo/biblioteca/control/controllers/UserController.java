package al.ifal.proo.biblioteca.control.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.dataBase.ConexaoMySQL;
import al.ifal.proo.biblioteca.control.dataBase.IConexao;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Cliente;
import al.ifal.proo.biblioteca.control.util.Funcionario;
import al.ifal.proo.biblioteca.control.util.Gerente;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class UserController {

	public static final String CLIENTE = "CLIENTE";
	public static final String NVCLIENTE = "SIMPLES";
	public static final String FUNCIONARIO = "CLIENTE";
	public static final String NVFUNCIONARIO = "AVANCADO";
	public static final String GERENTE = "CLIENTE";
	public static final String NVGERENTE = "ADMINISTRADOR";

	public Usuario consultarUsuarioPeloCPF(String cpf) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		ResultSet rs;
		Statement stmt;
		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			rs = stmt.executeQuery("SELECT * FROM usuarios WHERE cpf=" + cpf + "");
			rs.next();
			if (rs.getString(6).equals(CLIENTE)) {
				return new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
			} else if (rs.getString(6).equals(FUNCIONARIO)) {
				return new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(4));
			} else if (rs.getString(6).equals(GERENTE)) {
				return new Gerente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
			}
			throw new ControllerException("Erro ao fazer a consulta!");

		} catch (SQLException e) {
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
			throw new ControllerException("Este CPF est� Cadastrado Para outro usuario");
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

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("insert into usuarios(nome, cpf, senha, Endereco, tipo_usuario, tipo_cliente)"
					+ "values('" + nome + "','" + cpf + "','" + senha + "','" + endereco + "','" + CLIENTE + "','"
					+ NVCLIENTE + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}

	public void cadastrarFuncionario(String nome, String cpf, String senha, String endereco) throws ControllerException {

		try {
			validarCPF(cpf);
			validarSenha(senha);
		} catch (ControllerException e) {
			throw e;
		}
		if (nome.equals("")) {
			throw new ControllerException("Faltou Digitar um nome!");
		}

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("insert into usuarios(nome, cpf, senha, Endereco, tipo_usuario, tipo_cliente)"
					+ "values('" + nome + "','" + cpf + "','" + senha + "','" + endereco + "','" + FUNCIONARIO + "','"
					+ NVFUNCIONARIO + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

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

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("insert into usuarios(nome, cpf, senha, Endereco, tipo_usuario, tipo_cliente)"
					+ "values('" + nome + "','" + cpf + "','" + senha + "','" + endereco + "','" + GERENTE + "','"
					+ NVGERENTE + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}

}
