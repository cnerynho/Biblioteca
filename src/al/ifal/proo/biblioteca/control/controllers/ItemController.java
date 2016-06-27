package al.ifal.proo.biblioteca.control.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Livro;
import al.ifal.proo.biblioteca.control.util.Revista;
import al.ifal.proo.biblioteca.control.util.Setor;
import al.ifal.proo.biblioteca.control.util.TrabalhoDeConclusaoDeCurso;
import al.ifal.proo.biblioteca.model.conexao.CadastrarItens;
import al.ifal.proo.biblioteca.model.conexao.ConsultarItens;
import al.ifal.proo.biblioteca.model.conexao.ItemVO;

public class ItemController {

	public static final int LIVRO = 1;
	public static final int REVISTA = 2;
	public static final int TCC = 3;

	public void cadastrarLivro(String nome, Setor setor, String editora, int edicao, String autor, String genero)
			throws ControllerException {

		if (nome.equals("")) {
			throw new ControllerException("Nome do Livro está em branco");
		}

		CadastrarItens cadastro = new CadastrarItens();

		try {
			cadastro.cadastrarLivro(nome, setor, editora, edicao, genero, autor);

		} catch (ControllerException e) {
			throw new ControllerException("Ocorreu algum problema, tente novamente");
		}

	}

	public void cadastrarRevista(String nome, Setor setor, int ano, int numero) throws ControllerException {

		if (nome.equals("")) {
			throw new ControllerException("Nome da revista está em branco");
		}

		CadastrarItens cadastro = new CadastrarItens();

		try {
			cadastro.cadastrarRevista(nome, setor, ano, numero);
			;

		} catch (ControllerException e) {
			throw new ControllerException("Ocorreu algum problema, tente novamente");
		}

	}

	public void cadastrarTCC(String nome, Setor setor, String autor, String institutoSuperior, String curso,
			String orientador, String campoDeEstudo) throws ControllerException {

		if (nome.equals("")) {
			throw new ControllerException("Nome do trabalho está em branco");
		}

		CadastrarItens cadastro = new CadastrarItens();

		try {
			cadastro.cadastrarTCC(nome, setor, autor, institutoSuperior, curso, orientador, campoDeEstudo);

		} catch (ControllerException e) {
			throw new ControllerException("Ocorreu algum problema, tente novamente");
		}

	}

	public Item consultarItemPeloID(int _iD) throws ControllerException {
		ConsultarItens consulta = new ConsultarItens();
		ResultSet rs = consulta.consultaItemID(_iD);
		UtilController consultarSetor = new UtilController();

		int iD_item;
		String nome;
		Setor setor;
		boolean isDisponivel;

		try {
			if (!rs.next()) {
				throw new ControllerException("Consulta vazia");
			}
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta");
		} catch (ControllerException e) {
			throw e;
		}
		try {

			iD_item = rs.getInt(1);
			nome = rs.getString(2);
			setor = consultarSetor.consultarSetorID(rs.getInt(3));
			isDisponivel = rs.getBoolean(4);
			switch (rs.getInt(5)) {
			case LIVRO:
				rs = consulta.consultaLivroID(iD_item);
				rs.next();
				return new Livro(iD_item, nome, setor, isDisponivel, rs.getString(2), rs.getInt(3), rs.getString(5),
						rs.getString(4));
			case REVISTA:
				rs = consulta.consultaRevistaID(iD_item);
				rs.next();
				return new Revista(iD_item, nome, setor, isDisponivel, rs.getInt(2), rs.getInt(3));
			case TCC:
				rs = consulta.consultaLivroID(iD_item);
				rs.next();
				return new TrabalhoDeConclusaoDeCurso(iD_item, nome, setor, isDisponivel, rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

			}
			throw new Exception();
		} catch (Exception e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}
	}

	public ArrayList<Item> consultarItemPeloNome(String _nome) throws ControllerException {
		ConsultarItens consulta = new ConsultarItens();
		ResultSet rs = consulta.consultaItemNome(_nome);
		UtilController consultarSetor = new UtilController();
		ArrayList<ItemVO> itensVO = new ArrayList<ItemVO>();
		ArrayList<Item> itens = new ArrayList<Item>();

		try {
			while (rs.next()) {
				ItemVO item = new ItemVO(rs.getInt(1), rs.getString(2), consultarSetor.consultarSetorID(rs.getInt(3)),
						rs.getBoolean(4), rs.getInt(5));
				itensVO.add(item);

			}
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta");
		} catch (ControllerException e) {
			throw e;
		}
		try {
			for(ItemVO i:itensVO){
				switch (i.getTipoItem()) {
				case LIVRO:
					rs = consulta.consultaLivroID(i.getiD());
					rs.next();
					itens.add(new Livro(i.getiD(), i.getNome(), i.getSetor(), i.isDisponivel(), rs.getString(2), rs.getInt(3), rs.getString(5),
							rs.getString(4)));
					break;
				case REVISTA:
					rs = consulta.consultaRevistaID(i.getiD());
					rs.next();
					itens.add( new Revista(i.getiD(), i.getNome(), i.getSetor(), i.isDisponivel(), rs.getInt(2), rs.getInt(3)));
					break;
				case TCC:
					rs = consulta.consultaLivroID(i.getiD());
					rs.next();
					itens.add( new TrabalhoDeConclusaoDeCurso(i.getiD(), i.getNome(), i.getSetor(), i.isDisponivel(), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
					break;
				}
			}
			return itens;
		} catch (Exception e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}
	}

	public ArrayList<Item> consultarItemPeloSetor(Setor _setor) throws ControllerException {
		ConsultarItens consulta = new ConsultarItens();
		ResultSet rs = consulta.consultaItemSetor(_setor);
		UtilController consultarSetor = new UtilController();
		ArrayList<ItemVO> itensVO = new ArrayList<ItemVO>();
		ArrayList<Item> itens = new ArrayList<Item>();

		try {
			while (rs.next()) {
				ItemVO item = new ItemVO(rs.getInt(1), rs.getString(2), _setor,
						rs.getBoolean(4), rs.getInt(5));
				itensVO.add(item);

			}
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta");
		}
		try {
			for(ItemVO i:itensVO){
				switch (i.getTipoItem()) {
				case LIVRO:
					rs = consulta.consultaLivroID(i.getiD());
					rs.next();
					itens.add(new Livro(i.getiD(), i.getNome(), i.getSetor(), i.isDisponivel(), rs.getString(2), rs.getInt(3), rs.getString(5),
							rs.getString(4)));
					break;
				case REVISTA:
					rs = consulta.consultaRevistaID(i.getiD());
					rs.next();
					itens.add( new Revista(i.getiD(), i.getNome(), i.getSetor(), i.isDisponivel(), rs.getInt(2), rs.getInt(3)));
					break;
				case TCC:
					rs = consulta.consultaLivroID(i.getiD());
					rs.next();
					itens.add( new TrabalhoDeConclusaoDeCurso(i.getiD(), i.getNome(), i.getSetor(), i.isDisponivel(), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
					break;
				}
			}
			return itens;
		} catch (Exception e) {
			throw new ControllerException("Erro ao fazer a consulta!");
		}
	}

}
