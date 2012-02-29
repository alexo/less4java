package com.mostlymagic.lesscss.parser;

import static com.mostlymagic.lesscss.parser.LessVariableParser.VARIABLENAME;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mostlymagic.lesscss.grammar.less.variable.LessVariableName;

public class LessVariableParserTest{

    @Test
    public void testVariableNameParser(){
        assertEquals(VARIABLENAME.parse("@someVar"),
            new LessVariableName("someVar"));
    }
}
