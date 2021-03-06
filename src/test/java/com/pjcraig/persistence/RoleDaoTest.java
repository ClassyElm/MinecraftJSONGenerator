package com.pjcraig.persistence;

import com.pjcraig.entity.Role;
import com.pjcraig.entity.User;
import com.pjcraig.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    GenericDao roleDao;
    GenericDao userDao;

    /**
     * Initializes the DAOs and testing database before any test is run.
     */
    @BeforeEach
    void setUp() {
        roleDao = new GenericDao(Role.class);
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies retrieving roles by id from database.
     */
    @Test
    void getByIdSuccess() {
        int id = 1;
        User user = (User) userDao.getById(1);
        Role expectedRole = new Role("admin", user);
        expectedRole.setId(id);
        Role retrievedRole = (Role) roleDao.getById(id);
        assertNotNull(retrievedRole);
        assertEquals(expectedRole, retrievedRole);
    }

    /**
     * Verifies retrieving roles by a given property from database succeeds.
     */
    @Test
    void getByPropertyEqualsSuccess() {
        Role expectedRole = (Role) roleDao.getById(1);

        List<Role> roles = roleDao.getByPropertyEqual("name", expectedRole.getName());

        assertEquals(1, roles.size());
        Role actualRole = roles.get(0);
        assertEquals(expectedRole, actualRole);
    }

    /**
     * Verifies success of updating roles in database.
     */
    @Test
    void saveOrUpdateSuccess() {
        int id = 1;
        Role roleToUpdate = (Role) roleDao.getById(id);
        String newName = "standard";
        String initialName = roleToUpdate.getName();
        roleToUpdate.setName(newName);
        roleDao.saveOrUpdate(roleToUpdate);
        Role retrievedRole = (Role) roleDao.getById(id);
        assertNotEquals(initialName, retrievedRole.getName());
        assertEquals(newName, retrievedRole.getName());
    }

    /**
     * Verifies success of role insertion into the database.
     */
    @Test
    void insertSuccess() {
        User user = (User) userDao.getById(2);
        Role newRole = new Role("admin", user);
        int id = roleDao.insert(newRole);
        newRole.setId(id);
        assertNotEquals(1, id);
        Role insertedRole = (Role) roleDao.getById(id);
        assertEquals(newRole, insertedRole);
    }

    /**
     * Verifies success of role deletion without removing the users from the database.
     */
    @Test
    void deleteSuccess() {
        int id = 1;
        Role initialRole = (Role) roleDao.getById(id);
        assertNotNull(initialRole);

        roleDao.delete(initialRole);

        Role deletedRole = (Role) roleDao.getById(id);
        assertNull(deletedRole);
    }

    /**
     * Verifies successful retrieval of all roles from the database.
     */
    @Test
    void getAllSuccess() {
        List<Role> roles = roleDao.getAll();
        assertEquals(1, roles.size());
    }
}