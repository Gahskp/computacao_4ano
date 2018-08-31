/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

/**
 *
 * @author oliver
 */
public class JavaApplication2 {
    
    static String input;

    static String NextChar()
    {
      return input[0];
    }

    static void AdvancePointer()
    {
      input = input.Substring(1);
    }

    static void S()
    {
        System.out.println("S -> E");
      E();
    }

    static void E()
    {
      System.out.println("E -> TF");
      T();
      F();
    }

    static void F()
    {
      String rule;

      if(NextChar() == '+'){ 
          rule = "+";
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
        S();
        if(NextChar() == 's')
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
        input = s.next(".");
        System.out.println(Parse() ? "String Accepted" : "String Rejected");
    }
    
}


