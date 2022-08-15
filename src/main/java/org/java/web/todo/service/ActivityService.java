package org.java.web.todo.service;

import org.java.web.todo.model.ActivityDto;
import reactor.core.publisher.Flux;

public interface ActivityService {
    void save(ActivityDto activity,String userId);
    Flux<ActivityDto> findAll(String userId);
    Flux<ActivityDto> findAllByStatus(String status);
    void delete(String id);
}
