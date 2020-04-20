/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.Utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ivan rezini
 */
public class ObterData {
    

     public static String obterData(String mascara) {

        Date data = new Date();
        if (mascara == null) {
            mascara = "yyyy-MM-dd";
        }
        SimpleDateFormat formatador = new SimpleDateFormat(mascara);
        String dataTxt = formatador.format(data);

        return dataTxt;
        
   
  
}
     
       public void inserirData(){
        
        
            
        }
    
        }

