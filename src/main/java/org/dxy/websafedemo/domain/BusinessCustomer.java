package org.dxy.websafedemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "demo_business_customer")
@Getter
@Setter
public class BusinessCustomer extends BootDomain {

    private String username;

    private String customer;

    private String mobilePhone;

    private String city;

}
