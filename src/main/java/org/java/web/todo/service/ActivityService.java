package org.java.web.todo.service;

import org.java.web.todo.model.ActivityDto;
import reactor.core.publisher.Flux;

public interface ActivityService {
    void save(ActivityDto activity);
    Flux<ActivityDto> findAll();
    Flux<ActivityDto> findAllByStatus(String status);
    void delete(Long id);
}
