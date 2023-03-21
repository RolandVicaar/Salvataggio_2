package core;

import java.io.Serializable;
import java.util.HashMap;

public class Studente implements Serializable {
	
	private String nome;
	private int eta;
	
	public Studente(String n, int e) {
		this.nome = n;
		this.eta = e;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
	class Votazioni{
		//private List<String> materie = List of("STORIA","ITALIANO","MATEMATICA","SCIENZE");
		HashMap<String,Integer>materie = new HashMap<String,Integer>();
		
		public Votazioni() {
			materie.put("STORIA",0);
			materie.put("ITALIANO",0);
			materie.put("MATEMATICA",0);
			materie.put("SCIENZE",0);
		}
		
		public HashMap<String,Integer> getMaterie(){
			return this.materie;
		}
	}

	public String toString(){
		return this.nome + " " +this.eta;
	}

}
