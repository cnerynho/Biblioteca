package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

public class ConsultarSetor {

	public ResultSet consultaID(int iD) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM setores WHERE id=" + iD + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}

}
