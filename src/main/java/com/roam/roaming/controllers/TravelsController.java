package com.roam.roaming.controllers;

import com.roam.roaming.models.Travels;
import com.roam.roaming.data.TravelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Service
@RequestMapping("travels")
public class TravelsController {
    @Autowired
    private TravelsRepository travelsRepository;

    //displays travel log
    @RequestMapping("")
    public String displayAllTravelsTraveled(Model model){
        model.addAttribute("title", "Travel Log");
        model.addAttribute("travels", travelsRepository.findAll());
        return "travels/index";
    }

    //adds new travels to empty constructor Places()
    @GetMapping("create")
    public String renderCreateTravelsForm(Model model){
        model.addAttribute("travels", new Travels());
//        model.addAttribute("places", placesRepository.findAll());
        return "travels/create";
    }

    //adds new travels to places repository
    @PostMapping("create")
    public String createTravels(@ModelAttribute @Valid Travels newTravels, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Travels");
//            model.addAttribute("errorMsg", "Bad data!");
            return "travels/create";
        }
        travelsRepository.save(newTravels);
        return "redirect:/travels"; //updates places list
    }

    //check delete function
    @GetMapping("delete")
    public String displayDeleteTravelsForm(Model model){
        model.addAttribute("title", "Delete Travels");
        model.addAttribute("travels", travelsRepository.findAll());
        return "travels/delete";
    }

    @PostMapping("delete")
    public String processDeleteTravelsForm(@RequestParam(required = false) int[] travelsIds){

        if(travelsIds != null) {
            for (int id : travelsIds) {
                travelsRepository.deleteById(id);
            }
        }
        return "redirect:/travels";
    }
}
