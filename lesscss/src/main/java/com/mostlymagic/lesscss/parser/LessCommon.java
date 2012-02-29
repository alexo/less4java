package com.mostlymagic.lesscss.parser;

import java.math.BigDecimal;
import java.util.EnumSet;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.Tokens.Fragment;
import org.codehaus.jparsec.functors.Map;

import com.google.common.collect.Iterables;
import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;

public class LessCommon{

    static final String DIV = "/";

    static final String TIMES = "*";

    static final String MINUS = "-";

    static final String PLUS = "+";

    private static Parser<Void> IGNORED = Parsers
        .or(Scanners.JAVA_LINE_COMMENT,
            Scanners.JAVA_BLOCK_COMMENT,
            Scanners.WHITESPACES);

    static final Terminals ARITHMETIC_OPERATORS = Terminals.operators(PLUS,
        MINUS,
        TIMES,
        DIV);

    static final Parser<BigDecimal> BIGDECIMAL =
        Terminals.DecimalLiteral.TOKENIZER.map(new Map<Fragment, BigDecimal>(){

            @Override
            public BigDecimal map(final Fragment fragment){
                return new BigDecimal(fragment.text());
            }
        });

    static final Terminals STATEMENT_DELIMITER = Terminals.operators(";");

    static final Terminals VARIABLE = Terminals.operators("@");

    static final Parser<String> IDENTIFIER = Terminals.Identifier.PARSER;

    static final Terminals NUMERIC_UNITS = Terminals.operators(//
        Iterables.toArray(Iterables.transform(//
        EnumSet.allOf(LessNumericUnit.class),
            LessNumericUnit.literalFunction()), String.class));

}
