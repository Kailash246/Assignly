package com.studentworktracker.controller;

import com.studentworktracker.model.Task;
import com.studentworktracker.storage.TaskStore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class TaskController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/cr")
    public String crPanel(Model model) {
        model.addAttribute("tasks", TaskStore.getInstance().getAllTasks());
        model.addAttribute("today", LocalDate.now());
        return "cr";
    }

    @PostMapping("/cr/add")
    public String addTask(@RequestParam String title,
                          @RequestParam String description,
                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {
        Task task = new Task(title, description, dueDate);
        TaskStore.getInstance().addTask(task);
        return "redirect:/cr";
    }

    @PostMapping("/cr/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        TaskStore.getInstance().deleteTaskById(id);
        return "redirect:/cr";
    }

    @GetMapping("/student")
    public String studentPage(Model model) {
        model.addAttribute("tasks", TaskStore.getInstance().getAllTasks());
        model.addAttribute("today", LocalDate.now());
        return "student";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // this will map to about.html in the templates folder
    }
}
