package al.ifal.proo.biblioteca.control;

import al.ifal.proo.biblioteca.control.controllers.UtilController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

class Main {

	
	public static void main(String[] args) {

		UtilController controlador = new UtilController();
		try {
			controlador.cadastrarSetor("carlos", "09581844457");
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
		}	
	
	}

}
