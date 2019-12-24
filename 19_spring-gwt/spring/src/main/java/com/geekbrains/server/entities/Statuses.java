package com.geekbrains.server.entities;

public enum Statuses {
    NEW(1, "Новая задача"), IN_WORK(2,"В работе"), CLOSED(3,"Закрыта");

    private Integer statusId;
    private String rusName;

    Statuses(Integer statusId, String rusName) {
        this.statusId = statusId;
        this.rusName = rusName;
    }

    @Override
    public String toString() {
        return rusName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public boolean checkId(Integer id){
        return this.statusId.equals(id);
    }

    //Возвращает статус по идентификатору
    public static Statuses getStatusById(Integer statusId) {
        for (Statuses s: Statuses.values()) {
            if (s.statusId.equals(statusId)){
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