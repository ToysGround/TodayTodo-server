package com.toysground.todaytodo.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    private String content;

    @Column(name = "todo_status")
    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    private int sortNum;

    //==연관관게 메서드==//
    public void setTodoList(TodoList todoList){
        this.todoList = todoList;
        todoList.getTodos().add(this);
    }

}
