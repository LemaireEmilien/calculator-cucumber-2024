package calculator.parser;// Generated from Calculator.g4 by ANTLR 4.13.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CalculatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COS=1, SIN=2, TAN=3, ACOS=4, ASIN=5, ATAN=6, LN=7, LOG=8, SQRT=9, LPAREN=10, 
		RPAREN=11, PLUS=12, MINUS=13, TIMES=14, DIV=15, COMMA=16, POINT=17, POW=18, 
		PI=19, EULER=20, I=21, FRAC=22, VARIABLE=23, SCIENTIFIC_NUMBER=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COS", "SIN", "TAN", "ACOS", "ASIN", "ATAN", "LN", "LOG", "SQRT", "LPAREN", 
			"RPAREN", "PLUS", "MINUS", "TIMES", "DIV", "COMMA", "POINT", "POW", "PI", 
			"EULER", "I", "FRAC", "VARIABLE", "VALID_ID_START", "VALID_ID_CHAR", 
			"SCIENTIFIC_NUMBER", "NUMBER", "E1", "E2", "SIGN", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'cos'", "'sin'", "'tan'", "'acos'", "'asin'", "'atan'", "'ln'", 
			"'log'", "'sqrt'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "','", "'.'", 
			"'^'", "'pi'", null, "'i'", "'\\u2044'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COS", "SIN", "TAN", "ACOS", "ASIN", "ATAN", "LN", "LOG", "SQRT", 
			"LPAREN", "RPAREN", "PLUS", "MINUS", "TIMES", "DIV", "COMMA", "POINT", 
			"POW", "PI", "EULER", "I", "FRAC", "VARIABLE", "SCIENTIFIC_NUMBER", "WS"
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
		"\u0004\u0000\u0019\u00b4\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u0084\b\u0016\n\u0016\f\u0016\u0087\t\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u008d\b\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u0092\b\u0019\u0001\u0019\u0003\u0019\u0095"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0099\b\u0019\u0001\u001a"+
		"\u0004\u001a\u009c\b\u001a\u000b\u001a\f\u001a\u009d\u0001\u001a\u0001"+
		"\u001a\u0004\u001a\u00a2\b\u001a\u000b\u001a\f\u001a\u00a3\u0003\u001a"+
		"\u00a6\b\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0004\u001e\u00af\b\u001e\u000b\u001e\f\u001e"+
		"\u00b0\u0001\u001e\u0001\u001e\u0000\u0000\u001f\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00001\u00003\u00185\u0000"+
		"7\u00009\u0000;\u0000=\u0019\u0001\u0000\u0003\u0003\u0000AZ__az\u0002"+
		"\u0000++--\u0003\u0000\t\n\r\r  \u00b6\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000=\u0001"+
		"\u0000\u0000\u0000\u0001?\u0001\u0000\u0000\u0000\u0003C\u0001\u0000\u0000"+
		"\u0000\u0005G\u0001\u0000\u0000\u0000\u0007K\u0001\u0000\u0000\u0000\t"+
		"P\u0001\u0000\u0000\u0000\u000bU\u0001\u0000\u0000\u0000\rZ\u0001\u0000"+
		"\u0000\u0000\u000f]\u0001\u0000\u0000\u0000\u0011a\u0001\u0000\u0000\u0000"+
		"\u0013f\u0001\u0000\u0000\u0000\u0015h\u0001\u0000\u0000\u0000\u0017j"+
		"\u0001\u0000\u0000\u0000\u0019l\u0001\u0000\u0000\u0000\u001bn\u0001\u0000"+
		"\u0000\u0000\u001dp\u0001\u0000\u0000\u0000\u001fr\u0001\u0000\u0000\u0000"+
		"!t\u0001\u0000\u0000\u0000#v\u0001\u0000\u0000\u0000%x\u0001\u0000\u0000"+
		"\u0000\'{\u0001\u0000\u0000\u0000)}\u0001\u0000\u0000\u0000+\u007f\u0001"+
		"\u0000\u0000\u0000-\u0081\u0001\u0000\u0000\u0000/\u0088\u0001\u0000\u0000"+
		"\u00001\u008c\u0001\u0000\u0000\u00003\u008e\u0001\u0000\u0000\u00005"+
		"\u009b\u0001\u0000\u0000\u00007\u00a7\u0001\u0000\u0000\u00009\u00a9\u0001"+
		"\u0000\u0000\u0000;\u00ab\u0001\u0000\u0000\u0000=\u00ae\u0001\u0000\u0000"+
		"\u0000?@\u0005c\u0000\u0000@A\u0005o\u0000\u0000AB\u0005s\u0000\u0000"+
		"B\u0002\u0001\u0000\u0000\u0000CD\u0005s\u0000\u0000DE\u0005i\u0000\u0000"+
		"EF\u0005n\u0000\u0000F\u0004\u0001\u0000\u0000\u0000GH\u0005t\u0000\u0000"+
		"HI\u0005a\u0000\u0000IJ\u0005n\u0000\u0000J\u0006\u0001\u0000\u0000\u0000"+
		"KL\u0005a\u0000\u0000LM\u0005c\u0000\u0000MN\u0005o\u0000\u0000NO\u0005"+
		"s\u0000\u0000O\b\u0001\u0000\u0000\u0000PQ\u0005a\u0000\u0000QR\u0005"+
		"s\u0000\u0000RS\u0005i\u0000\u0000ST\u0005n\u0000\u0000T\n\u0001\u0000"+
		"\u0000\u0000UV\u0005a\u0000\u0000VW\u0005t\u0000\u0000WX\u0005a\u0000"+
		"\u0000XY\u0005n\u0000\u0000Y\f\u0001\u0000\u0000\u0000Z[\u0005l\u0000"+
		"\u0000[\\\u0005n\u0000\u0000\\\u000e\u0001\u0000\u0000\u0000]^\u0005l"+
		"\u0000\u0000^_\u0005o\u0000\u0000_`\u0005g\u0000\u0000`\u0010\u0001\u0000"+
		"\u0000\u0000ab\u0005s\u0000\u0000bc\u0005q\u0000\u0000cd\u0005r\u0000"+
		"\u0000de\u0005t\u0000\u0000e\u0012\u0001\u0000\u0000\u0000fg\u0005(\u0000"+
		"\u0000g\u0014\u0001\u0000\u0000\u0000hi\u0005)\u0000\u0000i\u0016\u0001"+
		"\u0000\u0000\u0000jk\u0005+\u0000\u0000k\u0018\u0001\u0000\u0000\u0000"+
		"lm\u0005-\u0000\u0000m\u001a\u0001\u0000\u0000\u0000no\u0005*\u0000\u0000"+
		"o\u001c\u0001\u0000\u0000\u0000pq\u0005/\u0000\u0000q\u001e\u0001\u0000"+
		"\u0000\u0000rs\u0005,\u0000\u0000s \u0001\u0000\u0000\u0000tu\u0005.\u0000"+
		"\u0000u\"\u0001\u0000\u0000\u0000vw\u0005^\u0000\u0000w$\u0001\u0000\u0000"+
		"\u0000xy\u0005p\u0000\u0000yz\u0005i\u0000\u0000z&\u0001\u0000\u0000\u0000"+
		"{|\u00039\u001c\u0000|(\u0001\u0000\u0000\u0000}~\u0005i\u0000\u0000~"+
		"*\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u2044\u0000\u0000\u0080,\u0001"+
		"\u0000\u0000\u0000\u0081\u0085\u0003/\u0017\u0000\u0082\u0084\u00031\u0018"+
		"\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000"+
		"\u0000\u0086.\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0007\u0000\u0000\u0000\u00890\u0001\u0000\u0000\u0000\u008a"+
		"\u008d\u0003/\u0017\u0000\u008b\u008d\u000209\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d2\u0001\u0000"+
		"\u0000\u0000\u008e\u0098\u00035\u001a\u0000\u008f\u0092\u00037\u001b\u0000"+
		"\u0090\u0092\u00039\u001c\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0090\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093"+
		"\u0095\u0003;\u001d\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u00035\u001a\u0000\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0091\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u00994\u0001\u0000"+
		"\u0000\u0000\u009a\u009c\u000209\u0000\u009b\u009a\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u00a5\u0001\u0000\u0000\u0000"+
		"\u009f\u00a1\u0005.\u0000\u0000\u00a0\u00a2\u000209\u0000\u00a1\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a5\u009f\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a66\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005"+
		"E\u0000\u0000\u00a88\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005e\u0000"+
		"\u0000\u00aa:\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007\u0001\u0000\u0000"+
		"\u00ac<\u0001\u0000\u0000\u0000\u00ad\u00af\u0007\u0002\u0000\u0000\u00ae"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006\u001e\u0000\u0000\u00b3"+
		">\u0001\u0000\u0000\u0000\n\u0000\u0085\u008c\u0091\u0094\u0098\u009d"+
		"\u00a3\u00a5\u00b0\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}