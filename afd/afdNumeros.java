package exerciciopseudocodigoafd;
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
    
    private boolean runAFD(String s) {
       int estado = 1;
       char c;
       int i = 0;
       while (i<s.length()) {
           c = s.charAt(i);
           switch (estado) {
		case 1:
			switch (c){
				case '0':
				estado = 2;
				break;
				case '1':
				estado = 2;
				break;
				case '2':
				estado = 2;
				break;
				case '3':
				estado = 2;
				break;
				case '4':
				estado = 2;
				break;
				case '5':
				estado = 2;
				break;
				case '6':
				estado = 2;
				break;
				case '7':
				estado = 2;
				break;
				case '8':
				estado = 2;
				break;
				case '9':
				estado = 2;
				break;
				case '.':
				estado = 4;
				break;
                                default:
                                return false;
			}
			break;
		case 2:
			switch (c){
				case '0':
				estado = 2;
				break;
				case '1':
				estado = 2;
				break;
				case '2':
				estado = 2;
				break;
				case '3':
				estado = 2;
				break;
				case '4':
				estado = 2;
				break;
				case '5':
				estado = 2;
				break;
				case '6':
				estado = 2;
				break;
				case '7':
				estado = 2;
				break;
				case '8':
				estado = 2;
				break;
				case '9':
				estado = 2;
				break;
				case '.':
				estado = 3;
				break;
                                default:
                                return false;
			}
			break;
		case 3:
			switch (c){
				case '0':
				estado = 3;
				break;
				case '1':
				estado = 3;
				break;
				case '2':
				estado = 3;
				break;
				case '3':
				estado = 3;
				break;
				case '4':
				estado = 3;
				break;
				case '5':
				estado = 3;
				break;
				case '6':
				estado = 3;
				break;
				case '7':
				estado = 3;
				break;
				case '8':
				estado = 3;
				break;
				case '9':
				estado = 3;
				break;
				case '.':
				estado = 4;
				break;
                                default:
                                return false;
			}
			break;
		case 4:
			switch (c){
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '.':
			}
			break;
           }
           i++;
       }
	if(estado == 2){
		return true;
	}else if(estado == 3){
		return true;
	}else{
		return false; }
       }
    
}
