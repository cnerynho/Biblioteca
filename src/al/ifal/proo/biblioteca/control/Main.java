package al.ifal.proo.biblioteca.control;

import java.sql.Date;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Setor;
import al.ifal.proo.biblioteca.model.conexao.ConsultarItens;

class Main {

	/*SQL DATE FORMAT
	 * year - the year minus 1900; must be 0 to 8099. (Note that 8099 is 9999 minus 1900.)
	 *month - 0 to 11
	 *day - 1 to 31 
	 * */
	public static void main(String[] args) {



		Date data = new Date(2016-1900,5,26);
		data.getYear();
		
		Setor setor = new Setor(22, "asd", "");
		ConsultarItens a = new ConsultarItens();
		ItemController i = new ItemController();
		
		
		try {
			System.out.println(i.consultarItemPeloID(15).getNome());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
