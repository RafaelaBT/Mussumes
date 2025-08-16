// Generated from ./Mussumes.g4 by ANTLR 4.13.2
package parser;
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
		T__0=1, T__1=2, T__2=3, T__3=4, AP=5, FP=6, SC=7, OP=8, ATTR=9, WS=10, 
		ID=11, NUMBER=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "AP", "FP", "SC", "OP", "ATTR", "WS", 
			"ID", "NUMBER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'iniciavis'", "'fimis'", "'levis'", "'escrevis'", "'('", "')'", 
			"';'", null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "AP", "FP", "SC", "OP", "ATTR", "WS", "ID", 
			"NUMBER"
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
		"\u0004\u0000\fZ\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\nI\b\n\n\n\f\nL\t\n\u0001"+
		"\u000b\u0004\u000bO\b\u000b\u000b\u000b\f\u000bP\u0001\u000b\u0001\u000b"+
		"\u0004\u000bU\b\u000b\u000b\u000b\f\u000bV\u0003\u000bY\b\u000b\u0000"+
		"\u0000\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0001\u0000"+
		"\u0004\u0003\u0000*+--//\u0003\u0000\t\n\r\r  \u0002\u0000AZaz\u0003\u0000"+
		"09AZaz]\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001"+
		"\u0019\u0001\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005)\u0001"+
		"\u0000\u0000\u0000\u0007/\u0001\u0000\u0000\u0000\t8\u0001\u0000\u0000"+
		"\u0000\u000b:\u0001\u0000\u0000\u0000\r<\u0001\u0000\u0000\u0000\u000f"+
		">\u0001\u0000\u0000\u0000\u0011@\u0001\u0000\u0000\u0000\u0013B\u0001"+
		"\u0000\u0000\u0000\u0015F\u0001\u0000\u0000\u0000\u0017N\u0001\u0000\u0000"+
		"\u0000\u0019\u001a\u0005i\u0000\u0000\u001a\u001b\u0005n\u0000\u0000\u001b"+
		"\u001c\u0005i\u0000\u0000\u001c\u001d\u0005c\u0000\u0000\u001d\u001e\u0005"+
		"i\u0000\u0000\u001e\u001f\u0005a\u0000\u0000\u001f \u0005v\u0000\u0000"+
		" !\u0005i\u0000\u0000!\"\u0005s\u0000\u0000\"\u0002\u0001\u0000\u0000"+
		"\u0000#$\u0005f\u0000\u0000$%\u0005i\u0000\u0000%&\u0005m\u0000\u0000"+
		"&\'\u0005i\u0000\u0000\'(\u0005s\u0000\u0000(\u0004\u0001\u0000\u0000"+
		"\u0000)*\u0005l\u0000\u0000*+\u0005e\u0000\u0000+,\u0005v\u0000\u0000"+
		",-\u0005i\u0000\u0000-.\u0005s\u0000\u0000.\u0006\u0001\u0000\u0000\u0000"+
		"/0\u0005e\u0000\u000001\u0005s\u0000\u000012\u0005c\u0000\u000023\u0005"+
		"r\u0000\u000034\u0005e\u0000\u000045\u0005v\u0000\u000056\u0005i\u0000"+
		"\u000067\u0005s\u0000\u00007\b\u0001\u0000\u0000\u000089\u0005(\u0000"+
		"\u00009\n\u0001\u0000\u0000\u0000:;\u0005)\u0000\u0000;\f\u0001\u0000"+
		"\u0000\u0000<=\u0005;\u0000\u0000=\u000e\u0001\u0000\u0000\u0000>?\u0007"+
		"\u0000\u0000\u0000?\u0010\u0001\u0000\u0000\u0000@A\u0005=\u0000\u0000"+
		"A\u0012\u0001\u0000\u0000\u0000BC\u0007\u0001\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DE\u0006\t\u0000\u0000E\u0014\u0001\u0000\u0000\u0000FJ\u0007"+
		"\u0002\u0000\u0000GI\u0007\u0003\u0000\u0000HG\u0001\u0000\u0000\u0000"+
		"IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000"+
		"\u0000K\u0016\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MO\u0002"+
		"09\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000QX\u0001\u0000\u0000\u0000RT\u0005"+
		".\u0000\u0000SU\u000209\u0000TS\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001"+
		"\u0000\u0000\u0000XR\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"Y\u0018\u0001\u0000\u0000\u0000\u0005\u0000JPVX\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}