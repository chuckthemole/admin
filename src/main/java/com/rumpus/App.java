package com.rumpus;

import org.slf4j.Logger;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.EnumerablePropertySource;

@SpringBootApplication
@EnableAdminServer
public class App {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @org.springframework.context.event.EventListener
    public void handleContextRefresh(
            org.springframework.context.event.ContextRefreshedEvent event) {
        LOGGER.info("App::handleContextRefresh()");
        final org.springframework.core.env.Environment environment = event.getApplicationContext()
                .getEnvironment();
        LOGGER.info("Active profiles: {}",
                java.util.Arrays.toString(environment.getActiveProfiles()));

        final org.springframework.core.env.MutablePropertySources sources = ((org.springframework.core.env.AbstractEnvironment) environment)
                .getPropertySources();

        java.util.stream.StreamSupport.stream(sources.spliterator(), false)
                .filter(propertySource -> propertySource instanceof EnumerablePropertySource)
                .map(propertySource -> ((EnumerablePropertySource) propertySource)
                        .getPropertyNames())
                .flatMap(java.util.Arrays::stream)
                .distinct()
                .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
                .forEach(prop -> LOGGER.info("{}: {}", prop, environment.getProperty(prop)));
    }

}
