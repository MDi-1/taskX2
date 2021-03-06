package com.crud.taskX2.service;

import com.crud.taskX2.domain.Task;
import com.crud.taskX2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }

    public Optional<Task> getTask(final Long taskId) {
        return repository.findById(taskId);
    }

    public void deleteTask(final Long taskId) {
        repository.deleteById(taskId);
    }
}