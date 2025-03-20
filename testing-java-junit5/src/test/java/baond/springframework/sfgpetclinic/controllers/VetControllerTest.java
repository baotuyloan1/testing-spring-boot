package baond.springframework.sfgpetclinic.controllers;

import baond.springframework.sfgpetclinic.fauxspring.Model;
import baond.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import baond.springframework.sfgpetclinic.model.Vet;
import baond.springframework.sfgpetclinic.services.SpecialtyService;
import baond.springframework.sfgpetclinic.services.VetService;
import baond.springframework.sfgpetclinic.services.map.SpecialityMapService;
import baond.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by BaoND on 2025-03-20
 */
class VetControllerTest {

    VetService vetService;
    SpecialtyService specialtyService;

    VetController vetController;
    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "Bao", "ND", null);
        Vet vet2 = new Vet(2L, "Bao2", "ND2", null);
        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);
        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}