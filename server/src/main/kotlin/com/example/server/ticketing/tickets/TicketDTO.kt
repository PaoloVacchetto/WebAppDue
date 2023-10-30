package com.example.server.ticketing.tickets

import com.example.server.products.ProductDTO
import com.example.server.products.toDTO
import com.example.server.profiles.ProfileDTO
import com.example.server.profiles.toDTO
import com.example.server.ticketing.messages.MessageDTO

data class TicketDTO (
    val id: Long?,
    val product: ProductDTO,
    val customer: ProfileDTO,
    val technician: ProfileDTO?,
    val statuses:MutableList<States>,
    val description: String,
    val priority: Int,
    val message: MutableSet<Long>?
)

fun Ticket.toDTO() : TicketDTO {
    val m = mutableSetOf<Long>()
    messages?.forEach{m.add(it.id!!)}
    return TicketDTO(id, product.toDTO(), customer.toDTO(), technician?.toDTO(), statuses, description, priority, m)
}