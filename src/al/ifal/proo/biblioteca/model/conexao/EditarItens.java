
package al.ifal.proo.biblioteca.model.conexao;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Setor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EditarItens {
    
        public void editarLivro(String nome, Setor setor, String editora, int edicao, String genero, String autor)
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
			
			stmt.executeUpdate("update livros set(editora, edicao, genero, autor)" + "values('"
					+ editora + "','" + edicao + "','" + genero + "','" + autor + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}
        
        public void editarTCC(String nome, Setor setor, String autor, String instituto, String curso, String orientador,
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
			
			stmt.executeUpdate("update tcc set(autor, instituto, curso, orientador, campoDeEstudo)" + "values('" + autor + "','" + instituto + "','" + curso + "','" + orientador + "','" + campoDeEstudo + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}

	public void editarRevista(String nome, Setor setor, int ano, int numero) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			
			stmt.executeUpdate(
					"update revistas set(ano, numero)" + "values('" + ano + "','" + numero + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}
}
