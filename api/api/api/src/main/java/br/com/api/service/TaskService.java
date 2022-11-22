package br.com.api.service;

import br.com.api.entitys.StatusEmun;
import br.com.api.entitys.Task;
import br.com.api.entitys.User;
import br.com.api.repositorys.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public List<Task> getAll() {
        return  taskRepository.findAll();
    }

    private Page<Task> tasks;
    private boolean isAdmin;

    @Transactional
    public Task save(String token, Task task){

        Long idUser = userService.getIdUserToken(token);
        task.setUser_id(idUser);
        task.setDt_insert(this.createDate());
        task.setStatus(StatusEmun.PENDING);
        return taskRepository.save(task);
    }

    public Page<Task> getAllUserId(String token, Pageable pageable) {

        Long idUser = userService.getIdUserToken(token);
        Optional<User> user = userService.getUserIdToken(token);

        user.get().getProfiles().forEach(profile->{
             this.tasks = profile.getName().equals("ADMIN") ?
                            taskRepository.findAll(pageable) :
                            taskRepository.findAll(pageable, idUser);
        });
        return this.tasks;
    }

    public ResponseEntity<Object> delete(String token, Long id) {

        Long idUser = userService.getIdUserToken(token);
        Task taskOld = this.getTaskId(id);

        if((taskOld.getUser_id() != null && taskOld.getUser_id().equals(idUser)) || this.userIsAdmin(token, id)){
            Optional<Task> task = taskRepository.findById(id);
            if(task.isPresent()){
                taskRepository.delete(task.get());
                log.info("Deleted task ${id}", id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @Transactional
    public Task savePath(String token, Task task, Long id) {

        Long idUser = userService.getIdUserToken(token);
        Task taskOld = this.getTaskId(id);

        if((taskOld.getUser_id() != null && taskOld.getUser_id().equals(idUser)) || this.userIsAdmin(token, id)){

            task.setId(id);
            task.setUser_id(taskOld.getUser_id());
            task.setDt_insert(taskOld.getDt_insert());
            task.setDt_update(this.createDate());
            return taskRepository.save(task);
        }
        return null;
    }

    public Task getTaskId(Long id){
        return taskRepository.getOne(id);
    }
    public String createDate(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public boolean userIsAdmin(String token, Long id){

        Optional<User> user = userService.getUserIdToken(token);
        user.get().getProfiles().stream().forEach(profile -> {
            isAdmin = profile.getName().equals("ADMIN");
        });
        return isAdmin;
    }

}
