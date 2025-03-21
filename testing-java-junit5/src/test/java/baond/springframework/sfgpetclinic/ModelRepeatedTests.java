package baond.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

/**
 * Created by BaoND on 2025-03-21
 */
@Tag("repeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Before of " + testInfo.getDisplayName());
        System.out.println("Current Repetition: " + repetitionInfo.getCurrentRepetition());
        System.out.println("Total Repetition: " + repetitionInfo.getTotalRepetitions());
    }


    @AfterEach
    default void afterAll(TestInfo testInfo) {
        System.out.println("After of " + testInfo.getDisplayName());
    }
}
