package com.roam.roaming.controllers;

import com.roam.roaming.models.User;
import com.roam.roaming.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
@Service
public class UserController {
    @Autowired
    UserRepository userRepository;

    @ModelAttribute
    public void addUserAttributes(Model model, HttpServletRequest request) {
        Object userObj = request.getAttribute("user");
        if(userObj != null && userObj instanceof User){
            model.addAttribute("user", (User) userObj);
        }
    }

    @GetMapping("/profile")
    public String displayProfile(Model model){
        model.addAttribute("profileOwner", model.getAttribute("user"));
        return "users/profile";
    }

    @GetMapping("profile/{username}")
    public String displayProfile(Model model, @PathVariable String username){
        User profileOwner = userRepository.findByUsername(username);

        if(profileOwner == null) {
            // the expected user was not found
            return "redirect:/index";
        }
        model.addAttribute("profileOwner", profileOwner);

        return "users/profile";
    }

}
