package com.example.testTask;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/firstTask")
@RequiredArgsConstructor
public class FirstTaskController {
    public final FirstTaskService service;
    @PostMapping("")
    public String firstTask(@RequestBody InputString inputString){

        return service.transformText(Optional.ofNullable(inputString.getDesc()).orElse(""));
    }
}
