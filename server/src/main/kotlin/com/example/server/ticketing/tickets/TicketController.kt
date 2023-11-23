package com.example.server.ticketing.tickets

import com.example.server.NotValidException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TicketController (private val ticketService: TicketService) {
    @GetMapping("/tickets")
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<TicketDTO> {
        return ticketService.getAll().map { it.toDTO() }
    }

    @GetMapping("/tickets/{ticketId}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable ticketId : Long): TicketDTO {
        return ticketService.getById(ticketId).toDTO()
    }


    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    fun createTicket(@RequestBody ticketDTO: TicketDTO?) : TicketDTO {
        if (ticketDTO == null) throw NotValidException("Ticket was malformed")
        return ticketService.createTicket(ticketDTO).toDTO()
    }


}