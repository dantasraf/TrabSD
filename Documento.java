

import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @authors leonardo, matheus e rafael
 */
public class Documento {
    
    private String endereco;
    
    public Documento(String endereco){
        this.endereco = endereco;
    }
    
    public String ler(int numArquivo, int numClient, int inicio, int qtdLeitores) throws IOException{
        processar(new Random().nextInt(100)*100);
        
        String nomeArq = new String();
        
        switch (numArquivo){
            case 0: nomeArq = "arquivo1.txt";
                            break;
            case 1: nomeArq = "arquivo2.txt";
                            break;
            case 2: nomeArq = "arquivo3.txt";                    
        }
        
        String texto = new String();
        BufferedReader in = null;
        
        try {
            in = new BufferedReader(new FileReader(nomeArq));
            while (inicio >= 0){
                texto = in.readLine();
                inicio--;
            }
            System.out.println((char)27 + "[31m" + "Quantidade de leitores: " + qtdLeitores + "\n" + 
            "O cliente " + numClient + " leu -" + texto + "- do arquivo " + (numArquivo+1) + "\n");
        }
        catch (Exception e){
            System.err.println(e);
        }
        finally {
            in.close();
        }
        
        return "";
        
    }
    
    public void escrever(int numArquivo, int numClient, String texto, int qtdLeitores) throws IOException{
        processar(new Random().nextInt(100)*100);
        String nomeArq = new String();
        
        switch (numArquivo){
            case 0: nomeArq = "arquivo1.txt";
                            break;
            case 1: nomeArq = "arquivo2.txt";
                            break;
            case 2: nomeArq = "arquivo3.txt";                    
        }
        
        RandomAccessFile RAF = null;
        
        try{
            RAF = new RandomAccessFile(nomeArq, "rw");
            RAF.seek(RAF.length());
            RAF.writeUTF(texto);
            System.out.println((char)27 + "[31m" + "Quantidade de leitores: " + qtdLeitores + "\n" +
            "O cliente " + numClient + " escreveu no arquivo " + (numArquivo+1) + "\n");
        }
        catch (Exception e){
            System.err.println("e");
        }
        finally{
            RAF.close();
        }
    }
    
    public void processar(long temp){
        try {
            Thread.sleep(temp);
        } catch (InterruptedException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
