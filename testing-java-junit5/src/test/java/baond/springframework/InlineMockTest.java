package baond.springframework;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by BaoND on 2025-03-22
 */
public class InlineMockTest {

    @Test
    void testInlineMock(){
        /*create a mock implementation of Map*/
        Map mapMock = mock(Map.class);

        assertEquals(mapMock.size(), 0);
    }
}
