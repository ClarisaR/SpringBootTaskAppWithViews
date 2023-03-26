package com.app.taskapplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="tasks")
public class Task {
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    private String description;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
