package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

public class CadastrarItens {

	public int CadastrarItem(String nome, int idSetor, int tipoItem) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			return stmt.executeUpdate("insert into itens(Nome, id_Setor, Disponivel, tipo_item)" + "values('" + nome + "','"
					+ idSetor + "','" + true + "','" + tipoItem + "')", 1);
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}
	}
	
	public void CadastrarLivro(String nome, int idSetor, int tipoItem, String editora,int edicao, String genero, String autor) throws ControllerException{

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}		
		
		try {
			int ID = CadastrarItem(nome, idSetor, tipoItem);
			stmt.executeUpdate("insert into itens(id, editora, edicao, genero, autor)" + "values('" + ID + "','"
					+ editora + "','" + edicao + "','" + genero + "','" + autor + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}
}
