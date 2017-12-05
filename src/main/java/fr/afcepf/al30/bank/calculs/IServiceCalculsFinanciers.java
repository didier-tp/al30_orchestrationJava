package fr.afcepf.al30.bank.calculs;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IServiceCalculsFinanciers {
	
	public double calculerMensualite(
			@WebParam(name="montant")double montant,
			@WebParam(name="nbMois")double nbMois,
			@WebParam(name="tauxInteretAnnuel")double tauxInteretAnnuel);
	//...

}
