package fr.afcepf.al30.emprunt;
/* DTO : Data Transfert Object : param entree d'un appel WS SOAP */
public class OffrePret {
	private double montant;
	private int duree; //nombre d'années
	private double tauxInteret; //par an
	private double mensualite;
	private double fraisDossier;
	private boolean ok;
	private String message;
	
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getTauxInteret() {
		return tauxInteret;
	}
	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	public double getMensualite() {
		return mensualite;
	}
	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}
	public double getFraisDossier() {
		return fraisDossier;
	}
	public void setFraisDossier(double fraisDossier) {
		this.fraisDossier = fraisDossier;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
