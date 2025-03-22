package baond.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

/**
 * Created by BaoND on 2025-03-22
 */
public class AnnotationMocksTest {

    @Mock
    Map<String, Object> mapMock;

    @BeforeEach
    void setUp() {
        /*initialize mocks*/
        MockitoAnnotations.initMocks(this);
    }




    @Test
    void testMock(){
        mapMock.put("keyvalue", "food");
    }

}
