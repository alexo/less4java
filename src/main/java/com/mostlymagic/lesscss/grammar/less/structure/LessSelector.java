package com.mostlymagic.lesscss.grammar.less.structure;

import lombok.Data;

import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessNode;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data(staticConstructor="create")
public class LessSelector implements LessNode{

	private final String name;

	@Override
	public LessVisitorStatus accept(final LessVisitor visitor, final Context context) {
		return visitor.visit(this, context);
	}

}
