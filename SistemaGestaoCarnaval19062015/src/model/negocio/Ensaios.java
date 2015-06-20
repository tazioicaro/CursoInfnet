package model.negocio;


public class Ensaios {
	
	private int id, samba_id;
	private String descricao, data,	hora, duracao, escola;
	
	public Ensaios() {		

}

	public Ensaios(int id, String descricao, String data, String hora,
			String duracao, int samba_id) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.hora = hora;
		this.duracao = duracao;
		this.setSamba_id(samba_id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public int getSamba_id() {
		return samba_id;
	}

	public void setSamba_id(int samba_id) {
		this.samba_id = samba_id;
	}
}