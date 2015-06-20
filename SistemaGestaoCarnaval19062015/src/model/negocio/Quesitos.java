package model.negocio;

import java.util.List;

public class Quesitos {
	private String nome;
	List<Quesitos> listQuesitos;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Quesitos> getListQuesitos() {
		return listQuesitos;
	}
	public void setListQuesitos(List<Quesitos> listQuesitos) {
		this.listQuesitos = listQuesitos;
	}
	
	

}
