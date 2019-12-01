import exceptions.TaskAlreadyExist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Класс для хранения и работы с задачами
public class TaskRepository implements TaskInterface {
    private List<Task> taskArr = new ArrayList<>();

    //Проверка есть ли задача в массиве
    public boolean isTaskExist(Task task){
        return taskArr.contains(task);
    }

    //Добавление задачи в массив
    @Override
    public void addTask(Task task){
        if (isTaskExist(task)){
            throw new TaskAlreadyExist("Задача id=" + task.getId() + " уже добавлена в список '");
        }

        taskArr.add(task);
    }

    //Удаление задачи из массива по ID
    @Override
    public void delTask(int id){

        Iterator<Task> iter = taskArr.iterator();

        while (iter.hasNext()){
            if (iter.next().getId() == id){
                iter.remove();
            }
        }
    }

    //Удаление задачи из массива по названию
    @Override
    public void delTask(String name){

        Iterator<Task> iter = taskArr.iterator();

        while (iter.hasNext()){
            if (iter.next().getName().equals(name)){
                iter.remove();
            }
        }
    }

    //Возвращает весь список задач
    public List<Task> getAllTasks(){
        return taskArr;
    }

}