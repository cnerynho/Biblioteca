package al.ifal.proo.biblioteca.control.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

public class ConexaoMySQL implements IConexao {

	public static Connection conexao;

	private String tipoBanco = "jdbc:mysql";
	private String endereco = "localhost";
	private String nomeBanco = "biblioteca";
	private String nomeUsuario = "root";
	private String senha = "";

	public synchronized Connection getConexao() throws ControllerException {

		conexao = null;

		try {
			conexao = DriverManager.getConnection(tipoBanco + "://" + endereco + "/" + nomeBanco, nomeUsuario, senha);
			return conexao;

		} catch (SQLException e) {
			throw new ControllerException("Erro de conexão com o banco de dados!");
		}

	}

	public void fecharConexao() {

		try {
			conexao.close();
		} catch (SQLException e) {

		}

		conexao = null;
	}

}
