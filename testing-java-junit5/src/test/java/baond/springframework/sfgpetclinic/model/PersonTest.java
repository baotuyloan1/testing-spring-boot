package baond.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by BaoND on 2025-03-20
 */
@Tag("model")
class PersonTest {

    @Test
    void groupedAssertions() {
        /*given*/
        Person person = new Person(1L, "Bao", "Nguyen");

        /*then*/
        assertAll("Test Props Set",
                () -> assertEquals("Bao", person.getFirstName()),
                () -> assertEquals("Nguyen", person.getLastName()));

    }

    @Test
    void groupedAssertionsMsg() {
        /*given*/
        Person person = new Person(1L, "Bao", "Nguyen");

        /*then*/
        assertAll("Test Props Set",
                () -> assertEquals("Bao", person.getFirstName(), "First Name failed"),
                () -> assertEquals("Nguyen", person.getLastName(), "Last Name failed"));

    }
}