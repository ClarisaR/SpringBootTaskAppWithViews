package com.app.taskapplication.repositories;

import com.app.taskapplication.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
