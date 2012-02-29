package com.mostlymagic.lesscss.grammar.less.mixin;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.mostlymagic.lesscss.grammar.less.expression.LessExpression;
import com.mostlymagic.lesscss.grammar.less.visitor.Context;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitor;
import com.mostlymagic.lesscss.grammar.less.visitor.LessVisitorStatus;

@Data @EqualsAndHashCode(callSuper=true)
public class LessParameterizedMixinReference extends LessMixinReference {

	private LessParameterizedMixinReference(final String name, final LessExpression parameters){
		super(name);
		this.parameters = parameters;
	}

	public static LessParameterizedMixinReference create(final String name, final LessExpression parameters){
		return new LessParameterizedMixinReference(name, parameters);
	}

	private final LessExpression parameters; 

	@Override
	protected LessVisitorStatus dispatchVisitor(final LessVisitor visitor, final Context context) {
		final LessVisitorStatus status = visitor.visit(this, context);
		if(status==LessVisitorStatus.DESCEND){
			if(parameters.accept(visitor, context)==LessVisitorStatus.BREAK)return LessVisitorStatus.BREAK;
		}
		return status;
	}

}
