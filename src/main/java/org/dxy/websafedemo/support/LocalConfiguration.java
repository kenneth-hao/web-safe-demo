package org.dxy.websafedemo.support;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class LocalConfiguration implements EnvConfiguration {

    @Override
    public String site() {
        return "http://localhost:8080";
    }

    @Override
    public String hackSite() {
        return "http://localhost:9090";
    }

}
