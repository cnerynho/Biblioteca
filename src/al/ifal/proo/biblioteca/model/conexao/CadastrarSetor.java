package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

public class CadastrarSetor {
	
	public void CadastrarNovoSetor (String localizacao, String descricao) throws ControllerException{
		
		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("insert into setores(localizacao, descricao)" + "values('" + localizacao + "','"
					+ descricao + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}
	}

}
