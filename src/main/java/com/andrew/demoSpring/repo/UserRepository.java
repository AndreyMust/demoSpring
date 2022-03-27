package com.andrew.demoSpring.repo;

import com.andrew.demoSpring.models.DemoUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<DemoUser, Long> {

}
