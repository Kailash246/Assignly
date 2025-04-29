package com.studentworktracker.storage;

import com.studentworktracker.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskStore {
    private static final TaskStore instance = new TaskStore();
    private final List<Task> tasks = new ArrayList<>();

    private TaskStore() {}

    public static TaskStore getInstance() {
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public void deleteTaskById(long id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}
