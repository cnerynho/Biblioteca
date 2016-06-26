package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

public class ConsultarUsuarios {

	public ResultSet consultaCPF(String CPF) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM usuarios WHERE cpf='" + CPF + "'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}

	public ResultSet consultaID(int ID) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM usuarios WHERE id=" + ID + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}

	public ResultSet consultaNome(String nome) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM usuarios WHERE nome LIKE '%" + nome + "%';");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}

	public ResultSet consultaTipoUsuario(int tipoUsuario) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM usuarios WHERE tipo_usuario=" + tipoUsuario + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}

	public ResultSet consultaCliente(int tipoCliente) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM usuarios WHERE tipo_cliente=" + tipoCliente + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}

}
