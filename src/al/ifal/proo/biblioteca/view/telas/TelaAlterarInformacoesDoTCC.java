package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.controllers.UtilController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.TrabalhoDeConclusaoDeCurso;

public class TelaAlterarInformacoesDoTCC extends Tela {

	private TrabalhoDeConclusaoDeCurso tcc;

	public TelaAlterarInformacoesDoTCC(TrabalhoDeConclusaoDeCurso tcc) {
		this.tcc = tcc;
	}

	public Tela gerarTela() {
		
		Scanner entrada = new Scanner(System.in);
		ItemController itemControl = new ItemController();
		UtilController utilControl = new UtilController();
		
		while(true){
			System.out.println("QUAL INFORMAÇÃO GOSTARIA DE ALTERAR:\n"
					+ "1 - NOME\n"
					+ "2 - SETOR\n"
					+ "3 - AUTOR\n"
					+ "4 - INSTITUTO\n"
					+ "5 - CURSO\n"
					+ "6 - ORIENTADOR\n"
					+ "7 - CAMPO DE ESTUDO\n"
					+ "8 - REMOVER TCC\n"
					+ "9 - VOLTAR AO MENU PRINCIPAL\n");
			switch(entrada.nextInt()){
			case 1:
				System.out.println("Digite o novo NOME para o Revista:\n");
				try{
					itemControl.alterarNomeDoItem(tcc,entrada.nextLine());
					System.out.println("NOME alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 2:
				System.out.println("Digite o numero do novo SETOR para o Revista:\n");
				try{
					itemControl.alterarSetorDoItem(tcc,utilControl.consultarSetorID(entrada.nextInt()));
					System.out.println("SETOR alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 3:
				System.out.println("Digite o nome do novo Autor para o TCC:\n");
				try{
					itemControl.alterarAutorDoTCC(tcc,entrada.nextLine());
					System.out.println("AUTOR alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 4:
				System.out.println("Digite o nome do novo Instituto para o TCC:\n");
				try{
					itemControl.alterarInstitutoDoTCC(tcc,entrada.nextLine());
					System.out.println("INSTITUTO alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 5:
				System.out.println("Digite o nome do novo CURSO para o TCC:\n");
				try{
					itemControl.alterarCursoDoTCC(tcc,entrada.nextLine());
					System.out.println("CURSO alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 6:
				System.out.println("Digite o nome do novo ORIENTADOR para o TCC:\n");
				try{
					itemControl.alterarOrientadorDoTCC(tcc,entrada.nextLine());
					System.out.println("ORIENTADOR alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 7:
				System.out.println("Digite o novo CAMPO DE ESTUDO para o TCC:\n");
				try{
					itemControl.alterarCampoDeEstudoDoTCC(tcc,entrada.nextLine());
					System.out.println("CAMPO DE ESTUDO alterado com Sucesso!\n");
					break;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 8:
				System.out.println("TEM CERTEZA QUE QUER REMOVER O TCC?\n"
						+ "digite 'SIM' para confirmar ou qualquer coisa para cancelar\n");
				String opcao = entrada.nextLine();
				if(!opcao.equals("SIM")){
					break;
				}
				try{
					itemControl.removerItem(tcc);
					System.out.println("Item REMOVIDO com Sucesso!\n");
					return null;
				}catch(ControllerException e){
					System.out.println(e.getMessage());
					break;
				}
			case 9:
				return null;
			}
		}
	}
}
