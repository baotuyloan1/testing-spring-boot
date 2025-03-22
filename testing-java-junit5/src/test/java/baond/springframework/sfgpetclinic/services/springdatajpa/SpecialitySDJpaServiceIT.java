package baond.springframework.sfgpetclinic.services.springdatajpa;

import baond.springframework.sfgpetclinic.model.Speciality;
import baond.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by BaoND on 2025-03-22
 */
@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceIT {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void findByIdTest(){
        Speciality speciality = new Speciality();
        speciality.setId(1l);

        when(specialtyRepository.findById(1l)).thenReturn(Optional.of(speciality));

        Speciality foundSpeciality = service.findById(1l);

        assertThat(foundSpeciality).isNotNull();

        verify(specialtyRepository).findById(1l);
    }

    @Test
    void testDeleteById() {
        service.deleteById(2l);
        service.deleteById(2l);
        service.deleteById(1l);
        service.deleteById(2l);

        /*check whether if deleteById(2l) is called 3 times*/
        verify(specialtyRepository, times(3)).deleteById(2l);
        verify(specialtyRepository, times(1)).deleteById(1l);
    }

    @Test
    void testDeleteByIdAtLeast() {
        service.deleteById(2l);
        service.deleteById(2l);
        service.deleteById(1l);
        service.deleteById(2l);

        /*check whether if deleteById(2l) is called 3 times*/
        verify(specialtyRepository, atLeastOnce()).deleteById(1l);
        verify(specialtyRepository, atLeast(2)).deleteById(2l);
    }


    @Test
    void testDeleteByIdAtMost(){
        service.deleteById(1l);
        service.deleteById(1l);

        verify(specialtyRepository, atMost(2)).deleteById(2l);
        verify(specialtyRepository, atMost(2)).deleteById(1l);
    }


    @Test
    void deleteByIdNever(){
        service.deleteById(1l);
        service.deleteById(1l);

        verify(specialtyRepository,never()).deleteById(2l);
    }

    @Test
    void testDelete(){
        service.delete(new Speciality());
    }
}