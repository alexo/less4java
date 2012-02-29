package com.mostlymagic.lesscss.grammar.less.mixin;

import java.util.List;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
public class LessMixinParameterBlock implements LessNode {

	private final List<LessMixinVariable> variableDeclarations;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if(status==LessVisitorStatus.DESCEND) {
			for (final LessMixinVariable variable : variableDeclarations) {
				if (variable.accept(visitor, context) == LessVisitorStatus.BREAK)
					return LessVisitorStatus.BREAK;
			}
		}
		return status;
	}

}
