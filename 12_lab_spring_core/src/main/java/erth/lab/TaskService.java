package erth.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) throws SQLException {
        taskRepository.addTask(task);
    }

    public void delTask(int id){
        taskRepository.delTask(id);
    }

    public void delTask(String name){
        taskRepository.delTask(name);
    }

    //Распечатка списка задач
    public void print(){
        for (Task o: taskRepository.getAllTasks()) {
            System.out.println(o);
        }
    }

    //Дисконнект репозитория
    public void disconnectRepository(){
        taskRepository.disconnectRepository();
    }
}
