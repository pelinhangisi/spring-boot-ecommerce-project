package com.pelinhangisi.admin.user;

import static org.assertj.core.api.Assertions.assertThat;
import com.pelinhangisi.shopworldcommon.entity.Role;
import com.pelinhangisi.shopworldcommon.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        Role roleAdmin = entityManager.find(Role.class, 1);
        User userPelin = new User("pelin@test.com" , "1234", "Pelin", "Hangisi");
        userPelin.addRole(roleAdmin);
        User savedUser = repo.save(userPelin);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}cmd
