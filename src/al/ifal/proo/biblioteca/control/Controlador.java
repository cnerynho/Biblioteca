package al.ifal.proo.biblioteca.control;

import al.ifal.proo.biblioteca.control.controllers.UserController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class Controlador {
	
	public static boolean isLogged = false;
	public static boolean isExit = false;
	public static Usuario USER;

	public Usuario AutenticarLoggin(String usuario, String senha) {
		
		UserController userC = new UserController();
		Usuario user = null;
		
		try{
			user = userC.consultarUsuarioPeloCPF(usuario);
		}catch (ControllerException e){
			return null;
		}
		
		if(user.getSenha()!=senha){
			return null;
		}
		
		USER = user;
		isLogged = true;
		
		return USER;
	}

	public boolean getIsLogged() {
		return isLogged;
	}

	public void Exit() {
		isExit = true;

	}

	public void LogOut() {
		isLogged = false;

	}

	public Usuario getUsuario() {
		return USER;
	}
}
