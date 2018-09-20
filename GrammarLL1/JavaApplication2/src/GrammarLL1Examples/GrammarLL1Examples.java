/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrammarLL1Examples;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oliver
 */
public class GrammarLL1Examples {
    
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
        AdvancePointer();
        if(NextChar() != 'e') return false;
        AdvancePointer();
        if(NextChar() != 'g') return false;
        AdvancePointer();
        if(NextChar() != 'i') return false;
        AdvancePointer();
        if(NextChar() != 'n') return false;
        return true;
    }
    
    static boolean input(){
        AdvancePointer();
        if(NextChar() != 'n') return false;
        AdvancePointer();
        if(NextChar() != 'p') return false;
        AdvancePointer();
        if(NextChar() != 'u') return false;
        AdvancePointer();
        if(NextChar() != 't') return false;
        return true;
    }
    
    static boolean print(){
        AdvancePointer();
        if(NextChar() != 'r') return false;
        AdvancePointer();
        if(NextChar() != 'i') return false;
        AdvancePointer();
        if(NextChar() != 'n') return false;
        AdvancePointer();
        if(NextChar() != 't') return false;
        return true;
    }
    
    static void P() throws Exception
    {
        if(NextChar() == 'b' && begin());
        else throw new Exception();
        System.out.println("P -> begin L end");
        L();
        //Verificar o estado final "end"
    }

    static void L()
    {
      System.out.println("L -> CL | vazio");
        try {
            C();
        } catch (Exception ex) {
            Logger.getLogger(GrammarLL1Examples.class.getName()).log(Level.SEVERE, null, ex);
        }
      L();
    }
    
    static boolean id(){
        AdvancePointer();
        if(NextChar() == 'x') return true;
        if(NextChar() == 'y') return true;
        if(NextChar() == 'z') return true;
        return false;
    }
    
    static void C() throws Exception{
        String rule;
        
        if(id()) rule = "id";
        else AdvancePointer(); if(NextChar() == 'i' && input()) rule = "input";
        else AdvancePointer(); if(NextChar() == 'p' && print()) rule = "print";
        else rule = "~";
        
        switch(rule)
        {
            case "id": break;
            case "input": break;
            case "print": break;
            case "~": break;
        }
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


