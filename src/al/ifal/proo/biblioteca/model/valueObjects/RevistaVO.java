package al.ifal.proo.biblioteca.model.valueObjects;

public class RevistaVO {

	private int iD;
	private int ano;
	private int numero;
	public RevistaVO(int iD, int ano, int numero) {
		super();
		this.iD = iD;
		this.ano = ano;
		this.numero = numero;
	}
	public int getiD() {
		return iD;
	}
	public int getAno() {
		return ano;
	}
	public int getNumero() {
		return numero;
	}
	
	
}
