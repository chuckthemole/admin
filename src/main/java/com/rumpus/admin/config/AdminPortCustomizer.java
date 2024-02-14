package com.rumpus.admin.config;

@org.springframework.stereotype.Component
public class AdminPortCustomizer extends com.rumpus.common.Config.AbstractServerPortCustomizer {
    
    @org.springframework.beans.factory.annotation.Autowired
    public AdminPortCustomizer(com.rumpus.common.Server.Port.IPort port) {
        super(port);
    }
}

