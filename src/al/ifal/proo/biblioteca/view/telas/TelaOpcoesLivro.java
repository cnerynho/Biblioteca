package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.Controlador;
import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.controllers.UserController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Livro;

public class TelaOpcoesLivro extends Tela {

	private Livro consultado;

	public TelaOpcoesLivro(Livro consultado) {
		this.consultado = consultado;
	}

	public Tela gerarTela() {
		Controlador controller = new Controlador();
		switch (controller.getUsuario().getTipoUsuario()) {
		case UserController.CLIENTE:
			return menuCliente();
		case UserController.FUNCIONARIO:
			return menuFuncionario();
		case UserController.GERENTE:
			return menuGerente();
		}

		return null;
	}

	private Tela menuGerente() {
		Scanner entrada = new Scanner(System.in);
		UserController control = new UserController();
		ItemController itemControl = new ItemController();
		Controlador controller = new Controlador();

		while (true) {
			System.out.println(
							"DETALHES: \n" 
							+ consultado + "\n" 
							+ "OPCOES" 
							+ "1 - EMPRESTAR A UM CLIENTE\n"
							+ "2 - TORNAR INDISPONIVEL\n"
							+ "3 - TORNAR DISPONIVEL\n"
							+ "4 - PEGAR EMPRESTADO\n"
							+ "5 - ALTERAR INFORMACOES DO LIVRO\n" 
							+ "6 - VOLTAR AO MENU PRINCIPAL\n");
			
			switch (entrada.nextInt()) {
			case 1:
				return new TelaEmprestarLivroAoCliente(consultado);
			case 2:
				consultado.setDisponivel(false);
				itemControl.alterarLivro(consultado);
				return null;
			case 3:
				consultado.setDisponivel(true);
				itemControl.alterarLivro(consultado);
				return null;
			case 5:
				return new TelaAlterarInformacoesDoLivro(consultado);
			case 4:
				try {
					control.emprestarLivro(controller.getUsuario(), consultado);
				} catch (ControllerException e) {
					System.out.println("ERRO AO LOCAR LIVRO");
					break;
				}
			case 6:
				return null;
			}

		}
	}

	private Tela menuFuncionario() {
		Scanner entrada = new Scanner(System.in);
		UserController control = new UserController();
		ItemController itemControl = new ItemController();
		Controlador controller = new Controlador();

		while (true) {
			System.out.println(
							"DETALHES: \n" 
							+ consultado + "\n" 
							+ "OPCOES" 
							+ "1 - EMPRESTAR A UM CLIENTE\n"
							+ "2 - TORNAR INDISPONIVEL\n"
							+ "3 - TORNAR DISPONIVEL\n"
							+ "4 - PEGAR EMPRESTADO\n" 
							+ "5 - VOLTAR AO MENU PRINCIPAL\n");
			
			switch (entrada.nextInt()) {
			case 1:
				return TelaEmprestarLivroAoCliente(consultado);
			case 2:
				consultado.setDisponivel(false);
				itemControl.alterarLivro(consultado);
				return null;
			case 3:
				consultado.setDisponivel(true);
				itemControl.alterarLivro(consultado);
				return null;
			case 4:
				try {
					control.emprestarLivro(controller.getUsuario(), consultado);
				} catch (ControllerException e) {
					System.out.println("ERRO AO LOCAR LIVRO");
					break;
				}
			case 5:
				return null;
			}

		}
	}

	private Tela menuCliente() {
		Scanner entrada = new Scanner(System.in);
		UserController control = new UserController();
		Controlador controller = new Controlador();

		while (true) {
			System.out.println(
							"DETALHES: \n" 
							+ consultado 
							+ "\n" 
							+ "OPCOES" 
							+ "1 - PEGAR EMPRESTADO\n" 
							+ "2 - VOLTAR AO MENU PRINCIPAL\n");
			
			switch (entrada.nextInt()) {
			case 1:
				try {
					control.emprestarLivro(controller.getUsuario(), consultado);
				} catch (ControllerException e) {
					System.out.println("ERRO AO LOCAR LIVRO");
					break;
				}
			case 2:
				return null;
			}

		}
	}

}
