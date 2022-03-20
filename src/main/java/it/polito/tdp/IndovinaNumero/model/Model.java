package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {
	
	private int segreto;
	private final int TMAX = 8;
	private final int NMAX = 100;
	private int tentativiFatti;
	
	private boolean inGioco=false;
	
	private Set<Integer> tentativi;
	
	public Model() {
		//tentativi= new HashSet<Integer>();
	}//meglio farlo ogni nuova partita
	
	public void nuovaPartita() {
    	//gestione di una nuova partita
		
		tentativi= new HashSet<Integer>();

		this.segreto = (int)((Math.random() * NMAX) +1);
    	this.tentativiFatti = 0;
    	this.inGioco=true;
    	
	}

	public int tentativo(int tentativo) {
		if(!inGioco) {
			throw new IllegalStateException("Hai perso, partita terminata");
		}
		if(!tentativoValido(tentativo))
			throw new InvalidParameterException("Devi inserire numero tra 1 e "+NMAX+" che non hai ancora usato");
		
		this.tentativiFatti++;
		this.tentativi.add(tentativo);
		if(this.tentativiFatti==TMAX) {
			this.inGioco=false;
			
		}
		if(tentativo==segreto) {
	    	this.inGioco=false;
			return 0;
		} else if(tentativo < segreto) {
			return -1;
		} else {
			return 1;
		}
		
		
			
		
	}


	private boolean tentativoValido(int tentativo) {
		if(tentativo <1 ||tentativo > NMAX
				||tentativi.contains(tentativo))
			return false;
		return true;
	}

	public int getSegreto() {
		return segreto;
	}




	public int getTMAX() {
		return TMAX;
	}




	public int getNMAX() {
		return NMAX;
	}




	public int getTentativiFatti() {
		return tentativiFatti;
	}
}
