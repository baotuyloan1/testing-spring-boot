package baond.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Created by BaoND on 2025-03-20
 */
class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        /*those are JUnit assertions*/
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned");
        assertEquals("index", controller.index(), "Another Expensive Message " +
                "Make me only if you have to");


        /*this is an AssertJ Assertion*/
        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class,
                () -> controller.oopsHandler());
//        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "This is some expensive" +
//                " Message to build" +
//                " for my test");
    }


    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {
        /*it's gonna run in a single thread.
         * JUnit is just gonna pause and wait for it (5 sec)*/
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }


    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPrempt() {
        /*running in a separate thread.
        Even though I told it to sleep for five sec
        The timing is canceled out early by JUnit. (119ms)
        */
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here Preemptively");
        });
    }


    @Test
    void testAssumptionTrue() {
        assertEquals("baond", "baond");
        System.out.println("Before");
        assumeTrue("BAOND".equalsIgnoreCase(System.getenv("MY_RUNTIME")));
        System.out.println("after");
        assertEquals("baond2", "baond2");
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        System.out.println("Before2");
        assumeTrue("BAOND".equalsIgnoreCase("baond"));
        System.out.println("after2");
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }


    /*window = USERNAME
     * macos = USER*/
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "nguye")
    @Test
    void testMeIfUserBaoND() {
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "somebody")
    @Test
    void testMeIfUserBaoND2() {
    }
}