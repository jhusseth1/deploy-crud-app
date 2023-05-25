package com.codingdojo.jhusseth.controller.mvc;

import com.codingdojo.jhusseth.services.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Optional;

import static com.codingdojo.jhusseth.utils.Utils.getCurrentUserLoginId;
import static com.codingdojo.jhusseth.utils.Utils.getCurrentUserLoginUsername;

@Controller
@RequestMapping("/tasks")
public class IndexController {

    @Autowired
    private TaskService service;

    @GetMapping
    public String show(Model model, @RequestParam(value = "order", required = false) Integer order) {
        Optional<String> user = getCurrentUserLoginUsername();
        Optional<Long> userId = getCurrentUserLoginId();
        if (user.isPresent() && userId.isPresent()) {
            model.addAttribute("username", user.get());
            model.addAttribute("tasks", service.findAll(Objects.nonNull(order) ? order : 0, userId.get()));
            model.addAttribute("myTasks", service.findAllByUserId(userId.get()));
            return "index.jsp";
        }
        return "redirect:/login";
    }

}
