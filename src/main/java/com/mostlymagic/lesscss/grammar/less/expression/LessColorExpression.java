package com.mostlymagic.lesscss.grammar.less.expression;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.mostlymagic.lesscss.grammar.less.unit.LessRgb;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data @EqualsAndHashCode(callSuper=true)
public abstract class LessColorExpression extends LessSingleExpression {

	public abstract LessRgb getRgbValue();

	@Override
	protected LessVisitorStatus dispatchVisitor(final LessVisitor visitor, final Context context) {
		return visitor.visit(this, context);
	}


}
