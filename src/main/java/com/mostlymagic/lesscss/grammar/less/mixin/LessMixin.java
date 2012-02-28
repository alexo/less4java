package com.mostlymagic.lesscss.grammar.less.mixin;

import java.util.List;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.structure.LessDeclaration;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
public class LessMixin implements LessNode {

    private final String name;
	private final List<LessDeclaration> declarations;
	private final LessMixinParameterBlock parameterBlock;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if (status == LessVisitorStatus.DESCEND) {
			if (parameterBlock != null && parameterBlock.accept(visitor, context) == LessVisitorStatus.BREAK)
				return LessVisitorStatus.BREAK;
			for (final LessDeclaration declaration : declarations) {
				if (declaration.accept(visitor, context) == LessVisitorStatus.BREAK)
					return LessVisitorStatus.BREAK;
			}
		}
		return status;
	}
}
