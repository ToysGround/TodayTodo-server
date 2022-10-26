package com.toysground.todaytodo.controller;

import com.toysground.todaytodo.domain.TodoList;
import com.toysground.todaytodo.dto.ResultEntity;
import com.toysground.todaytodo.dto.TodoListRequestDto;
import com.toysground.todaytodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/todoList")
@RestController
@RequiredArgsConstructor
public class TodoListContoroller {
    private final TodoService todoService;

    @GetMapping("/save")
    public ResultEntity<TodoList> saveTodoList(@RequestBody TodoList todoList){
        if(todoService.saveList(todoList) > 0){
            return new ResultEntity(true);
        }else{
            return new ResultEntity(false);
        }
    }

    @GetMapping("/find")
    public ResultEntity<TodoList> saveTodoList(@RequestBody Long id){
        return new ResultEntity(todoService.findList(id));
    }

}
