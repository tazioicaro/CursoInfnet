package model.negocio;

import java.util.Set;

public class EscolaDeSamba {
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String pracinha;
	private String cores;
	private String ensaios;
	private Set<Torcedor> torcedores;
	
	public EscolaDeSamba() {	
	}
	
	public EscolaDeSamba(int id, String nome, String email, String senha,  String ensaios) {
		this.setId(id);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setEnsaios(ensaios);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Torcedor> getTorcedores() {
		return torcedores;
	}

	public void setTorcedores(Set<Torcedor> torcedores) {
		this.torcedores = torcedores;
	}

	public String getEnsaios() {
		return ensaios;
	}

	public void setEnsaios(String ensaios) {
		this.ensaios = ensaios;
	}

	public String getPracinha() {
		return pracinha;
	}

	public void setPracinha(String pracinha) {
		this.pracinha = pracinha;
	}

	public String getCores() {
		return cores;
	}

	public void setCores(String cores) {
		this.cores = cores;
	}
	
	
	
	

}
