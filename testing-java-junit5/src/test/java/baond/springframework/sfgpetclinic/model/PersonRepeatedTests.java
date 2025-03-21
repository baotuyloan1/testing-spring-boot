package baond.springframework.sfgpetclinic.model;

import baond.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.*;

/**
 * Created by BaoND on 2025-03-21
 */
class PersonRepeatedTests implements ModelRepeatedTests {


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


    @RepeatedTest(value = 5, name = "{displayName}: {currentRepetition} | {totalRepetitions}")
    @DisplayName("My Repeated Test combines with interface")
    void myAssignmentRepeated(){
        System.out.println("Repeated Method");
    }
}
