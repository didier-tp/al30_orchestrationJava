package fr.afcepf.al30.emprunt;

import javax.jws.WebService;

import fr.afcepf.al30.bank.calculs.IServiceCalculsFinanciers;
import fr.afcepf.al30.bank.calculs.ServiceCalculsFinanciersBusinessDelegate;
import fr.afcepf.al30.bank.valeurs.IServiceTauxFrais;
import fr.afcepf.al30.bank.valeurs.ServiceTauxFraisBusinessDelegate;

/*
 * ce projet ne s'appuie que sur les interface jax-ws des services à appeler/orchestrer
 * içi récupérées par copier/coller mais idéalement avec dépendances maven vers sous projet interfaces
 * 
 * ==> bonne décomposition en sous projets:
 *    page 30 du support de cours UML/conception_avec_uml
 */


@WebService(endpointInterface="fr.afcepf.al30.emprunt.IServiceOffrePret")
public class ServiceOffrePretImpl implements IServiceOffrePret {
	
	private IServiceTauxFrais serviceTauxFrais = new ServiceTauxFraisBusinessDelegate();
	private IServiceCalculsFinanciers serviceCalculsFinanciers 
	                    = new ServiceCalculsFinanciersBusinessDelegate();

	@Override
	public OffrePret getOffrePret(DemandePret demandePret) {
		double tauxInteretAnnuel = serviceTauxFrais.getTauxInteret(demandePret.getDuree()*12);
		double mensualite = serviceCalculsFinanciers.calculerMensualite(demandePret.getMontant(),
				                                                        demandePret.getDuree()*12,
				                                                        tauxInteretAnnuel);
		double fraisDossier = serviceTauxFrais.getFraisDossier(demandePret.getMontant());
		OffrePret offrePret = new OffrePret();
		offrePret.setOk(true);
		offrePret.setMessage("offre de pret valable 2 mois");
		offrePret.setMontant(demandePret.getMontant());
		offrePret.setDuree(demandePret.getDuree());
		offrePret.setMensualite(mensualite);
		offrePret.setTauxInteret(tauxInteretAnnuel);
		offrePret.setFraisDossier(fraisDossier);
		return offrePret;
	}

}
