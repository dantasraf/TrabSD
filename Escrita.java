

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public class Escrita implements Runnable{
    
    private int idClient;
    private int numArquivo;
    private String texto;
    
    public Escrita(int id, int numArq, String texto){
        this.idClient = id;
        this.numArquivo = numArq;
        this.texto = texto;
        inicializa();
    }
    
    public void inicializa(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Registry r = LocateRegistry.getRegistry("127.0.0.1", 1099);
            Arquivos a = (Arquivos) r.lookup("ArquivosService");
            a.escrever(this.numArquivo, this.texto, this.idClient);
            System.err.println("O cliente " + this.idClient + " se conectou para ESCRITA no arquivo " + (this.numArquivo+1) + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
