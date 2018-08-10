/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Luan
 */
public class Afd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            FileReader arq = new FileReader("numeros.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
      // a variável "linha" recebe o valor "null" quando o processo
      // de repetição atingir o final do arquivo texto
            String[] estado = linha.split(" ");

            
            linha = lerArq.readLine(); // lê da segunda até a última linha
            String[] transicao = linha.split(" ");
            
            linha = lerArq.readLine();
            String[] s = linha.split(" ");
            
            linha = lerArq.readLine();
            String[] f = linha.split(" ");
            
            linha = lerArq.readLine();
            String[] delta = linha.split(" ");
                        
            for(int i=2;i<delta.length;i++){
                delta[i] = delta[i].replace("(", "");
                delta[i] = delta[i].replace(")", "");
            }
            
            System.out.print("Estados: ");
            for(int i =2;i<estado.length;i++){
                System.out.print(estado[i]+" ");
            }
            System.out.println("");
            System.out.print("Transição: ");
            for(int i =2;i<transicao.length;i++){
                System.out.print(transicao[i]+" ");
            }
            System.out.println("");
            System.out.print("S: ");
            for(int i =2;i<s.length;i++){
                System.out.print(s[i]+" ");
            }
            System.out.println("");
            System.out.print("F: ");
            for(int i =2;i<f.length;i++){
                System.out.print(f[i]+" ");
            }
            
            
            String parte1 = "package exerciciopseudocodigoafd;\n" +
                            "import java.io.BufferedReader;\n" +
                            "import java.io.IOException;\n" +
                            "import java.io.InputStreamReader;\n" +
                            "import java.util.logging.Level;\n" +
                            "import java.util.logging.Logger;\n" +
                            "/**\n" +
                            " *\n" +
                            " * @author jcarlos\n" +
                            " */\n" +
                            "public class ExercicioPseudoCodigoAFD {\n" +
                            "    \n" +
                            "    public static void main(String[] args) {\n" +
                            "        ExercicioPseudoCodigoAFD epc = new ExercicioPseudoCodigoAFD();\n" +
                            "        String s  = epc.leEntrada();\n" +
                            "        epc.runAFD(s);\n" +
                            "        \n" +
                            "    }\n" +
                            "    \n" +
                            "    \n" +
                            "    private String leEntrada() {\n" +
                            "        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));\n" +
                            "        String string = null;\n" +
                            "        try {\n" +
                            "            string = reader.readLine();\n" +
                            "            System.out.println(\"Cadeia para processar: \"+string);\n" +
                            "        } catch (IOException ex) {\n" +
                            "            System.exit(0);\n" +
                            "        }\n" +
                            "        return string;\n" +
                            "    }\n" +
                            "    \n" +
                            "    private boolean runAFD(String s) {\n" +
                            "       int estado = 1;\n" +
                            "       char c;\n" +
                            "       int i = 0;\n" +
                            "       while (i<s.length()) {\n" +
                            "           c = s.charAt(i);\n" +
                            "           switch (estado) {";
            
            String parte3 = "           }\n" +
                            "           i++;\n" +
                            "       }";
            
            String parte5 = "       }\n" +
                            "    \n" +
                            "}";
            
            FileWriter arquivo = new FileWriter("/home/oliver/Desktop/geraAFD/afd/afdNumeros.java");
            PrintWriter gravarArq = new PrintWriter(arquivo);
            
            gravarArq.println(parte1);
            
            //parte 2
            for(int i = 2;i < estado.length; i++){
                gravarArq.println("\t\tcase "+estado[i]+":");
                gravarArq.println("\t\t\tswitch (c){");
                for(int j = 2;j < transicao.length;j++){
                    gravarArq.println("\t\t\t\tcase '"+transicao[j]+"':");
                    for(int k = 2; k < delta.length; k++){
                        String temp[] = delta[k].split(",");
                        if(temp[0].equals(estado[i]) && temp[1].equals(transicao[j])){
                            gravarArq.println("\t\t\t\testado = "+temp[2]+";");
                            gravarArq.println("\t\t\t\tbreak;");
                        }
                    }
                }
                gravarArq.println("\t\t\t}");
                gravarArq.println("\t\t\tbreak;");
            }
            //--------
            gravarArq.println(parte3);
            //parte 4
            gravarArq.println("\tif(estado == "+f[2]+"){");
            gravarArq.println("\t\treturn true;");
            for(int i =3;i<f.length;i++){
                gravarArq.println("\t}else if(estado == "+f[i]+"){");
                 gravarArq.println("\t\treturn true;");
            }
             gravarArq.println("\t}else{");
             gravarArq.println("return false; }");
                
            //parte 5
            gravarArq.print(parte5);
            
            arquivo.close();
            

            arq.close();
          } catch (IOException e) {
              System.err.printf("Erro na abertura do arquivo: %s.\n",
                e.getMessage());
          }

        System.out.println();
    }
    
}
