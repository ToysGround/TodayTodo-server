package com.toysground.todaytodo.service;

import com.toysground.todaytodo.domain.TodoList;
import com.toysground.todaytodo.dto.TodoListRequestDto;
import com.toysground.todaytodo.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoListRepository todoListRepository;

    @Transactional
    public Long saveList(TodoList todoList){
        //TodoList todoList = new TodoList();
        todoListRepository.save(todoList);
        return todoList.getId();
    }

    public List<TodoList> findList(Long userId){
        return todoListRepository.findAll(userId);
    }
}
