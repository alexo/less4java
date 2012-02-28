package com.mostlymagic.lesscss.grammar.less.mixin;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.expression.LessExpression;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
public class LessMixinVariable implements LessNode{

	private final String name;
	private final LessExpression defaultValue;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if(status==LessVisitorStatus.DESCEND){
			if (defaultValue!=null && defaultValue.accept(visitor, context)==LessVisitorStatus.BREAK)
				return LessVisitorStatus.BREAK;
		}
		return status;
	}

}
