package model.negocio;

import java.util.List;

public class Torcedor extends Usuario {

	
	private List<Torcedor> torcedores;
	
	
	
	public Torcedor (){
		
	}

	public List<Torcedor> getTorcedores() {
		return torcedores;
	}

	public void setTorcedores(List<Torcedor> torcedores) {
		this.torcedores = torcedores;
	}
	

}
