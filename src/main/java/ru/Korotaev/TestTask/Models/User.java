package ru.Korotaev.TestTask.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = false)
    List<Task> taskList = new ArrayList<>();

    public User(){}
//    public User(User user){
//        this(user.getId(), user.getName() , user.getTaskList());
//    }
//    public User(int id) {
//        this.id = id;
//    }
//
    public User(String name) {
        this.name = name;
    }
    public User(int id , String name) {
        this.id = id;
        this.name = name;

    }
    public User(int id , String name , List<Task> taskList) {
        this.id = id;
        this.name = name;
        this.taskList = taskList;
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

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public void addTask(Task task){
        task.setUser(this);
        taskList.add(task);
    }
    public void removeUser(Task task){
        taskList.remove(task);
    }
}
