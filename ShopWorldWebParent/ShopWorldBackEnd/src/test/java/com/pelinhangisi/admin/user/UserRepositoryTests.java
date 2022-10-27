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
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class, 1);
        User userPelin = new User("leyle@test.com" , "1234", "Pelin", "Hangisi");
        userPelin.addRole(roleAdmin);

        User savedUser = repo.save(userPelin);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

//    @Test
//    public void testCreateNewUserWithTwoRoles(){
//        User userAyse = new User("test@test.com", "1234", "Pelin", "Hangisi");
//        Role roleEditor = new Role("Editor");
//        Role roleAssistant = new Role("Assistant");
//
//        userAyse.addRole(roleEditor);
//        userAyse.addRole(roleAssistant);
//
//        User savedUser = repo.save(userAyse);
//
//        assertThat(savedUser.getId()).isGreaterThan(0);
//    }

    @Test
    public void testListAllUsers(){
        Iterable<User> listUsers = repo.findAll();
        listUsers.forEach(user -> System.out.println(user));
    }
}
