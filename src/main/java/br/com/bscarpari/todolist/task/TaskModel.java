package br.com.bscarpari.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.bscarpari.todolist.task.enums.Priority;
import br.com.bscarpari.todolist.task.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Priority priority;

    private LocalDateTime startAt;
    private LocalDateTime finishAt;

    @CreationTimestamp
    private String createdAt;

    @CreationTimestamp
    private String updatedAt;
}
