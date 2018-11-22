

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public class ControleSemPrio implements Controle{
    private int qtdLeitores;
    private Semaphore acessoQtdLeitores;
    private Semaphore escrita;
    private Semaphore ordem;
    private Documento documento;
    
    public ControleSemPrio(Documento d){
        this.qtdLeitores = 0;
        this.documento = d;
        this.acessoQtdLeitores = new Semaphore(1);
        this.ordem = new Semaphore(1, true);
        escrita = new Semaphore(1);
    }
    
    @Override
    public void leitor(int numArquivo, int numClient, int inicio) throws InterruptedException, IOException{
        this.ordem.acquire();
        this.ordem.release();
        this.acessoQtdLeitores.acquire();
        this.qtdLeitores++;
        if(this.qtdLeitores == 1)this.escrita.acquire();
        //this.qtdLeitores++;
        
        this.acessoQtdLeitores.release();
        
        
        this.documento.ler(numArquivo, numClient, inicio, qtdLeitores);
        
        this.acessoQtdLeitores.acquire();
        this.qtdLeitores--;
        if(this.qtdLeitores == 0)this.escrita.release();
        this.acessoQtdLeitores.release();
        
    }
    
    @Override
    public void escritor(int numArquivo, int numClient, String texto) throws InterruptedException, IOException{
        this.ordem.acquire();
        this.escrita.acquire();
        
        
        this.documento.escrever(numArquivo, numClient, texto, qtdLeitores);
        
        this.escrita.release();
        this.ordem.release();
    }
}
