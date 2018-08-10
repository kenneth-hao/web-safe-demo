package org.dxy.websafedemo.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "demo_timeline")
@Getter
@Setter
public class Timeline extends BootDomain {

    private String username;
    private String microBlog;

    public static Timeline of(String username, String microBlog) {
        Timeline timeline = new Timeline();

        timeline.username = username;
        timeline.microBlog = microBlog;

        return timeline;
    }

}
