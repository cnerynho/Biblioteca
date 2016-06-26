package al.ifal.proo.biblioteca.control.util;

import java.sql.Date;

public class Emprestimo {
	
	public int		iD;
	public Usuario 	user;
	public Item		item;
	public Date		dataQueLocou;
	public Date		dataQueDevolveu;
	
	public Emprestimo (int iD,Usuario user, Item item, Date dataQueLocou){
		
		this.iD = iD;
		this.user = user;
		this.item = item;
		this.dataQueLocou = dataQueLocou;
		dataQueDevolveu = null;
				
	}
	public Emprestimo (int iD, Usuario user, Item item, Date dataQueLocou, Date dataQueDevolveu){
		
		this.iD = iD;
		this.user = user;
		this.item = item;
		this.dataQueLocou = dataQueLocou;
		this.dataQueDevolveu = dataQueDevolveu;
				
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Date getDataQueLocou() {
		return dataQueLocou;
	}
	public Date getDataQueDevolveu() {
		return dataQueDevolveu;
	}
	public int getiD() {
		return iD;
	}
		
	
	
}
