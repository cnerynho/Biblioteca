package al.ifal.proo.biblioteca.control;

import java.sql.ResultSet;

import al.ifal.proo.biblioteca.model.conexao.ConsultarUsuarios;

class Main {

	
	public static void main(String[] args) {

		ConsultarUsuarios a = new ConsultarUsuarios();
		ResultSet rs ;
		try {
			rs = a.consultaCPF("09581844457");
			//rs.next();
			System.out.println(rs.next());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
