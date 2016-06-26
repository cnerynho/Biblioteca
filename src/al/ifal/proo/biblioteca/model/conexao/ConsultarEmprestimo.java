package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class ConsultarEmprestimo {
	
	public ResultSet consultarEmprestimo(Usuario user) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM usuarios WHERE usuario_id=" + user.getID() + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}
	
		
	}
	
	public ResultSet consultarEmprestimo(Item item) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM usuarios WHERE item_id=" + item.getiD() + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}
	
		
	}
	
	public ResultSet consultarLivrosEmprestadosDia(Date data) throws ControllerException{
		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM usuarios WHERE data_inicio=" + data + "");
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}
	}

}
