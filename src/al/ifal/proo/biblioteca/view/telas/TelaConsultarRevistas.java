package al.ifal.proo.biblioteca.view.telas;

import java.util.ArrayList;
import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Revista;

public class TelaConsultarRevistas extends Tela {

	public Tela gerarTela() {

		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		while(opcao<1 || opcao > 5){
			
			System.out.println("ESCOLHA UMA DAS OPÇÕES:\n"
					+ "1 - 	CONSULTAR POR ID\n"
					+ "2 - 	CONSULTAR POR NOME\n"
					+ "3 - 	CONSULTAR POR ANO\n"
					+ "4 -	CONSULTAR POR NUMERO\n"
					+ "5 -	VOLTAR AO MENU PRINCIPAL\n");
			opcao = entrada.nextInt();
		}

			switch(opcao){
			case 1:
				return consultarPorID();
			case 2:
				return consultarPorNome();
			case 3:
				return consultarPorAno();
			case 4:
				return consultarPorNumero();
			case 5:
				return null;
			
		}
		return null;
	}
	
	private Tela consultarPorNome() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Nome da Revista que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<Revista> consultados = consulta.consultarRevistaPeloNome(nome);
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
	
	private Tela consultarPorAno() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o ANO da Revista que deseja Consultar");
		ItemController consulta = new ItemController();
		int ano = entrada.nextInt();
		try {
			ArrayList<Revista> consultados = consulta.consultarRevistaPorAno(ano);
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
	
	private Tela consultarPorNumero() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o NUMERO da Revista que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<Revista> consultados = consulta.consultarRevistaPeloNome(nome);
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

	private Tela consultarPorID() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o ID da Revista que deseja Consultar");
		ItemController consulta = new ItemController();
		int iD = entrada.nextInt();
		try {
			Revista consultado = consulta.consultarRevistaPeloID(iD);
			return new TelaExibirItem(consultado);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
