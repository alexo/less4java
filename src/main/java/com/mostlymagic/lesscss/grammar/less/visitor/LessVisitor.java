package com.mostlymagic.lesscss.grammar.less.visitor;

import com.mostlymagic.lesscss.grammar.less.expression.LessArithmeticExpression;
import com.mostlymagic.lesscss.grammar.less.expression.LessColorExpression;
import com.mostlymagic.lesscss.grammar.less.expression.LessExpression;
import com.mostlymagic.lesscss.grammar.less.expression.LessMixinVariableReferenceExpression;
import com.mostlymagic.lesscss.grammar.less.expression.LessMultiExpression;
import com.mostlymagic.lesscss.grammar.less.expression.LessNumericExpression;
import com.mostlymagic.lesscss.grammar.less.expression.LessVariableReferenceExpression;
import com.mostlymagic.lesscss.grammar.less.mixin.LessMixin;
import com.mostlymagic.lesscss.grammar.less.mixin.LessMixinParameterBlock;
import com.mostlymagic.lesscss.grammar.less.mixin.LessMixinVariable;
import com.mostlymagic.lesscss.grammar.less.mixin.LessParameterizedMixinReference;
import com.mostlymagic.lesscss.grammar.less.mixin.LessSimpleMixinReference;
import com.mostlymagic.lesscss.grammar.less.operator.LessArithmeticOperator;
import com.mostlymagic.lesscss.grammar.less.operator.LessPriority;
import com.mostlymagic.lesscss.grammar.less.operator.LessUnaryOperator;
import com.mostlymagic.lesscss.grammar.less.structure.LessDeclaration;
import com.mostlymagic.lesscss.grammar.less.structure.LessRuleSet;
import com.mostlymagic.lesscss.grammar.less.structure.LessSelector;
import com.mostlymagic.lesscss.grammar.less.structure.LessStyleSheet;
import com.mostlymagic.lesscss.grammar.less.unit.LessNumericUnit;
import com.mostlymagic.lesscss.grammar.less.variable.LessVariable;
import com.mostlymagic.lesscss.grammar.less.variable.LessVariableName;

public interface LessVisitor{

    LessVisitorStatus visit(LessStyleSheet styleSheet, Context context);

    LessVisitorStatus visit(LessRuleSet ruleSet, Context context);

    LessVisitorStatus visit(LessDeclaration declaration, Context context);

    LessVisitorStatus visit(LessSelector selector, Context context);

    LessVisitorStatus visit(LessMultiExpression expression, Context context);

    LessVisitorStatus visit(LessPriority priority, Context context);

    LessVisitorStatus visit(LessUnaryOperator operator, Context context);

    LessVisitorStatus visit(LessNumericUnit unit, Context context);

    LessVisitorStatus visit(LessNumericExpression expression, Context context);

    LessVisitorStatus visit(LessColorExpression expression, Context context);

    LessVisitorStatus visit(LessVariableReferenceExpression expression,
        Context context);

    LessVisitorStatus visit(LessSimpleMixinReference reference, Context context);

    LessVisitorStatus visit(LessParameterizedMixinReference reference,
        Context context);

    LessVisitorStatus visit(LessMixin mixin, Context context);

    LessVisitorStatus visit(LessMixinVariableReferenceExpression expression,
        Context context);

    LessVisitorStatus visit(LessMixinVariable variable, Context context);

    LessVisitorStatus visit(LessMixinParameterBlock parameterBlock,
        Context context);

    LessVisitorStatus visit(LessArithmeticExpression expression, Context context);

    LessVisitorStatus visit(LessArithmeticOperator arithmeticOperator,
        Context context);

    LessVisitorStatus visit(LessVariable lessVariable, Context context);

    LessVisitorStatus visit(LessExpression expression, Context context);

    LessVisitorStatus visit(LessVariableName variableName, Context context);

}
