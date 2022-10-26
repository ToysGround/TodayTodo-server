package com.toysground.todaytodo.repository;

import com.toysground.todaytodo.domain.TodoList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class TodoListRepository {

    private final EntityManager em;

    public void save(TodoList todoList){
        em.persist(todoList);
    }

    public List<TodoList> findAll(Long id){
        return em.createQuery("select td from TodoList td where td.userId = :userId")
                .setParameter("userId", id)
                .getResultList();
    }

}
