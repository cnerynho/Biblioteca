package al.ifal.proo.biblioteca.control.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Emprestimo;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Setor;
import al.ifal.proo.biblioteca.control.util.Usuario;
import al.ifal.proo.biblioteca.model.conexao.CadastrarSetor;
import al.ifal.proo.biblioteca.model.conexao.ConsultarEmprestimo;
import al.ifal.proo.biblioteca.model.conexao.ConsultarSetor;
import al.ifal.proo.biblioteca.model.conexao.EditarSetor;
public class UtilController {

	public void cadastrarSetor(String localizacao, String descricao) throws ControllerException {

		if (localizacao.equals("")) {
			throw new ControllerException("Faltou Digitar a localizacao");
		}

		CadastrarSetor cadastro = new CadastrarSetor();

		cadastro.CadastrarNovoSetor(localizacao, descricao);

	}

	public ArrayList<Emprestimo> consultarEmprestimo(Usuario user) {
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

		return emprestimos;
	}

	public ArrayList<Emprestimo> consultarEmprestimos(Item item) throws ControllerException {
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

		ResultSet consultaDeEmpestimos;

		try {
			ConsultarEmprestimo consultar = new ConsultarEmprestimo();
			consultaDeEmpestimos = consultar.consultarEmprestimo(item);
		} catch (ControllerException e) {
			throw e;
		}
		UserController consultaUsuario = new UserController();
		ItemController consultaItem = new ItemController();
		try{
			while (consultaDeEmpestimos.next()) {
				Emprestimo emprestimo;
				if (consultaDeEmpestimos.getDate(5) != null) {
					emprestimo = new Emprestimo(consultaDeEmpestimos.getInt(1),
							consultaUsuario.consultarUsuarioPeloID(consultaDeEmpestimos.getInt(2)),
							consultaItem.consultarItemPeloID(consultaDeEmpestimos.getInt(3)),
							consultaDeEmpestimos.getDate(4), consultaDeEmpestimos.getDate(5));
				}else {
					emprestimo = new Emprestimo(consultaDeEmpestimos.getInt(1),
						consultaUsuario.consultarUsuarioPeloID(consultaDeEmpestimos.getInt(2)),
						consultaItem.consultarItemPeloID(consultaDeEmpestimos.getInt(3)),
						consultaDeEmpestimos.getDate(4));
				}
				emprestimos.add(emprestimo);
	
			}
		}catch(SQLException e){
			throw new ControllerException("Erro ao consultar os Emprestimos");
		}
		return emprestimos;
	}

	public Setor consultarSetorID(int iD) throws ControllerException {

		ConsultarSetor consulta = new ConsultarSetor();
		ResultSet rs = consulta.consultaID(iD);

		try {
			if (rs.next()) {
				return new Setor(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			throw new ControllerException("Consulta vazia");
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta do Setor");
		} catch (ControllerException e) {
			throw e;
		}

	}
        
        public void editarSetor(String localizacao, String descricao) throws ControllerException {

		if (localizacao.equals("")) {
			throw new ControllerException("Faltou Digitar a localizacao");
		}

		EditarSetor editar = new EditarSetor();

		editar.edicaoSetor(localizacao, descricao);

	}

}
