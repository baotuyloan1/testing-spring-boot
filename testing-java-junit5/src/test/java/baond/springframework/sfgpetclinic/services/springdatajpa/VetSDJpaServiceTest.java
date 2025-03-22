package baond.springframework.sfgpetclinic.services.springdatajpa;

import baond.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by BaoND on 2025-03-22
 */
@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetSDJpaService vetSDJpaService;

    @Test
    void deleteById() {
        vetSDJpaService.deleteById(1l);

        verify(vetRepository, times(1)).deleteById(1l);
    }
}