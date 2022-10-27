package com.pelinhangisi.admin.user;

import com.pelinhangisi.shopworldcommon.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
