import java.io.Serializable;

//Класс задачи
public class Task implements Serializable {
    enum Statuses {
        NEW(1, "Новая задача"), IN_WORK(2,"В работе"), CLOSED(3,"Закрыта");

        private int statusId;
        private String rusName;

        Statuses(int statusId, String rusName) {
            this.statusId = statusId;
            this.rusName = rusName;
        }

        @Override
        public String toString() {
            return rusName;
        }

        public int getStatusId() {
            return statusId;
        }
    }

    private int id;
    private String name;
    private String ownerName;
    private String executorName;
    private String description;
    private Statuses status;

    public Task(int id, String name, String ownerName, String executorName, String description) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.executorName = executorName;
        this.description = description;
        this.status = Statuses.NEW;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", executorName='" + executorName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getExecutorName() {
        return executorName;
    }

    public String getDescription() {
        return description;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

}