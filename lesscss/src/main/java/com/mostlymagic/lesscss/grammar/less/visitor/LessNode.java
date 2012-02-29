package com.mostlymagic.lesscss.grammar.less.visitor;


public interface LessNode {
	LessVisitorStatus accept(LessVisitor visitor, Context context);
}
