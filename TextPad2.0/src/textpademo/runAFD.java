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
    
    public boolean runAFDAtribuicao(String s) {
        int estado = 1;
        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            switch (estado) {
                case 1:
                    switch (c) {
                        case '=':
                            estado = 2;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 2:
                    switch (c) {
                        case '=':
                        default:
                            return false;
                    }
            }
            i++;
        }
        if (estado == 2) {
            System.out.println("AFD Atribuição: String Reconhecida");
            return true;
        } else {
            System.out.println("AFD Atribuição: String Não Reconhecida");
            return false;
        }
    }

    public boolean runAFDConstante(String s) {
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
            System.out.println("AFD Constante: String Reconhecida");
            return true;
        } else if (estado == 3) {
            System.out.println("AFD Constante: String Reconhecida");
            return true;
        } else {
            System.out.println("AFD Constante: String Não Reconhecida");
            return false;
        }
    }

    public boolean runAFDAritmeticos(String s) {
        int estado = 1;
        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            switch (estado) {
                case 1:
                    switch (c) {
                        case '+':
                            estado = 2;
                            break;
                        case '-':
                            estado = 2;
                            break;
                        case '/':
                            estado = 2;
                            break;
                        case '*':
                            estado = 2;
                            break;
                        case '%':
                            estado = 2;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 2:
                    switch (c) {
                        case '+':
                        case '-':
                        case '/':
                        case '*':
                        case '%':
                        default:
                            return false;
                    }
            }
            i++;
        }
        if (estado == 2) {
            System.out.println("AFD Aritmético: String Reconhecida");
            return true;
        } else {
            System.out.println("AFD Aritmético: String Não Reconhecida");
            return false;
        }
    }

    public boolean runAFDParavrasReservadas(String s) {
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
            System.out.println("AFD Palavras Reservadas: String Reconhecida");
            return true;
        } else {
            System.out.println("AFD Palavras Reservadas: String Não Reconhecida");
            return false;
        }
    }

    public boolean runAFDOpLog(String s) {
        int estado = 1;
        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            switch (estado) {
                case 1:
                    switch (c) {
                        case 'a':
                            estado = 15;
                            break;
                        case 'n':
                            estado = 3;
                            break;
                        case 'o':
                            estado = 2;
                            break;
                        case '^':
                            estado = 4;
                            break;
                        case '~':
                            estado = 8;
                            break;
                        case '<':
                            estado = 6;
                            break;
                        case '>':
                            estado = 5;
                            break;
                        case '=':
                            estado = 7;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 2:
                    switch (c) {
                        case 'r':
                            estado = 11;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 3:
                    switch (c) {
                        case 'o':
                            estado = 12;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 4:
                    switch (c) {
                        default:
                            return false;
                    }

                case 5:
                    switch (c) {
                        case '=':
                            estado = 14;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 6:
                    switch (c) {
                        case '=':
                            estado = 14;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 7:
                    switch (c) {
                        case '=':
                            estado = 14;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 8:
                    switch (c) {
                        case '=':
                            estado = 14;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 9:
                    switch (c) {
                        case 'd':
                            estado = 10;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 10:
                    switch (c) {
                        default:
                            return false;
                    }

                case 11:
                    switch (c) {
                        default:
                            return false;
                    }

                case 12:
                    switch (c) {
                        case 't':
                            estado = 13;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 13:
                    switch (c) {
                        default:
                            return false;
                    }

                case 14:
                    switch (c) {
                        default:
                            return false;
                    }

                case 15:
                    switch (c) {
                        case 'n':
                            estado = 9;
                            break;
                        default:
                            return false;
                    }
                    break;
            }
            i++;
        }
        if (estado == 10) {
            System.out.println("AFD Operadores lógicos: String Reconhecida");
            return true;
        } else if (estado == 11) {
            System.out.println("AFD Operadores lógicos: String Reconhecida");
            return true;
        } else if (estado == 13) {
            System.out.println("AFD Operadores lógicos: String Reconhecida");
            return true;
        } else if (estado == 4) {
            System.out.println("AFD Operadores lógicos: String Reconhecida");
            return true;
        } else if (estado == 5) {
            System.out.println("AFD Operadores lógicos: String Reconhecida");
            return true;
        } else if (estado == 6) {
            System.out.println("AFD Operadores lógicos: String Reconhecida");
            return true;
        } else if (estado == 14) {
            System.out.println("AFD Operadores lógicos: String Reconhecida");
            return true;
        } else {
            System.out.println("AFD Operadores lógicos: String Não Reconhecida");
            return false;
        }
    }

    public boolean runAFDString(String s) {
        int estado = 1;
        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            switch (estado) {
                case 1:
                    switch (c) {
                        case '"':
                            estado = 2;
                            break;
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'x':
                        case 'w':
                        case 'y':
                        case 'z':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'X':
                        case 'W':
                        case 'Y':
                        case 'Z':
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
                        case '!':
                        case '@':
                        case '#':
                        case '$':
                        case '%':
                        case '&':
                        case '*':
                        case '(':
                        case ')':
                        case '_':
                        case '-':
                        case '=':
                        case '+':
                        case '[':
                        case '{':
                        case '}':
                        case ']':
                        case '^':
                        case '~':
                        case '/':
                        case '?':
                        case ';':
                        case ':':
                        case ',':
                        case '.':
                        case '<':
                        case '>':
                        case '|':
                        default:
                            return false;
                    }
                    break;
                case 2:
                    switch (c) {
                        case '"':
                            estado = 3;
                            break;
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
                        case 'A':
                            estado = 2;
                            break;
                        case 'B':
                            estado = 2;
                            break;
                        case 'C':
                            estado = 2;
                            break;
                        case 'D':
                            estado = 2;
                            break;
                        case 'E':
                            estado = 2;
                            break;
                        case 'F':
                            estado = 2;
                            break;
                        case 'G':
                            estado = 2;
                            break;
                        case 'H':
                            estado = 2;
                            break;
                        case 'I':
                            estado = 2;
                            break;
                        case 'J':
                            estado = 2;
                            break;
                        case 'K':
                            estado = 2;
                            break;
                        case 'L':
                            estado = 2;
                            break;
                        case 'M':
                            estado = 2;
                            break;
                        case 'N':
                            estado = 2;
                            break;
                        case 'O':
                            estado = 2;
                            break;
                        case 'P':
                            estado = 2;
                            break;
                        case 'Q':
                            estado = 2;
                            break;
                        case 'R':
                            estado = 2;
                            break;
                        case 'S':
                            estado = 2;
                            break;
                        case 'T':
                            estado = 2;
                            break;
                        case 'U':
                            estado = 2;
                            break;
                        case 'V':
                            estado = 2;
                            break;
                        case 'X':
                            estado = 2;
                            break;
                        case 'W':
                            estado = 2;
                            break;
                        case 'Y':
                            estado = 2;
                            break;
                        case 'Z':
                            estado = 2;
                            break;
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
                        case '!':
                            estado = 2;
                            break;
                        case '@':
                            estado = 2;
                            break;
                        case '#':
                            estado = 2;
                            break;
                        case '$':
                            estado = 2;
                            break;
                        case '%':
                            estado = 2;
                            break;
                        case '�':
                            estado = 2;
                            break;
                        case '&':
                            estado = 2;
                            break;
                        case '*':
                            estado = 2;
                            break;
                        case '(':
                        case ')':
                        case '_':
                            estado = 2;
                            break;
                        case '-':
                            estado = 2;
                            break;
                        case '=':
                            estado = 2;
                            break;
                        case '+':
                            estado = 2;
                            break;
                        case '[':
                            estado = 2;
                            break;
                        case '{':
                            estado = 2;
                            break;
                        case '}':
                            estado = 2;
                            break;
                        case ']':
                            estado = 2;
                            break;
                        case '^':
                            estado = 2;
                            break;
                        case '~':
                            estado = 2;
                            break;
                        case '/':
                            estado = 2;
                            break;
                        case '?':
                            estado = 2;
                            break;
                        case ';':
                            estado = 2;
                            break;
                        case ':':
                            estado = 2;
                            break;
                        case ',':
                        case '.':
                            estado = 2;
                            break;
                        case '<':
                            estado = 2;
                            break;
                        case '>':
                            estado = 2;
                            break;
                        case '|':
                            estado = 2;
                            break;
                        default:
                            estado = 2;
                    }
                    break;
                case 3:
                    switch (c) {
                        case '"':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'x':
                        case 'w':
                        case 'y':
                        case 'z':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'X':
                        case 'W':
                        case 'Y':
                        case 'Z':
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
                        case '!':
                        case '@':
                        case '#':
                        case '$':
                        case '%':
                        case '&':
                        case '*':
                        case '(':
                        case ')':
                        case '_':
                        case '-':
                        case '=':
                        case '+':
                        case '[':
                        case '{':
                        case '}':
                        case ']':
                        case '^':
                        case '~':
                        case '/':
                        case '?':
                        case ';':
                        case ':':
                        case ',':
                        case '.':
                        case '<':
                        case '>':
                        case '|':
                        default:
                            return false;
                    }
            }
            i++;
        }
        if (estado == 3) {
            System.out.println("AFD String: String Reconhecida");
            return true;
        } else {
            System.out.println("AFD String: String Não Reconhecida");
            return false;
        }
    }

    public boolean runAFDIdentificadores(String s) {
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
                        case 'A':
                            estado = 2;
                            break;
                        case 'B':
                            estado = 2;
                            break;
                        case 'C':
                            estado = 2;
                            break;
                        case 'D':
                            estado = 2;
                            break;
                        case 'E':
                            estado = 2;
                            break;
                        case 'F':
                            estado = 2;
                            break;
                        case 'G':
                            estado = 2;
                            break;
                        case 'H':
                            estado = 2;
                            break;
                        case 'I':
                            estado = 2;
                            break;
                        case 'J':
                            estado = 2;
                            break;
                        case 'K':
                            estado = 2;
                            break;
                        case 'L':
                            estado = 2;
                            break;
                        case 'M':
                            estado = 2;
                            break;
                        case 'N':
                            estado = 2;
                            break;
                        case 'O':
                            estado = 2;
                            break;
                        case 'P':
                            estado = 2;
                            break;
                        case 'Q':
                            estado = 2;
                            break;
                        case 'R':
                            estado = 2;
                            break;
                        case 'S':
                            estado = 2;
                            break;
                        case 'T':
                            estado = 2;
                            break;
                        case 'U':
                            estado = 2;
                            break;
                        case 'V':
                            estado = 2;
                            break;
                        case 'X':
                            estado = 2;
                            break;
                        case 'W':
                            estado = 2;
                            break;
                        case 'Y':
                            estado = 2;
                            break;
                        case 'Z':
                            estado = 2;
                            break;
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
                        case '_':
                            estado = 2;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 2:
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
                        case 'A':
                            estado = 2;
                            break;
                        case 'B':
                            estado = 2;
                            break;
                        case 'C':
                            estado = 2;
                            break;
                        case 'D':
                            estado = 2;
                            break;
                        case 'E':
                            estado = 2;
                            break;
                        case 'F':
                            estado = 2;
                            break;
                        case 'G':
                            estado = 2;
                            break;
                        case 'H':
                            estado = 2;
                            break;
                        case 'I':
                            estado = 2;
                            break;
                        case 'J':
                            estado = 2;
                            break;
                        case 'K':
                            estado = 2;
                            break;
                        case 'L':
                            estado = 2;
                            break;
                        case 'M':
                            estado = 2;
                            break;
                        case 'N':
                            estado = 2;
                            break;
                        case 'O':
                            estado = 2;
                            break;
                        case 'P':
                            estado = 2;
                            break;
                        case 'Q':
                            estado = 2;
                            break;
                        case 'R':
                            estado = 2;
                            break;
                        case 'S':
                            estado = 2;
                            break;
                        case 'T':
                            estado = 2;
                            break;
                        case 'U':
                            estado = 2;
                            break;
                        case 'V':
                            estado = 2;
                            break;
                        case 'X':
                            estado = 2;
                            break;
                        case 'W':
                            estado = 2;
                            break;
                        case 'Y':
                            estado = 2;
                            break;
                        case 'Z':
                            estado = 2;
                            break;
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
                        case '_':
                            estado = 2;
                            break;
                        default:
                            return false;
                    }
                    break;
            }
            i++;
        }
        if (estado == 2) {
            System.out.println("AFD Identificadores: String Reconhecida");
            return true;
        } else {
            System.out.println("AFD Identificadores: String Não Reconhecida");
            return false;
        }
    }
    
}
