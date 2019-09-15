package com.github.seraphain.pogen.service.name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractNameGenerator implements NameGenerator {

    private List<NameHandler> preHandlers;

    private List<NameHandler> postHandlers;

    @Override
    public String generate(String name) {
        String result = name;
        if (preHandlers != null) {
            for (NameHandler handle : preHandlers) {
                result = handle.handle(result);
            }
        }
        result = generateInternal(result);
        if (postHandlers != null) {
            for (NameHandler handle : postHandlers) {
                result = handle.handle(result);
            }
        }
        return result;
    }

    protected abstract String generateInternal(String name);

    public void setPreHandlers(List<NameHandler> preHandlers) {
        this.preHandlers = new ArrayList<>();
        this.preHandlers.addAll(preHandlers);
    }

    public void addPreHandlers(NameHandler... preHandlers) {
        if (this.preHandlers == null) {
            this.preHandlers = new ArrayList<>();
        }
        this.preHandlers.addAll(Arrays.asList(preHandlers));
    }

    public void setPostHandlers(List<NameHandler> postHandlers) {
        this.postHandlers = new ArrayList<>();
        this.postHandlers.addAll(postHandlers);
    }

    public void addPostHandlers(NameHandler... postHandlers) {
        if (this.postHandlers == null) {
            this.postHandlers = new ArrayList<>();
        }
        this.postHandlers.addAll(Arrays.asList(postHandlers));
    }

}
