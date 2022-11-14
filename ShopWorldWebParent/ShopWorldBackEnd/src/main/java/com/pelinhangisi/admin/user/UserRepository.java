package com.pelinhangisi.admin.user;

import com.pelinhangisi.shopworldcommon.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    // "SELECT u FROM u User u WHERE u.email = :email"   hata ne ?
    @Query()
    User getUserByEmail(@Param("email") String email);
}
