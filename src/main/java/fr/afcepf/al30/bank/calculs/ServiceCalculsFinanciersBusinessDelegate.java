package fr.afcepf.al30.bank.calculs;

import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ServiceCalculsFinanciersBusinessDelegate implements IServiceCalculsFinanciers {
    private IServiceCalculsFinanciers proxyWsCalcul; //proxy vers WS distant
	private void initSoapProxy(){
		try {
			Properties props = new Properties(); //java.util
			props.load(Thread.currentThread()
					   .getContextClassLoader().getResourceAsStream("ws.properties"));
			String wsdlUrlAsString = props.getProperty("calculFinancier.wsdl");
			System.out.println("wsdlUrlAsString="+wsdlUrlAsString);
			URL wsdlUrl = new URL(wsdlUrlAsString);
			QName SERVICE_NAME = new QName("http://calculs.bank.al30.afcepf.fr/",
					                       "ServiceCalculsFinanciersImplService");
			QName PORT_NAME = new QName("http://calculs.bank.al30.afcepf.fr/",
                    "ServiceCalculsFinanciersImplPort");
			Service service = Service.create(wsdlUrl, SERVICE_NAME);
			this.proxyWsCalcul = (IServiceCalculsFinanciers)
			                 service.getPort(PORT_NAME, IServiceCalculsFinanciers.class);
		} catch (Exception e) {	e.printStackTrace();}
	}
	public ServiceCalculsFinanciersBusinessDelegate(){
		initSoapProxy();
	}
	@Override
	public double calculerMensualite(double montant, double nbMois, double tauxInteretAnnuel) {
		return proxyWsCalcul.calculerMensualite(montant, nbMois, tauxInteretAnnuel);
	}

}
