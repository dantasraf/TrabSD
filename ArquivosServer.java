

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public class ArquivosServer {
    
    
    ArquivosServer(){
    
        try{
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Registry r = LocateRegistry.createRegistry(1099);
            Arquivos a = new ArquivosImple();
            r.rebind("ArquivosService", a);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
     new ArquivosServer();
    }
    
}
