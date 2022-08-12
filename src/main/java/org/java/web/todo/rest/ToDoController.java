package org.java.web.todo.rest;

import org.java.web.todo.model.ActivityDto;
import org.java.web.todo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/all")
    public Flux<ActivityDto> listAll(){
        return activityService.findAll();
    }

    @GetMapping("/{status}/all")
    public Flux<ActivityDto> listAllByStatus(@PathVariable("status") String status){
        return activityService.findAllByStatus(status);
    }

    @PostMapping
    public Flux<ActivityDto> save(@RequestBody ActivityDto dto){
        activityService.save(dto);
        return activityService.findAll();
    }

    @DeleteMapping("/{id}")
    public Flux<ActivityDto> delete(@PathVariable("id") Long id){
        activityService.delete(id);
        return activityService.findAll();
    }

}
