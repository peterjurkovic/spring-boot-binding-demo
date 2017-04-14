package com.test.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("com.text")
public class Props {

    private Map<String, Map<String, String>> property;

    public Map<String, Map<String, String>> getProperty() {
        return property;
    }

    public void setProperty(Map<String, Map<String, String>> property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Props [property=" + property + "]";
    }

   
    
}
