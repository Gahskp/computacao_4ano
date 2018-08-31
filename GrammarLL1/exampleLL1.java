static String input;

static char NextChar()
{
  return input[0];
}

static void AdvancePointer()
{
  input = input.Substring(1);
}

static void S()
{
  Console.WriteLine("S -> E");
  E();
}

static void E()
{
  Console.WirteLine("E -> TF");
  T();
  F();
}

static void F()
{
  String rule;

  if(NextChar() == '+') rule = "+E";
  else if(NextChar() == '*') rule ="*E";
  else rule = "~";

  Console.WriteLine("F -> " + rule);
  switch(rule)
  {
    case "+E": AdvancePointer(); E(); break;
    case "*E": AdvancePointer(); E(); break;
    case "~": break;
  }
}

static void T()
{
  String rule;

  if(NextChar() == 'a') rule = "a";
  else if(NextChar() == 'b') rule = "b";
  else if(NextChar() == 'c') rule = "c";
  else if(NextChar() == '(') rule = "(E)";
  else throw new Exception();

  Console.WriteLine("T -> " + rule);
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

static bool Parse()
{
  try
  {
    s();
    if(NextChar() == 's')
      return true;
  }
  catch(Exception)
  {

  }

  return false;
}

static void Main(String[] args)
{
  input = Console.ReadLine() + "$";
  Console.WriteLine(Parse() ? "String Accepted" : "String Rejected");
}
