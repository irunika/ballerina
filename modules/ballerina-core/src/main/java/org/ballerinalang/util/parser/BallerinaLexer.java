/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.util.parser;// Generated from docs/grammar/Ballerina.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BallerinaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, IntegerLiteral=83, FloatingPointLiteral=84, BooleanLiteral=85, 
		StringInterpolationTemplateStart=86, StringInterpolationTemplateMiddle=87, 
		StringInterpolationTemplateEnd=88, QuotedStringLiteral=89, BacktickStringLiteral=90, 
		NullLiteral=91, Identifier=92, WS=93, NEW_LINE=94, LINE_COMMENT=95;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
		"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
		"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "T__63", "T__64", 
		"T__65", "T__66", "T__67", "T__68", "T__69", "T__70", "T__71", "T__72", 
		"T__73", "T__74", "T__75", "T__76", "T__77", "T__78", "T__79", "T__80", 
		"T__81", "IntegerLiteral", "DecimalIntegerLiteral", "HexIntegerLiteral", 
		"OctalIntegerLiteral", "BinaryIntegerLiteral", "IntegerTypeSuffix", "DecimalNumeral", 
		"Digits", "Digit", "NonZeroDigit", "DigitOrUnderscore", "Underscores", 
		"HexNumeral", "HexDigits", "HexDigit", "HexDigitOrUnderscore", "OctalNumeral", 
		"OctalDigits", "OctalDigit", "OctalDigitOrUnderscore", "BinaryNumeral", 
		"BinaryDigits", "BinaryDigit", "BinaryDigitOrUnderscore", "FloatingPointLiteral", 
		"DecimalFloatingPointLiteral", "ExponentPart", "ExponentIndicator", "SignedInteger", 
		"Sign", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", "HexSignificand", 
		"BinaryExponent", "BinaryExponentIndicator", "BooleanLiteral", "StringInterpolationTemplateStart", 
		"StringInterpolationTemplateMiddle", "StringInterpolationTemplateEnd", 
		"QuotedStringLiteral", "BacktickStringLiteral", "ValidBackTickStringCharacters", 
		"ValidBackTickStringCharacter", "StringCharacters", "StringCharacter", 
		"EscapeSequence", "OctalEscape", "UnicodeEscape", "ZeroToThree", "NullLiteral", 
		"Identifier", "Letter", "LetterOrDigit", "WS", "NEW_LINE", "LINE_COMMENT", 
		"IdentifierLiteral", "IdentifierLiteralChar", "IdentifierLiteralEscapeSequence"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'package'", "';'", "'.'", "'import'", "'as'", "'service'", "'<'", 
		"'>'", "'{'", "'}'", "'resource'", "'('", "')'", "'native'", "'function'", 
		"'connector'", "'action'", "'struct'", "'annotation'", "'attach'", "','", 
		"'='", "'typemapper'", "'const'", "'parameter'", "'worker'", "'any'", 
		"'['", "']'", "'boolean'", "'int'", "'float'", "'string'", "'blob'", "'message'", 
		"'map'", "'xml'", "'xmlDocument'", "'json'", "'datatable'", "'@'", "':'", 
		"'transform'", "'create'", "'var'", "'if'", "'else'", "'iterate'", "'while'", 
		"'continue'", "'break'", "'fork'", "'join'", "'some'", "'all'", "'timeout'", 
		"'try'", "'catch'", "'finally'", "'throw'", "'return'", "'reply'", "'->'", 
		"'<-'", "'@['", "'transaction'", "'aborted'", "'committed'", "'abort'", 
		"'+'", "'-'", "'!'", "'^'", "'/'", "'*'", "'%'", "'<='", "'>='", "'=='", 
		"'!='", "'&&'", "'||'", null, null, null, null, null, null, null, null, 
		"'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "IntegerLiteral", 
		"FloatingPointLiteral", "BooleanLiteral", "StringInterpolationTemplateStart", 
		"StringInterpolationTemplateMiddle", "StringInterpolationTemplateEnd", 
		"QuotedStringLiteral", "BacktickStringLiteral", "NullLiteral", "Identifier", 
		"WS", "NEW_LINE", "LINE_COMMENT"
	};
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


	    boolean isStringExpression = false;


	public BallerinaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ballerina.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 118:
			StringInterpolationTemplateStart_action((RuleContext)_localctx, actionIndex);
			break;
		case 120:
			StringInterpolationTemplateEnd_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void StringInterpolationTemplateStart_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			isStringExpression = true;
			break;
		}
	}
	private void StringInterpolationTemplateEnd_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			isStringExpression = false;
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 119:
			return StringInterpolationTemplateMiddle_sempred((RuleContext)_localctx, predIndex);
		case 120:
			return StringInterpolationTemplateEnd_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean StringInterpolationTemplateMiddle_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isStringExpression;
		}
		return true;
	}
	private boolean StringInterpolationTemplateEnd_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isStringExpression;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2a\u0435\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#"+
		"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-"+
		"\3-\3-\3.\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3"+
		"\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38"+
		"\38\38\39\39\39\39\39\39\39\39\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<"+
		"\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?"+
		"\3?\3@\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3D"+
		"\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F"+
		"\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3P"+
		"\3Q\3Q\3Q\3R\3R\3R\3S\3S\3S\3T\3T\3T\3T\5T\u02d1\nT\3U\3U\5U\u02d5\nU"+
		"\3V\3V\5V\u02d9\nV\3W\3W\5W\u02dd\nW\3X\3X\5X\u02e1\nX\3Y\3Y\3Z\3Z\3Z"+
		"\5Z\u02e8\nZ\3Z\3Z\3Z\5Z\u02ed\nZ\5Z\u02ef\nZ\3[\3[\7[\u02f3\n[\f[\16"+
		"[\u02f6\13[\3[\5[\u02f9\n[\3\\\3\\\5\\\u02fd\n\\\3]\3]\3^\3^\5^\u0303"+
		"\n^\3_\6_\u0306\n_\r_\16_\u0307\3`\3`\3`\3`\3a\3a\7a\u0310\na\fa\16a\u0313"+
		"\13a\3a\5a\u0316\na\3b\3b\3c\3c\5c\u031c\nc\3d\3d\5d\u0320\nd\3d\3d\3"+
		"e\3e\7e\u0326\ne\fe\16e\u0329\13e\3e\5e\u032c\ne\3f\3f\3g\3g\5g\u0332"+
		"\ng\3h\3h\3h\3h\3i\3i\7i\u033a\ni\fi\16i\u033d\13i\3i\5i\u0340\ni\3j\3"+
		"j\3k\3k\5k\u0346\nk\3l\3l\5l\u034a\nl\3m\3m\3m\5m\u034f\nm\3m\5m\u0352"+
		"\nm\3m\5m\u0355\nm\3m\3m\3m\5m\u035a\nm\3m\5m\u035d\nm\3m\3m\3m\5m\u0362"+
		"\nm\3m\3m\3m\5m\u0367\nm\3n\3n\3n\3o\3o\3p\5p\u036f\np\3p\3p\3q\3q\3r"+
		"\3r\3s\3s\3s\5s\u037a\ns\3t\3t\5t\u037e\nt\3t\3t\3t\5t\u0383\nt\3t\3t"+
		"\5t\u0387\nt\3u\3u\3u\3v\3v\3w\3w\3w\3w\3w\3w\3w\3w\3w\5w\u0397\nw\3x"+
		"\3x\5x\u039b\nx\3x\3x\3x\3x\3x\3y\3y\3y\5y\u03a5\ny\3y\3y\3y\3z\3z\3z"+
		"\5z\u03ad\nz\3z\3z\3z\3{\3{\5{\u03b4\n{\3{\3{\3|\3|\3|\3|\3}\6}\u03bd"+
		"\n}\r}\16}\u03be\3~\3~\3~\3~\3~\5~\u03c6\n~\3\177\6\177\u03c9\n\177\r"+
		"\177\16\177\u03ca\3\u0080\3\u0080\5\u0080\u03cf\n\u0080\3\u0081\3\u0081"+
		"\3\u0081\3\u0081\3\u0081\3\u0081\5\u0081\u03d7\n\u0081\3\u0082\3\u0082"+
		"\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082"+
		"\5\u0082\u03e4\n\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0084\3\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0086"+
		"\3\u0086\7\u0086\u03f6\n\u0086\f\u0086\16\u0086\u03f9\13\u0086\3\u0086"+
		"\5\u0086\u03fc\n\u0086\3\u0087\3\u0087\3\u0087\3\u0087\5\u0087\u0402\n"+
		"\u0087\3\u0088\3\u0088\3\u0088\3\u0088\5\u0088\u0408\n\u0088\3\u0089\6"+
		"\u0089\u040b\n\u0089\r\u0089\16\u0089\u040c\3\u0089\3\u0089\3\u008a\6"+
		"\u008a\u0412\n\u008a\r\u008a\16\u008a\u0413\3\u008a\3\u008a\3\u008b\3"+
		"\u008b\3\u008b\3\u008b\7\u008b\u041c\n\u008b\f\u008b\16\u008b\u041f\13"+
		"\u008b\3\u008c\3\u008c\6\u008c\u0423\n\u008c\r\u008c\16\u008c\u0424\3"+
		"\u008c\3\u008c\3\u008d\3\u008d\5\u008d\u042b\n\u008d\3\u008e\3\u008e\3"+
		"\u008e\3\u008e\3\u008e\3\u008e\3\u008e\5\u008e\u0434\n\u008e\2\2\u008f"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o"+
		"9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH"+
		"\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\u00a5T\u00a7U\u00a9\2\u00ab\2\u00ad\2\u00af\2\u00b1\2\u00b3\2"+
		"\u00b5\2\u00b7\2\u00b9\2\u00bb\2\u00bd\2\u00bf\2\u00c1\2\u00c3\2\u00c5"+
		"\2\u00c7\2\u00c9\2\u00cb\2\u00cd\2\u00cf\2\u00d1\2\u00d3\2\u00d5\2\u00d7"+
		"V\u00d9\2\u00db\2\u00dd\2\u00df\2\u00e1\2\u00e3\2\u00e5\2\u00e7\2\u00e9"+
		"\2\u00eb\2\u00edW\u00efX\u00f1Y\u00f3Z\u00f5[\u00f7\\\u00f9\2\u00fb\2"+
		"\u00fd\2\u00ff\2\u0101\2\u0103\2\u0105\2\u0107\2\u0109]\u010b^\u010d\2"+
		"\u010f\2\u0111_\u0113`\u0115a\u0117\2\u0119\2\u011b\2\3\2\36\4\2NNnn\3"+
		"\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62\63\4\2GGgg\4\2--//\6"+
		"\2FFHHffhh\4\2RRrr\3\2bb\b\2^^ddhhppttvv\5\2$$&&^^\n\2$$))^^ddhhppttv"+
		"v\3\2&&\3\2\62\65\5\2C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802\udc01\3"+
		"\2\udc02\ue001\6\2\62;C\\aac|\4\2\13\13\"\"\4\2\f\f\16\17\4\2\f\f\17\17"+
		"\6\2\n\f\16\17^^~~\6\2$$\61\61^^~~\7\2ddhhppttvv\u044b\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q"+
		"\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2"+
		"\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087"+
		"\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2"+
		"\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2"+
		"\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00d7\3\2\2\2\2\u00ed"+
		"\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2\2\2\u00f5\3\2\2"+
		"\2\2\u00f7\3\2\2\2\2\u0109\3\2\2\2\2\u010b\3\2\2\2\2\u0111\3\2\2\2\2\u0113"+
		"\3\2\2\2\2\u0115\3\2\2\2\3\u011d\3\2\2\2\5\u0125\3\2\2\2\7\u0127\3\2\2"+
		"\2\t\u0129\3\2\2\2\13\u0130\3\2\2\2\r\u0133\3\2\2\2\17\u013b\3\2\2\2\21"+
		"\u013d\3\2\2\2\23\u013f\3\2\2\2\25\u0141\3\2\2\2\27\u0143\3\2\2\2\31\u014c"+
		"\3\2\2\2\33\u014e\3\2\2\2\35\u0150\3\2\2\2\37\u0157\3\2\2\2!\u0160\3\2"+
		"\2\2#\u016a\3\2\2\2%\u0171\3\2\2\2\'\u0178\3\2\2\2)\u0183\3\2\2\2+\u018a"+
		"\3\2\2\2-\u018c\3\2\2\2/\u018e\3\2\2\2\61\u0199\3\2\2\2\63\u019f\3\2\2"+
		"\2\65\u01a9\3\2\2\2\67\u01b0\3\2\2\29\u01b4\3\2\2\2;\u01b6\3\2\2\2=\u01b8"+
		"\3\2\2\2?\u01c0\3\2\2\2A\u01c4\3\2\2\2C\u01ca\3\2\2\2E\u01d1\3\2\2\2G"+
		"\u01d6\3\2\2\2I\u01de\3\2\2\2K\u01e2\3\2\2\2M\u01e6\3\2\2\2O\u01f2\3\2"+
		"\2\2Q\u01f7\3\2\2\2S\u0201\3\2\2\2U\u0203\3\2\2\2W\u0205\3\2\2\2Y\u020f"+
		"\3\2\2\2[\u0216\3\2\2\2]\u021a\3\2\2\2_\u021d\3\2\2\2a\u0222\3\2\2\2c"+
		"\u022a\3\2\2\2e\u0230\3\2\2\2g\u0239\3\2\2\2i\u023f\3\2\2\2k\u0244\3\2"+
		"\2\2m\u0249\3\2\2\2o\u024e\3\2\2\2q\u0252\3\2\2\2s\u025a\3\2\2\2u\u025e"+
		"\3\2\2\2w\u0264\3\2\2\2y\u026c\3\2\2\2{\u0272\3\2\2\2}\u0279\3\2\2\2\177"+
		"\u027f\3\2\2\2\u0081\u0282\3\2\2\2\u0083\u0285\3\2\2\2\u0085\u0288\3\2"+
		"\2\2\u0087\u0294\3\2\2\2\u0089\u029c\3\2\2\2\u008b\u02a6\3\2\2\2\u008d"+
		"\u02ac\3\2\2\2\u008f\u02ae\3\2\2\2\u0091\u02b0\3\2\2\2\u0093\u02b2\3\2"+
		"\2\2\u0095\u02b4\3\2\2\2\u0097\u02b6\3\2\2\2\u0099\u02b8\3\2\2\2\u009b"+
		"\u02ba\3\2\2\2\u009d\u02bd\3\2\2\2\u009f\u02c0\3\2\2\2\u00a1\u02c3\3\2"+
		"\2\2\u00a3\u02c6\3\2\2\2\u00a5\u02c9\3\2\2\2\u00a7\u02d0\3\2\2\2\u00a9"+
		"\u02d2\3\2\2\2\u00ab\u02d6\3\2\2\2\u00ad\u02da\3\2\2\2\u00af\u02de\3\2"+
		"\2\2\u00b1\u02e2\3\2\2\2\u00b3\u02ee\3\2\2\2\u00b5\u02f0\3\2\2\2\u00b7"+
		"\u02fc\3\2\2\2\u00b9\u02fe\3\2\2\2\u00bb\u0302\3\2\2\2\u00bd\u0305\3\2"+
		"\2\2\u00bf\u0309\3\2\2\2\u00c1\u030d\3\2\2\2\u00c3\u0317\3\2\2\2\u00c5"+
		"\u031b\3\2\2\2\u00c7\u031d\3\2\2\2\u00c9\u0323\3\2\2\2\u00cb\u032d\3\2"+
		"\2\2\u00cd\u0331\3\2\2\2\u00cf\u0333\3\2\2\2\u00d1\u0337\3\2\2\2\u00d3"+
		"\u0341\3\2\2\2\u00d5\u0345\3\2\2\2\u00d7\u0349\3\2\2\2\u00d9\u0366\3\2"+
		"\2\2\u00db\u0368\3\2\2\2\u00dd\u036b\3\2\2\2\u00df\u036e\3\2\2\2\u00e1"+
		"\u0372\3\2\2\2\u00e3\u0374\3\2\2\2\u00e5\u0376\3\2\2\2\u00e7\u0386\3\2"+
		"\2\2\u00e9\u0388\3\2\2\2\u00eb\u038b\3\2\2\2\u00ed\u0396\3\2\2\2\u00ef"+
		"\u0398\3\2\2\2\u00f1\u03a1\3\2\2\2\u00f3\u03a9\3\2\2\2\u00f5\u03b1\3\2"+
		"\2\2\u00f7\u03b7\3\2\2\2\u00f9\u03bc\3\2\2\2\u00fb\u03c5\3\2\2\2\u00fd"+
		"\u03c8\3\2\2\2\u00ff\u03ce\3\2\2\2\u0101\u03d6\3\2\2\2\u0103\u03e3\3\2"+
		"\2\2\u0105\u03e5\3\2\2\2\u0107\u03ec\3\2\2\2\u0109\u03ee\3\2\2\2\u010b"+
		"\u03fb\3\2\2\2\u010d\u0401\3\2\2\2\u010f\u0407\3\2\2\2\u0111\u040a\3\2"+
		"\2\2\u0113\u0411\3\2\2\2\u0115\u0417\3\2\2\2\u0117\u0420\3\2\2\2\u0119"+
		"\u042a\3\2\2\2\u011b\u0433\3\2\2\2\u011d\u011e\7r\2\2\u011e\u011f\7c\2"+
		"\2\u011f\u0120\7e\2\2\u0120\u0121\7m\2\2\u0121\u0122\7c\2\2\u0122\u0123"+
		"\7i\2\2\u0123\u0124\7g\2\2\u0124\4\3\2\2\2\u0125\u0126\7=\2\2\u0126\6"+
		"\3\2\2\2\u0127\u0128\7\60\2\2\u0128\b\3\2\2\2\u0129\u012a\7k\2\2\u012a"+
		"\u012b\7o\2\2\u012b\u012c\7r\2\2\u012c\u012d\7q\2\2\u012d\u012e\7t\2\2"+
		"\u012e\u012f\7v\2\2\u012f\n\3\2\2\2\u0130\u0131\7c\2\2\u0131\u0132\7u"+
		"\2\2\u0132\f\3\2\2\2\u0133\u0134\7u\2\2\u0134\u0135\7g\2\2\u0135\u0136"+
		"\7t\2\2\u0136\u0137\7x\2\2\u0137\u0138\7k\2\2\u0138\u0139\7e\2\2\u0139"+
		"\u013a\7g\2\2\u013a\16\3\2\2\2\u013b\u013c\7>\2\2\u013c\20\3\2\2\2\u013d"+
		"\u013e\7@\2\2\u013e\22\3\2\2\2\u013f\u0140\7}\2\2\u0140\24\3\2\2\2\u0141"+
		"\u0142\7\177\2\2\u0142\26\3\2\2\2\u0143\u0144\7t\2\2\u0144\u0145\7g\2"+
		"\2\u0145\u0146\7u\2\2\u0146\u0147\7q\2\2\u0147\u0148\7w\2\2\u0148\u0149"+
		"\7t\2\2\u0149\u014a\7e\2\2\u014a\u014b\7g\2\2\u014b\30\3\2\2\2\u014c\u014d"+
		"\7*\2\2\u014d\32\3\2\2\2\u014e\u014f\7+\2\2\u014f\34\3\2\2\2\u0150\u0151"+
		"\7p\2\2\u0151\u0152\7c\2\2\u0152\u0153\7v\2\2\u0153\u0154\7k\2\2\u0154"+
		"\u0155\7x\2\2\u0155\u0156\7g\2\2\u0156\36\3\2\2\2\u0157\u0158\7h\2\2\u0158"+
		"\u0159\7w\2\2\u0159\u015a\7p\2\2\u015a\u015b\7e\2\2\u015b\u015c\7v\2\2"+
		"\u015c\u015d\7k\2\2\u015d\u015e\7q\2\2\u015e\u015f\7p\2\2\u015f \3\2\2"+
		"\2\u0160\u0161\7e\2\2\u0161\u0162\7q\2\2\u0162\u0163\7p\2\2\u0163\u0164"+
		"\7p\2\2\u0164\u0165\7g\2\2\u0165\u0166\7e\2\2\u0166\u0167\7v\2\2\u0167"+
		"\u0168\7q\2\2\u0168\u0169\7t\2\2\u0169\"\3\2\2\2\u016a\u016b\7c\2\2\u016b"+
		"\u016c\7e\2\2\u016c\u016d\7v\2\2\u016d\u016e\7k\2\2\u016e\u016f\7q\2\2"+
		"\u016f\u0170\7p\2\2\u0170$\3\2\2\2\u0171\u0172\7u\2\2\u0172\u0173\7v\2"+
		"\2\u0173\u0174\7t\2\2\u0174\u0175\7w\2\2\u0175\u0176\7e\2\2\u0176\u0177"+
		"\7v\2\2\u0177&\3\2\2\2\u0178\u0179\7c\2\2\u0179\u017a\7p\2\2\u017a\u017b"+
		"\7p\2\2\u017b\u017c\7q\2\2\u017c\u017d\7v\2\2\u017d\u017e\7c\2\2\u017e"+
		"\u017f\7v\2\2\u017f\u0180\7k\2\2\u0180\u0181\7q\2\2\u0181\u0182\7p\2\2"+
		"\u0182(\3\2\2\2\u0183\u0184\7c\2\2\u0184\u0185\7v\2\2\u0185\u0186\7v\2"+
		"\2\u0186\u0187\7c\2\2\u0187\u0188\7e\2\2\u0188\u0189\7j\2\2\u0189*\3\2"+
		"\2\2\u018a\u018b\7.\2\2\u018b,\3\2\2\2\u018c\u018d\7?\2\2\u018d.\3\2\2"+
		"\2\u018e\u018f\7v\2\2\u018f\u0190\7{\2\2\u0190\u0191\7r\2\2\u0191\u0192"+
		"\7g\2\2\u0192\u0193\7o\2\2\u0193\u0194\7c\2\2\u0194\u0195\7r\2\2\u0195"+
		"\u0196\7r\2\2\u0196\u0197\7g\2\2\u0197\u0198\7t\2\2\u0198\60\3\2\2\2\u0199"+
		"\u019a\7e\2\2\u019a\u019b\7q\2\2\u019b\u019c\7p\2\2\u019c\u019d\7u\2\2"+
		"\u019d\u019e\7v\2\2\u019e\62\3\2\2\2\u019f\u01a0\7r\2\2\u01a0\u01a1\7"+
		"c\2\2\u01a1\u01a2\7t\2\2\u01a2\u01a3\7c\2\2\u01a3\u01a4\7o\2\2\u01a4\u01a5"+
		"\7g\2\2\u01a5\u01a6\7v\2\2\u01a6\u01a7\7g\2\2\u01a7\u01a8\7t\2\2\u01a8"+
		"\64\3\2\2\2\u01a9\u01aa\7y\2\2\u01aa\u01ab\7q\2\2\u01ab\u01ac\7t\2\2\u01ac"+
		"\u01ad\7m\2\2\u01ad\u01ae\7g\2\2\u01ae\u01af\7t\2\2\u01af\66\3\2\2\2\u01b0"+
		"\u01b1\7c\2\2\u01b1\u01b2\7p\2\2\u01b2\u01b3\7{\2\2\u01b38\3\2\2\2\u01b4"+
		"\u01b5\7]\2\2\u01b5:\3\2\2\2\u01b6\u01b7\7_\2\2\u01b7<\3\2\2\2\u01b8\u01b9"+
		"\7d\2\2\u01b9\u01ba\7q\2\2\u01ba\u01bb\7q\2\2\u01bb\u01bc\7n\2\2\u01bc"+
		"\u01bd\7g\2\2\u01bd\u01be\7c\2\2\u01be\u01bf\7p\2\2\u01bf>\3\2\2\2\u01c0"+
		"\u01c1\7k\2\2\u01c1\u01c2\7p\2\2\u01c2\u01c3\7v\2\2\u01c3@\3\2\2\2\u01c4"+
		"\u01c5\7h\2\2\u01c5\u01c6\7n\2\2\u01c6\u01c7\7q\2\2\u01c7\u01c8\7c\2\2"+
		"\u01c8\u01c9\7v\2\2\u01c9B\3\2\2\2\u01ca\u01cb\7u\2\2\u01cb\u01cc\7v\2"+
		"\2\u01cc\u01cd\7t\2\2\u01cd\u01ce\7k\2\2\u01ce\u01cf\7p\2\2\u01cf\u01d0"+
		"\7i\2\2\u01d0D\3\2\2\2\u01d1\u01d2\7d\2\2\u01d2\u01d3\7n\2\2\u01d3\u01d4"+
		"\7q\2\2\u01d4\u01d5\7d\2\2\u01d5F\3\2\2\2\u01d6\u01d7\7o\2\2\u01d7\u01d8"+
		"\7g\2\2\u01d8\u01d9\7u\2\2\u01d9\u01da\7u\2\2\u01da\u01db\7c\2\2\u01db"+
		"\u01dc\7i\2\2\u01dc\u01dd\7g\2\2\u01ddH\3\2\2\2\u01de\u01df\7o\2\2\u01df"+
		"\u01e0\7c\2\2\u01e0\u01e1\7r\2\2\u01e1J\3\2\2\2\u01e2\u01e3\7z\2\2\u01e3"+
		"\u01e4\7o\2\2\u01e4\u01e5\7n\2\2\u01e5L\3\2\2\2\u01e6\u01e7\7z\2\2\u01e7"+
		"\u01e8\7o\2\2\u01e8\u01e9\7n\2\2\u01e9\u01ea\7F\2\2\u01ea\u01eb\7q\2\2"+
		"\u01eb\u01ec\7e\2\2\u01ec\u01ed\7w\2\2\u01ed\u01ee\7o\2\2\u01ee\u01ef"+
		"\7g\2\2\u01ef\u01f0\7p\2\2\u01f0\u01f1\7v\2\2\u01f1N\3\2\2\2\u01f2\u01f3"+
		"\7l\2\2\u01f3\u01f4\7u\2\2\u01f4\u01f5\7q\2\2\u01f5\u01f6\7p\2\2\u01f6"+
		"P\3\2\2\2\u01f7\u01f8\7f\2\2\u01f8\u01f9\7c\2\2\u01f9\u01fa\7v\2\2\u01fa"+
		"\u01fb\7c\2\2\u01fb\u01fc\7v\2\2\u01fc\u01fd\7c\2\2\u01fd\u01fe\7d\2\2"+
		"\u01fe\u01ff\7n\2\2\u01ff\u0200\7g\2\2\u0200R\3\2\2\2\u0201\u0202\7B\2"+
		"\2\u0202T\3\2\2\2\u0203\u0204\7<\2\2\u0204V\3\2\2\2\u0205\u0206\7v\2\2"+
		"\u0206\u0207\7t\2\2\u0207\u0208\7c\2\2\u0208\u0209\7p\2\2\u0209\u020a"+
		"\7u\2\2\u020a\u020b\7h\2\2\u020b\u020c\7q\2\2\u020c\u020d\7t\2\2\u020d"+
		"\u020e\7o\2\2\u020eX\3\2\2\2\u020f\u0210\7e\2\2\u0210\u0211\7t\2\2\u0211"+
		"\u0212\7g\2\2\u0212\u0213\7c\2\2\u0213\u0214\7v\2\2\u0214\u0215\7g\2\2"+
		"\u0215Z\3\2\2\2\u0216\u0217\7x\2\2\u0217\u0218\7c\2\2\u0218\u0219\7t\2"+
		"\2\u0219\\\3\2\2\2\u021a\u021b\7k\2\2\u021b\u021c\7h\2\2\u021c^\3\2\2"+
		"\2\u021d\u021e\7g\2\2\u021e\u021f\7n\2\2\u021f\u0220\7u\2\2\u0220\u0221"+
		"\7g\2\2\u0221`\3\2\2\2\u0222\u0223\7k\2\2\u0223\u0224\7v\2\2\u0224\u0225"+
		"\7g\2\2\u0225\u0226\7t\2\2\u0226\u0227\7c\2\2\u0227\u0228\7v\2\2\u0228"+
		"\u0229\7g\2\2\u0229b\3\2\2\2\u022a\u022b\7y\2\2\u022b\u022c\7j\2\2\u022c"+
		"\u022d\7k\2\2\u022d\u022e\7n\2\2\u022e\u022f\7g\2\2\u022fd\3\2\2\2\u0230"+
		"\u0231\7e\2\2\u0231\u0232\7q\2\2\u0232\u0233\7p\2\2\u0233\u0234\7v\2\2"+
		"\u0234\u0235\7k\2\2\u0235\u0236\7p\2\2\u0236\u0237\7w\2\2\u0237\u0238"+
		"\7g\2\2\u0238f\3\2\2\2\u0239\u023a\7d\2\2\u023a\u023b\7t\2\2\u023b\u023c"+
		"\7g\2\2\u023c\u023d\7c\2\2\u023d\u023e\7m\2\2\u023eh\3\2\2\2\u023f\u0240"+
		"\7h\2\2\u0240\u0241\7q\2\2\u0241\u0242\7t\2\2\u0242\u0243\7m\2\2\u0243"+
		"j\3\2\2\2\u0244\u0245\7l\2\2\u0245\u0246\7q\2\2\u0246\u0247\7k\2\2\u0247"+
		"\u0248\7p\2\2\u0248l\3\2\2\2\u0249\u024a\7u\2\2\u024a\u024b\7q\2\2\u024b"+
		"\u024c\7o\2\2\u024c\u024d\7g\2\2\u024dn\3\2\2\2\u024e\u024f\7c\2\2\u024f"+
		"\u0250\7n\2\2\u0250\u0251\7n\2\2\u0251p\3\2\2\2\u0252\u0253\7v\2\2\u0253"+
		"\u0254\7k\2\2\u0254\u0255\7o\2\2\u0255\u0256\7g\2\2\u0256\u0257\7q\2\2"+
		"\u0257\u0258\7w\2\2\u0258\u0259\7v\2\2\u0259r\3\2\2\2\u025a\u025b\7v\2"+
		"\2\u025b\u025c\7t\2\2\u025c\u025d\7{\2\2\u025dt\3\2\2\2\u025e\u025f\7"+
		"e\2\2\u025f\u0260\7c\2\2\u0260\u0261\7v\2\2\u0261\u0262\7e\2\2\u0262\u0263"+
		"\7j\2\2\u0263v\3\2\2\2\u0264\u0265\7h\2\2\u0265\u0266\7k\2\2\u0266\u0267"+
		"\7p\2\2\u0267\u0268\7c\2\2\u0268\u0269\7n\2\2\u0269\u026a\7n\2\2\u026a"+
		"\u026b\7{\2\2\u026bx\3\2\2\2\u026c\u026d\7v\2\2\u026d\u026e\7j\2\2\u026e"+
		"\u026f\7t\2\2\u026f\u0270\7q\2\2\u0270\u0271\7y\2\2\u0271z\3\2\2\2\u0272"+
		"\u0273\7t\2\2\u0273\u0274\7g\2\2\u0274\u0275\7v\2\2\u0275\u0276\7w\2\2"+
		"\u0276\u0277\7t\2\2\u0277\u0278\7p\2\2\u0278|\3\2\2\2\u0279\u027a\7t\2"+
		"\2\u027a\u027b\7g\2\2\u027b\u027c\7r\2\2\u027c\u027d\7n\2\2\u027d\u027e"+
		"\7{\2\2\u027e~\3\2\2\2\u027f\u0280\7/\2\2\u0280\u0281\7@\2\2\u0281\u0080"+
		"\3\2\2\2\u0282\u0283\7>\2\2\u0283\u0284\7/\2\2\u0284\u0082\3\2\2\2\u0285"+
		"\u0286\7B\2\2\u0286\u0287\7]\2\2\u0287\u0084\3\2\2\2\u0288\u0289\7v\2"+
		"\2\u0289\u028a\7t\2\2\u028a\u028b\7c\2\2\u028b\u028c\7p\2\2\u028c\u028d"+
		"\7u\2\2\u028d\u028e\7c\2\2\u028e\u028f\7e\2\2\u028f\u0290\7v\2\2\u0290"+
		"\u0291\7k\2\2\u0291\u0292\7q\2\2\u0292\u0293\7p\2\2\u0293\u0086\3\2\2"+
		"\2\u0294\u0295\7c\2\2\u0295\u0296\7d\2\2\u0296\u0297\7q\2\2\u0297\u0298"+
		"\7t\2\2\u0298\u0299\7v\2\2\u0299\u029a\7g\2\2\u029a\u029b\7f\2\2\u029b"+
		"\u0088\3\2\2\2\u029c\u029d\7e\2\2\u029d\u029e\7q\2\2\u029e\u029f\7o\2"+
		"\2\u029f\u02a0\7o\2\2\u02a0\u02a1\7k\2\2\u02a1\u02a2\7v\2\2\u02a2\u02a3"+
		"\7v\2\2\u02a3\u02a4\7g\2\2\u02a4\u02a5\7f\2\2\u02a5\u008a\3\2\2\2\u02a6"+
		"\u02a7\7c\2\2\u02a7\u02a8\7d\2\2\u02a8\u02a9\7q\2\2\u02a9\u02aa\7t\2\2"+
		"\u02aa\u02ab\7v\2\2\u02ab\u008c\3\2\2\2\u02ac\u02ad\7-\2\2\u02ad\u008e"+
		"\3\2\2\2\u02ae\u02af\7/\2\2\u02af\u0090\3\2\2\2\u02b0\u02b1\7#\2\2\u02b1"+
		"\u0092\3\2\2\2\u02b2\u02b3\7`\2\2\u02b3\u0094\3\2\2\2\u02b4\u02b5\7\61"+
		"\2\2\u02b5\u0096\3\2\2\2\u02b6\u02b7\7,\2\2\u02b7\u0098\3\2\2\2\u02b8"+
		"\u02b9\7\'\2\2\u02b9\u009a\3\2\2\2\u02ba\u02bb\7>\2\2\u02bb\u02bc\7?\2"+
		"\2\u02bc\u009c\3\2\2\2\u02bd\u02be\7@\2\2\u02be\u02bf\7?\2\2\u02bf\u009e"+
		"\3\2\2\2\u02c0\u02c1\7?\2\2\u02c1\u02c2\7?\2\2\u02c2\u00a0\3\2\2\2\u02c3"+
		"\u02c4\7#\2\2\u02c4\u02c5\7?\2\2\u02c5\u00a2\3\2\2\2\u02c6\u02c7\7(\2"+
		"\2\u02c7\u02c8\7(\2\2\u02c8\u00a4\3\2\2\2\u02c9\u02ca\7~\2\2\u02ca\u02cb"+
		"\7~\2\2\u02cb\u00a6\3\2\2\2\u02cc\u02d1\5\u00a9U\2\u02cd\u02d1\5\u00ab"+
		"V\2\u02ce\u02d1\5\u00adW\2\u02cf\u02d1\5\u00afX\2\u02d0\u02cc\3\2\2\2"+
		"\u02d0\u02cd\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d0\u02cf\3\2\2\2\u02d1\u00a8"+
		"\3\2\2\2\u02d2\u02d4\5\u00b3Z\2\u02d3\u02d5\5\u00b1Y\2\u02d4\u02d3\3\2"+
		"\2\2\u02d4\u02d5\3\2\2\2\u02d5\u00aa\3\2\2\2\u02d6\u02d8\5\u00bf`\2\u02d7"+
		"\u02d9\5\u00b1Y\2\u02d8\u02d7\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u00ac"+
		"\3\2\2\2\u02da\u02dc\5\u00c7d\2\u02db\u02dd\5\u00b1Y\2\u02dc\u02db\3\2"+
		"\2\2\u02dc\u02dd\3\2\2\2\u02dd\u00ae\3\2\2\2\u02de\u02e0\5\u00cfh\2\u02df"+
		"\u02e1\5\u00b1Y\2\u02e0\u02df\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u00b0"+
		"\3\2\2\2\u02e2\u02e3\t\2\2\2\u02e3\u00b2\3\2\2\2\u02e4\u02ef\7\62\2\2"+
		"\u02e5\u02ec\5\u00b9]\2\u02e6\u02e8\5\u00b5[\2\u02e7\u02e6\3\2\2\2\u02e7"+
		"\u02e8\3\2\2\2\u02e8\u02ed\3\2\2\2\u02e9\u02ea\5\u00bd_\2\u02ea\u02eb"+
		"\5\u00b5[\2\u02eb\u02ed\3\2\2\2\u02ec\u02e7\3\2\2\2\u02ec\u02e9\3\2\2"+
		"\2\u02ed\u02ef\3\2\2\2\u02ee\u02e4\3\2\2\2\u02ee\u02e5\3\2\2\2\u02ef\u00b4"+
		"\3\2\2\2\u02f0\u02f8\5\u00b7\\\2\u02f1\u02f3\5\u00bb^\2\u02f2\u02f1\3"+
		"\2\2\2\u02f3\u02f6\3\2\2\2\u02f4\u02f2\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5"+
		"\u02f7\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f7\u02f9\5\u00b7\\\2\u02f8\u02f4"+
		"\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u00b6\3\2\2\2\u02fa\u02fd\7\62\2\2"+
		"\u02fb\u02fd\5\u00b9]\2\u02fc\u02fa\3\2\2\2\u02fc\u02fb\3\2\2\2\u02fd"+
		"\u00b8\3\2\2\2\u02fe\u02ff\t\3\2\2\u02ff\u00ba\3\2\2\2\u0300\u0303\5\u00b7"+
		"\\\2\u0301\u0303\7a\2\2\u0302\u0300\3\2\2\2\u0302\u0301\3\2\2\2\u0303"+
		"\u00bc\3\2\2\2\u0304\u0306\7a\2\2\u0305\u0304\3\2\2\2\u0306\u0307\3\2"+
		"\2\2\u0307\u0305\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u00be\3\2\2\2\u0309"+
		"\u030a\7\62\2\2\u030a\u030b\t\4\2\2\u030b\u030c\5\u00c1a\2\u030c\u00c0"+
		"\3\2\2\2\u030d\u0315\5\u00c3b\2\u030e\u0310\5\u00c5c\2\u030f\u030e\3\2"+
		"\2\2\u0310\u0313\3\2\2\2\u0311\u030f\3\2\2\2\u0311\u0312\3\2\2\2\u0312"+
		"\u0314\3\2\2\2\u0313\u0311\3\2\2\2\u0314\u0316\5\u00c3b\2\u0315\u0311"+
		"\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u00c2\3\2\2\2\u0317\u0318\t\5\2\2\u0318"+
		"\u00c4\3\2\2\2\u0319\u031c\5\u00c3b\2\u031a\u031c\7a\2\2\u031b\u0319\3"+
		"\2\2\2\u031b\u031a\3\2\2\2\u031c\u00c6\3\2\2\2\u031d\u031f\7\62\2\2\u031e"+
		"\u0320\5\u00bd_\2\u031f\u031e\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0321"+
		"\3\2\2\2\u0321\u0322\5\u00c9e\2\u0322\u00c8\3\2\2\2\u0323\u032b\5\u00cb"+
		"f\2\u0324\u0326\5\u00cdg\2\u0325\u0324\3\2\2\2\u0326\u0329\3\2\2\2\u0327"+
		"\u0325\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u032a\3\2\2\2\u0329\u0327\3\2"+
		"\2\2\u032a\u032c\5\u00cbf\2\u032b\u0327\3\2\2\2\u032b\u032c\3\2\2\2\u032c"+
		"\u00ca\3\2\2\2\u032d\u032e\t\6\2\2\u032e\u00cc\3\2\2\2\u032f\u0332\5\u00cb"+
		"f\2\u0330\u0332\7a\2\2\u0331\u032f\3\2\2\2\u0331\u0330\3\2\2\2\u0332\u00ce"+
		"\3\2\2\2\u0333\u0334\7\62\2\2\u0334\u0335\t\7\2\2\u0335\u0336\5\u00d1"+
		"i\2\u0336\u00d0\3\2\2\2\u0337\u033f\5\u00d3j\2\u0338\u033a\5\u00d5k\2"+
		"\u0339\u0338\3\2\2\2\u033a\u033d\3\2\2\2\u033b\u0339\3\2\2\2\u033b\u033c"+
		"\3\2\2\2\u033c\u033e\3\2\2\2\u033d\u033b\3\2\2\2\u033e\u0340\5\u00d3j"+
		"\2\u033f\u033b\3\2\2\2\u033f\u0340\3\2\2\2\u0340\u00d2\3\2\2\2\u0341\u0342"+
		"\t\b\2\2\u0342\u00d4\3\2\2\2\u0343\u0346\5\u00d3j\2\u0344\u0346\7a\2\2"+
		"\u0345\u0343\3\2\2\2\u0345\u0344\3\2\2\2\u0346\u00d6\3\2\2\2\u0347\u034a"+
		"\5\u00d9m\2\u0348\u034a\5\u00e5s\2\u0349\u0347\3\2\2\2\u0349\u0348\3\2"+
		"\2\2\u034a\u00d8\3\2\2\2\u034b\u034c\5\u00b5[\2\u034c\u034e\7\60\2\2\u034d"+
		"\u034f\5\u00b5[\2\u034e\u034d\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0351"+
		"\3\2\2\2\u0350\u0352\5\u00dbn\2\u0351\u0350\3\2\2\2\u0351\u0352\3\2\2"+
		"\2\u0352\u0354\3\2\2\2\u0353\u0355\5\u00e3r\2\u0354\u0353\3\2\2\2\u0354"+
		"\u0355\3\2\2\2\u0355\u0367\3\2\2\2\u0356\u0357\7\60\2\2\u0357\u0359\5"+
		"\u00b5[\2\u0358\u035a\5\u00dbn\2\u0359\u0358\3\2\2\2\u0359\u035a\3\2\2"+
		"\2\u035a\u035c\3\2\2\2\u035b\u035d\5\u00e3r\2\u035c\u035b\3\2\2\2\u035c"+
		"\u035d\3\2\2\2\u035d\u0367\3\2\2\2\u035e\u035f\5\u00b5[\2\u035f\u0361"+
		"\5\u00dbn\2\u0360\u0362\5\u00e3r\2\u0361\u0360\3\2\2\2\u0361\u0362\3\2"+
		"\2\2\u0362\u0367\3\2\2\2\u0363\u0364\5\u00b5[\2\u0364\u0365\5\u00e3r\2"+
		"\u0365\u0367\3\2\2\2\u0366\u034b\3\2\2\2\u0366\u0356\3\2\2\2\u0366\u035e"+
		"\3\2\2\2\u0366\u0363\3\2\2\2\u0367\u00da\3\2\2\2\u0368\u0369\5\u00ddo"+
		"\2\u0369\u036a\5\u00dfp\2\u036a\u00dc\3\2\2\2\u036b\u036c\t\t\2\2\u036c"+
		"\u00de\3\2\2\2\u036d\u036f\5\u00e1q\2\u036e\u036d\3\2\2\2\u036e\u036f"+
		"\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u0371\5\u00b5[\2\u0371\u00e0\3\2\2"+
		"\2\u0372\u0373\t\n\2\2\u0373\u00e2\3\2\2\2\u0374\u0375\t\13\2\2\u0375"+
		"\u00e4\3\2\2\2\u0376\u0377\5\u00e7t\2\u0377\u0379\5\u00e9u\2\u0378\u037a"+
		"\5\u00e3r\2\u0379\u0378\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u00e6\3\2\2"+
		"\2\u037b\u037d\5\u00bf`\2\u037c\u037e\7\60\2\2\u037d\u037c\3\2\2\2\u037d"+
		"\u037e\3\2\2\2\u037e\u0387\3\2\2\2\u037f\u0380\7\62\2\2\u0380\u0382\t"+
		"\4\2\2\u0381\u0383\5\u00c1a\2\u0382\u0381\3\2\2\2\u0382\u0383\3\2\2\2"+
		"\u0383\u0384\3\2\2\2\u0384\u0385\7\60\2\2\u0385\u0387\5\u00c1a\2\u0386"+
		"\u037b\3\2\2\2\u0386\u037f\3\2\2\2\u0387\u00e8\3\2\2\2\u0388\u0389\5\u00eb"+
		"v\2\u0389\u038a\5\u00dfp\2\u038a\u00ea\3\2\2\2\u038b\u038c\t\f\2\2\u038c"+
		"\u00ec\3\2\2\2\u038d\u038e\7v\2\2\u038e\u038f\7t\2\2\u038f\u0390\7w\2"+
		"\2\u0390\u0397\7g\2\2\u0391\u0392\7h\2\2\u0392\u0393\7c\2\2\u0393\u0394"+
		"\7n\2\2\u0394\u0395\7u\2\2\u0395\u0397\7g\2\2\u0396\u038d\3\2\2\2\u0396"+
		"\u0391\3\2\2\2\u0397\u00ee\3\2\2\2\u0398\u039a\7$\2\2\u0399\u039b\5\u00fd"+
		"\177\2\u039a\u0399\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u039c\3\2\2\2\u039c"+
		"\u039d\7&\2\2\u039d\u039e\7}\2\2\u039e\u039f\3\2\2\2\u039f\u03a0\bx\2"+
		"\2\u03a0\u00f0\3\2\2\2\u03a1\u03a2\6y\2\2\u03a2\u03a4\7\177\2\2\u03a3"+
		"\u03a5\5\u00fd\177\2\u03a4\u03a3\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a6"+
		"\3\2\2\2\u03a6\u03a7\7&\2\2\u03a7\u03a8\7}\2\2\u03a8\u00f2\3\2\2\2\u03a9"+
		"\u03aa\6z\3\2\u03aa\u03ac\7\177\2\2\u03ab\u03ad\5\u00fd\177\2\u03ac\u03ab"+
		"\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03af\7$\2\2\u03af"+
		"\u03b0\bz\3\2\u03b0\u00f4\3\2\2\2\u03b1\u03b3\7$\2\2\u03b2\u03b4\5\u00fd"+
		"\177\2\u03b3\u03b2\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5"+
		"\u03b6\7$\2\2\u03b6\u00f6\3\2\2\2\u03b7\u03b8\7b\2\2\u03b8\u03b9\5\u00f9"+
		"}\2\u03b9\u03ba\7b\2\2\u03ba\u00f8\3\2\2\2\u03bb\u03bd\5\u00fb~\2\u03bc"+
		"\u03bb\3\2\2\2\u03bd\u03be\3\2\2\2\u03be\u03bc\3\2\2\2\u03be\u03bf\3\2"+
		"\2\2\u03bf\u00fa\3\2\2\2\u03c0\u03c6\n\r\2\2\u03c1\u03c2\7^\2\2\u03c2"+
		"\u03c6\t\16\2\2\u03c3\u03c6\5\u0103\u0082\2\u03c4\u03c6\5\u0105\u0083"+
		"\2\u03c5\u03c0\3\2\2\2\u03c5\u03c1\3\2\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c4"+
		"\3\2\2\2\u03c6\u00fc\3\2\2\2\u03c7\u03c9\5\u00ff\u0080\2\u03c8\u03c7\3"+
		"\2\2\2\u03c9\u03ca\3\2\2\2\u03ca\u03c8\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb"+
		"\u00fe\3\2\2\2\u03cc\u03cf\n\17\2\2\u03cd\u03cf\5\u0101\u0081\2\u03ce"+
		"\u03cc\3\2\2\2\u03ce\u03cd\3\2\2\2\u03cf\u0100\3\2\2\2\u03d0\u03d1\7^"+
		"\2\2\u03d1\u03d7\t\20\2\2\u03d2\u03d3\7&\2\2\u03d3\u03d7\t\21\2\2\u03d4"+
		"\u03d7\5\u0103\u0082\2\u03d5\u03d7\5\u0105\u0083\2\u03d6\u03d0\3\2\2\2"+
		"\u03d6\u03d2\3\2\2\2\u03d6\u03d4\3\2\2\2\u03d6\u03d5\3\2\2\2\u03d7\u0102"+
		"\3\2\2\2\u03d8\u03d9\7^\2\2\u03d9\u03e4\5\u00cbf\2\u03da\u03db\7^\2\2"+
		"\u03db\u03dc\5\u00cbf\2\u03dc\u03dd\5\u00cbf\2\u03dd\u03e4\3\2\2\2\u03de"+
		"\u03df\7^\2\2\u03df\u03e0\5\u0107\u0084\2\u03e0\u03e1\5\u00cbf\2\u03e1"+
		"\u03e2\5\u00cbf\2\u03e2\u03e4\3\2\2\2\u03e3\u03d8\3\2\2\2\u03e3\u03da"+
		"\3\2\2\2\u03e3\u03de\3\2\2\2\u03e4\u0104\3\2\2\2\u03e5\u03e6\7^\2\2\u03e6"+
		"\u03e7\7w\2\2\u03e7\u03e8\5\u00c3b\2\u03e8\u03e9\5\u00c3b\2\u03e9\u03ea"+
		"\5\u00c3b\2\u03ea\u03eb\5\u00c3b\2\u03eb\u0106\3\2\2\2\u03ec\u03ed\t\22"+
		"\2\2\u03ed\u0108\3\2\2\2\u03ee\u03ef\7p\2\2\u03ef\u03f0\7w\2\2\u03f0\u03f1"+
		"\7n\2\2\u03f1\u03f2\7n\2\2\u03f2\u010a\3\2\2\2\u03f3\u03f7\5\u010d\u0087"+
		"\2\u03f4\u03f6\5\u010f\u0088\2\u03f5\u03f4\3\2\2\2\u03f6\u03f9\3\2\2\2"+
		"\u03f7\u03f5\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8\u03fc\3\2\2\2\u03f9\u03f7"+
		"\3\2\2\2\u03fa\u03fc\5\u0117\u008c\2\u03fb\u03f3\3\2\2\2\u03fb\u03fa\3"+
		"\2\2\2\u03fc\u010c\3\2\2\2\u03fd\u0402\t\23\2\2\u03fe\u0402\n\24\2\2\u03ff"+
		"\u0400\t\25\2\2\u0400\u0402\t\26\2\2\u0401\u03fd\3\2\2\2\u0401\u03fe\3"+
		"\2\2\2\u0401\u03ff\3\2\2\2\u0402\u010e\3\2\2\2\u0403\u0408\t\27\2\2\u0404"+
		"\u0408\n\24\2\2\u0405\u0406\t\25\2\2\u0406\u0408\t\26\2\2\u0407\u0403"+
		"\3\2\2\2\u0407\u0404\3\2\2\2\u0407\u0405\3\2\2\2\u0408\u0110\3\2\2\2\u0409"+
		"\u040b\t\30\2\2\u040a\u0409\3\2\2\2\u040b\u040c\3\2\2\2\u040c\u040a\3"+
		"\2\2\2\u040c\u040d\3\2\2\2\u040d\u040e\3\2\2\2\u040e\u040f\b\u0089\4\2"+
		"\u040f\u0112\3\2\2\2\u0410\u0412\t\31\2\2\u0411\u0410\3\2\2\2\u0412\u0413"+
		"\3\2\2\2\u0413\u0411\3\2\2\2\u0413\u0414\3\2\2\2\u0414\u0415\3\2\2\2\u0415"+
		"\u0416\b\u008a\4\2\u0416\u0114\3\2\2\2\u0417\u0418\7\61\2\2\u0418\u0419"+
		"\7\61\2\2\u0419\u041d\3\2\2\2\u041a\u041c\n\32\2\2\u041b\u041a\3\2\2\2"+
		"\u041c\u041f\3\2\2\2\u041d\u041b\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u0116"+
		"\3\2\2\2\u041f\u041d\3\2\2\2\u0420\u0422\7~\2\2\u0421\u0423\5\u0119\u008d"+
		"\2\u0422\u0421\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u0422\3\2\2\2\u0424\u0425"+
		"\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0427\7~\2\2\u0427\u0118\3\2\2\2\u0428"+
		"\u042b\n\33\2\2\u0429\u042b\5\u011b\u008e\2\u042a\u0428\3\2\2\2\u042a"+
		"\u0429\3\2\2\2\u042b\u011a\3\2\2\2\u042c\u042d\7^\2\2\u042d\u0434\t\34"+
		"\2\2\u042e\u042f\7^\2\2\u042f\u0430\7^\2\2\u0430\u0431\3\2\2\2\u0431\u0434"+
		"\t\35\2\2\u0432\u0434\5\u0105\u0083\2\u0433\u042c\3\2\2\2\u0433\u042e"+
		"\3\2\2\2\u0433\u0432\3\2\2\2\u0434\u011c\3\2\2\2<\2\u02d0\u02d4\u02d8"+
		"\u02dc\u02e0\u02e7\u02ec\u02ee\u02f4\u02f8\u02fc\u0302\u0307\u0311\u0315"+
		"\u031b\u031f\u0327\u032b\u0331\u033b\u033f\u0345\u0349\u034e\u0351\u0354"+
		"\u0359\u035c\u0361\u0366\u036e\u0379\u037d\u0382\u0386\u0396\u039a\u03a4"+
		"\u03ac\u03b3\u03be\u03c5\u03ca\u03ce\u03d6\u03e3\u03f7\u03fb\u0401\u0407"+
		"\u040c\u0413\u041d\u0424\u042a\u0433\5\3x\2\3z\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}