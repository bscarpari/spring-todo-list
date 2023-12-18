package br.com.bscarpari.todolist.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @GetMapping("/")
    public ResponseEntity<List<TaskModel>> findAll() {
        List<TaskModel> tasksList = taskRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(tasksList);
    }

    @PostMapping("/")
    public ResponseEntity<TaskModel> createATask(@RequestParam TaskModel taskModel) {
        TaskModel taskCreated = taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

}
