package com.example.testTask;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Service
public class ThirdTaskService {
    private LinkedList<Ticket> tickets = new LinkedList<>(List.of(
            new Ticket(1245, "2017-09-01", "15:22", 0),
            new Ticket(1246, "2017-09-01", "15:42", 1),
            new Ticket(1250, "2017-09-01", "16:32", 2)));

    private long lastTicketId = tickets.getLast().getTicketId();
    public Ticket generateTicket() {
        lastTicketId++;
        Ticket ticket = Ticket.builder()
                .ticketId(lastTicketId)
                .date(LocalDate.now().toString())
                .time(LocalTime.now().withSecond(0).withNano(0).toString())
                .queue(tickets.size())
                .build();
        tickets.add(ticket);
        return ticket;
    }
    public void deleteTicket() {
        if (!tickets.isEmpty()) {
            tickets.removeFirst();
            if (!tickets.isEmpty()) {
                lastTicketId = tickets.getLast().getTicketId();
                tickets.forEach(t ->
                        t.setQueue(t.getQueue() - 1)
                );
            }
        }
    }
    public Ticket getActiveTicket(){
        if (!tickets.isEmpty()) {
            return tickets.getFirst();
        }
        return null;
    }
    public List<Ticket> getAll(){
        return tickets;
    }
}
