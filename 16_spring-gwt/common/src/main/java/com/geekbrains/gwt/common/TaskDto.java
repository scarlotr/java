package com.geekbrains.gwt.common;

public class TaskDto {
    private Long id;
    private String name;
    private String owner;
    private String executor;
    private String description;
    private String status;

    public TaskDto() {
    }

    public TaskDto(Long id, String name, String owner, String executor, String description, String status) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.executor = executor;
        this.description = description;
        this.status = status;
    }

    public TaskDto(String name, String owner, String executor, String description) {
        this.name = name;
        this.owner = owner;
        this.executor = executor;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getExecutor() {
        return executor;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
