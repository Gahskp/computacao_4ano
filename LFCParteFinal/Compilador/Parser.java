/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfctrabalhofinal;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	public static final int _EOF = 0;
	public static final int _ident = 1;
	public static final int _number = 2;
	public static final int maxT = 27;

	static final boolean _T = true;
	static final boolean _x = false;
	static final int minErrDist = 2;

	public Token t;    // last recognized token
	public Token la;   // lookahead token
	int errDist = minErrDist;

	public Scanner scanner;
	public Errors errors;

	TabelaSimbolos tab = new TabelaSimbolos();

        public Constantes sConst = new Constantes();

public void printTable() {

System.out.println("**** Conteudo da tabela de simbolos ****");

System.out.println(tab.toString());

}




class ObjetoTabela {
        public String nome;
        public int categoria;   // valores válidos CVAR = 8, CPROC=9
        public int tipo;        // inteiro, booleano ou indefinido: TUNDEF = 0; TINTEGER = 1; TBOOLEAN = 2;
        public int address;

    public ObjetoTabela(String nome, int categoria, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = categoria;
    }
    public String getNome() {
        return nome;
    }
    public int getCategoria() {
        return categoria;
    }
    public int getTipo() {
        return tipo;
    }
    public int getType() {
        return tipo;
    }
    public int getKind() {
        return tipo;
    }
    public int getAddress() {
        return address;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public void setAddress(int address) {
        this.address = address;
    }
    @Override
    public String toString(){
        String s="";
        s="OT >> Nome: " + this.nome+ ", Categoria: " + this.categoria + ", Tipo:" + this.tipo;
        return s;
    }
}

class ObjetoEscopo {
        public List<ObjetoTabela> locals = new ArrayList<ObjetoTabela>();;
        public ObjetoEscopo externo=null;
        public int nvars;

    public List<ObjetoTabela> getLocals() {
        return locals;
    }
    public ObjetoEscopo getExterno() {
        return externo;
    }
    public int getNvars() {
        return nvars;
    }
    public void setLocals(List<ObjetoTabela> locals) {
        this.locals = locals;
    }
    public void setExterno(ObjetoEscopo externo) {
        this.externo = externo;
    }
    public void setNvars(int nvars) {
        this.nvars = nvars;
    }
    public void append(ObjetoTabela local){ // adiciona um ObjetoTabela a ObjetoEscopo
        this.locals.add(local);
    }
    public ObjetoTabela find(String nome){   //localiza objetos da tabela dentro de ObjetoEscopo. o argumento deste método é um string com o nome do objeto procurado.
        for (int i=0; i<locals.size();i++){
            if (locals.get(i).getNome().matches(nome)){
                return locals.get(i);
            }
        }
        return null;
    }
    @Override
    public String toString(){
        String s="";
        String s2[]=super.toString().split("Escopo");
        s+="OE"+s2[1]+ "(nvars: " + this.nvars+")";
        return s;
    }
}

class TabelaSimbolos {
    public ObjetoEscopo escopoAtual;
    public int nivel;

    public ObjetoEscopo getEscopoAtual() {
        return escopoAtual;
    }
    public int getNivel() {
        return nivel;
    }
    public void setEscopoAtual(ObjetoEscopo escopoAtual) {
        this.escopoAtual = escopoAtual;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void openScope(){
        ObjetoEscopo E = new ObjetoEscopo();
        E.externo=escopoAtual;
        escopoAtual=E;
        nivel++;
    }
    public void closeScope(){
        escopoAtual=escopoAtual.externo;
        nivel--;
    }
    public ObjetoTabela insert(String nome, int categoria, int tipo){
        ObjetoTabela Q = new ObjetoTabela(nome, tipo, categoria);
        if (tipo==8){ // se for CVAR
            Q.address=escopoAtual.nvars;
            escopoAtual.nvars++;
        }
        escopoAtual.append(Q);
        return Q;
    }
    public ObjetoTabela find(String aname){
        ObjetoEscopo OE = escopoAtual;
        ObjetoTabela OT = OE.find(aname);
        if (OT!=null){
            return OT;
        }
        else{
            while (OE.externo!=null){
                OE=OE.externo;
                OT = OE.find(aname);
                if (OT!=null){
                    return OT;
                }
            }
        }
        OT = new ObjetoTabela("NoObj", 0, 0); // se chegar aqui é porque não encontrou aname.
        return OT;
    }

    @Override
    public String toString(){

        String s="";
        s="TS >> Escopo atual: " + this.escopoAtual +"; Nível: "+this.nivel;
        s+="\n";
        for (int i=0;i<escopoAtual.locals.size();i++){
            s=s.concat(escopoAtual.locals.get(i).toString()+"\n");
        }
        return s;
    }
}



/*--------------------------------------------------------------------------*/



	public Parser(Scanner scanner) {
		this.scanner = scanner;
		errors = new Errors();
	}

	void SynErr (int n) {
		if (errDist >= minErrDist) errors.SynErr(la.line, la.col, n);
		errDist = 0;
	}

	public void SemErr (String msg) {
		if (errDist >= minErrDist) errors.SemErr(t.line, t.col, msg);
		errDist = 0;
	}

	void Get () {
		for (;;) {
			t = la;
			la = scanner.Scan();
			if (la.kind <= maxT) {
				++errDist;
				break;
			}

			la = t;
		}
	}

	void Expect (int n) {
		if (la.kind==n) Get(); else { SynErr(n); }
	}

	boolean StartOf (int s) {
		return set[s][la.kind];
	}

	void ExpectWeak (int n, int follow) {
		if (la.kind == n) Get();
		else {
			SynErr(n);
			while (!StartOf(follow)) Get();
		}
	}

	boolean WeakSeparator (int n, int syFol, int repFol) {
		int kind = la.kind;
		if (kind == n) { Get(); return true; }
		else if (StartOf(repFol)) return false;
		else {
			SynErr(n);
			while (!(set[syFol][kind] || set[repFol][kind] || set[0][kind])) {
				Get();
				kind = la.kind;
			}
			return StartOf(syFol);
		}
	}

	String  Ident() {
		String  xname;
		Expect(1);
		xname = t.val;
		return xname;
	}

	int  AddOp() {
		int  aop;
		aop = -1;
		if (la.kind == 3) {
			Get();
			aop = sConst.OPPLUS;
		} else if (la.kind == 4) {
			Get();
			aop = sConst.OPMINUS;
		} else SynErr(28);
		return aop;
	}

	int  Expr() {
		int  etype;
		int type1, rop;
		etype = SimExpr();
		if (la.kind == 14 || la.kind == 15 || la.kind == 16) {
			rop = RelOp();
			type1 = SimExpr();
		}
		return etype;
	}

	int  SimExpr() {
		int  stype;
		int stype1, aop;
		stype = Term();
		while (la.kind == 3 || la.kind == 4) {
			aop = AddOp();
			stype1 = Term();
			if (stype != sConst.TINTEGER || stype1 != sConst.TINTEGER) System.out.println("ExpressÃ£o simples requer operandos do tipo inteiro");
		}
		return stype;
	}

	int  RelOp() {
		int  rop;
		rop = -1;
		if (la.kind == 14) {
			Get();
			rop = sConst.OPEQU;
		} else if (la.kind == 15) {
			Get();
			rop = sConst.OPLSS;
		} else if (la.kind == 16) {
			Get();
			rop = sConst.OPGTR;
		} else SynErr(29);
		return rop;
	}

	int  Factor() {
		int  ftype;
		int val, n;
		ObjetoTabela obj;
		String xname;
		int ftype1;
		ftype = sConst.TUNDEF;

		if (la.kind == 1) {
			xname = Ident();
			obj = tab.find(xname); ftype = obj.getType();
			if (obj.getKind() == sConst.CVAR) {
			System.out.println("Processando um fator que tem uma variavel");
			System.out.println(" cujo nome eh " + xname);
			} else System.out.println("Esperava uma variavel");

		} else if (la.kind == 2) {
			Get();
		} else if (la.kind == 4) {
			Get();
			ftype1 = Factor();
			if (ftype1 != sConst.TINTEGER) {
			System.out.println("esperava um inteiro");
			System.out.println("depois tratar erro");
			}

		} else if (la.kind == 5) {
			Get();
		} else if (la.kind == 6) {
			Get();
		} else SynErr(30);
		return ftype;
	}

	int  MulOp() {
		int  mop;
		mop = -1;
		if (la.kind == 7) {
			Get();
			mop = sConst.OPTIMES;
		} else if (la.kind == 8) {
			Get();
			mop =sConst.OPSLASH;
		} else SynErr(31);
		return mop;
	}

	void ProcDecl() {
		String xname; ObjetoTabela obj;
		Expect(9);
		xname = Ident();
		obj = tab.insert(xname, sConst.CPROC, sConst.TUNDEF);
		tab.openScope(); System.out.println("Apos criar escopo"); printTable();

		Expect(10);
		Expect(11);
		Expect(12);
		while (StartOf(1)) {
			if (la.kind == 24 || la.kind == 25) {
				VarDecl();
			} else {
				Stat();
			}
		}
		Expect(13);
		tab.closeScope();
	}

	void VarDecl() {
		String xname; int ttype;
		ttype = Type();
		xname = Ident();
		tab.insert(xname, sConst.CVAR, ttype);
		while (la.kind == 26) {
			Get();
			xname = Ident();
			tab.insert(xname, sConst.CVAR, ttype);
		}
		Expect(18);
		System.out.println("Declaracao de Variaveis efetuada\n"); printTable();
	}

	void Stat() {
		int etype;
		String xname;
		ObjetoTabela obj;

		switch (la.kind) {
		case 1: {
			xname = Ident();
			obj = tab.find(xname);
			if (la.kind == 17) {
				Get();
				if (obj.getKind() != sConst.CVAR) System.out.println("Atribui valores somente a variaveis");
				etype = Expr();
				Expect(18);
				if (etype != obj.getType()) System.out.println("Tipos incompativeis");
			} else if (la.kind == 10) {
				Get();
				Expect(11);
				Expect(18);
				if (obj.getKind()!= sConst.CPROC) System.out.println("Obj nao é um procedimento");
			} else SynErr(32);
			break;
		}
		case 19: {
			Get();
			Expect(10);
			etype = Expr();
			Expect(11);
			if (etype != sConst.TBOOLEAN) System.out.println("Precisa ser booleano");
			break;
		}
		case 20: {
			Get();
			Expect(10);
			etype = Expr();
			Expect(11);
			if (etype != sConst.TBOOLEAN) System.out.println("Precisa ser booleano");
			Stat();
			break;
		}
		case 21: {
			Get();
			xname = Ident();
			Expect(18);
			obj = tab.find(xname);
			break;
		}
		case 22: {
			Get();
			etype = Expr();
			Expect(18);
			if (etype != sConst.TINTEGER) System.out.println("Precisa ser do tipo inteiro");
			break;
		}
		case 12: {
			Get();
			while (StartOf(1)) {
				if (StartOf(2)) {
					Stat();
				} else {
					VarDecl();
				}
			}
			Expect(13);
			break;
		}
		default: SynErr(33); break;
		}
	}

	int  Term() {
		int  ttype;
		int ttype1, mop;
		ttype = Factor();
		while (la.kind == 7 || la.kind == 8) {
			mop = MulOp();
			ttype1 = Factor();
			if (ttype != sConst.TINTEGER || ttype1 != sConst.TINTEGER)
			System.out.println("integer type expected");

		}
		return ttype;
	}

	void Taste() {
		String xname;
		Expect(23);
		xname = Ident();
		tab.openScope();
		Expect(12);
		while (la.kind == 24 || la.kind == 25) {
			VarDecl();
		}
		while (la.kind == 9) {
			ProcDecl();
		}
		Expect(13);
		tab.closeScope();
	}

	int  Type() {
		int  type;
		type = sConst.TUNDEF;
		if (la.kind == 24) {
			Get();
			type = sConst.TINTEGER;
		} else if (la.kind == 25) {
			Get();
			type = sConst.TBOOLEAN;
		} else SynErr(34);
		return type;
	}



	public void Parse() {
		la = new Token();
		la.val = "";
		Get();
		Taste();
		Expect(0);

	}

	private static final boolean[][] set = {
		{_T,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x},
		{_x,_T,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _T,_x,_x,_x, _x,_x,_x,_T, _T,_T,_T,_x, _T,_T,_x,_x, _x},
		{_x,_T,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _T,_x,_x,_x, _x,_x,_x,_T, _T,_T,_T,_x, _x,_x,_x,_x, _x}

	};
} // end Parser


class Errors {
	public int count = 0;                                    // number of errors detected
	public java.io.PrintStream errorStream = System.out;     // error messages go to this stream
	public String errMsgFormat = "-- line {0} col {1}: {2}"; // 0=line, 1=column, 2=text

	protected void printMsg(int line, int column, String msg) {
		StringBuffer b = new StringBuffer(errMsgFormat);
		int pos = b.indexOf("{0}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, line); }
		pos = b.indexOf("{1}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, column); }
		pos = b.indexOf("{2}");
		if (pos >= 0) b.replace(pos, pos+3, msg);
		errorStream.println(b.toString());
	}

	public void SynErr (int line, int col, int n) {
		String s;
		switch (n) {
			case 0: s = "EOF expected"; break;
			case 1: s = "ident expected"; break;
			case 2: s = "number expected"; break;
			case 3: s = "\"+\" expected"; break;
			case 4: s = "\"-\" expected"; break;
			case 5: s = "\"true\" expected"; break;
			case 6: s = "\"false\" expected"; break;
			case 7: s = "\"*\" expected"; break;
			case 8: s = "\"/\" expected"; break;
			case 9: s = "\"void\" expected"; break;
			case 10: s = "\"(\" expected"; break;
			case 11: s = "\")\" expected"; break;
			case 12: s = "\"{\" expected"; break;
			case 13: s = "\"}\" expected"; break;
			case 14: s = "\"==\" expected"; break;
			case 15: s = "\"<\" expected"; break;
			case 16: s = "\">\" expected"; break;
			case 17: s = "\"=\" expected"; break;
			case 18: s = "\";\" expected"; break;
			case 19: s = "\"if\" expected"; break;
			case 20: s = "\"while\" expected"; break;
			case 21: s = "\"read\" expected"; break;
			case 22: s = "\"write\" expected"; break;
			case 23: s = "\"program\" expected"; break;
			case 24: s = "\"int\" expected"; break;
			case 25: s = "\"bool\" expected"; break;
			case 26: s = "\",\" expected"; break;
			case 27: s = "??? expected"; break;
			case 28: s = "invalid AddOp"; break;
			case 29: s = "invalid RelOp"; break;
			case 30: s = "invalid Factor"; break;
			case 31: s = "invalid MulOp"; break;
			case 32: s = "invalid Stat"; break;
			case 33: s = "invalid Stat"; break;
			case 34: s = "invalid Type"; break;
			default: s = "error " + n; break;
		}
		printMsg(line, col, s);
		count++;
	}

	public void SemErr (int line, int col, String s) {
		printMsg(line, col, s);
		count++;
	}

	public void SemErr (String s) {
		errorStream.println(s);
		count++;
	}

	public void Warning (int line, int col, String s) {
		printMsg(line, col, s);
	}

	public void Warning (String s) {
		errorStream.println(s);
	}
} // Errors


class FatalError extends RuntimeException {
	public static final long serialVersionUID = 1L;
	public FatalError(String s) { super(s); }
}
