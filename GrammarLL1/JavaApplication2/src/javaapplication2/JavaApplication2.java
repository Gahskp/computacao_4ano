/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oliver
 */
public class JavaApplication2 {
    
    static String input;

    static char NextChar()
    {
      return input.charAt(0);
    }

    static void AdvancePointer()
    {
      input = input.substring(1, input.length());
    }

    static boolean begin(){
        if(NextChar() != 'e') return false;
        if(NextChar() != 'g') return false;
        if(NextChar() != 'i') return false;
        if(NextChar() != 'n') return false;
        return true;
    }
    
    static void P() throws Exception
    {
        if(NextChar() == 'b' && begin());
        else throw new Exception();
        System.out.println("S -> E");
        E();
    }

    static void E()
    {
      System.out.println("E -> TF");
        try {
            T();
        } catch (Exception ex) {
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }
      F();
    }

    static void F()
    {
      String rule;

      if(NextChar() == '+'){ 
          rule = "+E";
      }else if(NextChar() == '*') rule ="*E";
      else rule = "~";

      System.out.println("F -> " + rule);
      switch(rule)
      {
        case "+E": AdvancePointer(); E(); break;
        case "*E": AdvancePointer(); E(); break;
        case "~": break;
      }
    }

    static void T() throws Exception
    {
      String rule;

      if(NextChar() == 'a') rule = "a";
      else if(NextChar() == 'b') rule = "b";
      else if(NextChar() == 'c') rule = "c";
      else if(NextChar() == '(') rule = "(E)";
      else throw new Exception();

        System.out.println("T -> " + rule);
      switch(rule)
      {
        case "a": AdvancePointer(); break;
        case "b": AdvancePointer(); break;
        case "c": AdvancePointer(); break;
        case "(E)": AdvancePointer();
          E();
          if(NextChar() != ')') throw new Exception();
          AdvancePointer();
          break;
      }
    }

    static Boolean Parse()
    {
      try
      {
        P();
        if(NextChar() == '$')
          return true;
      }
      catch(Exception e)
      {

      }

      return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        input = s.nextLine();
        System.out.println(Parse() ? "String Accepted" : "String Rejected");
    }
    
}


