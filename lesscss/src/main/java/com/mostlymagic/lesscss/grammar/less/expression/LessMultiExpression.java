package com.mostlymagic.lesscss.grammar.less.expression;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create") @EqualsAndHashCode(callSuper=true)
public class LessMultiExpression extends LessExpression {

	private final List<LessSingleExpression> parts;

	@Override
	public LessVisitorStatus dispatchVisitor(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if(status==LessVisitorStatus.DESCEND){
			for (final LessSingleExpression expression : parts) {
				if(expression.accept(visitor, context)==LessVisitorStatus.BREAK)return LessVisitorStatus.BREAK;
			}
		}
		return status;
	}

}
