package org.dxy.websafedemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "demo_user")
@Getter
@Setter
public class User extends BootDomain {

    public static User of() {
        User o = new User();
        return o;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    protected String name;
}
