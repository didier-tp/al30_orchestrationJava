package fr.afcepf.al30.app;

import javax.xml.ws.Endpoint;

import fr.afcepf.al30.emprunt.ServiceOffrePretImpl;

public class OrchestrationApp {

	public static void main(String[] args) {
		ServiceOffrePretImpl so = new ServiceOffrePretImpl();
		Endpoint.publish("http://localhost:8084/bank/service/offrePret", so);
		System.out.println("serveur offrePret en attente des requetes (8084)");
		try {
			Thread.sleep(15*60*1000); //arret automatique au bout de 15mn
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

}
