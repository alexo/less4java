package com.mostlymagic.lesscss.grammar.less.expression;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data
public abstract class LessExpression implements LessNode{

	@Override
	public final LessVisitorStatus accept(final LessVisitor visitor,
			final Context context){
		final LessVisitorStatus status = visitor.visit(this, context);
		if(status == LessVisitorStatus.DESCEND)
			if(dispatchVisitor(visitor, context) == LessVisitorStatus.BREAK)
				return LessVisitorStatus.BREAK;
		return status;
	}

	protected abstract LessVisitorStatus dispatchVisitor(LessVisitor visitor,
			Context context);

}
