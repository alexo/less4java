package com.mostlymagic.lesscss.grammar.less.operator;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

public enum LessUnaryOperator implements LessNode{

    PLUS, MINUS, NONE;

    @Override
    public LessVisitorStatus accept(final LessVisitor visitor,
        final Context context){
        return visitor.visit(this, context);
    }

}
