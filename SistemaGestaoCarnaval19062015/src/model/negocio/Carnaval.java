package model.negocio;


public class Carnaval {
	
	private int id, idGrupo; 
	private String carnaval, ano;
	
	public Carnaval() {
		super();
	}
	
	public Carnaval(int id, int idGrupo, String carnaval, String ano) {
		super();
		
		this.id = id;
		this.idGrupo = idGrupo;
		this.carnaval = carnaval;
		this.ano = ano;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getCarnaval() {
		return carnaval;
	}
	public void setCarnaval(String carnaval) {
		this.carnaval = carnaval;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
}