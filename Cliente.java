import java.util.Random;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public class Cliente {
    
    private int id;
    
    public Cliente(int id){
        this.id = id;
    }
    
    
    public void realizaRequisicao(){
        Random r = new Random();
        int a = r.nextInt(100);
        int numArq = r.nextInt(3);
        
        if(a < 40){
            new Escrita(this.id, numArq, "\nLinha Nova");
        }
        else{
            int pos = r.nextInt(30);
            new Leitura(this.id, numArq, pos);
        }
    }
    
}
