package com.mostlymagic.lesscss.grammar.less.expression;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.mostlymagic.lesscss.grammar.less.operator.LessUnaryOperator;
import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create") @EqualsAndHashCode(callSuper=true)
public class LessNumericExpression extends LessSingleExpression {

	private LessUnaryOperator operator;
	private final BigDecimal value;
	private final LessNumericUnit unit;

	@Override
	protected LessVisitorStatus dispatchVisitor(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if(status==LessVisitorStatus.DESCEND){
			if(operator.accept(visitor, context)==LessVisitorStatus.BREAK)return LessVisitorStatus.BREAK;
			if(unit.accept(visitor, context)==LessVisitorStatus.BREAK)return LessVisitorStatus.BREAK;
		}
		return status;
	}
	@Override
	public LessNumericExpression asNumericExpression(final Context context) {
		return this;
	}

}
