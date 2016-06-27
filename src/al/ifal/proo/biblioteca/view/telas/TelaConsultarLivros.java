package al.ifal.proo.biblioteca.view.telas;

import java.util.ArrayList;
import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Livro;

public class TelaConsultarLivros extends Tela {


	public Tela gerarTela() {

		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		while(opcao<1 || opcao > 5){
			
			System.out.println("ESCOLHA UMA DAS OPÇÕES:\n"
					+ "1 - 	CONSULTAR POR ID\n"
					+ "2 - 	CONSULTAR POR NOME\n"
					+ "3 - 	CONSULTAR POR EDITORA\n"
					+ "4 -	CONSULTAR POR GENERO\n"
					+ "5 -	CONSULTAR POR AUTOR\n"
					+ "6 -	VOLTAR AO MENU PRINCIPAL\n");
		}

		switch(entrada.nextInt()){
		case 1:
			return consultarPorID();
		case 2:
			return consultarPorNome();
		case 3:
			return consultarPorEditora();
		case 4:
			return consultarPorGenero();
		case 5:
			return consultarPorAutor();
		case 6:
			return null;
		}
	}

	private Tela consultarPorNome() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Nome do Livro que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<Livro> consultados = consulta.consultarLivroPeloNome(nome);
			return new TelaExibirLivros(consultados);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Tela consultarPorID() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o ID do Livro que deseja Consultar");
		ItemController consulta = new ItemController();
		int iD = entrada.nextInt();
		try {
			Livro consultado = consulta.consultarLivroPeloID(iD);
			return new TelaExibirLivro(consultado);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
