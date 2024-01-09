package br.com.bscarpari.todolist.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @GetMapping("/")
    public ResponseEntity<List<TaskModel>> findAll() {
        List<TaskModel> tasksList = this.taskRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(tasksList);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Optional<TaskModel>> findTaskById(@RequestParam UUID taskId) {
        var task = this.taskRepository.findById((UUID) taskId);

        if (task.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @PostMapping("/")
    public ResponseEntity<TaskModel> createATask(@RequestParam TaskModel taskModel) {
        TaskModel taskCreated = taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskModel> updateATask(@RequestParam UUID taskId, @RequestParam TaskModel taskModel) {
        Optional<TaskModel> task = taskRepository.findById(taskId);

        if (task.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        taskModel.setId(taskId);
        TaskModel taskUpdated = taskRepository.save(taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(taskUpdated);
    }
    
    @DeleteMapping("/{taskId}")
    public ResponseEntity<TaskModel> deleteATask(@RequestParam UUID taskId) {
        Optional<TaskModel> task = taskRepository.findById(taskId);

        if (task.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        taskRepository.deleteById(taskId);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
