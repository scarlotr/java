package com.geekbrains.server.entities;

import com.geekbrains.gwt.common.TaskDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="task_id")
    private Long id;
    @Column(name = "task_name")
    private String name;
    @Column(name = "owner")
    private String ownerName;
    @Column(name = "executor")
    private String executorName;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private Statuses status = Statuses.NEW;

    public Task(String name, String ownerName, String executorName, String description) {
        this.name = name;
        this.ownerName = ownerName;
        this.executorName = executorName;
        this.description = description;
    }

    public Task(TaskDto taskDto){
        this.name = taskDto.getName();
        this.ownerName = taskDto.getOwner();
        this.executorName = taskDto.getExecutor();
        this.description = taskDto.getDescription();
    }

    public String getStatusName(){
        return status.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }
}
