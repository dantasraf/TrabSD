import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public class GerenciaDoc {

    private ArrayList<Controle> controles;

    public GerenciaDoc(int tpPrio) {
        controles = new ArrayList<>();

        if(tpPrio == 1){
            System.err.println("Servidor Rondando no Modo Priodidade ao Leitor\n");
            controles.add((Controle) new ControlePrioLeitor(new Documento("end0")));
            controles.add((Controle) new ControlePrioLeitor(new Documento("end1")));
            controles.add((Controle) new ControlePrioLeitor(new Documento("end2")));
        }
        else{
            System.err.println("Servidor Rodando no Modo Sem Prioridade\n");
            controles.add((Controle) new ControleSemPrio(new Documento("end0")));
            controles.add((Controle) new ControleSemPrio(new Documento("end1")));
            controles.add((Controle) new ControleSemPrio(new Documento("end2")));
        }
    }

    public void ler(int numArquivo, int numClient, int inicio) throws IOException {
        Controle controle = controles.get(numArquivo);
        try {
            controle.leitor(numArquivo, numClient, inicio);
        } catch (InterruptedException ex) {
            Logger.getLogger(GerenciaDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escrever(int numArquivo, int numClient, String texto) throws IOException{
        Controle controle = controles.get(numArquivo);
        try {
            controle.escritor(numArquivo, numClient, texto);
        } catch (InterruptedException ex) {
            Logger.getLogger(GerenciaDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
