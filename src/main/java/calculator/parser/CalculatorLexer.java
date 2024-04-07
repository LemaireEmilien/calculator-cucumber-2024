package calculator.parser;// Generated from Calculator.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CalculatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COS=1, SIN=2, TAN=3, ACOS=4, ASIN=5, ATAN=6, LN=7, LOG=8, SQRT=9, LPAREN=10, 
		RPAREN=11, PLUS=12, MINUS=13, TIMES=14, DIV=15, GT=16, LT=17, EQ=18, COMMA=19, 
		POINT=20, POW=21, PI=22, EULER=23, I=24, VARIABLE=25, SCIENTIFIC_NUMBER=26, 
		WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COS", "SIN", "TAN", "ACOS", "ASIN", "ATAN", "LN", "LOG", "SQRT", "LPAREN", 
			"RPAREN", "PLUS", "MINUS", "TIMES", "DIV", "GT", "LT", "EQ", "COMMA", 
			"POINT", "POW", "PI", "EULER", "I", "VARIABLE", "VALID_ID_START", "VALID_ID_CHAR", 
			"SCIENTIFIC_NUMBER", "NUMBER", "E1", "E2", "SIGN", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'cos'", "'sin'", "'tan'", "'acos'", "'asin'", "'atan'", "'ln'", 
			"'log'", "'sqrt'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", 
			"'='", "','", "'.'", "'^'", "'pi'", null, "'i'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COS", "SIN", "TAN", "ACOS", "ASIN", "ATAN", "LN", "LOG", "SQRT", 
			"LPAREN", "RPAREN", "PLUS", "MINUS", "TIMES", "DIV", "GT", "LT", "EQ", 
			"COMMA", "POINT", "POW", "PI", "EULER", "I", "VARIABLE", "SCIENTIFIC_NUMBER", 
			"WS"
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


	public CalculatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

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
		"\u0004\u0000\u001b\u00bc\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u008c\b\u0018\n\u0018\f\u0018\u008f\t\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u0095\b\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u009a\b\u001b\u0001\u001b\u0003\u001b"+
		"\u009d\b\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u00a1\b\u001b\u0001"+
		"\u001c\u0004\u001c\u00a4\b\u001c\u000b\u001c\f\u001c\u00a5\u0001\u001c"+
		"\u0001\u001c\u0004\u001c\u00aa\b\u001c\u000b\u001c\f\u001c\u00ab\u0003"+
		"\u001c\u00ae\b\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001 \u0004 \u00b7\b \u000b \f \u00b8\u0001 \u0001"+
		" \u0000\u0000!\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u00005\u00007\u001a9\u0000;\u0000=\u0000"+
		"?\u0000A\u001b\u0001\u0000\u0003\u0003\u0000AZ__az\u0002\u0000++--\u0003"+
		"\u0000\t\n\r\r  \u00be\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0001"+
		"C\u0001\u0000\u0000\u0000\u0003G\u0001\u0000\u0000\u0000\u0005K\u0001"+
		"\u0000\u0000\u0000\u0007O\u0001\u0000\u0000\u0000\tT\u0001\u0000\u0000"+
		"\u0000\u000bY\u0001\u0000\u0000\u0000\r^\u0001\u0000\u0000\u0000\u000f"+
		"a\u0001\u0000\u0000\u0000\u0011e\u0001\u0000\u0000\u0000\u0013j\u0001"+
		"\u0000\u0000\u0000\u0015l\u0001\u0000\u0000\u0000\u0017n\u0001\u0000\u0000"+
		"\u0000\u0019p\u0001\u0000\u0000\u0000\u001br\u0001\u0000\u0000\u0000\u001d"+
		"t\u0001\u0000\u0000\u0000\u001fv\u0001\u0000\u0000\u0000!x\u0001\u0000"+
		"\u0000\u0000#z\u0001\u0000\u0000\u0000%|\u0001\u0000\u0000\u0000\'~\u0001"+
		"\u0000\u0000\u0000)\u0080\u0001\u0000\u0000\u0000+\u0082\u0001\u0000\u0000"+
		"\u0000-\u0085\u0001\u0000\u0000\u0000/\u0087\u0001\u0000\u0000\u00001"+
		"\u0089\u0001\u0000\u0000\u00003\u0090\u0001\u0000\u0000\u00005\u0094\u0001"+
		"\u0000\u0000\u00007\u0096\u0001\u0000\u0000\u00009\u00a3\u0001\u0000\u0000"+
		"\u0000;\u00af\u0001\u0000\u0000\u0000=\u00b1\u0001\u0000\u0000\u0000?"+
		"\u00b3\u0001\u0000\u0000\u0000A\u00b6\u0001\u0000\u0000\u0000CD\u0005"+
		"c\u0000\u0000DE\u0005o\u0000\u0000EF\u0005s\u0000\u0000F\u0002\u0001\u0000"+
		"\u0000\u0000GH\u0005s\u0000\u0000HI\u0005i\u0000\u0000IJ\u0005n\u0000"+
		"\u0000J\u0004\u0001\u0000\u0000\u0000KL\u0005t\u0000\u0000LM\u0005a\u0000"+
		"\u0000MN\u0005n\u0000\u0000N\u0006\u0001\u0000\u0000\u0000OP\u0005a\u0000"+
		"\u0000PQ\u0005c\u0000\u0000QR\u0005o\u0000\u0000RS\u0005s\u0000\u0000"+
		"S\b\u0001\u0000\u0000\u0000TU\u0005a\u0000\u0000UV\u0005s\u0000\u0000"+
		"VW\u0005i\u0000\u0000WX\u0005n\u0000\u0000X\n\u0001\u0000\u0000\u0000"+
		"YZ\u0005a\u0000\u0000Z[\u0005t\u0000\u0000[\\\u0005a\u0000\u0000\\]\u0005"+
		"n\u0000\u0000]\f\u0001\u0000\u0000\u0000^_\u0005l\u0000\u0000_`\u0005"+
		"n\u0000\u0000`\u000e\u0001\u0000\u0000\u0000ab\u0005l\u0000\u0000bc\u0005"+
		"o\u0000\u0000cd\u0005g\u0000\u0000d\u0010\u0001\u0000\u0000\u0000ef\u0005"+
		"s\u0000\u0000fg\u0005q\u0000\u0000gh\u0005r\u0000\u0000hi\u0005t\u0000"+
		"\u0000i\u0012\u0001\u0000\u0000\u0000jk\u0005(\u0000\u0000k\u0014\u0001"+
		"\u0000\u0000\u0000lm\u0005)\u0000\u0000m\u0016\u0001\u0000\u0000\u0000"+
		"no\u0005+\u0000\u0000o\u0018\u0001\u0000\u0000\u0000pq\u0005-\u0000\u0000"+
		"q\u001a\u0001\u0000\u0000\u0000rs\u0005*\u0000\u0000s\u001c\u0001\u0000"+
		"\u0000\u0000tu\u0005/\u0000\u0000u\u001e\u0001\u0000\u0000\u0000vw\u0005"+
		">\u0000\u0000w \u0001\u0000\u0000\u0000xy\u0005<\u0000\u0000y\"\u0001"+
		"\u0000\u0000\u0000z{\u0005=\u0000\u0000{$\u0001\u0000\u0000\u0000|}\u0005"+
		",\u0000\u0000}&\u0001\u0000\u0000\u0000~\u007f\u0005.\u0000\u0000\u007f"+
		"(\u0001\u0000\u0000\u0000\u0080\u0081\u0005^\u0000\u0000\u0081*\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005p\u0000\u0000\u0083\u0084\u0005i\u0000"+
		"\u0000\u0084,\u0001\u0000\u0000\u0000\u0085\u0086\u0003=\u001e\u0000\u0086"+
		".\u0001\u0000\u0000\u0000\u0087\u0088\u0005i\u0000\u0000\u00880\u0001"+
		"\u0000\u0000\u0000\u0089\u008d\u00033\u0019\u0000\u008a\u008c\u00035\u001a"+
		"\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"+
		"\u0000\u008e2\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0007\u0000\u0000\u0000\u00914\u0001\u0000\u0000\u0000\u0092"+
		"\u0095\u00033\u0019\u0000\u0093\u0095\u000209\u0000\u0094\u0092\u0001"+
		"\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u00956\u0001\u0000"+
		"\u0000\u0000\u0096\u00a0\u00039\u001c\u0000\u0097\u009a\u0003;\u001d\u0000"+
		"\u0098\u009a\u0003=\u001e\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b"+
		"\u009d\u0003?\u001f\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u00039\u001c\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u0099\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a18\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a4\u000209\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00ad\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a9\u0005.\u0000\u0000\u00a8\u00aa\u000209\u0000\u00a9\u00a8"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ad\u00a7\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae:\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"E\u0000\u0000\u00b0<\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005e\u0000"+
		"\u0000\u00b2>\u0001\u0000\u0000\u0000\u00b3\u00b4\u0007\u0001\u0000\u0000"+
		"\u00b4@\u0001\u0000\u0000\u0000\u00b5\u00b7\u0007\u0002\u0000\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0006 \u0000\u0000\u00bbB\u0001"+
		"\u0000\u0000\u0000\n\u0000\u008d\u0094\u0099\u009c\u00a0\u00a5\u00ab\u00ad"+
		"\u00b8\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}