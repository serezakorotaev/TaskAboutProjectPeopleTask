package ru.Korotaev.TestTask.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL,orphanRemoval = false)
    List<User> userList = new ArrayList<>();

    public Project(){}
public Project(Project project){
        this(project.getId(),project.getName(),project.getUserList());
}
//    public Project(int id) {
//        this.id = id;
//    }
//
    public Project(String name) {
        this.name = name;
    }

    public Project(int id , String name , List<User> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user){
        user.setProject(this);
        userList.add(user);
    }
    public void removeUser(User user){
        userList.remove(user);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userList=" + userList +
                '}';
    }
}
