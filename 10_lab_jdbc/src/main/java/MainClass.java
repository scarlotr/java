import java.sql.*;

public class MainClass {
    public static void main(String[] args) throws SQLException {
        Task task1 = new Task(1, "Сделать ДЗ", "Иванов", "Петров", "Вовремя сделать ДЗ");
        Task task2 = new Task(2, "Поспать", "Пупкин", "Пупкин", "Хорошенько поспать");
        Task task3 = new Task(3, "Задача 3", "Сидоров", "Сидоров", "Сделать задачу");
        task2.setStatus(Task.Statuses.IN_WORK);
        task3.setStatus(Task.Statuses.CLOSED);

        TaskService taskService = new TaskService("Список 1");

        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);

        taskService.delTask(3);
        taskService.delTask("Поспать");

        taskService.print();
/*
        System.out.println("Stream API:");
        System.out.println(taskService.getTasksByStatus(Task.Statuses.IN_WORK));
        System.out.println("id 1 - " + taskService.isTaskExist(1));
        System.out.println(taskService.getTasksSortedByStatus());
        System.out.println("Новых задач : " + taskService.getCntTasksWithStatus(Task.Statuses.NEW));
        System.out.println("В работе : " + taskService.getCntTasksWithStatus(Task.Statuses.IN_WORK));
        System.out.println("Закрытых : " + taskService.getCntTasksWithStatus(Task.Statuses.CLOSED));

        System.out.println("IO:");
        taskService.exportToFile("tasks.dat", taskService.getTasksByStatus(Task.Statuses.IN_WORK));
        System.out.println(taskService.importFromFile("tasks.dat"));
*/
    }
}