package org.dxy.websafedemo.repository;

import org.dxy.websafedemo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BootRepository<User> {

}
