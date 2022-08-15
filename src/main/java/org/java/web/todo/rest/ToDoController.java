package org.java.web.todo.rest;

import org.java.web.todo.model.ActivityDto;
import org.java.web.todo.model.Status;
import org.java.web.todo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/all")
    public Flux<ActivityDto> listAll(){
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return activityService.findAll(user);
    }

    @GetMapping("/{status}")
    public Flux<ActivityDto> listAllByStatus(@PathVariable("status") String status){
        return activityService.findAllByStatus(status);
    }

    @PostMapping
    public Flux<ActivityDto> save(@RequestBody ActivityDto dto){
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        activityService.save(dto,user);
        return activityService.findAll(user);
    }

    @PutMapping("/update")
    public Flux<ActivityDto> update(@RequestBody ActivityDto dto){
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        dto.setStatus(Status.COMPLETED.name());
        activityService.save(dto,user);
        return activityService.findAll(user);
    }

    @DeleteMapping("/{id}")
    public Flux<ActivityDto> delete(@PathVariable("id") String id){
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        activityService.delete(id);
        return activityService.findAll(user);
    }

}
