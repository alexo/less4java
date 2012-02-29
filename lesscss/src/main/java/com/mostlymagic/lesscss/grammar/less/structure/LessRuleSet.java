package com.mostlymagic.lesscss.grammar.less.structure;

import java.util.List;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.mixin.LessMixinReference;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
public class LessRuleSet implements LessNode{

	private final LessRuleSet parent;
	private final List<LessDeclaration> declarations;
	private final List<LessRuleSet> children;
	private final List<LessMixinReference> mixinReferences;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if (status == LessVisitorStatus.DESCEND) {
			for (final LessDeclaration declaration : declarations) {
				if (declaration.accept(visitor, context) == LessVisitorStatus.BREAK)
					return LessVisitorStatus.BREAK;
			}
			for (final LessRuleSet child : children) {
				if (child.accept(visitor, context) == LessVisitorStatus.BREAK)
					return LessVisitorStatus.BREAK;
			}
		}
		return status;
	}
}
