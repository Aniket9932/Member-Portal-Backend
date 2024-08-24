package com.roms.authentication.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CaregiverTest {
    /**
     * Method under test: {@link Caregiver#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Caregiver()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Caregiver#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Caregiver caregiver = new Caregiver();

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        assertTrue(caregiver.canEqual(caregiver1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Caregiver#Caregiver()}
     *   <li>{@link Caregiver#setCaregiverId(int)}
     *   <li>{@link Caregiver#setCaregiverName(String)}
     *   <li>{@link Caregiver#setPhone(String)}
     *   <li>{@link Caregiver#toString()}
     *   <li>{@link Caregiver#getCaregiverId()}
     *   <li>{@link Caregiver#getCaregiverName()}
     *   <li>{@link Caregiver#getPhone()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Caregiver actualCaregiver = new Caregiver();
        actualCaregiver.setCaregiverId(123);
        actualCaregiver.setCaregiverName("Caregiver Name");
        actualCaregiver.setPhone("4105551212");
        String actualToStringResult = actualCaregiver.toString();
        assertEquals(123, actualCaregiver.getCaregiverId());
        assertEquals("Caregiver Name", actualCaregiver.getCaregiverName());
        assertEquals("4105551212", actualCaregiver.getPhone());
        assertEquals("Caregiver(caregiverId=123, caregiverName=Caregiver Name, phone=4105551212)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Caregiver#Caregiver(int, String, String)}
     *   <li>{@link Caregiver#setCaregiverId(int)}
     *   <li>{@link Caregiver#setCaregiverName(String)}
     *   <li>{@link Caregiver#setPhone(String)}
     *   <li>{@link Caregiver#toString()}
     *   <li>{@link Caregiver#getCaregiverId()}
     *   <li>{@link Caregiver#getCaregiverName()}
     *   <li>{@link Caregiver#getPhone()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Caregiver actualCaregiver = new Caregiver(123, "Caregiver Name", "4105551212");
        actualCaregiver.setCaregiverId(123);
        actualCaregiver.setCaregiverName("Caregiver Name");
        actualCaregiver.setPhone("4105551212");
        String actualToStringResult = actualCaregiver.toString();
        assertEquals(123, actualCaregiver.getCaregiverId());
        assertEquals("Caregiver Name", actualCaregiver.getCaregiverName());
        assertEquals("4105551212", actualCaregiver.getPhone());
        assertEquals("Caregiver(caregiverId=123, caregiverName=Caregiver Name, phone=4105551212)", actualToStringResult);
    }

    /**
     * Method under test: {@link Caregiver#equals(Object)}
     */
    @Test
    void testEquals() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        assertNotEquals(caregiver, null);
    }

    /**
     * Method under test: {@link Caregiver#equals(Object)}
     */
    @Test
    void testEquals2() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        assertNotEquals(caregiver, "Different type to Caregiver");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Caregiver#equals(Object)}
     *   <li>{@link Caregiver#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        assertEquals(caregiver, caregiver);
        int expectedHashCodeResult = caregiver.hashCode();
        assertEquals(expectedHashCodeResult, caregiver.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Caregiver#equals(Object)}
     *   <li>{@link Caregiver#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        assertEquals(caregiver, caregiver1);
        int expectedHashCodeResult = caregiver.hashCode();
        assertEquals(expectedHashCodeResult, caregiver1.hashCode());
    }

    /**
     * Method under test: {@link Caregiver#equals(Object)}
     */
    @Test
    void testEquals5() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(1);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        assertNotEquals(caregiver, caregiver1);
    }

    /**
     * Method under test: {@link Caregiver#equals(Object)}
     */
    @Test
    void testEquals6() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("4105551212");
        caregiver.setPhone("4105551212");

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        assertNotEquals(caregiver, caregiver1);
    }

    /**
     * Method under test: {@link Caregiver#equals(Object)}
     */
    @Test
    void testEquals7() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName(null);
        caregiver.setPhone("4105551212");

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        assertNotEquals(caregiver, caregiver1);
    }

    /**
     * Method under test: {@link Caregiver#equals(Object)}
     */
    @Test
    void testEquals8() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("+44 1865 4960636");

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        assertNotEquals(caregiver, caregiver1);
    }

    /**
     * Method under test: {@link Caregiver#equals(Object)}
     */
    @Test
    void testEquals9() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone(null);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        assertNotEquals(caregiver, caregiver1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Caregiver#equals(Object)}
     *   <li>{@link Caregiver#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName(null);
        caregiver.setPhone("4105551212");

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName(null);
        caregiver1.setPhone("4105551212");
        assertEquals(caregiver, caregiver1);
        int expectedHashCodeResult = caregiver.hashCode();
        assertEquals(expectedHashCodeResult, caregiver1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Caregiver#equals(Object)}
     *   <li>{@link Caregiver#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone(null);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverId(123);
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone(null);
        assertEquals(caregiver, caregiver1);
        int expectedHashCodeResult = caregiver.hashCode();
        assertEquals(expectedHashCodeResult, caregiver1.hashCode());
    }
}

