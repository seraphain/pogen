package com.github.seraphain.pogen.service.name;

import org.apache.commons.lang3.StringUtils;

public class RegexReplaceNameHandlerImpl implements NameHandler {

    private String oldPattern;

    private String newPattern;

    public RegexReplaceNameHandlerImpl() {

    }

    public RegexReplaceNameHandlerImpl(String oldPattern, String newPattern) {
        this.oldPattern = oldPattern;
        this.newPattern = newPattern;
    }

    @Override
    public String handle(String name) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(oldPattern) || newPattern == null) {
            return name;
        }
        return name.replaceAll(oldPattern, newPattern);
    }

    public void setOldPattern(String oldPattern) {
        this.oldPattern = oldPattern;
    }

    public void setNewPattern(String newPattern) {
        this.newPattern = newPattern;
    }

}
