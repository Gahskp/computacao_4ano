/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;


/**
 *
 * @author evert
 */
public class LFCTrabalhoFinal {


  public static void main(String[] arg) {

    Scanner scanner = new Scanner(arg[0]);

    //    Scanner scanner = new Scanner("C:\\Users\\evert\\Documents\\NetBeansProjects\\LFCTrabalhoFinal\\src\\lfctrabalhofinal\\Taste.tas");

    Parser parser = new Parser(scanner);
    parser.Parse();
    System.out.println(parser.errors.count + " errors detected");
  }
}
