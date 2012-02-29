package com.mostlymagic.lesscss.grammar.less.mixin;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data
public abstract class LessMixinReference implements LessNode {


	private final String name;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor, final Context context) {
		return dispatchVisitor(visitor, context);
	}

	protected abstract LessVisitorStatus dispatchVisitor(LessVisitor visitor, Context context);

}
