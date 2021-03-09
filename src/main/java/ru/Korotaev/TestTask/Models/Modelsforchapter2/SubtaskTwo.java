package ru.Korotaev.TestTask.Models.Modelsforchapter2;

import javax.persistence.*;

@Entity
@Table(name = "subtasktwo")
public class SubtaskTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "time")
    private int time;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subtaskOne_id")
    private SubtaskOne subtaskOne;

    public SubtaskTwo(){}
    public SubtaskTwo(String name) {
        this.name = name;
    }

    public SubtaskTwo(String name , int time) {
        this.name = name;
        this.time = time;
    }

    public SubtaskTwo(int id , String name , int time , SubtaskOne subtaskOne) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.subtaskOne = subtaskOne;
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

    public SubtaskOne getSubtaskOne() {
        return subtaskOne;
    }

    public void setSubtaskOne(SubtaskOne subtaskOne) {
        this.subtaskOne = subtaskOne;
    }
}
