import java.io.IOException;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public interface Controle {
    
    public void leitor(int numArq, int numClient, int inicio) throws InterruptedException, IOException;
    
    public void escritor(int numArq, int numClient, String texto) throws InterruptedException, IOException;
}
