package model.negocio;


public class CarnavalTO {
	
	
	private int id, idGrupo;
	private String descricaoGrupo;
	private String carnaval, ano;
	
	public CarnavalTO() {
		super();
	
	}
		
	public CarnavalTO(int idGrupo, String descricaoGrupo, String carnaval, String ano) {
		super();
		this.idGrupo = idGrupo;
		this.descricaoGrupo = descricaoGrupo;
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

	public String getDescricaoGrupo() {
		return descricaoGrupo;
	}

	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo;
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