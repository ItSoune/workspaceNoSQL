package generated;

// Generated from NoSQL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NoSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOREACH=1, IN=2, CREATE_TUPLE=3, SELECT_IF=4, POINT=5, EXCLUDE_IF=6, PAROUVR=7, 
		PARFERM=8, AND=9, OR=10, AS=11, MATCHES=12, OUTPUT=13, COMMA=14, SQL_WORD=15, 
		OPERATOR=16, STRING=17, FLOAT=18, INT=19, WHITESPACE=20;
	public static final String[] tokenNames = {
		"<INVALID>", "'foreach'", "'in'", "'create_tuple'", "'select_if'", "'.'", 
		"'exclude_if'", "'('", "')'", "'and'", "'or'", "'as'", "'matches'", "'output'", 
		"','", "SQL_WORD", "OPERATOR", "STRING", "FLOAT", "INT", "WHITESPACE"
	};
	public static final int
		RULE_start = 0, RULE_expression = 1, RULE_variable = 2, RULE_relation = 3, 
		RULE_attribute = 4, RULE_listattr = 5, RULE_iteration = 6, RULE_listit = 7, 
		RULE_block = 8, RULE_selection = 9, RULE_listexcl = 10, RULE_exclusion = 11, 
		RULE_condition = 12, RULE_logical = 13, RULE_data = 14, RULE_comparaison = 15, 
		RULE_output = 16;
	public static final String[] ruleNames = {
		"start", "expression", "variable", "relation", "attribute", "listattr", 
		"iteration", "listit", "block", "selection", "listexcl", "exclusion", 
		"condition", "logical", "data", "comparaison", "output"
	};

	@Override
	public String getGrammarFileName() { return "NoSQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NoSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(NoSQLParser.EOF, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOREACH) {
				{
				{
				setState(34); expression();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40); match(EOF);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ListitContext listit() {
			return getRuleContext(ListitContext.class,0);
		}
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); listit();
			setState(43); block();
			setState(44); output();
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode SQL_WORD() { return getToken(NoSQLParser.SQL_WORD, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(SQL_WORD);
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

	public static class RelationContext extends ParserRuleContext {
		public TerminalNode SQL_WORD() { return getToken(NoSQLParser.SQL_WORD, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitRelation(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(SQL_WORD);
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

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode POINT() { return getToken(NoSQLParser.POINT, 0); }
		public TerminalNode SQL_WORD() { return getToken(NoSQLParser.SQL_WORD, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attribute);
		try {
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50); match(SQL_WORD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); variable();
				setState(52); match(POINT);
				setState(53); match(SQL_WORD);
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

	public static class ListattrContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(NoSQLParser.COMMA); }
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(NoSQLParser.COMMA, i);
		}
		public ListattrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listattr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterListattr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitListattr(this);
		}
	}

	public final ListattrContext listattr() throws RecognitionException {
		ListattrContext _localctx = new ListattrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_listattr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(57); attribute();
					setState(58); match(COMMA);
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(65); attribute();
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

	public static class IterationContext extends ParserRuleContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public TerminalNode FOREACH() { return getToken(NoSQLParser.FOREACH, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode IN() { return getToken(NoSQLParser.IN, 0); }
		public IterationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterIteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitIteration(this);
		}
	}

	public final IterationContext iteration() throws RecognitionException {
		IterationContext _localctx = new IterationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_iteration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); match(FOREACH);
			setState(68); variable();
			setState(69); match(IN);
			setState(70); relation();
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

	public static class ListitContext extends ParserRuleContext {
		public IterationContext iteration(int i) {
			return getRuleContext(IterationContext.class,i);
		}
		public List<IterationContext> iteration() {
			return getRuleContexts(IterationContext.class);
		}
		public TerminalNode CREATE_TUPLE() { return getToken(NoSQLParser.CREATE_TUPLE, 0); }
		public ListitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterListit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitListit(this);
		}
	}

	public final ListitContext listit() throws RecognitionException {
		ListitContext _localctx = new ListitContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72); iteration();
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FOREACH );
			setState(77); match(CREATE_TUPLE);
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

	public static class BlockContext extends ParserRuleContext {
		public ListexclContext listexcl() {
			return getRuleContext(ListexclContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			setState(84);
			switch (_input.LA(1)) {
			case SELECT_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(79); selection();
				setState(81);
				_la = _input.LA(1);
				if (_la==EXCLUDE_IF) {
					{
					setState(80); listexcl();
					}
				}

				}
				break;
			case EXCLUDE_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); listexcl();
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

	public static class SelectionContext extends ParserRuleContext {
		public TerminalNode SELECT_IF() { return getToken(NoSQLParser.SELECT_IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitSelection(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(SELECT_IF);
			setState(87); condition();
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

	public static class ListexclContext extends ParserRuleContext {
		public List<ExclusionContext> exclusion() {
			return getRuleContexts(ExclusionContext.class);
		}
		public ExclusionContext exclusion(int i) {
			return getRuleContext(ExclusionContext.class,i);
		}
		public ListexclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listexcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterListexcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitListexcl(this);
		}
	}

	public final ListexclContext listexcl() throws RecognitionException {
		ListexclContext _localctx = new ListexclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_listexcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89); exclusion();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EXCLUDE_IF );
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

	public static class ExclusionContext extends ParserRuleContext {
		public TerminalNode EXCLUDE_IF() { return getToken(NoSQLParser.EXCLUDE_IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExclusionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterExclusion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitExclusion(this);
		}
	}

	public final ExclusionContext exclusion() throws RecognitionException {
		ExclusionContext _localctx = new ExclusionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exclusion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(EXCLUDE_IF);
			setState(95); condition();
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

	public static class ConditionContext extends ParserRuleContext {
		public List<LogicalContext> logical() {
			return getRuleContexts(LogicalContext.class);
		}
		public LogicalContext logical(int i) {
			return getRuleContext(LogicalContext.class,i);
		}
		public TerminalNode AND(int i) {
			return getToken(NoSQLParser.AND, i);
		}
		public List<TerminalNode> AND() { return getTokens(NoSQLParser.AND); }
		public List<TerminalNode> OR() { return getTokens(NoSQLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(NoSQLParser.OR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_condition);
		try {
			int _alt;
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); logical();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(98); logical();
						setState(99); match(AND);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(103); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(105); logical();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(107); logical();
						setState(108); match(OR);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(112); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(114); logical();
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

	public static class LogicalContext extends ParserRuleContext {
		public ComparaisonContext comparaison() {
			return getRuleContext(ComparaisonContext.class,0);
		}
		public LogicalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitLogical(this);
		}
	}

	public final LogicalContext logical() throws RecognitionException {
		LogicalContext _localctx = new LogicalContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_logical);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); comparaison();
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

	public static class DataContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(NoSQLParser.STRING, 0); }
		public TerminalNode INT() { return getToken(NoSQLParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(NoSQLParser.FLOAT, 0); }
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitData(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << FLOAT) | (1L << INT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ComparaisonContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode OPERATOR() { return getToken(NoSQLParser.OPERATOR, 0); }
		public ComparaisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparaison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterComparaison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitComparaison(this);
		}
	}

	public final ComparaisonContext comparaison() throws RecognitionException {
		ComparaisonContext _localctx = new ComparaisonContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparaison);
		try {
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); attribute();
				setState(123); match(OPERATOR);
				setState(124); data();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126); attribute();
				setState(127); match(OPERATOR);
				setState(128); attribute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130); data();
				setState(131); match(OPERATOR);
				setState(132); attribute();
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

	public static class OutputContext extends ParserRuleContext {
		public TerminalNode OUTPUT() { return getToken(NoSQLParser.OUTPUT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ListattrContext listattr() {
			return getRuleContext(ListattrContext.class,0);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitOutput(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); match(OUTPUT);
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(137); listattr();
				}
				break;
			case 2:
				{
				setState(138); variable();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u0090\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\5\6:\n\6\3\7\3\7\3\7\7\7?\n\7\f\7\16\7B\13\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\6\tL\n\t\r\t\16\tM\3\t\3\t\3\n\3\n\5\nT\n\n"+
		"\3\n\5\nW\n\n\3\13\3\13\3\13\3\f\6\f]\n\f\r\f\16\f^\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\6\16h\n\16\r\16\16\16i\3\16\3\16\3\16\3\16\3\16\6\16q\n"+
		"\16\r\16\16\16r\3\16\3\16\5\16w\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0089\n\21\3\22\3\22"+
		"\3\22\5\22\u008e\n\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"\2\3\3\2\23\25\u008c\2\'\3\2\2\2\4,\3\2\2\2\6\60\3\2\2\2\b\62\3"+
		"\2\2\2\n9\3\2\2\2\f@\3\2\2\2\16E\3\2\2\2\20K\3\2\2\2\22V\3\2\2\2\24X\3"+
		"\2\2\2\26\\\3\2\2\2\30`\3\2\2\2\32v\3\2\2\2\34x\3\2\2\2\36z\3\2\2\2 \u0088"+
		"\3\2\2\2\"\u008a\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3"+
		"\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7\2\2\3+\3\3\2\2\2,-\5\20\t\2-.\5\22\n\2"+
		"./\5\"\22\2/\5\3\2\2\2\60\61\7\21\2\2\61\7\3\2\2\2\62\63\7\21\2\2\63\t"+
		"\3\2\2\2\64:\7\21\2\2\65\66\5\6\4\2\66\67\7\7\2\2\678\7\21\2\28:\3\2\2"+
		"\29\64\3\2\2\29\65\3\2\2\2:\13\3\2\2\2;<\5\n\6\2<=\7\20\2\2=?\3\2\2\2"+
		">;\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\5\n\6\2"+
		"D\r\3\2\2\2EF\7\3\2\2FG\5\6\4\2GH\7\4\2\2HI\5\b\5\2I\17\3\2\2\2JL\5\16"+
		"\b\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\5\2\2P\21\3"+
		"\2\2\2QS\5\24\13\2RT\5\26\f\2SR\3\2\2\2ST\3\2\2\2TW\3\2\2\2UW\5\26\f\2"+
		"VQ\3\2\2\2VU\3\2\2\2W\23\3\2\2\2XY\7\6\2\2YZ\5\32\16\2Z\25\3\2\2\2[]\5"+
		"\30\r\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\27\3\2\2\2`a\7\b\2"+
		"\2ab\5\32\16\2b\31\3\2\2\2cw\5\34\17\2de\5\34\17\2ef\7\13\2\2fh\3\2\2"+
		"\2gd\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\5\34\17\2lw\3\2"+
		"\2\2mn\5\34\17\2no\7\f\2\2oq\3\2\2\2pm\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3"+
		"\2\2\2st\3\2\2\2tu\5\34\17\2uw\3\2\2\2vc\3\2\2\2vg\3\2\2\2vp\3\2\2\2w"+
		"\33\3\2\2\2xy\5 \21\2y\35\3\2\2\2z{\t\2\2\2{\37\3\2\2\2|}\5\n\6\2}~\7"+
		"\22\2\2~\177\5\36\20\2\177\u0089\3\2\2\2\u0080\u0081\5\n\6\2\u0081\u0082"+
		"\7\22\2\2\u0082\u0083\5\n\6\2\u0083\u0089\3\2\2\2\u0084\u0085\5\36\20"+
		"\2\u0085\u0086\7\22\2\2\u0086\u0087\5\n\6\2\u0087\u0089\3\2\2\2\u0088"+
		"|\3\2\2\2\u0088\u0080\3\2\2\2\u0088\u0084\3\2\2\2\u0089!\3\2\2\2\u008a"+
		"\u008d\7\17\2\2\u008b\u008e\5\f\7\2\u008c\u008e\5\6\4\2\u008d\u008b\3"+
		"\2\2\2\u008d\u008c\3\2\2\2\u008e#\3\2\2\2\16\'9@MSV^irv\u0088\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}