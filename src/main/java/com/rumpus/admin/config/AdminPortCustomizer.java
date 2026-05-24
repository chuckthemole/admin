package com.rumpus.admin.config;

import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

import com.rumpus.common.Config.AbstractServerPortCustomizer;
import com.rumpus.common.Server.Port.IPort;

@Component
public class AdminPortCustomizer extends AbstractServerPortCustomizer {

    @Autowired
    public AdminPortCustomizer(Environment environment, IPort port) {
        super(environment, port);
    }

    @Override
    public String sqlDialect() {
        return "MYSQL";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
