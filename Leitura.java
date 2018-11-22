import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public class Leitura implements Runnable{
    
    private int idClient;
    private int numArquivo;
    private int inicio;
    
    public Leitura(int id, int numArq, int inicio){
        this.idClient = id;
        this.numArquivo = numArq;
        this.inicio = inicio;
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
            a.ler(this.numArquivo, this.idClient, this.inicio);
            System.out.println("O cliente " + this.idClient + " se conectou para LEITURA no arquivo " + (this.numArquivo+1) + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}