package org.dxy.websafedemo.support;


public interface EnvConfiguration {

    default String site() {
        return "";
    }

    default String hackSite() {
        return "";
    }

}
