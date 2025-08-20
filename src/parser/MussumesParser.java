// Generated from ./Mussumes.g4 by ANTLR 4.13.2
package parser;

    import datastructures.Symbol;
    import datastructures.Variable;
    import datastructures.SymbolTable;
    import exceptions.SemanticException;
    import ast.Program;
    import ast.AbstractCommand;
    import java.util.ArrayList;
    import java.util.Stack;
    import ast.CommandLeitura;
    import ast.CommandEscrita;
    import ast.CommandBloco;
    import ast.CommandDecisao;
    import ast.CommandEnquanto;
    import ast.CommandAtribuicao;
    import org.antlr.v4.runtime.ParserRuleContext;
    import org.antlr.v4.runtime.misc.Interval;

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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, VIR=23, AP=24, FP=25, 
		ACH=26, FCH=27, SC=28, ATTR=29, OPREL=30, WS=31, COMMENT=32, TRUE=33, 
		FALSE=34, ID=35, FLOAT=36, INT=37, STRING=38;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdrepeticao = 10, RULE_cmdfor = 11, RULE_expr_or_bool = 12, 
		RULE_expr = 13, RULE_termo = 14, RULE_fator = 15, RULE_boolexpr = 16, 
		RULE_booltermo = 17, RULE_boolfator = 18, RULE_comparison = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"cmdattrib", "cmdselecao", "cmdrepeticao", "cmdfor", "expr_or_bool", 
			"expr", "termo", "fator", "boolexpr", "booltermo", "boolfator", "comparison"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'iniciavis'", "'fimis'", "'interis'", "'floatis'", "'letris'", 
			"'verdadis'", "'levis'", "'escrevis'", "'si'", "'entaovis'", "'elsivis'", 
			"'senaovis'", "'enquantis'", "'fazis'", "'foris'", "'+'", "'-'", "'*'", 
			"'/'", "'||'", "'&&'", "'!'", "','", "'('", "')'", "'{'", "'}'", "';'", 
			"'='", null, null, null, "'verdaderis'", "'falsis'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "VIR", 
			"AP", "FP", "ACH", "FCH", "SC", "ATTR", "OPREL", "WS", "COMMENT", "TRUE", 
			"FALSE", "ID", "FLOAT", "INT", "STRING"
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
	    private datastructures.SymbolTable symbolTable = new datastructures.SymbolTable();
	    private datastructures.Symbol symbol;
	    private ast.Program program = new ast.Program();
	    private java.util.ArrayList<ast.AbstractCommand> curThread = new java.util.ArrayList<ast.AbstractCommand>();

	    private String _readID;
	    private String _writeID;
	    private String _exprID;
	    private String _exprContent;
	    private String _exprDecision;
	    private java.util.ArrayList<ast.AbstractCommand> listaTrue;
	    private java.util.ArrayList<ast.AbstractCommand> listaFalse;

	    private String _forInitId, _forInitExpr, _forStepId, _forStepExpr;

	    private java.util.Stack<java.util.ArrayList<ast.AbstractCommand>> stack = new java.util.Stack<>();

	    private ast.CommandDecisao _ifRoot;
	    private ast.CommandDecisao _ifCurrent;

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
	        add("fazis");
	        add("enquantis");
	    }};

	    public void adicionaID(datastructures.Symbol symbol) {
	        String name = symbol.getName();
	        if (RESERVED_WORDS.contains(name.toLowerCase())) {
	            throw new exceptions.SemanticException("Nome reservadis: " + name);
	        }
	        if (symbolTable.exists(name)){
	            throw new exceptions.SemanticException("Esse "+name+" já existis, cumpadis!");
	        }
	        symbolTable.add(symbol);
	    }

	    public datastructures.Variable verificaID(String id) {
	        if(!symbolTable.exists(id)) {
	            throw new exceptions.SemanticException("Esse "+id+" num existis, cumpadis!");
	        }
	        return (datastructures.Variable) symbolTable.get(id);
	    }

	    public void verificaNum(String value, int tipo) {
	        try {
	            if (tipo == datastructures.Variable.INT) {
	                Integer.parseInt(value);
	            } else if (tipo == datastructures.Variable.FLOAT) {
	                Float.parseFloat(value);
	            } else {
	                throw new exceptions.SemanticException("Tipus inválidis: " + value);
	            }
	        } catch (NumberFormatException e) {
	            throw new exceptions.SemanticException("Valor numéricus inválidis: " + value);
	        }
	    }

	    public void verificaCond(int tipo) {
	        if (tipo != datastructures.Variable.BOOLEAN) {
	            throw new exceptions.SemanticException("Expressão de condição deve ser boolean, cumpadis!");
	        }
	    }

	    public void exibeComandos(){
	        for (ast.AbstractCommand c: program.getCommands()){
	            System.out.println(c);
	        }
	    }

	    public void generateCode(){
	        program.generateTarget();
	    }

	    private String textOf(org.antlr.v4.runtime.ParserRuleContext ctx){
	        // robusto mesmo com comentários/canais ocultos
	        return _input.getText(ctx.getSourceInterval());
	    }

	    private String normalizeExpr(String s){
	        if (s == null) return null;
	        // booleans Mussumês -> Java
	        s = s.replaceAll("\\bverdaderis\\b", "true");
	        s = s.replaceAll("\\bfalsis\\b", "false");
	        return s;
	    }

	    private String addFloatSuffixIfNeeded(String s){
	        if (s == null) return null;
	        // simples e suficiente p/ nossa léxica: FLOAT é \d+\.\d+ (sem expoente)
	        return s.replaceAll("(\\d+\\.\\d+)(?![fF])", "$1f");
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
			setState(41);
			decl();
			setState(42);
			bloco();
			setState(43);
			match(T__1);

			                    program.setSymbolTable(symbolTable);
			                    program.setProgramName("MussumProgram");
			                    program.setCommands(curThread);
			                
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120L) != 0)) {
				{
				{
				setState(46);
				declaravar();
				}
				}
				setState(51);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitDeclaravar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			tipo();
			setState(53);
			match(ID);

			                _varName  = _input.LT(-1).getText();
			                symbol    = new Variable(_varName, _tipo, null);
			                adicionaID(symbol);
			            
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(55);
				match(VIR);
				setState(56);
				match(ID);

				                _varName  = _input.LT(-1).getText();
				                symbol    = new Variable(_varName, _tipo, null);
				                adicionaID(symbol);
				            
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(T__2);
				_tipo = Variable.INT;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(T__3);
				_tipo = Variable.FLOAT;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(T__4);
				_tipo = Variable.TEXT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitBloco(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				cmd();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34359796608L) != 0) );
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
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdforContext cmdfor() {
			return getRuleContext(CmdforContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				cmdleitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				cmdattrib();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				cmdselecao();
				}
				break;
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				cmdrepeticao();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				cmdfor();
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
		public Token id;
		public TerminalNode AP() { return getToken(MussumesParser.AP, 0); }
		public TerminalNode FP() { return getToken(MussumesParser.FP, 0); }
		public TerminalNode SC() { return getToken(MussumesParser.SC, 0); }
		public TerminalNode ID() { return getToken(MussumesParser.ID, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitCmdleitura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__6);
			setState(89);
			match(AP);
			setState(90);
			((CmdleituraContext)_localctx).id = match(ID);

			                    Variable var = verificaID((((CmdleituraContext)_localctx).id!=null?((CmdleituraContext)_localctx).id.getText():null));
			                    _readID = (((CmdleituraContext)_localctx).id!=null?((CmdleituraContext)_localctx).id.getText():null);
			                    var.setInitialized(true);
			                
			setState(92);
			match(FP);
			setState(93);
			match(SC);

			                    curThread.add(new CommandLeitura(_readID, verificaID(_readID).getType()));
			                
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitCmdescrita(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__7);
			setState(97);
			match(AP);
			setState(98);
			((CmdescritaContext)_localctx).e = expr_or_bool();
			setState(99);
			match(FP);
			setState(100);
			match(SC);

			                String exprText = normalizeExpr( textOf(((CmdescritaContext)_localctx).e) );
			                curThread.add(new CommandEscrita(exprText));
			                
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitCmdattrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ID);
			 Variable var = verificaID(_input.LT(-1).getText()); _varName = _input.LT(-1).getText(); 
			setState(105);
			match(ATTR);
			setState(106);
			((CmdattribContext)_localctx).e = expr_or_bool();

			                if (var.getType() == Variable.INT) {
			                    if (((CmdattribContext)_localctx).e.tipoExpr != Variable.INT) {
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
			                    }
			                } else if (var.getType() == Variable.FLOAT) {
			                    if (((CmdattribContext)_localctx).e.tipoExpr != Variable.INT && ((CmdattribContext)_localctx).e.tipoExpr != Variable.FLOAT) {
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
			                    }
			                } else if (var.getType() == Variable.TEXT) {
			                    if (((CmdattribContext)_localctx).e.tipoExpr != Variable.TEXT) {
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
			                    }
			                } else if (var.getType() == Variable.BOOLEAN) {
			                    if (((CmdattribContext)_localctx).e.tipoExpr != Variable.BOOLEAN) {
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ _varName +", cumpadis!");
			                    }
			                }
			                var.setInitialized(true);

			                String exprText = normalizeExpr( textOf(((CmdattribContext)_localctx).e) );
			                if (var.getType() == Variable.FLOAT) {
			                    exprText = addFloatSuffixIfNeeded(exprText);
			                }
			                curThread.add(new CommandAtribuicao(_varName, exprText));
			                
			setState(108);
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
		public BoolexprContext c1;
		public BoolexprContext cN;
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
		public List<BoolexprContext> boolexpr() {
			return getRuleContexts(BoolexprContext.class);
		}
		public BoolexprContext boolexpr(int i) {
			return getRuleContext(BoolexprContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitCmdselecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__8);
			setState(111);
			match(AP);
			setState(112);
			((CmdselecaoContext)_localctx).c1 = boolexpr();
			setState(113);
			match(FP);
			setState(114);
			match(T__9);
			setState(115);
			match(ACH);

			                    verificaCond(((CmdselecaoContext)_localctx).c1.tipoExpr);
			                    String cond1 = addFloatSuffixIfNeeded( normalizeExpr( textOf(((CmdselecaoContext)_localctx).c1) ) );
			                    stack.push(curThread);
			                    curThread = new ArrayList<AbstractCommand>();
			                
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				cmd();
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34359796608L) != 0) );
			setState(122);
			match(FCH);

			                    ArrayList<AbstractCommand> then1 = curThread;
			                    curThread = stack.pop();

			                    _ifRoot = new CommandDecisao(cond1);
			                    for (AbstractCommand c : then1) _ifRoot.addTrueCommand(c);
			                    _ifCurrent = _ifRoot;
			                
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(124);
				match(T__10);
				setState(125);
				match(AP);
				setState(126);
				((CmdselecaoContext)_localctx).cN = boolexpr();
				setState(127);
				match(FP);
				setState(128);
				match(T__9);
				setState(129);
				match(ACH);

				                        verificaCond(((CmdselecaoContext)_localctx).cN.tipoExpr);
				                        String condN = addFloatSuffixIfNeeded( normalizeExpr( textOf(((CmdselecaoContext)_localctx).cN) ) );
				                        stack.push(curThread);
				                        curThread = new ArrayList<AbstractCommand>();
				                        _exprDecision = condN;
				                    
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34359796608L) != 0) );
				setState(136);
				match(FCH);

				                    ArrayList<AbstractCommand> thenN = curThread;
				                    curThread = stack.pop();

				                    CommandDecisao next = new CommandDecisao(_exprDecision);
				                    for (AbstractCommand c: thenN) next.addTrueCommand(c);
				                    _ifCurrent.addFalseCommand(next);
				                    _ifCurrent = next;
				                    
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(144);
				match(T__11);
				setState(145);
				match(ACH);
				 stack.push(curThread); curThread = new ArrayList<AbstractCommand>(); 
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(147);
					cmd();
					}
					}
					setState(150); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34359796608L) != 0) );
				setState(152);
				match(FCH);

				                    ArrayList<AbstractCommand> elseList = curThread;
				                    curThread = stack.pop();
				                    for (AbstractCommand c: elseList) _ifCurrent.addFalseCommand(c);
				                    
				}
			}


			                    curThread.add(_ifRoot);
			                    _ifRoot = null; _ifCurrent = null;
			                
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
	public static class CmdrepeticaoContext extends ParserRuleContext {
		public BoolexprContext c;
		public BoolexprContext c2;
		public TerminalNode AP() { return getToken(MussumesParser.AP, 0); }
		public TerminalNode FP() { return getToken(MussumesParser.FP, 0); }
		public TerminalNode ACH() { return getToken(MussumesParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(MussumesParser.FCH, 0); }
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitCmdrepeticao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitCmdrepeticao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdrepeticao);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(T__12);
				setState(160);
				match(AP);
				setState(161);
				((CmdrepeticaoContext)_localctx).c = boolexpr();
				setState(162);
				match(FP);
				setState(163);
				match(ACH);

				                    verificaCond(((CmdrepeticaoContext)_localctx).c.tipoExpr);
				                    String condText = addFloatSuffixIfNeeded( normalizeExpr( textOf(((CmdrepeticaoContext)_localctx).c) ) );
				                    stack.push(curThread);
				                    curThread = new ArrayList<AbstractCommand>();
				                    _exprDecision = condText;
				                
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(165);
					cmd();
					}
					}
					setState(168); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34359796608L) != 0) );
				setState(170);
				match(FCH);

				                    ArrayList<AbstractCommand> corpo = curThread;
				                    curThread = stack.pop();

				                    CommandEnquanto loop = new CommandEnquanto(_exprDecision);
				                    for (AbstractCommand c: corpo) loop.addCommand(c);
				                    curThread.add(loop);
				                
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(T__13);
				setState(174);
				match(ACH);
				 stack.push(curThread); curThread = new ArrayList<AbstractCommand>(); 
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					cmd();
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34359796608L) != 0) );
				setState(181);
				match(FCH);
				setState(182);
				match(T__12);
				setState(183);
				match(AP);
				setState(184);
				((CmdrepeticaoContext)_localctx).c2 = boolexpr();
				setState(185);
				match(FP);

				                    verificaCond(((CmdrepeticaoContext)_localctx).c2.tipoExpr);
				                    String cond2 = addFloatSuffixIfNeeded( normalizeExpr( textOf(((CmdrepeticaoContext)_localctx).c2) ) );

				                    ArrayList<AbstractCommand> corpo = curThread;
				                    curThread = stack.pop();

				                    // do-while(cond) -> while(true){ corpo; if(!(cond)) break; }
				                    CommandEnquanto loop = new CommandEnquanto("true");
				                    for (AbstractCommand c: corpo) loop.addCommand(c);
				                    CommandDecisao breaker = new CommandDecisao("!("+cond2+")");
				                    breaker.addTrueCommand(new AbstractCommand(){ public String generateJavaCode(){ return "break;"; }});
				                    loop.addCommand(breaker);
				                    curThread.add(loop);
				                
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
	public static class CmdforContext extends ParserRuleContext {
		public Token idInit;
		public Expr_or_boolContext eInit;
		public Token idStep;
		public Expr_or_boolContext eStep;
		public BoolexprContext cond;
		public TerminalNode AP() { return getToken(MussumesParser.AP, 0); }
		public List<TerminalNode> ATTR() { return getTokens(MussumesParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(MussumesParser.ATTR, i);
		}
		public List<TerminalNode> SC() { return getTokens(MussumesParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(MussumesParser.SC, i);
		}
		public TerminalNode FP() { return getToken(MussumesParser.FP, 0); }
		public TerminalNode ACH() { return getToken(MussumesParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(MussumesParser.FCH, 0); }
		public List<TerminalNode> ID() { return getTokens(MussumesParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MussumesParser.ID, i);
		}
		public List<Expr_or_boolContext> expr_or_bool() {
			return getRuleContexts(Expr_or_boolContext.class);
		}
		public Expr_or_boolContext expr_or_bool(int i) {
			return getRuleContext(Expr_or_boolContext.class,i);
		}
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdfor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).enterCmdfor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumesListener ) ((MussumesListener)listener).exitCmdfor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitCmdfor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdforContext cmdfor() throws RecognitionException {
		CmdforContext _localctx = new CmdforContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdfor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__14);
			setState(191);
			match(AP);
			setState(192);
			((CmdforContext)_localctx).idInit = match(ID);

			                    Variable v1 = verificaID((((CmdforContext)_localctx).idInit!=null?((CmdforContext)_localctx).idInit.getText():null));
			                    String id1 = (((CmdforContext)_localctx).idInit!=null?((CmdforContext)_localctx).idInit.getText():null);
			                
			setState(194);
			match(ATTR);
			setState(195);
			((CmdforContext)_localctx).eInit = expr_or_bool();
			setState(196);
			match(SC);

			                    if (v1.getType() == Variable.INT && ((CmdforContext)_localctx).eInit.tipoExpr != Variable.INT)
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ id1 +", cumpadis!");
			                    if (v1.getType() == Variable.FLOAT && !(((CmdforContext)_localctx).eInit.tipoExpr == Variable.INT || ((CmdforContext)_localctx).eInit.tipoExpr == Variable.FLOAT))
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ id1 +", cumpadis!");
			                    if (v1.getType() == Variable.TEXT && ((CmdforContext)_localctx).eInit.tipoExpr != Variable.TEXT)
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ id1 +", cumpadis!");
			                    if (v1.getType() == Variable.BOOLEAN && ((CmdforContext)_localctx).eInit.tipoExpr != Variable.BOOLEAN)
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ id1 +", cumpadis!");

			                    String initExpr = normalizeExpr( textOf(((CmdforContext)_localctx).eInit) );
			                    if (v1.getType() == Variable.FLOAT) {
			                        initExpr = addFloatSuffixIfNeeded(initExpr);
			                    }
			                    v1.setInitialized(true);
			                    _forInitId = id1; _forInitExpr = initExpr;
			                
			setState(198);
			((CmdforContext)_localctx).idStep = match(ID);

			                    Variable v2 = verificaID((((CmdforContext)_localctx).idStep!=null?((CmdforContext)_localctx).idStep.getText():null));
			                    String id2 = (((CmdforContext)_localctx).idStep!=null?((CmdforContext)_localctx).idStep.getText():null);
			                
			setState(200);
			match(ATTR);
			setState(201);
			((CmdforContext)_localctx).eStep = expr_or_bool();
			setState(202);
			match(SC);

			                    if (v2.getType() == Variable.INT && ((CmdforContext)_localctx).eStep.tipoExpr != Variable.INT)
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ id2 +", cumpadis!");
			                    if (v2.getType() == Variable.FLOAT && !(((CmdforContext)_localctx).eStep.tipoExpr == Variable.INT || ((CmdforContext)_localctx).eStep.tipoExpr == Variable.FLOAT))
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ id2 +", cumpadis!");
			                    if (v2.getType() == Variable.TEXT && ((CmdforContext)_localctx).eStep.tipoExpr != Variable.TEXT)
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ id2 +", cumpadis!");
			                    if (v2.getType() == Variable.BOOLEAN && ((CmdforContext)_localctx).eStep.tipoExpr != Variable.BOOLEAN)
			                        throw new SemanticException("Tipus incompatívis pra variavis "+ id2 +", cumpadis!");

			                    String stepExpr = normalizeExpr( textOf(((CmdforContext)_localctx).eStep) );
			                    if (v2.getType() == Variable.FLOAT) {
			                        stepExpr = addFloatSuffixIfNeeded(stepExpr);
			                    }
			                    _forStepId = id2; _forStepExpr = stepExpr;
			                
			setState(204);
			((CmdforContext)_localctx).cond = boolexpr();

			                    verificaCond(((CmdforContext)_localctx).cond.tipoExpr);
			                    String condText = addFloatSuffixIfNeeded( normalizeExpr( textOf(((CmdforContext)_localctx).cond) ) );
			                    _exprDecision = condText;
			                
			setState(206);
			match(FP);
			setState(207);
			match(ACH);
			 stack.push(curThread); curThread = new ArrayList<AbstractCommand>(); 
			setState(210); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(209);
				cmd();
				}
				}
				setState(212); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34359796608L) != 0) );
			setState(214);
			match(FCH);

			                    ArrayList<AbstractCommand> corpo = curThread;
			                    curThread = stack.pop();

			                    // init;
			                    curThread.add(new CommandAtribuicao(_forInitId, _forInitExpr));

			                    // while(cond){ corpo; step; }
			                    CommandEnquanto loop = new CommandEnquanto(_exprDecision);
			                    for (AbstractCommand c: corpo) loop.addCommand(c);
			                    loop.addCommand(new CommandAtribuicao(_forStepId, _forStepExpr));
			                    curThread.add(loop);
			                
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
		public BoolexprContext b;
		public ExprContext e;
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitExpr_or_bool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_or_boolContext expr_or_bool() throws RecognitionException {
		Expr_or_boolContext _localctx = new Expr_or_boolContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr_or_bool);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				((Expr_or_boolContext)_localctx).b = boolexpr();
				((Expr_or_boolContext)_localctx).tipoExpr =  ((Expr_or_boolContext)_localctx).b.tipoExpr;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				((Expr_or_boolContext)_localctx).e = expr();
				((Expr_or_boolContext)_localctx).tipoExpr =  ((Expr_or_boolContext)_localctx).e.tipoExpr;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			((ExprContext)_localctx).t1 = termo();
			((ExprContext)_localctx).tipoExpr =  ((ExprContext)_localctx).t1.tipoTermo;
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15 || _la==T__16) {
				{
				{
				setState(227);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(228);
				((ExprContext)_localctx).t2 = termo();

				                if (_localctx.tipoExpr == Variable.FLOAT || ((ExprContext)_localctx).t2.tipoTermo == Variable.FLOAT)
				                    ((ExprContext)_localctx).tipoExpr =  Variable.FLOAT;
				            
				}
				}
				setState(235);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			((TermoContext)_localctx).f1 = fator();
			((TermoContext)_localctx).tipoTermo =  ((TermoContext)_localctx).f1.tipoFator;
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || _la==T__18) {
				{
				{
				setState(238);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(239);
				((TermoContext)_localctx).f2 = fator();

				                if (_localctx.tipoTermo == Variable.FLOAT || ((TermoContext)_localctx).f2.tipoFator == Variable.FLOAT)
				                ((TermoContext)_localctx).tipoTermo =  Variable.FLOAT;
				              
				}
				}
				setState(246);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fator);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(ID);
				 Variable var = verificaID(_input.LT(-1).getText());
				                      if (!var.isInitialized()) {
				                        throw new SemanticException("Variavis " + var.getName() + " não inicializadis, cumpadis!");
				                      }
				                      ((FatorContext)_localctx).tipoFator =  var.getType(); 
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				match(INT);
				 _varValue = _input.LT(-1).getText();
				                      verificaNum(_varValue, Variable.INT);
				                      ((FatorContext)_localctx).tipoFator =  Variable.INT; 
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
				match(FLOAT);
				 _varValue = _input.LT(-1).getText();
				                      verificaNum(_varValue, Variable.FLOAT);
				                      ((FatorContext)_localctx).tipoFator =  Variable.FLOAT; 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(253);
				match(STRING);
				 ((FatorContext)_localctx).tipoFator =  Variable.TEXT; 
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(255);
				match(TRUE);
				 ((FatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(257);
				match(FALSE);
				 ((FatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 7);
				{
				setState(259);
				match(AP);
				setState(260);
				((FatorContext)_localctx).e = expr_or_bool();
				setState(261);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitBoolexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolexprContext boolexpr() throws RecognitionException {
		BoolexprContext _localctx = new BoolexprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			((BoolexprContext)_localctx).b1 = booltermo();
			 ((BoolexprContext)_localctx).tipoExpr =  ((BoolexprContext)_localctx).b1.tipoTermo; 
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(268);
				match(T__19);
				setState(269);
				((BoolexprContext)_localctx).b2 = booltermo();
				 ((BoolexprContext)_localctx).tipoExpr =  Variable.BOOLEAN; 
				}
				}
				setState(276);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitBooltermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooltermoContext booltermo() throws RecognitionException {
		BooltermoContext _localctx = new BooltermoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_booltermo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			((BooltermoContext)_localctx).f1 = boolfator();
			 ((BooltermoContext)_localctx).tipoTermo =  ((BooltermoContext)_localctx).f1.tipoFator; 
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(279);
				match(T__20);
				setState(280);
				((BooltermoContext)_localctx).f2 = boolfator();
				 ((BooltermoContext)_localctx).tipoTermo =  Variable.BOOLEAN; 
				}
				}
				setState(287);
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
		public ComparisonContext c;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitBoolfator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolfatorContext boolfator() throws RecognitionException {
		BoolfatorContext _localctx = new BoolfatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_boolfator);
		try {
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(T__21);
				setState(289);
				((BoolfatorContext)_localctx).f = boolfator();
				 ((BoolfatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				((BoolfatorContext)_localctx).c = comparison();
				 ((BoolfatorContext)_localctx).tipoFator =  ((BoolfatorContext)_localctx).c.tipoFator;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				match(ID);
				 Variable var = verificaID(_input.LT(-1).getText());
				                      if (!var.isInitialized()) {
				                        throw new SemanticException("Variavis " + var.getName() + " não inicializadis, cumpadis!");
				                      }
				                      ((BoolfatorContext)_localctx).tipoFator =  var.getType(); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(297);
				match(TRUE);
				 ((BoolfatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(299);
				match(FALSE);
				 ((BoolfatorContext)_localctx).tipoFator =  Variable.BOOLEAN; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				match(AP);
				setState(302);
				((BoolfatorContext)_localctx).b = boolexpr();
				setState(303);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MussumesVisitor ) return ((MussumesVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			((ComparisonContext)_localctx).left = expr();
			setState(309);
			((ComparisonContext)_localctx).op = match(OPREL);
			setState(310);
			((ComparisonContext)_localctx).right = expr();

			        if (!(((((ComparisonContext)_localctx).left.tipoExpr == Variable.INT || ((ComparisonContext)_localctx).left.tipoExpr == Variable.FLOAT) &&
			               (((ComparisonContext)_localctx).right.tipoExpr == Variable.INT || ((ComparisonContext)_localctx).right.tipoExpr == Variable.FLOAT)) ||
			              (((ComparisonContext)_localctx).left.tipoExpr == ((ComparisonContext)_localctx).right.tipoExpr))) {
			            throw new SemanticException("Tipos incompatíveis na comparação, cumpadis!");
			        }
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
		"\u0004\u0001&\u013a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u00010\b\u0001\n\u0001\f\u0001"+
		"3\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002;\b\u0002\n\u0002\f\u0002>\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003J\b\u0003\u0001\u0004"+
		"\u0004\u0004M\b\u0004\u000b\u0004\f\u0004N\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005W\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0004\tw\b\t\u000b\t\f\tx\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0085\b\t\u000b\t\f"+
		"\t\u0086\u0001\t\u0001\t\u0001\t\u0005\t\u008c\b\t\n\t\f\t\u008f\t\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0004\t\u0095\b\t\u000b\t\f\t\u0096\u0001\t"+
		"\u0001\t\u0001\t\u0003\t\u009c\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u00a7\b\n\u000b\n\f\n\u00a8"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u00b2"+
		"\b\n\u000b\n\f\n\u00b3\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u00bd\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00d3\b\u000b"+
		"\u000b\u000b\f\u000b\u00d4\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00e0\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00e8\b\r\n\r\f\r\u00eb\t\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00f3\b\u000e\n\u000e\f\u000e\u00f6\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0109\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0111\b\u0010\n\u0010\f\u0010\u0114\t\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u011c\b\u0011"+
		"\n\u0011\f\u0011\u011f\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0133\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0000\u0000\u0014"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&\u0000\u0002\u0001\u0000\u0010\u0011\u0001\u0000\u0012"+
		"\u0013\u0149\u0000(\u0001\u0000\u0000\u0000\u00021\u0001\u0000\u0000\u0000"+
		"\u00044\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\bL\u0001"+
		"\u0000\u0000\u0000\nV\u0001\u0000\u0000\u0000\fX\u0001\u0000\u0000\u0000"+
		"\u000e`\u0001\u0000\u0000\u0000\u0010g\u0001\u0000\u0000\u0000\u0012n"+
		"\u0001\u0000\u0000\u0000\u0014\u00bc\u0001\u0000\u0000\u0000\u0016\u00be"+
		"\u0001\u0000\u0000\u0000\u0018\u00df\u0001\u0000\u0000\u0000\u001a\u00e1"+
		"\u0001\u0000\u0000\u0000\u001c\u00ec\u0001\u0000\u0000\u0000\u001e\u0108"+
		"\u0001\u0000\u0000\u0000 \u010a\u0001\u0000\u0000\u0000\"\u0115\u0001"+
		"\u0000\u0000\u0000$\u0132\u0001\u0000\u0000\u0000&\u0134\u0001\u0000\u0000"+
		"\u0000()\u0005\u0001\u0000\u0000)*\u0003\u0002\u0001\u0000*+\u0003\b\u0004"+
		"\u0000+,\u0005\u0002\u0000\u0000,-\u0006\u0000\uffff\uffff\u0000-\u0001"+
		"\u0001\u0000\u0000\u0000.0\u0003\u0004\u0002\u0000/.\u0001\u0000\u0000"+
		"\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000"+
		"\u0000\u00002\u0003\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"45\u0003\u0006\u0003\u000056\u0005#\u0000\u00006<\u0006\u0002\uffff\uffff"+
		"\u000078\u0005\u0017\u0000\u000089\u0005#\u0000\u00009;\u0006\u0002\uffff"+
		"\uffff\u0000:7\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000"+
		"><\u0001\u0000\u0000\u0000?@\u0005\u001c\u0000\u0000@\u0005\u0001\u0000"+
		"\u0000\u0000AB\u0005\u0003\u0000\u0000BJ\u0006\u0003\uffff\uffff\u0000"+
		"CD\u0005\u0004\u0000\u0000DJ\u0006\u0003\uffff\uffff\u0000EF\u0005\u0005"+
		"\u0000\u0000FJ\u0006\u0003\uffff\uffff\u0000GH\u0005\u0006\u0000\u0000"+
		"HJ\u0006\u0003\uffff\uffff\u0000IA\u0001\u0000\u0000\u0000IC\u0001\u0000"+
		"\u0000\u0000IE\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000J\u0007"+
		"\u0001\u0000\u0000\u0000KM\u0003\n\u0005\u0000LK\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000"+
		"\u0000O\t\u0001\u0000\u0000\u0000PW\u0003\f\u0006\u0000QW\u0003\u000e"+
		"\u0007\u0000RW\u0003\u0010\b\u0000SW\u0003\u0012\t\u0000TW\u0003\u0014"+
		"\n\u0000UW\u0003\u0016\u000b\u0000VP\u0001\u0000\u0000\u0000VQ\u0001\u0000"+
		"\u0000\u0000VR\u0001\u0000\u0000\u0000VS\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000VU\u0001\u0000\u0000\u0000W\u000b\u0001\u0000\u0000"+
		"\u0000XY\u0005\u0007\u0000\u0000YZ\u0005\u0018\u0000\u0000Z[\u0005#\u0000"+
		"\u0000[\\\u0006\u0006\uffff\uffff\u0000\\]\u0005\u0019\u0000\u0000]^\u0005"+
		"\u001c\u0000\u0000^_\u0006\u0006\uffff\uffff\u0000_\r\u0001\u0000\u0000"+
		"\u0000`a\u0005\b\u0000\u0000ab\u0005\u0018\u0000\u0000bc\u0003\u0018\f"+
		"\u0000cd\u0005\u0019\u0000\u0000de\u0005\u001c\u0000\u0000ef\u0006\u0007"+
		"\uffff\uffff\u0000f\u000f\u0001\u0000\u0000\u0000gh\u0005#\u0000\u0000"+
		"hi\u0006\b\uffff\uffff\u0000ij\u0005\u001d\u0000\u0000jk\u0003\u0018\f"+
		"\u0000kl\u0006\b\uffff\uffff\u0000lm\u0005\u001c\u0000\u0000m\u0011\u0001"+
		"\u0000\u0000\u0000no\u0005\t\u0000\u0000op\u0005\u0018\u0000\u0000pq\u0003"+
		" \u0010\u0000qr\u0005\u0019\u0000\u0000rs\u0005\n\u0000\u0000st\u0005"+
		"\u001a\u0000\u0000tv\u0006\t\uffff\uffff\u0000uw\u0003\n\u0005\u0000v"+
		"u\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u001b"+
		"\u0000\u0000{\u008d\u0006\t\uffff\uffff\u0000|}\u0005\u000b\u0000\u0000"+
		"}~\u0005\u0018\u0000\u0000~\u007f\u0003 \u0010\u0000\u007f\u0080\u0005"+
		"\u0019\u0000\u0000\u0080\u0081\u0005\n\u0000\u0000\u0081\u0082\u0005\u001a"+
		"\u0000\u0000\u0082\u0084\u0006\t\uffff\uffff\u0000\u0083\u0085\u0003\n"+
		"\u0005\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u001b"+
		"\u0000\u0000\u0089\u008a\u0006\t\uffff\uffff\u0000\u008a\u008c\u0001\u0000"+
		"\u0000\u0000\u008b|\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"+
		"\u0000\u008e\u009b\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005\f\u0000\u0000\u0091\u0092\u0005\u001a\u0000\u0000"+
		"\u0092\u0094\u0006\t\uffff\uffff\u0000\u0093\u0095\u0003\n\u0005\u0000"+
		"\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u001b\u0000\u0000"+
		"\u0099\u009a\u0006\t\uffff\uffff\u0000\u009a\u009c\u0001\u0000\u0000\u0000"+
		"\u009b\u0090\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0006\t\uffff\uffff\u0000"+
		"\u009e\u0013\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\r\u0000\u0000\u00a0"+
		"\u00a1\u0005\u0018\u0000\u0000\u00a1\u00a2\u0003 \u0010\u0000\u00a2\u00a3"+
		"\u0005\u0019\u0000\u0000\u00a3\u00a4\u0005\u001a\u0000\u0000\u00a4\u00a6"+
		"\u0006\n\uffff\uffff\u0000\u00a5\u00a7\u0003\n\u0005\u0000\u00a6\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u001b\u0000\u0000\u00ab\u00ac"+
		"\u0006\n\uffff\uffff\u0000\u00ac\u00bd\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0005\u000e\u0000\u0000\u00ae\u00af\u0005\u001a\u0000\u0000\u00af\u00b1"+
		"\u0006\n\uffff\uffff\u0000\u00b0\u00b2\u0003\n\u0005\u0000\u00b1\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u001b\u0000\u0000\u00b6\u00b7"+
		"\u0005\r\u0000\u0000\u00b7\u00b8\u0005\u0018\u0000\u0000\u00b8\u00b9\u0003"+
		" \u0010\u0000\u00b9\u00ba\u0005\u0019\u0000\u0000\u00ba\u00bb\u0006\n"+
		"\uffff\uffff\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u009f\u0001"+
		"\u0000\u0000\u0000\u00bc\u00ad\u0001\u0000\u0000\u0000\u00bd\u0015\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0005\u000f\u0000\u0000\u00bf\u00c0\u0005"+
		"\u0018\u0000\u0000\u00c0\u00c1\u0005#\u0000\u0000\u00c1\u00c2\u0006\u000b"+
		"\uffff\uffff\u0000\u00c2\u00c3\u0005\u001d\u0000\u0000\u00c3\u00c4\u0003"+
		"\u0018\f\u0000\u00c4\u00c5\u0005\u001c\u0000\u0000\u00c5\u00c6\u0006\u000b"+
		"\uffff\uffff\u0000\u00c6\u00c7\u0005#\u0000\u0000\u00c7\u00c8\u0006\u000b"+
		"\uffff\uffff\u0000\u00c8\u00c9\u0005\u001d\u0000\u0000\u00c9\u00ca\u0003"+
		"\u0018\f\u0000\u00ca\u00cb\u0005\u001c\u0000\u0000\u00cb\u00cc\u0006\u000b"+
		"\uffff\uffff\u0000\u00cc\u00cd\u0003 \u0010\u0000\u00cd\u00ce\u0006\u000b"+
		"\uffff\uffff\u0000\u00ce\u00cf\u0005\u0019\u0000\u0000\u00cf\u00d0\u0005"+
		"\u001a\u0000\u0000\u00d0\u00d2\u0006\u000b\uffff\uffff\u0000\u00d1\u00d3"+
		"\u0003\n\u0005\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005"+
		"\u001b\u0000\u0000\u00d7\u00d8\u0006\u000b\uffff\uffff\u0000\u00d8\u0017"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0003 \u0010\u0000\u00da\u00db\u0006"+
		"\f\uffff\uffff\u0000\u00db\u00e0\u0001\u0000\u0000\u0000\u00dc\u00dd\u0003"+
		"\u001a\r\u0000\u00dd\u00de\u0006\f\uffff\uffff\u0000\u00de\u00e0\u0001"+
		"\u0000\u0000\u0000\u00df\u00d9\u0001\u0000\u0000\u0000\u00df\u00dc\u0001"+
		"\u0000\u0000\u0000\u00e0\u0019\u0001\u0000\u0000\u0000\u00e1\u00e2\u0003"+
		"\u001c\u000e\u0000\u00e2\u00e9\u0006\r\uffff\uffff\u0000\u00e3\u00e4\u0007"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0003\u001c\u000e\u0000\u00e5\u00e6\u0006"+
		"\r\uffff\uffff\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u001b\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0003"+
		"\u001e\u000f\u0000\u00ed\u00f4\u0006\u000e\uffff\uffff\u0000\u00ee\u00ef"+
		"\u0007\u0001\u0000\u0000\u00ef\u00f0\u0003\u001e\u000f\u0000\u00f0\u00f1"+
		"\u0006\u000e\uffff\uffff\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000\u00f2"+
		"\u00ee\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5"+
		"\u001d\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0005#\u0000\u0000\u00f8\u0109\u0006\u000f\uffff\uffff\u0000\u00f9"+
		"\u00fa\u0005%\u0000\u0000\u00fa\u0109\u0006\u000f\uffff\uffff\u0000\u00fb"+
		"\u00fc\u0005$\u0000\u0000\u00fc\u0109\u0006\u000f\uffff\uffff\u0000\u00fd"+
		"\u00fe\u0005&\u0000\u0000\u00fe\u0109\u0006\u000f\uffff\uffff\u0000\u00ff"+
		"\u0100\u0005!\u0000\u0000\u0100\u0109\u0006\u000f\uffff\uffff\u0000\u0101"+
		"\u0102\u0005\"\u0000\u0000\u0102\u0109\u0006\u000f\uffff\uffff\u0000\u0103"+
		"\u0104\u0005\u0018\u0000\u0000\u0104\u0105\u0003\u0018\f\u0000\u0105\u0106"+
		"\u0005\u0019\u0000\u0000\u0106\u0107\u0006\u000f\uffff\uffff\u0000\u0107"+
		"\u0109\u0001\u0000\u0000\u0000\u0108\u00f7\u0001\u0000\u0000\u0000\u0108"+
		"\u00f9\u0001\u0000\u0000\u0000\u0108\u00fb\u0001\u0000\u0000\u0000\u0108"+
		"\u00fd\u0001\u0000\u0000\u0000\u0108\u00ff\u0001\u0000\u0000\u0000\u0108"+
		"\u0101\u0001\u0000\u0000\u0000\u0108\u0103\u0001\u0000\u0000\u0000\u0109"+
		"\u001f\u0001\u0000\u0000\u0000\u010a\u010b\u0003\"\u0011\u0000\u010b\u0112"+
		"\u0006\u0010\uffff\uffff\u0000\u010c\u010d\u0005\u0014\u0000\u0000\u010d"+
		"\u010e\u0003\"\u0011\u0000\u010e\u010f\u0006\u0010\uffff\uffff\u0000\u010f"+
		"\u0111\u0001\u0000\u0000\u0000\u0110\u010c\u0001\u0000\u0000\u0000\u0111"+
		"\u0114\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112"+
		"\u0113\u0001\u0000\u0000\u0000\u0113!\u0001\u0000\u0000\u0000\u0114\u0112"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0003$\u0012\u0000\u0116\u011d\u0006"+
		"\u0011\uffff\uffff\u0000\u0117\u0118\u0005\u0015\u0000\u0000\u0118\u0119"+
		"\u0003$\u0012\u0000\u0119\u011a\u0006\u0011\uffff\uffff\u0000\u011a\u011c"+
		"\u0001\u0000\u0000\u0000\u011b\u0117\u0001\u0000\u0000\u0000\u011c\u011f"+
		"\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d\u011e"+
		"\u0001\u0000\u0000\u0000\u011e#\u0001\u0000\u0000\u0000\u011f\u011d\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0005\u0016\u0000\u0000\u0121\u0122\u0003"+
		"$\u0012\u0000\u0122\u0123\u0006\u0012\uffff\uffff\u0000\u0123\u0133\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\u0003&\u0013\u0000\u0125\u0126\u0006\u0012"+
		"\uffff\uffff\u0000\u0126\u0133\u0001\u0000\u0000\u0000\u0127\u0128\u0005"+
		"#\u0000\u0000\u0128\u0133\u0006\u0012\uffff\uffff\u0000\u0129\u012a\u0005"+
		"!\u0000\u0000\u012a\u0133\u0006\u0012\uffff\uffff\u0000\u012b\u012c\u0005"+
		"\"\u0000\u0000\u012c\u0133\u0006\u0012\uffff\uffff\u0000\u012d\u012e\u0005"+
		"\u0018\u0000\u0000\u012e\u012f\u0003 \u0010\u0000\u012f\u0130\u0005\u0019"+
		"\u0000\u0000\u0130\u0131\u0006\u0012\uffff\uffff\u0000\u0131\u0133\u0001"+
		"\u0000\u0000\u0000\u0132\u0120\u0001\u0000\u0000\u0000\u0132\u0124\u0001"+
		"\u0000\u0000\u0000\u0132\u0127\u0001\u0000\u0000\u0000\u0132\u0129\u0001"+
		"\u0000\u0000\u0000\u0132\u012b\u0001\u0000\u0000\u0000\u0132\u012d\u0001"+
		"\u0000\u0000\u0000\u0133%\u0001\u0000\u0000\u0000\u0134\u0135\u0003\u001a"+
		"\r\u0000\u0135\u0136\u0005\u001e\u0000\u0000\u0136\u0137\u0003\u001a\r"+
		"\u0000\u0137\u0138\u0006\u0013\uffff\uffff\u0000\u0138\'\u0001\u0000\u0000"+
		"\u0000\u00151<INVx\u0086\u008d\u0096\u009b\u00a8\u00b3\u00bc\u00d4\u00df"+
		"\u00e9\u00f4\u0108\u0112\u011d\u0132";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}