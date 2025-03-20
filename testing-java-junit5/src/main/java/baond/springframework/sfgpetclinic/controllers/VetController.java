package baond.springframework.sfgpetclinic.controllers;

import baond.springframework.sfgpetclinic.fauxspring.Model;
import baond.springframework.sfgpetclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
