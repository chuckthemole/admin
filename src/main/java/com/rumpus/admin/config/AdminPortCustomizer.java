package com.rumpus.admin.config;

@org.springframework.stereotype.Component
public class AdminPortCustomizer extends com.rumpus.common.Config.AbstractServerPortCustomizer {

    private static final String NAME = "AdminPortCustomizer";
    private static final String PORT = "8082"; // TODO: look in AbstractServerPortCustomizer for its todo. I should make a port manager, or look for one if I started one earlier.

    public AdminPortCustomizer() {
        super(NAME, PORT, true);
    }
}

