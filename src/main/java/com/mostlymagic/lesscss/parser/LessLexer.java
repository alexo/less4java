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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.functors.Map;
import org.codehaus.jparsec.pattern.CharPredicate;
import org.codehaus.jparsec.pattern.Patterns;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;

public final class LessLexer{

    static final String[] UNITS = Iterables.toArray(Iterables.filter(Iterables
        .transform(Arrays.asList(LessNumericUnit.values()),
            LessNumericUnit.literalFunction()), new Predicate<String>(){

        @Override
        public boolean apply(final String input){
            return input != null;
        }
    }), String.class);

    private static final Parser<String> NUMERIC_TOKENS = Terminals
        .operators(UNITS)
        .tokenizer()
        .source();

    private static final CharPredicate LESS_VARIABLE_START =
        new CharPredicate(){

            @Override
            public boolean isChar(final char c){
                return c == '@';
            }
        };

    private static final CharPredicate LESS_IDENTIFIER_PART =
        new CharPredicate(){

            @Override
            public boolean isChar(final char c){
                return Character.isJavaIdentifierPart(c);
            }
        };

    static final Parser<String> VARIABLE_NAME = Scanners.pattern(Patterns
        .isChar(LESS_VARIABLE_START)
        .next(Patterns.isChar(LESS_IDENTIFIER_PART).many()),
        "variable").source();

    static final Parser<Void> DECIMAL_POINT_SCANNER = Scanners
        .pattern(Patterns.INTEGER.optional().next(Patterns.FRACTION),
            "decimal number");

    static final Parser<String> NUMERIC_EXPRESSION = Scanners
        .pattern(Patterns.INTEGER.optional().next(Patterns.FRACTION),
            "decimal number")
        .source();

    static final Parser<BigDecimal> NUMERIC_VALUE = NUMERIC_EXPRESSION
        .map(new Map<String, BigDecimal>(){

            @Override
            public BigDecimal map(final String from){
                return new BigDecimal(from);
            }
        });

    private static Parser<LessNumericUnit> lessNumericUnit(final LessNumericUnit... LessNumericUnits){
        final List<Parser<LessNumericUnit>> list =
            new ArrayList<Parser<LessNumericUnit>>(LessNumericUnits.length);
        for(final LessNumericUnit unit : LessNumericUnits){
            final String literal = unit.literal();
            if(literal != null) list.add(

            NUMERIC_TOKENS.retn(unit));
        }
        return Parsers.or(list);
    }

    static final Parser<Void> IGNORED = Parsers.or(Scanners.JAVA_LINE_COMMENT,
        Scanners.JAVA_BLOCK_COMMENT,
        Scanners.WHITESPACES).skipMany();

    static final Parser<LessNumericUnit> NUMERIC_UNIT =
        lessNumericUnit(LessNumericUnit.values());

}
