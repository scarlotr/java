import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

//Класс для хранения и работы с задачами в памяти
public class TaskDBRepository implements TaskInterface {
    Session session;
    SessionFactory factory;

    public TaskDBRepository() {
        factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .buildSessionFactory();
        session = null;
    }

    @Override
    //Дисконнект с БД
    public void disconnectRepository(){
        System.out.println("Дисконнект с БД");
        factory.close();
        if (session != null){
            session.close();
        }
    }

    @Override
    //Добавление задачи а таблицу
    public void addTask(Task task) {
        System.out.println("Добавление задачи");
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
    }

    @Override
    public void delTask(int id) {
        System.out.println("Удаление задачи по ID");
        session = factory.getCurrentSession();
        session.beginTransaction();
        Task delTask = session.get(Task.class, id);
        if (delTask != null){
            session.delete(delTask);
        }
        session.getTransaction().commit();
    }

    @Override
    public void delTask(String name) {
        System.out.println("Удаление задачи по NAME");
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Task> delTasks = session.createQuery("SELECT t FROM Task t WHERE t.name LIKE :name", Task.class).setParameter("name", name).getResultList();
        Iterator<Task> iter = delTasks.iterator();
        while (iter.hasNext()){
            session.delete(iter.next());
        }
        session.getTransaction().commit();
    }

    @Override
    public List<Task> getAllTasks() {
        System.out.println("Получение списка задач");
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Task> allTasks = session.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        session.getTransaction().commit();

        return allTasks;
    }
}