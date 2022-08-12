package org.java.web.todo.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum Status {
    PENDING("Pending"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private String label;

    private Status(String label){
        this.label = label;
    }

    public static Optional<Status> getLabel(String toFind){
        return Stream.of(Status.values()).filter(value -> value.name().equalsIgnoreCase(toFind)).findFirst();
    }

}
