package org.apache.log4j;

import org.apache.log4j.helpers.CustomizedParser;
import org.apache.log4j.helpers.PatternParser;

public class CustomizedPatternLayout extends PatternLayout {
    @Override
    protected PatternParser createPatternParser(String pattern) {
        return new CustomizedParser(pattern);
    }
}
