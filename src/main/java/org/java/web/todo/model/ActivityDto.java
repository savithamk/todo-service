package org.java.web.todo.model;

import org.java.web.todo.entity.Activity;

import java.util.UUID;

public class ActivityDto {

    private String id;
    private String name;
    private String status;

    public static ActivityDto fromEntity(Activity activity){
        ActivityDto dto = new ActivityDto();
        dto.setId(activity.getId());
        dto.setName(activity.getName());
        dto.setStatus(activity.getStatus());
        return dto;
    }

    public Activity toEntity(){
        Activity activity = new Activity();
        activity.setId(id != null ? id : UUID.randomUUID().toString());
        activity.setName(name);
        activity.setStatus(status !=null ? status : Status.PENDING.name());
        return activity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}