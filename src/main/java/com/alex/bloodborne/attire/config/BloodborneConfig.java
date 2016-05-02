package com.alex.bloodborne.attire.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="bloodborne")
public class BloodborneConfig {

    private final List<SuitcaseConfig> filters = new ArrayList<>();
    private final List<AttireSetConfig> attireSets = new ArrayList<>();

    public List<SuitcaseConfig> getFilters() {
        return filters;
    }

    public List<AttireSetConfig> getAttireSets() {
        return attireSets;
    }
}
