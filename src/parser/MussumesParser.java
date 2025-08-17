// Generated from ./Mussumes.g4 by ANTLR 4.13.2
package parser;

    import datastructures.Symbol;
    import datastructures.Variable;
    import datastructures.SymbolTable;
    import exceptions.SemanticException;
    import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MussumesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, VIR=20, AP=21, FP=22, ACH=23, FCH=24, SC=25, ATTR=26, 
		OPREL=27, WS=28, COMMENT=29, TRUE=30, FALSE=31, ID=32, FLOAT=33, INT=34, 
		STRING=35;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_expr_or_bool = 10, RULE_expr = 11, RULE_termo = 12, 
		RULE_fator = 13, RULE_boolexpr = 14, RULE_booltermo = 15, RULE_boolfator = 16, 
		RULE_comparison = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"cmdattrib", "cmdselecao", "expr_or_bool", "expr", "termo", "fator", 
			"boolexpr", "booltermo", "boolfator", "comparison"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'iniciavis'", "'fimis'", "'interis'", "'floatis'", "'letris'", 
			"'verdadis'", "'levis'", "'escrevis'", "'si'", "'entaovis'", "'elsivis'", 
			"'senaovis'", "'+'", "'-'", "'*'", "'/'", "'||'", "'&&'", "'!'", "','", 
			"'('", "')'", "'{'", "'}'", "';'", "'='", null, null, null, "'verdaderis'", 
			"'falsis'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "VIR", "AP", "FP", "ACH", 
			"FCH", "SC", "ATTR", "OPREL", "WS", "COMMENT", "TRUE", "FALSE", "ID", 
			"FLOAT", "INT", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mussumes.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int _tipo;
	    private String _varName;
	    private String _varValue;
	    private SymbolTable symbolTable = new SymbolTable();
	    private Symbol symbol;

	    private static final java.util.Set<String> RESERVED_WORDS = new java.util.HashSet<String>() {{
	        add("iniciavis");
	        add("fimis");
	        add("interis");
	        add("floatis");
	        add("letris");
	        add("levis");
	        add("escrevis");
	        add("si");
	        add("entaovis");
	        add("elsivis");
	        add("senaovis");
	        add("verdadis");
	        add("verdaderis");
	        add("falsis");
	    }};

	    public void adicionaID(Symbol symbol) {
	        String name = symbol.getName();
	        if (RESERVED_WORDS.contains(name.toLowerCase())) {
	            throw new SemanticException("Nome reservadis: " + name);
	        }
	        if (symbolTable.exists(name)){
	            throw new SemanticException("Esse "+name+" já existis, cumpadis!");
	        }
	        symbolTable.add(symbol);
	    }

	    public Variable verificaID(String id) {
	        if(!symbolTable.exists(id)) {
	            throw new SemanticException("Esse "+id+" num existis, cumpadis!");
	        }
	        return (Variable) symbolTable.get(id);
	    }

	    public void verificaNum(String value, int tipo) {
	        try {
	            if (tipo == Variable.INT) {
	                Integer.parseInt(value);
	            } else if (tipo == Variable.FLOAT) {
	                Float.parseFloat(value);
	            } else {
	                throw new SemanticException("Tipus inválidis: " + value);
	            }
	        } catch (NumberFormatException e) {
	            throw new SemanticException("Valor numéricus inválidis: " + value);
	        }
	    }

	public MussumesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode SC() { return getToken(MussumesParser.SC, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			decl();
			setState(38);
			bloco();
			setState(39);
			match(T__1);
			setState(40);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120L) != 0)) {
				{
				{
				setState(42);
				declaravar();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MussumesParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MussumesParser.ID, i);
		}
		public TerminalNode SC() { return getToken(MussumesParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(MussumesParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(MussumesParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			tipo();
			setState(49);
			match(ID);

			                _varName  = _input.LT(-1).getText();
			                symbol    = new Variable(_varName, _tipo, null);
			                adicionaID(symbol);
			            
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(51);
				match(VIR);
				setState(52);
				match(ID);

				                _varName  = _input.LT(-1).getText();
				                symbol    = new Variable(_varName, _tipo, null);
				                adicionaID(symbol);
				            
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(T__2);
				_tipo = Variable.INT;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__3);
				_tipo = Variable.FLOAT;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(T__4);
				_tipo = Variable.TEXT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				match(T__5);
				_tipo = Variable.BOOLEAN;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				cmd();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4294968192L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				cmdleitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				cmdattrib();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				cmdselecao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MussumesParser.AP, 0); }
		public TerminalNode ID() { return getToken(MussumesParser.ID, 0); }
		public TerminalNode FP() { return getToken(MussumesParser.FP, 0); }
		public TerminalNode SC() { return getToken(MussumesParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__6);
			setState(83);
			match(AP);
			setState(84);
			match(ID);
			verificaID(_input.LT(-1).getText());
			setState(86);
			match(FP);
			setState(87);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdescritaContext extends ParserRuleContext {
		public Expr_or_boolContext e;
		public TerminalNode AP() { return getToken(MussumesParser.AP, 0); }
		public TerminalNode FP() { return getToken(MussumesParser.FP, 0); }
		public TerminalNode SC() { return getToken(MussumesParser.SC, 0); }
		public Expr_or_boolContext expr_or_bool() {
			return getRuleContext(Expr_or_boolContext.class,0);
		}
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__7);
			setState(90);
			match(AP);
			setState(91);
			((CmdescritaContext)_localctx).e = expr_or_bool();
			setState(92);
			match(FP);
			setState(93);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdattribContext extends ParserRuleContext {
		public Expr_or_boolContext e;
		public TerminalNode ID() { return getToken(MussumesParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(MussumesParser.ATTR, 0); }
		public TerminalNode SC() { return getToken(MussumesParser.SC, 0); }
		public Expr_or_boolContext expr_or_bool() {
			return getRuleContext(Expr_or_boolContext.class,0);
		}
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ID);
			verificaID(_input.LT(-1).getText());
			                  _varName = _input.LT(-1).getText();
			                 
			setState(97);
			match(ATTR);
			setState(98);
			((CmdattribContext)_localctx).e = expr_or_bool();

			                Variable var = (Variable) symbolTable.get(_varName);
			                if (var.getType() == Variable.INT) {
			                    if (((CmdattribContext)_localctx).e.tipoExpr != Variable.INT) {
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
			                    }
			                }
			                if (var.getType() == Variable.FLOAT) {
			                    if (((CmdattribContext)_localctx).e.tipoExpr != Variable.INT && ((CmdattribContext)_localctx).e.tipoExpr != Variable.FLOAT) {
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
			                    }
			                }
			                if (var.getType() == Variable.TEXT) {
			                    if (((CmdattribContext)_localctx).e.tipoExpr != Variable.TEXT) {
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
			                    }
			                }
			                if (var.getType() == Variable.BOOLEAN) {
			                    if (((CmdattribContext)_localctx).e.tipoExpr != Variable.BOOLEAN) {
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
			                    }
			                }
			             
			setState(100);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public Expr_or_boolContext cond;
		public Expr_or_boolContext cond2;
		public List<TerminalNode> AP() { return getTokens(MussumesParser.AP); }
		public TerminalNode AP(int i) {
			return getToken(MussumesParser.AP, i);
		}
		public List<TerminalNode> FP() { return getTokens(MussumesParser.FP); }
		public TerminalNode FP(int i) {
			return getToken(MussumesParser.FP, i);
		}
		public List<TerminalNode> ACH() { return getTokens(MussumesParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(MussumesParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(MussumesParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(MussumesParser.FCH, i);
		}
		public List<Expr_or_boolContext> expr_or_bool() {
			return getRuleContexts(Expr_or_boolContext.class);
		}
		public Expr_or_boolContext expr_or_bool(int i) {
			return getRuleContext(Expr_or_boolContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__8);
			setState(103);
			match(AP);
			setState(104);
			((CmdselecaoContext)_localctx).cond = expr_or_bool();
			setState(105);
			match(FP);
			setState(106);
			match(T__9);
			setState(107);
			match(ACH);
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				cmd();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4294968192L) != 0) );
			setState(113);
			match(FCH);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(114);
				match(T__10);
				setState(115);
				match(AP);
				setState(116);
				((CmdselecaoContext)_localctx).cond2 = expr_or_bool();
				setState(117);
				match(FP);
				setState(118);
				match(T__9);
				setState(119);
				match(ACH);
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(120);
					cmd();
					}
					}
					setState(123); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4294968192L) != 0) );
				setState(125);
				match(FCH);
				}
			}

			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(129);
				match(T__11);
				setState(130);
				match(ACH);
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(131);
					cmd();
					}
					}
					setState(134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4294968192L) != 0) );
				setState(136);
				match(FCH);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_or_boolContext extends ParserRuleContext {
		public int tipoExpr;
		public ExprContext e;
		public BoolexprContext b;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
		}
		public Expr_or_boolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_or_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterExpr_or_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitExpr_or_bool(this);
		}
	}

	public final Expr_or_boolContext expr_or_bool() throws RecognitionException {
		Expr_or_boolContext _localctx = new Expr_or_boolContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr_or_bool);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				((Expr_or_boolContext)_localctx).e = expr();
				((Expr_or_boolContext)_localctx).tipoExpr =  ((Expr_or_boolContext)_localctx).e.tipoExpr;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				((Expr_or_boolContext)_localctx).b = boolexpr();
				((Expr_or_boolContext)_localctx).tipoExpr =  ((Expr_or_boolContext)_localctx).b.tipoExpr;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public int tipoExpr;
		public TermoContext t1;
		public TermoContext t2;
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			((ExprContext)_localctx).t1 = termo();
			((ExprContext)_localctx).tipoExpr =  ((ExprContext)_localctx).t1.tipoTermo;
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || _la==T__13) {
				{
				{
				setState(150);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				((ExprContext)_localctx).t2 = termo();

				                if (_localctx.tipoExpr == Variable.FLOAT || ((ExprContext)_localctx).t2.tipoTermo == Variable.FLOAT)
				                    ((ExprContext)_localctx).tipoExpr =  Variable.FLOAT;
				            
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public int tipoTermo;
		public FatorContext f1;
		public FatorContext f2;
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			((TermoContext)_localctx).f1 = fator();
			((TermoContext)_localctx).tipoTermo =  ((TermoContext)_localctx).f1.tipoFator;
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14 || _la==T__15) {
				{
				{
				setState(161);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(162);
				((TermoContext)_localctx).f2 = fator();

				                if (_localctx.tipoTermo == Variable.FLOAT || ((TermoContext)_localctx).f2.tipoFator == Variable.FLOAT)
				                ((TermoContext)_localctx).tipoTermo =  Variable.FLOAT;
				              
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public int tipoFator;
		public Expr_or_boolContext e;
		public TerminalNode ID() { return getToken(MussumesParser.ID, 0); }
		public TerminalNode INT() { return getToken(MussumesParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MussumesParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(MussumesParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(MussumesParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MussumesParser.FALSE, 0); }
		public TerminalNode AP() { return getToken(MussumesParser.AP, 0); }
		public TerminalNode FP() { return getToken(MussumesParser.FP, 0); }
		public Expr_or_boolContext expr_or_bool() {
			return getRuleContext(Expr_or_boolContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fator);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(ID);
				 Variable var = verificaID(_input.LT(-1).getText());
				                      ((FatorContext)_localctx).tipoFator =  var.getType(); 
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(INT);
				 _varValue = _input.LT(-1).getText();
				                      verificaNum(_varValue, Variable.INT);
				                      ((FatorContext)_localctx).tipoFator =  Variable.INT; 
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(FLOAT);
				 _varValue = _input.LT(-1).getText();
				                      verificaNum(_varValue, Variable.FLOAT);
				                      ((FatorContext)_localctx).tipoFator =  Variable.FLOAT; 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				match(STRING);
				 ((FatorContext)_localctx).tipoFator =  Variable.TEXT; 
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				match(TRUE);
				 ((FatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(180);
				match(FALSE);
				 ((FatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 7);
				{
				setState(182);
				match(AP);
				setState(183);
				((FatorContext)_localctx).e = expr_or_bool();
				setState(184);
				match(FP);
				 ((FatorContext)_localctx).tipoFator =  ((FatorContext)_localctx).e.tipoExpr; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolexprContext extends ParserRuleContext {
		public int tipoExpr;
		public BooltermoContext b1;
		public BooltermoContext b2;
		public List<BooltermoContext> booltermo() {
			return getRuleContexts(BooltermoContext.class);
		}
		public BooltermoContext booltermo(int i) {
			return getRuleContext(BooltermoContext.class,i);
		}
		public BoolexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterBoolexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitBoolexpr(this);
		}
	}

	public final BoolexprContext boolexpr() throws RecognitionException {
		BoolexprContext _localctx = new BoolexprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_boolexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			((BoolexprContext)_localctx).b1 = booltermo();
			 ((BoolexprContext)_localctx).tipoExpr =  ((BoolexprContext)_localctx).b1.tipoTermo; 
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(191);
				match(T__16);
				setState(192);
				((BoolexprContext)_localctx).b2 = booltermo();
				 ((BoolexprContext)_localctx).tipoExpr =  Variable.BOOLEAN; 
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooltermoContext extends ParserRuleContext {
		public int tipoTermo;
		public BoolfatorContext f1;
		public BoolfatorContext f2;
		public List<BoolfatorContext> boolfator() {
			return getRuleContexts(BoolfatorContext.class);
		}
		public BoolfatorContext boolfator(int i) {
			return getRuleContext(BoolfatorContext.class,i);
		}
		public BooltermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booltermo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterBooltermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitBooltermo(this);
		}
	}

	public final BooltermoContext booltermo() throws RecognitionException {
		BooltermoContext _localctx = new BooltermoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_booltermo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			((BooltermoContext)_localctx).f1 = boolfator();
			 ((BooltermoContext)_localctx).tipoTermo =  ((BooltermoContext)_localctx).f1.tipoFator; 
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(202);
				match(T__17);
				setState(203);
				((BooltermoContext)_localctx).f2 = boolfator();
				 ((BooltermoContext)_localctx).tipoTermo =  Variable.BOOLEAN; 
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolfatorContext extends ParserRuleContext {
		public int tipoFator;
		public BoolfatorContext f;
		public BoolexprContext b;
		public BoolfatorContext boolfator() {
			return getRuleContext(BoolfatorContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode ID() { return getToken(MussumesParser.ID, 0); }
		public TerminalNode TRUE() { return getToken(MussumesParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MussumesParser.FALSE, 0); }
		public TerminalNode AP() { return getToken(MussumesParser.AP, 0); }
		public TerminalNode FP() { return getToken(MussumesParser.FP, 0); }
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
		}
		public BoolfatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolfator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterBoolfator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitBoolfator(this);
		}
	}

	public final BoolfatorContext boolfator() throws RecognitionException {
		BoolfatorContext _localctx = new BoolfatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolfator);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(T__18);
				setState(212);
				((BoolfatorContext)_localctx).f = boolfator();
				 ((BoolfatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				comparison();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				match(ID);
				 Variable var = verificaID(_input.LT(-1).getText()); ((BoolfatorContext)_localctx).tipoFator =  var.getType(); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(TRUE);
				 ((BoolfatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
				match(FALSE);
				 ((BoolfatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(222);
				match(AP);
				setState(223);
				((BoolfatorContext)_localctx).b = boolexpr();
				setState(224);
				match(FP);
				 ((BoolfatorContext)_localctx).tipoFator =  ((BoolfatorContext)_localctx).b.tipoExpr; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public int tipoFator;
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(MussumesParser.OPREL, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitComparison(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			((ComparisonContext)_localctx).left = expr();
			setState(230);
			((ComparisonContext)_localctx).op = match(OPREL);
			setState(231);
			((ComparisonContext)_localctx).right = expr();
			((ComparisonContext)_localctx).tipoFator =  Variable.BOOLEAN;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u00eb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001"+
		",\b\u0001\n\u0001\f\u0001/\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00027\b\u0002\n\u0002\f\u0002"+
		":\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"F\b\u0003\u0001\u0004\u0004\u0004I\b\u0004\u000b\u0004\f\u0004J\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005Q\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\tn\b\t\u000b\t"+
		"\f\to\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0004\tz\b\t\u000b\t\f\t{\u0001\t\u0001\t\u0003\t\u0080\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0004\t\u0085\b\t\u000b\t\f\t\u0086\u0001\t\u0001\t\u0003\t"+
		"\u008b\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0093"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u009b\b\u000b\n\u000b\f\u000b\u009e\t\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00a6\b\f\n\f\f\f\u00a9"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00bc\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u00c4\b\u000e\n\u000e\f\u000e\u00c7\t\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u00cf\b\u000f\n\u000f\f\u000f\u00d2\t\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00e4\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"\u0000\u0002\u0001\u0000\r\u000e\u0001\u0000\u000f\u0010\u00f6"+
		"\u0000$\u0001\u0000\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u00040"+
		"\u0001\u0000\u0000\u0000\u0006E\u0001\u0000\u0000\u0000\bH\u0001\u0000"+
		"\u0000\u0000\nP\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000\u000e"+
		"Y\u0001\u0000\u0000\u0000\u0010_\u0001\u0000\u0000\u0000\u0012f\u0001"+
		"\u0000\u0000\u0000\u0014\u0092\u0001\u0000\u0000\u0000\u0016\u0094\u0001"+
		"\u0000\u0000\u0000\u0018\u009f\u0001\u0000\u0000\u0000\u001a\u00bb\u0001"+
		"\u0000\u0000\u0000\u001c\u00bd\u0001\u0000\u0000\u0000\u001e\u00c8\u0001"+
		"\u0000\u0000\u0000 \u00e3\u0001\u0000\u0000\u0000\"\u00e5\u0001\u0000"+
		"\u0000\u0000$%\u0005\u0001\u0000\u0000%&\u0003\u0002\u0001\u0000&\'\u0003"+
		"\b\u0004\u0000\'(\u0005\u0002\u0000\u0000()\u0005\u0019\u0000\u0000)\u0001"+
		"\u0001\u0000\u0000\u0000*,\u0003\u0004\u0002\u0000+*\u0001\u0000\u0000"+
		"\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000"+
		"01\u0003\u0006\u0003\u000012\u0005 \u0000\u000028\u0006\u0002\uffff\uffff"+
		"\u000034\u0005\u0014\u0000\u000045\u0005 \u0000\u000057\u0006\u0002\uffff"+
		"\uffff\u000063\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000;<\u0005\u0019\u0000\u0000<\u0005\u0001\u0000"+
		"\u0000\u0000=>\u0005\u0003\u0000\u0000>F\u0006\u0003\uffff\uffff\u0000"+
		"?@\u0005\u0004\u0000\u0000@F\u0006\u0003\uffff\uffff\u0000AB\u0005\u0005"+
		"\u0000\u0000BF\u0006\u0003\uffff\uffff\u0000CD\u0005\u0006\u0000\u0000"+
		"DF\u0006\u0003\uffff\uffff\u0000E=\u0001\u0000\u0000\u0000E?\u0001\u0000"+
		"\u0000\u0000EA\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000F\u0007"+
		"\u0001\u0000\u0000\u0000GI\u0003\n\u0005\u0000HG\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000"+
		"\u0000K\t\u0001\u0000\u0000\u0000LQ\u0003\f\u0006\u0000MQ\u0003\u000e"+
		"\u0007\u0000NQ\u0003\u0010\b\u0000OQ\u0003\u0012\t\u0000PL\u0001\u0000"+
		"\u0000\u0000PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001"+
		"\u0000\u0000\u0000Q\u000b\u0001\u0000\u0000\u0000RS\u0005\u0007\u0000"+
		"\u0000ST\u0005\u0015\u0000\u0000TU\u0005 \u0000\u0000UV\u0006\u0006\uffff"+
		"\uffff\u0000VW\u0005\u0016\u0000\u0000WX\u0005\u0019\u0000\u0000X\r\u0001"+
		"\u0000\u0000\u0000YZ\u0005\b\u0000\u0000Z[\u0005\u0015\u0000\u0000[\\"+
		"\u0003\u0014\n\u0000\\]\u0005\u0016\u0000\u0000]^\u0005\u0019\u0000\u0000"+
		"^\u000f\u0001\u0000\u0000\u0000_`\u0005 \u0000\u0000`a\u0006\b\uffff\uffff"+
		"\u0000ab\u0005\u001a\u0000\u0000bc\u0003\u0014\n\u0000cd\u0006\b\uffff"+
		"\uffff\u0000de\u0005\u0019\u0000\u0000e\u0011\u0001\u0000\u0000\u0000"+
		"fg\u0005\t\u0000\u0000gh\u0005\u0015\u0000\u0000hi\u0003\u0014\n\u0000"+
		"ij\u0005\u0016\u0000\u0000jk\u0005\n\u0000\u0000km\u0005\u0017\u0000\u0000"+
		"ln\u0003\n\u0005\u0000ml\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000q\u007f\u0005\u0018\u0000\u0000rs\u0005\u000b\u0000\u0000st\u0005"+
		"\u0015\u0000\u0000tu\u0003\u0014\n\u0000uv\u0005\u0016\u0000\u0000vw\u0005"+
		"\n\u0000\u0000wy\u0005\u0017\u0000\u0000xz\u0003\n\u0005\u0000yx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0005\u0018\u0000"+
		"\u0000~\u0080\u0001\u0000\u0000\u0000\u007fr\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u008a\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0005\f\u0000\u0000\u0082\u0084\u0005\u0017\u0000\u0000\u0083\u0085"+
		"\u0003\n\u0005\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005"+
		"\u0018\u0000\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0081\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0013\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0003\u0016\u000b\u0000\u008d\u008e\u0006"+
		"\n\uffff\uffff\u0000\u008e\u0093\u0001\u0000\u0000\u0000\u008f\u0090\u0003"+
		"\u001c\u000e\u0000\u0090\u0091\u0006\n\uffff\uffff\u0000\u0091\u0093\u0001"+
		"\u0000\u0000\u0000\u0092\u008c\u0001\u0000\u0000\u0000\u0092\u008f\u0001"+
		"\u0000\u0000\u0000\u0093\u0015\u0001\u0000\u0000\u0000\u0094\u0095\u0003"+
		"\u0018\f\u0000\u0095\u009c\u0006\u000b\uffff\uffff\u0000\u0096\u0097\u0007"+
		"\u0000\u0000\u0000\u0097\u0098\u0003\u0018\f\u0000\u0098\u0099\u0006\u000b"+
		"\uffff\uffff\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0096\u0001"+
		"\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u0017\u0001"+
		"\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0003"+
		"\u001a\r\u0000\u00a0\u00a7\u0006\f\uffff\uffff\u0000\u00a1\u00a2\u0007"+
		"\u0001\u0000\u0000\u00a2\u00a3\u0003\u001a\r\u0000\u00a3\u00a4\u0006\f"+
		"\uffff\uffff\u0000\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u0019\u0001"+
		"\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005"+
		" \u0000\u0000\u00ab\u00bc\u0006\r\uffff\uffff\u0000\u00ac\u00ad\u0005"+
		"\"\u0000\u0000\u00ad\u00bc\u0006\r\uffff\uffff\u0000\u00ae\u00af\u0005"+
		"!\u0000\u0000\u00af\u00bc\u0006\r\uffff\uffff\u0000\u00b0\u00b1\u0005"+
		"#\u0000\u0000\u00b1\u00bc\u0006\r\uffff\uffff\u0000\u00b2\u00b3\u0005"+
		"\u001e\u0000\u0000\u00b3\u00bc\u0006\r\uffff\uffff\u0000\u00b4\u00b5\u0005"+
		"\u001f\u0000\u0000\u00b5\u00bc\u0006\r\uffff\uffff\u0000\u00b6\u00b7\u0005"+
		"\u0015\u0000\u0000\u00b7\u00b8\u0003\u0014\n\u0000\u00b8\u00b9\u0005\u0016"+
		"\u0000\u0000\u00b9\u00ba\u0006\r\uffff\uffff\u0000\u00ba\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bb\u00aa\u0001\u0000\u0000\u0000\u00bb\u00ac\u0001\u0000"+
		"\u0000\u0000\u00bb\u00ae\u0001\u0000\u0000\u0000\u00bb\u00b0\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b2\u0001\u0000\u0000\u0000\u00bb\u00b4\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b6\u0001\u0000\u0000\u0000\u00bc\u001b\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0003\u001e\u000f\u0000\u00be\u00c5\u0006\u000e"+
		"\uffff\uffff\u0000\u00bf\u00c0\u0005\u0011\u0000\u0000\u00c0\u00c1\u0003"+
		"\u001e\u000f\u0000\u00c1\u00c2\u0006\u000e\uffff\uffff\u0000\u00c2\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c3\u00bf\u0001\u0000\u0000\u0000\u00c4\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c6\u001d\u0001\u0000\u0000\u0000\u00c7\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u0003 \u0010\u0000\u00c9\u00d0\u0006"+
		"\u000f\uffff\uffff\u0000\u00ca\u00cb\u0005\u0012\u0000\u0000\u00cb\u00cc"+
		"\u0003 \u0010\u0000\u00cc\u00cd\u0006\u000f\uffff\uffff\u0000\u00cd\u00cf"+
		"\u0001\u0000\u0000\u0000\u00ce\u00ca\u0001\u0000\u0000\u0000\u00cf\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d1\u001f\u0001\u0000\u0000\u0000\u00d2\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u0013\u0000\u0000\u00d4\u00d5"+
		"\u0003 \u0010\u0000\u00d5\u00d6\u0006\u0010\uffff\uffff\u0000\u00d6\u00e4"+
		"\u0001\u0000\u0000\u0000\u00d7\u00e4\u0003\"\u0011\u0000\u00d8\u00d9\u0005"+
		" \u0000\u0000\u00d9\u00e4\u0006\u0010\uffff\uffff\u0000\u00da\u00db\u0005"+
		"\u001e\u0000\u0000\u00db\u00e4\u0006\u0010\uffff\uffff\u0000\u00dc\u00dd"+
		"\u0005\u001f\u0000\u0000\u00dd\u00e4\u0006\u0010\uffff\uffff\u0000\u00de"+
		"\u00df\u0005\u0015\u0000\u0000\u00df\u00e0\u0003\u001c\u000e\u0000\u00e0"+
		"\u00e1\u0005\u0016\u0000\u0000\u00e1\u00e2\u0006\u0010\uffff\uffff\u0000"+
		"\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00d3\u0001\u0000\u0000\u0000"+
		"\u00e3\u00d7\u0001\u0000\u0000\u0000\u00e3\u00d8\u0001\u0000\u0000\u0000"+
		"\u00e3\u00da\u0001\u0000\u0000\u0000\u00e3\u00dc\u0001\u0000\u0000\u0000"+
		"\u00e3\u00de\u0001\u0000\u0000\u0000\u00e4!\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0003\u0016\u000b\u0000\u00e6\u00e7\u0005\u001b\u0000\u0000\u00e7"+
		"\u00e8\u0003\u0016\u000b\u0000\u00e8\u00e9\u0006\u0011\uffff\uffff\u0000"+
		"\u00e9#\u0001\u0000\u0000\u0000\u0011-8EJPo{\u007f\u0086\u008a\u0092\u009c"+
		"\u00a7\u00bb\u00c5\u00d0\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}