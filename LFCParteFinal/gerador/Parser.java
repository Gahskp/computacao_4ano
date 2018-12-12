

public class Parser {
	public static final int _EOF = 0;
	public static final int _varid = 1;
	public static final int _integer = 2;
	public static final int _string = 3;
	public static final int _zr = 4;
	public static final int maxT = 33;

	static final boolean _T = true;
	static final boolean _x = false;
	static final int minErrDist = 2;

	public Token t;    // last recognized token
	public Token la;   // lookahead token
	int errDist = minErrDist;
	
	public Scanner scanner;
	public Errors errors;

	

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
	
	void simple() {
		Expect(5);
		clist();
		Expect(6);
	}

	void clist() {
		stmt();
		while (StartOf(1)) {
			stmt();
		}
	}

	void stmt() {
		switch (la.kind) {
		case 11: {
			sdecl();
			break;
		}
		case 8: {
			print();
			break;
		}
		case 9: {
			sinput();
			break;
		}
		case 1: {
			vardec();
			break;
		}
		case 14: {
			swhile();
			break;
		}
		case 18: {
			scond();
			break;
		}
		default: SynErr(34); break;
		}
		Expect(7);
	}

	void sdecl() {
		Expect(11);
		if (la.kind == 12) {
			Get();
		} else if (la.kind == 13) {
			Get();
		} else SynErr(35);
		Expect(1);
	}

	void print() {
		Expect(8);
		if (la.kind == 3) {
			Get();
		} else if (la.kind == 1 || la.kind == 2 || la.kind == 15) {
			cexpr();
		} else SynErr(36);
	}

	void sinput() {
		Expect(9);
		Expect(1);
	}

	void vardec() {
		Expect(1);
		if (la.kind == 10) {
			Get();
			if (la.kind == 3) {
				Get();
			} else if (la.kind == 2) {
				Get();
			} else if (la.kind == 4) {
				Get();
			} else SynErr(37);
		}
	}

	void swhile() {
		Expect(14);
		Expect(15);
		lexpr();
		Expect(16);
		stmt();
		Expect(17);
	}

	void scond() {
		Expect(18);
		Expect(15);
		lexpr();
		Expect(16);
		stmt();
		Expect(17);
	}

	void cexpr() {
		if (la.kind == 1 || la.kind == 2) {
			factor();
			if (StartOf(2)) {
				if (StartOf(3)) {
					aritop();
				} else {
					relop();
				}
				factor();
			}
		} else if (la.kind == 15) {
			expr();
		} else SynErr(38);
	}

	void lexpr() {
		Expect(26);
		lcond();
		Expect(27);
	}

	void expr() {
		Expect(15);
		cexpr();
		Expect(17);
	}

	void factor() {
		if (la.kind == 2) {
			Get();
		} else if (la.kind == 1) {
			vardec();
		} else SynErr(39);
	}

	void aritop() {
		if (la.kind == 19) {
			Get();
		} else if (la.kind == 20) {
			Get();
		} else if (la.kind == 21) {
			Get();
		} else if (la.kind == 22) {
			Get();
		} else SynErr(40);
	}

	void relop() {
		if (la.kind == 23) {
			Get();
		} else if (la.kind == 24) {
			Get();
		} else if (la.kind == 25) {
			Get();
		} else SynErr(41);
	}

	void lcond() {
		if (la.kind == 28) {
			Get();
			Expect(15);
			cexpr();
			Expect(17);
		} else if (la.kind == 1 || la.kind == 2 || la.kind == 15) {
			crelexpr();
		} else if (la.kind == 29) {
			Get();
		} else if (la.kind == 30) {
			Get();
		} else SynErr(42);
	}

	void crelexpr() {
		cexpr();
		if (la.kind == 31 || la.kind == 32) {
			if (la.kind == 31) {
				Get();
			} else {
				Get();
			}
			cexpr();
		}
	}



	public void Parse() {
		la = new Token();
		la.val = "";		
		Get();
		simple();
		Expect(0);

	}

	private static final boolean[][] set = {
		{_T,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x},
		{_x,_T,_x,_x, _x,_x,_x,_x, _T,_T,_x,_T, _x,_x,_T,_x, _x,_x,_T,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x},
		{_x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_T, _T,_T,_T,_T, _T,_T,_x,_x, _x,_x,_x,_x, _x,_x,_x},
		{_x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x,_T, _T,_T,_T,_x, _x,_x,_x,_x, _x,_x,_x,_x, _x,_x,_x}

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
			case 1: s = "varid expected"; break;
			case 2: s = "integer expected"; break;
			case 3: s = "string expected"; break;
			case 4: s = "zr expected"; break;
			case 5: s = "\"PROGRAM\" expected"; break;
			case 6: s = "\"END\" expected"; break;
			case 7: s = "\";\" expected"; break;
			case 8: s = "\"PRINT\" expected"; break;
			case 9: s = "\"INPUT\" expected"; break;
			case 10: s = "\":=\" expected"; break;
			case 11: s = "\"VAR\" expected"; break;
			case 12: s = "\"INT\" expected"; break;
			case 13: s = "\"STR\" expected"; break;
			case 14: s = "\"WHILE\" expected"; break;
			case 15: s = "\"(\" expected"; break;
			case 16: s = "\",\" expected"; break;
			case 17: s = "\")\" expected"; break;
			case 18: s = "\"IF\" expected"; break;
			case 19: s = "\"+\" expected"; break;
			case 20: s = "\"-\" expected"; break;
			case 21: s = "\"*\" expected"; break;
			case 22: s = "\"DIV\" expected"; break;
			case 23: s = "\"<\" expected"; break;
			case 24: s = "\">\" expected"; break;
			case 25: s = "\"==\" expected"; break;
			case 26: s = "\".(\" expected"; break;
			case 27: s = "\").\" expected"; break;
			case 28: s = "\"NOT\" expected"; break;
			case 29: s = "\"TRUE\" expected"; break;
			case 30: s = "\"FALSE\" expected"; break;
			case 31: s = "\"AND\" expected"; break;
			case 32: s = "\"OR\" expected"; break;
			case 33: s = "??? expected"; break;
			case 34: s = "invalid stmt"; break;
			case 35: s = "invalid sdecl"; break;
			case 36: s = "invalid print"; break;
			case 37: s = "invalid vardec"; break;
			case 38: s = "invalid cexpr"; break;
			case 39: s = "invalid factor"; break;
			case 40: s = "invalid aritop"; break;
			case 41: s = "invalid relop"; break;
			case 42: s = "invalid lcond"; break;
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
