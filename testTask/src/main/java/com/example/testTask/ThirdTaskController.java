package com.example.testTask;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class ThirdTaskController {
    private final ThirdTaskService service;
    @GetMapping("")
    public Ticket getTicket() {
        return service.getActiveTicket();
    }
    @GetMapping("/list")
    public List<Ticket> getAll() {
        return service.getAll();
    }
    @PostMapping("")
    public Ticket generateTicket() {
        return service.generateTicket();
    }
    @DeleteMapping("")
    public void deleteTicket() {
        service.deleteTicket();
    }
}
