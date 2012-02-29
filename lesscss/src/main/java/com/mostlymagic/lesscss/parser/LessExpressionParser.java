package com.mostlymagic.lesscss.parser;

import java.math.BigDecimal;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.functors.Map2;

import com.mostlymagic.lesscss.grammar.less.expression.LessNumericExpression;
import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;

public class LessExpressionParser{

    static Parser<LessNumericExpression> NUMERIC_EXPRESSION =

    Parsers.sequence(LessLexer.NUMERIC_VALUE,
        LessLexer.NUMERIC_UNIT,
        new Map2<BigDecimal, LessNumericUnit, LessNumericExpression>(){

            @Override
            public LessNumericExpression map(final BigDecimal a,
                final LessNumericUnit d){
                return LessNumericExpression.create(a, d);
            }
        });

}
