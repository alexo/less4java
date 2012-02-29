package com.mostlymagic.lesscss.grammar.less.operator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.MessageFormat;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

public enum LessArithmeticOperator implements LessNode{
	PLUS('+') {

		@Override
		public BigDecimal apply(final BigDecimal left, final BigDecimal right){
			return left.add(right, CONTEXT);
		}
	},
	MINUS('-') {

		@Override
		public BigDecimal apply(final BigDecimal left, final BigDecimal right){

			return left.subtract(right, CONTEXT);
		}
	},
	MULTI('*') {

		@Override
		public BigDecimal apply(final BigDecimal left, final BigDecimal right){
			return left.multiply(right, CONTEXT);
		}

	},
	DIV('/') {

		@Override
		public BigDecimal apply(final BigDecimal left, final BigDecimal right){
			return left.divide(right, CONTEXT);
		}
	};

	private final char operator;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor,
			final Context context){
		return visitor.visit(this, context);
	}

	private LessArithmeticOperator(final char operator) {
		this.operator = operator;
	}

	public static LessArithmeticOperator forOperator(final char operator) {
		for (final LessArithmeticOperator candidate : values()) {
			if (candidate.operator == operator)
				return candidate;
		}
		throw new IllegalArgumentException(MessageFormat.format("Unknown operator: ''{0}''", operator));
	}

	public abstract BigDecimal apply(BigDecimal left, BigDecimal right);

	private static final MathContext CONTEXT = new MathContext(2, RoundingMode.HALF_EVEN);

}
