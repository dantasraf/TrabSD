

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public interface Arquivos extends Remote{
    
    public String ler(int numArq, int numClient,int inicio) throws RemoteException;
    
    public void escrever(int numArq, String text, int numClient) throws RemoteException;
}
