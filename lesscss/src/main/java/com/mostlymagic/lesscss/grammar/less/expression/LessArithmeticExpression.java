package com.mostlymagic.lesscss.grammar.less.expression;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.google.common.base.Objects;
import com.mostlymagic.lesscss.grammar.less.operator.LessArithmeticOperator;
import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create") @EqualsAndHashCode(callSuper=true)
public class LessArithmeticExpression extends LessSingleExpression {

	private final LessSingleExpression left;
	private final LessSingleExpression right;
	private final LessArithmeticOperator operator;

	@Override
	protected LessVisitorStatus dispatchVisitor(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		return status;
	}
	@Override
	public LessNumericExpression asNumericExpression(final Context context) {
		final LessNumericExpression numericLeft = left.asNumericExpression(context);
		final LessNumericExpression numericRight = right.asNumericExpression(context);

		final BigDecimal value=operator.apply(numericLeft.getValue(),numericRight.getValue());
		final LessNumericUnit unit=Objects.firstNonNull(numericLeft.getUnit(), numericRight.getUnit());
		return LessNumericExpression.create(value, unit);
	}

}
