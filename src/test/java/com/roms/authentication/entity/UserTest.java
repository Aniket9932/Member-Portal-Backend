package com.roms.authentication.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Method under test: {@link User#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new User()).canEqual("Other"));
    }

    /**
     * Method under test: {@link User#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        User user = new User();

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(3L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertTrue(user.canEqual(user1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setAddress(String)}
     *   <li>{@link User#setCaregivers(List)}
     *   <li>{@link User#setCid(long)}
     *   <li>{@link User#setCname(String)}
     *   <li>{@link User#setId(long)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getAddress()}
     *   <li>{@link User#getCaregivers()}
     *   <li>{@link User#getCid()}
     *   <li>{@link User#getCname()}
     *   <li>{@link User#getId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setAddress("42 Main St");
        ArrayList<Caregiver> caregiverList = new ArrayList<>();
        actualUser.setCaregivers(caregiverList);
        actualUser.setCid(1L);
        actualUser.setCname("Cname");
        actualUser.setId(123L);
        String actualToStringResult = actualUser.toString();
        assertEquals("42 Main St", actualUser.getAddress());
        assertSame(caregiverList, actualUser.getCaregivers());
        assertEquals(1L, actualUser.getCid());
        assertEquals("Cname", actualUser.getCname());
        assertEquals(123L, actualUser.getId());
        assertEquals("User(id=123, username=null, password=null, roles=null, firstName=null, lastName=null, Address=42 Main"
                + " St, cid=1, cname=Cname, caregivers=[])", actualToStringResult);
    }

    /**
     * Method under test: {@link User#User(long, String, String, String, String, String, String, long, String, List)}
     */
    @Test
    void testConstructor2() {
        User actualUser = new User(123L, "janedoe", "iloveyou", "Roles", "Jane", "Doe", "42 Main St", 1L, "Cname",
                new ArrayList<>());

        assertEquals("42 Main St", actualUser.getAddress());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("Roles", actualUser.getRoles());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals(123L, actualUser.getId());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Cname", actualUser.getCname());
        assertEquals(1L, actualUser.getCid());
        assertTrue(actualUser.getCaregivers().isEmpty());
    }

    /**
     * Method under test: {@link User#User(long, String, String, String, String, String, String, long, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: username is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:11)
        //   See https://diff.blue/R013 to resolve this issue.

        new User(1L, null, null, null, null, null, "foo", 1L, "foo", new ArrayList<>());

    }

    /**
     * Method under test: {@link User#User(long, String, String, String, String, String, String, long, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: password is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:11)
        //   See https://diff.blue/R013 to resolve this issue.

        new User(123L, "janedoe", null, "Roles", "Jane", "Doe", "42 Main St", 1L, "Cname", new ArrayList<>());

    }

    /**
     * Method under test: {@link User#User(long, String, String, String, String, String, String, long, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: roles is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:11)
        //   See https://diff.blue/R013 to resolve this issue.

        new User(123L, "janedoe", "iloveyou", null, "Jane", "Doe", "42 Main St", 1L, "Cname", new ArrayList<>());

    }

    /**
     * Method under test: {@link User#User(long, String, String, String, String, String, String, long, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: firstName is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:11)
        //   See https://diff.blue/R013 to resolve this issue.

        new User(123L, "janedoe", "iloveyou", "Roles", null, "Doe", "42 Main St", 1L, "Cname", new ArrayList<>());

    }

    /**
     * Method under test: {@link User#User(long, String, String, String, String, String, String, long, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: lastName is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:11)
        //   See https://diff.blue/R013 to resolve this issue.

        new User(123L, "janedoe", "iloveyou", "Roles", "Jane", null, "42 Main St", 1L, "Cname", new ArrayList<>());

    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String)}
     */
    @Test
    void testConstructor8() {
        User actualUser = new User("janedoe", "iloveyou", "Roles", "Jane", "Doe");

        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("Roles", actualUser.getRoles());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("Jane", actualUser.getFirstName());
        assertTrue(actualUser.getCaregivers().isEmpty());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: username is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:14)
        //   See https://diff.blue/R013 to resolve this issue.

        new User(null, null, null, null, null);

    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: password is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:14)
        //   See https://diff.blue/R013 to resolve this issue.

        new User("janedoe", null, "Roles", "Jane", "Doe");

    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: roles is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:14)
        //   See https://diff.blue/R013 to resolve this issue.

        new User("janedoe", "iloveyou", null, "Jane", "Doe");

    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor12() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: firstName is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:14)
        //   See https://diff.blue/R013 to resolve this issue.

        new User("janedoe", "iloveyou", "Roles", null, "Doe");

    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor13() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: lastName is marked non-null but is null
        //       at com.roms.authentication.entity.User.<init>(User.java:14)
        //   See https://diff.blue/R013 to resolve this issue.

        new User("janedoe", "iloveyou", "Roles", "Jane", null);

    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        assertNotEquals(user, null);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals2() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        assertNotEquals(user, "Different type to User");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#equals(Object)}
     *   <li>{@link User#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        assertEquals(user, user);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#equals(Object)}
     *   <li>{@link User#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertEquals(user, user1);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user1.hashCode());
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals5() {
        User user = new User();
        user.setAddress("janedoe");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals6() {
        User user = new User();
        user.setAddress(null);
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals7() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("janedoe");
        caregiver.setPhone("4105551212");

        ArrayList<Caregiver> caregiverList = new ArrayList<>();
        caregiverList.add(caregiver);

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(caregiverList);
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals8() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(3L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals9() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("janedoe");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals10() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname(null);
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals11() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("janedoe");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals12() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals13() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("janedoe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals14() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("janedoe");
        user.setRoles("Roles");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals15() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("janedoe");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals16() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("iloveyou");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#setFirstName(String)}
     */
    @Test
    void testSetFirstName() {
        User user = new User();
        user.setFirstName("Jane");
        assertEquals("Jane", user.getFirstName());
    }

    /**
     * Method under test: {@link User#setFirstName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetFirstName2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: firstName is marked non-null but is null
        //       at com.roms.authentication.entity.User.setFirstName(User.java:9)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        user.setFirstName(null);
    }

    /**
     * Method under test: {@link User#setLastName(String)}
     */
    @Test
    void testSetLastName() {
        User user = new User();
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    /**
     * Method under test: {@link User#setLastName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetLastName2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: lastName is marked non-null but is null
        //       at com.roms.authentication.entity.User.setLastName(User.java:9)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        user.setLastName(null);
    }

    /**
     * Method under test: {@link User#setPassword(String)}
     */
    @Test
    void testSetPassword() {
        User user = new User();
        user.setPassword("iloveyou");
        assertEquals("iloveyou", user.getPassword());
    }

    /**
     * Method under test: {@link User#setPassword(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetPassword2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: password is marked non-null but is null
        //       at com.roms.authentication.entity.User.setPassword(User.java:9)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        user.setPassword(null);
    }

    /**
     * Method under test: {@link User#setRoles(String)}
     */
    @Test
    void testSetRoles() {
        User user = new User();
        user.setRoles("Roles");
        assertEquals("Roles", user.getRoles());
    }

    /**
     * Method under test: {@link User#setRoles(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetRoles2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: roles is marked non-null but is null
        //       at com.roms.authentication.entity.User.setRoles(User.java:9)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        user.setRoles(null);
    }

    /**
     * Method under test: {@link User#setUsername(String)}
     */
    @Test
    void testSetUsername() {
        User user = new User();
        user.setUsername("janedoe");
        assertEquals("janedoe", user.getUsername());
    }

    /**
     * Method under test: {@link User#setUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetUsername2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: username is marked non-null but is null
        //       at com.roms.authentication.entity.User.setUsername(User.java:9)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        user.setUsername(null);
    }
}

