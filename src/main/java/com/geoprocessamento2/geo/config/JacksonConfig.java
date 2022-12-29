package com.geoprocessamento2.geo.config;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;

public class JacksonConfig {
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }
}
