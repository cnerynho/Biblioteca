package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;

public class TelaExibirItem extends Tela {
	
	private Item item;

	public TelaExibirItem(Item item) {
		this.item = item;
	}


	public Tela gerarTela() {
		Scanner entrada = new Scanner(System.in);
		ItemController itemC = new ItemController();

		System.out.println("Exibindo ITEM Consultado:\n"
				+ item
				+ "\n"
				+ "\n"
				+ "ESCOLHA UMA DAS OPCOES:\n"
				+ "1 - MAIS OPCOES\n"
				+ "2 - VOLTAR AO MENU PRINCIPAL\n");
		int opcao = entrada.nextInt();
		while(true){
			
			switch (opcao){
			case 1:
				try {
					return new TelaOpcoesItem(itemC.consultarLivroPeloID(item.getiD()));
				} catch (ControllerException e) {
					System.out.println(e.getMessage());
					return null;
				}
			case 2:
				return null;
			}
		}
		
	}

}
