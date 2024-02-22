package com.rumpus.admin.config;

@org.springframework.stereotype.Component
public class AdminPortCustomizer extends com.rumpus.common.Config.AbstractServerPortCustomizer {

    public static final String NAME = "AdminPortCustomizer";

    @org.springframework.beans.factory.annotation.Autowired
    public AdminPortCustomizer(org.springframework.core.env.Environment environment, com.rumpus.common.Server.Port.IPort port) {
        super(NAME, environment, port);
    }
}

