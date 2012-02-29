package com.mostlymagic.lesscss.grammar.less.structure;

import java.util.List;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.mixin.LessMixin;
import com.mostlymagic.lesscss.grammar.less.variable.LessVariable;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
public class LessStyleSheet implements LessNode{

	private final List<LessVariable> variables;
	private final List<LessMixin> mixins;
	private final List<LessRuleSet> ruleSets;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if (LessVisitorStatus.DESCEND.equals(status)) {
			for (final LessVariable variable : variables) {
				if (variable.accept(visitor, context) == LessVisitorStatus.BREAK)
					return LessVisitorStatus.BREAK;
			}
			for (final LessMixin mixin : mixins) {
				if (mixin.accept(visitor, context) == LessVisitorStatus.BREAK)
					return LessVisitorStatus.BREAK;
			}
			for (final LessRuleSet ruleSet : ruleSets) {
				if (ruleSet.accept(visitor, context) == LessVisitorStatus.BREAK)
					return LessVisitorStatus.BREAK;
			}
		}
		return status;
	}

}
