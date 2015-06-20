package model.negocio;

import java.util.Set;

public class Usuario {
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	private int tipo;
	
	
	
	public Usuario() {	
	}
	
	public Usuario(int id, String nome, String email, String senha, int tipo) {
		this.setId(id);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setTipo(tipo);
	}
	
	public Usuario(int id, String nome,  String senha, int tipo) {
		this.setId(id);
		this.setNome(nome);		
		this.setSenha(senha);
		this.setTipo(tipo);
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


	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	

}
