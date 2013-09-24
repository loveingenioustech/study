package rmi;

import java.rmi.*;

/**
 * The interface for remote product objects.
 */
public interface Product extends Remote {
	/**
	 * Gets the description of this product.
	 * 
	 * @return the product description
	 */
	String getDescription() throws RemoteException;
}
