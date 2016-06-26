package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Setor;

public class CadastrarItens {

	public int cadastrarItem(String nome, int idSetor, int tipoItem) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("INSERT INTO itens(Nome, id_Setor, Disponivel, tipo_item)" + "values('" + nome + "','"
					+ idSetor + "','" + 1 + "','" + tipoItem + "')", Statement.RETURN_GENERATED_KEYS);
			ResultSet result = stmt.getGeneratedKeys();
			result.next();
			int iD = result.getInt(1);
			return iD;
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}
	}

	public void cadastrarLivro(String nome, Setor setor, String editora, int edicao, String genero, String autor)
			throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			int ID = cadastrarItem(nome, setor.getiD(), ItemController.LIVRO);
			stmt.executeUpdate("insert into livros(id, editora, edicao, genero, autor)" + "values('" + ID + "','"
					+ editora + "','" + edicao + "','" + genero + "','" + autor + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}

	public void cadastrarTCC(String nome, Setor setor, String autor, String instituto, String curso, String orientador,
			String campoDeEstudo) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			int ID = cadastrarItem(nome, setor.getiD(), ItemController.TCC);
			stmt.executeUpdate("INSERT INTO tcc (id, autor, instituto, curso, orientador, campoDeEstudo)" + "values('"
					+ ID + "','" + autor + "','" + instituto + "','" + curso + "','" + orientador + "','" + campoDeEstudo + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}

	public void cadastrarRevista(String nome, Setor setor, int ano, int numero) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			int ID = cadastrarItem(nome, setor.getiD(), ItemController.REVISTA);
			stmt.executeUpdate(
					"INSERT INTO revistas(id, ano, numero)" + "values('" + ID + "','" + ano + "','" + numero + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}
}
