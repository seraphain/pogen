package com.github.seraphain.pogen.service.name;

import org.apache.commons.lang3.StringUtils;

public class ClassNameGenerator extends AbstractNameGenerator {

    @Override
    protected String generateInternal(String name) {
        String[] words = name.toLowerCase().split("_");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(StringUtils.capitalize(word));
        }
        return result.toString();
    }

}
