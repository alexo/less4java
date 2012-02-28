package com.mostlymagic.lesscss.grammar.less.variable;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data
public class LessVariableName implements LessNode{

    private final String name;

    @Override
    public LessVisitorStatus accept(final LessVisitor visitor, final Context context){
        return visitor.visit(this, context);
    }

}
