package fr.afcepf.al30.emprunt;

/* DTO : Data Transfert Object : param entree d'un appel WS SOAP */
public class DemandePret {
		private double montant;
		private int duree; //nombre d'années
		
	
		public DemandePret() {
			super();
		}

		public DemandePret(double montant, int duree) {
			super();
			this.montant = montant;
			this.duree = duree;
		}
		
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
		
		

}
