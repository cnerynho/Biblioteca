
package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Livro;
import al.ifal.proo.biblioteca.control.util.Revista;
import al.ifal.proo.biblioteca.control.util.TrabalhoDeConclusaoDeCurso;

public class EditarItens {

	public void editarLivro(Livro livro) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("update itens set(Nome, id_Setor, Disponivel)" + "values('" + livro.getNome() + "','"
					+ livro.getSetor().getiD() + "','" + livro.isDisponivel() + "')");
			stmt.executeUpdate("update livros set(editora, edicao, genero, autor)" + "values('" + livro.getEditora()
					+ "','" + livro.getEdicao() + "','" + livro.getGenero() + "','" + livro.getAutor() + "')");
		} catch (SQLException e) {
			throw new ControllerException("Erro ao incluir os dados na tabela");
		}

	}

	public void editarTCC(TrabalhoDeConclusaoDeCurso tcc) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("update itens set(Nome, id_Setor, Disponivel)" + "values('" + tcc.getNome() + "','"
					+ tcc.getSetor().getiD() + "','" + tcc.isDisponivel() + "')");

			stmt.executeUpdate("update tcc set(autor, instituto, curso, orientador, campoDeEstudo)" + "values('"
					+ tcc.getAutor() + "','" + tcc.getInstitutoSuperior() + "','" + tcc.getCurso() + "','"
					+ tcc.getOrientador() + "','" + tcc.getAreaDeInteresse() + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}

	public void editarRevista(Revista revista) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("update itens set(Nome, id_Setor, Disponivel)" + "values('" + revista.getNome() + "','"
					+ revista.getSetor().getiD() + "','" + revista.isDisponivel() + "')");

			stmt.executeUpdate("update revistas set(ano, numero)" + "values('" + revista.getAno() + "','"
					+ revista.getNumero() + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}


	public void removerItem(Item item) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("remove from itens where ID = "+item.getiD()+"')");
			
			switch(item.getTipo()){
			case ItemController.LIVRO:
				stmt.executeUpdate("remove from livros where ID = "+item.getiD()+"')");
			case ItemController.REVISTA:
				stmt.executeUpdate("remove from revistas where ID = "+item.getiD()+"')");
			case ItemController.TCC:
				stmt.executeUpdate("remove from tcc where ID = "+item.getiD()+"')");
			}
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

		
	}

	public void editarItem(Item item) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {			
			stmt.executeUpdate("update itens set(Nome, id_Setor, Disponivel)" + "values('" + item.getNome() + "','"
				+ item.getSetor().getiD() + "','" + item.isDisponivel() + "')");
			

		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}

	}



}
