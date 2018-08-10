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
				case 'a':
				estado = 2;
				break;
				case 'b':
				estado = 2;
				break;
				case 'c':
				estado = 2;
				break;
				case 'd':
				estado = 2;
				break;
				case 'e':
				estado = 2;
				break;
				case 'f':
				estado = 2;
				break;
				case 'g':
				estado = 2;
				break;
				case 'h':
				estado = 2;
				break;
				case 'i':
				estado = 2;
				break;
				case 'j':
				estado = 2;
				break;
				case 'k':
				estado = 2;
				break;
				case 'l':
				estado = 2;
				break;
				case 'm':
				estado = 2;
				break;
				case 'n':
				estado = 2;
				break;
				case 'o':
				estado = 2;
				break;
				case 'p':
				estado = 2;
				break;
				case 'q':
				estado = 2;
				break;
				case 'r':
				estado = 2;
				break;
				case 's':
				estado = 2;
				break;
				case 't':
				estado = 2;
				break;
				case 'u':
				estado = 2;
				break;
				case 'v':
				estado = 2;
				break;
				case 'x':
				estado = 2;
				break;
				case 'w':
				estado = 2;
				break;
				case 'y':
				estado = 2;
				break;
				case 'z':
				estado = 2;
				break;
                default:
                return false;
			}
			break;
		case 2:
			switch (c){
				case 'a':
				estado = 3;
				break;
				case 'b':
				estado = 3;
				break;
				case 'c':
				estado = 3;
				break;
				case 'd':
				estado = 3;
				break;
				case 'e':
				estado = 3;
				break;
				case 'f':
				estado = 3;
				break;
				case 'g':
				estado = 3;
				break;
				case 'h':
				estado = 3;
				break;
				case 'i':
				estado = 3;
				break;
				case 'j':
				estado = 3;
				break;
				case 'k':
				estado = 3;
				break;
				case 'l':
				estado = 3;
				break;
				case 'm':
				estado = 3;
				break;
				case 'n':
				estado = 3;
				break;
				case 'o':
				estado = 3;
				break;
				case 'p':
				estado = 3;
				break;
				case 'q':
				estado = 3;
				break;
				case 'r':
				estado = 3;
				break;
				case 's':
				estado = 3;
				break;
				case 't':
				estado = 3;
				break;
				case 'u':
				estado = 3;
				break;
				case 'v':
				estado = 3;
				break;
				case 'x':
				estado = 3;
				break;
				case 'w':
				estado = 3;
				break;
				case 'y':
				estado = 3;
				break;
				case 'z':
				estado = 3;
				break;
                default:
                return false;
			}
			break;
		case 3:
			switch (c){
				case 'a':
				estado = 4;
				break;
				case 'b':
				estado = 4;
				break;
				case 'c':
				estado = 4;
				break;
				case 'd':
				estado = 4;
				break;
				case 'e':
				estado = 4;
				break;
				case 'f':
				estado = 4;
				break;
				case 'g':
				estado = 4;
				break;
				case 'h':
				estado = 4;
				break;
				case 'i':
				estado = 4;
				break;
				case 'j':
				estado = 4;
				break;
				case 'k':
				estado = 4;
				break;
				case 'l':
				estado = 4;
				break;
				case 'm':
				estado = 4;
				break;
				case 'n':
				estado = 4;
				break;
				case 'o':
				estado = 4;
				break;
				case 'p':
				estado = 4;
				break;
				case 'q':
				estado = 4;
				break;
				case 'r':
				estado = 4;
				break;
				case 's':
				estado = 4;
				break;
				case 't':
				estado = 4;
				break;
				case 'u':
				estado = 4;
				break;
				case 'v':
				estado = 4;
				break;
				case 'x':
				estado = 4;
				break;
				case 'w':
				estado = 4;
				break;
				case 'y':
				estado = 4;
				break;
				case 'z':
				estado = 4;
				break;
                default:
                return false;
			}
			break;
		case 4:
			switch (c){
				case 'a':
				estado = 4;
				break;
				case 'b':
				estado = 4;
				break;
				case 'c':
				estado = 4;
				break;
				case 'd':
				estado = 4;
				break;
				case 'e':
				estado = 4;
				break;
				case 'f':
				estado = 4;
				break;
				case 'g':
				estado = 4;
				break;
				case 'h':
				estado = 4;
				break;
				case 'i':
				estado = 4;
				break;
				case 'j':
				estado = 4;
				break;
				case 'k':
				estado = 4;
				break;
				case 'l':
				estado = 4;
				break;
				case 'm':
				estado = 4;
				break;
				case 'n':
				estado = 4;
				break;
				case 'o':
				estado = 4;
				break;
				case 'p':
				estado = 4;
				break;
				case 'q':
				estado = 4;
				break;
				case 'r':
				estado = 4;
				break;
				case 's':
				estado = 4;
				break;
				case 't':
				estado = 4;
				break;
				case 'u':
				estado = 4;
				break;
				case 'v':
				estado = 4;
				break;
				case 'x':
				estado = 4;
				break;
				case 'w':
				estado = 4;
				break;
				case 'y':
				estado = 4;
				break;
				case 'z':
				estado = 4;
				break;
                default:
                return false;
			}
			break;
           }
           i++;
       }
	if(estado == 4){
		return true;
	}else{
                return false; }
       }
    
}
