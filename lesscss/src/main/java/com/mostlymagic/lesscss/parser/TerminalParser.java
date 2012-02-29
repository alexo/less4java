/*****************************************************************************
 * Copyright (C) Codehaus.org                                                *
 * ------------------------------------------------------------------------- *
 * Licensed under the Apache License, Version 2.0 (the "License");           *
 * you may not use this file except in compliance with the License.          *
 * You may obtain a copy of the License at                                   *
 *                                                                           *
 * http://www.apache.org/licenses/LICENSE-2.0                                *
 *                                                                           *
 * Unless required by applicable law or agreed to in writing, software       *
 * distributed under the License is distributed on an "AS IS" BASIS,         *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
 * See the License for the specific language governing permissions and       *
 * limitations under the License.                                            *
 *****************************************************************************/
package com.mostlymagic.lesscss.parser;

import static org.codehaus.jparsec.misc.Mapper._;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.Token;
import org.codehaus.jparsec.functors.Map;

/**
 * Parser for terminals.
 * 
 * @author Ben Yu
 */
public final class TerminalParser {
  /**
   * {@literal <<}, {@literal >>} and {@literal >>>} are handled by {@link #adjacent(String)},
   * to avoid ambiguity with generics syntax.
   */
  private static final String[] OPERATORS = {
    "+", "-", "*", "/", "%", "&", "|", "~", "^",
    ">", "<", "==", ">=", "<=", "!=", "&&", "||", "!",
    ".", ",",  "?", ":", ";", "...", "@",
    "=", "+=", "-=", "*=", "/=", "%=", "^=", "&=", "|=", "<<=", ">>=", ">>>=", "++", "--",
    "(", ")", "[", "]", "{", "}",
  };
  
  private static final String[] KEYWORDS = {
    "private", "protected", "public", "final", "abstract", "native", "static",
    "transient", "volatile", "throws", "class", "interface", "enum", "package", "import",
    "if", "else", "for", "while", "do", "continue", "break", "return",
    "switch", "case", "default", "throw", "try", "catch", "finally",
    "new", "this", "super", "synchronized", "instanceof", "extends", "implements", "assert",
    "byte", "short", "int", "long", "char", "float", "double", "boolean", "char", "void",
    "true", "false", "null",
    "goto", "const", "strictfp",
  };
  
  private static final Terminals TERMS =
      Terminals.caseSensitive(LessLexer.VARIABLE, OPERATORS, KEYWORDS);
  
  // hex, oct, int, decimal, scientific, string literal, char literal and the other terms.
  // Let's not worry about unicode escape in char and string literals for now.
  // They are no fun to write and this is just a demo.
  static final Parser<?> TOKENIZER = Parsers.or(
      LessLexer.SCIENTIFIC_NUMBER_LITERAL,
      Terminals.StringLiteral.DOUBLE_QUOTE_TOKENIZER,
      Terminals.CharLiteral.SINGLE_QUOTE_TOKENIZER,
      TERMS.tokenizer(), LessLexer.DECIMAL_POINT_NUMBER, LessLexer.INTEGER);
  
  /**
   * A {@link Parser} that succeeds only if the {@link Token} objects in the {@link List} are
   * adjacent.
   */
  public static Parser<Token> adjacent(Parser<List<Token>> parser, final String name) {
    return parser.next(new Map<List<Token>, Parser<Object>>() {
      public Parser<Object> map(List<Token> tokens) {
        if (tokens.isEmpty()) return Parsers.always();
        int offset = tokens.get(0).index();
        for (Token token : tokens) {
          if (token.index() != offset) {
            return Parsers.expect(name);
          }
          offset += token.length();
        }
        return Parsers.always();
      }
    }).atomic().source().token();
  }
  
  /**
   * A {@link Parser} that parses all adjacent characters in {@code operator} as individual
   * {@link Token} and only succeeds if these tokens are adjacent. A {@code Token} representing
   * the entire {@code operator} is returned.
   */
  public static Parser<Token> adjacent(String operator) {
    List<Parser<Token>> parsers = new ArrayList<Parser<Token>>(operator.length());
    for (int i = 0; i < operator.length(); i++) {
      parsers.add(TERMS.token(Character.toString(operator.charAt(i))));
    }
    return adjacent(Parsers.list(parsers), operator);
  }
  
  public static Parser<?> term(String name) {
    if (name.equals(">>")) {
      // manually do the exclusion so that ">>>" never gets interpreted partially as ">>",
      // even if it can be interpreted as ">" followed by ">>" or three ">"s.
      return adjacent(">>>").not().next(adjacent(">>"));
    }
    if (name.equals("<<") || name.equals(">>>")) {
      return adjacent(name);
    }
    return _(TERMS.token(name));
  }
  
  static Parser<?> oneOf(String... names) {
    return _(TERMS.token(names));
  }
  
  static <T> T parse(Parser<T> parser, String source) {
    return parser.from(TOKENIZER, Scanners.JAVA_DELIMITER).parse(source);
  }
  
  static <T> T parse(Parser<T> parser, Readable readable, String module) throws IOException {
    return parser.from(TOKENIZER, Scanners.JAVA_DELIMITER).parse(readable, module);
  }
  
  public static Parser<?> phrase(String phrase) {
    return _(TERMS.phrase(phrase.split("\\s+")));
  }
}
