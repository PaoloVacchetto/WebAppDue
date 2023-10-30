package com.example.server.ticketing.messages

import com.example.server.DuplicateException
import com.example.server.NotFoundException
import com.example.server.ticketing.tickets.TicketRepository
import com.example.server.ticketing.tickets.TicketService
import org.springframework.data.repository.findByIdOrNull

class MessageServiceImpl  (
    private var messageRepository : MessageRepository,
    private var ticketService: TicketService
) : MessageService  {
    override fun getAllForTicket(ticketId: Long): List<Message> {
        val ticket = ticketService.getById(ticketId)
        return messageRepository.findMessagesByTicket(ticket)
    }

    override fun getById(ticketId: Long, messageId: Long): Message {
        val ticket = ticketService.getById(ticketId)
        return messageRepository.findMessagesByIdAndTicket(messageId, ticket)
            ?: throw NotFoundException("Ticket not found")
    }

    override fun addMessage(messageDTO: MessageDTO, ticketId: Long): Message {
        if (messageDTO.id != null && messageRepository.findByIdOrNull(messageDTO.id) != null) throw DuplicateException("Message is already exists")
        val ticket = ticketService.getById(ticketId)
        return messageRepository.save(
            Message(
                ticket = ticket,
                fromCustomer = messageDTO.fromCustomer,
                timestamp = messageDTO.timestamp,
                attachment = messageDTO.attachment,
                content = messageDTO.content
            )
        )
    }
}