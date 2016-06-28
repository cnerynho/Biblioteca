package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.controllers.UtilController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Revista;

public class TelaAlterarInformacoesDaRevista extends Tela {
	
	private Revista revista;

	public TelaAlterarInformacoesDaRevista(Revista revista) {
		this.revista = revista;
	}

	public Tela gerarTela() {
		
		Scanner entrada = new Scanner(System.in);
		ItemController itemControl = new ItemController();
		UtilController utilControl = new UtilController();
		
		while(true){
			System.out.println("QUAL INFORMAÇÃO GOSTARIA DE ALTERAR:\n"
					+ "1 - NOME\n"
					+ "2 - SETOR\n"
					+ "3 - ANO\n"
					+ "4 - NUMERO\n"
					+ "5 - REMOVER REVISTA\n"
					+ "6 - VOLTAR AO MENU PRINCIPAL\n");
			switch(entrada.nextInt()){
			case 1:
				System.out.println("Digite o novo NOME para o Revista:\n");
				try{
					itemControl.alterarNomeDoItem(revista,entrada.nextLine());
					System.out.println("NOME alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 2:
				System.out.println("Digite o numero do novo SETOR para o Revista:\n");
				try{
					itemControl.alterarSetorDoItem(revista,utilControl.consultarSetorID(entrada.nextInt()));
					System.out.println("SETOR alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 3:
				System.out.println("Digite o Novo Ano para a Revista:\n");
				try{
					itemControl.alterarAnoDaRevista(revista,entrada.nextInt());
					System.out.println("EDITORA alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 4:
				System.out.println("Digite o novo Numero para a Revista:\n");
				try{
					itemControl.alterarNumeroDaRevista(revista,entrada.nextInt());
					System.out.println("EDICAO alterado com Sucesso!");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 5:
				System.out.println("TEM CERTEZA QUE QUER REMOVER A REVISTA?\n"
						+ "digite 'SIM' para confirmar ou qualquer coisa para cancelar\n");
				String opcao = entrada.nextLine();
				if(!opcao.equals("SIM")){
					break;
				}
				try{
					itemControl.removerItem(revista);
					System.out.println("Item REMOVIDO com Sucesso!\n");
					return null;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 6:
				return null;
			}
		}
	}

}
