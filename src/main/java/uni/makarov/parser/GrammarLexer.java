// Generated from D:/JB/IDEA/UNI_LAB1_V1/src/main/antlr4/uni/makarov/parser\Grammar.g4 by ANTLR 4.9.1
package uni.makarov.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NUMBER=2, EXP=3, MULTIPLY=4, DIVIDE=5, SUB=6, ADD=7, MOD=8, DIV=9, 
		MMAX=10, MMIN=11, WORD=12, CELL_COL=13, CELL_ROW=14, ID=15, LPAREN=16, 
		RPAREN=17, WS=18, ANY=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "LETTER", "DIGIT", "SYMBOLS", "NUMBER", "EXP", "MULTIPLY", "DIVIDE", 
			"SUB", "ADD", "MOD", "DIV", "MMAX", "MMIN", "WORD", "CELL_COL", "CELL_ROW", 
			"ID", "LPAREN", "RPAREN", "WS", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", null, "'^'", "'*'", "'/'", "'-'", "'+'", "'mod'", "'div'", 
			"'mmax'", "'mmin'", null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NUMBER", "EXP", "MULTIPLY", "DIVIDE", "SUB", "ADD", "MOD", 
			"DIV", "MMAX", "MMIN", "WORD", "CELL_COL", "CELL_ROW", "ID", "LPAREN", 
			"RPAREN", "WS", "ANY"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\5\69\n\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\6\5\6B\n"+
		"\6\3\6\6\6E\n\6\r\6\16\6F\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\6\20f\n\20\r\20\16\20g\3\20\5\20k\n\20\3\21\6\21n\n\21"+
		"\r\21\16\21o\3\22\6\22s\n\22\r\22\16\22t\3\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\27\3\27\2\2\30\3\3\5\2\7\2\t\2\13\4\r\5\17"+
		"\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24"+
		"-\25\3\2\7\4\2C\\c|\3\2\62;\b\2#$))\60\60<=AAbb\3\2C\\\5\2\13\f\17\17"+
		"\"\"\2\u0087\2\3\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2"+
		"\2\2\t\65\3\2\2\2\138\3\2\2\2\rH\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23N\3"+
		"\2\2\2\25P\3\2\2\2\27R\3\2\2\2\31V\3\2\2\2\33Z\3\2\2\2\35_\3\2\2\2\37"+
		"j\3\2\2\2!m\3\2\2\2#r\3\2\2\2%v\3\2\2\2\'y\3\2\2\2){\3\2\2\2+}\3\2\2\2"+
		"-\u0081\3\2\2\2/\60\7.\2\2\60\4\3\2\2\2\61\62\t\2\2\2\62\6\3\2\2\2\63"+
		"\64\t\3\2\2\64\b\3\2\2\2\65\66\t\4\2\2\66\n\3\2\2\2\679\7/\2\28\67\3\2"+
		"\2\289\3\2\2\29A\3\2\2\2:<\5\7\4\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2"+
		"\2\2>@\3\2\2\2?=\3\2\2\2@B\7\60\2\2A=\3\2\2\2AB\3\2\2\2BD\3\2\2\2CE\5"+
		"\7\4\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\f\3\2\2\2HI\7`\2\2I\16"+
		"\3\2\2\2JK\7,\2\2K\20\3\2\2\2LM\7\61\2\2M\22\3\2\2\2NO\7/\2\2O\24\3\2"+
		"\2\2PQ\7-\2\2Q\26\3\2\2\2RS\7o\2\2ST\7q\2\2TU\7f\2\2U\30\3\2\2\2VW\7f"+
		"\2\2WX\7k\2\2XY\7x\2\2Y\32\3\2\2\2Z[\7o\2\2[\\\7o\2\2\\]\7c\2\2]^\7z\2"+
		"\2^\34\3\2\2\2_`\7o\2\2`a\7o\2\2ab\7k\2\2bc\7p\2\2c\36\3\2\2\2df\5\5\3"+
		"\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2\2ik\5\t\5\2je\3\2\2"+
		"\2ji\3\2\2\2k \3\2\2\2ln\t\5\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2"+
		"\2p\"\3\2\2\2qs\5\7\4\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2u$\3\2"+
		"\2\2vw\5!\21\2wx\5#\22\2x&\3\2\2\2yz\7*\2\2z(\3\2\2\2{|\7+\2\2|*\3\2\2"+
		"\2}~\t\6\2\2~\177\3\2\2\2\177\u0080\b\26\2\2\u0080,\3\2\2\2\u0081\u0082"+
		"\13\2\2\2\u0082.\3\2\2\2\13\28=AFgjot\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}