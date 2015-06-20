package model.negocio;

public class DesfileTO {
	
	private int idEscola, idCarnaval;
	private String descricaoEscola;
	private String descricaoCarnaval;
	private String id, data, hora, duracao;
	
	public DesfileTO() {
		super();
	
	}
		
	public DesfileTO(int idEscola, String id, String data, String hora) {
		super();
		this.idEscola = idEscola;
		this.id = id;
		this.data = data;
		this.hora = hora;
	}
	
	public int getIdEscola() {
		return idEscola;
	}
	
	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
	}
	
	public String getDescricaoEscola() {
		return descricaoEscola;
	}

	public void setDescricaoEscola(String descricaoEscola) {
		this.descricaoEscola = descricaoEscola;
	}
	
	public int getIdCarnaval() {
		return idCarnaval;
	}

	public void setIdCarnaval(int idCarnaval) {
		this.idCarnaval = idCarnaval;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricaoCarnaval() {
		return descricaoCarnaval;
	}

	public void setDescricaoCarnaval(String descricaoCarnaval) {
		this.descricaoCarnaval = descricaoCarnaval;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
}