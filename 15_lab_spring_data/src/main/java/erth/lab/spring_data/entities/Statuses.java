package erth.lab.spring_data.entities;

public enum Statuses {
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

    public boolean checkId(int id){
        return this.statusId == id;
    }

    //Возвращает статус по идентификатору
    public static Statuses getStatusById(int statusId) {
        for (Statuses s: Statuses.values()) {
            if (s.statusId == statusId){
                return s;
            }
        }
        System.out.println(">>> Статус не найден!!!");
        return null;
    }

    //Возвращает статус по русскому названию
    public static Statuses getStatusByName(String stat) {
        for (Statuses s: Statuses.values()) {
            if (s.toString().equals(stat)){
                return s;
            }
        }
        return null;
    }
}