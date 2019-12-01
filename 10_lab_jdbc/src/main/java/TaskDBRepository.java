import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Класс для хранения и работы с задачами в памяти
public class TaskDBRepository implements TaskInterface {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement ps;

    @Override
    //Добавление задачи а таблицу
    public void addTask(Task task) throws SQLException {
        try {
            connect();
            ps = connection.prepareStatement("INSERT INTO tasks(task_id, task_name, owner, executor, description, status) VALUES (?, ?, ?, ?, ?, ?);");
            ps.setInt(1, task.getId());
            ps.setString(2, task.getName());
            ps.setString(3, task.getOwnerName());
            ps.setString(4, task.getExecutorName());
            ps.setString(5, task.getDescription());
            ps.setString(6, task.getStatus().toString());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public void delTask(int id) {
        try {
            connect();
            ps = connection.prepareStatement("DELETE FROM tasks WHERE task_id = ?;");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public void delTask(String name) {
        try {
            connect();
            ps = connection.prepareStatement("DELETE FROM tasks WHERE task_name like ?;");
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> allTasks = new ArrayList<>();
        try {
            connect();
            ps = connection.prepareStatement("SELECT task_id, task_name, owner, executor, description, status FROM tasks;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task resultTask = new Task(rs.getInt("task_id")
                                            , rs.getString("task_name")
                                            , rs.getString("owner")
                                            , rs.getString("executor")
                                            , rs.getString("description")
                                            );
                //Пример использования reflection оставил для себя
                //Method m = Task.Statuses.class.getDeclaredMethod("getStatusByName", String.class);
                //resultTask.setStatus((Task.Statuses) m.invoke(Task.Statuses.class, rs.getString("status")));

                resultTask.setStatus(Task.Statuses.getStatusByName(rs.getString("status")));
                allTasks.add(resultTask);
            }
            return allTasks;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return null;
    }

    //Коннект к БД
    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:tasks.db");
        stmt = connection.createStatement();
    }

    //Дисконект с БД
    private void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
