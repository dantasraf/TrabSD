import java.io.IOException;
import java.util.concurrent.Semaphore;


/**
 *
 * @authors leonardo, matheus e rafael
 */
class ControlePrioLeitor implements Controle{
    
    private int qtdLeitores;
    private Semaphore acessoQtdLeitores;
    private Semaphore escrita;
    private Documento documento;
    
    public ControlePrioLeitor(Documento d){
        this.qtdLeitores = 0;
        this.documento = d;
        this.acessoQtdLeitores = new Semaphore(1);
        escrita = new Semaphore(1);
    }
    
    public void leitor(int numArquivo, int numClient, int inicio) throws InterruptedException, IOException{
        this.acessoQtdLeitores.acquire();
        //this.qtdLeitores++;
        if(this.qtdLeitores == 0)this.escrita.acquire();
        this.qtdLeitores++;
        this.acessoQtdLeitores.release();
        
        this.documento.ler(numArquivo, numClient, inicio, qtdLeitores);
        
        this.acessoQtdLeitores.acquire();
        this.qtdLeitores--;
        if(this.qtdLeitores == 0)this.escrita.release();
        this.acessoQtdLeitores.release();
    }
    
    public void escritor(int numArquivo, int numClient, String texto) throws InterruptedException, IOException{
        this.escrita.acquire();
        
        this.documento.escrever(numArquivo, numClient, texto, qtdLeitores);
        
        this.escrita.release();
    }
   
}
