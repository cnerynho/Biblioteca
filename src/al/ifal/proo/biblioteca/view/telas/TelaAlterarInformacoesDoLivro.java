package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.controllers.UtilController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Livro;

public class TelaAlterarInformacoesDoLivro extends Tela {

	public Livro livro;
	
	
	public TelaAlterarInformacoesDoLivro(Livro livro){
		this.livro = livro;
	}
	
	public Tela gerarTela() {
		
		Scanner entrada = new Scanner(System.in);
		ItemController itemControl = new ItemController();
		UtilController utilControl = new UtilController();
		
		while(true){
			System.out.println("QUAL INFORMAÇÃO GOSTARIA DE ALTERAR:\n"
					+ "1 - NOME\n"
					+ "2 - AUTOR\n"
					+ "3 - SETOR\n"
					+ "4 - EDITORA\n"
					+ "5 - EDICAO\n"
					+ "6 - GENERO\n"
					+ "7 - REMOVER LIVRO\n"
					+ "8 - VOLTAR AO MENU PRINCIPAL\n");
			switch(entrada.nextInt()){
			case 1:
				System.out.println("Digite o novo NOME para o livro:\n");
				try{
					itemControl.alterarNomeDoItem(livro,entrada.nextLine());
					System.out.println("NOME alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 2:
				System.out.println("Digite o nome do novo AUTOR para o livro:\n");
				try{
					itemControl.alterarAutorDoLivro(livro,entrada.nextLine());
					System.out.println("AUTOR alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 3:
				System.out.println("Digite o numero do novo SETOR para o livro:\n");
				try{
					itemControl.alterarSetorDoItem(livro,utilControl.consultarSetorID(entrada.nextInt()));
					System.out.println("SETOR alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 4:
				System.out.println("Digite o nome da nova EDITORA para o livro:\n");
				try{
					itemControl.alterarEditoraDoLivro(livro,entrada.nextLine());
					System.out.println("EDITORA alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 5:
				System.out.println("Digite o novo valor para EDICAO do livro:\n");
				try{
					itemControl.alterarEdicaoDoLivro(livro,entrada.nextInt());
					System.out.println("EDICAO alterado com Sucesso!");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 6:
				System.out.println("Digite o novo GENERO para o livro:\n");
				try{
					itemControl.alterarGeneroDoLivro(livro,entrada.nextLine());
					System.out.println("GENERO alterado com Sucesso!");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 7:
				System.out.println("TEM CERTEZA QUE QUER REMOVER O LIVRO?\n"
						+ "digite 'SIM' para confirmar ou qualquer coisa para cancelar\n");
				String opcao = entrada.nextLine();
				if(!opcao.equals("SIM")){
					break;
				}
				try{
					itemControl.removerItem(livro);
					System.out.println("Item REMOVIDO com Sucesso!\n");
					return null;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 8:
				return null;
			}
		}
	}

}
