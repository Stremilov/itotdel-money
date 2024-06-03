package com.itotdel.money.controller;


import com.itotdel.money.model.Task;
import com.itotdel.money.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    ResponseEntity<Task> createNewTask(@RequestBody Task body) {
        return ResponseEntity.ok(taskService.createNewTask(body));
    };
}
