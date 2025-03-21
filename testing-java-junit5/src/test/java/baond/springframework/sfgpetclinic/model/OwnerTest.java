package baond.springframework.sfgpetclinic.model;

import baond.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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
                        () -> assertEquals("Nguyen", owner.getLastName())),
                () -> assertAll("Owner properties",
                        () -> assertEquals("1234-5678", owner.getTelephone()),
                        () -> assertEquals("123 Main Street 1", owner.getAddress(), "Address Did not Match"))
        );
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - {index} : {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "BaoND"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - {index} : {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }


    @DisplayName("CSV Input test")
    @ParameterizedTest(name = "{displayName} - {index}: {arguments}")
    @CsvSource({
            "FL,1,1",
            "OH,2,2",
            "MI,3,1"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("CSV From File test")
    @ParameterizedTest(name = "{displayName} - {index}: {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Method Provider test")
    @ParameterizedTest(name = "{displayName} - {index}: {arguments}")
    @MethodSource("getargs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }


    static Stream<Arguments> getargs() {
        /*this method could be calling out a database, message queue, reading in like an XML file or a JSON file*/
        return Stream.of(
                Arguments.of("FL", 3, 8),
                Arguments.of("OH", 89, 3),
                Arguments.of("MI", 4, 10));
    }
}