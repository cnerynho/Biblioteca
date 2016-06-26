package al.ifal.proo.biblioteca.control.controllers;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Setor;
import al.ifal.proo.biblioteca.model.conexao.CadastrarItens;

public class ItemController {

	public static final int LIVRO = 1;
	public static final int RESVISTA = 2;
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

}
