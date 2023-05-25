package com.codingdojo.jhusseth.controller.mvc;

import com.codingdojo.jhusseth.domain.dto.TaskDTO;
import com.codingdojo.jhusseth.services.interfaces.PriorityService;
import com.codingdojo.jhusseth.services.interfaces.TaskService;
import com.codingdojo.jhusseth.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

import static com.codingdojo.jhusseth.controller.constans.Constants.*;
import static com.codingdojo.jhusseth.utils.Utils.concatErrorMessageList;
import static com.codingdojo.jhusseth.utils.Utils.getCurrentUserLoginId;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @Autowired
    private UserService userService;

    @Autowired
    private PriorityService priorityService;

    @GetMapping("/new")
    public String addTaskView(Model model, @ModelAttribute("task") TaskDTO task) {
        Optional<Long> user = getCurrentUserLoginId();
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("priorities", priorityService.findAll());
            return "createTask.jsp";
        }
        return "redirect:/login";
    }

    @PostMapping
    public String addTask(@Validated @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {
        Optional<Long> user = getCurrentUserLoginId();
        if (user.isPresent()) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("errorSaved", true);
                model.addAttribute("errorMessage", concatErrorMessageList(bindingResult));
                model.addAttribute("user", user.get());
                model.addAttribute("users", userService.findAllUsers());
                model.addAttribute("priorities", priorityService.findAll());
                return "createTask.jsp";
            }
            if (Objects.nonNull(task.getAssigneeUserId()) && !service.isValidAssignee(task.getAssigneeUserId())) {
                model.addAttribute("user", user.get());
                model.addAttribute("users", userService.findAllUsers());
                model.addAttribute("priorities", priorityService.findAll());
                model.addAttribute("errorSaved", true);
                model.addAttribute("errorMessage", FAILED_TASK_ASSIGNEE);
                return "createTask.jsp";
            }
            service.save(task);
            return "redirect:/tasks";
        }
        return "redirect:/login";
    }

    @GetMapping("/{taskId}/edit")
    public String editTask(@PathVariable(value = "taskId") Long taskId, @ModelAttribute("task") TaskDTO task, Model model) {
        Optional<Long> user = getCurrentUserLoginId();
        if (user.isPresent()) {
            TaskDTO taskEdit = service.findById(taskId);
            model.addAttribute("user", user.get());
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("priorities", priorityService.findAll());
            model.addAttribute("task", taskEdit);
            return "editTask.jsp";
        }
        return "redirect:/login";
    }

    @PutMapping("/update")
    public String postEditTask(@Validated @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", concatErrorMessageList(bindingResult));
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("priorities", priorityService.findAll());
            model.addAttribute("task", task);
            return "editTask.jsp";
        }

        boolean saved = service.update(task);
        if (!saved) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", FAILED_UPDATE_TASK);
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("priorities", priorityService.findAll());
            model.addAttribute("task", task);
            return "editTask.jsp";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/{taskId}")
    public String showTask(@PathVariable(value = "taskId") Long taskId, Model model) {
        TaskDTO task = service.findById(taskId);
        Optional<Long> userId = getCurrentUserLoginId();
        if (userId.isPresent()) {
            model.addAttribute("task", task);
            model.addAttribute("userId", userId.get());
            return "showTask.jsp";
        }
        return "redirect:/login";
    }

    @DeleteMapping("/{taskId}/delete")
    public String deleteTask(@PathVariable(value = "taskId") Long taskId, Model model) {
        Optional<Long> userId = getCurrentUserLoginId();
        boolean deleted = false;
        if (userId.isPresent() && service.isYourTask(userId.get(), taskId)) {
            deleted = service.delete(userId.get(), taskId);
        }
        if (!deleted) {
            TaskDTO task = service.findById(taskId);
            model.addAttribute("task", task);
            model.addAttribute("userId", userId.get());
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", FAILED_DELETE_PROJECT_MESSAGE);
            return "showTask.jsp";
        }
        return "redirect:/tasks";
    }

    @PostMapping("{taskId}/complete")
    public String completeTask(@PathVariable(value = "taskId") Long taskId) {
        service.completeTask(taskId);
        return "redirect:/tasks";
    }
}
