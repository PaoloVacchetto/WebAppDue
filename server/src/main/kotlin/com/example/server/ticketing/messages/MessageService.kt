package com.example.server.ticketing.messages

import com.example.server.NotFoundException
import kotlin.jvm.Throws

interface MessageService {

    fun getAllForTicket(ticketId : Long) : List<Message>

    @Throws(NotFoundException::class)
    fun getById(ticketId: Long, messageId: Long) : Message

    fun addMessage(messageDTO: MessageDTO, ticketId: Long) : Message
}