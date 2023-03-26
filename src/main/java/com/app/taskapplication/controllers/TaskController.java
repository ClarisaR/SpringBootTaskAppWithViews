package com.app.taskapplication.controllers;
import com.app.taskapplication.models.Task;
import com.app.taskapplication.models.TaskCreateDTO;
import com.app.taskapplication.models.TaskUpdateDTO;
import com.app.taskapplication.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/tasks")
    public String createTask(@Valid TaskCreateDTO taskCreateDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("task", taskCreateDTO);
            List<Task> taskList = taskService.getAll();
            model.addAttribute("taskList",taskList);
            return "home";
        }else {
            Task task = Task.builder()
                    .name(taskCreateDTO.getName())
                    .description(taskCreateDTO.getDescription())
                    .status(taskCreateDTO.getStatus())
                    .date(new Date())
                    .build();
            Task newTask = taskService.createdTask(task);
            model.addAttribute("task", newTask);

            return "task_created_successfully";
        }
    }

    @GetMapping("/tasks")
    public String home(Model model){
        Task task = new Task();
        List<Task> taskList = taskService.getAll();
        model.addAttribute("taskList",taskList);
        model.addAttribute("task", task);
        return "home";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(@PathVariable Long id, Model model){
        Optional<Task> taskOptional = taskService.getById(id);
        if(taskOptional.isEmpty()){
            return "not_found";
        }else {
            model.addAttribute("task", taskOptional.get());
            return "task_details";
        }
    }
    @PostMapping("/tasks/{id}")
    public String updateTask(@Valid @ModelAttribute("task") TaskUpdateDTO taskUpdateDTO, BindingResult result, Model model, @PathVariable Long id){
        System.out.println(taskUpdateDTO.toString());
        Optional<Task> optionalTask = taskService.getById(id);
        if(optionalTask.isEmpty()){
            return "not_found";
        }
        if(result.hasErrors()){
            System.out.println("Errores: "+result.getAllErrors());
            model.addAttribute("task",optionalTask.get());
            return "task_details";
        }
        Task task = Task.builder()
                .id(id)
                .date(optionalTask.get().getDate())
                .name(taskUpdateDTO.getName())
                .description(taskUpdateDTO.getDescription())
                .status(taskUpdateDTO.getStatus())
                .build();
        Task updateTask = taskService.updateTask(task);
        model.addAttribute("task", updateTask);
        return "task_details";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id, Model model){
        taskService.deleteTask(id);
        Task task = new Task();
        model.addAttribute("newTask",task);
        List<Task> taskList = taskService.getAll();
        model.addAttribute("taskList",taskList);
        return "home";
    }

}
