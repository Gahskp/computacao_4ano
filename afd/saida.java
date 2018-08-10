package exercicioscompiladores;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jcarlos
 */
public class ExercicioPseudoCodigoAFD {
    
    public static void main(String[] args) {
        ExercicioPseudoCodigoAFD epc = new ExercicioPseudoCodigoAFD();
        String s  = epc.leEntrada();
        epc.runAFD(s);
        
    }
    
    
    private String leEntrada() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try {
            string = reader.readLine();
            System.out.println("Cadeia para processar: "+string);
        } catch (IOException ex) {
            System.exit(0);
        }
        return string;
    }
    
    private void runAFD(String s) {
       int estado = 1;
       char c;
       int i = 0;
       while (i<s.length()) {
           c = s.charAt(i);
           switch (estado) {case: 1
   switch (c)
      case: a
         estado = 2
         break;
      case: b
         estado = 3
         break;
      break;
case: 2
   switch (c)
      case: a
         estado = 2
         break;
      case: b
         estado = 2
         break;
      break;
case: 3
   switch (c)
      case: a
         estado = 2
         break;
      case: b
         estado = 4
         break;
      break;
case: 4
   switch (c)
      case: a
         estado = 3
         break;
      case: b
         estado = 3
         break;
      break;
}
           i++;
       }   if(estado.equals(2){
      System.out.print("String Reconhecida");
   }else if(estado.equals(4){
      System.out.print("String Reconhecida");
     }else{
      System.out.print("String Não Reconhecida"); }
}
    
}