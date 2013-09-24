package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;

import org.omg.CORBA.ORB;

/**
 * This programs shows all RMI bindings.
 */
public class RMIDemo {
	public static void main(String[] args) {
		RMIDemo demo = new RMIDemo();

		demo.showRMIBindings();

		demo.showORBServices(args);
	}

	private void showORBServices(String[] args) {
		ORB orb = ORB.init(args, null);
		String[] services = orb.list_initial_services();
		for (int i = 0; i < services.length; i++)
			System.out.println(services[i]);
	}

	private void showRMIBindings() {
		try {
			Context namingContext = new InitialContext();
			NamingEnumeration<NameClassPair> e = namingContext.list("rmi:");
			while (e.hasMore())
				System.out.println(e.next().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
