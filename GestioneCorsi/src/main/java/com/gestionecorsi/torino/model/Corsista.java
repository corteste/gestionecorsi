package com.gestionecorsi.torino.model;

public class Corsista {
	private int codCorsista;
	private String nomeCorsista;
	private String cognomeCorsista;
	private char precedentiFormativi;
	
	public int getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(int codCorsista) {
		this.codCorsista = codCorsista;
	}
	public String getNomeCorsista() {
		return nomeCorsista;
	}
	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}
	public String getCognomeCorsista() {
		return cognomeCorsista;
	}
	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}
	public char getPrecedentiFormativi() {
		return precedentiFormativi;
	}
	public void setPrecedentiFormativi(char precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}
	
	@Override
	public String toString() {
		return "Corsista [codCorsista=" + codCorsista + ", nomeCorsista=" + nomeCorsista + ", cognomeCorsista="
				+ cognomeCorsista + ", precedentiFormativi=" + precedentiFormativi + "]";
	}
	
	
	

}
