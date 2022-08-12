package org.java.web.todo.service.impl;

import org.java.web.todo.data.ActivityRepository;
import org.java.web.todo.model.ActivityDto;
import org.java.web.todo.model.Status;
import org.java.web.todo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository repository;

    @Override
    public void save(ActivityDto activity) {
        repository.save(activity.toEntity()).block();
    }

    @Override
    public Flux<ActivityDto> findAll() {
        return repository.findAll().map(ActivityDto::fromEntity);
    }

    @Override
    public Flux<ActivityDto> findAllByStatus(String status) {
        Optional<Status> statusToFilter = Status.getLabel(status);
        return statusToFilter.map(s -> repository.findByStatus(s.name())
                        .map(ActivityDto::fromEntity))
                .orElse(Flux.empty());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id).block();
    }
}