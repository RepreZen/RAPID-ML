package com.reprezen.rapidml.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextDslLexer extends Lexer {
	public static final int T__144 = 144;
	public static final int T__143 = 143;
	public static final int T__146 = 146;
	public static final int T__50 = 50;
	public static final int T__145 = 145;
	public static final int T__140 = 140;
	public static final int T__142 = 142;
	public static final int T__141 = 141;
	public static final int T__59 = 59;
	public static final int T__55 = 55;
	public static final int T__56 = 56;
	public static final int T__57 = 57;
	public static final int T__58 = 58;
	public static final int T__51 = 51;
	public static final int T__137 = 137;
	public static final int T__52 = 52;
	public static final int T__136 = 136;
	public static final int T__53 = 53;
	public static final int T__139 = 139;
	public static final int T__54 = 54;
	public static final int T__138 = 138;
	public static final int T__133 = 133;
	public static final int T__132 = 132;
	public static final int T__60 = 60;
	public static final int T__135 = 135;
	public static final int T__61 = 61;
	public static final int T__134 = 134;
	public static final int RULE_ID = 5;
	public static final int T__131 = 131;
	public static final int T__130 = 130;
	public static final int RULE_INT = 9;
	public static final int T__66 = 66;
	public static final int RULE_ML_COMMENT = 13;
	public static final int T__67 = 67;
	public static final int T__129 = 129;
	public static final int T__68 = 68;
	public static final int T__69 = 69;
	public static final int T__62 = 62;
	public static final int T__126 = 126;
	public static final int RULE_ML_COMMENT_NL = 14;
	public static final int T__63 = 63;
	public static final int T__125 = 125;
	public static final int T__64 = 64;
	public static final int T__128 = 128;
	public static final int T__65 = 65;
	public static final int T__127 = 127;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int T__39 = 39;
	public static final int T__33 = 33;
	public static final int T__34 = 34;
	public static final int T__35 = 35;
	public static final int T__36 = 36;
	public static final int T__30 = 30;
	public static final int T__158 = 158;
	public static final int T__31 = 31;
	public static final int T__32 = 32;
	public static final int T__155 = 155;
	public static final int T__154 = 154;
	public static final int T__157 = 157;
	public static final int T__156 = 156;
	public static final int T__151 = 151;
	public static final int T__150 = 150;
	public static final int T__153 = 153;
	public static final int T__152 = 152;
	public static final int T__48 = 48;
	public static final int T__49 = 49;
	public static final int T__44 = 44;
	public static final int T__45 = 45;
	public static final int T__46 = 46;
	public static final int T__47 = 47;
	public static final int T__40 = 40;
	public static final int T__148 = 148;
	public static final int T__41 = 41;
	public static final int T__147 = 147;
	public static final int T__42 = 42;
	public static final int T__43 = 43;
	public static final int T__149 = 149;
	public static final int T__91 = 91;
	public static final int T__100 = 100;
	public static final int T__92 = 92;
	public static final int T__93 = 93;
	public static final int T__102 = 102;
	public static final int T__94 = 94;
	public static final int T__101 = 101;
	public static final int RULE_BEGIN = 6;
	public static final int T__90 = 90;
	public static final int T__19 = 19;
	public static final int T__99 = 99;
	public static final int T__95 = 95;
	public static final int T__96 = 96;
	public static final int RULE_RAW_STRING = 12;
	public static final int T__97 = 97;
	public static final int T__98 = 98;
	public static final int RULE_JAVADOC_COMMENT = 11;
	public static final int T__26 = 26;
	public static final int T__27 = 27;
	public static final int T__28 = 28;
	public static final int T__29 = 29;
	public static final int T__22 = 22;
	public static final int T__23 = 23;
	public static final int T__24 = 24;
	public static final int T__25 = 25;
	public static final int T__20 = 20;
	public static final int T__21 = 21;
	public static final int T__122 = 122;
	public static final int T__70 = 70;
	public static final int T__121 = 121;
	public static final int T__71 = 71;
	public static final int T__124 = 124;
	public static final int RULE_END = 8;
	public static final int T__72 = 72;
	public static final int T__123 = 123;
	public static final int T__120 = 120;
	public static final int RULE_STRING = 7;
	public static final int RULE_SL_COMMENT = 15;
	public static final int RULE_IN_RICH_STRING = 17;
	public static final int T__77 = 77;
	public static final int T__119 = 119;
	public static final int T__78 = 78;
	public static final int T__118 = 118;
	public static final int T__79 = 79;
	public static final int T__73 = 73;
	public static final int T__115 = 115;
	public static final int EOF = -1;
	public static final int T__74 = 74;
	public static final int T__114 = 114;
	public static final int T__75 = 75;
	public static final int T__117 = 117;
	public static final int T__76 = 76;
	public static final int T__116 = 116;
	public static final int T__80 = 80;
	public static final int T__111 = 111;
	public static final int T__81 = 81;
	public static final int T__110 = 110;
	public static final int T__82 = 82;
	public static final int T__113 = 113;
	public static final int RULE_RICH_TEXT = 10;
	public static final int T__83 = 83;
	public static final int T__112 = 112;
	public static final int RULE_WS = 16;
	public static final int RULE_ANY_OTHER = 18;
	public static final int T__88 = 88;
	public static final int T__108 = 108;
	public static final int T__89 = 89;
	public static final int T__107 = 107;
	public static final int T__109 = 109;
	public static final int RULE_NL = 4;
	public static final int T__84 = 84;
	public static final int T__104 = 104;
	public static final int T__85 = 85;
	public static final int T__103 = 103;
	public static final int T__86 = 86;
	public static final int T__106 = 106;
	public static final int T__87 = 87;
	public static final int T__105 = 105;

	// delegates
	// delegators

	public InternalXtextDslLexer() {
		;
	}

	public InternalXtextDslLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalXtextDslLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	public String getGrammarFileName() {
		return "InternalXtextDsl.g";
	}

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:11:7: ( 'namespace ' )
			// InternalXtextDsl.g:11:9: 'namespace '
			{
				match("namespace ");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:12:7: ( 'rapidModel' )
			// InternalXtextDsl.g:12:9: 'rapidModel'
			{
				match("rapidModel");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:13:7: ( 'with' )
			// InternalXtextDsl.g:13:9: 'with'
			{
				match("with");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:14:7: ( 'title' )
			// InternalXtextDsl.g:14:9: 'title'
			{
				match("title");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:15:7: ( 'extensions' )
			// InternalXtextDsl.g:15:9: 'extensions'
			{
				match("extensions");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:16:7: ( 'import' )
			// InternalXtextDsl.g:16:9: 'import'
			{
				match("import");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:17:7: ( 'from' )
			// InternalXtextDsl.g:17:9: 'from'
			{
				match("from");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:18:7: ( 'as' )
			// InternalXtextDsl.g:18:9: 'as'
			{
				match("as");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:19:7: ( 'resourceAPI' )
			// InternalXtextDsl.g:19:9: 'resourceAPI'
			{
				match("resourceAPI");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:20:7: ( 'version' )
			// InternalXtextDsl.g:20:9: 'version'
			{
				match("version");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:21:7: ( 'baseURI' )
			// InternalXtextDsl.g:21:9: 'baseURI'
			{
				match("baseURI");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:22:7: ( 'secured' )
			// InternalXtextDsl.g:22:9: 'secured'
			{
				match("secured");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:23:7: ( 'by' )
			// InternalXtextDsl.g:23:9: 'by'
			{
				match("by");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:24:7: ( 'autoRealizations' )
			// InternalXtextDsl.g:24:9: 'autoRealizations'
			{
				match("autoRealizations");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:25:7: ( 'default' )
			// InternalXtextDsl.g:25:9: 'default'
			{
				match("default");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:26:7: ( 'collectionResource' )
			// InternalXtextDsl.g:26:9: 'collectionResource'
			{
				match("collectionResource");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:27:7: ( 'bound' )
			// InternalXtextDsl.g:27:9: 'bound'
			{
				match("bound");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:28:7: ( 'to' )
			// InternalXtextDsl.g:28:9: 'to'
			{
				match("to");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:29:7: ( 'type' )
			// InternalXtextDsl.g:29:9: 'type'
			{
				match("type");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:30:7: ( 'URI' )
			// InternalXtextDsl.g:30:9: 'URI'
			{
				match("URI");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:31:7: ( 'mediaTypes' )
			// InternalXtextDsl.g:31:9: 'mediaTypes'
			{
				match("mediaTypes");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:32:7: ( ',' )
			// InternalXtextDsl.g:32:9: ','
			{
				match(',');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__40"

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:33:7: ( 'objectResource' )
			// InternalXtextDsl.g:33:9: 'objectResource'
			{
				match("objectResource");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:34:7: ( 'only' )
			// InternalXtextDsl.g:34:9: 'only'
			{
				match("only");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:35:7: ( 'properties' )
			// InternalXtextDsl.g:35:9: 'properties'
			{
				match("properties");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:36:7: ( 'all' )
			// InternalXtextDsl.g:36:9: 'all'
			{
				match("all");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:37:7: ( 'including' )
			// InternalXtextDsl.g:37:9: 'including'
			{
				match("including");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:38:7: ( 'excluding' )
			// InternalXtextDsl.g:38:9: 'excluding'
			{
				match("excluding");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:39:7: ( '/' )
			// InternalXtextDsl.g:39:9: '/'
			{
				match('/');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:40:7: ( '{' )
			// InternalXtextDsl.g:40:9: '{'
			{
				match('{');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:41:7: ( '}' )
			// InternalXtextDsl.g:41:9: '}'
			{
				match('}');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:42:7: ( '@' )
			// InternalXtextDsl.g:42:9: '@'
			{
				match('@');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:43:7: ( '-' )
			// InternalXtextDsl.g:43:9: '-'
			{
				match('-');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:44:7: ( '.' )
			// InternalXtextDsl.g:44:9: '.'
			{
				match('.');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:45:7: ( '_' )
			// InternalXtextDsl.g:45:9: '_'
			{
				match('_');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:46:7: ( '~' )
			// InternalXtextDsl.g:46:9: '~'
			{
				match('~');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:47:7: ( '%' )
			// InternalXtextDsl.g:47:9: '%'
			{
				match('%');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:48:7: ( '!' )
			// InternalXtextDsl.g:48:9: '!'
			{
				match('!');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:49:7: ( '$' )
			// InternalXtextDsl.g:49:9: '$'
			{
				match('$');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:50:7: ( '&' )
			// InternalXtextDsl.g:50:9: '&'
			{
				match('&');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:51:7: ( '\\'' )
			// InternalXtextDsl.g:51:9: '\\''
			{
				match('\'');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:52:7: ( '(' )
			// InternalXtextDsl.g:52:9: '('
			{
				match('(');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:53:7: ( ')' )
			// InternalXtextDsl.g:53:9: ')'
			{
				match(')');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:54:7: ( '*' )
			// InternalXtextDsl.g:54:9: '*'
			{
				match('*');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:55:7: ( '+' )
			// InternalXtextDsl.g:55:9: '+'
			{
				match('+');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:56:7: ( ';' )
			// InternalXtextDsl.g:56:9: ';'
			{
				match(';');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:57:7: ( '=' )
			// InternalXtextDsl.g:57:9: '='
			{
				match('=');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:58:7: ( 'required' )
			// InternalXtextDsl.g:58:9: 'required'
			{
				match("required");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:59:7: ( 'param' )
			// InternalXtextDsl.g:59:9: 'param'
			{
				match("param");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:60:7: ( 'located' )
			// InternalXtextDsl.g:60:9: 'located'
			{
				match("located");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:61:7: ( 'in' )
			// InternalXtextDsl.g:61:9: 'in'
			{
				match("in");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:62:7: ( 'fixed' )
			// InternalXtextDsl.g:62:9: 'fixed'
			{
				match("fixed");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:63:7: ( 'collectionParam' )
			// InternalXtextDsl.g:63:9: 'collectionParam'
			{
				match("collectionParam");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:64:7: ( 'matrixParam' )
			// InternalXtextDsl.g:64:9: 'matrixParam'
			{
				match("matrixParam");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:65:7: ( 'templateParam' )
			// InternalXtextDsl.g:65:9: 'templateParam'
			{
				match("templateParam");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:66:7: ( 'property' )
			// InternalXtextDsl.g:66:9: 'property'
			{
				match("property");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:67:7: ( 'of' )
			// InternalXtextDsl.g:67:9: 'of'
			{
				match("of");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:68:7: ( 'method' )
			// InternalXtextDsl.g:68:9: 'method'
			{
				match("method");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:69:7: ( 'request' )
			// InternalXtextDsl.g:69:9: 'request'
			{
				match("request");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:70:7: ( 'this' )
			// InternalXtextDsl.g:70:9: 'this'
			{
				match("this");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:71:7: ( 'resource' )
			// InternalXtextDsl.g:71:9: 'resource'
			{
				match("resource");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:72:7: ( 'response' )
			// InternalXtextDsl.g:72:9: 'response'
			{
				match("response");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__80"

	// $ANTLR start "T__81"
	public final void mT__81() throws RecognitionException {
		try {
			int _type = T__81;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:73:7: ( 'statusCode' )
			// InternalXtextDsl.g:73:9: 'statusCode'
			{
				match("statusCode");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__81"

	// $ANTLR start "T__82"
	public final void mT__82() throws RecognitionException {
		try {
			int _type = T__82;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:74:7: ( 'example' )
			// InternalXtextDsl.g:74:9: 'example'
			{
				match("example");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__82"

	// $ANTLR start "T__83"
	public final void mT__83() throws RecognitionException {
		try {
			int _type = T__83;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:75:7: ( 'externalExample' )
			// InternalXtextDsl.g:75:9: 'externalExample'
			{
				match("externalExample");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__83"

	// $ANTLR start "T__84"
	public final void mT__84() throws RecognitionException {
		try {
			int _type = T__84;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:76:7: ( 'referenceEmbed' )
			// InternalXtextDsl.g:76:9: 'referenceEmbed'
			{
				match("referenceEmbed");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__84"

	// $ANTLR start "T__85"
	public final void mT__85() throws RecognitionException {
		try {
			int _type = T__85;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:77:7: ( '>' )
			// InternalXtextDsl.g:77:9: '>'
			{
				match('>');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__85"

	// $ANTLR start "T__86"
	public final void mT__86() throws RecognitionException {
		try {
			int _type = T__86;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:78:7: ( 'referenceLink' )
			// InternalXtextDsl.g:78:9: 'referenceLink'
			{
				match("referenceLink");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__86"

	// $ANTLR start "T__87"
	public final void mT__87() throws RecognitionException {
		try {
			int _type = T__87;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:79:7: ( 'linkRelation' )
			// InternalXtextDsl.g:79:9: 'linkRelation'
			{
				match("linkRelation");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__87"

	// $ANTLR start "T__88"
	public final void mT__88() throws RecognitionException {
		try {
			int _type = T__88;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:80:7: ( 'targetResource' )
			// InternalXtextDsl.g:80:9: 'targetResource'
			{
				match("targetResource");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__88"

	// $ANTLR start "T__89"
	public final void mT__89() throws RecognitionException {
		try {
			int _type = T__89;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:81:7: ( 'linkDescriptor' )
			// InternalXtextDsl.g:81:9: 'linkDescriptor'
			{
				match("linkDescriptor");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__89"

	// $ANTLR start "T__90"
	public final void mT__90() throws RecognitionException {
		try {
			int _type = T__90;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:82:7: ( 'targetProperties' )
			// InternalXtextDsl.g:82:9: 'targetProperties'
			{
				match("targetProperties");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__90"

	// $ANTLR start "T__91"
	public final void mT__91() throws RecognitionException {
		try {
			int _type = T__91;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:83:7: ( 'dataModel' )
			// InternalXtextDsl.g:83:9: 'dataModel'
			{
				match("dataModel");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__91"

	// $ANTLR start "T__92"
	public final void mT__92() throws RecognitionException {
		try {
			int _type = T__92;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:84:7: ( 'structure' )
			// InternalXtextDsl.g:84:9: 'structure'
			{
				match("structure");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__92"

	// $ANTLR start "T__93"
	public final void mT__93() throws RecognitionException {
		try {
			int _type = T__93;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:85:7: ( 'extends' )
			// InternalXtextDsl.g:85:9: 'extends'
			{
				match("extends");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__93"

	// $ANTLR start "T__94"
	public final void mT__94() throws RecognitionException {
		try {
			int _type = T__94;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:86:7: ( 'and' )
			// InternalXtextDsl.g:86:9: 'and'
			{
				match("and");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__94"

	// $ANTLR start "T__95"
	public final void mT__95() throws RecognitionException {
		try {
			int _type = T__95;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:87:7: ( 'dataExample' )
			// InternalXtextDsl.g:87:9: 'dataExample'
			{
				match("dataExample");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__95"

	// $ANTLR start "T__96"
	public final void mT__96() throws RecognitionException {
		try {
			int _type = T__96;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:88:7: ( 'restrict' )
			// InternalXtextDsl.g:88:9: 'restrict'
			{
				match("restrict");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__96"

	// $ANTLR start "T__97"
	public final void mT__97() throws RecognitionException {
		try {
			int _type = T__97;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:89:7: ( ':' )
			// InternalXtextDsl.g:89:9: ':'
			{
				match(':');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__97"

	// $ANTLR start "T__98"
	public final void mT__98() throws RecognitionException {
		try {
			int _type = T__98;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:90:7: ( 'containing' )
			// InternalXtextDsl.g:90:9: 'containing'
			{
				match("containing");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__98"

	// $ANTLR start "T__99"
	public final void mT__99() throws RecognitionException {
		try {
			int _type = T__99;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:91:7: ( 'container' )
			// InternalXtextDsl.g:91:9: 'container'
			{
				match("container");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__99"

	// $ANTLR start "T__100"
	public final void mT__100() throws RecognitionException {
		try {
			int _type = T__100;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:92:8: ( 'reference' )
			// InternalXtextDsl.g:92:10: 'reference'
			{
				match("reference");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__100"

	// $ANTLR start "T__101"
	public final void mT__101() throws RecognitionException {
		try {
			int _type = T__101;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:93:8: ( 'inverse' )
			// InternalXtextDsl.g:93:10: 'inverse'
			{
				match("inverse");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__101"

	// $ANTLR start "T__102"
	public final void mT__102() throws RecognitionException {
		try {
			int _type = T__102;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:94:8: ( 'readOnly' )
			// InternalXtextDsl.g:94:10: 'readOnly'
			{
				match("readOnly");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__102"

	// $ANTLR start "T__103"
	public final void mT__103() throws RecognitionException {
		try {
			int _type = T__103;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:95:8: ( 'key' )
			// InternalXtextDsl.g:95:10: 'key'
			{
				match("key");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__103"

	// $ANTLR start "T__104"
	public final void mT__104() throws RecognitionException {
		try {
			int _type = T__104;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:96:8: ( 'enum' )
			// InternalXtextDsl.g:96:10: 'enum'
			{
				match("enum");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__104"

	// $ANTLR start "T__105"
	public final void mT__105() throws RecognitionException {
		try {
			int _type = T__105;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:97:8: ( 'simpleType' )
			// InternalXtextDsl.g:97:10: 'simpleType'
			{
				match("simpleType");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__105"

	// $ANTLR start "T__106"
	public final void mT__106() throws RecognitionException {
		try {
			int _type = T__106;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:98:8: ( 'defined' )
			// InternalXtextDsl.g:98:10: 'defined'
			{
				match("defined");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__106"

	// $ANTLR start "T__107"
	public final void mT__107() throws RecognitionException {
		try {
			int _type = T__107;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:99:8: ( 'matching' )
			// InternalXtextDsl.g:99:10: 'matching'
			{
				match("matching");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__107"

	// $ANTLR start "T__108"
	public final void mT__108() throws RecognitionException {
		try {
			int _type = T__108;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:100:8: ( 'regex' )
			// InternalXtextDsl.g:100:10: 'regex'
			{
				match("regex");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__108"

	// $ANTLR start "T__109"
	public final void mT__109() throws RecognitionException {
		try {
			int _type = T__109;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:101:8: ( 'length' )
			// InternalXtextDsl.g:101:10: 'length'
			{
				match("length");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__109"

	// $ANTLR start "T__110"
	public final void mT__110() throws RecognitionException {
		try {
			int _type = T__110;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:102:8: ( 'minimum' )
			// InternalXtextDsl.g:102:10: 'minimum'
			{
				match("minimum");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__110"

	// $ANTLR start "T__111"
	public final void mT__111() throws RecognitionException {
		try {
			int _type = T__111;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:103:8: ( 'up' )
			// InternalXtextDsl.g:103:10: 'up'
			{
				match("up");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__111"

	// $ANTLR start "T__112"
	public final void mT__112() throws RecognitionException {
		try {
			int _type = T__112;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:104:8: ( 'maximum' )
			// InternalXtextDsl.g:104:10: 'maximum'
			{
				match("maximum");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__112"

	// $ANTLR start "T__113"
	public final void mT__113() throws RecognitionException {
		try {
			int _type = T__113;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:105:8: ( 'valueRange' )
			// InternalXtextDsl.g:105:10: 'valueRange'
			{
				match("valueRange");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__113"

	// $ANTLR start "T__114"
	public final void mT__114() throws RecognitionException {
		try {
			int _type = T__114;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:106:8: ( 'inclusive' )
			// InternalXtextDsl.g:106:10: 'inclusive'
			{
				match("inclusive");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__114"

	// $ANTLR start "T__115"
	public final void mT__115() throws RecognitionException {
		try {
			int _type = T__115;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:107:8: ( 'exclusive' )
			// InternalXtextDsl.g:107:10: 'exclusive'
			{
				match("exclusive");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__115"

	// $ANTLR start "T__116"
	public final void mT__116() throws RecognitionException {
		try {
			int _type = T__116;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:108:8: ( 'primitiveTypesLibrary' )
			// InternalXtextDsl.g:108:10: 'primitiveTypesLibrary'
			{
				match("primitiveTypesLibrary");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__116"

	// $ANTLR start "T__117"
	public final void mT__117() throws RecognitionException {
		try {
			int _type = T__117;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:109:8: ( 'primitiveType' )
			// InternalXtextDsl.g:109:10: 'primitiveType'
			{
				match("primitiveType");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__117"

	// $ANTLR start "T__118"
	public final void mT__118() throws RecognitionException {
		try {
			int _type = T__118;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:110:8: ( '?' )
			// InternalXtextDsl.g:110:10: '?'
			{
				match('?');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__118"

	// $ANTLR start "T__119"
	public final void mT__119() throws RecognitionException {
		try {
			int _type = T__119;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:111:8: ( '[' )
			// InternalXtextDsl.g:111:10: '['
			{
				match('[');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__119"

	// $ANTLR start "T__120"
	public final void mT__120() throws RecognitionException {
		try {
			int _type = T__120;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:112:8: ( '..' )
			// InternalXtextDsl.g:112:10: '..'
			{
				match("..");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__120"

	// $ANTLR start "T__121"
	public final void mT__121() throws RecognitionException {
		try {
			int _type = T__121;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:113:8: ( ']' )
			// InternalXtextDsl.g:113:10: ']'
			{
				match(']');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__121"

	// $ANTLR start "T__122"
	public final void mT__122() throws RecognitionException {
		try {
			int _type = T__122;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:114:8: ( 'operation' )
			// InternalXtextDsl.g:114:10: 'operation'
			{
				match("operation");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__122"

	// $ANTLR start "T__123"
	public final void mT__123() throws RecognitionException {
		try {
			int _type = T__123;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:115:8: ( 'mediaTypesLibrary' )
			// InternalXtextDsl.g:115:10: 'mediaTypesLibrary'
			{
				match("mediaTypesLibrary");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__123"

	// $ANTLR start "T__124"
	public final void mT__124() throws RecognitionException {
		try {
			int _type = T__124;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:116:8: ( 'mediaType' )
			// InternalXtextDsl.g:116:10: 'mediaType'
			{
				match("mediaType");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__124"

	// $ANTLR start "T__125"
	public final void mT__125() throws RecognitionException {
		try {
			int _type = T__125;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:117:8: ( 'specURL' )
			// InternalXtextDsl.g:117:10: 'specURL'
			{
				match("specURL");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__125"

	// $ANTLR start "T__126"
	public final void mT__126() throws RecognitionException {
		try {
			int _type = T__126;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:118:8: ( 'derivedFrom' )
			// InternalXtextDsl.g:118:10: 'derivedFrom'
			{
				match("derivedFrom");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__126"

	// $ANTLR start "T__127"
	public final void mT__127() throws RecognitionException {
		try {
			int _type = T__127;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:119:8: ( 'linkRelationsLibrary' )
			// InternalXtextDsl.g:119:10: 'linkRelationsLibrary'
			{
				match("linkRelationsLibrary");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__127"

	// $ANTLR start "T__128"
	public final void mT__128() throws RecognitionException {
		try {
			int _type = T__128;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:120:8: ( 'securitySchemesLibrary' )
			// InternalXtextDsl.g:120:10: 'securitySchemesLibrary'
			{
				match("securitySchemesLibrary");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__128"

	// $ANTLR start "T__129"
	public final void mT__129() throws RecognitionException {
		try {
			int _type = T__129;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:121:8: ( 'authorized' )
			// InternalXtextDsl.g:121:10: 'authorized'
			{
				match("authorized");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__129"

	// $ANTLR start "T__130"
	public final void mT__130() throws RecognitionException {
		try {
			int _type = T__130;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:122:8: ( 'for' )
			// InternalXtextDsl.g:122:10: 'for'
			{
				match("for");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__130"

	// $ANTLR start "T__131"
	public final void mT__131() throws RecognitionException {
		try {
			int _type = T__131;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:123:8: ( 'scopes' )
			// InternalXtextDsl.g:123:10: 'scopes'
			{
				match("scopes");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__131"

	// $ANTLR start "T__132"
	public final void mT__132() throws RecognitionException {
		try {
			int _type = T__132;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:124:8: ( 'securityScheme' )
			// InternalXtextDsl.g:124:10: 'securityScheme'
			{
				match("securityScheme");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__132"

	// $ANTLR start "T__133"
	public final void mT__133() throws RecognitionException {
		try {
			int _type = T__133;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:125:8: ( 'methodInvocation' )
			// InternalXtextDsl.g:125:10: 'methodInvocation'
			{
				match("methodInvocation");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__133"

	// $ANTLR start "T__134"
	public final void mT__134() throws RecognitionException {
		try {
			int _type = T__134;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:126:8: ( 'requires' )
			// InternalXtextDsl.g:126:10: 'requires'
			{
				match("requires");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__134"

	// $ANTLR start "T__135"
	public final void mT__135() throws RecognitionException {
		try {
			int _type = T__135;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:127:8: ( 'authorization' )
			// InternalXtextDsl.g:127:10: 'authorization'
			{
				match("authorization");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__135"

	// $ANTLR start "T__136"
	public final void mT__136() throws RecognitionException {
		try {
			int _type = T__136;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:128:8: ( 'defines' )
			// InternalXtextDsl.g:128:10: 'defines'
			{
				match("defines");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__136"

	// $ANTLR start "T__137"
	public final void mT__137() throws RecognitionException {
		try {
			int _type = T__137;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:129:8: ( 'uses' )
			// InternalXtextDsl.g:129:10: 'uses'
			{
				match("uses");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__137"

	// $ANTLR start "T__138"
	public final void mT__138() throws RecognitionException {
		try {
			int _type = T__138;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:130:8: ( 'flow' )
			// InternalXtextDsl.g:130:10: 'flow'
			{
				match("flow");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__138"

	// $ANTLR start "T__139"
	public final void mT__139() throws RecognitionException {
		try {
			int _type = T__139;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:131:8: ( 'settings' )
			// InternalXtextDsl.g:131:10: 'settings'
			{
				match("settings");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__139"

	// $ANTLR start "T__140"
	public final void mT__140() throws RecognitionException {
		try {
			int _type = T__140;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:132:8: ( 'errorResponse' )
			// InternalXtextDsl.g:132:10: 'errorResponse'
			{
				match("errorResponse");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__140"

	// $ANTLR start "T__141"
	public final void mT__141() throws RecognitionException {
		try {
			int _type = T__141;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:133:8: ( 'PUT' )
			// InternalXtextDsl.g:133:10: 'PUT'
			{
				match("PUT");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__141"

	// $ANTLR start "T__142"
	public final void mT__142() throws RecognitionException {
		try {
			int _type = T__142;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:134:8: ( 'POST' )
			// InternalXtextDsl.g:134:10: 'POST'
			{
				match("POST");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__142"

	// $ANTLR start "T__143"
	public final void mT__143() throws RecognitionException {
		try {
			int _type = T__143;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:135:8: ( 'DELETE' )
			// InternalXtextDsl.g:135:10: 'DELETE'
			{
				match("DELETE");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__143"

	// $ANTLR start "T__144"
	public final void mT__144() throws RecognitionException {
		try {
			int _type = T__144;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:136:8: ( 'HEAD' )
			// InternalXtextDsl.g:136:10: 'HEAD'
			{
				match("HEAD");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__144"

	// $ANTLR start "T__145"
	public final void mT__145() throws RecognitionException {
		try {
			int _type = T__145;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:137:8: ( 'GET' )
			// InternalXtextDsl.g:137:10: 'GET'
			{
				match("GET");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__145"

	// $ANTLR start "T__146"
	public final void mT__146() throws RecognitionException {
		try {
			int _type = T__146;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:138:8: ( 'PATCH' )
			// InternalXtextDsl.g:138:10: 'PATCH'
			{
				match("PATCH");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__146"

	// $ANTLR start "T__147"
	public final void mT__147() throws RecognitionException {
		try {
			int _type = T__147;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:139:8: ( 'TRACE' )
			// InternalXtextDsl.g:139:10: 'TRACE'
			{
				match("TRACE");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__147"

	// $ANTLR start "T__148"
	public final void mT__148() throws RecognitionException {
		try {
			int _type = T__148;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:140:8: ( 'CONNECT' )
			// InternalXtextDsl.g:140:10: 'CONNECT'
			{
				match("CONNECT");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__148"

	// $ANTLR start "T__149"
	public final void mT__149() throws RecognitionException {
		try {
			int _type = T__149;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:141:8: ( 'OPTIONS' )
			// InternalXtextDsl.g:141:10: 'OPTIONS'
			{
				match("OPTIONS");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__149"

	// $ANTLR start "T__150"
	public final void mT__150() throws RecognitionException {
		try {
			int _type = T__150;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:142:8: ( 'header' )
			// InternalXtextDsl.g:142:10: 'header'
			{
				match("header");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__150"

	// $ANTLR start "T__151"
	public final void mT__151() throws RecognitionException {
		try {
			int _type = T__151;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:143:8: ( 'query' )
			// InternalXtextDsl.g:143:10: 'query'
			{
				match("query");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__151"

	// $ANTLR start "T__152"
	public final void mT__152() throws RecognitionException {
		try {
			int _type = T__152;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:144:8: ( 'IMPLICIT' )
			// InternalXtextDsl.g:144:10: 'IMPLICIT'
			{
				match("IMPLICIT");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__152"

	// $ANTLR start "T__153"
	public final void mT__153() throws RecognitionException {
		try {
			int _type = T__153;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:145:8: ( 'PASSWORD' )
			// InternalXtextDsl.g:145:10: 'PASSWORD'
			{
				match("PASSWORD");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__153"

	// $ANTLR start "T__154"
	public final void mT__154() throws RecognitionException {
		try {
			int _type = T__154;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:146:8: ( 'APPLICATION' )
			// InternalXtextDsl.g:146:10: 'APPLICATION'
			{
				match("APPLICATION");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__154"

	// $ANTLR start "T__155"
	public final void mT__155() throws RecognitionException {
		try {
			int _type = T__155;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:147:8: ( 'ACCESS_CODE' )
			// InternalXtextDsl.g:147:10: 'ACCESS_CODE'
			{
				match("ACCESS_CODE");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__155"

	// $ANTLR start "T__156"
	public final void mT__156() throws RecognitionException {
		try {
			int _type = T__156;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:148:8: ( 'basic' )
			// InternalXtextDsl.g:148:10: 'basic'
			{
				match("basic");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__156"

	// $ANTLR start "T__157"
	public final void mT__157() throws RecognitionException {
		try {
			int _type = T__157;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:149:8: ( 'oauth2' )
			// InternalXtextDsl.g:149:10: 'oauth2'
			{
				match("oauth2");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__157"

	// $ANTLR start "T__158"
	public final void mT__158() throws RecognitionException {
		try {
			int _type = T__158;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:150:8: ( 'custom' )
			// InternalXtextDsl.g:150:10: 'custom'
			{
				match("custom");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__158"

	// $ANTLR start "RULE_RAW_STRING"
	public final void mRULE_RAW_STRING() throws RecognitionException {
		try {
			int _type = RULE_RAW_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9812:17: ( 'r' ( '\"' (~ ( '\"' ) )* '\"' | '\\'' (~ (
			// '\\'' ) )* '\\'' ) )
			// InternalXtextDsl.g:9812:19: 'r' ( '\"' (~ ( '\"' ) )* '\"' | '\\'' (~ ( '\\''
			// ) )* '\\'' )
			{
				match('r');
				// InternalXtextDsl.g:9812:23: ( '\"' (~ ( '\"' ) )* '\"' | '\\'' (~ ( '\\'' )
				// )* '\\'' )
				int alt3 = 2;
				int LA3_0 = input.LA(1);

				if ((LA3_0 == '\"')) {
					alt3 = 1;
				} else if ((LA3_0 == '\'')) {
					alt3 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

					throw nvae;
				}
				switch (alt3) {
				case 1:
				// InternalXtextDsl.g:9812:24: '\"' (~ ( '\"' ) )* '\"'
				{
					match('\"');
					// InternalXtextDsl.g:9812:28: (~ ( '\"' ) )*
					loop1: do {
						int alt1 = 2;
						int LA1_0 = input.LA(1);

						if (((LA1_0 >= '\u0000' && LA1_0 <= '!') || (LA1_0 >= '#' && LA1_0 <= '\uFFFF'))) {
							alt1 = 1;
						}

						switch (alt1) {
						case 1:
						// InternalXtextDsl.g:9812:28: ~ ( '\"' )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!')
									|| (input.LA(1) >= '#' && input.LA(1) <= '\uFFFF')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}

						}
							break;

						default:
							break loop1;
						}
					} while (true);

					match('\"');

				}
					break;
				case 2:
				// InternalXtextDsl.g:9812:40: '\\'' (~ ( '\\'' ) )* '\\''
				{
					match('\'');
					// InternalXtextDsl.g:9812:45: (~ ( '\\'' ) )*
					loop2: do {
						int alt2 = 2;
						int LA2_0 = input.LA(1);

						if (((LA2_0 >= '\u0000' && LA2_0 <= '&') || (LA2_0 >= '(' && LA2_0 <= '\uFFFF'))) {
							alt2 = 1;
						}

						switch (alt2) {
						case 1:
						// InternalXtextDsl.g:9812:45: ~ ( '\\'' )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&')
									|| (input.LA(1) >= '(' && input.LA(1) <= '\uFFFF')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}

						}
							break;

						default:
							break loop2;
						}
					} while (true);

					match('\'');

				}
					break;

				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_RAW_STRING"

	// $ANTLR start "RULE_JAVADOC_COMMENT"
	public final void mRULE_JAVADOC_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_JAVADOC_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9814:22: ( '/**' ( options {greedy=false; } : . )* '*/' )
			// InternalXtextDsl.g:9814:24: '/**' ( options {greedy=false; } : . )* '*/'
			{
				match("/**");

				// InternalXtextDsl.g:9814:30: ( options {greedy=false; } : . )*
				loop4: do {
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == '*')) {
						int LA4_1 = input.LA(2);

						if ((LA4_1 == '/')) {
							alt4 = 2;
						} else if (((LA4_1 >= '\u0000' && LA4_1 <= '.') || (LA4_1 >= '0' && LA4_1 <= '\uFFFF'))) {
							alt4 = 1;
						}

					} else if (((LA4_0 >= '\u0000' && LA4_0 <= ')') || (LA4_0 >= '+' && LA4_0 <= '\uFFFF'))) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
					// InternalXtextDsl.g:9814:58: .
					{
						matchAny();

					}
						break;

					default:
						break loop4;
					}
				} while (true);

				match("*/");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_JAVADOC_COMMENT"

	// $ANTLR start "RULE_ML_COMMENT"
	public final void mRULE_ML_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9816:17: ( '/* ' ( options {greedy=false; } : . )* '*/' )
			// InternalXtextDsl.g:9816:19: '/* ' ( options {greedy=false; } : . )* '*/'
			{
				match("/* ");

				// InternalXtextDsl.g:9816:25: ( options {greedy=false; } : . )*
				loop5: do {
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == '*')) {
						int LA5_1 = input.LA(2);

						if ((LA5_1 == '/')) {
							alt5 = 2;
						} else if (((LA5_1 >= '\u0000' && LA5_1 <= '.') || (LA5_1 >= '0' && LA5_1 <= '\uFFFF'))) {
							alt5 = 1;
						}

					} else if (((LA5_0 >= '\u0000' && LA5_0 <= ')') || (LA5_0 >= '+' && LA5_0 <= '\uFFFF'))) {
						alt5 = 1;
					}

					switch (alt5) {
					case 1:
					// InternalXtextDsl.g:9816:53: .
					{
						matchAny();

					}
						break;

					default:
						break loop5;
					}
				} while (true);

				match("*/");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_ML_COMMENT"

	// $ANTLR start "RULE_ML_COMMENT_NL"
	public final void mRULE_ML_COMMENT_NL() throws RecognitionException {
		try {
			int _type = RULE_ML_COMMENT_NL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9818:20: ( '/*\\n' ( options {greedy=false; } : . )* '*/'
			// )
			// InternalXtextDsl.g:9818:22: '/*\\n' ( options {greedy=false; } : . )* '*/'
			{
				match("/*\n");

				// InternalXtextDsl.g:9818:29: ( options {greedy=false; } : . )*
				loop6: do {
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if ((LA6_0 == '*')) {
						int LA6_1 = input.LA(2);

						if ((LA6_1 == '/')) {
							alt6 = 2;
						} else if (((LA6_1 >= '\u0000' && LA6_1 <= '.') || (LA6_1 >= '0' && LA6_1 <= '\uFFFF'))) {
							alt6 = 1;
						}

					} else if (((LA6_0 >= '\u0000' && LA6_0 <= ')') || (LA6_0 >= '+' && LA6_0 <= '\uFFFF'))) {
						alt6 = 1;
					}

					switch (alt6) {
					case 1:
					// InternalXtextDsl.g:9818:57: .
					{
						matchAny();

					}
						break;

					default:
						break loop6;
					}
				} while (true);

				match("*/");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_ML_COMMENT_NL"

	// $ANTLR start "RULE_SL_COMMENT"
	public final void mRULE_SL_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9820:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* )
			// InternalXtextDsl.g:9820:19: '//' (~ ( ( '\\n' | '\\r' ) ) )*
			{
				match("//");

				// InternalXtextDsl.g:9820:24: (~ ( ( '\\n' | '\\r' ) ) )*
				loop7: do {
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if (((LA7_0 >= '\u0000' && LA7_0 <= '\t') || (LA7_0 >= '\u000B' && LA7_0 <= '\f')
							|| (LA7_0 >= '\u000E' && LA7_0 <= '\uFFFF'))) {
						alt7 = 1;
					}

					switch (alt7) {
					case 1:
					// InternalXtextDsl.g:9820:24: ~ ( ( '\\n' | '\\r' ) )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t')
								|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
								|| (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop7;
					}
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_SL_COMMENT"

	// $ANTLR start "RULE_NL"
	public final void mRULE_NL() throws RecognitionException {
		try {
			int _type = RULE_NL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9822:9: ( ( ( '\\r' )? '\\n' )+ ( '\\t' )* )
			// InternalXtextDsl.g:9822:11: ( ( '\\r' )? '\\n' )+ ( '\\t' )*
			{
				// InternalXtextDsl.g:9822:11: ( ( '\\r' )? '\\n' )+
				int cnt9 = 0;
				loop9: do {
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if ((LA9_0 == '\n' || LA9_0 == '\r')) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// InternalXtextDsl.g:9822:12: ( '\\r' )? '\\n'
					{
						// InternalXtextDsl.g:9822:12: ( '\\r' )?
						int alt8 = 2;
						int LA8_0 = input.LA(1);

						if ((LA8_0 == '\r')) {
							alt8 = 1;
						}
						switch (alt8) {
						case 1:
						// InternalXtextDsl.g:9822:12: '\\r'
						{
							match('\r');

						}
							break;

						}

						match('\n');

					}
						break;

					default:
						if (cnt9 >= 1)
							break loop9;
						EarlyExitException eee = new EarlyExitException(9, input);
						throw eee;
					}
					cnt9++;
				} while (true);

				// InternalXtextDsl.g:9822:25: ( '\\t' )*
				loop10: do {
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if ((LA10_0 == '\t')) {
						alt10 = 1;
					}

					switch (alt10) {
					case 1:
					// InternalXtextDsl.g:9822:25: '\\t'
					{
						match('\t');

					}
						break;

					default:
						break loop10;
					}
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_NL"

	// $ANTLR start "RULE_BEGIN"
	public final void mRULE_BEGIN() throws RecognitionException {
		try {
			int _type = RULE_BEGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9824:12: ( '\\u250C' )
			// InternalXtextDsl.g:9824:14: '\\u250C'
			{
				match('\u250C');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_BEGIN"

	// $ANTLR start "RULE_END"
	public final void mRULE_END() throws RecognitionException {
		try {
			int _type = RULE_END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9826:10: ( '\\u2510' )
			// InternalXtextDsl.g:9826:12: '\\u2510'
			{
				match('\u2510');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_END"

	// $ANTLR start "RULE_WS"
	public final void mRULE_WS() throws RecognitionException {
		try {
			int _type = RULE_WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9828:9: ( ( ' ' | '\\t' )+ )
			// InternalXtextDsl.g:9828:11: ( ' ' | '\\t' )+
			{
				// InternalXtextDsl.g:9828:11: ( ' ' | '\\t' )+
				int cnt11 = 0;
				loop11: do {
					int alt11 = 2;
					int LA11_0 = input.LA(1);

					if ((LA11_0 == '\t' || LA11_0 == ' ')) {
						alt11 = 1;
					}

					switch (alt11) {
					case 1:
					// InternalXtextDsl.g:
					{
						if (input.LA(1) == '\t' || input.LA(1) == ' ') {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						if (cnt11 >= 1)
							break loop11;
						EarlyExitException eee = new EarlyExitException(11, input);
						throw eee;
					}
					cnt11++;
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_WS"

	// $ANTLR start "RULE_RICH_TEXT"
	public final void mRULE_RICH_TEXT() throws RecognitionException {
		try {
			int _type = RULE_RICH_TEXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9830:16: ( '\\'\\'\\'' ( RULE_IN_RICH_STRING )*
			// '\\'\\'\\'' )
			// InternalXtextDsl.g:9830:18: '\\'\\'\\'' ( RULE_IN_RICH_STRING )* '\\'\\'\\''
			{
				match("'''");

				// InternalXtextDsl.g:9830:27: ( RULE_IN_RICH_STRING )*
				loop12: do {
					int alt12 = 2;
					int LA12_0 = input.LA(1);

					if ((LA12_0 == '\'')) {
						int LA12_1 = input.LA(2);

						if ((LA12_1 == '\'')) {
							int LA12_3 = input.LA(3);

							if (((LA12_3 >= '\u0000' && LA12_3 <= '&') || (LA12_3 >= '(' && LA12_3 <= '\u00AA')
									|| (LA12_3 >= '\u00AC' && LA12_3 <= '\uFFFF'))) {
								alt12 = 1;
							}

						} else if (((LA12_1 >= '\u0000' && LA12_1 <= '&') || (LA12_1 >= '(' && LA12_1 <= '\u00AA')
								|| (LA12_1 >= '\u00AC' && LA12_1 <= '\uFFFF'))) {
							alt12 = 1;
						}

					} else if (((LA12_0 >= '\u0000' && LA12_0 <= '&') || (LA12_0 >= '(' && LA12_0 <= '\u00AA')
							|| (LA12_0 >= '\u00AC' && LA12_0 <= '\uFFFF'))) {
						alt12 = 1;
					}

					switch (alt12) {
					case 1:
					// InternalXtextDsl.g:9830:27: RULE_IN_RICH_STRING
					{
						mRULE_IN_RICH_STRING();

					}
						break;

					default:
						break loop12;
					}
				} while (true);

				match("'''");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_RICH_TEXT"

	// $ANTLR start "RULE_IN_RICH_STRING"
	public final void mRULE_IN_RICH_STRING() throws RecognitionException {
		try {
			// InternalXtextDsl.g:9832:30: ( ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\''
			// ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) ) )
			// InternalXtextDsl.g:9832:32: ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~
			// ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
			{
				// InternalXtextDsl.g:9832:32: ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~
				// ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
				int alt13 = 3;
				int LA13_0 = input.LA(1);

				if ((LA13_0 == '\'')) {
					int LA13_1 = input.LA(2);

					if ((LA13_1 == '\'')) {
						alt13 = 1;
					} else if (((LA13_1 >= '\u0000' && LA13_1 <= '&') || (LA13_1 >= '(' && LA13_1 <= '\u00AA')
							|| (LA13_1 >= '\u00AC' && LA13_1 <= '\uFFFF'))) {
						alt13 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 13, 1, input);

						throw nvae;
					}
				} else if (((LA13_0 >= '\u0000' && LA13_0 <= '&') || (LA13_0 >= '(' && LA13_0 <= '\u00AA')
						|| (LA13_0 >= '\u00AC' && LA13_0 <= '\uFFFF'))) {
					alt13 = 3;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 13, 0, input);

					throw nvae;
				}
				switch (alt13) {
				case 1:
				// InternalXtextDsl.g:9832:33: '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) )
				{
					match("''");

					if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&')
							|| (input.LA(1) >= '(' && input.LA(1) <= '\u00AA')
							|| (input.LA(1) >= '\u00AC' && input.LA(1) <= '\uFFFF')) {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

				}
					break;
				case 2:
				// InternalXtextDsl.g:9832:59: '\\'' ~ ( ( '\\u00AB' | '\\'' ) )
				{
					match('\'');
					if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&')
							|| (input.LA(1) >= '(' && input.LA(1) <= '\u00AA')
							|| (input.LA(1) >= '\u00AC' && input.LA(1) <= '\uFFFF')) {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

				}
					break;
				case 3:
				// InternalXtextDsl.g:9832:83: ~ ( ( '\\u00AB' | '\\'' ) )
				{
					if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&')
							|| (input.LA(1) >= '(' && input.LA(1) <= '\u00AA')
							|| (input.LA(1) >= '\u00AC' && input.LA(1) <= '\uFFFF')) {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(null, input);
						recover(mse);
						throw mse;
					}

				}
					break;

				}

			}

		} finally {
		}
	}
	// $ANTLR end "RULE_IN_RICH_STRING"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9834:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a'
			// .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// InternalXtextDsl.g:9834:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a'
			// .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
				// InternalXtextDsl.g:9834:11: ( '^' )?
				int alt14 = 2;
				int LA14_0 = input.LA(1);

				if ((LA14_0 == '^')) {
					alt14 = 1;
				}
				switch (alt14) {
				case 1:
				// InternalXtextDsl.g:9834:11: '^'
				{
					match('^');

				}
					break;

				}

				if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_'
						|| (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// InternalXtextDsl.g:9834:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
				loop15: do {
					int alt15 = 2;
					int LA15_0 = input.LA(1);

					if (((LA15_0 >= '0' && LA15_0 <= '9') || (LA15_0 >= 'A' && LA15_0 <= 'Z') || LA15_0 == '_'
							|| (LA15_0 >= 'a' && LA15_0 <= 'z'))) {
						alt15 = 1;
					}

					switch (alt15) {
					case 1:
					// InternalXtextDsl.g:
					{
						if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z')
								|| input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop15;
					}
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_ID"

	// $ANTLR start "RULE_INT"
	public final void mRULE_INT() throws RecognitionException {
		try {
			int _type = RULE_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9836:10: ( ( '0' .. '9' )+ )
			// InternalXtextDsl.g:9836:12: ( '0' .. '9' )+
			{
				// InternalXtextDsl.g:9836:12: ( '0' .. '9' )+
				int cnt16 = 0;
				loop16: do {
					int alt16 = 2;
					int LA16_0 = input.LA(1);

					if (((LA16_0 >= '0' && LA16_0 <= '9'))) {
						alt16 = 1;
					}

					switch (alt16) {
					case 1:
					// InternalXtextDsl.g:9836:13: '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt16 >= 1)
							break loop16;
						EarlyExitException eee = new EarlyExitException(16, input);
						throw eee;
					}
					cnt16++;
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_INT"

	// $ANTLR start "RULE_STRING"
	public final void mRULE_STRING() throws RecognitionException {
		try {
			int _type = RULE_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9838:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
			// '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
			// InternalXtextDsl.g:9838:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
			// '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
			{
				// InternalXtextDsl.g:9838:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
				// '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
				int alt19 = 2;
				int LA19_0 = input.LA(1);

				if ((LA19_0 == '\"')) {
					alt19 = 1;
				} else if ((LA19_0 == '\'')) {
					alt19 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 19, 0, input);

					throw nvae;
				}
				switch (alt19) {
				case 1:
				// InternalXtextDsl.g:9838:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
				{
					match('\"');
					// InternalXtextDsl.g:9838:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
					loop17: do {
						int alt17 = 3;
						int LA17_0 = input.LA(1);

						if ((LA17_0 == '\\')) {
							alt17 = 1;
						} else if (((LA17_0 >= '\u0000' && LA17_0 <= '!') || (LA17_0 >= '#' && LA17_0 <= '[')
								|| (LA17_0 >= ']' && LA17_0 <= '\uFFFF'))) {
							alt17 = 2;
						}

						switch (alt17) {
						case 1:
						// InternalXtextDsl.g:9838:21: '\\\\' .
						{
							match('\\');
							matchAny();

						}
							break;
						case 2:
						// InternalXtextDsl.g:9838:28: ~ ( ( '\\\\' | '\"' ) )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!')
									|| (input.LA(1) >= '#' && input.LA(1) <= '[')
									|| (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}

						}
							break;

						default:
							break loop17;
						}
					} while (true);

					match('\"');

				}
					break;
				case 2:
				// InternalXtextDsl.g:9838:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
				// '\\''
				{
					match('\'');
					// InternalXtextDsl.g:9838:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
					loop18: do {
						int alt18 = 3;
						int LA18_0 = input.LA(1);

						if ((LA18_0 == '\\')) {
							alt18 = 1;
						} else if (((LA18_0 >= '\u0000' && LA18_0 <= '&') || (LA18_0 >= '(' && LA18_0 <= '[')
								|| (LA18_0 >= ']' && LA18_0 <= '\uFFFF'))) {
							alt18 = 2;
						}

						switch (alt18) {
						case 1:
						// InternalXtextDsl.g:9838:54: '\\\\' .
						{
							match('\\');
							matchAny();

						}
							break;
						case 2:
						// InternalXtextDsl.g:9838:61: ~ ( ( '\\\\' | '\\'' ) )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&')
									|| (input.LA(1) >= '(' && input.LA(1) <= '[')
									|| (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}

						}
							break;

						default:
							break loop18;
						}
					} while (true);

					match('\'');

				}
					break;

				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_STRING"

	// $ANTLR start "RULE_ANY_OTHER"
	public final void mRULE_ANY_OTHER() throws RecognitionException {
		try {
			int _type = RULE_ANY_OTHER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalXtextDsl.g:9840:16: ( . )
			// InternalXtextDsl.g:9840:18: .
			{
				matchAny();

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RULE_ANY_OTHER"

	public void mTokens() throws RecognitionException {
		// InternalXtextDsl.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 |
		// T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34
		// | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 |
		// T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53
		// | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 |
		// T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72
		// | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 |
		// T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91
		// | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 |
		// T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 |
		// T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 |
		// T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 |
		// T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 |
		// T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 |
		// T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 |
		// T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 |
		// T__157 | T__158 | RULE_RAW_STRING | RULE_JAVADOC_COMMENT | RULE_ML_COMMENT |
		// RULE_ML_COMMENT_NL | RULE_SL_COMMENT | RULE_NL | RULE_BEGIN | RULE_END |
		// RULE_WS | RULE_RICH_TEXT | RULE_ID | RULE_INT | RULE_STRING | RULE_ANY_OTHER
		// )
		int alt20 = 154;
		alt20 = dfa20.predict(input);
		switch (alt20) {
		case 1:
		// InternalXtextDsl.g:1:10: T__19
		{
			mT__19();

		}
			break;
		case 2:
		// InternalXtextDsl.g:1:16: T__20
		{
			mT__20();

		}
			break;
		case 3:
		// InternalXtextDsl.g:1:22: T__21
		{
			mT__21();

		}
			break;
		case 4:
		// InternalXtextDsl.g:1:28: T__22
		{
			mT__22();

		}
			break;
		case 5:
		// InternalXtextDsl.g:1:34: T__23
		{
			mT__23();

		}
			break;
		case 6:
		// InternalXtextDsl.g:1:40: T__24
		{
			mT__24();

		}
			break;
		case 7:
		// InternalXtextDsl.g:1:46: T__25
		{
			mT__25();

		}
			break;
		case 8:
		// InternalXtextDsl.g:1:52: T__26
		{
			mT__26();

		}
			break;
		case 9:
		// InternalXtextDsl.g:1:58: T__27
		{
			mT__27();

		}
			break;
		case 10:
		// InternalXtextDsl.g:1:64: T__28
		{
			mT__28();

		}
			break;
		case 11:
		// InternalXtextDsl.g:1:70: T__29
		{
			mT__29();

		}
			break;
		case 12:
		// InternalXtextDsl.g:1:76: T__30
		{
			mT__30();

		}
			break;
		case 13:
		// InternalXtextDsl.g:1:82: T__31
		{
			mT__31();

		}
			break;
		case 14:
		// InternalXtextDsl.g:1:88: T__32
		{
			mT__32();

		}
			break;
		case 15:
		// InternalXtextDsl.g:1:94: T__33
		{
			mT__33();

		}
			break;
		case 16:
		// InternalXtextDsl.g:1:100: T__34
		{
			mT__34();

		}
			break;
		case 17:
		// InternalXtextDsl.g:1:106: T__35
		{
			mT__35();

		}
			break;
		case 18:
		// InternalXtextDsl.g:1:112: T__36
		{
			mT__36();

		}
			break;
		case 19:
		// InternalXtextDsl.g:1:118: T__37
		{
			mT__37();

		}
			break;
		case 20:
		// InternalXtextDsl.g:1:124: T__38
		{
			mT__38();

		}
			break;
		case 21:
		// InternalXtextDsl.g:1:130: T__39
		{
			mT__39();

		}
			break;
		case 22:
		// InternalXtextDsl.g:1:136: T__40
		{
			mT__40();

		}
			break;
		case 23:
		// InternalXtextDsl.g:1:142: T__41
		{
			mT__41();

		}
			break;
		case 24:
		// InternalXtextDsl.g:1:148: T__42
		{
			mT__42();

		}
			break;
		case 25:
		// InternalXtextDsl.g:1:154: T__43
		{
			mT__43();

		}
			break;
		case 26:
		// InternalXtextDsl.g:1:160: T__44
		{
			mT__44();

		}
			break;
		case 27:
		// InternalXtextDsl.g:1:166: T__45
		{
			mT__45();

		}
			break;
		case 28:
		// InternalXtextDsl.g:1:172: T__46
		{
			mT__46();

		}
			break;
		case 29:
		// InternalXtextDsl.g:1:178: T__47
		{
			mT__47();

		}
			break;
		case 30:
		// InternalXtextDsl.g:1:184: T__48
		{
			mT__48();

		}
			break;
		case 31:
		// InternalXtextDsl.g:1:190: T__49
		{
			mT__49();

		}
			break;
		case 32:
		// InternalXtextDsl.g:1:196: T__50
		{
			mT__50();

		}
			break;
		case 33:
		// InternalXtextDsl.g:1:202: T__51
		{
			mT__51();

		}
			break;
		case 34:
		// InternalXtextDsl.g:1:208: T__52
		{
			mT__52();

		}
			break;
		case 35:
		// InternalXtextDsl.g:1:214: T__53
		{
			mT__53();

		}
			break;
		case 36:
		// InternalXtextDsl.g:1:220: T__54
		{
			mT__54();

		}
			break;
		case 37:
		// InternalXtextDsl.g:1:226: T__55
		{
			mT__55();

		}
			break;
		case 38:
		// InternalXtextDsl.g:1:232: T__56
		{
			mT__56();

		}
			break;
		case 39:
		// InternalXtextDsl.g:1:238: T__57
		{
			mT__57();

		}
			break;
		case 40:
		// InternalXtextDsl.g:1:244: T__58
		{
			mT__58();

		}
			break;
		case 41:
		// InternalXtextDsl.g:1:250: T__59
		{
			mT__59();

		}
			break;
		case 42:
		// InternalXtextDsl.g:1:256: T__60
		{
			mT__60();

		}
			break;
		case 43:
		// InternalXtextDsl.g:1:262: T__61
		{
			mT__61();

		}
			break;
		case 44:
		// InternalXtextDsl.g:1:268: T__62
		{
			mT__62();

		}
			break;
		case 45:
		// InternalXtextDsl.g:1:274: T__63
		{
			mT__63();

		}
			break;
		case 46:
		// InternalXtextDsl.g:1:280: T__64
		{
			mT__64();

		}
			break;
		case 47:
		// InternalXtextDsl.g:1:286: T__65
		{
			mT__65();

		}
			break;
		case 48:
		// InternalXtextDsl.g:1:292: T__66
		{
			mT__66();

		}
			break;
		case 49:
		// InternalXtextDsl.g:1:298: T__67
		{
			mT__67();

		}
			break;
		case 50:
		// InternalXtextDsl.g:1:304: T__68
		{
			mT__68();

		}
			break;
		case 51:
		// InternalXtextDsl.g:1:310: T__69
		{
			mT__69();

		}
			break;
		case 52:
		// InternalXtextDsl.g:1:316: T__70
		{
			mT__70();

		}
			break;
		case 53:
		// InternalXtextDsl.g:1:322: T__71
		{
			mT__71();

		}
			break;
		case 54:
		// InternalXtextDsl.g:1:328: T__72
		{
			mT__72();

		}
			break;
		case 55:
		// InternalXtextDsl.g:1:334: T__73
		{
			mT__73();

		}
			break;
		case 56:
		// InternalXtextDsl.g:1:340: T__74
		{
			mT__74();

		}
			break;
		case 57:
		// InternalXtextDsl.g:1:346: T__75
		{
			mT__75();

		}
			break;
		case 58:
		// InternalXtextDsl.g:1:352: T__76
		{
			mT__76();

		}
			break;
		case 59:
		// InternalXtextDsl.g:1:358: T__77
		{
			mT__77();

		}
			break;
		case 60:
		// InternalXtextDsl.g:1:364: T__78
		{
			mT__78();

		}
			break;
		case 61:
		// InternalXtextDsl.g:1:370: T__79
		{
			mT__79();

		}
			break;
		case 62:
		// InternalXtextDsl.g:1:376: T__80
		{
			mT__80();

		}
			break;
		case 63:
		// InternalXtextDsl.g:1:382: T__81
		{
			mT__81();

		}
			break;
		case 64:
		// InternalXtextDsl.g:1:388: T__82
		{
			mT__82();

		}
			break;
		case 65:
		// InternalXtextDsl.g:1:394: T__83
		{
			mT__83();

		}
			break;
		case 66:
		// InternalXtextDsl.g:1:400: T__84
		{
			mT__84();

		}
			break;
		case 67:
		// InternalXtextDsl.g:1:406: T__85
		{
			mT__85();

		}
			break;
		case 68:
		// InternalXtextDsl.g:1:412: T__86
		{
			mT__86();

		}
			break;
		case 69:
		// InternalXtextDsl.g:1:418: T__87
		{
			mT__87();

		}
			break;
		case 70:
		// InternalXtextDsl.g:1:424: T__88
		{
			mT__88();

		}
			break;
		case 71:
		// InternalXtextDsl.g:1:430: T__89
		{
			mT__89();

		}
			break;
		case 72:
		// InternalXtextDsl.g:1:436: T__90
		{
			mT__90();

		}
			break;
		case 73:
		// InternalXtextDsl.g:1:442: T__91
		{
			mT__91();

		}
			break;
		case 74:
		// InternalXtextDsl.g:1:448: T__92
		{
			mT__92();

		}
			break;
		case 75:
		// InternalXtextDsl.g:1:454: T__93
		{
			mT__93();

		}
			break;
		case 76:
		// InternalXtextDsl.g:1:460: T__94
		{
			mT__94();

		}
			break;
		case 77:
		// InternalXtextDsl.g:1:466: T__95
		{
			mT__95();

		}
			break;
		case 78:
		// InternalXtextDsl.g:1:472: T__96
		{
			mT__96();

		}
			break;
		case 79:
		// InternalXtextDsl.g:1:478: T__97
		{
			mT__97();

		}
			break;
		case 80:
		// InternalXtextDsl.g:1:484: T__98
		{
			mT__98();

		}
			break;
		case 81:
		// InternalXtextDsl.g:1:490: T__99
		{
			mT__99();

		}
			break;
		case 82:
		// InternalXtextDsl.g:1:496: T__100
		{
			mT__100();

		}
			break;
		case 83:
		// InternalXtextDsl.g:1:503: T__101
		{
			mT__101();

		}
			break;
		case 84:
		// InternalXtextDsl.g:1:510: T__102
		{
			mT__102();

		}
			break;
		case 85:
		// InternalXtextDsl.g:1:517: T__103
		{
			mT__103();

		}
			break;
		case 86:
		// InternalXtextDsl.g:1:524: T__104
		{
			mT__104();

		}
			break;
		case 87:
		// InternalXtextDsl.g:1:531: T__105
		{
			mT__105();

		}
			break;
		case 88:
		// InternalXtextDsl.g:1:538: T__106
		{
			mT__106();

		}
			break;
		case 89:
		// InternalXtextDsl.g:1:545: T__107
		{
			mT__107();

		}
			break;
		case 90:
		// InternalXtextDsl.g:1:552: T__108
		{
			mT__108();

		}
			break;
		case 91:
		// InternalXtextDsl.g:1:559: T__109
		{
			mT__109();

		}
			break;
		case 92:
		// InternalXtextDsl.g:1:566: T__110
		{
			mT__110();

		}
			break;
		case 93:
		// InternalXtextDsl.g:1:573: T__111
		{
			mT__111();

		}
			break;
		case 94:
		// InternalXtextDsl.g:1:580: T__112
		{
			mT__112();

		}
			break;
		case 95:
		// InternalXtextDsl.g:1:587: T__113
		{
			mT__113();

		}
			break;
		case 96:
		// InternalXtextDsl.g:1:594: T__114
		{
			mT__114();

		}
			break;
		case 97:
		// InternalXtextDsl.g:1:601: T__115
		{
			mT__115();

		}
			break;
		case 98:
		// InternalXtextDsl.g:1:608: T__116
		{
			mT__116();

		}
			break;
		case 99:
		// InternalXtextDsl.g:1:615: T__117
		{
			mT__117();

		}
			break;
		case 100:
		// InternalXtextDsl.g:1:622: T__118
		{
			mT__118();

		}
			break;
		case 101:
		// InternalXtextDsl.g:1:629: T__119
		{
			mT__119();

		}
			break;
		case 102:
		// InternalXtextDsl.g:1:636: T__120
		{
			mT__120();

		}
			break;
		case 103:
		// InternalXtextDsl.g:1:643: T__121
		{
			mT__121();

		}
			break;
		case 104:
		// InternalXtextDsl.g:1:650: T__122
		{
			mT__122();

		}
			break;
		case 105:
		// InternalXtextDsl.g:1:657: T__123
		{
			mT__123();

		}
			break;
		case 106:
		// InternalXtextDsl.g:1:664: T__124
		{
			mT__124();

		}
			break;
		case 107:
		// InternalXtextDsl.g:1:671: T__125
		{
			mT__125();

		}
			break;
		case 108:
		// InternalXtextDsl.g:1:678: T__126
		{
			mT__126();

		}
			break;
		case 109:
		// InternalXtextDsl.g:1:685: T__127
		{
			mT__127();

		}
			break;
		case 110:
		// InternalXtextDsl.g:1:692: T__128
		{
			mT__128();

		}
			break;
		case 111:
		// InternalXtextDsl.g:1:699: T__129
		{
			mT__129();

		}
			break;
		case 112:
		// InternalXtextDsl.g:1:706: T__130
		{
			mT__130();

		}
			break;
		case 113:
		// InternalXtextDsl.g:1:713: T__131
		{
			mT__131();

		}
			break;
		case 114:
		// InternalXtextDsl.g:1:720: T__132
		{
			mT__132();

		}
			break;
		case 115:
		// InternalXtextDsl.g:1:727: T__133
		{
			mT__133();

		}
			break;
		case 116:
		// InternalXtextDsl.g:1:734: T__134
		{
			mT__134();

		}
			break;
		case 117:
		// InternalXtextDsl.g:1:741: T__135
		{
			mT__135();

		}
			break;
		case 118:
		// InternalXtextDsl.g:1:748: T__136
		{
			mT__136();

		}
			break;
		case 119:
		// InternalXtextDsl.g:1:755: T__137
		{
			mT__137();

		}
			break;
		case 120:
		// InternalXtextDsl.g:1:762: T__138
		{
			mT__138();

		}
			break;
		case 121:
		// InternalXtextDsl.g:1:769: T__139
		{
			mT__139();

		}
			break;
		case 122:
		// InternalXtextDsl.g:1:776: T__140
		{
			mT__140();

		}
			break;
		case 123:
		// InternalXtextDsl.g:1:783: T__141
		{
			mT__141();

		}
			break;
		case 124:
		// InternalXtextDsl.g:1:790: T__142
		{
			mT__142();

		}
			break;
		case 125:
		// InternalXtextDsl.g:1:797: T__143
		{
			mT__143();

		}
			break;
		case 126:
		// InternalXtextDsl.g:1:804: T__144
		{
			mT__144();

		}
			break;
		case 127:
		// InternalXtextDsl.g:1:811: T__145
		{
			mT__145();

		}
			break;
		case 128:
		// InternalXtextDsl.g:1:818: T__146
		{
			mT__146();

		}
			break;
		case 129:
		// InternalXtextDsl.g:1:825: T__147
		{
			mT__147();

		}
			break;
		case 130:
		// InternalXtextDsl.g:1:832: T__148
		{
			mT__148();

		}
			break;
		case 131:
		// InternalXtextDsl.g:1:839: T__149
		{
			mT__149();

		}
			break;
		case 132:
		// InternalXtextDsl.g:1:846: T__150
		{
			mT__150();

		}
			break;
		case 133:
		// InternalXtextDsl.g:1:853: T__151
		{
			mT__151();

		}
			break;
		case 134:
		// InternalXtextDsl.g:1:860: T__152
		{
			mT__152();

		}
			break;
		case 135:
		// InternalXtextDsl.g:1:867: T__153
		{
			mT__153();

		}
			break;
		case 136:
		// InternalXtextDsl.g:1:874: T__154
		{
			mT__154();

		}
			break;
		case 137:
		// InternalXtextDsl.g:1:881: T__155
		{
			mT__155();

		}
			break;
		case 138:
		// InternalXtextDsl.g:1:888: T__156
		{
			mT__156();

		}
			break;
		case 139:
		// InternalXtextDsl.g:1:895: T__157
		{
			mT__157();

		}
			break;
		case 140:
		// InternalXtextDsl.g:1:902: T__158
		{
			mT__158();

		}
			break;
		case 141:
		// InternalXtextDsl.g:1:909: RULE_RAW_STRING
		{
			mRULE_RAW_STRING();

		}
			break;
		case 142:
		// InternalXtextDsl.g:1:925: RULE_JAVADOC_COMMENT
		{
			mRULE_JAVADOC_COMMENT();

		}
			break;
		case 143:
		// InternalXtextDsl.g:1:946: RULE_ML_COMMENT
		{
			mRULE_ML_COMMENT();

		}
			break;
		case 144:
		// InternalXtextDsl.g:1:962: RULE_ML_COMMENT_NL
		{
			mRULE_ML_COMMENT_NL();

		}
			break;
		case 145:
		// InternalXtextDsl.g:1:981: RULE_SL_COMMENT
		{
			mRULE_SL_COMMENT();

		}
			break;
		case 146:
		// InternalXtextDsl.g:1:997: RULE_NL
		{
			mRULE_NL();

		}
			break;
		case 147:
		// InternalXtextDsl.g:1:1005: RULE_BEGIN
		{
			mRULE_BEGIN();

		}
			break;
		case 148:
		// InternalXtextDsl.g:1:1016: RULE_END
		{
			mRULE_END();

		}
			break;
		case 149:
		// InternalXtextDsl.g:1:1025: RULE_WS
		{
			mRULE_WS();

		}
			break;
		case 150:
		// InternalXtextDsl.g:1:1033: RULE_RICH_TEXT
		{
			mRULE_RICH_TEXT();

		}
			break;
		case 151:
		// InternalXtextDsl.g:1:1048: RULE_ID
		{
			mRULE_ID();

		}
			break;
		case 152:
		// InternalXtextDsl.g:1:1056: RULE_INT
		{
			mRULE_INT();

		}
			break;
		case 153:
		// InternalXtextDsl.g:1:1065: RULE_STRING
		{
			mRULE_STRING();

		}
			break;
		case 154:
		// InternalXtextDsl.g:1:1077: RULE_ANY_OTHER
		{
			mRULE_ANY_OTHER();

		}
			break;

		}

	}

	protected DFA20 dfa20 = new DFA20(this);
	static final String DFA20_eotS = "\1\uffff\17\104\1\uffff\2\104\1\170\4\uffff\1\176\1\177\5\uffff\1\u0086\6\uffff\1\104\2\uffff\2\104\3\uffff\13\104\1\102\4\uffff\1\102\2\uffff\1\102\1\uffff\1\104\1\uffff\2\104\1\uffff\2\104\1\u00b5\10\104\1\u00c2\4\104\1\u00c7\6\104\1\u00ce\16\104\1\uffff\2\104\1\u00e5\4\104\17\uffff\1\u0087\10\uffff\3\104\2\uffff\1\104\1\u00f3\1\104\3\uffff\16\104\5\uffff\11\104\1\uffff\14\104\1\uffff\2\104\1\u011d\1\104\1\uffff\1\104\1\u0121\1\u0122\3\104\1\uffff\16\104\1\u0136\7\104\1\uffff\5\104\4\uffff\3\104\1\u0147\1\uffff\1\104\1\u0149\5\104\1\u014f\21\104\1\u0162\1\104\1\u0164\1\104\1\u0166\4\104\1\u016c\4\104\1\u0171\1\104\1\uffff\1\u0173\2\104\2\uffff\23\104\1\uffff\7\104\1\u0191\10\104\1\uffff\1\u019b\1\uffff\1\u019c\3\104\1\u01a0\1\uffff\21\104\1\u01b2\1\uffff\1\u01b3\1\uffff\1\104\1\uffff\5\104\1\uffff\4\104\1\uffff\1\u01c1\1\uffff\5\104\1\u01c7\1\u01c8\26\104\1\uffff\4\104\1\u01e4\4\104\2\uffff\1\u01e9\2\104\1\uffff\1\u01ec\3\104\1\u01f0\14\104\2\uffff\11\104\1\u0207\3\104\1\uffff\5\104\2\uffff\7\104\1\u0217\7\104\1\u0220\1\104\1\u0223\6\104\1\u022a\2\104\1\uffff\3\104\1\u0230\1\uffff\1\104\1\u0232\1\uffff\2\104\1\u0235\1\uffff\11\104\1\u0240\6\104\1\u0247\3\104\1\u024b\1\104\1\uffff\2\104\1\u024f\2\104\1\u0252\1\104\1\u0254\1\u0255\5\104\1\u025b\1\uffff\1\u025c\1\u025d\1\u025e\5\104\1\uffff\2\104\1\uffff\2\104\1\u0269\1\u026a\2\104\1\uffff\2\104\1\u0270\2\104\1\uffff\1\104\1\uffff\1\u0274\1\u0275\1\uffff\5\104\1\u027c\1\u027d\1\u027e\1\u027f\1\u0280\1\uffff\1\104\1\u0282\4\104\1\uffff\3\104\1\uffff\3\104\1\uffff\2\104\1\uffff\1\104\2\uffff\1\104\1\u0292\3\104\4\uffff\11\104\1\u029f\2\uffff\3\104\1\u02a3\1\104\1\uffff\2\104\1\u02a7\2\uffff\1\u02a8\5\104\5\uffff\1\u02b0\1\uffff\5\104\1\u02b6\1\u02b7\1\104\1\u02b9\1\u02ba\5\104\1\uffff\1\104\1\u02c1\2\104\1\u02c4\3\104\1\u02c8\1\u02ca\2\104\1\uffff\1\104\1\u02ce\1\104\1\uffff\3\104\2\uffff\2\104\1\uffff\1\u02d5\3\104\1\uffff\3\104\1\u02dc\1\104\2\uffff\1\104\2\uffff\1\104\1\u02e0\1\104\1\u02e2\1\104\1\u02e4\1\uffff\1\u02e5\1\104\1\uffff\2\104\1\u02ea\1\uffff\1\u02ec\1\uffff\3\104\1\uffff\1\u02f0\5\104\1\uffff\1\u02f6\5\104\1\uffff\3\104\1\uffff\1\104\1\uffff\1\104\2\uffff\1\u0301\1\u0302\2\104\1\uffff\1\104\1\uffff\1\104\1\u0307\1\104\1\uffff\3\104\1\u030c\1\u030d\1\uffff\12\104\2\uffff\4\104\1\uffff\2\104\1\u031f\1\104\2\uffff\1\104\1\u0322\1\u0323\3\104\1\u0327\1\104\1\u0329\6\104\1\u0331\1\104\1\uffff\1\104\1\u0334\2\uffff\1\u0335\2\104\1\uffff\1\104\1\uffff\1\u033a\4\104\1\u033f\1\104\1\uffff\1\104\1\u0342\2\uffff\1\104\1\u0344\2\104\1\uffff\1\104\1\u0348\2\104\1\uffff\2\104\1\uffff\1\u034d\1\uffff\1\u034e\2\104\1\uffff\1\104\1\u0352\2\104\2\uffff\2\104\1\u0357\1\uffff\3\104\1\u035b\1\uffff\3\104\1\uffff\4\104\1\u0363\1\104\1\u0365\1\uffff\1\u0366\2\uffff";
	static final String DFA20_eofS = "\u0367\uffff";
	static final String DFA20_minS = "\1\0\1\141\1\42\1\151\1\141\1\156\1\155\1\151\1\154\2\141\1\143\1\141\1\157\1\122\1\141\1\uffff\2\141\1\52\4\uffff\1\56\1\60\5\uffff\1\0\6\uffff\1\145\2\uffff\1\145\1\160\3\uffff\1\101\3\105\1\122\1\117\1\120\1\145\1\165\1\115\1\103\1\12\4\uffff\1\101\2\uffff\1\0\1\uffff\1\155\1\uffff\1\160\1\141\1\uffff\2\164\1\60\1\160\1\155\1\151\1\162\1\141\1\165\1\162\1\160\1\60\1\157\1\170\1\162\1\157\1\60\1\164\1\154\1\144\1\162\1\154\1\163\1\60\1\165\1\143\1\141\1\155\1\145\1\157\1\146\1\164\1\154\1\163\1\111\1\144\1\164\1\156\1\uffff\1\152\1\154\1\60\1\145\1\165\1\151\1\162\1\12\16\uffff\1\47\10\uffff\1\143\2\156\2\uffff\1\171\1\60\1\145\3\uffff\1\124\2\123\1\114\1\101\1\124\1\101\1\116\1\124\1\141\1\145\2\120\1\103\5\uffff\1\145\1\151\1\157\1\165\1\145\1\144\1\145\1\150\1\154\1\uffff\1\145\1\160\1\163\1\147\1\145\1\154\2\155\2\157\1\154\1\145\1\uffff\1\155\1\145\1\60\1\167\1\uffff\1\150\2\60\1\163\1\165\1\145\1\uffff\1\156\1\165\2\164\1\165\1\160\1\143\1\160\1\141\1\151\1\141\1\154\2\164\1\60\1\151\1\150\1\143\2\151\1\145\1\171\1\uffff\1\162\1\164\1\160\1\155\1\141\4\uffff\1\141\1\153\1\147\1\60\1\uffff\1\163\1\60\1\124\1\103\1\123\1\105\1\104\1\60\1\103\1\116\1\111\1\144\1\162\2\114\1\105\1\163\1\144\1\165\1\157\1\162\1\145\1\162\1\117\1\170\1\60\1\145\1\60\1\154\1\60\1\145\1\156\1\165\1\160\1\60\2\162\1\165\1\162\1\60\1\144\1\uffff\1\60\1\122\1\157\2\uffff\1\151\1\145\1\125\1\143\1\144\1\162\1\151\1\165\1\143\1\154\1\125\1\145\1\165\1\156\1\166\1\105\1\145\1\141\1\157\1\uffff\1\141\1\157\1\151\1\150\2\155\1\143\1\60\1\141\1\150\1\145\1\151\1\155\1\164\1\104\1\164\1\uffff\1\60\1\uffff\1\60\1\110\1\127\1\124\1\60\1\uffff\2\105\1\117\1\145\1\171\2\111\1\123\1\160\1\115\1\162\1\156\1\151\1\162\1\163\1\145\1\156\1\60\1\uffff\1\60\1\uffff\1\141\1\uffff\1\164\1\144\1\156\1\144\1\154\1\uffff\1\122\1\164\1\144\1\163\1\uffff\1\60\1\uffff\1\145\1\162\1\157\2\122\2\60\1\145\1\156\1\163\1\164\1\145\1\122\1\163\1\154\2\145\1\157\1\170\1\143\1\151\1\155\1\124\1\144\1\170\1\151\2\165\1\164\1\uffff\1\164\1\62\1\162\1\164\1\60\3\145\1\150\2\uffff\1\60\1\117\1\105\1\uffff\1\60\1\103\1\116\1\162\1\60\2\103\1\123\1\141\1\157\1\143\1\163\1\143\1\145\1\164\1\156\1\154\2\uffff\1\164\1\120\1\151\1\163\1\141\2\151\2\145\1\60\2\151\1\145\1\uffff\1\141\1\151\1\156\1\141\1\111\2\uffff\1\144\1\164\1\147\1\103\1\165\1\124\1\114\1\60\1\164\3\144\1\141\1\164\1\156\1\60\1\171\1\60\1\120\1\156\2\155\1\122\1\151\1\60\1\164\1\151\1\uffff\1\144\1\154\1\163\1\60\1\uffff\1\122\1\60\1\uffff\1\124\1\123\1\60\1\uffff\1\111\1\101\1\137\1\143\1\144\2\145\1\164\1\144\1\60\1\143\1\171\2\145\1\162\1\157\1\60\1\154\1\156\1\166\1\60\1\163\1\uffff\1\156\1\166\1\60\1\154\1\172\1\60\1\156\2\60\1\171\1\163\1\157\1\162\1\171\1\60\1\uffff\3\60\1\106\1\145\1\155\1\151\1\145\1\uffff\1\160\1\156\1\uffff\1\141\1\147\2\60\1\145\1\157\1\uffff\1\151\1\166\1\60\1\141\1\143\1\uffff\1\104\1\uffff\2\60\1\uffff\2\124\1\103\2\145\5\60\1\uffff\1\145\1\60\1\120\1\163\1\157\1\156\1\uffff\1\105\1\147\1\145\1\uffff\1\160\1\147\1\145\1\uffff\1\151\1\141\1\uffff\1\147\2\uffff\1\123\1\60\1\144\1\145\1\160\4\uffff\1\162\1\154\1\160\1\157\1\156\1\162\1\145\1\166\1\162\1\60\2\uffff\1\163\1\156\1\145\1\60\1\145\1\uffff\1\164\1\162\1\60\2\uffff\1\60\1\111\1\117\1\40\1\154\1\120\5\uffff\1\60\1\uffff\1\141\1\157\1\160\1\163\1\170\2\60\1\157\2\60\1\172\1\144\1\164\1\145\1\143\1\uffff\1\145\1\60\1\145\1\157\1\60\1\154\1\156\1\147\2\60\1\157\1\141\1\uffff\1\157\1\60\1\163\1\uffff\1\124\2\151\2\uffff\1\117\1\104\1\uffff\1\60\1\111\1\155\1\151\1\uffff\1\162\1\165\1\145\1\60\1\141\2\uffff\1\156\2\uffff\1\141\1\60\1\151\1\60\1\150\1\60\1\uffff\1\60\1\155\1\uffff\1\145\1\120\1\60\1\uffff\1\60\1\uffff\1\143\1\155\1\165\1\uffff\1\60\1\171\1\157\1\160\1\116\1\105\1\uffff\1\60\1\142\1\156\1\141\2\162\1\uffff\1\155\1\163\1\164\1\uffff\1\157\1\uffff\1\145\2\uffff\2\60\1\145\1\141\1\uffff\1\151\1\uffff\1\141\1\60\1\162\1\uffff\1\160\1\156\1\164\2\60\1\uffff\1\145\1\153\1\155\1\143\1\164\1\160\1\145\1\151\1\156\1\155\2\uffff\1\163\1\162\1\142\1\164\1\uffff\1\143\1\145\1\60\1\157\2\uffff\1\144\2\60\1\145\1\151\1\154\1\60\1\157\1\60\1\145\1\157\1\141\1\162\1\151\1\145\1\60\1\114\1\uffff\1\162\1\60\2\uffff\1\60\2\145\1\uffff\1\156\1\uffff\1\60\1\165\1\155\1\141\1\157\1\60\1\114\1\uffff\1\151\1\60\2\uffff\1\163\1\60\1\163\1\114\1\uffff\1\162\1\60\1\162\1\156\1\uffff\1\151\1\142\1\uffff\1\60\1\uffff\1\60\1\151\1\143\1\uffff\1\171\1\60\1\142\1\162\2\uffff\1\142\1\145\1\60\1\uffff\1\162\1\141\1\162\1\60\1\uffff\1\141\1\162\1\141\1\uffff\1\162\1\171\1\162\1\171\1\60\1\171\1\60\1\uffff\1\60\2\uffff";
	static final String DFA20_maxS = "\1\uffff\1\141\1\145\1\151\1\171\1\170\1\156\1\162\1\165\1\145\1\171\1\164\1\145\1\165\1\122\1\151\1\uffff\1\160\1\162\1\57\4\uffff\1\56\1\172\5\uffff\1\uffff\6\uffff\1\157\2\uffff\1\145\1\163\3\uffff\1\125\3\105\1\122\1\117\1\120\1\145\1\165\1\115\1\120\1\12\4\uffff\1\172\2\uffff\1\uffff\1\uffff\1\155\1\uffff\1\160\1\163\1\uffff\2\164\1\172\1\160\1\155\1\151\1\162\1\164\1\165\1\162\1\160\1\172\1\157\1\170\1\162\1\157\1\172\1\164\1\154\1\144\1\162\1\154\1\163\1\172\1\165\1\164\1\162\1\155\1\145\1\157\1\162\1\164\1\156\1\163\1\111\1\164\1\170\1\156\1\uffff\1\152\1\154\1\172\1\145\1\165\1\157\1\162\1\52\16\uffff\1\47\10\uffff\1\143\2\156\2\uffff\1\171\1\172\1\145\3\uffff\1\124\1\123\1\124\1\114\1\101\1\124\1\101\1\116\1\124\1\141\1\145\2\120\1\103\5\uffff\1\145\1\151\1\164\1\165\1\145\1\144\1\145\1\150\1\154\1\uffff\1\145\1\160\1\163\1\147\1\145\1\154\2\155\2\157\1\154\1\145\1\uffff\1\155\1\145\1\172\1\167\1\uffff\1\157\2\172\1\163\1\165\1\151\1\uffff\1\156\1\165\2\164\1\165\1\160\1\143\1\160\2\151\1\141\1\154\2\164\1\172\1\151\1\150\1\162\2\151\1\145\1\171\1\uffff\1\162\1\164\1\160\1\155\1\141\4\uffff\1\141\1\153\1\147\1\172\1\uffff\1\163\1\172\1\124\1\103\1\123\1\105\1\104\1\172\1\103\1\116\1\111\1\144\1\162\2\114\1\105\1\163\1\144\1\165\1\157\1\162\1\151\1\162\1\117\1\170\1\172\1\145\1\172\1\154\1\172\1\145\1\162\1\165\1\160\1\172\2\162\1\165\1\162\1\172\1\144\1\uffff\1\172\1\122\1\157\2\uffff\1\151\1\145\1\125\1\143\1\144\1\162\1\151\1\165\1\143\1\154\1\125\1\145\1\165\1\156\1\166\1\115\1\145\1\141\1\157\1\uffff\1\141\1\157\1\151\1\150\2\155\1\143\1\172\1\141\1\150\1\145\1\151\1\155\1\164\1\122\1\164\1\uffff\1\172\1\uffff\1\172\1\110\1\127\1\124\1\172\1\uffff\2\105\1\117\1\145\1\171\2\111\1\123\1\160\1\115\1\162\1\156\1\151\1\162\1\163\1\145\1\156\1\172\1\uffff\1\172\1\uffff\1\141\1\uffff\1\164\1\163\1\156\1\163\1\154\1\uffff\1\122\1\164\2\163\1\uffff\1\172\1\uffff\1\145\1\162\1\157\2\122\2\172\1\151\1\156\1\163\1\164\1\145\1\122\1\163\1\154\2\145\1\157\1\170\1\143\1\151\1\155\1\124\1\144\1\170\1\151\2\165\1\164\1\uffff\1\164\1\62\1\162\1\164\1\172\3\145\1\150\2\uffff\1\172\1\117\1\105\1\uffff\1\172\1\103\1\116\1\162\1\172\2\103\1\123\1\141\1\157\1\143\1\163\1\143\1\145\1\164\1\156\1\154\2\uffff\1\164\1\122\1\151\1\163\1\141\2\151\2\145\1\172\2\151\1\145\1\uffff\1\141\1\151\1\156\1\141\1\111\2\uffff\1\144\1\164\1\147\1\103\1\165\1\124\1\114\1\172\1\164\1\163\2\144\1\141\1\164\1\156\1\172\1\171\1\172\1\120\1\156\2\155\1\122\1\151\1\172\1\164\1\151\1\uffff\1\144\1\154\1\163\1\172\1\uffff\1\122\1\172\1\uffff\1\124\1\123\1\172\1\uffff\1\111\1\101\1\137\1\143\1\144\2\145\1\164\1\163\1\172\1\143\1\171\2\145\1\162\1\157\1\172\1\154\1\156\1\166\1\172\1\163\1\uffff\1\156\1\166\1\172\1\154\2\172\1\156\2\172\1\171\1\163\1\157\1\162\1\171\1\172\1\uffff\3\172\1\106\1\145\1\155\2\151\1\uffff\1\160\1\156\1\uffff\1\141\1\147\2\172\1\145\1\157\1\uffff\1\171\1\166\1\172\1\141\1\143\1\uffff\1\104\1\uffff\2\172\1\uffff\2\124\1\103\2\145\5\172\1\uffff\1\145\1\172\1\120\1\163\1\157\1\156\1\uffff\1\105\1\147\1\145\1\uffff\1\160\1\147\1\145\1\uffff\1\151\1\145\1\uffff\1\147\2\uffff\1\123\1\172\1\144\1\145\1\160\4\uffff\1\162\1\154\1\160\1\157\1\156\1\162\1\145\1\166\1\162\1\172\2\uffff\1\163\1\156\1\145\1\172\1\145\1\uffff\1\164\1\162\1\172\2\uffff\1\172\1\111\1\117\1\40\1\154\1\120\5\uffff\1\172\1\uffff\1\141\1\157\1\160\1\163\1\170\2\172\1\157\3\172\1\144\1\164\1\145\1\143\1\uffff\1\145\1\172\1\145\1\157\1\172\1\154\1\156\1\147\2\172\1\157\1\141\1\uffff\1\157\1\172\1\163\1\uffff\1\124\2\151\2\uffff\1\117\1\104\1\uffff\1\172\1\111\1\155\1\151\1\uffff\1\162\1\165\1\145\1\172\1\141\2\uffff\1\156\2\uffff\1\141\1\172\1\151\1\172\1\150\1\172\1\uffff\1\172\1\155\1\uffff\1\145\1\122\1\172\1\uffff\1\172\1\uffff\1\143\1\155\1\165\1\uffff\1\172\1\171\1\157\1\160\1\116\1\105\1\uffff\1\172\1\142\1\156\1\141\2\162\1\uffff\1\155\1\163\1\164\1\uffff\1\157\1\uffff\1\145\2\uffff\2\172\1\145\1\141\1\uffff\1\151\1\uffff\1\141\1\172\1\162\1\uffff\1\160\1\156\1\164\2\172\1\uffff\1\145\1\153\1\155\1\143\1\164\1\160\1\145\1\151\1\156\1\155\2\uffff\1\163\1\162\1\142\1\164\1\uffff\1\143\1\145\1\172\1\157\2\uffff\1\144\2\172\1\145\1\151\1\154\1\172\1\157\1\172\1\145\1\157\1\141\1\162\1\151\1\145\1\172\1\114\1\uffff\1\162\1\172\2\uffff\1\172\2\145\1\uffff\1\156\1\uffff\1\172\1\165\1\155\1\141\1\157\1\172\1\114\1\uffff\1\151\1\172\2\uffff\1\163\1\172\1\163\1\114\1\uffff\1\162\1\172\1\162\1\156\1\uffff\1\151\1\142\1\uffff\1\172\1\uffff\1\172\1\151\1\143\1\uffff\1\171\1\172\1\142\1\162\2\uffff\1\142\1\145\1\172\1\uffff\1\162\1\141\1\162\1\172\1\uffff\1\141\1\162\1\141\1\uffff\1\162\1\171\1\162\1\171\1\172\1\171\1\172\1\uffff\1\172\2\uffff";
	static final String DFA20_acceptS = "\20\uffff\1\26\3\uffff\1\36\1\37\1\40\1\41\2\uffff\1\44\1\45\1\46\1\47\1\50\1\uffff\1\52\1\53\1\54\1\55\1\56\1\57\1\uffff\1\103\1\117\2\uffff\1\144\1\145\1\147\14\uffff\1\u0092\1\u0093\1\u0094\1\u0095\1\uffff\1\u0097\1\u0098\1\uffff\1\u009a\1\uffff\1\u0097\2\uffff\1\u008d\46\uffff\1\26\10\uffff\1\u0091\1\35\1\36\1\37\1\40\1\41\1\146\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\uffff\1\51\1\u0099\1\52\1\53\1\54\1\55\1\56\1\57\3\uffff\1\103\1\117\3\uffff\1\144\1\145\1\147\16\uffff\1\u0092\1\u0093\1\u0094\1\u0095\1\u0098\11\uffff\1\22\14\uffff\1\63\4\uffff\1\10\6\uffff\1\15\26\uffff\1\71\5\uffff\1\u008e\1\u008f\1\u0090\1\u0096\4\uffff\1\135\51\uffff\1\160\3\uffff\1\32\1\114\23\uffff\1\24\20\uffff\1\125\1\uffff\1\173\5\uffff\1\177\22\uffff\1\3\1\uffff\1\23\1\uffff\1\74\5\uffff\1\126\4\uffff\1\7\1\uffff\1\170\35\uffff\1\30\11\uffff\1\167\1\174\3\uffff\1\176\21\uffff\1\132\1\4\15\uffff\1\64\5\uffff\1\u008a\1\21\33\uffff\1\61\4\uffff\1\u0080\2\uffff\1\u0081\3\uffff\1\u0085\26\uffff\1\6\17\uffff\1\161\10\uffff\1\u008c\2\uffff\1\72\6\uffff\1\u008b\5\uffff\1\133\1\uffff\1\175\2\uffff\1\u0084\12\uffff\1\73\6\uffff\1\113\3\uffff\1\100\3\uffff\1\123\2\uffff\1\12\1\uffff\1\13\1\14\5\uffff\1\153\1\17\1\130\1\166\12\uffff\1\136\1\134\5\uffff\1\62\3\uffff\1\u0082\1\u0083\6\uffff\1\75\1\76\1\116\1\60\1\164\1\uffff\1\124\17\uffff\1\171\14\uffff\1\131\3\uffff\1\70\3\uffff\1\u0087\1\u0086\2\uffff\1\1\4\uffff\1\122\5\uffff\1\34\1\141\1\uffff\1\33\1\140\6\uffff\1\112\2\uffff\1\111\3\uffff\1\121\1\uffff\1\152\3\uffff\1\150\6\uffff\1\2\6\uffff\1\5\3\uffff\1\157\1\uffff\1\137\1\uffff\1\77\1\127\4\uffff\1\120\1\uffff\1\25\3\uffff\1\31\5\uffff\1\11\12\uffff\1\154\1\115\4\uffff\1\66\4\uffff\1\u0088\1\u0089\21\uffff\1\105\2\uffff\1\104\1\67\3\uffff\1\172\1\uffff\1\165\7\uffff\1\143\2\uffff\1\102\1\106\4\uffff\1\162\4\uffff\1\27\2\uffff\1\107\1\uffff\1\101\3\uffff\1\65\4\uffff\1\110\1\16\3\uffff\1\163\4\uffff\1\151\3\uffff\1\20\7\uffff\1\155\1\uffff\1\142\1\156";
	static final String DFA20_specialS = "\1\2\36\uffff\1\1\41\uffff\1\0\u0325\uffff}>";
	static final String[] DFA20_transitionS = {
			"\11\102\1\75\1\72\2\102\1\71\22\102\1\75\1\34\1\101\1\102\1\35\1\33\1\36\1\37\1\40\1\41\1\42\1\43\1\20\1\27\1\30\1\23\12\100\1\50\1\44\1\102\1\45\1\47\1\53\1\26\1\70\1\77\1\63\1\57\2\77\1\61\1\60\1\67\5\77\1\64\1\56\3\77\1\62\1\16\5\77\1\54\1\102\1\55\1\76\1\31\1\102\1\10\1\12\1\15\1\14\1\5\1\7\1\77\1\65\1\6\1\77\1\51\1\46\1\17\1\1\1\21\1\22\1\66\1\2\1\13\1\4\1\52\1\11\1\3\3\77\1\24\1\102\1\25\1\32\u248d\102\1\73\3\102\1\74\udaef\102",
			"\1\103", "\1\107\4\uffff\1\107\71\uffff\1\105\3\uffff\1\106", "\1\110",
			"\1\116\3\uffff\1\114\2\uffff\1\115\1\111\5\uffff\1\112\11\uffff\1\113",
			"\1\120\3\uffff\1\121\5\uffff\1\117", "\1\122\1\123", "\1\125\2\uffff\1\127\2\uffff\1\126\2\uffff\1\124",
			"\1\132\1\uffff\1\133\4\uffff\1\130\1\uffff\1\131", "\1\135\3\uffff\1\134",
			"\1\136\15\uffff\1\140\11\uffff\1\137", "\1\145\1\uffff\1\141\3\uffff\1\143\6\uffff\1\144\3\uffff\1\142",
			"\1\147\3\uffff\1\146", "\1\150\5\uffff\1\151", "\1\152", "\1\154\3\uffff\1\153\3\uffff\1\155", "",
			"\1\163\1\157\3\uffff\1\161\7\uffff\1\160\1\uffff\1\162", "\1\165\20\uffff\1\164", "\1\166\4\uffff\1\167",
			"", "", "", "", "\1\175", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "", "", "", "",
			"\47\u0087\1\u0085\uffd8\u0087", "", "", "", "", "", "", "\1\u0090\3\uffff\1\u008f\5\uffff\1\u008e", "", "",
			"\1\u0093", "\1\u0094\2\uffff\1\u0095", "", "", "", "\1\u009b\15\uffff\1\u009a\5\uffff\1\u0099", "\1\u009c",
			"\1\u009d", "\1\u009e", "\1\u009f", "\1\u00a0", "\1\u00a1", "\1\u00a2", "\1\u00a3", "\1\u00a4",
			"\1\u00a6\14\uffff\1\u00a5", "\1\u00a7", "", "", "", "", "\32\104\4\uffff\1\104\1\uffff\32\104", "", "",
			"\0\u0087", "", "\1\u00ac", "", "\1\u00ad",
			"\1\u00b1\4\uffff\1\u00b0\1\u00b2\11\uffff\1\u00af\1\uffff\1\u00ae", "", "\1\u00b3", "\1\u00b4",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u00b6", "\1\u00b7", "\1\u00b8", "\1\u00b9",
			"\1\u00bc\1\uffff\1\u00bb\20\uffff\1\u00ba", "\1\u00bd", "\1\u00be", "\1\u00bf",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\2\104\1\u00c0\22\104\1\u00c1\4\104", "\1\u00c3", "\1\u00c4",
			"\1\u00c5", "\1\u00c6", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u00c8", "\1\u00c9",
			"\1\u00ca", "\1\u00cb", "\1\u00cc", "\1\u00cd", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\1\u00cf", "\1\u00d0\20\uffff\1\u00d1", "\1\u00d2\20\uffff\1\u00d3", "\1\u00d4", "\1\u00d5", "\1\u00d6",
			"\1\u00d7\13\uffff\1\u00d8", "\1\u00d9", "\1\u00da\1\uffff\1\u00db", "\1\u00dc", "\1\u00dd",
			"\1\u00de\17\uffff\1\u00df", "\1\u00e0\3\uffff\1\u00e1", "\1\u00e2", "", "\1\u00e3", "\1\u00e4",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u00e6", "\1\u00e7", "\1\u00e9\5\uffff\1\u00e8",
			"\1\u00ea", "\1\u00ed\25\uffff\1\u00ec\11\uffff\1\u00eb", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "\1\u00ee", "", "", "", "", "", "", "", "", "\1\u00ef", "\1\u00f0", "\1\u00f1", "", "", "\1\u00f2",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u00f4", "", "", "", "\1\u00f5", "\1\u00f6",
			"\1\u00f8\1\u00f7", "\1\u00f9", "\1\u00fa", "\1\u00fb", "\1\u00fc", "\1\u00fd", "\1\u00fe", "\1\u00ff",
			"\1\u0100", "\1\u0101", "\1\u0102", "\1\u0103", "", "", "", "", "", "\1\u0104", "\1\u0105",
			"\1\u0106\1\u0107\3\uffff\1\u0108", "\1\u0109", "\1\u010a", "\1\u010b", "\1\u010c", "\1\u010d", "\1\u010e",
			"", "\1\u010f", "\1\u0110", "\1\u0111", "\1\u0112", "\1\u0113", "\1\u0114", "\1\u0115", "\1\u0116",
			"\1\u0117", "\1\u0118", "\1\u0119", "\1\u011a", "", "\1\u011b", "\1\u011c",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u011e", "", "\1\u0120\6\uffff\1\u011f",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0123", "\1\u0124", "\1\u0125\3\uffff\1\u0126",
			"", "\1\u0127", "\1\u0128", "\1\u0129", "\1\u012a", "\1\u012b", "\1\u012c", "\1\u012d", "\1\u012e",
			"\1\u012f\7\uffff\1\u0130", "\1\u0131", "\1\u0132", "\1\u0133", "\1\u0134", "\1\u0135",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0137", "\1\u0138", "\1\u013a\16\uffff\1\u0139",
			"\1\u013b", "\1\u013c", "\1\u013d", "\1\u013e", "", "\1\u013f", "\1\u0140", "\1\u0141", "\1\u0142",
			"\1\u0143", "", "", "", "", "\1\u0144", "\1\u0145", "\1\u0146",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u0148",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u014a", "\1\u014b", "\1\u014c", "\1\u014d",
			"\1\u014e", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0150", "\1\u0151", "\1\u0152",
			"\1\u0153", "\1\u0154", "\1\u0155", "\1\u0156", "\1\u0157", "\1\u0158", "\1\u0159", "\1\u015a", "\1\u015b",
			"\1\u015c", "\1\u015e\3\uffff\1\u015d", "\1\u015f", "\1\u0160", "\1\u0161",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0163",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0165",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0167", "\1\u0168\3\uffff\1\u0169", "\1\u016a",
			"\1\u016b", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u016d", "\1\u016e", "\1\u016f",
			"\1\u0170", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0172", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0174", "\1\u0175", "", "", "\1\u0176",
			"\1\u0177", "\1\u0178", "\1\u0179", "\1\u017a", "\1\u017b", "\1\u017c", "\1\u017d", "\1\u017e", "\1\u017f",
			"\1\u0180", "\1\u0181", "\1\u0182", "\1\u0183", "\1\u0184", "\1\u0186\7\uffff\1\u0185", "\1\u0187",
			"\1\u0188", "\1\u0189", "", "\1\u018a", "\1\u018b", "\1\u018c", "\1\u018d", "\1\u018e", "\1\u018f",
			"\1\u0190", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0192", "\1\u0193", "\1\u0194",
			"\1\u0195", "\1\u0196", "\1\u0197", "\1\u0199\15\uffff\1\u0198", "\1\u019a", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u019d", "\1\u019e", "\1\u019f",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u01a1", "\1\u01a2", "\1\u01a3", "\1\u01a4",
			"\1\u01a5", "\1\u01a6", "\1\u01a7", "\1\u01a8", "\1\u01a9", "\1\u01aa", "\1\u01ab", "\1\u01ac", "\1\u01ad",
			"\1\u01ae", "\1\u01af", "\1\u01b0", "\1\u01b1", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u01b4", "", "\1\u01b5",
			"\1\u01b7\16\uffff\1\u01b6", "\1\u01b8", "\1\u01b9\16\uffff\1\u01ba", "\1\u01bb", "", "\1\u01bc",
			"\1\u01bd", "\1\u01be\16\uffff\1\u01bf", "\1\u01c0", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u01c2", "\1\u01c3", "\1\u01c4", "\1\u01c5",
			"\1\u01c6", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u01c9\3\uffff\1\u01ca", "\1\u01cb", "\1\u01cc",
			"\1\u01cd", "\1\u01ce", "\1\u01cf", "\1\u01d0", "\1\u01d1", "\1\u01d2", "\1\u01d3", "\1\u01d4", "\1\u01d5",
			"\1\u01d6", "\1\u01d7", "\1\u01d8", "\1\u01d9", "\1\u01da", "\1\u01db", "\1\u01dc", "\1\u01dd", "\1\u01de",
			"\1\u01df", "", "\1\u01e0", "\1\u01e1", "\1\u01e2", "\1\u01e3",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u01e5", "\1\u01e6", "\1\u01e7", "\1\u01e8", "",
			"", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u01ea", "\1\u01eb", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u01ed", "\1\u01ee", "\1\u01ef",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u01f1", "\1\u01f2", "\1\u01f3", "\1\u01f4",
			"\1\u01f5", "\1\u01f6", "\1\u01f7", "\1\u01f8", "\1\u01f9", "\1\u01fa", "\1\u01fb", "\1\u01fc", "", "",
			"\1\u01fd", "\1\u01ff\1\uffff\1\u01fe", "\1\u0200", "\1\u0201", "\1\u0202", "\1\u0203", "\1\u0204",
			"\1\u0205", "\1\u0206", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0208", "\1\u0209",
			"\1\u020a", "", "\1\u020b", "\1\u020c", "\1\u020d", "\1\u020e", "\1\u020f", "", "", "\1\u0210", "\1\u0211",
			"\1\u0212", "\1\u0213", "\1\u0214", "\1\u0215", "\1\u0216",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0218", "\1\u0219\16\uffff\1\u021a", "\1\u021b",
			"\1\u021c", "\1\u021d", "\1\u021e", "\1\u021f", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\1\u0221", "\12\104\7\uffff\10\104\1\u0222\21\104\4\uffff\1\104\1\uffff\32\104", "\1\u0224", "\1\u0225",
			"\1\u0226", "\1\u0227", "\1\u0228", "\1\u0229", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\1\u022b", "\1\u022c", "", "\1\u022d", "\1\u022e", "\1\u022f",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u0231",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u0233", "\1\u0234",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u0236", "\1\u0237", "\1\u0238", "\1\u0239",
			"\1\u023a", "\1\u023b", "\1\u023c", "\1\u023d", "\1\u023e\16\uffff\1\u023f",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0241", "\1\u0242", "\1\u0243", "\1\u0244",
			"\1\u0245", "\1\u0246", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0248", "\1\u0249",
			"\1\u024a", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u024c", "", "\1\u024d", "\1\u024e",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0250", "\1\u0251",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0253",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0256", "\1\u0257", "\1\u0258", "\1\u0259",
			"\1\u025a", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u025f", "\1\u0260", "\1\u0261", "\1\u0262",
			"\1\u0264\3\uffff\1\u0263", "", "\1\u0265", "\1\u0266", "", "\1\u0267", "\1\u0268",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u026b", "\1\u026c", "",
			"\1\u026d\17\uffff\1\u026e", "\1\u026f", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0271",
			"\1\u0272", "", "\1\u0273", "", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u0276", "\1\u0277", "\1\u0278", "\1\u0279",
			"\1\u027a", "\12\104\7\uffff\1\u027b\31\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u0281",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0283", "\1\u0284", "\1\u0285", "\1\u0286", "",
			"\1\u0287", "\1\u0288", "\1\u0289", "", "\1\u028a", "\1\u028b", "\1\u028c", "", "\1\u028d",
			"\1\u028f\3\uffff\1\u028e", "", "\1\u0290", "", "", "\1\u0291",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0293", "\1\u0294", "\1\u0295", "", "", "", "",
			"\1\u0296", "\1\u0297", "\1\u0298", "\1\u0299", "\1\u029a", "\1\u029b", "\1\u029c", "\1\u029d", "\1\u029e",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "", "\1\u02a0", "\1\u02a1", "\1\u02a2",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02a4", "", "\1\u02a5", "\1\u02a6",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02a9", "\1\u02aa", "\1\u02ab", "\1\u02ac",
			"\1\u02ad", "", "", "", "", "",
			"\12\104\7\uffff\4\104\1\u02ae\6\104\1\u02af\16\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u02b1",
			"\1\u02b2", "\1\u02b3", "\1\u02b4", "\1\u02b5", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02b8",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02bb", "\1\u02bc", "\1\u02bd", "\1\u02be",
			"\1\u02bf", "", "\1\u02c0", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02c2", "\1\u02c3",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02c5", "\1\u02c6", "\1\u02c7",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\22\104\1\u02c9\7\104", "\1\u02cb", "\1\u02cc", "", "\1\u02cd",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02cf", "", "\1\u02d0", "\1\u02d1", "\1\u02d2",
			"", "", "\1\u02d3", "\1\u02d4", "", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02d6",
			"\1\u02d7", "\1\u02d8", "", "\1\u02d9", "\1\u02da", "\1\u02db",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02dd", "", "", "\1\u02de", "", "", "\1\u02df",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02e1",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02e3",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02e6", "", "\1\u02e7",
			"\1\u02e9\1\uffff\1\u02e8", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "",
			"\12\104\7\uffff\13\104\1\u02eb\16\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u02ed", "\1\u02ee",
			"\1\u02ef", "", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02f1", "\1\u02f2", "\1\u02f3",
			"\1\u02f4", "\1\u02f5", "", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u02f7", "\1\u02f8",
			"\1\u02f9", "\1\u02fa", "\1\u02fb", "", "\1\u02fc", "\1\u02fd", "\1\u02fe", "", "\1\u02ff", "", "\1\u0300",
			"", "", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0303", "\1\u0304", "", "\1\u0305", "",
			"\1\u0306", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0308", "", "\1\u0309", "\1\u030a",
			"\1\u030b", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u030e", "\1\u030f", "\1\u0310", "\1\u0311",
			"\1\u0312", "\1\u0313", "\1\u0314", "\1\u0315", "\1\u0316", "\1\u0317", "", "", "\1\u0318", "\1\u0319",
			"\1\u031a", "\1\u031b", "", "\1\u031c", "\1\u031d",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\22\104\1\u031e\7\104", "\1\u0320", "", "", "\1\u0321",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0324", "\1\u0325", "\1\u0326",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0328",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u032a", "\1\u032b", "\1\u032c", "\1\u032d",
			"\1\u032e", "\1\u032f", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\22\104\1\u0330\7\104", "\1\u0332", "",
			"\1\u0333", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0336", "\1\u0337", "", "\1\u0338", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\22\104\1\u0339\7\104", "\1\u033b", "\1\u033c", "\1\u033d",
			"\1\u033e", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0340", "", "\1\u0341",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "", "\1\u0343",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0345", "\1\u0346", "", "\1\u0347",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0349", "\1\u034a", "", "\1\u034b", "\1\u034c",
			"", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u034f", "\1\u0350", "", "\1\u0351",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "\1\u0353", "\1\u0354", "", "", "\1\u0355",
			"\1\u0356", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u0358", "\1\u0359", "\1\u035a",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "\1\u035c", "\1\u035d", "\1\u035e", "",
			"\1\u035f", "\1\u0360", "\1\u0361", "\1\u0362", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
			"\1\u0364", "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "",
			"\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104", "", "" };

	static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
	static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
	static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
	static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
	static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
	static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
	static final short[][] DFA20_transition;

	static {
		int numStates = DFA20_transitionS.length;
		DFA20_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
		}
	}

	static class DFA20 extends DFA {

		public DFA20(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 20;
			this.eot = DFA20_eot;
			this.eof = DFA20_eof;
			this.min = DFA20_min;
			this.max = DFA20_max;
			this.accept = DFA20_accept;
			this.special = DFA20_special;
			this.transition = DFA20_transition;
		}

		public String getDescription() {
			return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 | T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 | T__157 | T__158 | RULE_RAW_STRING | RULE_JAVADOC_COMMENT | RULE_ML_COMMENT | RULE_ML_COMMENT_NL | RULE_SL_COMMENT | RULE_NL | RULE_BEGIN | RULE_END | RULE_WS | RULE_RICH_TEXT | RULE_ID | RULE_INT | RULE_STRING | RULE_ANY_OTHER );";
		}

		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA20_65 = input.LA(1);

				s = -1;
				if (((LA20_65 >= '\u0000' && LA20_65 <= '\uFFFF'))) {
					s = 135;
				}

				else
					s = 66;

				if (s >= 0)
					return s;
				break;
			case 1:
				int LA20_31 = input.LA(1);

				s = -1;
				if ((LA20_31 == '\'')) {
					s = 133;
				}

				else if (((LA20_31 >= '\u0000' && LA20_31 <= '&') || (LA20_31 >= '(' && LA20_31 <= '\uFFFF'))) {
					s = 135;
				}

				else
					s = 134;

				if (s >= 0)
					return s;
				break;
			case 2:
				int LA20_0 = input.LA(1);

				s = -1;
				if ((LA20_0 == 'n')) {
					s = 1;
				}

				else if ((LA20_0 == 'r')) {
					s = 2;
				}

				else if ((LA20_0 == 'w')) {
					s = 3;
				}

				else if ((LA20_0 == 't')) {
					s = 4;
				}

				else if ((LA20_0 == 'e')) {
					s = 5;
				}

				else if ((LA20_0 == 'i')) {
					s = 6;
				}

				else if ((LA20_0 == 'f')) {
					s = 7;
				}

				else if ((LA20_0 == 'a')) {
					s = 8;
				}

				else if ((LA20_0 == 'v')) {
					s = 9;
				}

				else if ((LA20_0 == 'b')) {
					s = 10;
				}

				else if ((LA20_0 == 's')) {
					s = 11;
				}

				else if ((LA20_0 == 'd')) {
					s = 12;
				}

				else if ((LA20_0 == 'c')) {
					s = 13;
				}

				else if ((LA20_0 == 'U')) {
					s = 14;
				}

				else if ((LA20_0 == 'm')) {
					s = 15;
				}

				else if ((LA20_0 == ',')) {
					s = 16;
				}

				else if ((LA20_0 == 'o')) {
					s = 17;
				}

				else if ((LA20_0 == 'p')) {
					s = 18;
				}

				else if ((LA20_0 == '/')) {
					s = 19;
				}

				else if ((LA20_0 == '{')) {
					s = 20;
				}

				else if ((LA20_0 == '}')) {
					s = 21;
				}

				else if ((LA20_0 == '@')) {
					s = 22;
				}

				else if ((LA20_0 == '-')) {
					s = 23;
				}

				else if ((LA20_0 == '.')) {
					s = 24;
				}

				else if ((LA20_0 == '_')) {
					s = 25;
				}

				else if ((LA20_0 == '~')) {
					s = 26;
				}

				else if ((LA20_0 == '%')) {
					s = 27;
				}

				else if ((LA20_0 == '!')) {
					s = 28;
				}

				else if ((LA20_0 == '$')) {
					s = 29;
				}

				else if ((LA20_0 == '&')) {
					s = 30;
				}

				else if ((LA20_0 == '\'')) {
					s = 31;
				}

				else if ((LA20_0 == '(')) {
					s = 32;
				}

				else if ((LA20_0 == ')')) {
					s = 33;
				}

				else if ((LA20_0 == '*')) {
					s = 34;
				}

				else if ((LA20_0 == '+')) {
					s = 35;
				}

				else if ((LA20_0 == ';')) {
					s = 36;
				}

				else if ((LA20_0 == '=')) {
					s = 37;
				}

				else if ((LA20_0 == 'l')) {
					s = 38;
				}

				else if ((LA20_0 == '>')) {
					s = 39;
				}

				else if ((LA20_0 == ':')) {
					s = 40;
				}

				else if ((LA20_0 == 'k')) {
					s = 41;
				}

				else if ((LA20_0 == 'u')) {
					s = 42;
				}

				else if ((LA20_0 == '?')) {
					s = 43;
				}

				else if ((LA20_0 == '[')) {
					s = 44;
				}

				else if ((LA20_0 == ']')) {
					s = 45;
				}

				else if ((LA20_0 == 'P')) {
					s = 46;
				}

				else if ((LA20_0 == 'D')) {
					s = 47;
				}

				else if ((LA20_0 == 'H')) {
					s = 48;
				}

				else if ((LA20_0 == 'G')) {
					s = 49;
				}

				else if ((LA20_0 == 'T')) {
					s = 50;
				}

				else if ((LA20_0 == 'C')) {
					s = 51;
				}

				else if ((LA20_0 == 'O')) {
					s = 52;
				}

				else if ((LA20_0 == 'h')) {
					s = 53;
				}

				else if ((LA20_0 == 'q')) {
					s = 54;
				}

				else if ((LA20_0 == 'I')) {
					s = 55;
				}

				else if ((LA20_0 == 'A')) {
					s = 56;
				}

				else if ((LA20_0 == '\r')) {
					s = 57;
				}

				else if ((LA20_0 == '\n')) {
					s = 58;
				}

				else if ((LA20_0 == '\u250C')) {
					s = 59;
				}

				else if ((LA20_0 == '\u2510')) {
					s = 60;
				}

				else if ((LA20_0 == '\t' || LA20_0 == ' ')) {
					s = 61;
				}

				else if ((LA20_0 == '^')) {
					s = 62;
				}

				else if ((LA20_0 == 'B' || (LA20_0 >= 'E' && LA20_0 <= 'F') || (LA20_0 >= 'J' && LA20_0 <= 'N')
						|| (LA20_0 >= 'Q' && LA20_0 <= 'S') || (LA20_0 >= 'V' && LA20_0 <= 'Z') || LA20_0 == 'g'
						|| LA20_0 == 'j' || (LA20_0 >= 'x' && LA20_0 <= 'z'))) {
					s = 63;
				}

				else if (((LA20_0 >= '0' && LA20_0 <= '9'))) {
					s = 64;
				}

				else if ((LA20_0 == '\"')) {
					s = 65;
				}

				else if (((LA20_0 >= '\u0000' && LA20_0 <= '\b') || (LA20_0 >= '\u000B' && LA20_0 <= '\f')
						|| (LA20_0 >= '\u000E' && LA20_0 <= '\u001F') || LA20_0 == '#' || LA20_0 == '<'
						|| LA20_0 == '\\' || LA20_0 == '`' || LA20_0 == '|'
						|| (LA20_0 >= '\u007F' && LA20_0 <= '\u250B') || (LA20_0 >= '\u250D' && LA20_0 <= '\u250F')
						|| (LA20_0 >= '\u2511' && LA20_0 <= '\uFFFF'))) {
					s = 66;
				}

				if (s >= 0)
					return s;
				break;
			}
			NoViableAltException nvae = new NoViableAltException(getDescription(), 20, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}