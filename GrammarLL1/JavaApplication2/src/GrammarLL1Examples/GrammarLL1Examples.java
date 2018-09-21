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
    
    static boolean atribuicao(){
        AdvancePointer();
        if(NextChar() != '=') return false;        
        return true;
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
        if(NextChar() != 'r') return false;
        AdvancePointer();
        if(NextChar() != 'i') return false;
        AdvancePointer();
        if(NextChar() != 'n') return false;
        AdvancePointer();
        if(NextChar() != 't') return false;
        AdvancePointer();        
        return true;
    }
    
    static boolean end(){
        AdvancePointer();
        if(NextChar() != 'n') return false;
        AdvancePointer();
        if(NextChar() != 'd') return false;
        return true;
    }
    
    static boolean id(){
        if(NextChar() == 'x') return true;
        if(NextChar() == 'y') return true;
        if(NextChar() == 'z') return true;
        return false;
    }

    
    static void P() throws Exception
    {
        if(NextChar() == 'b' && begin());
        else throw new Exception();
        System.out.println("P -> begin L");
        
        try {
            L();
        } catch (Exception e) {
            throw new Exception();
        }
        
        Scanner s = new Scanner(System.in);
        input = s.nextLine();
        if(NextChar() == 'e' && end());
        else throw new Exception();
        System.out.println("P -> end");
    }
    
    

    static void L() throws Exception{
        Scanner s = new Scanner(System.in);
        input = s.nextLine();
        
        if(C()) System.out.println("L -> vazio");
        else{
            System.out.println("L -> CL");
            L();
        }
    }
    
    static boolean C() throws Exception{
        String rule;
        if(id()) rule = "id";
        else if(NextChar() == 'i' && input()) rule = "input";
        else if(NextChar() == 'p' && print()) rule = "print";
        else if(NextChar() == ' ') rule = "~";
        else throw new Exception();
            
        switch(rule)
        {
            case "id": 
                AdvancePointer();
                if(NextChar() == ':' && atribuicao()){
                    System.out.println("C -> id:= E");
                    E();
                    return false;
                } else throw new Exception();
            case "input": System.out.println("C -> input"); return false;
            case "print": System.out.println("C -> print"); return false;
            case "~": System.out.println("C -> ~"); return true;
        }
        return true;
    }
    
    static void E() throws Exception
    {
      System.out.println("E -> TR");
        try {
            AdvancePointer();
            T();
        } catch (Exception ex) {
            Logger.getLogger(GrammarLL1Examples.class.getName()).log(Level.SEVERE, null, ex);
        }
      R();
    }
    
    static void R() throws Exception
    {
      String rule;
      
      if(NextChar() == '+'){
          rule = "+TR";
      }else if(NextChar() == '-') {
          rule ="-TR";
      }
      else rule = "~";

      System.out.println("R -> " + rule);
      switch(rule)
      {
        case "+TR": AdvancePointer(); T(); R(); break;
        case "-TR": AdvancePointer(); T(); R(); break;
        case "~": break;
      }
    }
    
    static void T() throws Exception
    {
        System.out.println("T -> FS");
        F();
        S();
    }
    
    static void S() throws Exception
    {
      String rule;
      
      AdvancePointer();
      if(NextChar() == '*'){
          rule = "*FS";
      }else if(NextChar() == '/') {
          rule ="/FS";
      }
      else rule = "~";

      System.out.println("S -> " + rule);
      switch(rule)
      {
        case "*FS": AdvancePointer(); F(); S(); break;
        case "/FS": AdvancePointer(); F(); S(); break;
        case "~": break;
      }
    }

    static void F() throws Exception
    {
        String rule;
        System.out.println(input);
        System.out.println(input.charAt(0));
        if(NextChar() == '('){
            rule = "(E)";
            System.out.println("F -> " + rule);
            E();
            if(NextChar() != ')');
        }
        else if((NextChar() == '0')||(NextChar() == '1')||(NextChar() == '2')||(NextChar() == '3')
            ||(NextChar() == 'x')||(NextChar() == 'y')||(NextChar() == 'z')){
            rule ="id | literal";
            System.out.println("F -> " + rule);
        }
    }

    static Boolean Parse()
    {
      try
      {
        P();
        AdvancePointer();
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


