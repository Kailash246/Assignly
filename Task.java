package com.studentworktracker.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task {
    private static long idCounter = 0;

    private long id;
    private String title;
    private String description;
    private LocalDate dueDate;

    public Task(String title, String description, LocalDate dueDate) {
        this.id = ++idCounter;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // Method to get the number of days remaining until the due date
    public long getDaysUntilDue() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dueDate);
    }
}
