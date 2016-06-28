package al.ifal.proo.biblioteca.view.telas;

import java.util.ArrayList;
import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Livro;
import al.ifal.proo.biblioteca.control.util.TrabalhoDeConclusaoDeCurso;

public class TelaConsultarTCC extends Tela {

	public Tela gerarTela() {

		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		while(opcao<1 || opcao > 8){
			
			System.out.println("ESCOLHA UMA DAS OPÇÕES:\n"
					+ "1 - 	CONSULTAR POR ID\n"
					+ "2 - 	CONSULTAR POR NOME\n"
					+ "3 - 	CONSULTAR POR AUTOR\n"
					+ "4 -	CONSULTAR POR INSTITUTO\n"
					+ "5 -	CONSULTAR POR CURSO\n"
					+ "6 -	CONSULTAR POR ORIENTADOR\n"
					+ "7 -	CONSULTAR POR CAMPO DE ESTUDO\n"
					+ "8 -	VOLTAR AO MENU PRINCIPAL\n");
			opcao = entrada.nextInt();
		}

		switch(opcao){
		case 1:
			return consultarPorID();
		case 2:
			return consultarPorNome();
		case 3:
			return consultarPorAutor();
		case 4:
			return consultarPorInstituto();
		case 5:
			return consultarPorCurso();
		case 6:
			return consultarPorOrientador();
		case 7:
			return consultarPorCampoDeEstudo();
		case 8:
			return null;
				
		}
			return null;
	}
	
	private Tela consultarPorID() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o ID do TCC que deseja Consultar");
		ItemController consulta = new ItemController();
		int iD = entrada.nextInt();
		try {
			TrabalhoDeConclusaoDeCurso consultado = consulta.consultarTccPeloID(iD);
			return new TelaExibirItem(consultado);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	private Tela consultarPorNome() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Nome do TCC que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<TrabalhoDeConclusaoDeCurso> consultados = consulta.consultarTccPeloNome(nome);
			ArrayList<Item> itens = new ArrayList<Item>();
			for(Item item:consultados){
				itens.add(item);
			}
			return new TelaExibirItens(itens);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Tela consultarPorAutor() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Nome do Autor que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<TrabalhoDeConclusaoDeCurso> consultados = consulta.consultarTccPeloAutor(nome);
			ArrayList<Item> itens = new ArrayList<Item>();
			for(Item item:consultados){
				itens.add(item);
			}
			return new TelaExibirItens(itens);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Tela consultarPorInstituto() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Nome do Instituto que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<TrabalhoDeConclusaoDeCurso> consultados = consulta.consultarTccPeloInstituto(nome);
			ArrayList<Item> itens = new ArrayList<Item>();
			for(Item item:consultados){
				itens.add(item);
			}
			return new TelaExibirItens(itens);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Tela consultarPorCurso() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Nome do Curso que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<TrabalhoDeConclusaoDeCurso> consultados = consulta.consultarTccPeloCurso(nome);
			ArrayList<Item> itens = new ArrayList<Item>();
			for(Item item:consultados){
				itens.add(item);
			}
			return new TelaExibirItens(itens);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Tela consultarPorOrientador() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Nome do Orientador que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<TrabalhoDeConclusaoDeCurso> consultados = consulta.consultarTccPeloOrientador(nome);
			ArrayList<Item> itens = new ArrayList<Item>();
			for(Item item:consultados){
				itens.add(item);
			}
			return new TelaExibirItens(itens);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Tela consultarPorCampoDeEstudo() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Campo De Estudo que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<TrabalhoDeConclusaoDeCurso> consultados = consulta.consultarTccPeloCampoDeEstudo(nome);
			ArrayList<Item> itens = new ArrayList<Item>();
			for(Item item:consultados){
				itens.add(item);
			}
			return new TelaExibirItens(itens);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
