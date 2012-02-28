package com.mostlymagic.lesscss.grammar.less.mixin;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
@EqualsAndHashCode(callSuper = true)
public class LessSimpleMixinReference extends LessMixinReference{

    public LessSimpleMixinReference(final String name){
        super(name);
    }

    @Override
    protected LessVisitorStatus dispatchVisitor(final LessVisitor visitor,
        final Context context){
        return visitor.visit(this, context);
    }

}
