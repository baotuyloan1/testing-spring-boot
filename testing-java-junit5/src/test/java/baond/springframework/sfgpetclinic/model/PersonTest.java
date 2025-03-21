package baond.springframework.sfgpetclinic.model;

import baond.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by BaoND on 2025-03-20
 */
class PersonTest implements ModelTests {

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


    /*by default:
     * repetition 1 - of 10
     * ...
     * repetition 10 of 10
     *
     * we can modify this
     * */
//    @Test - don't need this annotation as long  as we have @RepeatedTest
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        // to do - impl
    }

    /*TestInfo and RepetitionInfo are going to be injected into the test at runtime.*/
    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo, TestReporter testReporter) {
        System.out.println(testInfo.getDisplayName());
        System.out.println(repetitionInfo.getCurrentRepetition() + " - " + repetitionInfo.getTotalRepetitions());
    }
}