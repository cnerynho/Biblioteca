package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

public interface IConexao {

	public Connection getConexao() throws ControllerException;
	public void fecharConexao();
}
