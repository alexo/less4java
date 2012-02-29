package com.mostlymagic.lesscss.grammar.less.expression;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.mostlymagic.lesscss.grammar.less.operator.LessArithmeticOperator;
import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;

public class LessArithmeticExpressionTest {

	@Test
	public void testNumericValue() {
		final LessNumericExpression left = LessNumericExpression.create(BigDecimal.valueOf(10), LessNumericUnit.PX);
		final LessNumericExpression right = LessNumericExpression.create(BigDecimal.valueOf(5), LessNumericUnit.PX);
		final Context ctx = Context.create();
		final LessArithmeticExpression plusExp = LessArithmeticExpression.create(left, right, LessArithmeticOperator.PLUS);
		final LessArithmeticExpression minusExp = LessArithmeticExpression.create(left, right, LessArithmeticOperator.MINUS);
		final LessArithmeticExpression multiExp = LessArithmeticExpression.create(left, right, LessArithmeticOperator.MULTI);
		final LessArithmeticExpression divExp = LessArithmeticExpression.create(left, right, LessArithmeticOperator.DIV);
		assertEquals(
				plusExp.asNumericExpression(ctx), LessNumericExpression.create(BigDecimal.valueOf(15), LessNumericUnit.PX));
		assertEquals(
				minusExp.asNumericExpression(ctx), LessNumericExpression.create(BigDecimal.valueOf(5), LessNumericUnit.PX));
		assertEquals(
				multiExp.asNumericExpression(ctx), LessNumericExpression.create(BigDecimal.valueOf(50), LessNumericUnit.PX));
		assertEquals(
				divExp.asNumericExpression(ctx), LessNumericExpression.create(BigDecimal.valueOf(2), LessNumericUnit.PX));
		assertEquals(LessArithmeticExpression.create(plusExp, minusExp, LessArithmeticOperator.MULTI).asNumericExpression(ctx),
				LessNumericExpression.create(BigDecimal.valueOf(75), LessNumericUnit.PX));
	}

}
