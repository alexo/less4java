package com.mostlymagic.lesscss.grammar.less.unit;

import com.google.common.base.Function;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

public enum LessNumericUnit implements LessNode{

    PLAIN_NUMBER{

        @Override
        public String literal(){
            return null;
        }
    },
    EX, EM, PERCENT{

        @Override
        public String literal(){
            return "";
        }
    },
    CM, MM, INCH{

        @Override
        public String literal(){
            return "in";
        }
    },
    PT, PX, PC;

    @Override
    public LessVisitorStatus accept(final LessVisitor visitor,
        final Context context){
        return visitor.visit(this, context);
    }

    public String literal(){
        return name().toLowerCase();
    }

    private static final Function<LessNumericUnit, String> LITERAL_F =
        new Function<LessNumericUnit, String>(){

            @Override
            public String apply(final LessNumericUnit input){
                return input.literal();
            }
        };

    public static Function<LessNumericUnit, String> literalFunction(){
        return LITERAL_F;
    }

}
