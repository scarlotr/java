package erth.lab.spring_data.services;

import erth.lab.spring_data.entities.Statuses;
import erth.lab.spring_data.entities.Task;
import erth.lab.spring_data.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskService() {
    }

    public Page<Task> getTasksByFilter(Specification<Task> spec, Pageable page){
        return taskRepository.findAll(spec, page);
    }

    public void add(Task task){
        taskRepository.save(task);
    }

    public void del(Long id){
        taskRepository.deleteById(id);
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }
}
