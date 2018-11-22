import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public class ArquivosImple extends UnicastRemoteObject implements Arquivos {

    private GerenciaDoc gerenciador;

    protected ArquivosImple() throws RemoteException {
        super();
        this.gerenciador = new GerenciaDoc(2);/* tp prioridade: 1 - Prioridade Leitor
                                                                2 - Sem Prioridade*/                                        
    }

    @Override
    public String ler(int numArq, int numClient, int inicio) throws RemoteException {
        try {
            gerenciador.ler(numArq, numClient, inicio);
        } catch (IOException ex) {
            Logger.getLogger(ArquivosImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @Override
    public void escrever(int numArq, String texto, int numClient) throws RemoteException {
        try {
            this.gerenciador.escrever(numArq, numClient, texto);
        } catch (IOException ex) {
            Logger.getLogger(ArquivosImple.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
