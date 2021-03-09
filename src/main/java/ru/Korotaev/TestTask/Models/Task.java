package ru.Korotaev.TestTask.Models;


import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private User user;
    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL,orphanRemoval = false)
    List<SubtaskOne> subtaskOneList = new ArrayList<>();
    public Task(){}
//    public Task(Task task){
//        this(task.getId(),task.getName());
//    }
//    public Task(int id) {
//        this.id = id;
//    }
//
    public Task(String name) {
        this.name = name;
    }

    public Task(int id , String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

        public void addSubtaskOne(SubtaskOne subtaskOne){
        subtaskOne.setTask(this);
        subtaskOneList.add(subtaskOne);
        }
        public void removeSubtaskOne(SubtaskOne subtaskOne){
        subtaskOneList.remove(subtaskOne);
        }
}
