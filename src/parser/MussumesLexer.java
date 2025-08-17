// Generated from ./Mussumes.g4 by ANTLR 4.13.2
package parser;

    import datastructures.Symbol;
    import datastructures.Variable;
    import datastructures.SymbolTable;
    import exceptions.SemanticException;
    import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MussumesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, VIR=7, AP=8, FP=9, SC=10, 
		OP=11, ATTR=12, WS=13, ID=14, NUMBER=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "VIR", "AP", "FP", "SC", 
			"OP", "ATTR", "WS", "ID", "NUMBER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'iniciavis'", "'fimis'", "'numeris'", "'letris'", "'levis'", "'escrevis'", 
			"','", "'('", "')'", "';'", null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "VIR", "AP", "FP", "SC", "OP", 
			"ATTR", "WS", "ID", "NUMBER"
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


	    private int _tipo;
	    private String _varName;
	    private String _varValue;
	    private SymbolTable symbolTable = new SymbolTable();
	    private Symbol symbol;

	    public void adicionaID(String id) {
	        if (symbolTable.exists(_varName)){
	            throw new SemanticException("Esse "+_varName+" já existis, cumpadis!");
	        }
	        symbolTable.add(symbol);
	        System.out.println("Variavis "+ symbol.getName() +" adicionadus!");
	    }

	    public void verificaID(String id) {
	        if(!symbolTable.exists(id)) {
	            throw new SemanticException("Esse "+id+" num existis, cumpadis!");
	        }
	    }


	public MussumesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mussumes.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000fq\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005"+
		"\r`\b\r\n\r\f\rc\t\r\u0001\u000e\u0004\u000ef\b\u000e\u000b\u000e\f\u000e"+
		"g\u0001\u000e\u0001\u000e\u0004\u000el\b\u000e\u000b\u000e\f\u000em\u0003"+
		"\u000ep\b\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0004\u0003"+
		"\u0000*+--//\u0003\u0000\t\n\r\r  \u0002\u0000AZaz\u0003\u000009AZazt"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000\u0000\u0000\u0003)\u0001"+
		"\u0000\u0000\u0000\u0005/\u0001\u0000\u0000\u0000\u00077\u0001\u0000\u0000"+
		"\u0000\t>\u0001\u0000\u0000\u0000\u000bD\u0001\u0000\u0000\u0000\rM\u0001"+
		"\u0000\u0000\u0000\u000fO\u0001\u0000\u0000\u0000\u0011Q\u0001\u0000\u0000"+
		"\u0000\u0013S\u0001\u0000\u0000\u0000\u0015U\u0001\u0000\u0000\u0000\u0017"+
		"W\u0001\u0000\u0000\u0000\u0019Y\u0001\u0000\u0000\u0000\u001b]\u0001"+
		"\u0000\u0000\u0000\u001de\u0001\u0000\u0000\u0000\u001f \u0005i\u0000"+
		"\u0000 !\u0005n\u0000\u0000!\"\u0005i\u0000\u0000\"#\u0005c\u0000\u0000"+
		"#$\u0005i\u0000\u0000$%\u0005a\u0000\u0000%&\u0005v\u0000\u0000&\'\u0005"+
		"i\u0000\u0000\'(\u0005s\u0000\u0000(\u0002\u0001\u0000\u0000\u0000)*\u0005"+
		"f\u0000\u0000*+\u0005i\u0000\u0000+,\u0005m\u0000\u0000,-\u0005i\u0000"+
		"\u0000-.\u0005s\u0000\u0000.\u0004\u0001\u0000\u0000\u0000/0\u0005n\u0000"+
		"\u000001\u0005u\u0000\u000012\u0005m\u0000\u000023\u0005e\u0000\u0000"+
		"34\u0005r\u0000\u000045\u0005i\u0000\u000056\u0005s\u0000\u00006\u0006"+
		"\u0001\u0000\u0000\u000078\u0005l\u0000\u000089\u0005e\u0000\u00009:\u0005"+
		"t\u0000\u0000:;\u0005r\u0000\u0000;<\u0005i\u0000\u0000<=\u0005s\u0000"+
		"\u0000=\b\u0001\u0000\u0000\u0000>?\u0005l\u0000\u0000?@\u0005e\u0000"+
		"\u0000@A\u0005v\u0000\u0000AB\u0005i\u0000\u0000BC\u0005s\u0000\u0000"+
		"C\n\u0001\u0000\u0000\u0000DE\u0005e\u0000\u0000EF\u0005s\u0000\u0000"+
		"FG\u0005c\u0000\u0000GH\u0005r\u0000\u0000HI\u0005e\u0000\u0000IJ\u0005"+
		"v\u0000\u0000JK\u0005i\u0000\u0000KL\u0005s\u0000\u0000L\f\u0001\u0000"+
		"\u0000\u0000MN\u0005,\u0000\u0000N\u000e\u0001\u0000\u0000\u0000OP\u0005"+
		"(\u0000\u0000P\u0010\u0001\u0000\u0000\u0000QR\u0005)\u0000\u0000R\u0012"+
		"\u0001\u0000\u0000\u0000ST\u0005;\u0000\u0000T\u0014\u0001\u0000\u0000"+
		"\u0000UV\u0007\u0000\u0000\u0000V\u0016\u0001\u0000\u0000\u0000WX\u0005"+
		"=\u0000\u0000X\u0018\u0001\u0000\u0000\u0000YZ\u0007\u0001\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[\\\u0006\f\u0000\u0000\\\u001a\u0001\u0000"+
		"\u0000\u0000]a\u0007\u0002\u0000\u0000^`\u0007\u0003\u0000\u0000_^\u0001"+
		"\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000b\u001c\u0001\u0000\u0000\u0000ca\u0001\u0000"+
		"\u0000\u0000df\u000209\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000ho\u0001\u0000"+
		"\u0000\u0000ik\u0005.\u0000\u0000jl\u000209\u0000kj\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000np\u0001\u0000\u0000\u0000oi\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000p\u001e\u0001\u0000\u0000\u0000\u0005\u0000agmo\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}