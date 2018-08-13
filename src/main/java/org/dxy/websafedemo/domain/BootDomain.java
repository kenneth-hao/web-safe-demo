package org.dxy.websafedemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BootDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(updatable = false)
    protected Date createTime = new Date();

}
