package ru.Korotaev.TestTask.Models.Modelsforchapter2;

import ru.Korotaev.TestTask.Models.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SUBTASKONE")
public class SubtaskOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "time")
    private int time;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private Task task;
    @OneToMany(mappedBy = "subtaskOne",cascade = CascadeType.ALL,orphanRemoval = false)
    List<SubtaskTwo> subtaskTwoList = new ArrayList<>();

    public SubtaskOne(){}
    public SubtaskOne(String name) {
        this.name = name;
    }

    public SubtaskOne( String name, int time) {
        this.name = name;
        this.time = time;
    }

    public SubtaskOne(int id , String name , int time , Task task , List<SubtaskTwo> subtaskTwoList) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.task = task;
        this.subtaskTwoList = subtaskTwoList;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<SubtaskTwo> getSubtaskTwoList() {
        return subtaskTwoList;
    }

    public void setSubtaskTwoList(List<SubtaskTwo> subtaskTwoList) {
        this.subtaskTwoList = subtaskTwoList;
    }
    public void addSubtaskTwo(SubtaskTwo subtaskTwo){
        subtaskTwo.setSubtaskOne(this);
        subtaskTwoList.add(subtaskTwo);
    }
    public void removeSubtaskTwo(SubtaskTwo subtaskTwo){
        subtaskTwoList.remove(subtaskTwo);
    }
}
