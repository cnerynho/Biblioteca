package al.ifal.proo.biblioteca.control.util;

public abstract class Item {
	
	private int 	iD;
	private String 	nome;
	private Setor	setor;
	private boolean isDisponivel;
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public boolean isDisponivel() {
		return isDisponivel;
	}
	public void setDisponivel(boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}
	
	

}
