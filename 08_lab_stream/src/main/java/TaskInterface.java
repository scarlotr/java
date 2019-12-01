import java.util.List;

//Базовый интерфейс для задач
public interface TaskInterface {
    void addTask(Task task);
    void delTask(int id);
    void delTask(String name);
    List<Task> getAllTasks();
}