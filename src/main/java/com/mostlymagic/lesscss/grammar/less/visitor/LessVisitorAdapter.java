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

/**
 * Default adapter for {@link LessVisitor}. Does nothing and returns
 * {@link LessVisitorStatus#DESCEND} in every method call.
 * 
 * @author Sean P. Floyd
 */
public class LessVisitorAdapter implements LessVisitor{

    /**
     * Must subclass to use.
     */
    protected LessVisitorAdapter(){
    }

    @Override
    public LessVisitorStatus visit(final LessStyleSheet styleSheet,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessRuleSet ruleSet,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessDeclaration declaration,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessSelector selector,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessMultiExpression expression,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessPriority priority,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessNumericExpression expression,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessUnaryOperator operator,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessNumericUnit unit,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessColorExpression expression,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessVariableReferenceExpression expression,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessSimpleMixinReference reference,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessParameterizedMixinReference reference,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessMixin mixin, final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessMixinVariableReferenceExpression expression,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessMixinVariable variable,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessMixinParameterBlock parameterBlock,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessArithmeticExpression expression,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessArithmeticOperator arithmeticOperator,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessVariable lessVariable,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessExpression expression,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }

    @Override
    public LessVisitorStatus visit(final LessVariableName variableName,
        final Context context){
        return LessVisitorStatus.DESCEND;
    }
}
