package baond.springframework.sfgpetclinic.model;

import baond.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by BaoND on 2025-03-20
 */
class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Bao", "Nguyen");
        owner.setTelephone("1234-5678");
        owner.setAddress("123 Main Street");

        assertAll("Properties test",
                () -> assertAll("Person properties",
                        () -> assertEquals("Bao1", owner.getFirstName(), "First Name Did not Match"),
                        ()-> assertEquals("Nguyen", owner.getLastName())),
                () -> assertAll("Owner properties",
                        () -> assertEquals("1234-5678", owner.getTelephone()),
                        () -> assertEquals("123 Main Street 1", owner.getAddress(), "Address Did not Match"))
                );
    }
}