package br.com.api.controllers;

import br.com.api.entitys.StatusEmun;
import br.com.api.entitys.Task;
import br.com.api.entitys.User;
import br.com.api.repositorys.UserRepository;
import br.com.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Page<Task> getParam(@RequestHeader String authorization, Pageable pageable){
        return service.getAllUserId(authorization, pageable);
    }

    @PostMapping
    public Task post(@RequestHeader String authorization, @RequestBody @Valid Task task){
        return service.save(authorization, task);
    }

    @PatchMapping("{id}")
    public Task patch(@RequestHeader String authorization,
                      @RequestBody @Valid Task task,
                      @PathVariable("id") Long id){
        return service.savePath(authorization, task, id);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@RequestHeader String authorization, @PathVariable(value = "id") Long id){
        return service.delete(authorization, id);
    }
}
