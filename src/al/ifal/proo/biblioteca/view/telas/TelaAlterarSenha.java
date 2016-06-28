package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.Controlador;
import al.ifal.proo.biblioteca.control.controllers.UserController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class TelaAlterarSenha extends Tela {
	
	private Usuario usuario;

	public TelaAlterarSenha(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tela gerarTela() {
		
		Scanner entrada = new Scanner(System.in);
		UserController userC = new UserController();
		String senhaDigitada;
		String novaSenha1;
		String novaSenha2;
		
		System.out.println("Digite sua senha:\n");
		senhaDigitada = entrada.nextLine();
		if(!senhaDigitada.equals(Controlador.USER.getSenha())){
			System.out.println("SENHA INCORRETA");
			return null;
		}
		System.out.println("Digite a nova senha:\n");
		novaSenha1 = entrada.nextLine();

		System.out.println("Digite novamente a nova senha:\n");
		novaSenha2 = entrada.nextLine();
		
		if(novaSenha1.equals(novaSenha2)){
			try {
				userC.alterarSenhaUsuario(usuario,novaSenha1);
			} catch (ControllerException e) {
				System.out.println("Erro:"+e.getMessage());
			}
		}else {
			System.out.println("As duas senhas nao conferem\n");
		}
		
		
		
		
		
		return null;
	}

}
