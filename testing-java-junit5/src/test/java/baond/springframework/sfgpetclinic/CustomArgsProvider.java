package baond.springframework.sfgpetclinic;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * Created by BaoND on 2025-03-21
 */
public class CustomArgsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of("FL", 33, 98),
                Arguments.of("OH", 89, 33),
                Arguments.of("MI", 44, 10));
    }
}
