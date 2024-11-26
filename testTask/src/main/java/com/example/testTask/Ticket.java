package com.example.testTask;
import lombok.*;

@Getter
@Setter
@Builder
public class Ticket {
    private long ticketId;
    private String date;
    private String time;
    private int queue;
}
