package baond.springframework.sfgpetclinic.services.springdatajpa;

import baond.springframework.sfgpetclinic.model.Visit;
import baond.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by BaoND on 2025-03-22
 */
@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceIT {


    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {
        Visit visit = new Visit();

        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = service.findAll();

        verify(visitRepository).findAll();

        assertThat(foundVisits).hasSize(1);


    }

    @Test
    void findById() {
        Visit visit = new Visit();
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
        Visit foundVisit = service.findById(1l);

        verify(visitRepository).findById(anyLong());
        assertThat(foundVisit).isNotNull();
    }

    @Test
    void save() {
        Visit visit = new Visit();
        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(visit);

        verify(visitRepository).save(visit);
        assertThat(savedVisit).isNotNull().isEqualTo(visit);
    }

    @Test
    void delete() {
        /*given*/
        Visit visit = new Visit();


        /*when*/
        service.delete(visit);

        /*then*/
        verify(visitRepository).delete(visit);

    }

    @Test
    void deleteById() {
        Long aLong = 1L;

        service.deleteById(aLong);

        verify(visitRepository).deleteById(aLong);

    }
}