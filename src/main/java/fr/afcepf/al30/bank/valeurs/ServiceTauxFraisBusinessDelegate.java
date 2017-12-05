package fr.afcepf.al30.bank.valeurs;

import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al30.bank.calculs.IServiceCalculsFinanciers;

public class ServiceTauxFraisBusinessDelegate implements IServiceTauxFrais {
	private IServiceTauxFrais proxyWsTauxFrais; //proxy vers WS distant
	private void initSoapProxy(){
		try {
			Properties props = new Properties(); //java.util
			props.load(Thread.currentThread()
					   .getContextClassLoader().getResourceAsStream("ws.properties"));
			String wsdlUrlAsString = props.getProperty("tauxFrais.wsdl");
			System.out.println("wsdlUrlAsString="+wsdlUrlAsString);
			URL wsdlUrl = new URL(wsdlUrlAsString);
			QName SERVICE_NAME = new QName("http://valeurs.bank.al30.afcepf.fr/",
					                       "ServiceTauxFraisImplService");
			QName PORT_NAME = new QName("http://valeurs.bank.al30.afcepf.fr/",
                    "ServiceTauxFraisImplPort");
			Service service = Service.create(wsdlUrl, SERVICE_NAME);
			this.proxyWsTauxFrais = (IServiceTauxFrais)
			                 service.getPort(PORT_NAME, IServiceTauxFrais.class);
		} catch (Exception e) {	e.printStackTrace();}
	}
	public ServiceTauxFraisBusinessDelegate(){
		initSoapProxy();
	}
	@Override
	public double getTauxInteret(double nbMois) {
		return proxyWsTauxFrais.getTauxInteret(nbMois);
	}

	@Override
	public double getFraisDossier(double montant) {
		return proxyWsTauxFrais.getFraisDossier(montant);
	}

}
