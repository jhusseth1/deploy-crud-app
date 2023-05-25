package com.codingdojo.jhusseth.controller.mvc;

import com.codingdojo.jhusseth.domain.dto.UserRegisterDTO;
import com.codingdojo.jhusseth.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Optional;

import static com.codingdojo.jhusseth.controller.constans.Constants.FAILED_SIMILAR_EMAIL_MESSAGE;
import static com.codingdojo.jhusseth.controller.constans.Constants.FAILED_SIMILAR_PASSWORD_MESSAGE;
import static com.codingdojo.jhusseth.utils.Utils.concatErrorMessageList;
import static com.codingdojo.jhusseth.utils.Utils.getCurrentUserLoginUsername;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String index(@RequestParam(required = false, value = "error") String error, Model model) {
        if (Objects.nonNull(error)) {
            model.addAttribute("errorLogin", "true");
            model.addAttribute("errorMessage", "El usuario o la contraseña son incorrectos!");
        }
        return "authPage.jsp";
    }

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute UserRegisterDTO dto, BindingResult bindingResult, Model model) {
        boolean error = false;
        String message = "";
        if (bindingResult.hasErrors()) {
            error = true;
            message = concatErrorMessageList(bindingResult);
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            error = true;
            message = FAILED_SIMILAR_PASSWORD_MESSAGE;

        }
        boolean isRegistered = service.register(dto);
        if (!isRegistered) {
            error = true;
            message = FAILED_SIMILAR_EMAIL_MESSAGE;
        }
        if (error) {
            model.addAttribute("errorRegister", error);
            model.addAttribute("errorMessage", message);
            return "authPage.jsp";
        }

        return "redirect:/login";
    }

    @GetMapping("/")
    public String show(Model model) {
        Optional<String> user = getCurrentUserLoginUsername();
        if (user.isEmpty()) {
            return "redirect:/login";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access_denied.jsp";
    }

}
