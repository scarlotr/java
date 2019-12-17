package com.geekbrains.gwt.common;

public class StatusDto {
    private Integer statusId;
    private String rusName;

    public StatusDto() {
    }

    public StatusDto(Integer statusId, String rusName) {
        this.statusId = statusId;
        this.rusName = rusName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }
}