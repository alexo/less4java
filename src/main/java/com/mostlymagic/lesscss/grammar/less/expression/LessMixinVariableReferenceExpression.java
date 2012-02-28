package com.mostlymagic.lesscss.grammar.less.expression;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create") @EqualsAndHashCode(callSuper=true)
public class LessMixinVariableReferenceExpression extends LessSingleExpression {

	private final String variableName;

	@Override
	protected LessVisitorStatus dispatchVisitor(final LessVisitor visitor, final Context context) {
		return visitor.visit(this, context);
	}
	@Override
	public LessNumericExpression asNumericExpression(final Context context) {
		// TODO how to handle this?
		return null;
	}

}
