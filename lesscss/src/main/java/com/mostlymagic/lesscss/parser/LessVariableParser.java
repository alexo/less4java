package com.mostlymagic.lesscss.parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.functors.Map;

import com.mostlymagic.lesscss.grammar.less.variable.LessVariableName;

public class LessVariableParser{

    static final Parser<LessVariableName> VARIABLENAME =
        LessLexer.VARIABLE_NAME.map(new Map<String, LessVariableName>(){

            @Override
            public LessVariableName map(final String str){
                return new LessVariableName(str.substring(1));
            }
        });

}
