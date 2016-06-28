package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.Controlador;
import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.controllers.UserController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;

public class TelaOpcoesItem extends Tela {

	private Item item;

	public TelaOpcoesItem(Item livro) {
		this.item = livro;
	}

	public Tela gerarTela() {
		switch (Controlador.USER.getTipoUsuario()) {
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
							+ item + "\n" 
							+ "OPCOES\n" 
							+ "1 - EMPRESTAR A UM CLIENTE\n"
							+ "2 - TORNAR INDISPONIVEL\n"
							+ "3 - TORNAR DISPONIVEL\n"
							+ "4 - PEGAR EMPRESTADO\n"
							+ "5 - ALTERAR INFORMACOES DO ITEM\n" 
							+ "6 - VOLTAR AO MENU PRINCIPAL\n");
			
			switch (entrada.nextInt()) {
			case 1:
				return new TelaEmprestarItemAoCliente(item);
			case 2:
				item.setDisponivel(false);
				try{
					itemControl.alterarItem(item);
				} catch (ControllerException e1) {
					System.out.println("Ocorreu um erro!\n");
				}
				return null;
			case 3:
				item.setDisponivel(true);
				try {
				itemControl.alterarItem(item);
				} catch (ControllerException e1) {
					System.out.println("Ocorreu um erro!\n");
				}
				return null;
			case 5:
				switch(item.getTipo()){
				case ItemController.LIVRO:
					try {
						return new TelaAlterarInformacoesDoLivro(itemControl.consultarLivroPeloID(item.getiD()));
					} catch (ControllerException e1) {
						System.out.println("Ocorreu um erro!\n");
						return null;
					}
				case ItemController.REVISTA:
					try {
						return new TelaAlterarInformacoesDaRevista(itemControl.consultarRevistaPeloID(item.getiD()));
					} catch (ControllerException e1) {
						System.out.println("Ocorreu um erro!\n");
						return null;
					}
				case ItemController.TCC:
					try {
						return new TelaAlterarInformacoesDoTCC(itemControl.consultarTccPeloID(item.getiD()));
					} catch (ControllerException e1) {
						System.out.println("Ocorreu um erro!\n");
						return null;
					}
			
				}
				
			case 4:
				try {
					control.emprestarItem(controller.getUsuario(), item);
				} catch (ControllerException e) {
					System.out.println("ERRO AO LOCAR ITEM\n");
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
							+ item + "\n" 
							+ "OPCOES\n" 
							+ "1 - EMPRESTAR A UM CLIENTE\n"
							+ "2 - TORNAR INDISPONIVEL\n"
							+ "3 - TORNAR DISPONIVEL\n"
							+ "4 - PEGAR EMPRESTADO\n" 
							+ "5 - VOLTAR AO MENU PRINCIPAL\n");
			
			switch (entrada.nextInt()) {
			case 1:
				return new TelaEmprestarItemAoCliente(item);
			case 2:
				item.setDisponivel(false);
				try {
					itemControl.alterarItem(item);
				} catch (ControllerException e1) {
					System.out.println("Ocorreu um erro!\n");
				}
				return null;
			case 3:
				item.setDisponivel(true);
				try {
					itemControl.alterarItem(item);
				} catch (ControllerException e1) {
					System.out.println("Ocorreu um erro!\n");
				}
				return null;
			case 4:
				try {
					control.emprestarItem(controller.getUsuario(), item);
				} catch (ControllerException e) {
					System.out.println("ERRO AO LOCAR ITEM");
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
							+ item 
							+ "\n" 
							+ "OPCOES\n" 
							+ "1 - PEGAR EMPRESTADO\n" 
							+ "2 - VOLTAR AO MENU PRINCIPAL\n");
			
			switch (entrada.nextInt()) {
			case 1:
				try {
					control.emprestarItem(controller.getUsuario(), item);
				} catch (ControllerException e) {
					System.out.println("ERRO AO LOCAR ITEM");
					break;
				}
			case 2:
				return null;
			}

		}
	}

}
