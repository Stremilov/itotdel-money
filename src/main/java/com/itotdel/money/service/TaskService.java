package com.itotdel.money.service;

import com.itotdel.money.exception.TaskExsistsExeption;
import com.itotdel.money.model.Task;
import com.itotdel.money.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task requestBody) {
        if (taskRepository.findById(requestBody.getId()).isPresent()) {
            throw new TaskExsistsExeption();
        }
        return taskRepository.save(requestBody);
    }
}
