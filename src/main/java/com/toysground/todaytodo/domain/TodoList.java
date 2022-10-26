package com.toysground.todaytodo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class TodoList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_list_id")
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
    private Long userId;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "todoList")
    private List<Todo> todos = new ArrayList<>();

    @Column(name = "list_type")
    @Enumerated(EnumType.STRING)
    private TodoType type;
    private Boolean autoReset;


}
