package com.toysground.todaytodo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequestMapping("/api")
@RestController
public class itemcontroller {

    public ResponseEntity<?> test(){
        HashMap<String,String> map = new HashMap<>();
        map.put("data","김상배");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
