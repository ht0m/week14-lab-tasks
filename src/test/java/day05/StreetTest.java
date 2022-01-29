package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    @Test
    void testStreet() {
        Street street = new Street();
        street.readFile();

        //HomeWork
        assertEquals(3, street.streamHomeWork("Petofi"));
        assertEquals(2, street.streamHomeWork("Kossuth"));
    }

}