package com.mostlymagic.lesscss.grammar.less.structure;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.expression.LessExpression;
import com.mostlymagic.lesscss.grammar.less.operator.LessPriority;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
public class LessDeclaration implements LessNode {

	private final String property;
	private final LessExpression expression;
	private final LessPriority priority;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if (status == LessVisitorStatus.DESCEND) {
			if (priority.accept(visitor, context) == LessVisitorStatus.BREAK)
				return LessVisitorStatus.BREAK;
			if (expression.accept(visitor, context) == LessVisitorStatus.BREAK)
				return LessVisitorStatus.BREAK;
		}
		return status;
	}

}
