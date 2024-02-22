package com.rumpus;

@org.springframework.boot.autoconfigure.SpringBootApplication
@de.codecentric.boot.admin.server.config.EnableAdminServer
public class App {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(App.class, args);
	}

    @org.springframework.context.event.EventListener
    public void handleContextRefresh(org.springframework.context.event.ContextRefreshedEvent event) {
        LOGGER.info("App::handleContextRefresh()");
        final org.springframework.core.env.Environment environment = event.getApplicationContext().getEnvironment();
        LOGGER.info("Active profiles: {}", java.util.Arrays.toString(environment.getActiveProfiles()));

        final org.springframework.core.env.MutablePropertySources sources = ((org.springframework.core.env.AbstractEnvironment) environment).getPropertySources();

        java.util.stream.StreamSupport.stream(sources.spliterator(), false)
            .filter(propertySource -> propertySource instanceof org.springframework.core.env.EnumerablePropertySource)
            .map(propertySource -> ((org.springframework.core.env.EnumerablePropertySource) propertySource).getPropertyNames())
            .flatMap(java.util.Arrays::stream)
            .distinct()
            .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
            .forEach(prop -> LOGGER.info("{}: {}", prop, environment.getProperty(prop)));
    }

}
