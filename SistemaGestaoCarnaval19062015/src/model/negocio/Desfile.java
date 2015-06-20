package model.negocio;


public class Desfile {
	
	private int idEscola, idCarnaval;
	private String id, data, hora, duracao;
	
	public Desfile() {
		super();
	}
	
	public Desfile(int id_escola, int idCarnaval, String id, String data, String hora, String duracao) {
		super();
		this.idEscola = id_escola;
		this.setIdCarnaval(idCarnaval);
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.duracao = duracao;
	}
	
	
	public int getIdEscola() {
		return idEscola;
	}
	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public int getIdCarnaval() {
		return idCarnaval;
	}

	public void setIdCarnaval(int idCarnaval) {
		this.idCarnaval = idCarnaval;
	}
}