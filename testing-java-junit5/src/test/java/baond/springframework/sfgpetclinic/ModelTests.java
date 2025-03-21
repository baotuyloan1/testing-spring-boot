package baond.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

/**
 * Created by BaoND on 2025-03-21
 */
@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        System.out.println("Before of "+ testInfo.getDisplayName());
    }


    @AfterEach
    default void afterAll(TestInfo testInfo) {
        System.out.println("After of "+ testInfo.getDisplayName());
    }
}
