package com.github.seraphain.pogen.service.name;

import org.apache.commons.lang3.StringUtils;

public class AttributeNameGenerator extends AbstractNameGenerator {

    @Override
    protected String generateInternal(String name) {
        String[] words = name.toLowerCase().split("_");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result.append(words[i]);
            } else {
                result.append(StringUtils.capitalize(words[i]));
            }
        }
        return result.toString();
    }

}
