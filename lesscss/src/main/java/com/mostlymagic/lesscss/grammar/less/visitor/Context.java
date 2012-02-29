package com.mostlymagic.lesscss.grammar.less.visitor;

import java.util.Map;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import com.google.common.collect.Maps;
import com.mostlymagic.lesscss.grammar.less.mixin.LessMixin;
import com.mostlymagic.lesscss.grammar.less.mixin.LessMixinReference;

@Data(staticConstructor="create")
public class Context{

    @Getter(value = AccessLevel.PRIVATE) 
    private final Map<String, LessMixin> mixins = Maps.newHashMap();

    public void register(final LessMixin mixin){
        mixins.put(mixin.getName(), mixin);
    }
    
    public LessMixin evaluate(final LessMixinReference reference){
        return mixins.get(reference.getName());
    }

}
