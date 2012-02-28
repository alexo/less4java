package com.mostlymagic.lesscss.grammar.less.expression;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;

@Data @EqualsAndHashCode(callSuper=true)
public abstract class LessSingleExpression extends LessExpression {

	public abstract LessNumericExpression asNumericExpression(Context context);


}
