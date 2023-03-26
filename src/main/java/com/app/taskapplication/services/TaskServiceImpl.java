package com.app.taskapplication.services;

import com.app.taskapplication.models.Task;
import com.app.taskapplication.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> getAll() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        return (List<Task>)taskIterable;
    }

    @Override
    public Task createdTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getById(Long id) {
         return taskRepository.findById(id);
    }

    @Override
    public Task updateTask(Task task) {
         return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id ){
        taskRepository.deleteById(id);
    }
}
