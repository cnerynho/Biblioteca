package al.ifal.proo.biblioteca.control;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.controllers.UserController;
import al.ifal.proo.biblioteca.control.controllers.UtilController;
import al.ifal.proo.biblioteca.control.util.Setor;

class Main {

	
	public static void main(String[] args) {


		try {
			UtilController a = new UtilController();
			a.cadastrarSetor("asd", "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
