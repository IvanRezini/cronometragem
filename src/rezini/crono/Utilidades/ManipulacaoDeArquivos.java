package rezini.crono.Utilidades;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
 *
 * @author Vilmar
 */
public class ManipulacaoDeArquivos {
    
    private String caminhoArquivo;
    private String nomeArquivo;
    
    public ManipulacaoDeArquivos(String caminho,String nome)
    {
        this.caminhoArquivo= caminho;
        this.nomeArquivo = nome;
    }
    public void gravar(String conteudo) throws IOException{   
                            
        try (FileWriter arquivoTxt = new FileWriter(this.caminhoArquivo+"/"+this.nomeArquivo,true)) {
            PrintWriter gravarArq = new PrintWriter(arquivoTxt);
                    gravarArq.println(conteudo);
    arquivoTxt.close();
            }
    }
      public  void sobreEscrever(String conteudo) throws IOException {   
                            
        try (FileWriter arquivoTxt = new FileWriter(this.caminhoArquivo+"/"+this.nomeArquivo)) {
            PrintWriter gravarArq = new PrintWriter(arquivoTxt);
        
                    gravarArq.println(conteudo);
    arquivoTxt.close();
        }
        }
      
     public String[] ler() throws IOException {

        FileReader arquivoTxt = new FileReader(this.caminhoArquivo + "/" + this.nomeArquivo);
        BufferedReader lerArq = new BufferedReader(arquivoTxt);

        String linha = lerArq.readLine();
        int contador = 0;
        while (linha != null) {
            contador++;
            linha = lerArq.readLine();
        }

        String[] conteudo = new String[contador];
        FileReader arquivo2 = new FileReader(this.caminhoArquivo + "/" + this.nomeArquivo);
        BufferedReader lerArqForArray = new BufferedReader(arquivo2);
        
        //Popula o array
        String novaLinha = lerArqForArray.readLine();
        contador = 0;
        while (novaLinha != null) {
            conteudo [contador] = novaLinha;
            contador++;            
            novaLinha = lerArqForArray.readLine();
        }
        
        return conteudo;
    }

    public String lerEmString() throws IOException
    {
        String conteudoArquivo[] = this.ler();
        String conteudo= "";
        for(int i = 0;i<conteudoArquivo.length; i++)
        {
         conteudo = conteudo + conteudoArquivo[i]+"\n";   
        }
        return conteudo;
         
    }
}



   
  