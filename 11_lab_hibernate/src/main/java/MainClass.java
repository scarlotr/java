import java.sql.*;

public class MainClass {
    public static void main(String[] args) throws SQLException {
        TaskService taskService = new TaskService("Список 1");

        Task task1 = new Task(1, "Сделать ДЗ", "Иванов", "Петров", "Вовремя сделать ДЗ");
        Task task2 = new Task(2, "Поспать", "Пупкин", "Пупкин", "Хорошенько поспать");
        Task task3 = new Task(3, "Задача 3", "Сидоров", "Сидоров", "Сделать задачу");
        task2.setStatus(Task.Statuses.IN_WORK);
        task3.setStatus(Task.Statuses.CLOSED);

        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);

        taskService.delTask(2);
        taskService.delTask("Поспать");

        taskService.print();

        taskService.disconnectRepository();
    }
}