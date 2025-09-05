package com.example.Service.model;

import java.util.Objects;

public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto taskDto = (TaskDto) o;
        return completed == taskDto.completed && Objects.equals(id, taskDto.id) && Objects.equals(title, taskDto.title) && Objects.equals(description, taskDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, completed);
    }
}
