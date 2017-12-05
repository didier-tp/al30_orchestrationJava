package fr.afcepf.al30.emprunt;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IServiceOffrePret {
	public OffrePret getOffrePret(@WebParam(name="demandePret")DemandePret demandePret);
	//...
}
