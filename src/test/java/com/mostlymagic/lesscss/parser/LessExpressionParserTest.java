package com.mostlymagic.lesscss.parser;

import static com.mostlymagic.lesscss.parser.LessExpressionParser.NUMERIC_EXPRESSION;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.mostlymagic.lesscss.grammar.less.expression.LessNumericExpression;
import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;

public class LessExpressionParserTest{

    @Test
    public void testNumericExpression(){
        assertEquals(NUMERIC_EXPRESSION.parse("1.234ex"),
            LessNumericExpression.create(new BigDecimal("1.234"),
                LessNumericUnit.EM));

    }

}
