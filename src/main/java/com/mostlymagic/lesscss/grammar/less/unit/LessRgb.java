package com.mostlymagic.lesscss.grammar.less.unit;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data(staticConstructor="create") @RequiredArgsConstructor
public class LessRgb {

	private final Integer red;
	private final Integer green;
	private final Integer blue;
	private final String name;
	public LessRgb(final int red, final int green, final int blue) {
		this(red, green, blue, null);
	}

	public LessRgb(final String name){
		this(null,null,null,name);
	}





}
