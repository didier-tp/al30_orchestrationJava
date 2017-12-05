package fr.afcepf.al30.bank.valeurs;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IServiceTauxFrais {
		public double getTauxInteret(@WebParam(name="nbMois") double nbMois);
		public double getFraisDossier(@WebParam(name="montant") double montant);
}
