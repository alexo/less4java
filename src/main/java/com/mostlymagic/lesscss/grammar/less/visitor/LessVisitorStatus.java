package com.mostlymagic.lesscss.grammar.less.visitor;

public enum LessVisitorStatus {

	/**
	 * Equivalent to the <code>continue</code> keyword: jump to next iteration. Do not descend into child elements.
	 */
	CONTINUE,

	/**
	 * Equivalent to the <code>break</code> keyword: break the loop. This will be propagated all the way up to the outermost method
	 * call, i.e. the visitor stops immediately, no matter where it is.
	 */
	BREAK,

	/**
	 * Keep going as usual.
	 */
	DESCEND;
}
