package org.dxy.websafedemo.support;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class ProdConfiguration implements EnvConfiguration {



    @Override
    public String site() {
        return "https://web-safe-demo.herokuapp.com";
    }

    @Override
    public String hackSite() {
        return "https://web-safe-demo-hack.herokuapp.com";
    }

}
