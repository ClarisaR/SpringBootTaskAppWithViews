package com.app.taskapplication.services;

import com.app.taskapplication.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAll();

    Task createdTask(Task task);

    Optional<Task> getById(Long id);

    Task updateTask(Task task);

    void deleteTask(Long id);
}
