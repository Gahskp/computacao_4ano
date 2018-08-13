/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textpademo;

/**
 *
 * @author oliver
 */
public class runAFD {
    
    public runAFD() {
        
    }
    
    public boolean runAFDNumeros(String s) {
        int estado = 1;
        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            switch (estado) {
                case 1:
                    switch (c) {
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
                    switch (c) {
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
                    switch (c) {
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
                    switch (c) {
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
        if (estado == 2) {
            return true;
        } else if (estado == 3) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean runAFDAlfabeto(String s) {
        int estado = 1;
        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            switch (estado) {
                case 1:
                    switch (c) {
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
                    switch (c) {
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
                    switch (c) {
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
                    switch (c) {
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
        if (estado == 4) {
            return true;
        } else {
            return false;
        }
    }
    
}
