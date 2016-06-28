package al.ifal.proo.biblioteca.view.telas;

import java.util.ArrayList;
import java.util.Scanner;

import al.ifal.proo.biblioteca.control.Controlador;
import al.ifal.proo.biblioteca.control.controllers.UserController;
import al.ifal.proo.biblioteca.control.controllers.UtilController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Emprestimo;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class TelaExibirItensLocados extends Tela {

	private Usuario usuario;

	public TelaExibirItensLocados(Usuario usuario) {
		this.usuario = usuario;

	}


	public Tela gerarTela() {
		ArrayList<Emprestimo> emprestimos;
		Scanner entrada = new Scanner(System.in);	
		UserController userC = new UserController();
		
		try {
			emprestimos = userC.consultarEmprestimos(usuario);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		for(Emprestimo emprestimo:emprestimos){
			if(emprestimo.getDataQueDevolveu()==null){
				System.out.println(emprestimo+"\n");
			}
		}
		
		System.out.println("Digite ");
		if(Controlador.USER.getTipoUsuario()!=UserController.CLIENTE){
			System.out.println("DEVOLER para efetivar a devolucao ou ");			
		}
		System.out.println("Qualquer coisa para sair\n");
		String opcao = entrada.nextLine();
		
		if(Controlador.USER.getTipoUsuario()!=UserController.CLIENTE){
			if(opcao.equals("DEVOLVER")){
				System.out.println("DIGITE O ID DO EMPRESTIMO PARA EFETIVAR A DEVOLUCAO OU QUALQUER COISA PARA SAIR\n");
				try{
					UtilController devolver = new UtilController();
					devolver.devolverItem(devolver.consultarEmprestimos(entrada.nextInt()));
				}catch (ControllerException e){
					System.out.println("erro" + e.getMessage());
				}
			}			
		}
		

		
		return null;
	}

}
