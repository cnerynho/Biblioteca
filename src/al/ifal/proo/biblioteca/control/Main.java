package al.ifal.proo.biblioteca.control;

import java.sql.Date;

import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Livro;
import al.ifal.proo.biblioteca.control.util.Setor;

class Main {

	/*SQL DATE FORMAT
	 * year - the year minus 1900; must be 0 to 8099. (Note that 8099 is 9999 minus 1900.)
	 *month - 0 to 11
	 *day - 1 to 31 
	 * */
	public static void main(String[] args) {



		Date data = new Date(2016-1900,5,26);
		data.getYear();
		
		//Cliente a = new Cliente(1, "asdas", "12f2", "asdasd", "asdasd");
		//System.out.println(a);
		Setor setor = new Setor(22, "asd", "");
		
		Item a = new Livro(1,"livro 1" , setor, true, "Saraiva", 1, "carlos Nery", "ficcao cientifica");
		System.out.println(a);
		
		/*
		Setor setor = new Setor(22, "asd", "");
		ConsultarItens a = new ConsultarItens();
		UserController i = new UserController();
		
		
		try {
			for(Usuario aux:i.consultarTodosClientes()){
				System.out.println(aux.getID()+" "+aux.getNome());
			}
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
