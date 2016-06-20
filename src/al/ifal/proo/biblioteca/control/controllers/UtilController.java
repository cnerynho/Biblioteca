package al.ifal.proo.biblioteca.control.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.dataBase.ConexaoMySQL;
import al.ifal.proo.biblioteca.control.dataBase.IConexao;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

public class UtilController {

	public void cadastrarSetor(String localizacao, String descricao) throws ControllerException {

		if (localizacao.equals("")) {
			throw new ControllerException("Faltou Digitar a localização!");
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
			stmt.executeUpdate("insert into setores(localizacao, descricao)" + "values('" + localizacao + "','"
					+ descricao + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}

}
