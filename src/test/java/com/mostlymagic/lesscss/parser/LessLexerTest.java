package com.mostlymagic.lesscss.parser;

import static com.mostlymagic.lesscss.parser.LessLexer.NUMERIC_UNIT;
import static com.mostlymagic.lesscss.parser.LessLexer.NUMERIC_VALUE;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;

public class LessLexerTest{

    @Test
    public void testBigDecimalValue(){
        assertEquals(NUMERIC_VALUE.parse("3.1234"), new BigDecimal("3.1234"));
    }

    @Test
    public void testNumericUnit(){
        for(final LessNumericUnit unit : LessNumericUnit.values()){
            final String literal = unit.literal();
            if(literal != null){
                assertEquals(NUMERIC_UNIT.parse(literal), unit);
            }
        }
    }

}
