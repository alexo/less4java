package com.mostlymagic.lesscss.grammar.less.variable;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.expression.LessExpression;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
public class LessVariable implements LessNode{

    private final LessVariableName name;
    private final LessExpression expression;
    
    @Override
    public LessVisitorStatus accept(final LessVisitor visitor, final Context context){
        final LessVisitorStatus status = visitor.visit(this, context);
        if(status==LessVisitorStatus.DESCEND)
            if(visitor.visit(expression, context)==LessVisitorStatus.BREAK)return LessVisitorStatus.BREAK;
        return status;
    }

}
