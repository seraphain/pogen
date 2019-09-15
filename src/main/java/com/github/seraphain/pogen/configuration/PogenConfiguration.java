package com.github.seraphain.pogen.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.seraphain.pogen.service.name.AttributeNameGenerator;
import com.github.seraphain.pogen.service.name.ClassNameGenerator;
import com.github.seraphain.pogen.service.name.RegexReplaceNameHandlerImpl;

@Configuration
public class PogenConfiguration {

    @Value("${pogen.table.prefix}")
    private String tablePrefix;

    @Value("${pogen.table.postfix}")
    private String tablePostfix;

    @Bean
    public ClassNameGenerator classNameGenerator() {
        ClassNameGenerator classNameGenerator = new ClassNameGenerator();
        classNameGenerator.addPreHandlers(new RegexReplaceNameHandlerImpl("^" + tablePrefix, ""));
        classNameGenerator.addPreHandlers(new RegexReplaceNameHandlerImpl(tablePostfix + "$", ""));
        return classNameGenerator;
    }

    @Bean
    public AttributeNameGenerator attributeNameGenerator() {
        return new AttributeNameGenerator();
    }

}
