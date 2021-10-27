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
			"T__0", "LETTER", "DIGIT", "NUMBER", "EXP", "MULTIPLY", "DIVIDE", "SUB", 
			"ADD", "MOD", "DIV", "MMAX", "MMIN", "WORD", "CELL_COL", "CELL_ROW", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4\3\5\7"+
		"\5\65\n\5\f\5\16\58\13\5\3\5\5\5;\n\5\3\5\6\5>\n\5\r\5\16\5?\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\6\17_\n\17\r\17\16\17`"+
		"\3\20\6\20d\n\20\r\20\16\20e\3\21\6\21i\n\21\r\21\16\21j\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\2\2\27\3\3\5\2\7\2"+
		"\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21"+
		"%\22\'\23)\24+\25\3\2\6\4\2C\\c|\3\2\62;\3\2C\\\5\2\13\f\17\17\"\"\2|"+
		"\2\3\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t:\3\2\2"+
		"\2\13A\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2\23I\3\2\2\2\25K\3\2"+
		"\2\2\27O\3\2\2\2\31S\3\2\2\2\33X\3\2\2\2\35^\3\2\2\2\37c\3\2\2\2!h\3\2"+
		"\2\2#l\3\2\2\2%o\3\2\2\2\'q\3\2\2\2)s\3\2\2\2+w\3\2\2\2-.\7.\2\2.\4\3"+
		"\2\2\2/\60\t\2\2\2\60\6\3\2\2\2\61\62\t\3\2\2\62\b\3\2\2\2\63\65\5\7\4"+
		"\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28"+
		"\66\3\2\2\29;\7\60\2\2:\66\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\5\7\4\2=<\3\2"+
		"\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\n\3\2\2\2AB\7`\2\2B\f\3\2\2\2CD\7"+
		",\2\2D\16\3\2\2\2EF\7\61\2\2F\20\3\2\2\2GH\7/\2\2H\22\3\2\2\2IJ\7-\2\2"+
		"J\24\3\2\2\2KL\7o\2\2LM\7q\2\2MN\7f\2\2N\26\3\2\2\2OP\7f\2\2PQ\7k\2\2"+
		"QR\7x\2\2R\30\3\2\2\2ST\7o\2\2TU\7o\2\2UV\7c\2\2VW\7z\2\2W\32\3\2\2\2"+
		"XY\7o\2\2YZ\7o\2\2Z[\7k\2\2[\\\7p\2\2\\\34\3\2\2\2]_\5\5\3\2^]\3\2\2\2"+
		"_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\36\3\2\2\2bd\t\4\2\2cb\3\2\2\2de\3\2\2"+
		"\2ec\3\2\2\2ef\3\2\2\2f \3\2\2\2gi\5\7\4\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2"+
		"\2jk\3\2\2\2k\"\3\2\2\2lm\5\37\20\2mn\5!\21\2n$\3\2\2\2op\7*\2\2p&\3\2"+
		"\2\2qr\7+\2\2r(\3\2\2\2st\t\5\2\2tu\3\2\2\2uv\b\25\2\2v*\3\2\2\2wx\13"+
		"\2\2\2x,\3\2\2\2\t\2\66:?`ej\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}