package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Setor;

public class ConsultarItens {

	public ResultSet consultaItemID(int iD) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM itens WHERE ID=" + iD + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

		
	}
	public ResultSet consultaItemNome(String nome) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM itens WHERE Nome LIKE '%" + nome + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	
	}
	public ResultSet consultaItemSetor(Setor setor) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM itens WHERE id_Setor=" + setor.getiD() + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	
	}
	public ResultSet consultaLivroID(int iD) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM livros WHERE id=" + iD + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	
	}
	public ResultSet consultaLivroEditora(String editora) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM livros WHERE editora LIKE '%" + editora + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	
	}
	public ResultSet consultaLivroGenero(String genero) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM livros WHERE genero LIKE '%" + genero + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	
	}
	public ResultSet consultaLivroAutor(String autor) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM livros WHERE autor like '%" + autor + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	
	}
	public ResultSet consultaRevistaID(int iD) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM revistas WHERE ID=" + iD + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	
	}
	public ResultSet consultaRevistaAno(int ano) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM revistas WHERE ano=" + ano + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
	public ResultSet consultaRevistaNumero(int numero) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM revistas WHERE numero=" + numero + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
	public ResultSet consultaRevistaAnoNumero(int ano,int numero) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM revistas WHERE ano=" + ano + " AND (numero ="+numero+";");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
	public ResultSet consultaTccID(int iD) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM tcc WHERE ID=" + iD + "");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
	public ResultSet consultaTccAutor(String autor) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM tcc WHERE autor LIKE '%" + autor + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
	public ResultSet consultaTccInstituto(String instituto) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM tcc WHERE instituto LIKE '%" + instituto + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
	public ResultSet consultaTccCurso(String curso) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM tcc WHERE curso LIKE '%" + curso + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
	public ResultSet consultaTccOrientador(String orientador) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM tcc WHERE orientador LIKE '%" + orientador + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
	public ResultSet consultaTccCampoDeEstudo(String campoDeEstudo) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}
		try {
			return stmt.executeQuery("SELECT * FROM tcc WHERE campoDeEstudo LIKE '%" + campoDeEstudo + "%'");

		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}

	}
}
