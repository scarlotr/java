package com.geekbrains.server.services;

import com.geekbrains.gwt.common.TaskDto;
import com.geekbrains.server.entities.Task;
import com.geekbrains.server.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public TaskService() {
    }

    public List<TaskDto> findAll(Specification<Task> spec){
        List<Task> tasks = (List<Task>) taskRepository.findAll(spec);
        List<TaskDto> taskDto = new ArrayList<>();
        for (Task t: tasks){
            taskDto.add(new TaskDto(t.getId(), t.getName(), t.getOwnerName(), t.getExecutorName(), t.getDescription(), t.getStatus().toString()));
        }
        return taskDto;
    }

    public TaskDto save(TaskDto taskDto){
        Task task = taskRepository.save(new Task(taskDto));
        return new TaskDto(task.getId()
                            ,task.getName()
                            ,task.getOwnerName()
                            ,task.getExecutorName()
                            ,task.getDescription()
                            ,task.getStatus().toString()
                            );
    }

    public void add(Task task){
        taskRepository.save(task);
    }

    public void del(Long id){
        taskRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return taskRepository.existsById(id);
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }
}
