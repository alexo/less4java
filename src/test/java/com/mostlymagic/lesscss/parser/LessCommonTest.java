package com.mostlymagic.lesscss.parser;

import static com.mostlymagic.lesscss.parser.LessCommon.BIGDECIMAL;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class LessCommonTest{

    @Test
    public void testBigDecimal(){
        assertEquals(BIGDECIMAL.parse("3.4567"), new BigDecimal("3.4567"));
    }

}
