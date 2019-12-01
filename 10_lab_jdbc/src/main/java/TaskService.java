import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Класс для работы с задачами
public class TaskService {
    private TaskInterface rep;

    private String name;

    public TaskService(String name){
        this.name = name;
        this.rep = new TaskDBRepository();
    }

    public void addTask(Task task) throws SQLException {
        rep.addTask(task);
    }

    public void delTask(int id){
        rep.delTask(id);
    }

    public void delTask(String name){
        rep.delTask(name);
    }

    //Распечатка списка задач
    public void print(){
        System.out.println("Список: " + name);
        for (Task o: rep.getAllTasks()) {
            System.out.println(o);

        }
    }

    //Получение списка задач по выбранному статусу
    public List<Task> getTasksByStatus(Task.Statuses status){
        return rep.getAllTasks().stream().filter(o -> o.getStatus().equals(status)).collect(Collectors.toList());
    }

    //Проверка наличия задачи с указанным ID
    public boolean isTaskExist(int id){
        return rep.getAllTasks().stream().anyMatch(o -> o.getId() == id);
    }

    //Получение списка задач в отсортированном по статусу
    public List<Task> getTasksSortedByStatus(){
        return rep.getAllTasks().stream().sorted((o1, o2) -> o1.getStatus().getStatusId() - o2.getStatus().getStatusId())
                .collect(Collectors.toList());
    }

    //Подсчет количества задач по определенному статусу
    public long getCntTasksWithStatus(Task.Statuses status){
        return rep.getAllTasks().stream().filter(o -> o.getStatus().equals(status)).count();
    }

    //Запись в файл
    public void exportToFile(String fileName, List<Task> tasks){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Чтение из файла
    public List<Task> importFromFile(String fileName){
        List<Task> tasks = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            tasks = (List<Task>)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }

}