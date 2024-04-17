package calculator.parser;// Generated from Calculator.g4 by ANTLR 4.13.1

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CalculatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COS=1, SIN=2, TAN=3, ACOS=4, ASIN=5, ATAN=6, LN=7, LOG=8, SQRT=9, LPAREN=10, 
		RPAREN=11, PLUS=12, MINUS=13, TIMES=14, DIV=15, COMMA=16, POINT=17, POW=18, 
		PI=19, EULER=20, I=21, FRAC=22, VARIABLE=23, SCIENTIFIC_NUMBER=24, WS=25;
	public static final int
		RULE_init = 0, RULE_expression = 1, RULE_multiplyingExpression = 2, RULE_powExpression = 3, 
		RULE_postfix_expression = 4, RULE_prefix_expression = 5, RULE_signedAtom = 6, 
		RULE_atom = 7, RULE_rational = 8, RULE_scientific = 9, RULE_constant = 10, 
		RULE_variable = 11, RULE_func_ = 12, RULE_funcname = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "expression", "multiplyingExpression", "powExpression", "postfix_expression", 
			"prefix_expression", "signedAtom", "atom", "rational", "scientific", 
			"constant", "variable", "func_", "funcname"
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

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculatorParser.EOF, 0); }
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Prefix_expressionContext prefix_expression() {
			return getRuleContext(Prefix_expressionContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				expression(0);
				setState(29);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				postfix_expression();
				setState(32);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				prefix_expression();
				setState(35);
				match(EOF);
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
	public static class ExpressionContext extends ParserRuleContext {
		public MultiplyingExpressionContext multiplyingExpression() {
			return getRuleContext(MultiplyingExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CalculatorParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(40);
			multiplyingExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(42);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(43);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(44);
					multiplyingExpression(0);
					}
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplyingExpressionContext extends ParserRuleContext {
		public PowExpressionContext powExpression() {
			return getRuleContext(PowExpressionContext.class,0);
		}
		public List<TerminalNode> LPAREN() { return getTokens(CalculatorParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(CalculatorParser.LPAREN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(CalculatorParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(CalculatorParser.RPAREN, i);
		}
		public MultiplyingExpressionContext multiplyingExpression() {
			return getRuleContext(MultiplyingExpressionContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(CalculatorParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(CalculatorParser.DIV, 0); }
		public MultiplyingExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyingExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitMultiplyingExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyingExpressionContext multiplyingExpression() throws RecognitionException {
		return multiplyingExpression(0);
	}

	private MultiplyingExpressionContext multiplyingExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplyingExpressionContext _localctx = new MultiplyingExpressionContext(_ctx, _parentState);
		MultiplyingExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_multiplyingExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(51);
				powExpression();
				}
				break;
			case 2:
				{
				setState(52);
				match(LPAREN);
				setState(53);
				expression(0);
				setState(54);
				match(RPAREN);
				setState(59); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(55);
						match(LPAREN);
						setState(56);
						expression(0);
						setState(57);
						match(RPAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(61); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiplyingExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplyingExpression);
					setState(65);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					{
					setState(66);
					_la = _input.LA(1);
					if ( !(_la==TIMES || _la==DIV) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(67);
					powExpression();
					}
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PowExpressionContext extends ParserRuleContext {
		public SignedAtomContext signedAtom() {
			return getRuleContext(SignedAtomContext.class,0);
		}
		public TerminalNode POW() { return getToken(CalculatorParser.POW, 0); }
		public PowExpressionContext powExpression() {
			return getRuleContext(PowExpressionContext.class,0);
		}
		public PowExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitPowExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowExpressionContext powExpression() throws RecognitionException {
		PowExpressionContext _localctx = new PowExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_powExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			signedAtom();
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(74);
				match(POW);
				setState(75);
				powExpression();
				}
				break;
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
	public static class Postfix_expressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public TerminalNode PLUS() { return getToken(CalculatorParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(CalculatorParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(CalculatorParser.DIV, 0); }
		public List<Postfix_expressionContext> postfix_expression() {
			return getRuleContexts(Postfix_expressionContext.class);
		}
		public Postfix_expressionContext postfix_expression(int i) {
			return getRuleContext(Postfix_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CalculatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CalculatorParser.COMMA, i);
		}
		public SignedAtomContext signedAtom() {
			return getRuleContext(SignedAtomContext.class,0);
		}
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitPostfix_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_postfix_expression);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(LPAREN);
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(79);
					postfix_expression();
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(80);
						match(COMMA);
						}
					}

					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 28850174L) != 0) );
				setState(87);
				match(RPAREN);
				setState(88);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				signedAtom();
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
	public static class Prefix_expressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public TerminalNode PLUS() { return getToken(CalculatorParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(CalculatorParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(CalculatorParser.DIV, 0); }
		public List<Prefix_expressionContext> prefix_expression() {
			return getRuleContexts(Prefix_expressionContext.class);
		}
		public Prefix_expressionContext prefix_expression(int i) {
			return getRuleContext(Prefix_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CalculatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CalculatorParser.COMMA, i);
		}
		public SignedAtomContext signedAtom() {
			return getRuleContext(SignedAtomContext.class,0);
		}
		public Prefix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitPrefix_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_expressionContext prefix_expression() throws RecognitionException {
		Prefix_expressionContext _localctx = new Prefix_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_prefix_expression);
		int _la;
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(94);
				match(LPAREN);
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					prefix_expression();
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(96);
						match(COMMA);
						}
					}

					}
					}
					setState(101); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 28899326L) != 0) );
				setState(103);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				signedAtom();
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
	public static class SignedAtomContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(CalculatorParser.PLUS, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public Func_Context func_() {
			return getRuleContext(Func_Context.class,0);
		}
		public SignedAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitSignedAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignedAtomContext signedAtom() throws RecognitionException {
		SignedAtomContext _localctx = new SignedAtomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_signedAtom);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(PLUS);
				setState(109);
				atom();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(MINUS);
				setState(111);
				atom();
				}
				break;
			case COS:
			case SIN:
			case TAN:
			case ACOS:
			case ASIN:
			case ATAN:
			case LN:
			case LOG:
			case SQRT:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				func_();
				}
				break;
			case LPAREN:
			case PI:
			case EULER:
			case I:
			case VARIABLE:
			case SCIENTIFIC_NUMBER:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				atom();
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
	public static class AtomContext extends ParserRuleContext {
		public ScientificContext scientific() {
			return getRuleContext(ScientificContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public RationalContext rational() {
			return getRuleContext(RationalContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atom);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				scientific();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				constant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				rational();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				match(LPAREN);
				setState(121);
				expression(0);
				setState(122);
				match(RPAREN);
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
	public static class RationalContext extends ParserRuleContext {
		public List<ScientificContext> scientific() {
			return getRuleContexts(ScientificContext.class);
		}
		public ScientificContext scientific(int i) {
			return getRuleContext(ScientificContext.class,i);
		}
		public TerminalNode FRAC() { return getToken(CalculatorParser.FRAC, 0); }
		public RationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rational; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitRational(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RationalContext rational() throws RecognitionException {
		RationalContext _localctx = new RationalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rational);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			scientific();
			setState(127);
			match(FRAC);
			setState(128);
			scientific();
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
	public static class ScientificContext extends ParserRuleContext {
		public TerminalNode SCIENTIFIC_NUMBER() { return getToken(CalculatorParser.SCIENTIFIC_NUMBER, 0); }
		public ScientificContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scientific; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitScientific(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScientificContext scientific() throws RecognitionException {
		ScientificContext _localctx = new ScientificContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_scientific);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(SCIENTIFIC_NUMBER);
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
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode PI() { return getToken(CalculatorParser.PI, 0); }
		public TerminalNode EULER() { return getToken(CalculatorParser.EULER, 0); }
		public TerminalNode I() { return getToken(CalculatorParser.I, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(CalculatorParser.VARIABLE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(VARIABLE);
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
	public static class Func_Context extends ParserRuleContext {
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CalculatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CalculatorParser.COMMA, i);
		}
		public Func_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitFunc_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_Context func_() throws RecognitionException {
		Func_Context _localctx = new Func_Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_func_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			funcname();
			setState(137);
			match(LPAREN);
			setState(138);
			expression(0);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(139);
				match(COMMA);
				setState(140);
				expression(0);
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			match(RPAREN);
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
	public static class FuncnameContext extends ParserRuleContext {
		public TerminalNode COS() { return getToken(CalculatorParser.COS, 0); }
		public TerminalNode TAN() { return getToken(CalculatorParser.TAN, 0); }
		public TerminalNode SIN() { return getToken(CalculatorParser.SIN, 0); }
		public TerminalNode ACOS() { return getToken(CalculatorParser.ACOS, 0); }
		public TerminalNode ATAN() { return getToken(CalculatorParser.ATAN, 0); }
		public TerminalNode ASIN() { return getToken(CalculatorParser.ASIN, 0); }
		public TerminalNode LOG() { return getToken(CalculatorParser.LOG, 0); }
		public TerminalNode LN() { return getToken(CalculatorParser.LN, 0); }
		public TerminalNode SQRT() { return getToken(CalculatorParser.SQRT, 0); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor) return ((CalculatorVisitor<? extends T>)visitor).visitFuncname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funcname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1022L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 2:
			return multiplyingExpression_sempred((MultiplyingExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplyingExpression_sempred(MultiplyingExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u0097\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000&\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001.\b\u0001\n\u0001\f\u00011\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0004\u0002<\b\u0002\u000b\u0002\f\u0002"+
		"=\u0003\u0002@\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"E\b\u0002\n\u0002\f\u0002H\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003M\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"R\b\u0004\u0004\u0004T\b\u0004\u000b\u0004\f\u0004U\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\\\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005b\b\u0005\u0004\u0005d\b\u0005"+
		"\u000b\u0005\f\u0005e\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"k\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006s\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"}\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u008e\b\f\n\f\f\f\u0091\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0000\u0002\u0002\u0004\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u0000\u0005\u0001\u0000\f\r\u0001\u0000"+
		"\u000e\u000f\u0001\u0000\f\u000f\u0001\u0000\u0013\u0015\u0001\u0000\u0001"+
		"\t\u009d\u0000%\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000"+
		"\u0004?\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\b[\u0001"+
		"\u0000\u0000\u0000\nj\u0001\u0000\u0000\u0000\fr\u0001\u0000\u0000\u0000"+
		"\u000e|\u0001\u0000\u0000\u0000\u0010~\u0001\u0000\u0000\u0000\u0012\u0082"+
		"\u0001\u0000\u0000\u0000\u0014\u0084\u0001\u0000\u0000\u0000\u0016\u0086"+
		"\u0001\u0000\u0000\u0000\u0018\u0088\u0001\u0000\u0000\u0000\u001a\u0094"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0002\u0001\u0000\u001d\u001e"+
		"\u0005\u0000\u0000\u0001\u001e&\u0001\u0000\u0000\u0000\u001f \u0003\b"+
		"\u0004\u0000 !\u0005\u0000\u0000\u0001!&\u0001\u0000\u0000\u0000\"#\u0003"+
		"\n\u0005\u0000#$\u0005\u0000\u0000\u0001$&\u0001\u0000\u0000\u0000%\u001c"+
		"\u0001\u0000\u0000\u0000%\u001f\u0001\u0000\u0000\u0000%\"\u0001\u0000"+
		"\u0000\u0000&\u0001\u0001\u0000\u0000\u0000\'(\u0006\u0001\uffff\uffff"+
		"\u0000()\u0003\u0004\u0002\u0000)/\u0001\u0000\u0000\u0000*+\n\u0001\u0000"+
		"\u0000+,\u0007\u0000\u0000\u0000,.\u0003\u0004\u0002\u0000-*\u0001\u0000"+
		"\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001"+
		"\u0000\u0000\u00000\u0003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000"+
		"\u000023\u0006\u0002\uffff\uffff\u00003@\u0003\u0006\u0003\u000045\u0005"+
		"\n\u0000\u000056\u0003\u0002\u0001\u00006;\u0005\u000b\u0000\u000078\u0005"+
		"\n\u0000\u000089\u0003\u0002\u0001\u00009:\u0005\u000b\u0000\u0000:<\u0001"+
		"\u0000\u0000\u0000;7\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000"+
		"\u0000?2\u0001\u0000\u0000\u0000?4\u0001\u0000\u0000\u0000@F\u0001\u0000"+
		"\u0000\u0000AB\n\u0002\u0000\u0000BC\u0007\u0001\u0000\u0000CE\u0003\u0006"+
		"\u0003\u0000DA\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001"+
		"\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0005\u0001\u0000\u0000"+
		"\u0000HF\u0001\u0000\u0000\u0000IL\u0003\f\u0006\u0000JK\u0005\u0012\u0000"+
		"\u0000KM\u0003\u0006\u0003\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000M\u0007\u0001\u0000\u0000\u0000NS\u0005\n\u0000\u0000OQ\u0003"+
		"\b\u0004\u0000PR\u0005\u0010\u0000\u0000QP\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SO\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WX\u0005\u000b\u0000\u0000XY\u0007\u0002"+
		"\u0000\u0000Y\\\u0001\u0000\u0000\u0000Z\\\u0003\f\u0006\u0000[N\u0001"+
		"\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\t\u0001\u0000\u0000\u0000"+
		"]^\u0007\u0002\u0000\u0000^c\u0005\n\u0000\u0000_a\u0003\n\u0005\u0000"+
		"`b\u0005\u0010\u0000\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bd\u0001\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000gh\u0005\u000b\u0000\u0000hk\u0001\u0000\u0000\u0000"+
		"ik\u0003\f\u0006\u0000j]\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000"+
		"k\u000b\u0001\u0000\u0000\u0000lm\u0005\f\u0000\u0000ms\u0003\u000e\u0007"+
		"\u0000no\u0005\r\u0000\u0000os\u0003\u000e\u0007\u0000ps\u0003\u0018\f"+
		"\u0000qs\u0003\u000e\u0007\u0000rl\u0001\u0000\u0000\u0000rn\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000s\r\u0001"+
		"\u0000\u0000\u0000t}\u0003\u0012\t\u0000u}\u0003\u0016\u000b\u0000v}\u0003"+
		"\u0014\n\u0000w}\u0003\u0010\b\u0000xy\u0005\n\u0000\u0000yz\u0003\u0002"+
		"\u0001\u0000z{\u0005\u000b\u0000\u0000{}\u0001\u0000\u0000\u0000|t\u0001"+
		"\u0000\u0000\u0000|u\u0001\u0000\u0000\u0000|v\u0001\u0000\u0000\u0000"+
		"|w\u0001\u0000\u0000\u0000|x\u0001\u0000\u0000\u0000}\u000f\u0001\u0000"+
		"\u0000\u0000~\u007f\u0003\u0012\t\u0000\u007f\u0080\u0005\u0016\u0000"+
		"\u0000\u0080\u0081\u0003\u0012\t\u0000\u0081\u0011\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0005\u0018\u0000\u0000\u0083\u0013\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0007\u0003\u0000\u0000\u0085\u0015\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005\u0017\u0000\u0000\u0087\u0017\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0003\u001a\r\u0000\u0089\u008a\u0005\n\u0000\u0000\u008a"+
		"\u008f\u0003\u0002\u0001\u0000\u008b\u008c\u0005\u0010\u0000\u0000\u008c"+
		"\u008e\u0003\u0002\u0001\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u000b\u0000\u0000\u0093"+
		"\u0019\u0001\u0000\u0000\u0000\u0094\u0095\u0007\u0004\u0000\u0000\u0095"+
		"\u001b\u0001\u0000\u0000\u0000\u000f%/=?FLQU[aejr|\u008f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}